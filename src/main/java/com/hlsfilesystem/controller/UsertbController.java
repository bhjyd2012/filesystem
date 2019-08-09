package com.hlsfilesystem.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hucheng
 * @since 2019-08-08
 */
@Controller
@RequestMapping("/usertb")
public class UsertbController {
	@GetMapping("/userlist")
	public String getPowerUserList() {
		System.out.println("进入index");
		 return "power/user/list";
	}
}

