package com.pt.ptuser.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pt.ptcommon.constant.CommonConstants;
import com.pt.ptcommon.security.CustomUser;
import com.pt.ptcommon.util.R;

import com.pt.ptcommon.util.SecurityUtils;
import com.pt.ptuser.dto.UserInfo;
import com.pt.ptuser.entity.SysUser;
import com.pt.ptuser.service.SysRoleService;
import com.pt.ptuser.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * auth获取用户信息
     * @param username
     * @return
     */
    @GetMapping("/info/{username}")
    private UserInfo findUserByUsername(@PathVariable String username,@RequestParam String clientId){
        return  sysUserService.findUserByUsername(username,clientId);
    }

    /**
     * 根据token获取当前用户信息
     * @return 用户信息
     */
    @GetMapping(value = {"/info"})
    public R info() {
        CustomUser user = SecurityUtils.getUser();
        return R.ok(sysUserService.findUserByUsername(user.getUsername(),user.getClientId()));
    }
    /**
     * 分页查询全部用户
     *
     * @param page    参数集
     * @return 用户集合
     */
    @GetMapping("/page")
    public R getAllUserPage(Page page) {
        CustomUser user = SecurityUtils.getUser();
        return R.ok(sysUserService.getAllUserWithRolePage(page,user.getClientId()));
    }

    /**
     * 分页查询本部门用户
     *
     * @param page    参数集
     * @return 用户集合
     */
    @GetMapping("/dept")
    public R getDeptUserPage(Page page) {
        CustomUser user = SecurityUtils.getUser();
        return R.ok(sysUserService.getDeptUserWithRolePage(page,user.getClientId(),user.getDeptId()));
    }

    /**
     * 根据用户编号获取详细信息
     */
    @GetMapping(value = { "/", "/{userId}" })
    public R getInfo(@PathVariable(value = "userId", required = false) String userId)
    {
        Map result = new HashMap<String, List<String>>();
        result.put("roles", sysRoleService.selectRoleAll());
//        result.put("posts", postService.selectPostAll());
        if (StrUtil.isNotEmpty(userId))
        {
//            ajax.put(AjaxResult.DATA_TAG, userService.selectUserById(userId));
//            ajax.put("postIds", postService.selectPostListByUserId(userId));
//            ajax.put("roleIds", roleService.selectRoleListByUserId(userId));
        }
        return R.ok(result);
    }

    /**
     * 状态修改
     */
    @PutMapping("/changeStatus")
    public R changeStatus(@RequestBody SysUser user)
    {
        if(sysUserService.checkUserAllowed(user)){
            return R.ok(sysUserService.updateUserStatus(user));
        }else {
            return R.failed();
        }

    }

    /**
     * 获取初始密码
     * @return
     */
    @GetMapping("/initPwd")
    public R getInitPassword(){
        return R.ok(CommonConstants.INIT_PASSWORD);
    }
}
