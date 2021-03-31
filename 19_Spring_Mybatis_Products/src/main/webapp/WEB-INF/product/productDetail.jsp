<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	table {
		border-collapse: collapse;
		border: solid 2px black;
	}
	
	td {
		border: solid 2px black;
		padding: 3px;
	}
	
	img  {
		width:100px;
		height:100px;
	}
	
	form {
		margin: 0;
	}
</style>

<!-- detail.prd -->
productDetail.jsp<br>
<%-- <%=request.getContextPath()%>/resources/${ product.image }<br> --%>

<h2>상품 상세 화면</h2>
<table>
	<tr>
		<td>
			<img src="<%=request.getContextPath()%>/resources/${ product.image }" alt="${ product.name } 이미지">
		</td>
		<td>
			<table border=1>
				<tr height="50">
					<td>상품명</td>
					<td>${ product.name }</td>
				</tr>
				<tr height="50">
					<td>가격</td>
					<td>${ product.price } 원</td>
				</tr>
				<tr height="50">
					<td>재고 수량</td>
					<td>${ product.stock }</td>
				</tr>
				<tr height="50">
					<td>설명</td>
					<td>${ product.contents }</td>
				</tr>
				<tr height="50">
					<td>주문 수량</td>
					<td>
					<!-- add.mall => mall.controller.CartAddController -->
						<form action="add.mall" method="post">
							<input type="hidden" name="num" value="${ product.num }">
							<input type="text" name="orderqty" value=1>
							<input type="submit" value="주문">
						</form>
					</td>
				</tr>
				<tr height="50">
					<td colspan=2 align="center">
						<a href="list.prd">상품 리스트</a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
