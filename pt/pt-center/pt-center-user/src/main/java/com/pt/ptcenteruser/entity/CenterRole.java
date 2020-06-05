package com.pt.ptcenteruser.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("center_role")
@EqualsAndHashCode(callSuper = true)
public class CenterRole extends Model<CenterRole> {

    private String roleId;


    private String roleName;


    private String roleCode;

    /**
     * 0-正常，1-删除
     */
    @TableLogic
    private String delFlag;

    private static final long serialVersionUID = 1L;
}