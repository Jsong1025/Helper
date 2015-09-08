package com.helper.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.helper.entity.User;
import com.helper.service.UserService;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String useradress = request.getParameter("useradress");
		String password = request.getParameter("password");
		
		UserService service = new UserService();
		User user = service.login(useradress, password);
		HttpSession session = request.getSession();
		if (user != null) {
			session.setAttribute("user", user);
			response.sendRedirect("home.html");
		} else {
			response.sendRedirect("login.html");
		}
		
	}

}
