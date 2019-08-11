package com.hlsfilesystem.service.impl;

import com.hlsfilesystem.bean.Menu;
import com.hlsfilesystem.bean.Usertb;
import com.hlsfilesystem.mapper.MenuMapper;
import com.hlsfilesystem.mapper.UsertbMapper;
import com.hlsfilesystem.service.RoleService;
import com.hlsfilesystem.service.UsertbService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hucheng
 * @since 2019-08-08
 */
@Service
public class UsertbServiceImpl extends ServiceImpl<UsertbMapper, Usertb> implements UsertbService {
	@Autowired
	private UsertbMapper usertbMapper;
	@Autowired
	private MenuMapper menuMapper;
	
	
	@Override
	@Transactional
	public Usertb getUserByName(String username) {
		Usertb user = usertbMapper.getUserByName(username);
		if (user!=null) {
			//根据角色查询菜单
			List<Menu> menus = menuMapper.getmenusbyrid(user.getRoleId());
			//分一、二级菜单
			//存一级菜单
			List oneMenuList = new ArrayList<Menu>();
			for (Menu menu : menus) {
				if (menu.getUpmenuid()==-1) {
					//upmenuid等于-1为一级菜单
					//存储一级菜单所对应的二级菜单集合
					List secondMenuList = new ArrayList();
					for (Menu second: menus) {
						if (second.getUpmenuid()==menu.getMenuid()) {
							//存储二级菜单
							secondMenuList.add(second);
						}
					}
					//建立一级菜单和二级菜单对象的关系
					menu.setSeconds(secondMenuList);
					oneMenuList.add(menu);
					
				}
			}
			
			
			user.getRole().setMenus(oneMenuList);
			return user;
		}
		return null;
	}
   
	@Override
	@Transactional
	public List<Usertb> getusers(){
		  return usertbMapper.getAllUserTb();
	}

	

	
	
	
	
	
	

}
