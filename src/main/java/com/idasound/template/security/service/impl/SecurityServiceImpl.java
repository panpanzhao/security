package com.idasound.template.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idasound.template.security.dao.MenuMapper;
import com.idasound.template.security.dao.UserMapper;
import com.idasound.template.security.model.TbsMenu;
import com.idasound.template.security.model.TbsUser;
import com.idasound.template.security.service.SecurityService;


@Service("securityService")
public class SecurityServiceImpl implements SecurityService{
	@Autowired
	private UserMapper userMapper;
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

	/**
	 * 通过姓名获取信息
	 */
	public TbsUser getUserInfoByName(String name) {
		return userMapper.getUserInfoByName(name);
	}
}