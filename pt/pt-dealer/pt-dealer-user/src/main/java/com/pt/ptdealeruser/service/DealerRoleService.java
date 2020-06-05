package com.pt.ptdealeruser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pt.ptdealeruser.entity.DealerRole;

import java.util.List;

public interface DealerRoleService extends IService<DealerRole> {
    List<DealerRole> findRolesByUserId(String UserId);



}
