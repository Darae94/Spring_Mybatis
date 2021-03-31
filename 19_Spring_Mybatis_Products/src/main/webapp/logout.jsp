<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

webapp\logout.jsp<br>

<%
	// 모든 세션 해제
	session.invalidate();
	response.sendRedirect("main.jsp");
%>
