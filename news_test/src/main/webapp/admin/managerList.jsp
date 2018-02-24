<%@page import="com.action.bean.ActionBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base href="<%=basePath%>">
<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css">
<title>管理员列表</title>
<script type="text/javascript">
	/* 修改管理员信息 */
	function updateManager(btn){
		var tr=btn.parentNode.parentNode;
		var tds=tr.getElementsByTagName("td");
		var id=tds[2].innerHTML;
		location="editManager.jsp?manager_id="+id;
	}
	/* 查看被选中的管理员 */
	function selectedRow(){
		debugger
		var ms=document.getElementsByName("box");
		var obj=null;
		for(i=0;i<ms.length;i++){
			if(ms[i].checked){
				obj=ms[i];
				break;
			}
		}
		if(null==obj){
			alert("请选择要删除的管理员");
			return;
		}
		return obj;
	}
	/* 删除被选中的管理员 */
	function onDeleteManager(){
  		var obj = selectedRow();
  		if(obj==null)return;
  		if(confirm("您确认要删除当前用户吗？")){
  			location="<%=basePath%>deleteManager?manager_id="+obj.value;
  		}
  	}
</script>
</head>
<body>
	<div class="main-frame">
	<jsp:include page="top.jsp"></jsp:include>
	<jsp:include page="left.jsp"></jsp:include>
	<div class="right">
	<div class="admin" align="center" >
		<h1 class="title">管理员信息列表<a href="<%=basePath%>admin/main.jsp" class="back-btn">返回主页</a></h1>
		<table class="tab" cellspacing="20">
			<tr>
				<td class="text-center" >选择</td>
				<td class="text-center">序号</td>
				<td class="text-center">登录账号</td>
				<td>登录姓名</td>
				<td>编辑</td>
			</tr>
			<%
				ActionBean actionBean=new ActionBean();
				out.println(actionBean.queryManagerAll());
			%>
			<tr>
				<td colspan="1" style="border-bottom:0"><a class="btn" href="admin/addManager.jsp">增加管理员</a></td>
				<td colspan="1" style="border-bottom:0"><input type="button" value="删除" class="btn" onclick="onDeleteManager();"></td>
			</tr>
		</table>
	</div>
	</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>