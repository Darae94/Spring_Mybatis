<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../common/color.jsp" %>
<%@ include file="../common/common.jsp" %>

<link rel="stylesheet" href="<c:url value='/resources/style.css' />">

content.jsp<br>
<style>
	table {
		width: 500px;
		margin : 0 auto;
	}
</style>

<body bgcolor="<%=bodyback_c%>">
	<h2 align=center>글 상세 보기</h2>
	<table border=1>
		<tr align="center" height="30">
			<td width="125" bgcolor="<%=value_c%>">글번호</td>
			<td width="125">${ bean.num }</td>
			<td width="125" bgcolor="<%=value_c%>">조회수</td>
			<td width="125">${ bean.readcount }</td>
		</tr>
		<tr align="center" height="30">
			<td bgcolor="<%=value_c%>">작성자</td>
			<td>${ bean.writer }</td>
			<td bgcolor="<%=value_c%>">작성일</td>
			<td><fmt:formatDate value="${ bean.regDate }" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr align="center" height="30">
			<td bgcolor="<%=value_c%>">글제목</td>
			<td colspan=3>${ bean.subject }</td>
		</tr>
		<tr height="80">
			<td align="center" bgcolor="<%=value_c%>">글내용</td>
			<td colspan=3>${ bean.content }</td>
		</tr>
		<tr height="30">
			<td align="right" colspan=4 bgcolor="<%=value_c%>">
				<input type="button" value="글수정" onClick="location.href='update.bd?num=${ bean.num }&pageNumber=${ pageNumber }'">
				<input type="button" value="글삭제" onClick="location.href='delete.bd?num=${ bean.num }&pageNumber=${ pageNumber }'">
				<input type="button" value="답글쓰기" onClick="location.href='reply.bd?pageNumber=${ pageNumber }&ref=${ bean.ref }&reStep=${ bean.reStep }&reLevel=${ bean.reLevel }'">
				<input type="button" value="글목록" onClick="location.href='list.bd?pageNumber=${ pageNum }'">
			</td>
		</tr>
	</table>
</body>