<%@page import="com.config.Config"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String msg=request.getParameter("msg")==null?"":("2".equals(request.getParameter("msg"))?"用户名或密码错误!":"用户名或密码输入不完整");
	if(null!=session.getAttribute(Config.MANAGER_ID) && !"".equals(session.getAttribute(Config.MANAGER_ID).toString())){
		response.sendRedirect("admin/main.jsp");
		return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css">
<title>登录页面</title>
</head>
<body>
	<div class="login-title">登录老乡新闻发布系统<small>登录</small></div>
	<div class="login-main">
		<div class="login-box">
			<div class="box">
				<h2>用户登录</h2>
				<form action="LoginServlet" method="post" id="for">
					<p><label>账号:</label><input type="text" name="manager_id" id="manager_id"></p>
					<p><label>密码:</label><input type="password" name="manager_pwd" id="manager_pwd"></p>
					<p><a class="btn" href="javascript:void(0)" onclick="postForm();">登录</a></p>
					<p><span id="msg" class="msg"><%=msg %></span></p>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="admin/footer.jsp"></jsp:include>
	<script type="text/javascript">
		function postForm(){
			var manager_id=document.getElementById("manager_id").value;
			var manager_pwd=document.getElementById("manager_pwd").value;
			document.getElementById("msg").innerHTML="";
			if(manager_pwd=="" || manager_id==""){
				document.getElementById("msg").innerHTML="请输入用户名和密码";
				return;
			}
			document.getElementById("for").submit();
		}
	</script>
</body>
</html>