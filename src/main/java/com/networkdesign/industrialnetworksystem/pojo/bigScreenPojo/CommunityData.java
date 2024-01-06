package com.networkdesign.industrialnetworksystem.pojo.bigScreenPojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommunityData {
    private Integer deviceAmount;
    private Integer communityAmount;

    public CommunityData() {
    }

    public CommunityData(Integer deviceAmount, Integer communityAmount) {
        this.deviceAmount = deviceAmount;
        this.communityAmount = communityAmount;
    }

    public Integer getDeviceAmount() {
        return deviceAmount;
    }

    public void setDeviceAmount(Integer deviceAmount) {
        this.deviceAmount = deviceAmount;
    }

    public Integer getCommunityAmount() {
        return communityAmount;
    }

    public void setCommunityAmount(Integer communityAmount) {
        this.communityAmount = communityAmount;
    }

    @Override
    public String toString() {
        return "CommunityData{" +
                "deviceAmount=" + deviceAmount +
                ", communityAmount=" + communityAmount +
                '}';
    }
}
