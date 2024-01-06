package com.networkdesign.industrialnetworksystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@TableName("t_log")
public class Log {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private LocalDateTime time;
    private String operation;
    private Boolean logObject;
}
