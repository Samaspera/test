package com.networkdesign.industrialnetworksystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.networkdesign.industrialnetworksystem.pojo.User;
import com.networkdesign.industrialnetworksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class HelloController {

    @Autowired
    public UserService service;

    @RequestMapping("/hello")  //给前端返回数据
    public String hello(String nickname){
        return nickname + "hello world";
    }

//    @RequestMapping("/user")
//    public void user() {
//        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.eq("admin", )
//        List<User> list = service.list();
//        for(User l : list) {
//            System.out.println(l);
//        }
//    }

    @RequestMapping("/login")
    public User login(@RequestBody User user){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        wrapper.eq("password", user.getPassword());
        List<User> list = service.list(wrapper);
        return list.isEmpty() ? null : list.get(0);
    }
}
