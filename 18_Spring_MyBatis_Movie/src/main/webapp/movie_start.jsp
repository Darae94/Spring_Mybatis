<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

movie_start.jsp<br>

<%
	String viewPage = request.getContextPath() + "/list.mv";
	response.sendRedirect(viewPage);
%>
