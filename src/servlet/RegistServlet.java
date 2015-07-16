package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

public class RegistServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("useradress");
		String password = request.getParameter("userpassword");
		
		UserDao dao = new UserDao();
		if (dao.insertUser(email, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			session.setAttribute("permision", 5);
			session.setAttribute("message", "<script type='text/javascript'>alert('注册成功！');</script>");
			response.sendRedirect("home.jsp");
		} else {
			response.sendRedirect("regist.html");
		}
		
	}

}
