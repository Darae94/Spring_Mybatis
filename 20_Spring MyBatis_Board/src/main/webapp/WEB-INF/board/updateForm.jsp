<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../common/color.jsp" %>
<%@ include file="../common/common.jsp" %>

<link rel="stylesheet" href="<c:url value='/resources/style.css' />">

updateForm.jsp<br>

<body bgcolor="<%=bodyback_c%>">
	<h2 align=center>글수정</h2>
	<form:form commandName="bean" method="post" action="update.bd">
		<input type="hidden" name="num" value="${ bean.num }">
		<input type="hidden" name="pageNumber" value="${ pageNumber }">
		<table border=1 style="width:500px;">
			<tr>
				<td bgcolor="<%=value_c%>">이 름</td>
				<td>
					<input type="text" name="writer" maxlength="10" value="${ bean.writer }">
					<form:errors cssClass="err" path="writer" />
				</td>
			</tr>
			<tr>
				<td bgcolor="<%=value_c%>">제 목</td>
				<td>
					<input type="text" name="subject" maxlength="20" value="${ bean.subject }">
					<form:errors cssClass="err" path="subject" />
				</td>
			</tr>
			<tr>
				<td bgcolor="<%=value_c%>">Email</td>
				<td>
					<input type="text" name="email" maxlength="10" value="${ bean.email }">
				</td>
			</tr>
			<tr>
				<td bgcolor="<%=value_c%>">내 용</td>
				<td>
					<textarea rows="15" cols="50" name="content">${ bean.content }</textarea>
					<form:errors cssClass="err" path="content" />
				</td>
			</tr>
			<tr>
				<td bgcolor="<%=value_c%>">비밀번호</td>
				<td>
					<input type="password" name="passwd" maxlength="12">
					<form:errors cssClass="err" path="passwd" />
				</td>
			</tr>
			<tr bgcolor="<%=value_c%>">
				<td colspan=2>
					<input type="submit" value="글수정">
					<input type="reset" value="다시 작성">
					<input type="button" value="목록보기" onClick="location.href='list.bd?pageNumber=${ pageNumber }'">
				</td>
			</tr>
		</table>
	</form:form>
</body>