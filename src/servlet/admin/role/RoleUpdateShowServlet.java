package servlet.admin.role;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Role;
import dao.RoleDao;

public class RoleUpdateShowServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		RoleDao dao = new RoleDao();
		Role role = dao.findRoleById(id);
		request.setAttribute("role", role);
		request.getRequestDispatcher("roleUpdate.jsp").forward(request, response);
	}

}
