package com.pt.ptuser.vo;

import com.baomidou.mybatisplus.annotation.TableLogic;

/**
 * @author wl
 */
public class UserVo {
    private String userId;

    private String deptId;

    private String userName;

    private String nickName;

    private String password;

    private String email;

    private String phone;

    private char sex;

    private String avatar;

    private char status;

    private String deptName;

    /**
     * 0-正常，1-删除
     */
    @TableLogic
    private String delFlag;

}
