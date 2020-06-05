package com.pt.ptuser.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pt.ptuser.entity.SysRole;

import java.util.List;

public interface SysRoleService extends IService<SysRole> {
    List<SysRole> findRolesByUserId(String UserId, String clientId);

    /**
     * 查询所有角色
     *
     * @return 角色列表
     */
    List<SysRole> selectRoleAll();

    /**
     * 根据条件查询角色数据
     *
     * @param role 角色信息
     * @return 角色数据集合信息
     */
    List<SysRole> selectRoleList(SysRole role);

    /**
     * 根据角色名获取角色
     * @param roleCode
     * @return
     */
    SysRole getByRoleCode(String roleCode);

    /**
     * 分页获取角色
     * @param page
     * @param sysRole
     * @return
     */
    IPage<List<SysRole>> getRolePage(Page page, SysRole sysRole);

    /**
     * 根据id获取角色
     * @param roleId
     * @return
     */
    SysRole selectRoleById(String roleId);
}
