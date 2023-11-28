package com.fly.utils;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Pair;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fly.common.utils.RedisUtils;
import com.fly.constant.RedisKeyConstant;
import com.fly.user.UserDetail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class JwtUtils {
    /**
     * jwt盐
     */
    @Value("${jwt.secret}")
    private String secret;
    /**
     * 访问token过期时间
     */
    @Value("${jwt.expires}")
    private long expires;

    /**
     * 刷新token过期时间
     */
    @Value("${jwt.refresh_token_expires}")
    private long refreshTokenExpires;

    private final static ConcurrentMap<String, String> tokenMaps = new ConcurrentHashMap<>();

    /**
     * 生成token
     *
     * @param userDetail 用户信息
     * @param expires    过期时间
     * @return token
     */
    public String createToken(UserDetail userDetail, long expires) {
        DateTime now = DateUtil.date();
        return JWT.create()
                // 设置jwt主体
                .withSubject(userDetail.getUsername())
                .withClaim("account", userDetail.getUsername())
                // 设置jwt发布时间
                .withIssuedAt(now)
                // 设置jwt过期时间
                .withExpiresAt(DateUtil.offsetSecond(now, Math.toIntExact(expires * 1000)))
                // 设置签名的加密算法
                .sign(Algorithm.HMAC256(secret));
    }

    /**
     * 生成accessToken和refreshToken
     *
     * @param userDetail 用户信息
     * @return 返回包含accessToken和refreshToken的容器
     */
    public Pair<String, String> generateToken(UserDetail userDetail) {
        String accessToken = createToken(userDetail, expires);
        String refreshToken = createToken(userDetail, refreshTokenExpires);
        tokenMaps.put(accessToken, refreshToken);
        return Pair.of(accessToken, refreshToken);
    }

    public String getUsernameFromToken(String token) {
        try {
            return JWT.require(Algorithm.HMAC512(secret))
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 验证token是否有效
     *
     * @param token 令牌
     * @return 返回一个布尔值表示是否有效
     */
    public boolean validateToken(String token) {
        try {
            return Objects.nonNull(getUsernameFromToken(token));
        } catch (Exception e) {
            return false;
        }
    }

    public void invalidateToken(String username) {
        RedisUtils.del(RedisKeyConstant.ACCESS_TOKEN + username);
    }
}
