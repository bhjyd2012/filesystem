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
@RequestMapping("/role")
public class RoleController {
	/**   
	 * @Title: getPowerUserList   
	 * @Description: TODO(查询所有角色)   
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	@GetMapping("/rolelist")
	public String getPowerRoleList() {
		
		 return "power/role/list";
	}
}

