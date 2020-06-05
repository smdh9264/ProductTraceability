package com.pt.ptuser.controller;

import com.pt.ptcommon.dto.MenuVO;
import com.pt.ptcommon.util.R;
import com.pt.ptcommon.util.SecurityUtils;
import com.pt.ptuser.entity.SysMenu;
import com.pt.ptuser.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author wl
 * @date 2020/5/27
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 返回当前用户的树形菜单集合
     *
     * @param parentId 父节点ID
     * @return 当前用户的树形菜单
     */
    @GetMapping("/all")
    public R getMenuTree(String parentId) {

        // 获取符合条件的菜单
        Set<MenuVO> all = new HashSet<>();
        SecurityUtils.getRoles()
                .forEach(role -> all.addAll(sysMenuService.findMenuByRole(role)));
        return R.ok(sysMenuService.filterMenu(all, parentId));
//        return R.ok(all);
    }

    /**
     * 返回当前用户的树形菜单集合
     *
     * @param parentId 父节点ID
     * @return 当前用户的树形菜单
     */
    @GetMapping("/routes")
    public R getRoutes(String parentId) {

        // 获取符合条件的菜单
        Set<SysMenu> all = new HashSet<>();
        SecurityUtils.getRoles()
                .forEach(role -> all.addAll(sysMenuService.findRoutesByRole(role)));
        return R.ok(all);
    }

    /**
     * 返回当前用户的树形菜单集合
     *
     * @param sysMenu 父节点ID
     * @return 当前用户的树形菜单
     */
    @GetMapping("/tree")
    public R getTree(SysMenu sysMenu) {

        // 获取符合条件的菜单
        List<SysMenu> menus = sysMenuService.selectMenuList(sysMenu, SecurityUtils.getUser().getId());
        return R.ok(sysMenuService.buildMenuTreeSelect(menus));
    }

    /**
     * 加载对应角色菜单列表树
     */
    @GetMapping(value = "/roleMenuTreeselect/{roleId}")
    public R roleMenuTreeselect(@PathVariable("roleId") String roleId)
    {
        List<SysMenu> menus = sysMenuService.selectMenuList(SecurityUtils.getUser().getId());
        Map result = new HashMap<String, List<String>>();
        //个人菜单
        result.put("checkedKeys", sysMenuService.selectMenuListByRoleId(roleId));
        //全部菜单
        result.put("menus", sysMenuService.buildMenuTreeSelect(menus));
        return R.ok(result);
    }

}
