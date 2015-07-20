package servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Appointment;

import dao.AppointmentDao;

public class AppointmentListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取用户邮箱
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		
		//查找用户所有约会
		AppointmentDao dao = new AppointmentDao();
		ArrayList<Appointment> appointments = dao.findAllByEmail(email);
		
		//移除已经取消了的约会
		for (int i = 0; i < appointments.size(); i++) {
			if (appointments.get(i).isCacel()) {
				appointments.remove(i);
			}
		}
		
		//绑定数据，转发
		request.setAttribute("appointments", appointments);
		request.getRequestDispatcher("appointment.jsp").forward(request, response);
	}

}
