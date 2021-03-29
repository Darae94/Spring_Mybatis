<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<style>
	.err {
		font-weight: bold;
		font-size: 9pt;
		color: red;
	}
</style>

memberRegisterForm.jsp<br>
<h2>회원 가입 화면</h2>
<form:form commandName="member" method="post" action="registerForm.me"> 
	
		<p>
			<label for="id">아이디</label>
			<input type="text" name="id" value="${ member.id }">
			<form:errors cssClass="err" path="id" />
		</p>
		<p>
			<label for="name">이름</label>
			<input type="text" name="name" value="${ member.name }">
			<form:errors cssClass="err" path="name" />
		</p>
		<p>
			<label for="password">비번</label>
			<input type="text" name="password" value="${ member.password }">
			<form:errors cssClass="err" path="password" />
		</p>	
		<p>
			<label for="gender">성별</label>
			<input type="radio" name="gender" <c:if test="${ member.gender == '남자' }">checked</c:if> value="남자">남자
			<input type="radio" name="gender" <c:if test="${ member.gender == '여자' }">checked</c:if> value="여자">여자
			<form:errors cssClass="err" path="gender" />
		</p>	
		<p>
			<label for="hobby">취미</label>
			<input type="checkbox" name="hobby" <c:if test="${ fn:contains(member.hobby,'마라톤') }">checked</c:if> value="마라톤">마라톤
			<input type="checkbox" name="hobby" <c:if test="${ fn:contains(member.hobby,'영화감상') }">checked</c:if> value="영화감상">영화감상
			<input type="checkbox" name="hobby" <c:if test="${ fn:contains(member.hobby,'게임') }">checked</c:if> value="게임">게임
			<input type="checkbox" name="hobby" <c:if test="${ fn:contains(member.hobby,'공부') }">checked</c:if> value="공부">공부
			<form:errors cssClass="err" path="hobby" />
		</p>	
		<p>
			<label for="address1">주소1</label>
			<input type="text" name="address1" value="${ member.address1 }">
			<form:errors cssClass="err" path="address1" />
		</p>	
		<p>
			<label for="address2">주소2</label>
			<input type="text" name="address2" value="${ member.address2 }">
		</p>	
		
		<p>
			<label for="mpoint">적립포인트</label>
			<input type="text" name="mpoint" value="${ member.mpoint }">
		</p>	
		<p class="btnRow">
			<input type="submit" value="추가하기">		
		</p>
</form:form>