<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../common/common.jsp" %>

<script type="text/javascript">
	function goInsert() {
		location.href="insert.mv";
	}
	
	function goDelete(n, pn) {
		var answer = confirm(n+"번 영화 정보를 삭제하시겠습니까?");
		if(answer) {
			location.href="delete.mv?num="+n+"&pageNumber="+pn;
		}
	}
	
	function goUpdate(n, pn) {
		location.href="update.mv?num="+n+"&pageNumber="+pn;
	}
</script>

movieList.jsp<br>

<center>
	<h2>영화 정보 리스트 화면</h2>
	<form action="list.mv" method="get">
		<select name="whatColumn">
			<option value="all"> 전체검색
			<option value="genre"> 장르
			<option value="grade"> 등급
			<option value="actor"> 배우
		</select>
		<input type="text" name="keyword" value="액션">
		<input type="submit" value="검색">
	</form>
	<table border=1>
		<tr>
			<td colspan=9 align=right>
				<input type="button" value="추가하기" onclick="goInsert()">
			</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>대륙</th>
			<th>제작국가</th>
			<th>장르</th>
			<th>등급</th>
			<th>출연배우</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>
		<c:forEach var="mb" items="${ lists }">
		<tr>
			<td align=center>${ mb.num }</td>
			<td align=center><a href="detail.mv?num=${ mb.num }&pageNumber=${ pageInfo.pageNumber }">${ mb.title }</a></td>
			<td align=center>${ mb.continent }</td>
			<td align=center>${ mb.nation }</td>
			<td align=center>${ mb.genre }</td>
			<td align=right>${ mb.grade }</td>
			<td align=center>${ mb.actor }</td>
			<td align=center><a href="javascript:goDelete(${ mb.num },${ pageInfo.pageNumber })">삭제</a></td>
			<td align=center><input type="button" value="수정" onClick="goUpdate(${ mb.num },${ pageInfo.pageNumber })"></td>
		</tr>
		</c:forEach>
	</table>
	${ pageInfo.pagingHtml }
</center>
