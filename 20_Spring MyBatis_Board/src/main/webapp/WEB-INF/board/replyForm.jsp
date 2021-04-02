<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../common/color.jsp" %>
<%@ include file="../common/common.jsp" %>

<link rel="stylesheet" href="<c:url value='/resources/style.css' />">

replyForm.jsp<br>

<body bgcolor="<%=bodyback_c%>">
	<h2>답글쓰기</h2>
	<form:form commandName="board" method="post" action="reply.bd">
		<input type="hidden" name="pageNumber" value="${ pageNumber }">
		<input type="hidden" name="ref" value="${ board.ref }">
		<input type="hidden" name="reStep" value="${ board.reStep }">
		<input type="hidden" name="reLevel" value="${ board.reLevel }">
		<table border=1 style="width:450px;">
			<tr bgcolor="<%=value_c%>">
				<td colspan=2 style="text-align:right">
					<a href="list.jsp">글목록</a>
				</td>
			</tr>
			<tr>
				<td bgcolor="<%=value_c%>">이 름</td>
				<td>
					<input type="text" name="writer" maxlength="10" value="${ board.writer }">
					<form:errors cssClass="err" path="writer" />
				</td>
			</tr>
			<tr>
				<td bgcolor="<%=value_c%>">제 목</td>
				<td>
					<input type="text" name="subject" maxlength="20" value="${ board.subject }">
					<form:errors cssClass="err" path="subject" />
				</td>
			</tr>
			<tr>
				<td bgcolor="<%=value_c%>">Email</td>
				<td>
					<input type="text" name="email" maxlength="10" value="${ board.email }">
				</td>
			</tr>
			<tr>
				<td bgcolor="<%=value_c%>">내 용</td>
				<td>
					<textarea rows="15" cols="50" name="content">${ board.content }</textarea>
					<form:errors cssClass="err" path="content" />
				</td>
			</tr>
			<tr>
				<td bgcolor="<%=value_c%>">비밀번호</td>
				<td>
					<input type="password" name="passwd" maxlength="12" value="${ board.passwd }">
					<form:errors cssClass="err" path="passwd" />
				</td>
			</tr>
			<tr bgcolor="<%=value_c%>">
				<td colspan=2>
					<input type="submit" value="답글쓰기">
					<input type="reset" value="다시작성">
					<input type="button" value="목록보기" onClick="location.href='list.bd'">
				</td>
			</tr>
		</table>
	</form:form>
</body>