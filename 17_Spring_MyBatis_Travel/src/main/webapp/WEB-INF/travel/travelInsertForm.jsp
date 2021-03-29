<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<style>
	.err {
		color: red;
		font-size: 9pt;
		font-weight: bold;
	}
</style>

<%
	String[] areas = {"유럽", "동남아", "일본", "중국"};
	String[] styles = {"패키지", "크루즈", "자유여행", "골프여행"};
	String[] prices = {"100~200", "200~300", "300~400", "400~500"};
%>

travelInsertForm.jsp<br>

<h2>여행 정보 등록 화면</h2>
<form:form commandName="travel" action="insert.tv" method="post">
	<p>
		이름 : <input type="text" name="name" value="${ travel.name }">
		<form:errors cssClass="err" path="name" />
	</p>
	<p>
		나이 : 
		<input type="text" name="age" value="${ travel.age }">
		<form:errors cssClass="err" path="age" />
	</p>
	<p>
		관심지역 : 
		<c:forEach var="a" items="<%=areas%>">
		<input type="checkbox" name="area" value="${ a }" <c:if test="${ fn:contains(travel.area, a) }">checked</c:if>> ${ a }
		</c:forEach>
		<form:errors cssClass="err" path="area" />
	</p>
	<p>
		여행 타입 : 
		<c:set var="st" value="<%=styles%>"/>
		<c:forEach var="s" items="${ st }">
		<input type="radio" name="style" value="${ s }"  <c:if test="${ s == travel.style }">checked</c:if>> ${ s }
		</c:forEach>
		<form:errors cssClass="err" path="style" />
	</p>
	<p>
		가격 : 
		<select name="price">
			<option value=""> 선택하세요
			<c:set var="price" value="<%=prices%>" />
			<c:forEach var="p" items="${ price }">
				<option value="${ p }"  <c:if test="${ p == travel.price }">selected</c:if>>${ p }
			</c:forEach>
		</select>
		<form:errors cssClass="err" path="price" />
	</p>
	<p>
		<input type="submit" value="추가하기">
	</p>
</form:form> 
