package com.idasound.template.security.service;


import java.util.List;

import com.idasound.template.security.model.TbsMenu;
import com.idasound.template.security.model.TbsUser;


public interface SecurityService{
	/**
     * 通过用户名查询用户信息
     * @param authUser
     * @return
     */
	 public TbsUser getUserInfoByName(String name);
	/**
	  * 通过用户名称查对应权限
	  * @param userId
	  * @return
	  */
	 public List<TbsMenu> getMenuByUserName(String userName);
}

