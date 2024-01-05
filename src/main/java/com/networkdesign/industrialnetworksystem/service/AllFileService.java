package com.networkdesign.industrialnetworksystem.service;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.networkdesign.industrialnetworksystem.pojo.AllFile;

import java.util.List;

public interface AllFileService {
    static <T> void writeDeviceStatistic(List<T> data) {
        String filePath="../../log/statistic/output.xlsx";
        ExcelWriter writer = ExcelUtil.getWriter(filePath);
        writer.addHeaderAlias("time","时间");
        writer.addHeaderAlias("data","设备数据");
        writer.write(data, true);
        writer.flush();
        writer.close();
    }
}
