<%@page import="com.entity.*"%>
<%@page import="com.action.bean.ActionBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String nav_id=request.getParameter("nav_id");
	if(nav_id==null)return;
	ActionBean actionBean=new ActionBean();
	Nav nav=actionBean.queryNavById(nav_id);
	if(null==nav){
		response.sendRedirect("navList.jsp");
		return;
	}
%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="admin" align="center">
		<form action="<%=basePath %>editNav" id="for" method="post">
			<input type="hidden" name="nav_id" value="<%=nav.getNav_id() %>">
			<table>
				<tr><td>新闻类别名称：</td><td><input id="nav_name" name="nav_name" maxlength="10" type="text" value="<%=nav.getNav_name() %>"></td><td id="err_nav_name"></td></tr>
				<tr><td align="right">权重：</td><td><input id="nav_feight" name="nav_feight" maxlength="20" type="text" value="<%=nav.getNav_feight()%>"></td><td id="err_nav_feight"></td></tr>
				<!-- <tr><td><input type="submit" value="保存"></td></tr> -->
				<tr><td><a onclick="startPost()" class="btn" href="javascript:void(0)">保存</a></td></tr>
			</table>
		</form>
	</div>
<script type="text/javascript" src="<%=basePath %>js/nav.js"></script>
</body>
</html>