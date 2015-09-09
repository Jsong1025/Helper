package com.helper.servlet.admin.role;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.dao.MySQLRoleDao;
import com.helper.dao.RoleDao;
import com.helper.entity.Role;

public class RoleUpdateShowServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		RoleDao dao = new MySQLRoleDao();
		Role role = dao.findRoleById(id);
		request.setAttribute("role", role);
		request.getRequestDispatcher("roleUpdate.jsp").forward(request, response);
	}

}
