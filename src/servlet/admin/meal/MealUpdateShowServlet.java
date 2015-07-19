package servlet.admin.meal;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Meal;
import vo.Store;
import dao.MealDao;
import dao.StoreDao;

public class MealUpdateShowServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		StoreDao storeDao = new StoreDao();
		ArrayList<Store> stores = storeDao.finAll();
		
		MealDao mealDao = new MealDao();
		Meal meal = mealDao.findMealById(id);
		
		request.setAttribute("meal", meal);
		request.setAttribute("stores", stores);
		request.getRequestDispatcher("mealUpdate.jsp").forward(request, response);
	}

}
