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

productInsertForm.jsp<br>

<h2>상품 추가  화면</h2>
<form:form commandName="product" method="post" action="insert.prd" enctype="multipart/form-data">
	<p>
		상품명 : <input type="text" name="name" value="${ product.name }">
		<form:errors cssClass="err" path="name" />
	</p>
	<p>
		제조회사 : <input type="text" name="company" value="${ product.company }">
		<form:errors cssClass="err" path="company" />
	</p>
	<p>
		가격 : <input type="text" name="price" value="${ product.price }">
		<form:errors cssClass="err" path="price" />
	</p>
	<p>
		재고수량 : <input type="text" name="stock" value="${ product.stock }">
	</p>
	<p>
		적립포인트 : <input type="text" name="point" value="${ product.point }">
	</p>
	<p>
		설명 : <input type="text" name="contents" value="${ product.contents }">
		<form:errors cssClass="err" path="contents" />
	</p>
	<p>
		그림화일 : <input type="file" name="upload"> ${ product.image } 
		<form:errors cssClass="err" path="image" />
	</p>
	<p>
		입고일자 : <input type="text" name="inputdate" value="${ product.inputdate }">
	</p>
	<p>
		<input type="submit" value="추가하기">
	</p>
</form:form>
