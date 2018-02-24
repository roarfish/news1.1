package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Nav;
import com.sql.SqlHelper;

/**
 * Servlet implementation class insertNav
 */
public class insertNav extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String nav_name=request.getParameter("nav_name");
			String nav_feight_str=request.getParameter("nav_feight");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			if(nav_name==null || nav_feight_str==null){
				out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
				out.println("<HTML>");
				out.println("<head><title>不错</title></head>");
				out.println("<body>");
				out.println("请把信息输入完整! <a href='addNav.jsp'>返回重新输入</a>");
				out.println("</body>");
				out.println("</HTML>");
			}
			int nav_feight=0;
			try {
				nav_feight=Integer.parseInt(nav_feight_str);
			} catch (Exception e) {
				e.printStackTrace();
			}
			String nav_id=UUID.randomUUID().toString();
			Nav nav=new Nav();
			nav.setNav_id(nav_id);
			nav.setNav_name(nav_name);
			nav.setNav_feight(nav_feight);
			SqlHelper sqlhelper=new SqlHelper();
			boolean b=sqlhelper.insertNav(nav);
			if(!b){
				out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
				out.println("<HTML>");
				out.println("<head><title>错误</title></head>");
				out.println("<body>");
				out.println("增加类别失败! <a href='addNav.jsp'>返回重新输入</a>");
				out.println("</body>");
				out.println("</HTML>");
			}
			sqlhelper.destroy();
			response.sendRedirect("admin/navList.jsp");
	}

}
