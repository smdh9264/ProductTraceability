package com.pt.ptuser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pt.ptuser.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wl
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
    /**
     * 根据
     * @param userId
     * @param roleId
     * @return
     */
    List<SysUserRole> getUserRoleList(@Param("userId") String userId,@Param("roleId") String roleId);
}