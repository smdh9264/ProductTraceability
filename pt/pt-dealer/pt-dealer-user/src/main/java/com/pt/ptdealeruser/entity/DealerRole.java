package com.pt.ptdealeruser.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("dealer_role")
@EqualsAndHashCode(callSuper = true)
public class DealerRole extends Model<DealerRole> {

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