package com.networkdesign.industrialnetworksystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@TableName("t_device")
public class Device {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String dName;
    private Integer type;
    private Integer address;
    private Integer isOnline;
    private Integer isWarning;

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
    public String LogString(){
        //String [] types =new String[] {"温度型设备","湿度型设备","光照型设备"} ;
        //String [] addresses =new String[] {"北京","上海","广州","深圳"};
//        防溢出
        try{
            //return"在"+addresses[address-1]+"的"+types[type-1]+" "+dName;
            return dName;
        }catch (ArrayIndexOutOfBoundsException e){
//            return "日志写入错误";
            return "error";

        }

    }
}
