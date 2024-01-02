package com.networkdesign.industrialnetworksystem.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_device")
public class Device {
    private Integer id;
    private String dName;
    private Integer type;

    public Device() {
    }

    public Device(Integer id, String dName, Integer type) {
        this.id = id;
        this.dName = dName;
        this.type =type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", dName='" + dName + '\'' +
                ", type=" + type +
                '}';
    }
}
