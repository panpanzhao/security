package com.idasound.template.layout;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页布局
 * 
 * @author panpanzhao
 * 
 */
@Controller
@RequestMapping("/layoutController")
public class LayoutController {
	@RequestMapping(params = "top")
	public String top(Model model) {
		return "/layout/top";
	}
	@RequestMapping(params = "bottom")
	public String bottom() {
		return "/layout/bottom";
	}
	@RequestMapping(params = "center")
	public String center() {
		return "/layout/center";
	}
	
	@RequestMapping(params = "home")
	public String home() {
		return "/layout/home";
	}
	
	@RequestMapping(params = "left")
	public String left() {
		return "/layout/left";
	}
}
