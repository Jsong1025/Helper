package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.User;
import dao.UserDao;

public class InfoUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String email = (String)request.getSession().getAttribute("email");
		UserDao dao = new UserDao();
		User user = dao.findInfoByEmail(email);
		
		int type = Integer.parseInt(request.getParameter("type"));
		switch (type) {
		case 1:
			user.setName(request.getParameter("name"));
			user.setSex(request.getParameter("sex").charAt(0));
			user.setLocation(request.getParameter("location"));
			user.setDescription(request.getParameter("description"));
			break;
		case 2:
			
			break;
			
		case 3:
			user.setUsername(request.getParameter("usernameNew"));
			break;
			
		case 4:
			user.setPassword(request.getParameter("passwordNew"));
			break;
		default:
			break;
		}
		
		dao.updateInfoByEmail(user);
		response.sendRedirect("info.do");
	}

}
