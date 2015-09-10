package com.helper.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf('/'),uri.lastIndexOf('.'));

		if (uri.equals("/loginCheck")) {
			request.getRequestDispatcher("").forward(request, response);
		} else if (uri.equals("/login")) {
		
		} else if (uri.equals("/home")) {
			
		}
	}

}
