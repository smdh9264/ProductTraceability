package com.pt.ptuser.service.serviceImpl;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pt.ptcommon.constant.CommonConstants;
import com.pt.ptuser.dto.UserInfo;
import com.pt.ptuser.entity.SysRole;
import com.pt.ptuser.entity.SysUser;
import com.pt.ptuser.mapper.SysUserMapper;
import com.pt.ptuser.service.SysMenuService;
import com.pt.ptuser.service.SysRoleService;
import com.pt.ptuser.service.SysUserRoleService;
import com.pt.ptuser.service.SysUserService;
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


    private SysRoleService sysRoleService;
    private SysMenuService sysMenuService;
    private SysUserRoleService sysUserRoleService;


    /**
     * auth通过账号与客户端获取用户信息
     * @param username
     * @param clientId
     * @return
     */
    @Override
    public UserInfo findUserByUsername(String username, String clientId) {
        SysUser sysUser = baseMapper.findUserByUsername(username, clientId);
        UserInfo userInfo = new UserInfo();
        userInfo.setSysUser(sysUser);
        //设置角色列表  （ID）
        List<SysRole> dealerSysRoles = sysRoleService.findRolesByUserId(sysUser.getUserId(),clientId);
        List<String> roles = dealerSysRoles.stream()
                .map(SysRole::getRoleCode)
                .collect(Collectors.toList());
        userInfo.setRoles(ArrayUtil.toArray(roles, String.class));
        //设置权限列表（menu.permission）
        Set<String> permissions = new HashSet<>();
        dealerSysRoles.forEach(dealerRole -> {
            List<String> permissionsByRoleId = sysMenuService.findPermissionsByRoleId(dealerRole.getRoleId(),clientId);
            permissions.addAll(permissionsByRoleId);
        });
        userInfo.setPermissions(ArrayUtil.toArray(permissions, String.class));
        return userInfo;
    }

    @Override
    public IPage getDeptUserWithRolePage(Page page, String clientId,String deptId) {
        return baseMapper.getDeptUserPage(page,clientId,deptId);
    }

    @Override
    public IPage getAllUserWithRolePage(Page page, String clientId) {
        return baseMapper.getAllUserPage(page,clientId);
    }

    /**
     * 根据id查找用户
     * @param userId
     * @return
     */
    @Override
    public SysUser getByUserId(String userId) {
        return baseMapper.getByUserId(userId);
    }

    /**
     * 校验用户是否允许操作
     *
     * @param user 用户信息
     */
    @Override
    public Boolean checkUserAllowed(SysUser user)
    {
        if (StrUtil.isNotEmpty(user.getUserId()) && sysUserRoleService.isAdmin(user.getUserId(), sysRoleService
                .getByRoleCode(CommonConstants.ROLE_ADMIN).getRoleId())) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /**
     * 修改用户状态
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public Boolean updateUserStatus(SysUser user)
    {
        return baseMapper.updateUser(user);
    }
}
