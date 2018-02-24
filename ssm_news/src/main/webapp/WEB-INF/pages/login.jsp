<%@ page import="com.zhou.common.config.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${basePath}/js/common/login.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${basePath }/css/style.css" rel="stylesheet" type="text/css">
<title>登录页面</title>
</head>
<body>
	<div class="login-title">登录老乡新闻发布系统<small>登录</small></div>
	<div class="login-main">
		<div class="login-box">
			<div class="box">
				<h2>用户登录</h2>
				<form action="LoginServlet" method="post" id="for">
					<p><label>账号:</label><input type="text" name="manager_name" id="manager_name"></p>
					<p><label>密码:</label><input type="password" name="manager_pwd" id="manager_pwd"></p>
					<p><a class="btn" href="javascript:void(0)" id="submit">登录</a></p>
					<p><span id="msg" class="msg"></span></p>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>