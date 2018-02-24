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
 * Servlet implementation class articleServlet
 */
public class articleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int p = MyFuns.string2Int(request.getParameter("p"));
		String nav_id = request.getParameter("nav_id");
		SqlHelper sqlHelper = new SqlHelper();
		//获取导航（新闻类别）
		List <Nav>list = sqlHelper.queryNavAll();
		//获取最新发布的新闻数据
		List <Article>lastArticles = sqlHelper.queryLastArticles();
		//获取分类下的新闻列表
		List <Map>articles = sqlHelper.queryArticleMapByPage(p, nav_id, null);
		//获取总的记录数
		int rows = sqlHelper.queryArticleCount(nav_id,null);
		//获取分类信息的数据
		request.setAttribute("nav", sqlHelper.queryNavById(nav_id));
		request.setAttribute("navList", list);
		request.setAttribute("lastArticles", lastArticles);
		request.setAttribute("articles", articles);
		request.setAttribute("rows", rows);
		request.setAttribute("p", p);
		request.setAttribute("nav_id",nav_id);
		sqlHelper.destroy();
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

}
