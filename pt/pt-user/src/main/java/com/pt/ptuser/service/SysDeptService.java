package com.pt.ptuser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pt.ptuser.dto.TreeSelect;
import com.pt.ptuser.entity.SysDept;

import java.util.List;

public interface SysDeptService extends IService<SysDept> {

    /**
     * 获取下级部门列表
     * @param sysDept 部门
     * @return
     */
    List<SysDept> selectDeptList( SysDept sysDept);

    /**
     * 构建前端所需要下拉树结构
     *
     * @param depts 部门列表
     * @return 下拉树结构列表
     */
    public List<TreeSelect> buildDeptTreeSelect(List<SysDept> depts);
}
