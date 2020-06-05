package com.pt.ptuser.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="com-pt-ptuser-entity-SysUserRole")
@Data
public class SysUserRole extends Model<SysUserRole> {
    @ApiModelProperty(value="")
    private String userId;

    @ApiModelProperty(value="")
    private String roleId;
}