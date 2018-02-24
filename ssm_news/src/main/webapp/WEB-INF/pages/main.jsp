<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
<link href="${basePath }/css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="${basePath }/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="${basePath }/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="${basePath }/kindeditor/kindeditor-all.js"></script>
<script charset="utf-8" src="${basePath }/kindeditor/lang/zh-CN.js"></script>
<script charset="utf-8" src="${basePath }/kindeditor/plugins/code/prettify.js"></script>
<script type="text/javascript" src="${basePath }/datePicker/WdatePicker.js"></script>
<script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>
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
