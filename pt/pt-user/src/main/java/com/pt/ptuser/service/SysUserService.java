package com.pt.ptuser.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pt.ptuser.dto.UserInfo;
import com.pt.ptuser.entity.SysUser;

public interface SysUserService extends IService<SysUser> {


   UserInfo findUserByUsername(String username,String clientId);

   /**
    * 分页查询部门用户信息（含有角色信息）
    *
    * @param page    分页对象
    * @param clientId 客户端ID
    * @return
    */
   IPage getDeptUserWithRolePage(Page page,String clientId,String deptId);

   /**
    * 分页查询所有用户信息（含有角色信息）
    *
    * @param page    分页对象
    * @param clientId 客户端ID
    * @return
    */
   IPage getAllUserWithRolePage(Page page,String clientId);

   /**
    * 根据id查找用户
    * @param userId
    * @return
    */
   SysUser getByUserId(String userId);

   /**
    * 校验用户是否允许操作
    *
    * @param user 用户信息
    */
   Boolean checkUserAllowed(SysUser user);
   /**
    * 修改用户状态
    *
    * @param user 用户信息
    * @return 结果
    */
   Boolean updateUserStatus(SysUser user);
}
