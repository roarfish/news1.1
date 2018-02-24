package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sql.SqlHelper;

/**
 * Servlet implementation class deleteManager
 */
public class deleteManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String manager_id = request.getParameter("manager_id");
		if(!(manager_id==null || "".equals(manager_id))){
			SqlHelper sqlHelper = new SqlHelper();
			sqlHelper.deleteManager(manager_id);
			sqlHelper.destroy();
		}else{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
			out.println("<HTML>");
			out.println("<head><title>不错</title></head>");
			out.println("<body>");
			out.println("数据有误! <a href='addManager.jsp'>返回重新输入</a>");
			out.println("</body>");
			out.println("</HTML>");
		}
		response.sendRedirect("admin/managerList.jsp");
	}

}
