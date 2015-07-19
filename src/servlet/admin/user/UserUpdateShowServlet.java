package servlet.admin.user;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Role;
import vo.User;

import dao.RoleDao;
import dao.UserDao;

public class UserUpdateShowServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		UserDao dao = new UserDao();
		User user = dao.findUserById(id);
		
		RoleDao roledao = new RoleDao();
		ArrayList<Role> roles = roledao.findAll();
		
		request.setAttribute("user", user);
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("userUpdate.jsp").forward(request, response);
	}

}
