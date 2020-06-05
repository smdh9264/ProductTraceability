package com.pt.ptdealeruser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pt.ptdealeruser.dto.UserInfo;
import com.pt.ptdealeruser.entity.SysUser;

public interface SysUserService extends IService<SysUser> {

   UserInfo findUserByUsername(SysUser sysUser);

}
