package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StoreDao;

import vo.Store;

public class StoreAddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Store store = new Store();
		store.setName(request.getParameter("name"));
		store.setAddress(request.getParameter("address"));
		store.setTel(request.getParameter("tel"));
		store.setType(request.getParameter("type"));
		store.setIntroduce(request.getParameter("introduce"));
		store.setPicture("");
		
		StoreDao dao = new StoreDao();
		dao.insertStore(store);
		response.sendRedirect("storeAdminList.do");
	}
}
