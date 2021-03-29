<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../common/common.jsp" %>
<script type="text/javascript">
	function insert() {
		location.href = "insert.ab";
	}
	
	function goUpdate(num,page) {
		//alert(num);
		location.href = "update.ab?num="+num+"&pageNumber="+page;
	}
</script>
<style>
	div { text-align : center; }
	table { margin : 0 auto; }
</style>
album\albumList.jsp<br>

<div>
	<h2>상품 리스트 화면(레코드갯수 : ${ totalCount })</h2>
	<form action="list.ab" method="get">
		<select name="whatColumn">
			<option value="all">전체 검색</option>
			<option value="title">노래제목</option>
			<option value="singer">가수명</option>
		</select>
		<input type="text" name="keyword" value="아이유">
		<input type="submit" value="검색">
	</form>
	<table border="1">
		<tr>
			<td colspan=7 align="right">
				<input type="button" value="추가하기" onClick="insert()">
			</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>노래제목</th>
			<th>가수명</th>
			<th>가격</th>
			<th>출간일</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>
		<c:forEach var="album" items="${ albumLists }">
		<tr>
			<td>${ album.num }</td>
			<td><c:out value="${ album.title }" /></td>
			<td>${ album.singer }</td>
			<td><fmt:formatNumber value="${ album.price }" pattern="#,###" />원</td>
			<td>
				<fmt:parseDate var="d" value="${ album.day }" dateStyle="short" pattern="yyyy-MM-dd" />
				<fmt:formatDate value="${ d }" pattern="yyyy-MM-dd" />
			</td>
			<td><a href="delete.ab?num=${ album.num }&pageNumber=${ pageInfo.pageNumber }">삭제</a></td>
			<td><a href="javascript:goUpdate(${ album.num },${ pageInfo.pageNumber })">수정</a></td>
		</tr>
		</c:forEach>
	</table>
</div>
<center>
	${ pageInfo.pagingHtml } <!-- getPagingHtml() -->
</center>
