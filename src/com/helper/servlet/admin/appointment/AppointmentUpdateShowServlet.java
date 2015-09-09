package com.helper.servlet.admin.appointment;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import com.helper.dao.AppointmentDao;
import com.helper.dao.MealDao;
import com.helper.dao.MySQLAppointmentDao;
import com.helper.dao.MySQLMealDao;
import com.helper.dao.MySQLUserDao;
import com.helper.dao.UserDao;
import com.helper.entity.Appointment;
import com.helper.entity.Meal;
import com.helper.entity.User;

public class AppointmentUpdateShowServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		UserDao userDao = new MySQLUserDao();
		List<User> users = userDao.findAllUser();
		
		MealDao mealDao = new MySQLMealDao();
		ArrayList<Meal> meals = mealDao.finAll();
		
		AppointmentDao dao = new MySQLAppointmentDao();
		Appointment appointment = dao.findAppointmentById(id);
		
		request.setAttribute("users", users);
		request.setAttribute("meals", meals);
		request.setAttribute("appointment", appointment);
		request.getRequestDispatcher("appointmentUpdate.jsp").forward(request, response);
	}

}
