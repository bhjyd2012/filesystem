package com.hlsfilesystem.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hlsfilesystem.bean.Usertb;
import com.hlsfilesystem.service.RoleService;
import com.hlsfilesystem.service.UsertbService;
import com.hlsfilesystem.utils.Pager;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

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
	@Autowired
	private UsertbService usertbService;
	@Autowired
	private RoleService roleService;

	/**   
	 * @Title: getPowerUserList   
	 * @Description: TODO(查询所有用户)   
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	@GetMapping("/userlist")
	public String getPowerUserList(
			@RequestParam(value = "index" , defaultValue = "1")Integer pageIndex,
			@RequestParam(value = "size" , defaultValue = "2")Integer pageSize,
			ModelMap model) {
		System.out.println(pageIndex+":"+pageSize);
		//分页工具
		Page<Usertb> page = new Page<Usertb>(pageIndex, pageSize);
		//符合条件查询出的结果集
		Page<Usertb> results = usertbService.selectPage(page,null);
		System.out.println(results);
		//获取总条数
		Integer totalCount = ((Long)results.getTotal()).intValue();
		System.out.println(totalCount);
		//获取总页数
		Integer pageCount = ((Long)results.getPages()).intValue();
		System.out.println(pageCount);
		 //查询到每页的数据集合
		 List<Usertb> usertbs = results.getRecords();
		 for (Usertb usertb : usertbs) {
			usertb.setRole(roleService.selectById(usertb.getRoleId()));
			System.out.println(usertb);
		  }
		 System.err.println(results);
		Pager<Usertb> pager = new Pager<Usertb>(pageIndex, pageSize, pageCount, totalCount, usertbs);
		
		model.put("pager",pager);
		model.put("size", pageSize);
		
		return "power/user/list";
	}
}

