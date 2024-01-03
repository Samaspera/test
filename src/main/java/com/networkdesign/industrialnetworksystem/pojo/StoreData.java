package com.networkdesign.industrialnetworksystem.pojo;

import java.time.LocalDateTime;

public class StoreData {
    private Double data ;
    private LocalDateTime time;

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
}
