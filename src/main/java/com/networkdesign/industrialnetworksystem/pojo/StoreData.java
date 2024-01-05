package com.networkdesign.industrialnetworksystem.pojo;

import java.time.LocalDateTime;

public class StoreData {

    private LocalDateTime time;
    private Double data ;
    public StoreData(Double data){
        this.data=data;
        this.time= LocalDateTime.now();
    }

    public Double getData() {
        return data;
    }

    public void setData(Double data) {
        this.data = data;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "StoreData{" +
                "data=" + data +
                ", time=" + time +
                '}';
    }
}
