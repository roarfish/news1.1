package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Nav;
import com.sql.SqlHelper;

/**
 * Servlet implementation class indexServlet
 */
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlHelper sqlHelper = new SqlHelper();
		//获取导航（新闻类别）
		List <Nav> list = sqlHelper.queryNavAll();
		List <Map> resultList = new ArrayList();
		//获取新闻信息
		for(Nav nav:list){
			Map map = new HashMap();
			map.put("articleList", sqlHelper.queryArticleByNav_id(nav.getNav_id()));
			map.put("nav", nav); 
			resultList.add(map);
		}
		sqlHelper.destroy();
		request.setAttribute("navList", list);
		request.setAttribute("resultList", resultList);
		request.setAttribute("fromIndex", 1);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
