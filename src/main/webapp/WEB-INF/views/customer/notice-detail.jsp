<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main id="main">
      
            <h2 class="main-title">공지사항 등록</h2>
            
            <div class="breadcrumb">
               <h3 class="hidden">현재경로</h3>
               <ul>
                  <li>home</li>
                  <li>고객센터</li>
                  <li>공지사항</li>
               </ul>
            </div>
               
            <form action="notice-reg-proc.jsp" method="post">
            <table border="1">
               <tbody>
                  <tr>
                     <th>제목</th>
                     <td>${n.title}</td>
                  </tr>
				 <tr>
                     <th>작성자</th>
                     <td>${n.writer}</td>
                  </tr>
                  <tr>
                     <th>작성일</th>
                     <td>${n.regDate}</td>
                  </tr>
                  <tr>
                     <th>조회수</th>
                     <td>${n.hit}</td>
                  </tr>
                  <tr>
	                 <td colspan="2">
	                     <textarea rows="20" cols="80" name = "content">${n.content}</textarea>
	                 </td>
	              </tr>
	                  
                  <tr>
                  <tr>
                     <th>첨부파일</th>
          <%--            <%
                  
                     String hbs = "롤,코딩,자기,먹기";
                     
                     pageContext.setAttribute("hbs",hbs);
                     
                     %>
             		<c:forTokens var="hb" items="${hbs }" delims=",">
             		
             		${hb }<br/>
             		</c:forTokens> --%>
                     
                     
                     <c:forEach var="f" items="${list}">
                     
                     <a href ="upload/${f.src }">${f.src}</a>
                     
                     </c:forEach>
                  </tr>
                  <tr>
                     <td colspan="2"></td>
                  </tr>
     
               </tbody>
            </table>
            <div>
               <a href="notice">목록</a>      
               <a href="notice-edit?c=${n.code}">수정</a>
               <a href="notice-del?c=${n.code}">삭제</a>
            </div>
				<div>
					<ul>
						<li>
							<span>이전글:</span>
							<c:if test="${ empty prev}">
							<span>이전글이 없습니다.</span>
							</c:if>
							<c:if test="${not empty next}">
							<a href="notice-detail?c=${prev.code}">${prev["title"]}</a>
							</c:if>
						</li>
						<li>
							
							<span>다음:</span>
							<c:if test="${ empty next}">
							<span>다음 글이 없습니다.</span>
							</c:if>
							<c:if test="${not empty next}">
							<a href="notice-detail?c=${next.code}">${next["title"]}</a>
							</c:if>
						</li>
					</ul>
				</div>
			</form>            
         </main>