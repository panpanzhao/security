/*
 * Powered By idasound
 * Web Site: http://www.idasound.com
 * Since 2016 - 2017
 */

package com.idasound.template.security.dao;
import java.util.List;

import com.idasound.template.security.model.TbsMenu;

public interface MenuMapper{
	
	/**
	  * 通过用户名称查对应权限
	  * @param userId
	  * @return
	  */
	 public List<TbsMenu> getMenuByUserName(String userName);
}
