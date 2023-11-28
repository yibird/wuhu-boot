package com.fly.filter;

import com.fly.config.PermitResource;
import com.fly.store.TokenStore;
import com.fly.user.UserDetail;
import com.fly.utils.JwtUtils;
import com.fly.utils.TokenUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

/**
 * @Description 身份验证令牌过滤器
 * @Author zchengfeng
 * @Date 2023/6/9 14:31
 */
@Component
@AllArgsConstructor
public class AuthenticationTokenFilter extends OncePerRequestFilter {

    private final PermitResource permitResource;
    private final TokenStore tokenStore;
    private final JwtUtils jwtUtils;

    /**
     * 判断当前请求是否忽略token认证
     *
     * @param req  HttpServletRequest
     * @param list 忽略token认证请求url列表
     * @return 是否忽略token认证
     */
    public boolean isIgnoreTokenAuth(HttpServletRequest req, List<String> list) {
        return list.stream().anyMatch((url) -> new AntPathRequestMatcher(url).matches(req));
    }

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest req, @NotNull HttpServletResponse res, @NotNull FilterChain chain) throws ServletException, IOException {
        List<String> permitList = permitResource.getPermitList();
        boolean isIgnoreRequest = isIgnoreTokenAuth(req, permitList);
        String accessToken = TokenUtils.getAccessToken(req);
        // 如果当前请求不在忽略列表中并且token为空
        if (!isIgnoreRequest && Strings.isBlank(accessToken)) {
            chain.doFilter(req, res);
            return;
        }
        String refreshToken = TokenUtils.getAccessToken(req);
        /**
         * 如果token不为空则检查是否过期,如果accessToken过期,
         * 但refreshToken未过期则将refreshToken替换
         * accessToken
         */
//        if(!jwtUtils.validateToken(accessToken)){
//
//        }

        // 根据accessToken获取用户信息
        UserDetail user = tokenStore.getUser(accessToken);
        if (user == null) {
            chain.doFilter(req, res);
            return;
        }

        // 保存登录用户信息
        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);

        chain.doFilter(req, res);
    }
}
