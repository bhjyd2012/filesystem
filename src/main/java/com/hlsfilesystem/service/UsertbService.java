package com.hlsfilesystem.service;

import com.hlsfilesystem.bean.Usertb;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hucheng
 * @since 2019-08-08
 */
public interface UsertbService extends IService<Usertb> {
		//根据名字查询登录用户信息
		 public Usertb getUserByName(String username);
}
