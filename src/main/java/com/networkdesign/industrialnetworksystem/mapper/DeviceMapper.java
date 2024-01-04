package com.networkdesign.industrialnetworksystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.networkdesign.industrialnetworksystem.pojo.Device;
import com.networkdesign.industrialnetworksystem.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DeviceMapper extends BaseMapper<Device> {
    @Update("update t_device set d_name=#{dName}, type=#{type}, address=#{address} where id=#{id} ")
    Integer update(Device device);

    @Delete("delete from t_device where id=#{id}")
    Integer deleteById(@Param("id") Integer id);
}
