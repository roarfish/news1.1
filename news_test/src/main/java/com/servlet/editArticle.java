package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Article;
import com.sql.SqlHelper;

/**
 * Servlet implementation class editServlet
 */
public class editArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String article_id=request.getParameter("article_id");
		String article_title=request.getParameter("article_title");
		String article_date=request.getParameter("article_date");
		String article_content=request.getParameter("content1");
		String nav_id=request.getParameter("nav_id");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		if(article_title==null || article_date==null || nav_id==null){
			out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
			out.println("<HTML>");
			out.println("<head><title>不错</title></head>");
			out.println("<body>");
			out.println("请把信息输入完整! <a href='addManager.jsp'>返回重新输入</a>");
			out.println("</body>");
			out.println("</HTML>");
			return;
		}
		Article article=new Article();
		article.setArticle_content(article_content);
		article.setArticle_date(article_date);
		article.setArticle_id(article_id);
		article.setArticle_title(article_title);
		article.setNav_id(nav_id);
		SqlHelper sqlhelper=new SqlHelper();
		boolean b=sqlhelper.editArticle(article);
		if(!b){
			out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
			out.println("<HTML>");
			out.println("<head><title>错误</title></head>");
			out.println("<body>");
			out.println("增加新闻失败! <a href='addArticle.jsp'>返回重新输入</a>");
			out.println("</body>");
			out.println("</HTML>");
		}
		sqlhelper.destroy();
		response.sendRedirect("admin/articleList.jsp");
		
	}

}
