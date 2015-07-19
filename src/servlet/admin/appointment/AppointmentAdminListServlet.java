package servlet.admin.appointment;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Appointment;

import dao.AppointmentDao;

public class AppointmentAdminListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AppointmentDao dao = new AppointmentDao();
		ArrayList<Appointment> appointments = dao.findAll();
		
		request.setAttribute("appointments", appointments);
		request.getRequestDispatcher("appointmentAdminList.jsp").forward(request, response);
		
	}

}
