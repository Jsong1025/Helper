package servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AppointmentDao;
import dao.UserDao;

import vo.Appointment;
import vo.User;

public class SearchListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AppointmentDao dao = new AppointmentDao();
		ArrayList<Appointment> appointments = dao.findAll();
		
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		User user = (new UserDao()).findInfoByEmail(email);
		
		//去除已经响应了的约会
		for (int i = 0; i < appointments.size(); i++) {
			if (appointments.get(i).isResponse()) {
				appointments.remove(i);
			}
//			if (dao.isResponseAppointment(appointments.get(i).getId(), user.getId())) {
//				appointments.get(i).setType(2);
//			}
		}
		
		request.setAttribute("appointments", appointments);
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}

}
