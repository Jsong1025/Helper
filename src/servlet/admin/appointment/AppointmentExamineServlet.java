package servlet.admin.appointment;


import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AppointmentDao;

public class AppointmentExamineServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		//生成消费码
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
	    Random random = new Random();     
	    StringBuffer payKey = new StringBuffer();     
	    for (int i = 0; i < 6; i++) {     
	        int number = random.nextInt(base.length());     
	        payKey.append(base.charAt(number));     
	    } 
		
	    AppointmentDao dao = new AppointmentDao();
	    dao.examineAppointment(id, payKey.toString());
	    
	    response.sendRedirect("appointmentAdminList.do");
	}

}
