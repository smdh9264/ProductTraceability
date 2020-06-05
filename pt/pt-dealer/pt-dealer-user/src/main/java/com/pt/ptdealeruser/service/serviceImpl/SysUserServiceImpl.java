package com.pt.ptdealeruser.service.serviceImpl;

import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pt.ptdealeruser.dto.UserInfo;
import com.pt.ptdealeruser.entity.DealerRole;
import com.pt.ptdealeruser.entity.SysUser;
import com.pt.ptdealeruser.mapper.SysUserMapper;
import com.pt.ptdealeruser.service.DealerMenuService;
import com.pt.ptdealeruser.service.DealerRoleMenuService;
import com.pt.ptdealeruser.service.DealerRoleService;
import com.pt.ptdealeruser.service.SysUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wl
 * @date 2020/5/18
 */
@Slf4j
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {


    private DealerRoleService dealerRoleService;
    private DealerMenuService dealerMenuService;

    @Override
    public UserInfo findUserByUsername(SysUser sysUser) {
        UserInfo userInfo = new UserInfo();
        userInfo.setSysUser(sysUser);
        //设置角色列表  （ID）
        List<DealerRole> dealerRoles = dealerRoleService.findRolesByUserId(sysUser.getId());
        List<String> roles = dealerRoles.stream()
                .map(DealerRole::getRoleCode)
                .collect(Collectors.toList());
        userInfo.setRoles(ArrayUtil.toArray(roles, String.class));
        //设置权限列表（menu.permission）
        Set<String> permissions = new HashSet<>();
        dealerRoles.forEach(dealerRole -> {
            List<String> permissionsByRoleId = dealerMenuService.findPermissionsByRoleId(dealerRole.getRoleId());
            permissions.addAll(permissionsByRoleId);
        });
        userInfo.setPermissions(ArrayUtil.toArray(permissions, String.class));
       return userInfo;
    }
}
