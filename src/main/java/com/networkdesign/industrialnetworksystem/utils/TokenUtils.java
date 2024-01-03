package com.networkdesign.industrialnetworksystem.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.networkdesign.industrialnetworksystem.pojo.User;
import com.networkdesign.industrialnetworksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
@Component
public class TokenUtils {
    private static final long EXPIRE_TIME = 5 * 60 * 60 * 1000;  //过期时间为5个小时
    private static UserService staticService;
    @Resource
    private UserService service;
    @PostConstruct
    public void setService() {
        staticService = service;
    }
    public static String genToken(String userId, String sign) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        return JWT.create().withAudience(userId) // 将 user id 保存到 token 里面,作为载荷
                .withExpiresAt(date) // 2小时后token过期
                .sign(Algorithm.HMAC256(sign)); // 以 password 作为 token 的密钥
    }

    /**
     * 获取当前登录的用户信息
     * @return user
     */
    public static User getCurrentUser() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("token");
            if(token != null && !token.equals("")) {
                String userId = JWT.decode(token).getAudience().get(0);
                return staticService.getById(Integer.valueOf(userId));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
