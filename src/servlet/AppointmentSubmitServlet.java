package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Message;
import vo.Responser;
import vo.User;

import dao.AppointmentDao;
import dao.MessageDao;
import dao.ResponserDao;
import dao.UserDao;

/**
 * @author Jsong
 * 
 * 用户确认约会类。另一用户确认了已发布的约会后，
 *
 */
public class AppointmentSubmitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		//根据ID查找响应信息
		ResponserDao responserDao = new ResponserDao();
		Responser responser = responserDao.findResponserById(id);
		
		//更新约会信息（另一用户）
		AppointmentDao appointmentDao = new AppointmentDao();
		appointmentDao.updateAppointmentOtherUser(responser.getAppointmentId(), responser.getResponserUser().getId());
		//删除响应信息
		responserDao.deleteResponserByAppointmentId(responser.getAppointmentId());
		
		String email = (String)request.getSession().getAttribute("email");
		UserDao userDao = new UserDao();
		User user = userDao.findInfoByEmail(email);
		
		Message message = new Message();
		message.setUser(responser.getResponserUser().getId());
		message.setMessage("您的申请约会编号为  "+responser.getResponserUser().getId()+" 的约会对方已同意，正在等待管理员审核。");
		message.setAppointmentId(responser.getAppointmentId());
		message.setOtherUser(user.getId());
		
		MessageDao messageDao = new MessageDao();
		messageDao.insertMessage(message);
		
		response.sendRedirect("appointmentList.do");
	}

}
