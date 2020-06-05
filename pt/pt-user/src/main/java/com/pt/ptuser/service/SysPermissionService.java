package com.pt.ptuser.service;


import com.pt.ptcommon.constant.CommonConstants;
import com.pt.ptuser.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户权限处理
 * 
 * @author ruoyi
 */
@Service
public class SysPermissionService
{

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysUserRoleService sysUserRoleService;
    /**
     * 获取角色数据权限
     * 
     * @param user 用户信息
     * @return 角色权限信息
     */
//    public Set<String> getRolePermission(SysUser user)
//    {
//        Set<String> roles = new HashSet<String>();
//        // 管理员拥有所有权限
//        Boolean isAdmin = sysUserRoleService.isAdmin(user.getUserId(), sysRoleService
//                .getByRoleCode(CommonConstants.ROLE_ADMIN).getRoleId());
//        if (isAdmin)
//        {
//            roles.add("admin");
//        }
//        else
//        {
//            roles.addAll(sysRoleService.selectRolePermissionByUserId(user.getUserId()));
//        }
//        return roles;
//    }
//
//    /**
//     * 获取菜单数据权限
//     *
//     * @param user 用户信息
//     * @return 菜单权限信息
//     */
//    public Set<String> getMenuPermission(SysUser user)
//    {
//        Set<String> perms = new HashSet<String>();
//        // 管理员拥有所有权限
//        if (user.isAdmin())
//        {
//            perms.add("*:*:*");
//        }
//        else
//        {
//            perms.addAll(sysMenuService.selectMenuPermsByUserId(user.getUserId()));
//        }
//        return perms;
//    }
}
