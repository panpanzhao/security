package com.idasound.template.security.service;


import java.util.List;

import com.idasound.template.security.model.TbsMenu;


public interface MenuService{
	/**
	  * 通过用户名称查对应权限
	  * @param userId
	  * @return
	  */
	 public List<TbsMenu> getMenuByUserName(String userName);
}

