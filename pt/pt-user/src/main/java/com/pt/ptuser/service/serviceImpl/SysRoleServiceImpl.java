package com.pt.ptuser.service.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.pt.ptuser.mapper.SysRoleMapper;
import com.pt.ptuser.entity.SysRole;
import com.pt.ptuser.service.SysRoleService;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Override
    public List<SysRole> findRolesByUserId(String UserId, String clientId) {
        return baseMapper.listRolesByUserId(UserId,clientId);
    }

    /**
     * 查询所有角色
     *
     * @return 角色列表
     */
    @Override
    public List<SysRole> selectRoleAll()
    {
        return selectRoleList(new SysRole());
    }

    /**
     * 根据条件查询角色数据
     *
     * @param role 角色信息
     * @return 角色数据集合信息
     */
    @Override
    public List<SysRole> selectRoleList(SysRole role)
    {
        return baseMapper.selectRoleList(role);
    }

    /**
     * 根据角色名获取角色
     * @param roleCode
     * @return
     */
    @Override
    public SysRole getByRoleCode(String roleCode) {
        return baseMapper.getByRoleCode(roleCode);
    }

    @Override
    public IPage<List<SysRole>> getRolePage(Page page, SysRole sysRole) {
        return baseMapper.getRolePage(page,sysRole);
    }

    /**
     * 根据id获取角色
     * @param roleId
     * @return
     */
    @Override
    public SysRole selectRoleById(String roleId) {
        return baseMapper.selectRoleById(roleId);
    }
}
