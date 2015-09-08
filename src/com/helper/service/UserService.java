package com.helper.service;

import java.io.Serializable;

import com.helper.dao.MySQLUserDao;
import com.helper.dao.UserDao;
import com.helper.entity.User;

/**
 * 	User业务类
 */
public class UserService implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private UserDao dao;
	
	public UserService() {
		this.dao = new MySQLUserDao();
	}
	
	public UserService(UserDao dao) {
		this.dao = dao;
	}
	
	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	
	/*
	 * 登陆功能
	 */
	public User login(String useradress, String password) {
		User user = ((MySQLUserDao)dao).findUserByEmail(useradress);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		} else{
			return null;
		}
	}

}
