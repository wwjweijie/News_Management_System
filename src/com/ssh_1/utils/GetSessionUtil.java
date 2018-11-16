package com.ssh_1.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 获取session实例
 * @author wwj
 *
 */
public class GetSessionUtil{
	
	private static final Configuration config;
	private static final SessionFactory sessionFactory;
	private static final Session session;
	
	// 静态代码块实现 
	static{
		// 加载核心配置文件
		config = new Configuration().configure();
		sessionFactory = config.buildSessionFactory();
		session = sessionFactory.openSession();
	}
	
	// 提供方法返回session
	public static Session getSession(){
		return session;
	}
	
	public static void main(String[] args){
	}
}
