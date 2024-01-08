package com.networkdesign.industrialnetworksystem.controller.dto;

import com.networkdesign.industrialnetworksystem.pojo.Device;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@NoArgsConstructor
public class DeviceExport {
    private Integer id;
    private String dName;
    private String type;
    private String address;
    private String isOnline;
    private String isWarning;
    final private String[] warningList= new String[]{"正常","报警"};
    final private String[] addressList= new String[]{"北京", "上海","广州","深圳"};
    final private String[] typeList= new String[]{"温度型设备","湿度型设备","光照型设备"};
    final private String[] onlineList= new String[]{"离线","在线"};
    public DeviceExport (Device device){
        this.id=device.getId();
        this.dName=device.getdName();
        this.type=typeList[device.getType()-1];
        this.address=addressList[device.getAddress() -1];
        this.isOnline=onlineList[device.getIsOnline()];
        this.isWarning=warningList[device.getIsWarning()];
    }
    public static List<DeviceExport> ListExports(List<Device> list){
        List<DeviceExport> exportList = new ArrayList<>();
        for (Device device: list) {
            DeviceExport export = new DeviceExport(device);
            exportList.add(export);
            System.out.println(export.getId());
        }
        return exportList;
    }

    public Integer getId() {
        return id;
    }

    public String getdName() {
        return dName;
    }

    public String getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public String getIsOnline() {
        return isOnline;
    }

    public String getIsWarning() {
        return isWarning;
    }
}
