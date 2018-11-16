package com.ssh_1.dao;

import com.ssh_1.entity.User;

/**
 * 用户处理接口类
 * @author wwj
 *
 */
public interface UserDao {

	User findOne(User user);

	void register(User user);

}
