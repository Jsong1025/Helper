package servlet.admin.meal;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MealDao;

import vo.Meal;

public class MealUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("utf-8");

			Meal meal = new Meal();
			meal.setId(Integer.parseInt(request.getParameter("id")));
			meal.setName(request.getParameter("name"));
			meal.setNum(Integer.parseInt(request.getParameter("num")));
			meal.setPrice(Double.parseDouble(request.getParameter("price")));
			meal.setPriferemential(request.getParameter("priferemential"));
			meal.setStoreId(Integer.parseInt(request.getParameter("store")));

			// 字符串时间转Date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date startTime;
			startTime = sdf.parse((String)request.getParameter("startTime"));
			meal.setStartTime(startTime);

			Date endTime = sdf.parse((String)request.getParameter("endTime"));
			meal.setEndTime(endTime);

			MealDao dao = new MealDao();
			dao.updateMeal(meal);
			response.sendRedirect("mealAdminList.do");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}