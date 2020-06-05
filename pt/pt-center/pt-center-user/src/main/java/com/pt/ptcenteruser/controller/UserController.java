package com.pt.ptcenteruser.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import com.pt.ptcenteruser.dto.UserInfo;
import com.pt.ptcenteruser.entity.SysUser;
import com.pt.ptcenteruser.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/user")
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

    @GetMapping("/info/{username}")
    private ResponseEntity<UserInfo> getUserInfo(@PathVariable String username){
        SysUser sysUser = sysUserService.getOne(Wrappers.<SysUser>query()
                .lambda().eq(SysUser::getUsername, username));
//        if (sysUser == null) {
//            return R.failed(String.format("用户信息为空 %s", username));
//        }
        return ResponseEntity.ok(sysUserService.findUserByUsername(sysUser));
    }

    @GetMapping("/check/{username}")
    private UserInfo findUserByUsername(@PathVariable String username){
        SysUser sysUser = sysUserService.getOne(Wrappers.<SysUser>query()
                .lambda().eq(SysUser::getUsername, username));
//        if (sysUser == null) {
//            return R.failed(String.format("用户信息为空 %s", username));
//        }
        return sysUserService.findUserByUsername(sysUser);
    }
}
