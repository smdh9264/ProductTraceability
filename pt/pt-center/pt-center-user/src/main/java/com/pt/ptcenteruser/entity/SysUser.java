package com.pt.ptcenteruser.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@TableName("center_user")
@EqualsAndHashCode(callSuper = true)
public class SysUser extends Model<SysUser> {

    @TableId(value = "id",type = IdType.INPUT)
    private String id;


    private String username;


    private String password;
    /**
     * 0-正常，1-删除
     */
    @TableLogic
    private String delFlag;

    private static final long serialVersionUID = 1L;

}