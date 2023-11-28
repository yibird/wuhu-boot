package com.fly.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fly.common.exception.ApiStatus;
import com.fly.common.model.response.ApiResult;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

public class SecurityAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final static String CONTENT_TYPE = "application/json; charset=utf-8";

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException ex) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(ApiResult.error(ApiStatus.UNAUTHORIZED));

        res.setContentType(CONTENT_TYPE);
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setHeader("Access-Control-Allow-Origin", req.getHeader(HttpHeaders.ORIGIN));
        res.getWriter().print(content);
    }
}
