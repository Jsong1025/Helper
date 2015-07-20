package servlet.admin.appointment;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import vo.Appointment;
import vo.Meal;
import vo.User;

import dao.AppointmentDao;
import dao.MealDao;
import dao.UserDao;

public class AppointmentUpdateShowServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		UserDao userDao = new UserDao();
		ArrayList<User> users = userDao.findAll();
		
		MealDao mealDao = new MealDao();
		ArrayList<Meal> meals = mealDao.finAll();
		
		AppointmentDao dao = new AppointmentDao();
		Appointment appointment = dao.findAppointmentById(id);
		
		request.setAttribute("users", users);
		request.setAttribute("meals", meals);
		request.setAttribute("appointment", appointment);
		request.getRequestDispatcher("appointmentUpdate.jsp").forward(request, response);
	}

}
