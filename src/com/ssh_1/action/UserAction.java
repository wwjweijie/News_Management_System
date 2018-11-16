package com.ssh_1.action;

import java.util.regex.Pattern;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh_1.entity.User;
import com.ssh_1.service.UserService;

/**
 * 用户动作类
 * @author wwj
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();

	@Override
	public User getModel() {
		return user;
	}

	// 注入userservice
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/*
	 * 用户登录的方法
	 */
	public String login() {
		//判断用户输入的信息是否符合规定
		if (user.getUsername().equals("")) {
			addFieldError("username", "用户名不允许为空");
		}
		if (user.getPassword().equals("")) {
			addFieldError("password", "密码不允许为空");
		}
		if (user.getUsername().length() < 3 || user.getUsername().length() > 10) {
			addFieldError("username", "用户名的长度是3至10");
		}
		if (hasErrors()) {
			return "inputLogin";
		}
		
		User existUser = userService.findOne(user);
		if (existUser != null) {
			if (existUser.getUtype() == 1) {
				// 使用session来保存用户的登录状态
				ServletActionContext.getRequest().getSession().setAttribute("user", existUser);
				return "loginSuccess";
			} else {
				// 使用session来保存用户的登录状态
				ServletActionContext.getRequest().getSession().setAttribute("user", existUser);
				return "adminLoginSuccess";
			}
		} else {
			return "login";
		}
	}

	/*
	 * 用户退出的方法
	 */
	public String quit() {
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}

	/*
	 * 用户注册的方法
	 */
	public String register() {
		//判断用户注册的信息是否符合规定
		if (user.getUsername().equals("")) {
			addFieldError("username", "用户名不允许为空");
		}
		if (user.getPassword().equals("")) {
			addFieldError("password", "密码不允许为空");
		}
		if (user.getPassword2().equals("")) {
			addFieldError("password2", "确认密码不允许为空");
		}
		if (user.getUsername().length() < 3 || user.getUsername().length() > 10) {
			addFieldError("username", "用户名的长度是3至10");
		}
		if (!user.getPassword2().equals(user.getPassword())) {
			addFieldError("password2", "确认密码必须与密码相同");
		}
		if (!Pattern.matches("\\w{3,15}", user.getPassword())) {
			addFieldError("password", "密码必须是字母和数字组成，且长度为3到15");
		}
		if (hasErrors()) {
			return "inputRegister";
		}
		
		userService.register(user);
		return "register";
	}
}
