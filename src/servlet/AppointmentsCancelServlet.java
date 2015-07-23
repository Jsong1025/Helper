package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AppointmentDao;

/**
 * @author Jsong
 * 
 * 用户取消约会类。此类用于用户取消已经发布的约会
 *
 */
public class AppointmentsCancelServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		AppointmentDao dao = new AppointmentDao();
		dao.cancelAppointment(id);
		
		response.sendRedirect("appointmentList.do");
	}

}
