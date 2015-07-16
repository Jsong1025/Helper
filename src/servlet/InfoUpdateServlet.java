package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.User;
import dao.UserDao;

public class InfoUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String email = (String)request.getSession().getAttribute("email");
		UserDao dao = new UserDao();
		User user = dao.findInfoByEmail(email);
		
		// 根据type值判断更新内容
		int type = Integer.parseInt(request.getParameter("type"));
		switch (type) {
		case 1:		//更新基本资料
			user.setName(request.getParameter("name"));
			user.setSex(request.getParameter("sex").charAt(0));
			user.setLocation(request.getParameter("location"));
			user.setDescription(request.getParameter("description"));
			break;
		case 2:	// 更新头像
			
			break;
			
		case 3: // 更新用户名
			String usernameNew = request.getParameter("usernameNew");
			user.setUsername(usernameNew);
			HttpSession session = request.getSession();
			session.setAttribute("username", usernameNew);
			break;
			
		case 4: //更新密码
			user.setPassword(request.getParameter("passwordNew"));
			break;
			
		default:
			break;
		}
		
		dao.updateInfoByEmail(user);
		response.sendRedirect("info.do");
	}

}
