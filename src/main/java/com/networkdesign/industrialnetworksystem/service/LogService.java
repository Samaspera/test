package com.networkdesign.industrialnetworksystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.networkdesign.industrialnetworksystem.pojo.Log;

public interface LogService  extends IService<Log> {
    Integer insert (Log log);
}
