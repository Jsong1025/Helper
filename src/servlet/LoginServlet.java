package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.User;

import dao.UserDao;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		String email = req.getParameter("useradress"); 
		String password = req.getParameter("userpassword"); 

		UserDao dao = new UserDao();
		User user = dao.findPasswordByUserName(email);
		HttpSession session = req.getSession();
		
		if (user != null && password.equals(user.getPassword())) {	//验证密码

			// 将用户名和emial放入session中
			String username = user.getUsername();
			session.setAttribute("username", username);
			session.setAttribute("email", email);

			// 将用户权限放入session中
			int permision = dao.findPermision(email);
			
			session.setAttribute("permision", permision);
			session.setAttribute("message", "<script type='text/javascript'>alert('登陆成功！');</script>");

			resp.sendRedirect("home.jsp");
		}else {
			session.setAttribute("message", "<script type='text/javascript'>alert('账号名或密码错误！');</script>");
			resp.sendRedirect("login.html");
		}
	}

}
