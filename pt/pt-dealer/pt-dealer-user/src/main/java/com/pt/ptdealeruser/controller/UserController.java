package com.pt.ptdealeruser.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.pt.ptcommon.util.R;

import com.pt.ptcommon.util.SecurityUtils;
import com.pt.ptdealeruser.dto.UserInfo;
import com.pt.ptdealeruser.entity.SysUser;
import com.pt.ptdealeruser.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/test")
    public String test(){
        SysUser sysUser = sysUserService.getOne(Wrappers.<SysUser>query()
                .lambda().eq(SysUser::getUsername, "admin"));
        sysUserService.findUserByUsername(sysUser);
        return "1";
    }

    /**
     * auth获取用户信息
     * @param username
     * @return
     */
    @GetMapping("/info/{username}")
    private UserInfo findUserByUsername(@PathVariable String username){
        SysUser sysUser = sysUserService.getOne(Wrappers.<SysUser>query()
                .lambda().eq(SysUser::getUsername, username));
        return sysUserService.findUserByUsername(sysUser);
    }

    /**
     * 根据token获取当前用户信息
     * @return 用户信息
     */
    @GetMapping(value = {"/info"})
    public R info() {
        String username = SecurityUtils.getUser().getUsername();
        SysUser user = sysUserService.getOne(Wrappers.<SysUser>query()
                .lambda().eq(SysUser::getUsername, username));
        if (user == null) {
            return R.failed("获取当前用户信息失败");
        }
        return R.ok(sysUserService.findUserByUsername(user));
    }


}
