package com.networkdesign.industrialnetworksystem.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.networkdesign.industrialnetworksystem.pojo.Device;
import com.networkdesign.industrialnetworksystem.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    public DeviceService service;

    @PostMapping
    public boolean save(@RequestBody Device device) {
        if(device.getType() == null) {
            device.setType(1);
        }
        return service.save(device);
    }

    @GetMapping ("/page")
    public IPage<Device> findPage(@RequestParam Integer pageNum,
                                  @RequestParam Integer pageSize,
                                  @RequestParam(defaultValue = "") Integer id,
                                  @RequestParam(defaultValue = "") String dName) {
        IPage<Device> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Device> wrapper = new QueryWrapper<>();
        if(id != null) {
            wrapper.like("id", id);
        }
        if(!"".equals(dName)) {
            wrapper.like("d_name", dName);
        }
        return service.page(page, wrapper);
    }
    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }
    /**
     * excel数据导出
     *
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response)throws Exception{
        List<Device> list=service.list();
        //写入内存
        ExcelWriter writer = ExcelUtil.getWriter(true);

        //起别名
        writer.addHeaderAlias("dname","设备名");
        writer.addHeaderAlias("type","数据类型");
        //一次性写出list内对象到excel,使用默认样式，强制输出标题
        writer.write(list,true);
        //文件名
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheetml.sheet;charset-utf-8");
        String filename= URLEncoder.encode("设备信息","UTF-8");
        response.setHeader("Content-Disposition","attachment;filename="+filename+".xlsx");
        //写出
        ServletOutputStream out =response.getOutputStream();
        writer.flush(out,true);
        out.close();
        writer.close();

    }
}
