package com.ssh_1.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ssh_1.entity.User;

/**
 * 用户处理实现类
 * @author wwj
 *
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	/*
	 * 用户登录的方法
	 */
	@Override
	public User findOne(User user) {
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where username=? and password=?",
				user.getUsername(), user.getPassword());
		User exitUser = list.get(0);
		return exitUser;
	}

	/*
	 * 用户注册的方法
	 */
	@Override
	public void register(User user) {
		this.getHibernateTemplate().save(user);
	}

}
