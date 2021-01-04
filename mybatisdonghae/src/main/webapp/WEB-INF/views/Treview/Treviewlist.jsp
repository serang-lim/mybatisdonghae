<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<%@ include file="../header.jsp" %>
<!-- 본문 시작 Treview.jsp -->
   <h3 align="center">후기</h3>
   <p><a href="createrform.do">[작성하기]</a></p>
   <table border='1' class="table_list" >
   <tr>
      <th>글번호</th>
      <th>지역</th>
      <th>제목</th>
      <th>작성자</th>
      <th>작성일</th>
      <th>조회수</th>
   </tr>
   <c:forEach var="dto" items="${list}">
   <tr>
      <td>${dto.rnum}</td>
      <td>${dto.rregion}</td>
      <td><a href="read.do?rnum=${dto.rnum}">${dto.rsubject}</a></td>
      <td>${dto.rid}</td>
      <td>${dto.rdate}</td>
      <td>${dto.rreadcnt}</td>
   </tr>
   </c:forEach>
   </table>
<!-- 
   <div class='bottom'>
   <input type='button' value='HOME' onclick="location.href='${root}/index.do'">
   </div>   
	<form action="Treview2.do" align="center">
         <select name="col">
            <option value="0">지역선택
            <option value="강릉">강릉
            <option value="속초">속초
            <option value="삼척">삼척
            <option value="동해">동해      
         </select>
         <input type="text" name="word" placeholder="아이디검색">
         <input type="submit" value="검색">
      </form>
   -->    
    

	<div align="center">
    <!-- pagination -->
        <ul class="pagination">
            <!-- 이전 -->
            <c:choose>
                <c:when test="${pageMaker.prev} ">              
                        <a href="/notice/noticeList.do${pageMaker.makeSearch(pageMaker.startPage-1)}" class="paginate_button previous">     
                        이전 
                        </a>
                </c:when>
                <c:otherwise>                   
                        <a href="/notice/noticeList.do${pageMaker.makeSearch(pageMaker.startPage-1) }" class="paginate_button previous">
                        이전 
                        </a>
                </c:otherwise>
            </c:choose>
 
            <!-- 페이지 번호 -->
            <c:foreach var="idx" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                    <a href="/notice/noticeList.do${pageMaker.makeSearch(idx)}">
                      
                    ${idx}
                      
                    </a>
            </c:foreach>
 
            <!-- 이후 -->
            <c:choose>
                <c:when test="${pageMaker.next}">
                        <a href="/notice/noticeList.do${pageMaker.makeSearch(pageMaker.endPage+1)}" class="paginate_button next">
                         다음
                        </a>
                </c:when>
                <c:otherwise>
                        <a href="/notice/noticeList.do${pageMaker.makeSearch(pageMaker.endPage+1)}" class="paginate_button next disabled">                      
                         다음
                        </a>
                </c:otherwise>
            </c:choose>
        <span class="current">22/33</span></ul>
    </div>
	<div align="right">
                <!-- 검색 타입 선택 리스트 -->
                <select name="searchType" class="selectBox">
                    <option value="t" <c:out=""/>>제목</option>
                    <option value="w" <c:out=""/>>작성자</option>
                </select>
                <!-- 키워드 입력 부분 -->
                <input type="text" name="keyword" placeholder="Search" value="${pageMaker.cri.keyword}" style="height: 28px;">
                <!-- 검색 버튼 -->
                <button type="submit" id="searchBtn" class="btn-search"><img src="${path}/resources/image/search1.png" align="bottom"></button>                  
        </div>
       
        
        $(function(){   
    $('.disabled').on('click', function(event){
        event.preventDefault();
    }); 
    /* 검색 버튼 클릭 이벤트 핸들러 */
    $('#searchBtn').on("click", function(event){        
        // 검색옵션 값 가져오고
        var searchType = $("select[name=searchType]").val();        
        // 키워드 값 가져와서
        var keyword = $("input[name=keyword]").val();       
        self.location = "/notice/noticeList.do${pageMaker.makeQuery(1)}&searchType=" + searchType + "&keyword=" + encodeURI(keyword);
    });//on()       
});
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %> 