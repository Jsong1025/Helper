package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

import vo.User;

public class InfoListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao dao = new UserDao();
		HttpSession session = request.getSession();
		User user = dao.findInfoByEmail((String)session.getAttribute("email"));
		request.setAttribute("info", user);
		request.getRequestDispatcher("info.jsp").forward(request, response);
	}

}
