<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

접속자 아이디 : ${ loginInfo.id }<br>
shopList.jsp<br>
<br>
<c:if test="${ loginInfo != null }">
	<a href="logout.jsp">로그아웃</a>
</c:if>
<c:if test="${ loginInfo == null }">
	<a href="loginForm.me">로그인</a>
</c:if>
<center>
	<h2>주문 내역</h2>
	<table border=1>
		<tr>
			<td colspan=3 align=center>
				주문자 정보 : ${ loginInfo.name }(${ loginInfo.id })
			</td>
		</tr>
		<tr>
			<th>주문 번호</th>
			<th>주문 일자</th>
			<th>상세 보기</th>
		</tr>
		<c:forEach var="od" items="${ lists }">
		<tr align=center>
			<td>${ od.oid }</td>
			<td>${ od.orderdate }</td>
			<td><a href="detailView.mall?oid=${ od.oid }">상세 보기</a></td>
		</tr>
		</c:forEach>
	</table>
</center>