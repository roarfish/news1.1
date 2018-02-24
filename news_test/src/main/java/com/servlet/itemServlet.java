package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Article;
import com.entity.Nav;
import com.sql.SqlHelper;

/**
 * Servlet implementation class itemServlet
 */
public class itemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlHelper sqlHelper = new SqlHelper();
		List <Nav>list = sqlHelper.queryNavAll();
		String article_id = request.getParameter("article_id");//待优化的地方
		Article article = sqlHelper.queryArticleById(article_id);
		
		sqlHelper.destroy();
		request.setAttribute("navList", list);
		request.setAttribute("article", article);
		
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

}
