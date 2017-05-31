package com.idasound.template.security.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.idasound.template.security.dto.JsonTreeDTO;
import com.idasound.template.security.model.TbsMenu;
import com.idasound.template.security.service.MenuService;

/**
 * 首页布局
 * 
 * @author panpanzhao
 * 
 */
@Controller
public class LoginController {
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
    	if (subject.isAuthenticated()) {
    		subject.logout();
    	}
		return "login";
	}
	@RequestMapping(value ="/login", method = RequestMethod.POST)
	public  void onSubmit(@RequestParam("username") String username,
	                          @RequestParam("password") String password,
	                          ModelMap model,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
	    UsernamePasswordToken token = new UsernamePasswordToken(username, password);
	    JSONObject jsonObject=new JSONObject();
	    boolean success=true;
	    try {
	        SecurityUtils.getSubject().login(token);
	        SavedRequest savedRequest = WebUtils.getSavedRequest(request);
	        if(savedRequest!=null){
	        	
	        	jsonObject.put("loginMsg", savedRequest);
	        }
	    } catch (UnknownAccountException uae) { 
	    	success=false;
	    	jsonObject.put("message", "用户不存在");
	    } catch (IncorrectCredentialsException ice) { 
	    	success=false;
	    	jsonObject.put("message", "密码错误");
	    } catch (LockedAccountException lae) { 
	    	success=false;
	    	jsonObject.put("message", "用户被锁定");
	    }catch (AuthenticationException e) {
	    	success=false;
	    	jsonObject.put("message", "登陆失败");
	    }catch (Exception e) {
	    	success=false;
	    	jsonObject.put("message", "登陆失败");
	    }
	    jsonObject.put("success", success);
		PrintWriter write = response.getWriter();
		write.write(jsonObject.toString());
		write.flush();
		write.close();
	}
	
	/**
	 * 查询
	 * @return
	 */
	@RequestMapping(value = "/left/menu/tree")
	public void tree(HttpServletRequest request, HttpServletResponse response)throws Exception {
		List<JsonTreeDTO> tree=getGoodsSpec();
		PrintWriter write = response.getWriter();
		write.write(JSONArray.fromObject(tree).toString());
		write.flush();
		write.close();
	}
	private List<JsonTreeDTO> getGoodsSpec() {
		Subject subject=SecurityUtils.getSubject();
		List<TbsMenu> tbsMenu=menuService.getMenuByUserName(subject.getPrincipal().toString());
        List<JsonTreeDTO> treeDataList = new ArrayList<JsonTreeDTO>();
         /*为了整理成公用的方法，所以将查询结果进行二次转换。
          * 其中specid为主键ID，varchar类型UUID生成
          * parentid为父ID
          * specname为节点名称
          * */
        for (TbsMenu menu : tbsMenu) {
            JsonTreeDTO treeData = new JsonTreeDTO();
            treeData.setId(menu.getId());
            treeData.setPid(menu.getParentId());
            treeData.setText(menu.getMenuName());
            if(!"".equals(menu.getMenuUrl())&&menu.getMenuUrl()!=null){
            	JsonTreeDTO.Attributes attributes=new JsonTreeDTO.Attributes();
            	attributes.setUrl(menu.getMenuUrl());
            	treeData.setAttributes(attributes);            	
            }
            treeDataList.add(treeData);
        }
        //最后得到结果集,经过FirstJSON转换后就可得所需的json格式
        List<JsonTreeDTO> newTreeDataList = getfatherNode(treeDataList);
        return newTreeDataList;
    }
	
    /**
    * @Title: getfatherNode
    * @Description 方法描述: 父节点
    * @param 设定文件： @param treeDataList
    * @param 设定文件： @return    
    * @return 返回类型：List<JsonTreeDTO>    
    * @throws
    * @date 最后修改时间：2015年6月9日 下午6:39:26
    */
    private final static List<JsonTreeDTO> getfatherNode(List<JsonTreeDTO> treeDataList) {
        List<JsonTreeDTO> newTreeDataList = new ArrayList<JsonTreeDTO>();
        for (JsonTreeDTO jsonTreeDTO : treeDataList) {
            if(jsonTreeDTO.getPid() == null||jsonTreeDTO.getPid().equals("")) {
                //获取父节点下的子节点
                jsonTreeDTO.setChildren(getChildrenNode(jsonTreeDTO.getId(),treeDataList));
                jsonTreeDTO.setState("closed");
                newTreeDataList.add(jsonTreeDTO);
            }
        }
        return newTreeDataList;
    }
     
    /**
    * @Title: getChildrenNode
    * @Description 方法描述: 子节点
    * @param 设定文件： @param pid
    * @param 设定文件： @param treeDataList
    * @param 设定文件： @return    
    * @return 返回类型：List<JsonTreeDTO>    
    * @throws
    * @date 最后修改时间：2015年6月9日 下午6:39:50
    */
    private final static List<JsonTreeDTO> getChildrenNode(String pid , List<JsonTreeDTO> treeDataList) {
        List<JsonTreeDTO> newTreeDataList = new ArrayList<JsonTreeDTO>();
        for (JsonTreeDTO jsonTreeDTO : treeDataList) {
            if(jsonTreeDTO.getPid() == null||jsonTreeDTO.getPid().equals(""))  continue;
            //这是一个子节点
            if(jsonTreeDTO.getPid().equals(pid)){
                //递归获取子节点下的子节点
                jsonTreeDTO.setChildren(getChildrenNode(jsonTreeDTO.getId() , treeDataList));
                newTreeDataList.add(jsonTreeDTO);
            }
        }
        return newTreeDataList;
    }
}
