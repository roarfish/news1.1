<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
			<div class="admin" align="center" >
				<h1 class="title">添加管理员 <a href="managerList.jsp" class="back-btn">返回</a></h1>
				<form action="insertManager.do" id="for" method="post">
					<table>
						<tr><td>登陆账号：</td><td><input id="manager_id" name="manager_id" maxlength="10" type="text"></td><td id="err_manager_id"></td></tr>
						<tr><td>登陆姓名：</td><td><input id="manager_name" name="manager_name" maxlength="20" type="text"></td><td id="err_manager_name"></td></tr>
						<tr><td>登陆密码：</td><td><input id="manager_pwd" name="manager_pwd" maxlength="20" type="password"></td><td id="err_manager_pwd"></td></tr>
						<tr><td>确认密码：</td><td><input id="re_manager_pwd" name="re_manager_id" maxlength="10" type="password"></td><td id="err_re_manager_pwd"></td></tr>
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
		/* 验证两次输入的密码是否一致 */
		function validPwd(){
			if(document.getElementById("manager_pwd").value!=document.getElementById("re_manager_pwd").value){
				document.getElementById("err_re_manager_pwd").innerHTML="<span class='err'>两次输入的密码不一致.</span>";
				return false;
			}
			return true;
		}
		/* 调用相关方法处理是否符合提交要求 */
		function startPost(){
			var ids=["manager_id","manager_name","manager_pwd","re_manager_pwd"];
			var msg=["请输入登录账号,至少3位","请输入登录姓名,至少2位","请输入登录密码,至少8位","确认密码与登录密码不一致!"];
			var n=[3,2,8,8];
			var flag=true;
			for(i=0;i<4;i++){
				flag=validInput(ids[i],msg[i],n[i]) && flag;
			}
			flag=validPwd() && flag;
			if(flag){
				document.getElementById("for").submit();
			}
		}
		
		
	</script>
</body>
</html>