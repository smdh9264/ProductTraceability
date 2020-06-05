package com.pt.ptuser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pt.ptuser.entity.SysRoleMenu;

import java.util.List;

/**
 * @author wl
 * @date 2020/5/25
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {

    List<SysRoleMenu> listRoleMenu(String roleId,String clientId);
}
