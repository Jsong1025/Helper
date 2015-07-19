package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.User;
import dao.UserDao;

public class UserUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setUsername(request.getParameter("username"));
		user.setName(request.getParameter("name"));
		user.setPassword(request.getParameter("password"));
		user.setSex(request.getParameter("sex").charAt(0));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		user.setTel(request.getParameter("tel"));
		user.setQQ(request.getParameter("QQ"));
		user.setEmail(request.getParameter("email"));
		user.setLocation(request.getParameter("location"));
		user.setDescription(request.getParameter("description"));
		user.setRoleId(Integer.parseInt(request.getParameter("role")));
		
		UserDao dao = new UserDao();
		dao.updateUser(user);
		response.sendRedirect("userAdminList.do");
	}

}
