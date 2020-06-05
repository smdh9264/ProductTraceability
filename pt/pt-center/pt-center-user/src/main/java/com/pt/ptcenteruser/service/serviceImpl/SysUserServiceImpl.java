package com.pt.ptcenteruser.service.serviceImpl;

import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pt.ptcenteruser.dto.UserInfo;
import com.pt.ptcenteruser.entity.CenterRole;
import com.pt.ptcenteruser.entity.SysUser;
import com.pt.ptcenteruser.mapper.SysUserMapper;
import com.pt.ptcenteruser.service.CenterRoleService;
import com.pt.ptcenteruser.service.SysUserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wl
 * @date 2020/5/18
 */
@Slf4j
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {


    private CenterRoleService centerRoleService;

    @Override
    public UserInfo findUserByUsername(SysUser sysUser) {
        UserInfo userInfo = new UserInfo();
        userInfo.setSysUser(sysUser);
        //设置角色列表  （ID）
        List<String> roles = centerRoleService.findRolesByUserId(sysUser.getId())
                .stream()
                .map(CenterRole::getRoleCode)
                .collect(Collectors.toList());
        userInfo.setRoles(ArrayUtil.toArray(roles, String.class));
//
//        //设置权限列表（menu.permission）
//        Set<String> permissions = new HashSet<>();
//        roleIds.forEach(roleId -> {
//            List<String> permissionList = sysMenuService.findMenuByRoleId(roleId)
//                    .stream()
//                    .filter(menuVo -> StringUtils.isNotEmpty(menuVo.getPermission()))
//                    .map(MenuVO::getPermission)
//                    .collect(Collectors.toList());
//            permissions.addAll(permissionList);
//        });
//        userInfo.setPermissions(ArrayUtil.toArray(permissions, String.class));
        return userInfo;
    }
}
