package com.pt.ptuser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pt.ptcommon.dto.MenuTree;
import com.pt.ptcommon.dto.MenuVO;
import com.pt.ptuser.dto.TreeSelect;
import com.pt.ptuser.entity.SysMenu;

import java.util.List;
import java.util.Set;

/**
 * @author wl
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 按角色获取菜单
     * @param role
     * @return
     */
    List<MenuVO> findMenuByRole(String role);
    /**
     * 按角色获取菜单
     * @param role
     * @return
     */
    List<SysMenu> findRoutesByRole(String role);
    /**
     * 按角色id查询权限
     * @param roleId
     * @return
     */
    List<String> findPermissionsByRoleId(String roleId,String clientId);

    /**
     * 查询菜单
     *
     * @param menuSet
     * @param parentId
     * @return
     */
    List<MenuTree> filterMenu(Set<MenuVO> menuSet, String parentId);

    /**
     * 根据用户查询系统菜单列表
     *
     * @param menu 菜单信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    List<SysMenu> selectMenuList(SysMenu menu, String userId);
    /**
     * 根据用户查询系统菜单列表
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    List<SysMenu> selectMenuList(String userId);

    /**
     * 构建前端所需要下拉树结构
     *
     * @param menus 菜单列表
     * @return 下拉树结构列表
     */
    List<TreeSelect> buildMenuTreeSelect(List<SysMenu> menus);

    /**
     * 构建前端所需要树结构
     *
     * @param menus 菜单列表
     * @return 树结构列表
     */
    List<SysMenu> buildMenuTree(List<SysMenu> menus);
    /**
     * 根据角色ID查询菜单树信息
     *
     * @param roleId 角色ID
     * @return 选中菜单列表
     */
    List<String> selectMenuListByRoleId(String roleId);

}
