package com.idasound.template.security.security;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SecurityController {    

	/**
	 * 进入页面权限
	 * @param jp
	 * @throws Throwable 
	 */
    public Object  aroundList(ProceedingJoinPoint pjp) throws Throwable {
    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    	String securityUrl=request.getServletPath();
    	if(securityUrl!=null&&!SecurityUtils.getSubject().isPermitted(securityUrl)){
    		return "common/error/403";
    	}
    	return pjp.proceed();
    }
    /**
     * 操作功能权限
     * @param jp
     * @throws Throwable 
     */
    public void aroundAjax(ProceedingJoinPoint pjp) throws Throwable{
//    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//    	HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
//    	String securityUrl=request.getServletPath();
//    	if(securityUrl!=null&&!SecurityUtils.getSubject().isPermitted(securityUrl)){
//    		System.out.println("没有权限");
//    		PrintWriter write = null;
//    		try {
//    			write = response.getWriter();
//    			write.write("ERROR");
//    		} catch (IOException e) {
// 
//    		}finally{
//    			write.flush();
//    			write.close();			
//    		}
//    		return;
//    	}
    	pjp.proceed();
		
    }
}
