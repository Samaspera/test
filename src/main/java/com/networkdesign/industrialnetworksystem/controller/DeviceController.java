package com.networkdesign.industrialnetworksystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.networkdesign.industrialnetworksystem.pojo.Device;
import com.networkdesign.industrialnetworksystem.pojo.Log;
import com.networkdesign.industrialnetworksystem.service.DeviceService;
import com.networkdesign.industrialnetworksystem.service.impl.LogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    public DeviceService service;
    @Autowired
    public LogServiceImpl logService;
    @PostMapping
    public Integer save(@RequestBody Device device) {
        return service.new_save(device);
    }

    @GetMapping ("/page")
    public IPage<Device> findPage(@RequestParam Integer pageNum,
                                  @RequestParam Integer pageSize,
                                  @RequestParam(defaultValue = "") Integer id,
                                  @RequestParam(defaultValue = "") Integer dType,
                                  @RequestParam(defaultValue = "") String dName) {
        IPage<Device> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Device> wrapper = new QueryWrapper<>();
        if(id != null) {
            wrapper.eq("id", id);
        }
        if(!"".equals(dName)) {
            wrapper.like("d_name", dName);
        }

        //随机地去更改数据库里的设备的是否警告状态，模拟，发来的警告。
        service.updateWarnings();

        return service.page(page, wrapper);
    }
    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }

    @PostMapping("del/batch")
    public boolean delBatchById(@RequestBody List<Integer> ids){
        for(Integer id:ids){
            logService.insert(new Log(0, LocalDateTime.now(),"delete "+service.selectById(id).LogString(),true));
        }
        return service.removeByIds(ids);
    }
}
