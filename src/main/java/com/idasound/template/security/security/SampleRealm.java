package com.idasound.template.security.security;



import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.idasound.template.security.model.TbsMenu;
import com.idasound.template.security.model.TbsUser;
import com.idasound.template.security.service.SecurityService;

@Component
public class SampleRealm extends AuthorizingRealm {
	@Autowired
	private SecurityService securityService;
	
    public SampleRealm() {
        setName("SampleRealm"); //This name must match the name in the User class's getPrincipals() method
    }
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        TbsUser user = securityService.getUserInfoByName(token.getUsername());
        if(user==null){
        	throw new UnknownAccountException();
        }
        Session session= SecurityUtils.getSubject().getSession();
        session.setAttribute("userInfo", user);
        //String passWord=new SimpleHash("MD5", "密码","密钥", 2).toString();//获取加密密码
        SimpleAuthenticationInfo info= new SimpleAuthenticationInfo(user.getUserName(), user.getPasspword(), getName());
        info.setCredentialsSalt(ByteSource.Util.bytes(""+user.getUserName()));//添加密钥
        return info;
    }


    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	Session session= SecurityUtils.getSubject().getSession();
    	if(session.getAttribute("permission")==null){
        	SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    		String userName = (String) principals.fromRealm(getName()).iterator().next();
    		List<TbsMenu> menuList=securityService.getMenuByUserName(userName);
    		for( TbsMenu menu : menuList) {
    			if(menu.getMenuUrl()!=null){
    				info.addStringPermission(menu.getMenuUrl());
    			}
    		}
    		session.setAttribute("permission", info);
    		return info;
    	}
        return (AuthorizationInfo) session.getAttribute("permission");
    }

}

