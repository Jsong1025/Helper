package com.helper.servlet.admin.role;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.dao.MySQLRoleDao;
import com.helper.dao.RoleDao;

public class RoleDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		RoleDao dao = new MySQLRoleDao();
		dao.deleteRole(id);
		response.sendRedirect("roleAdminList.do");
	}

}
