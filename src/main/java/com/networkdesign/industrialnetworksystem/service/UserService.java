package com.networkdesign.industrialnetworksystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.networkdesign.industrialnetworksystem.controller.dto.UserDTO;
import com.networkdesign.industrialnetworksystem.controller.dto.UserRDTO;
import com.networkdesign.industrialnetworksystem.pojo.User;

public interface UserService extends IService<User> {
    UserDTO login(UserDTO userDTO);

    User register(UserRDTO userRDTO);
}