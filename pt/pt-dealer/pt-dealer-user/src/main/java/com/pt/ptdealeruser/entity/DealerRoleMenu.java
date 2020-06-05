package com.pt.ptdealeruser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wl
 */
@ApiModel(value="com-pt-ptdealeruser-entity-DealerRoleMenu")
@Data
@TableName("dealer_role_menu")
@EqualsAndHashCode(callSuper = true)
public class DealerRoleMenu extends Model<DealerRoleMenu> {

    /**
     * 角色id
     */
    @ApiModelProperty(value="角色id")
    private String roleId;
    /**
    * 菜单id
    */
    @ApiModelProperty(value="菜单id")
    private String menuId;


    private static final long serialVersionUID = 1L;
}