package com.hlsfilesystem.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hlsfilesystem.bean.Usertb;
import com.hlsfilesystem.service.UsertbService;

/**   
 * @ClassName:  MainController   
 * @Description:TODO(首页/登录页访问跳转)   
 * @author: hucheng 
 * @date:   2019年8月9日 下午3:34:39       
 * @Copyright: 2019 www.xxxx.com Inc. All rights reserved. 
 * 注意：本内容仅限于xxxxxxxxx传阅，禁止外泄以及用于其他的商业目
*/  
@Controller
public class MainController {
	@Autowired
	private UsertbService usertbService;
	
	
	@GetMapping("/")
	public String gethome() {
		return "login";
	}
	@GetMapping("/head")
	public String gethead() {
		return "head";
	}
	@GetMapping("/left")
	public String getleft() {
		return "left";
	}
	@GetMapping("/right")
	public String getright() {
		return "right";
	}
	@GetMapping("/index")
	public String getindex() {
		System.out.println("进入index");
		 return "index";
	}
	@RequestMapping("/login")
	public String getlogin(String username,String password,ModelMap model) {
		System.out.println("进入login");
		 return "login";
	}
	
	
	
}
