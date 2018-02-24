<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="main-frame">
	<jsp:include page="top.jsp"></jsp:include>
	<jsp:include page="left.jsp"></jsp:include>
	<div class="right">
		<div class="admin" align="center">
			<h1 class="title">后台主页</h1>
			<div class="welcome">欢迎使用</div>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>