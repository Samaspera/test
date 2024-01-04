package com.networkdesign.industrialnetworksystem.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_device")
public class Device {
    private Integer id;
    private String dName;
    private Integer type;
    private Integer address;
    private Integer isOnline;
    private Integer isWarning;

    public Device() {
    }

    public Device(Integer id, String dName, Integer type) {
        this.id = id;
        this.dName = dName;
        this.type =type;
    }

    public Device(Integer id, String dName, Integer type, Integer address, Integer isOnline, Integer isWarning) {
        this.id = id;
        this.dName = dName;
        this.type = type;
        this.address = address;
        this.isOnline = isOnline;
        this.isWarning = isWarning;
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

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public Integer getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Integer isOnline) {
        this.isOnline = isOnline;
    }

    public Integer getIsWarning() {
        return isWarning;
    }

    public void setIsWarning(Integer isWarning) {
        this.isWarning = isWarning;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", dName='" + dName + '\'' +
                ", type=" + type +
                ", address=" + address +
                ", isOnline=" + isOnline +
                ", isWarning=" + isWarning +
                '}';
    }
}
