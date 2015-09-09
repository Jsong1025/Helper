package com.helper.servlet.admin.store;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.dao.MySQLStoreDao;
import com.helper.dao.StoreDao;
import com.helper.entity.Store;

public class StoreAdminListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StoreDao dao = new MySQLStoreDao();
		ArrayList<Store> stores = dao.finAll();
		
		request.setAttribute("stores", stores);
		request.getRequestDispatcher("storeAdminList.jsp").forward(request, response);
	}
}
