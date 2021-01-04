<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../header.jsp"%>
<!-- 본 문 시 작 -->
<!-- 페이지 리스트 -->

<br>
<h3 align="center"> 프 로 모 션 </h3>
	<table border="1" align="center" style="font-size:15pt">
	<tr align="center">
		<th width="20%">분류</th>
		<th width="10%">글번호</th>
		<th width="20%">사진</th>
		<th width="10%">지역</th>
		<th width="30%">제목</th>
		<th width="15%">작성일</th>
	</tr>
	<c:forEach items="${list}" var="dto" >
	<tr align="center">
		<td>${dto.ticon }</td>
		<td>${dto.tbno }</td>
		<td><img src="../storage/${dto.timageName }" width="60%" height="auto"></td>
		<td>${dto.tregion}</td>
		<td><a href="TpromotionRead.do?tbno=${dto.tbno }">${dto.tsubject }</a></td>
		<td style="font-size:12pt;">${fn:substring(dto.twdate,0,10) }</td>
	</tr>	
	</c:forEach>
	
	</table>	
	<!-- 검색 끝 -->
	<br><br><br>
	
		<!-- 검색 시작  -->

			<form action="Tpromotion2.do" align="center" method="post">
				<div align="center">
				<c:if test="${total_cnt>0 }">
					<c:set var="pageCount" value="${totalPage }"/>
					<c:set var="startPage" value="${startPage }"/>
					<c:set var="endPage" value="${endPage }"/>
				
					
						<c:if test="${endPage>pageCount }">
							<c:set var="endPage" value="${pageCount+1 }"/>
						</c:if>
					<ul class="pagination">
						<c:if test="${startPage>0 }">
							<li><a href="Tpromotion2.do?pageNum=${startPage }">이전</a></li>
						</c:if>
					
						<c:forEach var="i" begin="${startPage+1 }" end="${endPage-1 }">
							<li><a href="Tpromotion.do?pageNum=${i }">${i }</a></li>
						</c:forEach>
					
						<c:if test="${endPage<pageCount }">
							<li><a href="Tpromotion2.do?pageNum=${startPage+11 }">다음</a></li>
						</c:if>
					</ul>
				
				</c:if>
				</div>
				<input type="hidden" name="nowPage" id="nowPage" value="1">
				<input type="hidden" name="recordPerPage" id="recordPerPage" value="5">
				<input type="hidden" name="totalRecord" id="totalRecord" value="10">
				
				<select name="col1">
					<option value="0" >지역선택
					<option value="강릉" ${dto.tregion.equals("강릉") ?"selected" : ""}>강릉
					<option value="속초" ${dto.tregion.equals("속초") ?"selected" : ""}>속초
					<option value="삼척" ${dto.tregion.equals("삼척") ?"selected" : ""}>삼척
					<option value="동해" ${dto.tregion.equals("동해") ?"selected" : ""}>동해		
				</select>
				<select name="col2">
					<option value="0">분류선택
					<option value="숙소">숙소
					<option value="주요행사">주요행사
					<option value="주위식당">주위식당
					<option value="액티비티">액티비티
				</select>
				<input type="submit" value="검색">
			</form>
	
	<div align="center" style="padding: 1%  1%  1%  1%;">
		<c:if test="${sessionScope.s_mlevel=='B1'}"><!-- 멤버레벨이 관리자면 보여짐 -->
		<input type="button" value="프로모션 등록하기" onclick="location.href='TpromotionWrite.do'">
		</c:if>
		<input type="button" value="프로모션 등록하기" onclick="location.href='TpromotionWrite.do'">
		<input type="button" value="메인으로" onclick="location.href='./index.do'">
	</div>
	<br><br><br>	


	
	
<!-- 본 문 끝 !! -->
<%@ include file="../footer.jsp"%>