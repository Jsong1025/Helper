package servlet.admin.role;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RoleDao;

import vo.Role;

public class RoleAddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Role role = new Role();
		role.setName(request.getParameter("name"));
		role.setPermision(Integer.parseInt(request.getParameter("permision")));
		
		RoleDao dao = new RoleDao();
		dao.insertRole(role);
		response.sendRedirect("roleAdminList.do");
		
	}

}
