package com.pt.ptdealeruser.controller;

import com.pt.ptcommon.dto.MenuVO;
import com.pt.ptcommon.util.R;
import com.pt.ptcommon.util.SecurityUtils;
import com.pt.ptdealeruser.entity.DealerMenu;
import com.pt.ptdealeruser.service.DealerMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wl
 * @date 2020/5/27
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private DealerMenuService dealerMenuService;

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
                .forEach(role -> all.addAll(dealerMenuService.findMenuByRole(role)));
        return R.ok(dealerMenuService.filterMenu(all, parentId));
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
        Set<DealerMenu> all = new HashSet<>();
        SecurityUtils.getRoles()
                .forEach(role -> all.addAll(dealerMenuService.findRoutesByRole(role)));
        return R.ok(all);
    }

}
