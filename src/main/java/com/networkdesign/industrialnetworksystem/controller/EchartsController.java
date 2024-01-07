package com.networkdesign.industrialnetworksystem.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.networkdesign.industrialnetworksystem.common.Result;
import com.networkdesign.industrialnetworksystem.pojo.StoreData;
import com.networkdesign.industrialnetworksystem.service.AllFileService;
import com.networkdesign.industrialnetworksystem.service.DeviceService;
import com.networkdesign.industrialnetworksystem.service.impl.random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/echarts")
public class EchartsController {
    @Autowired
    DeviceService deviceService;
    protected List<StoreData> storeList = new ArrayList<>();

    @GetMapping("/example")
    public Result get() {
        Map<String, Object> map = new HashMap<>();
        map.put("x", CollUtil.newArrayList(1, 2, 3, 4, 5, 6, 7));
        map.put("y", CollUtil.newArrayList(1, 2, 3, 4, 5, 6, 7));
        return Result.success(map);
    }

    @GetMapping("/statistic/{id}")
    public Result statistic(@PathVariable Integer id) {
        List<Double> data = random.getRandom();
        // 创建一个新的 ArrayList，并将已存在的 Double List 加入其中
        List<Double> combinedDoubleList = CollUtil.newArrayList();

        combinedDoubleList.addAll(data);
        for(Double douNum:data){
            if(douNum>=30.0) deviceService.updateWarnings(id);
            storeList.add(new StoreData(douNum));
        }
        if(storeList.size()>9){
            String filePath="../../log/statistic/output_all.xlsx";

            if(id != null) {
                filePath="../../log/statistic/"+deviceService.selectById(id).getdName()+".xlsx";
            }

            List<StoreData> ExistedData = AllFileService.readExcelData(filePath);

            System.out.println(ExistedData);
            ExistedData.addAll(storeList);
            storeList.clear();
            AllFileService.writeExcel(filePath,ExistedData);
        }
        return Result.success(data);
    }

    /**
     * excel数据导出
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        //List<Device> list=deservice.list();
        //写入内存
        ExcelWriter writer = ExcelUtil.getWriter(true);

        //起别名
        writer.addHeaderAlias("time","时间");
        writer.addHeaderAlias("data","设备数据");
        //一次性写出list内对象到excel,使用默认样式，强制输出标题
        writer.write(storeList, true);
        //文件名
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheetml.sheet;charset-utf-8");
        String filename = URLEncoder.encode("设备数据", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + filename + ".xlsx");
        //写出
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

    }

}
