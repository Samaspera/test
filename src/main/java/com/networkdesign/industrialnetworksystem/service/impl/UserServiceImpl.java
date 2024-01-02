package com.networkdesign.industrialnetworksystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.networkdesign.industrialnetworksystem.controller.dto.UserDTO;
import com.networkdesign.industrialnetworksystem.mapper.UserMapper;
import com.networkdesign.industrialnetworksystem.pojo.User;
import com.networkdesign.industrialnetworksystem.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public boolean login(UserDTO userDTO) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", userDTO.getUsername());
        wrapper.eq("password", userDTO.getPassword());
        try {
            User one = getOne(wrapper);
            return one != null;
        } catch (Exception e) {
            return false;
        }
    }
}
