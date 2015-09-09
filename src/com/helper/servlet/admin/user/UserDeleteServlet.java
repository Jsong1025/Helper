package com.helper.servlet.admin.user;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.dao.MySQLUserDao;
import com.helper.dao.UserDao;

public class UserDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		UserDao dao = new MySQLUserDao();
		dao.deleteUser(id);
		response.sendRedirect("userAdminList.do");
	}

}
