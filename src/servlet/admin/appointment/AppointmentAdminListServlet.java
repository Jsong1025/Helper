package servlet.admin.appointment;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.dao.AppointmentDao;
import com.helper.dao.MySQLAppointmentDao;
import com.helper.entity.Appointment;

public class AppointmentAdminListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AppointmentDao dao = new MySQLAppointmentDao();
		ArrayList<Appointment> appointments = dao.findAll();
		
		request.setAttribute("appointments", appointments);
		request.getRequestDispatcher("appointmentAdminList.jsp").forward(request, response);
		
	}

}
