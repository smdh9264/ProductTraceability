package com.pt.ptcenteruser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pt.ptcenteruser.dto.UserInfo;
import com.pt.ptcenteruser.entity.SysUser;

public interface SysUserService extends IService<SysUser> {

   UserInfo findUserByUsername(SysUser sysUser);

}
