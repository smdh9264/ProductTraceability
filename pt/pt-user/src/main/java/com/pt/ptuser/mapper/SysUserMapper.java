package com.pt.ptuser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pt.ptuser.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 根据账号与客户端查找用户
     * @param username 账号
     * @param clientId 客户端
     * @return
     */
    SysUser findUserByUsername(@Param("username") String username,@Param("clientId") String clientId);

    /**
     * 分页获取本部门全部用户
     * @param page 分页参数
     * @param clientId
     * @param deptId
     * @return
     */
    IPage<List<SysUser>> getDeptUserPage(Page page,@Param("clientId") String clientId,@Param("deptId") String deptId);

    /**
     * 分页获取全部用户
     * @param page 分页参数
     * @param clientId
     * @return
     */
    IPage<List<SysUser>> getAllUserPage(Page page,@Param("clientId") String clientId);

    /**
     * 根据id查找用户
     * @param userId
     * @return
     */
    SysUser getByUserId(@Param("userId") String userId);

    /**
     * 修改用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
     Boolean updateUser(SysUser user);
}