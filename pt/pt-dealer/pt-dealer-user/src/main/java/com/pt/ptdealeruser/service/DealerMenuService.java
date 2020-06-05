package com.pt.ptdealeruser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pt.ptcommon.dto.MenuTree;
import com.pt.ptcommon.dto.MenuVO;
import com.pt.ptdealeruser.entity.DealerMenu;

import java.util.List;
import java.util.Set;

/**
 * @author wl
 */
public interface DealerMenuService extends IService<DealerMenu> {

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
    List<DealerMenu> findRoutesByRole(String role);
    /**
     * 按角色id查询权限
     * @param roleId
     * @return
     */
    List<String> findPermissionsByRoleId(String roleId);

    /**
     * 查询菜单
     *
     * @param menuSet
     * @param parentId
     * @return
     */
    List<MenuTree> filterMenu(Set<MenuVO> menuSet, String parentId);
}
