<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

TravelDetailView.jsp<br>

<h2>여행 상세 화면</h2>
<table border="1">
	<tr>
		<th width="100">번호</th>
		<td width="200">${ travel.num }</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${ travel.name }</td>
	</tr>
	<tr>
		<th>나이</th>
		<td>${ travel.age }</td>
	</tr>
	<tr>
		<th>관심지역</th>
		<td>${ travel.area }</td>
	</tr>
	<tr>
		<th>여행타입</th>
		<td>${ travel.style }</td>
	</tr>
	<tr>
		<th>예상비용</th>
		<td>${ travel.price }</td>
	</tr>
	<tr>
		<td colspan=2 align=center>
			<a href="list.tv?pageNumber=${ pageNumber }">여행 리스트 화면으로 돌아감</a>
		</td>
	</tr>
</table>

