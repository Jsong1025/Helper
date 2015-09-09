package com.helper.servlet.admin.store;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.dao.MySQLStoreDao;
import com.helper.dao.StoreDao;
import com.helper.entity.Store;

public class StoreAddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Store store = new Store();
		store.setName(request.getParameter("name"));
		store.setAddress(request.getParameter("address"));
		store.setTel(request.getParameter("tel"));
		store.setType(request.getParameter("type"));
		store.setIntroduce(request.getParameter("introduce"));
		store.setPicture("");
		
		StoreDao dao = new MySQLStoreDao();
		dao.insertStore(store);
		response.sendRedirect("storeAdminList.do");
	}
}
