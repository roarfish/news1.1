<%@page import="com.entity.Manager"%>
<%@page import="com.action.bean.ActionBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String manager_id=request.getParameter("manager_id");
	ActionBean actionBean=new ActionBean();
	Manager manager=actionBean.queryManagerById(manager_id);
	if(null==manager){
		response.sendRedirect("managerList.jsp");
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
<div class="main-frame">
	<jsp:include page="top.jsp"></jsp:include>
	<jsp:include page="left.jsp"></jsp:include>
	<div class="right">
	<div class="admin" align="center">
		<h1 class="title">修改管理员信息 <a href="managerList.jsp" class="back-btn">返回</a></h1>
		<form action="editManager.dos" id="for" method="post">
			<table>
				<tr><td>登陆账号：</td><td><input id="manager_id" readonly name="manager_id" maxlength="10" type="text" value="<%=manager.getManager_id() %>"></td><td id="err_manager_id"></td></tr>
				<tr><td>登陆姓名：</td><td><input id="manager_name" name="manager_name" maxlength="20" type="text" value="<%=manager.getManager_name()%>"></td><td id="err_manager_name"></td></tr>
				<!-- <tr><td><input type="submit" value="保存"></td></tr> -->
				<tr><td><a onclick="startPost()" class="btn" href="javascript:void(0)">保存</a></td></tr>
			</table>
		</form>
	</div>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
		/* 验证所输入的信息是否都合法或规则 */
		function validInput(id,msg,n){
			var val=document.getElementById(id).value;
			if(val="" || val.length<n){
				document.getElementById("err_"+id).innerHTML="<span class='err'>"+msg+"</span>";
				return false;
			}else{
				document.getElementById("err_"+id).innerHTML="<span class='success'>验证通过.</span>";
				return true;
			}
		}
		/* 调用相关方法处理是否符合提交要求 */
		function startPost(){
			var ids=["manager_name"];
			var msg=["请输入登录姓名,至少2位"];
			var n=[2];
			var flag=true;
			for(i=0;i<n.length;i++){
				flag=validInput(ids[i],msg[i],n[i]) && flag;
			}
			if(flag){
				document.getElementById("for").submit();
			}
		}
	</script>
</body>
</html>