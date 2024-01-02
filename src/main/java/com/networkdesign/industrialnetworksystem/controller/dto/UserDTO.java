package com.networkdesign.industrialnetworksystem.controller.dto;

/**
 * 接收前端登录请求的参数
 */
public class UserDTO {
    private String username;
    private String password;
    private String token;

    public UserDTO() {
    }

    public UserDTO(String username, String password, String token) {
        this.username = username;
        this.password = password;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
