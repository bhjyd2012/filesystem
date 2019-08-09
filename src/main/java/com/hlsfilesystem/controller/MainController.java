package com.hlsfilesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hlsfilesystem.bean.Usertb;
import com.hlsfilesystem.service.UsertbService;

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
		System.out.println("进入登录请求");
		 return "login";
	}
	
	
	
}
