package com.helper.servlet.admin.appointment;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.dao.MealDao;
import com.helper.dao.MySQLMealDao;
import com.helper.dao.MySQLUserDao;
import com.helper.dao.UserDao;
import com.helper.entity.Meal;
import com.helper.entity.User;

public class AppointmentAddShowServlet extends HttpServlet {

	private static final long serialVersionUID = -843202815217118787L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao userDao = new MySQLUserDao();
		List<User> users = userDao.findAllUser();
		
		MealDao mealDao = new MySQLMealDao();
		ArrayList<Meal> meals = mealDao.finAll();
		
		request.setAttribute("users", users);
		request.setAttribute("meals", meals);
		request.getRequestDispatcher("appointmentAdd.jsp").forward(request, response);
	}

}
