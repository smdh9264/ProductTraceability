package com.pt.ptcenteruser.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pt.ptcenteruser.entity.CenterRole;
import com.pt.ptcenteruser.mapper.CenterRoleMapper;
import com.pt.ptcenteruser.service.CenterRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenterRoleServiceImpl extends ServiceImpl<CenterRoleMapper, CenterRole> implements CenterRoleService {
    @Override
    public List<CenterRole> findRolesByUserId(String UserId) {
        return baseMapper.listRolesByUserId(UserId);
    }
}
