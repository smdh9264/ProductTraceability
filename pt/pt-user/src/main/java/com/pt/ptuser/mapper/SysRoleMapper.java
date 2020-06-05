package com.pt.ptuser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pt.ptuser.entity.SysRole;
import com.pt.ptuser.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    List<SysRole> listRolesByUserId(@Param("userId") String userId, @Param("clientId") String clientId);

    SysRole getByRoleCode(@Param("roleCode") String roleCode);

    /**
     * 根据条件查询角色数据
     *
     * @param role 角色信息
     * @return 角色数据集合信息
     */
    List<SysRole> selectRoleList(SysRole role);

    /**
     * 分页获取角色
     * @param page 分页参数
     * @param sysRole 角色实体
     * @return
     */
    IPage<List<SysRole>> getRolePage(Page page, SysRole sysRole);

    /**
     * 根据id获取角色
     * @param roleId
     * @return
     */
    SysRole selectRoleById(@Param("roleId") String roleId);

}