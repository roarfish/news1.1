package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Nav;
import com.sql.SqlHelper;

/**
 * Servlet implementation class editNav
 */
public class editNav extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String nav_id=request.getParameter("nav_id");
		String nav_name=request.getParameter("nav_name");
		String nav_feight=request.getParameter("nav_feight");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		if(nav_id==null || nav_name==null || nav_feight==null){
			out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
			out.println("<HTML>");
			out.println("<head><title>不错</title></head>");
			out.println("<body>");
			out.println("请把信息输入完整!");
			out.println("</body>");
			out.println("</HTML>");
		}else{
			Nav nav=new Nav();
			nav.setNav_id(nav_id);
			nav.setNav_name(nav_name);
			nav.setNav_feight(Integer.parseInt(nav_feight));
			SqlHelper sqlhelper=new SqlHelper();
			boolean flag=sqlhelper.updateNav(nav);
			out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
			out.println("<HTML>");
			out.println("<head><title>不错</title></head>");
			out.println("<body>");
			if(flag){
				out.println("修改成功!'<script>parent.closeNavWindow(1);</script>'");
			}else{
				out.println("修改失败!");
			}
			out.println("</body>");
			out.println("</HTML>");
			sqlhelper.destroy();
		}
	}

}
