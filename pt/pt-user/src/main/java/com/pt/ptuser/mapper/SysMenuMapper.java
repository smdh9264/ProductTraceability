package com.pt.ptuser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pt.ptcommon.dto.MenuVO;
import com.pt.ptuser.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    /**
     * 按角色获取路由
     * @param role
     * @return
     */
    List<SysMenu> listRoutesByRole(@Param("role") String role);
    /**
     * 按角色获取菜单
     * @param role
     * @return
     */
    List<MenuVO> listMenuByRole(@Param("role") String role);

    SysMenu getMenuById(@Param("menuId") String menuId,@Param("clientId") String clientId);

    /**
     * 查询系统菜单列表
     *
     * @param menu 菜单信息
     * @return 菜单列表
     */
    List<SysMenu> selectMenuList(SysMenu menu);

    /**
     * 根据用户查询系统菜单列表
     *
     * @param menu 菜单信息
     * @return 菜单列表
     */
    List<SysMenu> selectMenuListByUserId(SysMenu menu);

    List<String> selectMenuListByRoleId(@Param("roleId") String roleId);
}