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
		ArrayList<Appointment> appointments = null;
		if (request.getParameter("gender") == null &&
				request.getParameter("age") == null && 
				request.getParameter("substance") == null
		) {
			appointments = dao.findAll();
		} else {
			int gender = Integer.parseInt(request.getParameter("gender"));
			int age = Integer.parseInt(request.getParameter("age"));
			int substance = Integer.parseInt(request.getParameter("substance"));
			
			
			int maxAge = 0;
			int minAge = 0;
			switch (age) {
			case 1:
				minAge = 0;
				maxAge = 19;
				break;
			case 2:
				minAge = 19;
				maxAge = 23;
				break;
			case 3:
				minAge = 23;
				maxAge = 26;
				break;
			case 4:
				minAge = 27;
				maxAge = 35;
				break;
			case 5:
				minAge = 35;
				maxAge = 1000;
				break;
			default:
				minAge = 0;
				maxAge = 1000;
				break;
			}
			String strSubstance ="";
			switch (substance) {
			case 1:
				strSubstance ="吃饭,";
				break;
			case 2:
				strSubstance ="看电影,";
				break;
			case 3:
				strSubstance ="唱歌,";
				break;
			case 4:
				strSubstance ="运动,";
				break;
				
			default:
				strSubstance =null;
				break;
			}
			appointments = dao.searchAppointment(gender, minAge, maxAge, strSubstance);
		}
		
		
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
