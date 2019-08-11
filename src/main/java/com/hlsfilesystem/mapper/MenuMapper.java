package com.hlsfilesystem.mapper;

import com.hlsfilesystem.bean.Menu;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hucheng
 * @since 2019-08-08
 */
public interface MenuMapper extends BaseMapper<Menu> {
    //根据角色id获取菜单
	public List<Menu> getmenusbyrid(int roleid);
}
