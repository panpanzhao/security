package com.idasound.template.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idasound.template.security.dao.MenuMapper;
import com.idasound.template.security.model.TbsMenu;
import com.idasound.template.security.service.MenuService;


@Service("menuService")
public class MenuServiceImpl implements MenuService{
	@Autowired
	private MenuMapper menuMapper;
	/**
	  * 通过用户名称查对应权限
	  * @param userId
	  * @return
	  */
	 public List<TbsMenu> getMenuByUserName(String userName){
		 return menuMapper.getMenuByUserName(userName);
	 }
}