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

productUpdateForm.jsp<br>

<center>
	<h2>상품 수정 화면</h2>
	<form:form commandName="product" method="post" action="update.prd" enctype="multipart/form-data">
		<input type="hidden" name="num" value="${ product.num }">
		<table border=1>
			<tr>
				<td>상품명</td>
				<td>
					<input type="text" name="name" value="${ product.name }">
					<form:errors cssClass="err" path="name" />
				</td>
			</tr>
			<tr>
				<td>제조 회사</td>
				<td><input type="text" name="company" value="${ product.company }"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td>
					<input type="text" name="price" value="${ product.price }">
					<form:errors cssClass="err" path="price" />
				</td>
			</tr>
			<tr>
				<td>재고 수량</td>
				<td><input type="text" name="stock" value="${ product.stock }"></td>
			</tr>
			<tr>
				<td>적립 포인트</td>
				<td><input type="text" name="point" value="${ product.point }"></td>
			</tr>
			<tr>
				<td>설명</td>
				<td>
					<input type="text" name="contents" value="${ product.contents }">
					<form:errors cssClass="err" path="contents" />
				</td>
			</tr>
			<tr>
				<td>그림 파일</td>
				<td>
					<c:if test="${ product.image != '' }">
					<img src="<%=request.getContextPath()%>/resources/${ product.image }" width=100 height=100 alt="${ product.name } 이미지"><br>
					</c:if>
					<input type="file" name="upload">
					<input type="hidden" name="upload2" value="${ product.image }">
				</td>
			</tr>
			<tr>
				<td colspan=2 align="center">
					<input type="submit" value="수정하기">
				</td>
			</tr>
		</table>
	</form:form>
</center>
