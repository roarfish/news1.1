package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sql.SqlHelper;

/**
 * Servlet implementation class deleteNews
 */
public class deleteNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String article_id=request.getParameter("article_id");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		if(article_id==null || "".equals(article_id)){
			out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
			out.println("<HTML>");
			out.println("<head><title>错误</title></head>");
			out.println("<body>");
			out.println("删除新闻失败! <a href='articleList.jsp'>返回重新输入</a>");
			out.println("</body>");
			out.println("</HTML>");
		}
		SqlHelper sqlhelper=new SqlHelper();
		boolean b=sqlhelper.deleteNewsById(article_id);
		sqlhelper.destroy();
		if(b){
			response.sendRedirect("admin/articleList.jsp");
		}else{
			response.sendRedirect("admin/deleteNewsError.jsp");
		}
	}

}
