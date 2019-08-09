package com.hlsfilesystem.mapper;

import com.hlsfilesystem.bean.Usertb;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hucheng
 * @since 2019-08-08
 */
public interface UsertbMapper extends BaseMapper<Usertb> {
     //根据名字查询登录用户信息
	 public Usertb getUserByName(String username);
}
