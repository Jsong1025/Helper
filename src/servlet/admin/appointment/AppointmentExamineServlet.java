package servlet.admin.appointment;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Appointment;
import vo.Message;
import vo.User;

import dao.AppointmentDao;
import dao.MessageDao;
import dao.UserDao;

public class AppointmentExamineServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		//生成消费码
	    Random random = new Random();
	    Integer payKey = random.nextInt(100000);     
		
	    AppointmentDao dao = new AppointmentDao();
	    dao.examineAppointment(id, payKey.toString());
	    
	    //查询当前用户ID
	    String email = (String)request.getSession().getAttribute("email");
		UserDao userDao = new UserDao();
		User user = userDao.findInfoByEmail(email);
	    
	    Appointment appointment = dao.findAppointmentById(id);
		Message message1 = new Message();
		message1.setUser(appointment.getUserId());
		message1.setMessage("您的编号为  "+id+" 的约会，管理员已审核通过。消费码为： "+payKey+" 。凭此码享受服务。");
		message1.setAppointmentId(id);
		message1.setOtherUser(user.getId());
		
		Message message2 = new Message();
		message2.setUser(appointment.getOtherUserId());
		message2.setMessage("您的编号为  "+id+" 的约会，管理员已审核通过。消费码为： "+payKey+" 。凭此码享受服务。");
		message2.setAppointmentId(id);
		message2.setOtherUser(user.getId());
		
		//向约会用户返回消息
		MessageDao messageDao = new MessageDao();
		messageDao.insertMessage(message1);
		messageDao.insertMessage(message2);
	    
	    response.sendRedirect("appointmentAdminList.do");
	}

}
