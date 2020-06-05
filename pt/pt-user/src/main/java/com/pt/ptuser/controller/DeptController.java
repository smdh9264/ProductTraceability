package com.pt.ptuser.controller;

import com.pt.ptcommon.util.R;
import com.pt.ptcommon.util.SecurityUtils;
import com.pt.ptuser.entity.SysDept;
import com.pt.ptuser.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private SysDeptService sysDeptService;
    /**
     * 获取部门下拉树列表
     */
    @GetMapping("/tree")
    public R treeselect(SysDept sysDept)
    {
        List<SysDept> depts = sysDeptService.selectDeptList(sysDept);
        return R.ok(sysDeptService.buildDeptTreeSelect(depts));
    }
    /**
     * 获取部门列表
     */
    @GetMapping("/list")
    public R list(SysDept dept)
    {
        List<SysDept> depts = sysDeptService.selectDeptList(dept);
        return R.ok(depts);
    }
}
