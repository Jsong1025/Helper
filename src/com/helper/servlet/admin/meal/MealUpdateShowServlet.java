package com.helper.servlet.admin.meal;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.dao.MealDao;
import com.helper.dao.MySQLMealDao;
import com.helper.dao.MySQLStoreDao;
import com.helper.dao.StoreDao;
import com.helper.entity.Meal;
import com.helper.entity.Store;

public class MealUpdateShowServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		StoreDao storeDao = new MySQLStoreDao();
		ArrayList<Store> stores = storeDao.finAll();
		
		MealDao mealDao = new MySQLMealDao();
		Meal meal = mealDao.findMealById(id);
		
		request.setAttribute("meal", meal);
		request.setAttribute("stores", stores);
		request.getRequestDispatcher("mealUpdate.jsp").forward(request, response);
	}

}
