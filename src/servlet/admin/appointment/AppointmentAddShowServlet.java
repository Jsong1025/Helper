package servlet.admin.appointment;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Meal;
import vo.User;

import dao.MealDao;
import dao.UserDao;

public class AppointmentAddShowServlet extends HttpServlet {

	private static final long serialVersionUID = -843202815217118787L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao userDao = new UserDao();
		ArrayList<User> users = userDao.findAll();
		
		MealDao mealDao = new MealDao();
		ArrayList<Meal> meals = mealDao.finAll();
		
		request.setAttribute("users", users);
		request.setAttribute("meals", meals);
		request.getRequestDispatcher("appointmentAdd.jsp").forward(request, response);
	}

}
