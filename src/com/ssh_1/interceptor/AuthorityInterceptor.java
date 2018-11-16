package com.ssh_1.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 自定义拦截器类用于判断用户是否登录
 * @author wwj
 *
 */
public class AuthorityInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//获取session域，并从中得到user对象
		HttpServletRequest request = ServletActionContext.getRequest();
		Object object = request.getSession().getAttribute("user");
		
		//如果是登录状态
		if (object != null) {
			return invocation.invoke();
		//不是登录状态
		}else {
			return "nologin";
		}
	}

}
