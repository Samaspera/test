package com.networkdesign.industrialnetworksystem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.networkdesign.industrialnetworksystem.controller.dto.UserDTO;
import com.networkdesign.industrialnetworksystem.pojo.User;

public interface UserService extends IService<User> {
    boolean login(UserDTO userDTO);
}