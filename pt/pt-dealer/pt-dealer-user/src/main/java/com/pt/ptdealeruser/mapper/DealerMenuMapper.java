package com.pt.ptdealeruser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pt.ptcommon.dto.MenuVO;
import com.pt.ptdealeruser.entity.DealerMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DealerMenuMapper extends BaseMapper<DealerMenu> {
    /**
     * 按角色获取路由
     * @param role
     * @return
     */
    List<DealerMenu> listRoutesByRole(@Param("role") String role);
    /**
     * 按角色获取菜单
     * @param role
     * @return
     */
    List<MenuVO> listMenuByRole(@Param("role") String role);
}