package com.networkdesign.industrialnetworksystem.controller;

import com.networkdesign.industrialnetworksystem.Constants;
import com.networkdesign.industrialnetworksystem.common.Result;
import com.networkdesign.industrialnetworksystem.controller.dto.UserDTO;
import com.networkdesign.industrialnetworksystem.controller.dto.UserRDTO;
import com.networkdesign.industrialnetworksystem.pojo.User;
import com.networkdesign.industrialnetworksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService service;

    @PostMapping("/login")
    public Result login(@RequestBody UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        if(username.equals("")||password.equals("")) {
            return Result.error(Constants.CODE_400, "参数错误");
        }
        UserDTO dto = service.login(userDTO);
        return Result.success(dto);
    }
    @PostMapping("/register")
    public Result register(@RequestBody UserRDTO userRDTO) {
        String username = userRDTO.getUsername();
        String password = userRDTO.getPassword();
        String email = userRDTO.getEmail();
        if(username.equals("")||password.equals("")||email.equals("")){
            return Result.error(Constants.CODE_400, "参数错误");
        }
        User dto = service.register(userRDTO);
        return Result.success(dto);
    }
}
