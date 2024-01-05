package com.networkdesign.industrialnetworksystem.pojo.bigScreenPojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CityDoorControlVOList {
    private String cityName;
    private Integer iotCount;

    public CityDoorControlVOList() {
    }

    public CityDoorControlVOList(String cityName, Integer iotCount) {
        this.cityName = cityName;
        this.iotCount = iotCount;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getIotCount() {
        return iotCount;
    }

    public void setIotCount(Integer iotCount) {
        this.iotCount = iotCount;
    }

    @Override
    public String toString() {
        return "CityDoorControlVOList{" +
                "cityName='" + cityName + '\'' +
                ", iotCount='" + iotCount + '\'' +
                '}';
    }
}
