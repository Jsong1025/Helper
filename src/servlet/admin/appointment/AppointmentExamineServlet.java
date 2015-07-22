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
	    Random random = new Random();
	    Integer payKey = random.nextInt(8);     
		
	    AppointmentDao dao = new AppointmentDao();
	    dao.examineAppointment(id, payKey.toString());
	    
	    response.sendRedirect("appointmentAdminList.do");
	}

}
