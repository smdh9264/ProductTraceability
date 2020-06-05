package com.pt.ptcenteruser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pt.ptcenteruser.entity.CenterRole;

import java.util.List;

public interface CenterRoleService extends IService<CenterRole> {
    List<CenterRole> findRolesByUserId(String UserId);


}
