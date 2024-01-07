package com.networkdesign.industrialnetworksystem.controller;

import com.networkdesign.industrialnetworksystem.pojo.Device;
import com.networkdesign.industrialnetworksystem.pojo.bigScreenPojo.*;
import com.networkdesign.industrialnetworksystem.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/bigscreen")
public class BigScreenController {
    @Autowired
    private DeviceService service;

    private final String[] cityList = new String[]{"北京市", "上海市", "广州市", "深圳市"};

    @GetMapping("/data")
    public Map<String, Object> getData() {
        Map<String, Object> res = new HashMap<>();

        DoorControlData doorControlData;
        DeviceStateData<DoorControlData> deviceStateData;
        List<CityDoorControlVOList> cityDoorControlVOList;
        DeviceSortData<List<CityDoorControlVOList>> deviceSortData;
        List<RealTimeWarningVOList> realTimeWarningVOLists;
        DeviceWarningData<List<RealTimeWarningVOList>> deviceWarningData;
        FaceDoorControlData faceDoorControlData;
        DeviceTypeData<FaceDoorControlData> deviceTypeData;

        try {
            List<Device> list = service.list();
            Integer offline = 0, online = 0;  //设备在线状态
            for (Device device : list) {
                online += device.getIsOnline();
                offline += 1 - device.getIsOnline();
            }
            doorControlData = new DoorControlData(offline, online);
            deviceStateData = new DeviceStateData<>(0, doorControlData, "success");
            res.put("deviceStateData", deviceStateData);

            int[] city = new int[]{0, 0, 0, 0};
            for (Device device : list) {
                city[device.getAddress() - 1]++;
            }
            cityDoorControlVOList = Arrays.asList(
                    new CityDoorControlVOList("北京市", city[0]),
                    new CityDoorControlVOList("上海市", city[1]),
                    new CityDoorControlVOList("广州市", city[2]),
                    new CityDoorControlVOList("深圳市", city[3])
            );
            Map<String, List<CityDoorControlVOList>> temp2 = new HashMap<>();
            temp2.put("cityDoorControlVOList", cityDoorControlVOList);
            deviceSortData = new DeviceSortData<>(0, temp2, "success");
            res.put("deviceSortData", deviceSortData);

            realTimeWarningVOLists = new ArrayList<>();
            for (Device device : list) {
                if(device.getIsWarning() == 1) {
                    realTimeWarningVOLists.add(new RealTimeWarningVOList(cityList[device.getAddress() - 1], device.getdName()));
                }
            }
            Map<String, List<RealTimeWarningVOList>> temp = new HashMap<>();
            temp.put("realTimeWarningVOList", realTimeWarningVOLists);
            deviceWarningData = new DeviceWarningData<>(0, temp, "success");
            res.put("deviceWarningData", deviceWarningData);

            int[] type = new int[]{0, 0, 0};
            for (Device device : list) {
                type[device.getType() - 1]++;
            }
            faceDoorControlData = new FaceDoorControlData(type[0], type[1], type[2]);
            deviceTypeData = new DeviceTypeData<>(0, faceDoorControlData, "success");
            res.put("deviceTypeData", deviceTypeData);
        } catch (Exception e) {
            e.printStackTrace();
            deviceStateData = new DeviceStateData<>(1, null, "error");
            deviceSortData = new DeviceSortData<>(1, null, "error");
            deviceWarningData = new DeviceWarningData<>(1, null, "error");
            deviceTypeData = new DeviceTypeData<>(1, null, "error");
            res.put("deviceStateData", deviceStateData);
            res.put("deviceSortData", deviceSortData);
            res.put("deviceWarningData", deviceWarningData);
            res.put("deviceTypeData", deviceTypeData);
        }
        return res;
    }

    @GetMapping("/communityData")
    public CommunityData getCommunityData() {
        List<Device> list = service.list();
        Integer deviceData = 0, communityData = 0;
        Set<Integer> set = new HashSet<>();
        for (Device device : list) {
            set.add(device.getAddress());
        }
        deviceData = list.size();
        communityData = set.size();

        return new CommunityData(deviceData, communityData);
    }
}
