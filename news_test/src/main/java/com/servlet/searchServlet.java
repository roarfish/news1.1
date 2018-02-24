package com.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Article;
import com.entity.Nav;
import com.sql.SqlHelper;
import com.tools.MyFuns;

/**
 * Servlet implementation class searchServlet
 */
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String searchTxt = request.getParameter("searchTxt");
		if(searchTxt == "" || "".equals(searchTxt)){
			response.sendRedirect("index.html");
			return;
		}
		int p = MyFuns.string2Int(request.getParameter("p"));
		SqlHelper sqlHelper = new SqlHelper();
		//获取导航菜单的数据
		List <Nav>list = sqlHelper.queryNavAll();
		//获取最近发布的文章
		List <Article>lastArticles = sqlHelper.queryLastArticles();
		//根据关键词作模糊查询
		List <Map>articles = sqlHelper.queryArticleMapByPage(p, null, searchTxt);
		//根据关键词查询总的记录数
		int rows = sqlHelper.queryArticleCount(null, searchTxt);
		
		sqlHelper.destroy();
		request.setAttribute("navList", 		list		);
		request.setAttribute("lastArticles", 	lastArticles);
		request.setAttribute("articles", 		articles	);
		request.setAttribute("p", 				p			);
		request.setAttribute("rows", 			rows		);
		request.setAttribute("searchTxt",		searchTxt	);
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}

}
