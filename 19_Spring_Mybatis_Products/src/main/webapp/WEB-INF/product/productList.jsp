<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<%
	session.setAttribute("destination", "redirect:/list.prd");
%>

<script type="text/javascript">
	function insert() {
		location.href = "insert.prd";
	}
	
	function update(n) {
		location.href = "update.prd?num="+n;
	}
</script>

접속자 아이디 :  ${ loginInfo.id }<br>
productList.jsp<br>
<br>
<a href="main.jsp">시작 페이지</a>
<c:if test="${ loginInfo != null }">
	<a href="logout.jsp">로그아웃</a>
</c:if>
<c:if test="${ loginInfo == null }">
	<a href="loginForm.me">로그인</a>
</c:if>
<br>
<br>
<center>
	<h2>상품 리스트 화면<br>productList.jsp</h2>
	<form action="list.prd">
		<select name="whatColumn">
			<option value="all"> 전체 검색
			<option value="name"> 상품명
			<option value="contents"> 설명
		</select>
		<input type="text" name="keyword" value="오렌지">
		<input type="submit" value="검색">
	</form>
	<table border="1" style="width:600px">
		<tr>
			<td colspan="6" align=right>
				<input type="button" value="추가하기" onclick="insert()">
			</td>
		</tr>
		<tr>
			<th>상품ID</th>
			<th>상품명</th>
			<th>설명</th>
			<th>가격</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>
		<c:forEach var="prd" items="${ lists }">
			<tr>
				<td align=center>${ prd.num }</td>
				<td><a href="detail.prd?num=${ prd.num }">${ prd.name }</a></td>
				<td>${ prd.contents }</td>
				<td align=right>${ prd.price }원</td>
				<td align=right><a href="delete.prd?num=${ prd.num }&pageNumber=${ pageInfo.pageNumber }">삭제</a></td>
				<td align=center><input type="button" value="수정" onclick="update(${ prd.num })"></td>
			</tr>
		</c:forEach>
	</table>
	${ pageInfo.pagingHtml }
</center>