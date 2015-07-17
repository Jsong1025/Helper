package servlet;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AppointmentDao;
import dao.UserDao;

import vo.Appointment;
import vo.User;

public class ReleaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			
			String[] substance = request.getParameterValues("substance");
			int storeID = Integer.parseInt((String) request.getParameter("store"));
			int mealId = Integer.parseInt((String)request.getParameter("meal"));
			int gender = Integer.parseInt((String)request.getParameter("gender"));
			String description = (String)request.getParameter("description");
			
			Date startTime = new Date();	//获取当前时间
			
			//获取用户ID值
			HttpSession session = request.getSession();
			String userEmail = (String)session.getAttribute("email");
			UserDao  userDao = new UserDao();
			User user = userDao.findInfoByEmail(userEmail); 
			
			// 字符串时间转Date
			String strTime = (String)request.getParameter("time");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date time = sdf.parse(strTime);

			Appointment appointment = new Appointment();
			appointment.setTime(time);
			appointment.setMealId(mealId);
			appointment.setGender(gender);
			appointment.setStartTime(startTime);
			appointment.setUserId(user.getId());
			appointment.setSubstance(substance);
			appointment.setDescription(description);
			
			AppointmentDao appointmentDao = new AppointmentDao();
			appointmentDao.insertAppointment(appointment);
			
			//跳转
			session.setAttribute("message", "<script type='text/javascript'>alert('发布成功！');</script>");
			response.sendRedirect("home.jsp");

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
