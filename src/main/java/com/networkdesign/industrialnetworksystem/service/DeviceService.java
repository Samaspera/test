package com.networkdesign.industrialnetworksystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.networkdesign.industrialnetworksystem.pojo.Device;

public interface DeviceService extends IService<Device> {
    Integer new_save(Device device);

    Integer deleteById(Integer id);

    Integer updateWarnings(Integer id);

    Device selectById(Integer id);
}