package com.networkdesign.industrialnetworksystem.pojo.bigScreenPojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RealTimeWarningVOList {
    private String communtiyName;
    private String doorControlName;
    private String realTime;

    public RealTimeWarningVOList() {
    }

    public RealTimeWarningVOList(String communtiyName, String doorControlName) {
        this.communtiyName = communtiyName;
        this.doorControlName = doorControlName;
        this.realTime = "10:58";
    }

    public String getCommuntiyName() {
        return communtiyName;
    }

    public void setCommuntiyName(String communtiyName) {
        this.communtiyName = communtiyName;
    }

    public String getDoorControlName() {
        return doorControlName;
    }

    public void setDoorControlName(String doorControlName) {
        this.doorControlName = doorControlName;
    }

    public String getRealTime() {
        return realTime;
    }

    public void setRealTime(String realTime) {
        this.realTime = realTime;
    }

    @Override
    public String toString() {
        return "RealTimeWarningVOList{" +
                "communtiyName='" + communtiyName + '\'' +
                ", doorControlName='" + doorControlName + '\'' +
                ", realTime='" + realTime + '\'' +
                '}';
    }
}
