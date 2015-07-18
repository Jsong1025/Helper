package servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Meal;
import dao.MealDao;

public class MealAdminListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MealDao dao = new MealDao();
		ArrayList<Meal> meals = dao.finAll();
		
		request.setAttribute("meals", meals);
		request.getRequestDispatcher("mealAdminList.jsp").forward(request, response);
	}

}
