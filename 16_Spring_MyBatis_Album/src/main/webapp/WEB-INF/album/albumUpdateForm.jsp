<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<style>
	.err {
		font-weight: bold;
		color: red;
		font-size: 9pt;
	}
</style>
albumUpdateForm.jsp<br>

<h2>앨범 수정 화면</h2>
<form:form commandName="album" method="post" action="update.ab">
	<input type="hidden" name="num" value="${ album.num }">
	<input type="hidden" name="pageNumber" value="${ pageNumber }">
	<p>
		<label>노래제목</label>
		<input type="text" name="title" value="${ album.title }">
		<form:errors cssClass="err" path="title" />
	</p>
	<p>
		<label>가수명</label>
		<input type="text" name="singer" value="${ album.singer }">
		<form:errors cssClass="err" path="singer" />
	</p>
	<p>
		<label>가격</label>
		<input type="text" name="price" value="${ album.price }">
		<form:errors cssClass="err" path="price" />
	</p>
	<p>
		<label>출간일</label>
		<fmt:parseDate var="d" value="${ album.day }" dateStyle="short" pattern="yyyy-MM-dd" />
		<input type="text" name="day" value="<fmt:formatDate value="${ d }" pattern="yyyy-MM-dd" />">
	</p>
	<p>
		<input type="submit" value="수정하기">
	</p>
</form:form>
