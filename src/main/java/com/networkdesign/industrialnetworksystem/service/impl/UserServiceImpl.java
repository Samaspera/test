package com.networkdesign.industrialnetworksystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.networkdesign.industrialnetworksystem.Constants;
import com.networkdesign.industrialnetworksystem.controller.dto.UserDTO;
import com.networkdesign.industrialnetworksystem.controller.dto.UserRDTO;
import com.networkdesign.industrialnetworksystem.exception.ServiceException;
import com.networkdesign.industrialnetworksystem.mapper.LogMapper;
import com.networkdesign.industrialnetworksystem.mapper.UserMapper;
import com.networkdesign.industrialnetworksystem.pojo.Log;
import com.networkdesign.industrialnetworksystem.pojo.User;
import com.networkdesign.industrialnetworksystem.service.UserService;
import com.networkdesign.industrialnetworksystem.utils.TokenUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private LogMapper logMapper;
    @Override
    public UserDTO login(UserDTO userDTO) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", userDTO.getUsername());
        wrapper.eq("password", userDTO.getPassword());
        User one;
        try {
            one = getOne(wrapper);
            if(one != null) {
                BeanUtils.copyProperties(one, userDTO);
                String token = TokenUtils.genToken(one.getId().toString(), one.getPassword());
                userDTO.setToken(token);
                logMapper.insert(new Log(0, LocalDateTime.now(),"user"+ userDTO.getUsername()+"Login",false));
                return userDTO;
            } else {
                throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
            }
        } catch (Exception e) {
            //e.printStackTrace();
            throw new ServiceException(Constants.CODE_500, "系统错误");
        }
    }

    @Override
    public User register(UserRDTO userRDTO) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", userRDTO.getUsername());
        User one;
        try {
            one = getOne(wrapper);
        } catch (Exception e) {
            //e.printStackTrace();
            throw new ServiceException(Constants.CODE_500, "系统错误");
        }
        if(one == null) {
            one = new User();
            BeanUtils.copyProperties(userRDTO, one);
            logMapper.insert(new Log(0, LocalDateTime.now(),"user"+ userRDTO.getUsername()+"register",false));
            save(one);
        } else {
            throw new ServiceException(Constants.CODE_600, "用户已存在");
        }
        return one;
    }
}
