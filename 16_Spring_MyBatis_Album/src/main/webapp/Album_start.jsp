<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


webapp\Album_start.jsp<br>

<%
	String viewPage = request.getContextPath() + "/list.ab";
	//System.out.println(request.getContextPath());
	response.sendRedirect(viewPage);
	// 실행 시 /ex 의 의미 => 16_Spring_MyBatis_Albums.com.spring.ex
%>
