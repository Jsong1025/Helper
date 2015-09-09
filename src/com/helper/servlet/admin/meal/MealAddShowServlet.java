package com.helper.servlet.admin.meal;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import com.helper.dao.MySQLStoreDao;
import com.helper.dao.StoreDao;
import com.helper.entity.Store;

public class MealAddShowServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		StoreDao dao = new MySQLStoreDao();
		ArrayList<Store> stores = dao.finAll();
		
		request.setAttribute("stores", stores);
		request.getRequestDispatcher("mealAdd.jsp").forward(request, response);
	}

}
