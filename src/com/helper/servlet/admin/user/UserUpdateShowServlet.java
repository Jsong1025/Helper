package com.helper.servlet.admin.user;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.dao.MySQLRoleDao;
import com.helper.dao.MySQLUserDao;
import com.helper.dao.RoleDao;
import com.helper.dao.UserDao;
import com.helper.entity.Role;
import com.helper.entity.User;

public class UserUpdateShowServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		UserDao dao = new MySQLUserDao();
		User user = dao.findUserById(id);
		
		RoleDao roledao = new MySQLRoleDao();
		ArrayList<Role> roles = roledao.findAll();
		
		request.setAttribute("user", user);
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("userUpdate.jsp").forward(request, response);
	}

}
