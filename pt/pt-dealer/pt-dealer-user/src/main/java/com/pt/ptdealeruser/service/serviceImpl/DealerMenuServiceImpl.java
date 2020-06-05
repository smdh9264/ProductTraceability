package com.pt.ptdealeruser.service.serviceImpl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pt.ptcommon.constant.CommonConstants;
import com.pt.ptcommon.dto.MenuTree;
import com.pt.ptcommon.dto.MenuVO;
import com.pt.ptcommon.util.TreeUtil;
import com.pt.ptdealeruser.entity.DealerRole;
import com.pt.ptdealeruser.entity.DealerRoleMenu;
import com.pt.ptdealeruser.service.DealerRoleMenuService;
import com.pt.ptdealeruser.service.DealerRoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.pt.ptdealeruser.mapper.DealerMenuMapper;
import com.pt.ptdealeruser.entity.DealerMenu;
import com.pt.ptdealeruser.service.DealerMenuService;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wl
 */
@Slf4j
@Service
@AllArgsConstructor
public class DealerMenuServiceImpl extends ServiceImpl<DealerMenuMapper,DealerMenu> implements DealerMenuService {

    private DealerRoleMenuService dealerRoleMenuService;

    private DealerRoleService dealerRoleService;
    /**
     * 根据角色获取权限
     * @param roleId
     * @return
     */
    @Override
    public List<String> findPermissionsByRoleId(String roleId) {
        List<DealerRoleMenu> dealerRoleMenuList = dealerRoleMenuService.list(Wrappers.<DealerRoleMenu>query()
                .lambda().eq(DealerRoleMenu::getRoleId, roleId));
        List<String> permissionsList = new ArrayList<>();
        dealerRoleMenuList.stream().forEach(dealerRoleMenu -> {
            String perms = this.getById(dealerRoleMenu.getMenuId()).getPerms();
            if(perms != null){
                permissionsList.add(perms);
            }
        });
        return permissionsList;
    }

    /**
     * @param role
     * @return
     */
    @Override
    public List<DealerMenu> findRoutesByRole(String role) {
        return baseMapper.listRoutesByRole(role);
    }


    @Override
    public List<MenuVO> findMenuByRole(String role) {
//        DealerRole dealerRole = dealerRoleService.getOne(Wrappers.<DealerRole>query().lambda()
//                .eq(DealerRole::getRoleCode, role));
//        List<DealerRoleMenu> dealerRoleMenus = dealerRoleMenuService.list(Wrappers.<DealerRoleMenu>query().lambda()
//                .eq(DealerRoleMenu::getRoleId, dealerRole.getRoleId()));
//        List<DealerMenu> collect = dealerRoleMenus.stream().map(dealerRoleMenu -> this.getById(dealerRoleMenu.getMenuId()))
//                .collect(Collectors.toList());
//        return collect;
        return baseMapper.listMenuByRole(role);
    }

    /**
     * 查询菜单
     *
     * @param all      全部菜单
     * @param parentId 父节点ID
     * @return
     */
    @Override
    public List<MenuTree> filterMenu(Set<MenuVO> all, String parentId) {
        List<MenuTree> menuTreeList = all.stream()
                .map(MenuTree::new)
                .sorted(Comparator.comparingInt(MenuTree::getSort))
                .collect(Collectors.toList());
        String parent = parentId == null ? CommonConstants.MENU_TREE_ROOT_ID : parentId;
        return TreeUtil.build(menuTreeList, parent);
    }
}
