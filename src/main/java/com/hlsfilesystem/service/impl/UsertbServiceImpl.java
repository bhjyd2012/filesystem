package com.hlsfilesystem.service.impl;

import com.hlsfilesystem.bean.Usertb;
import com.hlsfilesystem.mapper.UsertbMapper;
import com.hlsfilesystem.service.UsertbService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	@Override
	public Usertb getUserByName(String username) {
		Usertb user = usertbMapper.getUserByName(username);
		return user;
	}

}
