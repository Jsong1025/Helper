package com.helper.servlet.admin.user;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.dao.MySQLUserDao;
import com.helper.dao.UserDao;
import com.helper.entity.User;

public class UserAdminListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao dao = new MySQLUserDao();
		List<User> users = dao.findAllUser();
		
		request.setAttribute("users", users);
		request.getRequestDispatcher("userAdminList.jsp").forward(request, response);
	}
}
