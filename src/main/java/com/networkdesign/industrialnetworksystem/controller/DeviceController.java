package com.networkdesign.industrialnetworksystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.networkdesign.industrialnetworksystem.pojo.Device;
import com.networkdesign.industrialnetworksystem.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    public DeviceService service;

    @PostMapping
    public boolean save(@RequestBody Device device) {
        if(device.getType() == null) {
            device.setType(1);
        }
        return service.save(device);
    }

    @GetMapping ("/page")
    public IPage<Device> findPage(@RequestParam Integer pageNum,
                                  @RequestParam Integer pageSize,
                                  @RequestParam(defaultValue = "") Integer id,
                                  @RequestParam(defaultValue = "") String dName) {
        IPage<Device> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Device> wrapper = new QueryWrapper<>();
        if(id != null) {
            wrapper.like("id", id);
        }
        if(!"".equals(dName)) {
            wrapper.like("d_name", dName);
        }
        return service.page(page, wrapper);
    }
}
