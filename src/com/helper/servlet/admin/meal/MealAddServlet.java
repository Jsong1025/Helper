package com.helper.servlet.admin.meal;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.dao.MealDao;
import com.helper.dao.MySQLMealDao;
import com.helper.entity.Meal;

public class MealAddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			
			Meal meal = new Meal();
			meal.setName(request.getParameter("name"));

			// 字符串时间转Date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date startTime = sdf.parse((String)request.getParameter("startTime"));
			meal.setStartTime(startTime);
			
			Date endTime = sdf.parse((String)request.getParameter("endTime"));
			meal.setEndTime(endTime);
			
			meal.setNum(Integer.parseInt(request.getParameter("num")));
			meal.setPrice(Double.parseDouble(request.getParameter("price")));
			meal.setPriferemential(request.getParameter("priferemential"));
			meal.setStoreId(Integer.parseInt(request.getParameter("store")));
			
			MealDao dao = new MySQLMealDao();
			dao.insertMeal(meal);
			
			response.sendRedirect("mealAdminList.do");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
