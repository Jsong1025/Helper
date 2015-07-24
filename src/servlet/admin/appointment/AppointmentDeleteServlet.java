package servlet.admin.appointment;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AppointmentDao;
import dao.MealDao;

public class AppointmentDeleteServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		AppointmentDao dao = new AppointmentDao();
	  dao.deleteAppointment(id);
		response.sendRedirect("appointmentAdminList.do");
	}

}
