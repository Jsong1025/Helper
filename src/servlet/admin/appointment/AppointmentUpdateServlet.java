package servlet.admin.appointment;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Appointment;
import dao.AppointmentDao;

public class AppointmentUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			
			int id = Integer.parseInt(request.getParameter("id"));

			String[] substance = request.getParameterValues("substance");
			int mealId = Integer.parseInt((String)request.getParameter("meal"));
			int gender = Integer.parseInt((String)request.getParameter("gender"));
			String description = (String)request.getParameter("description");
			int userId = Integer.parseInt(request.getParameter("user"));
			int otherUserId = Integer.parseInt(request.getParameter("otherUser"));

			// 字符串时间转Date
			String strTime = (String)request.getParameter("time");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date time = sdf.parse(strTime);

			String strStartTime = (String)request.getParameter("startTime");
			Date startTime = sdf.parse(strStartTime);


			Appointment appointment = new Appointment();
			appointment.setId(id);
			appointment.setTime(time);
			appointment.setMealId(mealId);
			appointment.setGender(gender);
			appointment.setStartTime(startTime);
			appointment.setUserId(userId);
			appointment.setOtherUserId(otherUserId);
			appointment.setSubstance(substance);
			appointment.setDescription(description);

			AppointmentDao appointmentDao = new AppointmentDao();
			appointmentDao.updateAppointment(appointment);
			
			response.sendRedirect("appointmentAdminList.do");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
