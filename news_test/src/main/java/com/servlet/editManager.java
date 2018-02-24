package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Manager;
import com.sql.SqlHelper;

/**
 * Servlet implementation class EditManager
 */
public class editManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String manager_id=request.getParameter("manager_id");
		String manager_name=request.getParameter("manager_name");
		Manager manager=new Manager();
		manager.setManager_id(manager_id);
		manager.setManager_name(manager_name);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		if("".equals(manager_id) || "".equals(manager_name)){
			out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
			out.println("<HTML>");
			out.println("<head><title>不错</title></head>");
			out.println("<body>");
			out.println("信息更改格式错误! <a href='editManager.jsp'>返回重新输入</a>");
			out.println("</body>");
			out.println("</HTML>");
		}else{
			SqlHelper sqlhelper=new SqlHelper();
			boolean flag=sqlhelper.updateManger(manager);
			out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
			out.println("<HTML>");
			out.println("<head><title>不错</title></head>");
			out.println("<body>");
			if(flag){
				out.println("修改成功! <a href='managerList.jsp'>返回主页面</a>");
			}else{
				out.println("修改失败! <a href='editManager.jsp'>返回重新输入</a>");
			}
			out.println("</body>");
			out.println("</HTML>");
		}
	}


}
