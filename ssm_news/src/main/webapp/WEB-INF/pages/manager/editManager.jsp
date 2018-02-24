<%@ page import="com.zhou.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<link href="${basePath }/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${basePath }/js/manager/back.js"></script>
<script type="text/javascript" src="${basePath }/js/manager/editManager.js"></script>
<div>
	<h1 class="title">修改管理员信息 <a href="javascript:void(0)" class="back-btn">返回</a></h1>
	<form action="editManager.dos" id="for" method="post">
		<table>
			<tr><td>登陆账号：</td><td><input id="manager_id" readonly name="manager_id" maxlength="10" type="text" value=""></td><td id="err_manager_id"></td></tr>
			<tr><td>登陆姓名：</td><td><input id="manager_name" name="manager_name" maxlength="20" type="text" value=""></td><td id="err_manager_name"></td></tr>
			<!-- <tr><td><input type="submit" value="保存"></td></tr> -->
			<tr><td><a onclick="startPost()" class="btn" href="javascript:void(0)">保存</a></td></tr>
		</table>
	</form>
</div>
