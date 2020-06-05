package com.pt.ptuser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pt.ptuser.entity.SysUser;
import com.pt.ptuser.entity.SysUserRole;

import java.util.List;

/**
 * @author wl
 */
public interface SysUserRoleService extends IService<SysUserRole> {

    /**
     * 获取用户对应角色列表
     * @param userId
     * @return
     */
    List<SysUserRole> getListByUserId(String userId);

    /**
     * 是否为管理员
     * @param userId
     * @return
     */
    Boolean isAdmin(String userId,String roleId);
}
