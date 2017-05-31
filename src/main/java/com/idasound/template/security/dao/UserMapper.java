/*
 * Powered By idasound
 * Web Site: http://www.idasound.com
 * Since 2016 - 2017
 */

package com.idasound.template.security.dao;
import com.idasound.template.security.model.TbsUser;

public interface UserMapper{
	
	 /**
     * 通过用户名查询用户信息
     * @param authUser
     * @return
     */
	 public TbsUser getUserInfoByName(String name);
}
