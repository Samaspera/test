package com.networkdesign.industrialnetworksystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.networkdesign.industrialnetworksystem.pojo.Log;
import com.networkdesign.industrialnetworksystem.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/log")
public class LogController {
    @Autowired
    public LogService logService;

    @GetMapping("/device/page")
    public IPage<Log> findDevicePage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") Integer id) {
        IPage<Log> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Log> wrapper = new QueryWrapper<>();
        wrapper.eq("log_object",1);
//        if(id != null) {
//            wrapper.eq("id", id);
//        }
        return logService.page(page, wrapper);
    }
    @GetMapping("/user/page")
    public IPage<Log> findUserPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") Integer id) {
        IPage<Log> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Log> wrapper = new QueryWrapper<>();
        wrapper.eq("log_object",0);
        return logService.page(page, wrapper);
    }
    @DeleteMapping("/device/remove")
    public Boolean deleteDevice() {
        QueryWrapper<Log> wrapper = new QueryWrapper<>();
        wrapper.eq("log_object",1);
        return logService.remove(wrapper);
    }
    @DeleteMapping("/user/remove")
    public Boolean deleteUser() {
        QueryWrapper<Log> wrapper = new QueryWrapper<>();
        wrapper.eq("log_object",0);
        return logService.remove(wrapper);
    }
}
