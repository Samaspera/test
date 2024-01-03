package com.networkdesign.industrialnetworksystem.config;

import com.networkdesign.industrialnetworksystem.config.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                .addPathPatterns("/**")  //拦截所有请求
                .excludePathPatterns("/user/login", "/user/register");
    }

    @Bean
    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }
}
