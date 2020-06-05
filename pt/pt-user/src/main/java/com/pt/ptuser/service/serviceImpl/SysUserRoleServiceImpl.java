package com.pt.ptuser.service.serviceImpl;

import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pt.ptcommon.constant.CommonConstants;
import com.pt.ptuser.entity.SysUserRole;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.pt.ptuser.mapper.SysUserRoleMapper;
import com.pt.ptuser.service.SysUserRoleService;

import java.util.List;

@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService{

    @Override
    public List<SysUserRole> getListByUserId(String userId) {
        return baseMapper.getUserRoleList(userId,"");
    }

    @Override
    public Boolean isAdmin(String userId,String roleId) {
        return baseMapper.getUserRoleList(userId, roleId).size() != 0;
    }
}
