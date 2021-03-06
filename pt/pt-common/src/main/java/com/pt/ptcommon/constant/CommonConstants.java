package com.pt.ptcommon.constant;

import java.util.Arrays;
import java.util.List;

/**
 * @author wl
 * @date 2020/5/11
 */
public interface CommonConstants {
	/**
	 * 删除
	 */
	String STATUS_DEL = "1";
	/**
	 * 正常
	 */
	String STATUS_NORMAL = "0";

	/**
	 * 锁定
	 */
	String STATUS_LOCK = "9";

	/**
	 * 菜单树根节点
	 */
	String MENU_TREE_ROOT_ID = "-1";

	/**
	 * 菜单
	 */
	String MENU = "0";

	/**
	 * 编码
	 */
	String UTF8 = "UTF-8";

	/**
	 * JSON 资源
	 */
	String CONTENT_TYPE = "application/json; charset=utf-8";

	/**
	 * 前端工程名
	 */
	String FRONT_END_PROJECT = "pig-ui";

	/**
	 * 后端工程名
	 */
	String BACK_END_PROJECT = "pig";

	/**
	 * 成功标记
	 */
	Integer SUCCESS = 0;
	/**
	 * 失败标记
	 */
	Integer FAIL = 1;

	/**
	 * 验证码前缀
	 */
	String DEFAULT_CODE_KEY = "DEFAULT_CODE_KEY_";

	/**
	 * 当前页
	 */
	String CURRENT = "current";

	/**
	 * size
	 */
	String SIZE = "size";

	/**
	 * 动态查询表
	 */
	List<String> DYNAMIC_TABLES = Arrays.asList("user","user_role", "dept","role","role_menu","role_dept","menu");
	/**
	 * admin
	 */
	String ROLE_ADMIN = "ADMIN";
	/**
	 * tree root
	 */
	String TREE_ROOT = "0";
	/**
	 * 初始密码
	 */
	String INIT_PASSWORD = "123456";
}
