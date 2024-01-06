package com.networkdesign.industrialnetworksystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.networkdesign.industrialnetworksystem.mapper.LogMapper;
import com.networkdesign.industrialnetworksystem.pojo.Log;
import com.networkdesign.industrialnetworksystem.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl extends ServiceImpl<LogMapper,Log> implements LogService {
    @Autowired
    private LogMapper logMapper;
    @Override
    public Integer insert(Log log) {
        return logMapper.insert(log);
    }
}
