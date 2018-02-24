package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Article;
import com.entity.Nav;
import com.sql.SqlHelper;

/**
 * Servlet implementation class deleteNav
 */
public class deleteNav extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String nav_id=request.getParameter("nav_id");
		Nav nav=new Nav();
		if(nav_id==null || "".equals(nav_id)){
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
			out.println("<HTML>");
			out.println("<head><title>错误</title></head>");
			out.println("<body>");
			out.println("数据有误! <a href='addManager.jsp'>返回重新输入</a>");
			out.println("</body>");
			out.println("</HTML>");
		}else{
			SqlHelper sqlhelper=new SqlHelper();
			List<Article> list=sqlhelper.queryArticleByNav_id(nav_id);
			if(list.size()<1){
				sqlhelper.deleteNav(nav_id);
			}
			sqlhelper.destroy();
		}
		response.sendRedirect("admin/navList.jsp");
	}

}
