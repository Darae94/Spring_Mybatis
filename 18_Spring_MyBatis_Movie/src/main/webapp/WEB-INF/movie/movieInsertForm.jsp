<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<style>
	.err {
		font-size: 9pt;
		font-weight: bold;
		color: red;
	}
</style>

<script type="text/javascript">

	var continentArr = new Array('아시아','아프리카','유럽','아메리카','오세아니아');
	
	nationArr = [
				['한국','중국','베트남','네팔'],
				['케냐','가나','세네갈'],
				['스페인','영국','덴마크','러시아','체코'],
				['미국','캐나다'],
				['뉴질랜드','오스트레일리아']
			];
	
	// 기존에 선택된 값
	var f_val;
	var s_val;
	
	function init(continent,nation) {
		f_val = continent;
		s_val = nation;
		//alert(1);
		
		for(var i=0; i<continentArr.length; i++) {
			f.continent[i+1] = new Option(continentArr[i]);
			if(f_val == continentArr[i]) {
				f.continent[i+1].selected = true;
				firstChange();
			}
		}
	} // init
	
	function firstChange() {
		//alert(2);
		var s_sel = f.nation
		
		for(i=s_sel.length;i>0;i--) {
			s_sel[i] = null;
		}
		
		var f_idx = f.continent.selectedIndex;
		
		for(var i=0;i<nationArr[f_idx-1].length;i++){
			s_sel[i+1] = new Option(nationArr[f_idx-1][i]);
			if(s_val == nationArr[f_idx-1][i]) {
				s_sel[i+1].selected = true;
			}
		}
	} // firstChange
	
</script>

<body onLoad="init('${ movie.continent }','${ movie.nation }')">	
	movieInsertForm.jsp<br>
	
	<h2>영화 정보 등록 화면</h2>
	<form:form commandName="movie" name="f" action="insert.mv" method="post">
		<p>
			영화 제목 : <input type="text" name="title" value="${ movie.title }">
			<form:errors cssClass="err" path="title"></form:errors>
		</p>
		<p style="float:left;">
			대륙 : 
			<select name="continent" onChange="firstChange()">
				<option value=""> 대륙을 선택하세요
			</select>
			<form:errors cssClass="err" path="continent"></form:errors>
		</p>
		<p style="float:left;">
			&nbsp; &nbsp; &nbsp; &nbsp; 
			나라 : 
			<select name="nation">
				<option value=""> 나라를 선택하세요
			</select>
			<form:errors cssClass="err" path="nation"></form:errors>
		</p>
		<p style="clear:left;">
			장르 : 
			<input type="checkbox" name="genre" value="액션" <c:if test="${ fn:contains(movie.genre,'액션') }">checked</c:if>> 액션
			<input type="checkbox" name="genre" value="스릴러" <c:if test="${ fn:contains(movie.genre,'스릴러') }">checked</c:if>> 스릴러
			<input type="checkbox" name="genre" value="코미디" <c:if test="${ fn:contains(movie.genre,'코미디') }">checked</c:if>> 코미디
			<input type="checkbox" name="genre" value="판타지" <c:if test="${ fn:contains(movie.genre,'판타지') }">checked</c:if>>판타지
			<input type="checkbox" name="genre" value="애니메이션" <c:if test="${ fn:contains(movie.genre,'애니메이션') }">checked</c:if>> 애니메이션
			<form:errors cssClass="err" path="genre"></form:errors>
		</p>
		<p>
			등급 : 
			<input type="radio" name="grade" value="19" <c:if test="${ movie.grade == '19' }">checked</c:if>> 19
			<input type="radio" name="grade" value="15" <c:if test="${ movie.grade == '15' }">checked</c:if>> 15
			<input type="radio" name="grade" value="12" <c:if test="${ movie.grade == '12' }">checked</c:if>> 12
			<input type="radio" name="grade" value="7" <c:if test="${ movie.grade == '7'}">checked</c:if>> 7
			<form:errors cssClass="err" path="grade"></form:errors>
		</p>
		<p>
			출연 배우 : <input type="text" name="actor" value="${ movie.actor }">
			<form:errors cssClass="err" path="actor"></form:errors>
		</p>
		<input type="submit" value="추가하기">
	</form:form>
</body>
