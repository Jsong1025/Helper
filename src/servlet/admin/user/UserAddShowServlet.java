package servlet.admin.user;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Role;

import dao.RoleDao;

public class UserAddShowServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RoleDao dao = new RoleDao();
		ArrayList<Role> roles = dao.findAll();
		
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("userAdd.jsp").forward(request, response);
	}

}