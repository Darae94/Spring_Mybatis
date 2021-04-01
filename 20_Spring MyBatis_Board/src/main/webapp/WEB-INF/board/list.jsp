<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../common/color.jsp" %>
<%@ include file="../common/common.jsp" %>

<link rel="stylesheet" href="<c:url value='/resources/style.css' />">

list.jsp<br>
<style>
	table {
		width : 700px;
		margin : 0 auto;
	}
</style>

<body bgcolor="<%=bodyback_c%>">
	<h3>글목록 (전체 글 : ${ pageInfo.totalCount })</h3>
	<form action="list.bd">
		<select name="whatColumn">
			<option value="all"> 전체 검색
			<option value="subject"> 제목
			<option value="writer"> 작성자
		</select>
		<input type="text" name="keyword" value="a">
		<input type="submit" value="검색">
	</form>
	<table border="1">
		<tr>
			<td align="right" colspan="6" bgcolor="<%=value_c%>">
				<input type="button" value="작성하기" onclick="location.href='insert.bd'">
			</td>
		</tr>
		<tr align="center" bgcolor="<%=value_c%>">
			<th>번 호</th>
			<th>제 목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회</th>
			<th>IP</th>
		</tr>
	<c:forEach var="bean" items="${ lists }" varStatus="bb">
		<tr>
			<td>${ (pageInfo.totalCount-bb.index)-((pageInfo.pageNumber-1)*pageInfo.pageSize) }</td>
			<td>
				<!-- 원글 : 0, 답글 : 1, 답글의 답글 : 2 / 답글 : 20, 답글의 답글 : 40 -->
				<c:if test="${ bean.reLevel > 0 }">
					<img src="<c:url value='/resources/images/level.gif' />" width="${ 20 * bean.reLevel }" height="16">
					<img src="<c:url value='/resources/images/re.gif' />">
				</c:if>
				<a href="content.bd?num=${ bean.num }&pageNumber=${ pageInfo.pageNumber }">${ bean.subject }</a>
				<!-- 조회수가 10보다 크면 hot image 하나 부착  -->
				<c:if test="${ bean.readcount >= 10 }">
					<img src="<%=request.getContextPath()%>/resources/images/hot.gif">
				</c:if>
			</td>
			<td>${ bean.writer }</td>
			<td>
				<fmt:parseDate type="date" var="date" pattern="yyyy-MM-dd">${ bean.regDate }</fmt:parseDate>
				<fmt:formatDate value="${ date }" pattern="yyy-MM-dd"/>
			</td>
			<td>${ bean.readcount }</td>
			<td>${ bean.ip }</td>
		</tr>
	</c:forEach>
	</table>
	${ pageInfo.pagingHtml }
</body>
