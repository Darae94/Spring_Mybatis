<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../common/color.jsp" %>
<%@ include file="../common/common.jsp" %>

<link rel="stylesheet" href="<c:url value='/resources/style.css' />">

writeForm.jsp<br>

<body bgcolor="<%=bodyback_c%>">
	<h2>글 쓰기</h2>
	<form:form commandName="bb" method="post" action="insert.bd">
		<table border=1 style="width:450px;">
			<tr bgcolor="<%=value_c%>">
				<td colspan=2 style="text-align:right">
					<a href="list.bd">글목록</a>
				</td>
			</tr>
			<tr>
				<td bgcolor="<%=value_c%>">이 름</td>
				<td>
					<input type="text" name="writer" maxlength="10" value="${ bb.writer }">
					<form:errors cssClass="err" path="writer" />
				</td>
			</tr>
			<tr>
				<td bgcolor="<%=value_c%>">제 목</td>
				<td>
					<input type="text" name="subject" maxlength="20" value="${ bb.subject }">
					<form:errors cssClass="err" path="subject" />
				</td>
			</tr>
			<tr>
				<td bgcolor="<%=value_c%>">Email</td>
				<td>
					<input type="text" name="email" maxlength="10" value="${ bb.email }">
					<form:errors cssClass="err" path="email" />
				</td>
			</tr>
			<tr>
				<td bgcolor="<%=value_c%>">내 용</td>
				<td>
					<textarea rows="15" cols="50" id="ct" name="content">${ bb.content }</textarea>
					<form:errors cssClass="err" path="content" />
				</td>
			</tr>
			<tr>
				<td bgcolor="<%=value_c%>">비밀번호</td>
				<td>
					<input type="password" name="passwd" maxlength="12" value="${ bb.passwd }">
					<form:errors cssClass="err" path="passwd" />
				</td>
			</tr>
			<tr bgcolor="<%=value_c%>">
				<td colspan=2>
					<input type="submit" value="글쓰기">
					<input type="reset" value="다시작성">
					<input type="button" value="목록보기" onClick="location.href='list.bd'">
				</td>
			</tr>
		</table>
	</form:form>
</body>