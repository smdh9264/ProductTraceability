package com.pt.ptuser.service.serviceImpl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pt.ptcommon.constant.CommonConstants;
import com.pt.ptcommon.dto.MenuTree;
import com.pt.ptcommon.dto.MenuVO;
import com.pt.ptcommon.util.TreeUtil;
import com.pt.ptuser.dto.TreeSelect;
import com.pt.ptuser.entity.SysRoleMenu;
import com.pt.ptuser.service.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.pt.ptuser.mapper.SysMenuMapper;
import com.pt.ptuser.entity.SysMenu;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wl
 */
@Slf4j
@Service
@AllArgsConstructor
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    private SysRoleMenuService sysRoleMenuService;

    private SysRoleService sysRoleService;

    private SysUserRoleService sysUserRoleService;

    /**
     * 根据角色获取权限
     * @param roleId
     * @return
     */
    @Override
    public List<String> findPermissionsByRoleId(String roleId,String clientId) {
        List<SysRoleMenu> sysRoleMenuList = sysRoleMenuService.listRoleMenu(roleId,clientId);
        List<String> permissionsList = new ArrayList<>();
        sysRoleMenuList.stream().forEach(dealerRoleMenu -> {
            String perms = baseMapper.getMenuById(dealerRoleMenu.getMenuId(),clientId).getPerms();
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
    public List<SysMenu> findRoutesByRole(String role) {
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

    /**
     * 根据用户查询系统菜单列表
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    @Override
    public List<SysMenu> selectMenuList(String userId)
    {
        return selectMenuList(new SysMenu(), userId);
    }
    /**
     * 查询系统菜单列表
     *
     * @param menu 菜单信息
     * @return 菜单列表
     */
    @Override
    public List<SysMenu> selectMenuList(SysMenu menu, String userId)
    {
        List<SysMenu> menuList = null;
        Boolean isAdmin = sysUserRoleService.isAdmin(userId, sysRoleService
                .getByRoleCode(CommonConstants.ROLE_ADMIN).getRoleId());
        // 管理员显示所有菜单信息
        if (isAdmin)
        {
            menuList = baseMapper.selectMenuList(menu);
        }
        else
        {
            menu.getParams().put("userId", userId);
            menuList = baseMapper.selectMenuListByUserId(menu);
        }
        return menuList;
    }

    /**
     * 根据角色ID查询菜单树信息
     *
     * @param roleId 角色ID
     * @return 选中菜单列表
     */
    @Override
    public List<String> selectMenuListByRoleId(String roleId)
    {
        return baseMapper.selectMenuListByRoleId(roleId);
    }

    /**
     * 构建前端所需要下拉树结构
     *
     * @param menus 菜单列表
     * @return 下拉树结构列表
     */
    @Override
    public List<TreeSelect> buildMenuTreeSelect(List<SysMenu> menus)
    {
        List<SysMenu> menuTrees = buildMenuTree(menus);
        return menuTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
    }
    /**
     * 构建前端所需要树结构
     *
     * @param menus 菜单列表
     * @return 树结构列表
     */
    @Override
    public List<SysMenu> buildMenuTree(List<SysMenu> menus)
    {
        List<SysMenu> returnList = new ArrayList<SysMenu>();
        for (Iterator<SysMenu> iterator = menus.iterator(); iterator.hasNext();)
        {
            SysMenu t = (SysMenu) iterator.next();
            // 根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (t.getParentId().equals(CommonConstants.TREE_ROOT) )
            {
                recursionFn(menus, t);
                returnList.add(t);
            }
        }
        if (returnList.isEmpty())
        {
            returnList = menus;
        }
        return returnList;
    }
    /**
     * 递归列表
     *
     * @param list
     * @param t
     */
    private void recursionFn(List<SysMenu> list, SysMenu t)
    {
        // 得到子节点列表
        List<SysMenu> childList = getChildList(list, t);
        t.setChildren(childList);
        for (SysMenu tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                // 判断是否有子节点
                Iterator<SysMenu> it = childList.iterator();
                while (it.hasNext())
                {
                    SysMenu n = (SysMenu) it.next();
                    recursionFn(list, n);
                }
            }
        }
    }
    /**
     * 得到子节点列表
     */
    private List<SysMenu> getChildList(List<SysMenu> list, SysMenu t)
    {
        List<SysMenu> tlist = new ArrayList<SysMenu>();
        Iterator<SysMenu> it = list.iterator();
        while (it.hasNext())
        {
            SysMenu n = (SysMenu) it.next();
            if (n.getParentId().equals(t.getMenuId()))
            {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<SysMenu> list, SysMenu t)
    {
        return getChildList(list, t).size() > 0 ? true : false;
    }
}
