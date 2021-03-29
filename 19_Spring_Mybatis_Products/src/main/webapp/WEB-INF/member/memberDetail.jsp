<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<style>
	table {
		width: 400px;
	}
</style>

memberDetail.jsp<br>
<h2>회원 정보 화면</h2>
<table border=1> 
	<tr>
		<th>
			<label for="id">아이디</label>
		</th>
		<td>
			${ member.id }
		</td>
	</tr>
	<tr>
		<th>
			<label for="name">이름</label>
		</th>
		<td>
			${ member.name }
		</td>
	</tr>
	<tr>
		<th>
			<label for="password">비번</label>
		</th>
		<td>
			${ member.password }
		</td>
	</tr>
	<tr>
		<th>
			<label for="gender">성별</label>
		</th>
		<td>
			${ member.gender }
		</td>
	</tr>
	<tr>
		<th>
			<label for="hobby">취미</label>
		</th>
		<td>
			${ member.hobby }
		</td>
	</tr>
	<tr>
		<th>
			<label for="address1">주소1</label>
		</th>
		<td>
			${ member.address1 }
		</td>
	</tr>
	<tr>
		<th>
			<label for="address2">주소2</label>
		</th>
		<td>
			${ member.address2 }
		</td>
	</tr>
	<tr>
		<th>
			<label for="mpoint">적립포인트</label>
		</th>
		<td>
			${ member.mpoint }
		</td>
	</tr>
	<tr>
		<td colspan=2>
			<a href="list.me">회원 리스트로 돌아가기</a>
		</td>
	</tr>
</table>