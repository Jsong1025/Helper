package com.helper.servlet.admin.appointment;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.dao.AppointmentDao;
import com.helper.dao.MySQLAppointmentDao;

public class AppointmentDeleteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		AppointmentDao dao = new MySQLAppointmentDao();
	  dao.deleteAppointment(id);
		response.sendRedirect("appointmentAdminList.do");
	}

}
