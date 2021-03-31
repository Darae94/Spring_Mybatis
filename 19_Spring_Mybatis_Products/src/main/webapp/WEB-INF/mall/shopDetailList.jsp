<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
shopDetailList.jsp<br>
<br>
<a href="logout.jsp">로그아웃</a>
<br>

<center>
	<h2>주문 상세 내역</h2>
	<table border=1>
		<tr>
			<td colspan=3>고객 : ${ sessionScope.loginInfo.name }</td>
			<td colspan=2>송장 번호 : ${ requestScope.oid }</td>
		</tr>
		<tr>
			<td colspan=5>배송지 : ${ sessionScope.loginInfo.address1 } ${ loginInfo.address2 }</td>
		</tr>
		<tr>
			<th>순번</th>
			<th>상품명(상품번호)</th>
			<th>수량</th>
			<th>단가</th>
			<th>금액</th>
		</tr>
		<c:forEach items="${ lists }" var="sh" varStatus="shStatus">
		<tr>
			<td align=center>${ shStatus.count }</td>
			<td>${ sh.pname }(${ sh.pnum })</td>
			<td align=center>${ sh.oqty }</td>
			<td align="right"><fmt:formatNumber pattern="#,###">${ sh.price }</fmt:formatNumber></td>
			<td align="right"><fmt:formatNumber pattern="#,###" value="${ sh.amount }" /></td>
		</tr>
		</c:forEach>
	</table>
</center>
