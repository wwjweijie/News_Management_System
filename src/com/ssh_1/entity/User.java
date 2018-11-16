package com.ssh_1.entity;

/**
 * 用户类
 * @author wwj
 *
 */
public class User {
	private Integer uid;		//用户id
	private String username;	//用户名
	private String password;	//密码
	private String password2;	//确认密码
	private Integer utype;		//用户类别
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public Integer getUtype() {
		return utype;
	}
	public void setUtype(Integer utype) {
		this.utype = utype;
	}
}
