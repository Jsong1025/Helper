package com.helper.service;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.helper.dao.MySQLUserDao;
import com.helper.dao.UserDao;
import com.helper.entity.User;
import com.helper.servlet.ResponseMsg;

/**
 * 	Userҵ����
 */
public class UserService implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private UserDao dao;
	private HttpServletRequest request; 
	private HttpServletResponse response;
	
	public UserService() {
		this.dao = new MySQLUserDao();
	}
	
	public UserService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
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
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	/*
	 * ��½��֤���ܣ�����ʽ��½ǰ��
	 */
	public ResponseMsg loginCheck(String useradress, String password) {
		User user = ((MySQLUserDao)dao).findUserByEmail(useradress);
		System.out.println(user);
		if (user != null && password.equals(user.getPassword())) {
			return new ResponseMsg(true, "��½�ɹ�");
		} else{
			return new ResponseMsg(false, "�û������������");
		}
	}
	
	
	/*
	 * ��½����
	 */
	public String login(String useradress, String password) {
		User user = ((MySQLUserDao)dao).findUserByEmail(useradress);
		if (user != null && password.equals(user.getPassword())) {
			request.getSession().setAttribute("user", user);
			return "home.jsp";
		} else{
			return "login.html";
		}
	}
	

}
