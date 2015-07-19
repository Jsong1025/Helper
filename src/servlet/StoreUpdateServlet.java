package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StoreDao;

import vo.Store;

public class StoreUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Store store = new Store();
		store.setId(Integer.parseInt(request.getParameter("id")));
		store.setAddress(request.getParameter("address"));
		store.setName(request.getParameter("name"));
		store.setTel(request.getParameter("tel"));
		store.setType(request.getParameter("type"));
		store.setIntroduce(request.getParameter("introduce"));
		store.setPicture("");
		
		StoreDao dao = new StoreDao();
		dao.updateStore(store);
		response.sendRedirect("storeAdminList.do");
	}
	
}
