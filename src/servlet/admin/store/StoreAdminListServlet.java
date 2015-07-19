package servlet.admin.store;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Store;
import dao.StoreDao;

public class StoreAdminListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StoreDao dao = new StoreDao();
		ArrayList<Store> stores = dao.finAll();
		
		request.setAttribute("stores", stores);
		request.getRequestDispatcher("storeAdminList.jsp").forward(request, response);
	}
}
