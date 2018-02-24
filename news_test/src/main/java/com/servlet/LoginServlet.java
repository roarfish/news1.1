package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.config.Config;
import com.entity.Manager;
import com.sql.SqlHelper;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String manager_id=request.getParameter("manager_id");
		String manager_pwd=request.getParameter("manager_pwd");
		if(null==manager_id ||"".equals(manager_id)
		   || null==manager_pwd || "".equals(manager_pwd)){
			response.sendRedirect("login.jsp?msg=0");
			return;
		}
		Manager manager=new Manager();
		manager.setManager_id(manager_id);
		manager.setManager_pwd(manager_pwd);
		SqlHelper sqlhelper=new SqlHelper();
		Manager m=sqlhelper.queryManagerByIdAndPwd(manager);
		if(m==null){
			response.sendRedirect("login.jsp?msg=2");
		}else{
			HttpSession session=request.getSession();
			session.setAttribute(Config.MANAGER_ID, m.getManager_id());
			session.setAttribute(Config.LOGIN_SUCCESS, Config.LOGIN_SUCCESS_VALUE);
			response.sendRedirect("admin/loading.jsp");
		}
		sqlhelper.destroy();
	}

}
