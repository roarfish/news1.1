<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<div class="left-menu">
		<h1 class="title">导航菜单</h1>
		<ul>
			<li><a href="<%=basePath %>admin/managerList.jsp">用户管理</a></li>
			<li><a href="<%=basePath %>admin/navList.jsp">类别管理</a></li>
			<li><a href="<%=basePath %>admin/articleList.jsp">文章管理</a></li>
			<li><a href="<%=basePath %>admin/exit.jsp">退出系统</a></li>
		</ul>
	</div>
