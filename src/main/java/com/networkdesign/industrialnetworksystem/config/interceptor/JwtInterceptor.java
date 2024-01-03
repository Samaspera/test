package com.networkdesign.industrialnetworksystem.config.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.networkdesign.industrialnetworksystem.Constants;
import com.networkdesign.industrialnetworksystem.exception.ServiceException;
import com.networkdesign.industrialnetworksystem.pojo.User;
import com.networkdesign.industrialnetworksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService service;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        if(token == null || token.equals("")) {
            throw new ServiceException(Constants.CODE_401, "无token，请重新登录");
        }
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new ServiceException(Constants.CODE_401, "token验证失败，请重新登录");
        }
        User user = service.getById(userId);
        if (user == null) {
            throw new ServiceException(Constants.CODE_401, "用户不存在，请重新登录");
        }
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token); // 验证token
        } catch (JWTVerificationException e) {
            throw new ServiceException(Constants.CODE_401, "token验证失败，请重新登录");
        }
        return true;
    }
}
