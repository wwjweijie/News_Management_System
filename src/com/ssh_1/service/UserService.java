package com.ssh_1.service;

import org.springframework.transaction.annotation.Transactional;

import com.ssh_1.dao.UserDao;
import com.ssh_1.entity.User;

/**
 * 用户处理业务逻辑类
 * @author wwj
 *
 */
@Transactional
public class UserService {
	//注册userDao
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/*
	 * 用户登陆的方法
	 */
	public User findOne(User user) {
		User user2 = userDao.findOne(user);
		return user2;
	}

	/*
	 * 用户注册的方法
	 */
	public void register(User user) {
		//设置用户类型为普通用户
		user.setUtype(1);
		userDao.register(user);
	}
}
