package com.networkdesign.industrialnetworksystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.networkdesign.industrialnetworksystem.mapper.DeviceMapper;
import com.networkdesign.industrialnetworksystem.pojo.Device;
import com.networkdesign.industrialnetworksystem.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {
    @Autowired
    private DeviceMapper deviceMapper;
    public Integer new_save(Device device){
        if(device.getId()==null) {
            device.setId(0);
            return deviceMapper.insert(device);
        }else{
            return deviceMapper.update(device);
        }
    }
    public Integer deleteById(Integer id){
        return deviceMapper.deleteById(id);
    }

    public Integer updateWarning(Device device) {return deviceMapper.updateWarning(device);}
    }
