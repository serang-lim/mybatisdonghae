<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../header.jsp"%>
<!-- 본 문 시 작 -->
<h3 align="center"> 프 로 모 션 </h3>
<form name="TpromotionWrite" enctype="multipart/form-data" method="post" action="TpromotionWrite2.do">
	<table border="1" align="center">
	<tr>
	<th width="15%">분류</th>
	<td><input type="text" name="ticon" id="ticon"></td>
		<!-- <th width="15%">분류</th>
		<td> <select name="ticon" id="ticon">
				<option value="주위식당">주위식당</option>
				<option value="주요행사">주요행사</option>
				<option value="숙소">숙소</option>
				<option value="액티비티">액티비티</option>
			 </select>
		</td> -->
	</tr>
	<tr>
	<th width="15%">지역</th>
	<td><input type="text" name="tregion" id="tregion"></td>
		<!-- <th width="15%">지역</th>
			<td> <select name="tregion" id="tregion">
				<option value="강릉">강릉</option>
				<option value="속초">속초</option>
				<option value="삼척">삼척</option>
				<option value="동해">동해</option>
			 </select></td> -->
	</tr>
	<tr>	
		<th width="15%">사업자번호</th>
			<td><input type="text" name="tnum" id="tnum"></td>
	</tr>
	<tr>	
		<th width="15%">제목</th>
			<td><input type="text" name="tsubject" id="tsubject"></td>
	</tr>
	<tr>
		<th width="15%">관리자아이디</th>
			<td><input type="text" name="twriter" id="twriter" value="${s_id }"></td>
	</tr>
	<tr>
		<th width="15%">메인 사진</th>
			<td><input type="file" name="timageNameMF" id="timageNameMF" value="main사진"></td>
	</tr>
	<tr>
		<th width="15%">프로모션 사진</th>
			<td><input type="file" name="timageNameMF2" id="timageNameMF2" value="read사진"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="프로모션등록">
		
		</td>
		</tr>
	</table>
</form>
	<div align="center">
	<input type="button" value="목록으로" onclick="location.href='Tpromotion/Tpromotion.do'">
	<input type="button" value="HOME" onclick="location.href='../index.do'">
	</div>
<!-- 본 문 끝 !! -->
<%@ include file="../footer.jsp"%>