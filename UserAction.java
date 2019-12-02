package com.snake.action;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;  
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.snake.dao.UserDao;
import com.snake.model.User;
import com.opensymphony.xwork2.ActionSupport;


@Entity
@Controller @Scope("prototype")

public class UserAction<UserDao> extends ActionSupport implements SessionAware{
	


	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private static final long serialVersionUID = 1L;

	/*业务层对象*/
    @Resource UserDao UserDao;
    
    private User user;
    
    //这两个成员变量是用来做登录拦截的，记得添加setter和getter
    
	private Map<String,Object> session;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String showDetail(){
		food=foodDao.GetFoodById(food.getFoodid());
		return "detail_view";
	}
	
	public String showEdit() throws Exception{
		user=userDao.GetFoodById(user.getFoodid());
		return "edit_view";
	}
	
	public String editFood() throws Exception{
		userDao.UpdateUser(user);
		return "edit_message";
	}
	
	public String deleteUser() throws Exception{
		userDao.DeleteUser(user.getUserid());
		return "delete_message";
	}
	
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	
	
	private String errMessage;
	
	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	
	/*
	public String reg() throws Exception{
		customerDao.AddCustomer(customer);
		session.put("curCustomer", customer);
		return "show_view";
		
	}*/
	
    //注册，并在session中加入用户名
	public String reg() throws Exception{
		//UserDao.AddUser(user);
		session.put("user", user);
		return "show_view";

	}
    
	/* 验证用户登录 */
	/*public String login() {
		Customer db_customer = (Customer)customerDao.QueryCustomerInfo(customer.getName()).get(0);
		if(db_customer == null) { 
			
			this.errMessage = " 账号不存在 ";
			System.out.print(this.errMessage);
			return INPUT;
			
		} else if( !db_customer.getPassword().equals(customer.getPassword())) {
			
			this.errMessage = " 密码不正确! ";
			System.out.print(this.errMessage);
			return INPUT;
			
		}else{
			return "show_view";
			
		}	*/	

	
	/* 验证用户登录 */
	public String login() {
			
	Map<String, Object> listUser = null;
	Object db_user = null;
	//ArrayList<User> listUser = UserDao.QueryUserInfo(user.getName());
	if(listUser.size()==0) { 
		this.errMessage = " 账号不存在 ";
		System.out.print(this.errMessage);
		return "input";
		} 
		else if(!((Object) db_user).equals(user.getPassword(errMessage))){
		this.errMessage = " 密码不正确! ";
		System.out.print(this.errMessage);
		return "input";
		}
		else{
			session.put("user", db_user);
			return "success";
		}
	}
}
