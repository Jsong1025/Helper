package com.helper.servlet.admin.user;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.dao.MySQLRoleDao;
import com.helper.dao.RoleDao;
import com.helper.entity.Role;

public class UserAddShowServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RoleDao dao = new MySQLRoleDao();
		ArrayList<Role> roles = dao.findAll();
		
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("userAdd.jsp").forward(request, response);
	}

}
