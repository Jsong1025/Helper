package com.helper.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.entity.User;
import com.helper.service.UserService;


public class LoginCheckServlet extends HttpServlet implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String useradress = request.getParameter("useradress");
		String password = request.getParameter("password");
		System.out.println(useradress);
		UserService service = new UserService(request,response);
		ResponseMsg msg = service.loginCheck(useradress, password);
		out.print(msg);
	}
	

}
