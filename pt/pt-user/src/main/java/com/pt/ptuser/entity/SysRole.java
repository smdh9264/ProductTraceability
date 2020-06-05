package com.pt.ptuser.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysRole extends Model<SysRole> {

    private String roleId;


    private String roleName;


    private String roleCode;

    private Integer roleSort;

    private String createBy;

    private LocalDateTime createTime;

    private char status;

    /**
     * 0-正常，1-删除
     */
    @TableLogic
    private String delFlag;


}