package com.networkdesign.industrialnetworksystem.pojo.bigScreenPojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoorControlData {
    private Integer offLineDoorControl;
    private Integer onLineDoorControl;

    public DoorControlData() {
    }

    public DoorControlData(Integer offLineDoorControl, Integer onLineDoorControl) {
        this.offLineDoorControl = offLineDoorControl;
        this.onLineDoorControl = onLineDoorControl;
    }

    public Integer getOffLineDoorControl() {
        return offLineDoorControl;
    }

    public void setOffLineDoorControl(Integer offLineDoorControl) {
        this.offLineDoorControl = offLineDoorControl;
    }

    public Integer getOnLineDoorControl() {
        return onLineDoorControl;
    }

    public void setOnLineDoorControl(Integer onLineDoorControl) {
        this.onLineDoorControl = onLineDoorControl;
    }

    @Override
    public String toString() {
        return "DoorControlData{" +
                "offLineDoorControl=" + offLineDoorControl +
                ", onLineDoorControl=" + onLineDoorControl +
                '}';
    }
}
