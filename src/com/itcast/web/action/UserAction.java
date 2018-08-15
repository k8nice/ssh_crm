package com.itcast.web.action;

import com.itcast.domain.User;
import com.itcast.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author Administrator
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{	
	private static final long serialVersionUID = -3189355865512596290L;
	private UserService userService;
	private User user = new User();
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String login() throws Exception {
		// 1.调用Service执行登陆逻辑
		User u = userService.getUserByCodePassword(user);
		// 2.将返回的User对象放入session域
		ActionContext.getContext().getSession().put("user", u);
		// 3.重定向到首页		
		return "toHome";
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	

}
