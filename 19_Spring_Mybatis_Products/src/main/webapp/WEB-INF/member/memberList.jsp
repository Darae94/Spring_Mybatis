<%@page import="member.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<script type="text/javascript">
	function insert() {
		location.href = "registerForm.me";
	}
	
	function memberDelete(id, pn) {
		location.href = "delete.me?id="+id+"&pageNumber="+pn;
	}
	
	function memberUpdate(id, pn) {
		location.href = "update.me?id="+id+"&pageNumber="+pn;
	}
</script>

<%
	Member loginInfo = (Member) session.getAttribute("loginInfo");
%>

접속자 아이디 : ${ loginInfo.id }<br>
memberList.jsp<br>
<br>
<a href="main.jsp">시작 페이지</a>
<c:if test="${ loginInfo != null }">
	<a href="">로그아웃</a>
</c:if>
<c:if test="${ loginInfo == null }">
	<a href="loginForm.me">로그인</a>
</c:if>
<br>
<br>
<center>
	<h2>회원 리스트 화면</h2>
	<form action="list.me">
		<select name="whatColumn">
			<option value="all"> 전체 검색
			<option value="name"> 이름
			<option value="gender"> 성별
		</select>
		<input type="text" name="keyword" value="여">
		<input type="submit" value="검색">
	</form>
	<table border="1">
		<tr>
			<td colspan="9" align=right>
				<input type="button" value="추가하기" onclick="insert()">
			</td>
		</tr>
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>비번</th>
			<th>성별</th>
			<th>취미</th>
			<th>주소</th>
			<th>포인트</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>
		<c:forEach var="mb" items="${ lists }">
			<tr>
				<td align=center>${ mb.id }</td>
				<td><a href="detail.me?id='${ mb.id }'&pageNumber='${ pageInfo.pageNumber }'">${ mb.name }</a></td>
				<td>${ mb.password }</td>
				<td>${ mb.gender }</td>
				<td align=right>${ mb.hobby }</td>
				<td>${ mb.address1 } ${ mb.address2 }</td>
				<td align=right>${ mb.mpoint }</td>
				<td align=right><a href="javascript:memberDelete('${ mb.id }','${ pageInfo.pageNumber }')">삭제</a></td>
				<td align=center><input type="button" value="수정" onclick="memberUpdate('${ mb.id }','${ pageInfo.pageNumber }')"></td>
			</tr>
		</c:forEach>
	</table>
	${ pageInfo.pagingHtml }
</center>