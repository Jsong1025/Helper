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
import dao.ResponserDao;
import dao.UserDao;

import vo.Appointment;
import vo.Message;
import vo.User;

/**
 * @author Jsong
 * 
 * 用户约会响应类。此类用于用户界搜索约会中，用户点击“确认约会”操作。
 *
 */
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
		ResponserDao responserDao = new ResponserDao();
		responserDao.insertResponser(appointmentId, user.getId(), new Date());
		
		AppointmentDao appointmentDao = new AppointmentDao();
		Appointment appointment = appointmentDao.findAppointmentById(appointmentId);
		
		//添加消息
		Message message = new Message();
		message.setUser(appointment.getUser().getId());
		message.setMessage(user.getName()+"回应了您的约会编号为  "+appointmentId+" 的约会请求");
		message.setAppointmentId(appointmentId);
		message.setOtherUser(user.getId());
		MessageDao messageDao = new MessageDao();
		messageDao.insertMessage(message);
		
		response.sendRedirect("searchList.do");
	}

}
