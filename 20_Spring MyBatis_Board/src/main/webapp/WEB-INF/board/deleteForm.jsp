<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../common/color.jsp" %>
<%@ include file="../common/common.jsp" %>

<link rel="stylesheet" href="<c:url value='/resources/style.css' />">

deleteForm.jsp<br>

<style>
	table {
		width: 500px;
		margin : 0 auto;
		text-align: center;
	}
</style>

<body bgcolor="<%=bodyback_c%>">
	<h2>글삭제</h2>
	<form:form commandName="boardBean" action="delete.bd?num=${ num }&pageNumber=${ pageNumber }" method="post">
		<table>
			<tr bgcolor="<%=value_c%>">
				<td><b>비밀번호를 입력해 주세요.</b></td>
			</tr>
			<tr height=30>
				<td>
					비밀번호 : <input type="password" name="passwd" size="8" maxlength="12">
					<form:errors cssClass="err" path="passwd" />
				</td>
			</tr>
			<tr bgcolor="<%=value_c%>">
				<td>
					<input type="submit" value="글삭제">
					<input type="button" value="글목록" onClick="location.href='list.bd?pageNumber=${ pageNumber }'">
				</td>
			</tr>
		</table>
	</form:form>
</body>
