<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="./../common/common.jsp"%>

<script type="text/javascript">
	function insert() {
		location.href="insert.tv";
	}
	
	function goUpdate(n, pn) {
		location.href="update.tv?num="+n+"&pageNumber="+pn;
	}
</script>

travelList.jsp<br>

<h2 align="center">여행 리스트 화면</h2>
<center>
	<form action="list.tv" method="get"> 
		<select name="whatColumn">
			<option value="all">전체 검색
			<option value="area">지역
			<option value="style">여행 타입
		</select>
		<input type="text" name="keyword" value="유럽">
		<input type="submit" value="검색">
	</form>
	
	<table border="1">
		<tr>
			<td colspan="8" align="right">
				<input type="button" value="추가하기" onclick="insert()">
			</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>관심지역</th>
			<th>여행타입</th>
			<th>예상비용</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>
		
		<c:forEach items="${ lists }" var="travel">
			<tr>
				<td align="center">
					${ travel.num }
				</td>
				<td>
					<a href="detail.tv?num=${ travel.num }&pageNumber=${ pageInfo.pageNumber }">${ travel.name }</a>
				</td>
				<td>
					${ travel.age }
				</td>
				<td>
					${ travel.area }
				</td>
				<td align="right">
					${ travel.style }
				</td>
				
				<td align="center">
					${ travel.price }만원
				</td>
				<td align="center">
					<a href="delete.tv?num=${ travel.num }&pageNumber=${ pageInfo.pageNumber }">삭제</a>
				</td>
				<td align="center">
					<input type="button" value="수정" onClick="goUpdate(${travel.num},${ pageInfo.pageNumber })">
				</td>
			</tr>
		</c:forEach>
	</table>

	${pageInfo.pagingHtml }	
	</center>
	
	
	
	
	
	
	
	
	
		