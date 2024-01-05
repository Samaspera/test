package com.networkdesign.industrialnetworksystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.networkdesign.industrialnetworksystem.mapper.DeviceMapper;
import com.networkdesign.industrialnetworksystem.pojo.Device;
import com.networkdesign.industrialnetworksystem.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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

    @Override
    public Integer updateWarnings() {
        List<Device> deviceList=this.list();
        Random random=new Random();
        Device updatingDevice=deviceList.get(random.nextInt(deviceList.size()));
        updatingDevice.setIsWarning(updatingDevice.getIsWarning()^1);
        return deviceMapper.updateWarning(updatingDevice);
    }
    @Override
    public Device selectById(Integer id){
        return deviceMapper.selectById(id);
    }


}
