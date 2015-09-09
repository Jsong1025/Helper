package com.helper.servlet.admin.store;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.dao.MySQLStoreDao;
import com.helper.dao.StoreDao;

public class StoreDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		StoreDao dao = new MySQLStoreDao();
		dao.deleteStore(id);
		response.sendRedirect("storeAdminList.do");
	}

}
