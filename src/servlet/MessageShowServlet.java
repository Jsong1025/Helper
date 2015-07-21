package servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Message;

import dao.MessageDao;

public class MessageShowServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		
		MessageDao dao = new MessageDao();
		ArrayList<Message> messages = dao.findAllByEmail(email);
		
		request.setAttribute("messages", messages);
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}

}
