package com.networkdesign.industrialnetworksystem.service;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.networkdesign.industrialnetworksystem.pojo.StoreData;

import java.util.ArrayList;
import java.util.List;

public interface AllFileService {
//    static <T> void writeDeviceStatistic(List<T> data,Integer id) {
//
//
//        String filePath="../../log/statistic/output"+id+".xlsx";
//
//        //读取以前的数据
//        ExcelReader reader= ExcelUtil.getReader(filePath);
//        List<StoreData> all =reader.readAll(StoreData.class);
//        reader.close();
//        ExcelWriter writer = ExcelUtil.getWriter(filePath);
//        writer.addHeaderAlias("time","时间");
//        writer.addHeaderAlias("data","设备数据");
//        writer.write(data, true);
//        writer.flush();
//        writer.close();
//    }
    static List<StoreData> readExcelData(String filePath) {
        try {
            ExcelReader reader = ExcelUtil.getReader(filePath);
            List<StoreData> dataList = reader.readAll(StoreData.class);
            System.out.println(dataList);
            reader.close();
            return dataList;
        } catch (Exception e) {
            //e.printStackTrace();
            return new ArrayList<>();
        }
        //reader.removeHeaderAlias("时间");
        //reader.removeHeaderAlias("设备数据");
    }

    static void writeExcel(String filePath, List<StoreData> dataList) {
        ExcelWriter writer = ExcelUtil.getWriter(filePath);
        //writer.addHeaderAlias("time","时间");
        //writer.addHeaderAlias("data", "设备数据");
        writer.write(dataList, true);  // 使用 true 表示追加数据
        writer.flush();
        writer.close();
    }
}
