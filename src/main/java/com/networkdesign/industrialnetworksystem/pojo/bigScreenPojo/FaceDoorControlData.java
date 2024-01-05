package com.networkdesign.industrialnetworksystem.pojo.bigScreenPojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FaceDoorControlData {
    private Integer faceCount;  //温度型设备
    private Integer faceDoorControlByadvertiseCount;  //湿度型设备
    private Integer faceDoorControlCount;  //光照型设备
    private Integer iotDoorControlCount;
    private Integer iotDoorCount;
    private Integer offlineByadvertiseCount;
    private Integer offlineByadvertiseDoorCount;

    public FaceDoorControlData() {
    }

    public FaceDoorControlData(Integer faceCount, Integer faceDoorControlByadvertiseCount, Integer faceDoorControlCount) {
        this.faceCount = faceCount;
        this.faceDoorControlByadvertiseCount = faceDoorControlByadvertiseCount;
        this.faceDoorControlCount = faceDoorControlCount;
        this.iotDoorControlCount = 12;
        this.iotDoorCount = 34;
        this.offlineByadvertiseCount = 45;
        this.offlineByadvertiseDoorCount = 13;
    }

    public Integer getFaceCount() {
        return faceCount;
    }

    public void setFaceCount(Integer faceCount) {
        this.faceCount = faceCount;
    }

    public Integer getFaceDoorControlByadvertiseCount() {
        return faceDoorControlByadvertiseCount;
    }

    public void setFaceDoorControlByadvertiseCount(Integer faceDoorControlByadvertiseCount) {
        this.faceDoorControlByadvertiseCount = faceDoorControlByadvertiseCount;
    }

    public Integer getFaceDoorControlCount() {
        return faceDoorControlCount;
    }

    public void setFaceDoorControlCount(Integer faceDoorControlCount) {
        this.faceDoorControlCount = faceDoorControlCount;
    }

    public Integer getIotDoorControlCount() {
        return iotDoorControlCount;
    }

    public void setIotDoorControlCount(Integer iotDoorControlCount) {
        this.iotDoorControlCount = iotDoorControlCount;
    }

    public Integer getIotDoorCount() {
        return iotDoorCount;
    }

    public void setIotDoorCount(Integer iotDoorCount) {
        this.iotDoorCount = iotDoorCount;
    }

    public Integer getOfflineByadvertiseCount() {
        return offlineByadvertiseCount;
    }

    public void setOfflineByadvertiseCount(Integer offlineByadvertiseCount) {
        this.offlineByadvertiseCount = offlineByadvertiseCount;
    }

    public Integer getOfflineByadvertiseDoorCount() {
        return offlineByadvertiseDoorCount;
    }

    public void setOfflineByadvertiseDoorCount(Integer offlineByadvertiseDoorCount) {
        this.offlineByadvertiseDoorCount = offlineByadvertiseDoorCount;
    }

    @Override
    public String toString() {
        return "FaceDoorControlData{" +
                "faceCount=" + faceCount +
                ", faceDoorControlByadvertiseCount=" + faceDoorControlByadvertiseCount +
                ", faceDoorControlCount=" + faceDoorControlCount +
                ", iotDoorControlCount=" + iotDoorControlCount +
                ", iotDoorCount=" + iotDoorCount +
                ", offlineByadvertiseCount=" + offlineByadvertiseCount +
                ", offlineByadvertiseDoorCount=" + offlineByadvertiseDoorCount +
                '}';
    }
}
