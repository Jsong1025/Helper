package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Message;

import dao.AppointmentDao;
import dao.MessageDao;

public class AppointmentSubmitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		MessageDao messageDao = new MessageDao();
		Message message = messageDao.findMessageById(id);
		
		AppointmentDao appointmentDao = new AppointmentDao();
		appointmentDao.submitResponseAppointment(message.getAppointmentId(),message.getOtherUser());
		
		response.sendRedirect("messageShow.do");
	}

}
