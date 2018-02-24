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
<title>新闻类别管理</title>
<script type="text/javascript">
	/* 修改管理员信息 */
	function updateNav(btn){
		var tr=btn.parentNode.parentNode;
		var tds=tr.getElementsByTagName("input");
		var id=tds[0].value;
		updateNavWindow("admin/editNav.jsp?nav_id="+id);
	}
	function updateNavWindow(url){
		document.getElementById("win-box").style.display="block";
		document.getElementById("update-win").src=url;
	}
	function closeNavWindow(f){
		document.getElementById("win-box").style.display="none";
		if(f==1){
			location=location;
		}
	}
	/* 查看被选中的管理员 */
	function selectedRow(){
		var ms=document.getElementsByName("box");
		var obj=null;
		for(i=0;i<ms.length;i++){
			if(ms[i].checked){
				obj=ms[i];
				break;
			}
		}
		if(null==obj){
			alert("请选择要删除的新闻信息!");
			return;
		}
		return obj;
	}
	/* 删除被选中的管理员 */
	function onDeleteNav(){
  		var obj = selectedRow();
  		if(obj==null)return;
  		if(confirm("您确认要删除当前用户吗？")){
  			location="<%=basePath%>deleteNav?nav_id="+obj.value;
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
		<h1 class="title">新闻类别管理<a href="<%=basePath%>admin/main.jsp" class="back-btn">返回主页</a></h1>
		<table class="tab" cellspacing="20">
			<tr>
				<td class="text-center" >选择</td>
				<td class="text-center">类别名称</td>
				<td>排序权重</td>
				<td>编辑</td>
			</tr>
			<%
				ActionBean actionBean=new ActionBean();
				out.println(actionBean.queryNavAll());
			%>
			<tr>
				<td colspan="1" style="border-bottom:0"><a class="btn" href="admin/addNav.jsp">增加类别</a></td>
				<td colspan="1" style="border-bottom:0"><input type="button" value="删除" class="btn" onclick="onDeleteNav();"></td>
			</tr>
		</table>
	</div>
	</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<div class="win-box" id="win-box">
		<h2 class="win-title">修改新闻类别<span onclick="closeNavWindow(0);">&times;</span></h2>
		<iframe src="" id="update-win"></iframe>
	</div>
</body>
</html>