package com.pt.ptuser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pt.ptuser.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    List<SysRoleMenu> listRoleMenu(@Param("roleId") String roleId,@Param("clientId") String clientId);
}