<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

movieDetail<br>

<table border=1>
	<tr height="30">
		<th width="100">번호</th>
		<td width="200">${ movie.num }</td>
	</tr>
	<tr height="30">
		<th width="100">제목</th>
		<td width="200">${ movie.title }</td>
	</tr>
	<tr height="30">
		<th width="100">대륙</th>
		<td width="200">${ movie.continent }</td>
	</tr>
	<tr height="30">
		<th width="100">제작국가</th>
		<td width="200">${ movie.nation }</td>
	</tr>
	<tr height="30">
		<th width="100">장르</th>
		<td width="200">${ movie.genre }</td>
	</tr>
	<tr height="30">
		<th width="100">등급</th>
		<td width="200">${ movie.grade }</td>
	</tr>
	<tr height="30">
		<th width="100">출연 배우</th>
		<td width="200">${ movie.actor }</td>
	</tr>
	<tr height="30">
		<td colspan="2" align=center>
			<a href="list.mv?pageNumber=${ pageNumber }">영화 정보 리스트로 돌아가기</a>
		</td>
	</tr>
</table>