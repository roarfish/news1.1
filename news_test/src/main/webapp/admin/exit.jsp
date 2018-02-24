<%@page import="com.config.Config"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	HttpSession	sess=request.getSession();
	sess.removeAttribute(Config.MANAGER_ID);
	sess.removeAttribute(Config.LOGIN_SUCCESS);
	response.sendRedirect("loading.jsp");
%>
