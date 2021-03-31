<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

mall\mallList.jsp<br>

<center>
	<h2>주문 내역</h2>
	<table border=1>
		<tr>
			<td colspan="5" align=center>
				주문자 정보 : ${ loginInfo.name }(${ loginInfo.id })
			</td>
		</tr>
		<tr>
			<th>상품 번호</th>
			<th>상품명</th>
			<th>주문 수량</th>
			<th>단가</th>
			<th>금액</th>
		</tr>
		<c:forEach var="cart" items="${ sessionScope.shoplists }">
		<tr>
			<td align=center>${ cart.pnum }</td>
			<td align=center>${ cart.pname }</td>
			<td align=center>${ cart.oqty }</td>
			<td align=center>${ cart.price }</td>
			<td align=center>${ cart.amount }</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="4" align=center>
				<a href="calculate.mall">결재하기</a> &nbsp; &nbsp;
				<a href="list.prd">추가 주문</a>
			</td>
			<td align=center>총 금액 : ${ totalAmount }</td>
		</tr>
	</table>	
</center>
