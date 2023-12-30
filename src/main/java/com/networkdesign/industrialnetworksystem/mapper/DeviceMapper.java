package com.networkdesign.industrialnetworksystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.networkdesign.industrialnetworksystem.pojo.Device;
import com.networkdesign.industrialnetworksystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeviceMapper extends BaseMapper<Device> {
}
