<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript" src="${basePath }/js/manager/back.js"></script>
<div>
	<h1 class="title">添加管理员 <a href="javascript:void(0)" class="back-btn">返回</a></h1>
	<form action="" id="for" method="post">
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
<script type="text/javascript" src="${basePath }/js/manager/addManager.js"></script>
