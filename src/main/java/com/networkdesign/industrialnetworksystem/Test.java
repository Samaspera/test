package com.networkdesign.industrialnetworksystem;

import com.networkdesign.industrialnetworksystem.mapper.DeviceMapper;
import com.networkdesign.industrialnetworksystem.pojo.Device;
import com.networkdesign.industrialnetworksystem.service.DeviceService;
import com.networkdesign.industrialnetworksystem.service.impl.DeviceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        DeviceService service = getDeviceService();
        List<Device> deviceList = service.list();
        Random random = new Random();
        Device device = deviceList.get(random.nextInt(deviceList.size()));
        device.setIsWarning(device.getIsWarning() ^ 1);
        service.updateWarning(device);
    }
    @Bean
    private static DeviceService getDeviceService() {
        return new DeviceServiceImpl();
    }
}
