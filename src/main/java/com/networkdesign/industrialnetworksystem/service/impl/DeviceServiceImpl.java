package com.networkdesign.industrialnetworksystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.networkdesign.industrialnetworksystem.mapper.DeviceMapper;
import com.networkdesign.industrialnetworksystem.mapper.LogMapper;
import com.networkdesign.industrialnetworksystem.pojo.Device;
import com.networkdesign.industrialnetworksystem.pojo.Log;
import com.networkdesign.industrialnetworksystem.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {
    @Autowired
    private DeviceMapper deviceMapper;
    @Autowired
    private LogMapper logMapper;
    public Integer new_save(Device device){
        if(device.getId()==null) {
            device.setId(0);
            logMapper.insert(new Log(0, LocalDateTime.now(), "add "+device.LogString(),true));
            return deviceMapper.insert(device);
        }else{
            //插入日志
            logMapper.insert(new Log(0, LocalDateTime.now(), "update "+this.selectById(device.getId()).LogString()+" to "+device.LogString(),true));            return deviceMapper.update(device);
        }
    }
    public Integer deleteById(Integer id){
        //插入日志
        logMapper.insert(new Log(0, LocalDateTime.now(), "delete "+ this.selectById(id).LogString(),true));
        return deviceMapper.deleteById(id);
    }

    @Override
    public Integer updateWarnings(Integer id) {
        Device device=this.selectById(id);
//        List<Device> deviceList=this.list();
//        Random random=new Random();
//        Device updatingDevice=deviceList.get(random.nextInt(deviceList.size()));
//        updatingDevice.setIsWarning(updatingDevice.getIsWarning()^1);
        //插入日志
        logMapper.insert(new Log(0, LocalDateTime.now(), "warning "+ device.LogString(),true));
        device.setIsWarning(1);
        return deviceMapper.updateWarning(device);
    }
    @Override
    public Device selectById(Integer id){
        return deviceMapper.selectById(id);
    }


}
