package com.pt.ptuser.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pt.ptcommon.util.R;
import com.pt.ptuser.entity.SysRole;
import com.pt.ptuser.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wl
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 分页获取角色列表
     * @param page 分页参数
     * @param role
     * @return
     */
    @GetMapping("/page")
    public R list(Page page, SysRole role)
    {
        return R.ok(sysRoleService.getRolePage(page,role));
    }

    /**
     * 根据角色编号获取详细信息
     */
    @GetMapping(value = "/{roleId}")
    public R getInfo(@PathVariable String roleId)
    {
        return R.ok(sysRoleService.selectRoleById(roleId));
    }
}
