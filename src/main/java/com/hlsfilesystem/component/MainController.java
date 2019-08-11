package com.hlsfilesystem.component;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
		return "index";
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
	public String getindex(HttpServletRequest request,HttpSession session) {
		System.out.println("进入index");
		String username = request.getRemoteUser();
		System.out.println(username);
		if (username!=null) {			
			Usertb user = usertbService.getUserByName("admin");
			user.setLogincount(user.getLogincount()+1);
			boolean b = usertbService.updateById(user);
			System.err.println(b+"=============");
			System.out.println(user);
			session.setAttribute("user", user);
			session.setAttribute("logintime", new Date());
			System.out.println(new Date());
		}
		
		
		 return "index";
	}
	@RequestMapping("/login")
	public String getlogin() {
		System.out.println("进入login");
		 return "login";
	}
	
	
	
}
