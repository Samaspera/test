package com.networkdesign.industrialnetworksystem.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_device")
public class Device {
    private Integer id;
    private String dName;
    private Integer uid;

    public Device() {
    }

    public Device(Integer id, String dName, Integer uid) {
        this.id = id;
        this.dName = dName;
        this.uid = uid;
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

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", dName='" + dName + '\'' +
                ", uid=" + uid +
                '}';
    }
}
