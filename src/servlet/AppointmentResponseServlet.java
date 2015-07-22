package servlet;


import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AppointmentDao;
import dao.MessageDao;
import dao.UserDao;

import vo.Appointment;
import vo.Message;
import vo.User;

public class AppointmentResponseServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int appointmentId = Integer.parseInt(request.getParameter("id"));
		
		
		//获取用户信息
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		UserDao userDao = new UserDao();
		User user = userDao.findInfoByEmail(email);
		
		//添加约会请求
		AppointmentDao appointmentDao = new AppointmentDao();
		Appointment appointment = appointmentDao.findAppointmentById(appointmentId);
		appointmentDao.responseAppointment(appointmentId, user.getId(), new Date());
		
		//添加消息
		Message message = new Message();
		message.setUser(appointment.getUser().getId());
		message.setMessage(user.getName()+"回应了您的约会请求");
		message.setAppointmentId(appointmentId);
		message.setOtherUser(user.getId());
		MessageDao messageDao = new MessageDao();
		messageDao.insertMessage(message);
		
		response.sendRedirect("searchList.do");
	}

}
