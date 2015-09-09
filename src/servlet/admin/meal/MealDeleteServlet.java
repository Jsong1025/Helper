package servlet.admin.meal;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.dao.MealDao;
import com.helper.dao.MySQLMealDao;

public class MealDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		MealDao dao = new MySQLMealDao();
		dao.deleteRole(id);
		response.sendRedirect("mealAdminList.do");
	}
	
}
