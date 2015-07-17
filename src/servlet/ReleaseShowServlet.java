package servlet;


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

public class ReleaseShowServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取所有商家
		StoreDao sDao = new StoreDao();
		ArrayList<Store> stores = sDao.finAll();
		
		//获取所有套餐
		MealDao mDao = new MealDao();
		ArrayList<Meal> meals = mDao.finAll();
		
		//绑定数据，转发
		request.setAttribute("stores", stores);
		request.setAttribute("meals", meals);
		request.getRequestDispatcher("release.jsp").forward(request, response);
	}

}
