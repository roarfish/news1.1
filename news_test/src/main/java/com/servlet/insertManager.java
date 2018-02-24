package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Manager;
import com.sql.SqlHelper;

/**
 * Servlet implementation class insertManager
 */
public class insertManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String manager_id=request.getParameter("manager_id");
		String manager_name=request.getParameter("manager_name");
		String manager_pwd=request.getParameter("manager_pwd");
		
		Manager manager=new Manager();
		manager.setManager_id(manager_id);
		manager.setManager_name(manager_name);
		manager.setManager_pwd(manager_pwd);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		if(manager.getManager_id()==null || "".equals(manager.getManager_id()) ||
		   manager.getManager_name()==null || "".equals(manager.getManager_name()) ||
		   manager.getManager_pwd()==null || "".equals(manager.getManager_pwd())){
			out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
			out.println("<HTML>");
			out.println("<head><title>不错</title></head>");
			out.println("<body>");
			out.println("请把信息输入完整! <a href='addManager.jsp'>返回重新输入</a>");
			out.println("</body>");
			out.println("</HTML>");
		}else{
			SqlHelper sqlhelper=new SqlHelper();
			if(sqlhelper.queryManagerById(manager.getManager_id())!=null){
				out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
				out.println("<HTML>");
				out.println("<head><title>不错</title></head>");
				out.println("<body>");
				out.println("账号已存在! <a href='addManager.jsp'>返回重新输入</a>");
				out.println("</body>");
				out.println("</HTML>");
			}else{
				boolean b=sqlhelper.insertManager(manager);
				response.sendRedirect("managerList.jsp");
			}
			sqlhelper.destroy();
		}
	}

}
