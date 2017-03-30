<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src ="../js/customer/notice.js"></script>
<!-- <script>
window.addEventListener("load",function(){
	alert("Hello");
});

</script> -->
<link href="../css/reset.css" type="text/css" rel="stylesheet" />


<!-- 합쳐지고 최소화된 최신 CSS -->
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

부가적인 테마
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

합쳐지고 최소화된 최신 자바스크립트
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

 -->

<link href="../css/account/layout.css" type="text/css" rel="stylesheet" />
<link href="../css/account/style.css" type="text/css" rel="stylesheet" />

<style>
/* h2, h3 {
   color: lime;
   font-size: 30px;
}

nav ~ p {
   color: red;
}

h1.h2 {
   color: green;
}

nav>.h2 {
   color: orange;
}

.h2 {
   color: red;
}

#main-menu의 자손중에 li가 있느냐 
#main-menu>h3 {
   color: red;
} 
*/
</style>
</head>
<body>
	<!-- ------------header------------------------------------------------------------------- -->
	<header id="header">
		<div class="content-container">
			<h1 id="logo">
				<img src="../images/logo.png" />
			</h1>

			<section>
				<h1 class="hidden">헤더</h1>

				<nav id="main-menu" class="hr-menu">
					<h1>
						메인메뉴 <input type="button" value="클릭" id="btn-result">

					</h1>
					</h3>
					<ul>
						<li><a href="">학습가이드</a></li>
						<li><a href="">뉴렉과정</a></li>
						<li><a href="">강좌선택</a></li>
					</ul>
				</nav>

				<div id="lectur-serch-form">
					<h3 class="hidden">강좌검색폼</h3>
					<form>
						<fieldset>
							<legend class="hidden">검색 필드</legend>
							<label>과정검색</label> <input type="text" /> <input
								class="lecture-search-botton" type="button" value="검색" />
						</fieldset>


					</form>
				</div>

				<nav id="account-menu" class="hr-menu">
					<h1 class="hidden">
						계정메뉴
						</h3>
						<ul>
							<li class="first"><a href="../index.html">HOME</a></li>
							<li><a href="../joinus/login.html">로그인</a></li>
							<li><a href="../joinus/agree.html">회원가입</a></li>
						</ul>
				</nav>

				<nav id="member-menu" class="hr-menu">
					<h1 class="hidden">회원메뉴</h1>
					<ul>
						<li><a href="">마이페이지</a></li>
						<li><a href="">고객센터</a></li>
					</ul>

				</nav>
			</section>
		</div>
	</header>
	<!-- ------------visual------------------------------------------------------------------- -->
	<div id="visual">
		<div class="content-container"></div>
		<!--       visual      -->
	</div>
	</div>
	<!-- ------------body------------------------------------------------------------------- -->
	<div id="body">
		<div class="content-container">
			<aside id="aside">
				<h1 class="aside-title aside-margin">고객센터</h1>

				<nav class="aside-title aside-margin">
					<h1 class="hidden">고객센터메뉴</h1>
					<ul>
						<li class="aside-menu-item">공지사항</li>
						<li class="aside-menu-item">1:1고객문의</li>
						<li class="aside-menu-item">학습안내</li>
					</ul>
				</nav>
				<nav>
					<h1 class="aside-title margin">추천사이트</h1>
					<ul>
						<li class="aside-menu-link"><a href=""><img alt="앤서이즈"
								src="../images/answeris.png"></a></li>
						<li class="aside-menu-link"><a href=""><img alt="W3C"
								src="../images/w3c.png"></a></li>
						<li class="aside-menu-link"><a href=""><img
								alt="마이크로 소프트" src="../images/microsoft.png"></a></li>
					</ul>
				</nav>
				<h3>구글광고</h3>
				<li>유니티</li>
			</aside>

			<main id="main">
			<div class="breadcrumb">
				<h3 class="hidden">현재</h3>
				<ul>
					<li>home</li>
					<li>고객센터</li>
					<li>공지사항</li>
				</ul>
			</div>

	<form>
               <fieldset>
                  <legend class="hidden">검색필드</legend>
                  <label class="hidden">검색분류</label> <select name="f">
                     <c:if test="${param.f == 'TITLE' }">
                        <c:set var="selTitle" value="selected" />
                     </c:if>
                     <c:if test="${param.f == 'CONTENT' }">
                        <c:set var="selContent" value="selected" />
                     </c:if>
                     
                     <option value="TITLE"${selTitle}>제목</option>
                     <option value="CONTENT"${selContent}>내용</option>
                  </select> <label class="hidden">검색어</label> 
                  <input name="q" type="text" value="${parm.q }" placeholder="검색어를 입력하세요" /> 
                  <input class="btn btn-search" type="submit" value="검색" /> 
                  <input type="hidden" name="p" value="1" />
               </fieldset>
            </form>


			<h2>검색</h2>

			<div class="notice">
				<h3>공지목록 [${size}]</h3>
				<script type="text/javascript">
					window.addEventListener("load", function() {
						
						var morebutton = document.querySelector("#more-button");
						
						/*var notices = [
							{code:"1",title:"오오오"},
							{code:"2",title:"육육육"},
							{code:"3",title:"칠칠칠"}
							]; */
						/* var request = new ActiveXObject("Microsoft.XMLHTTP"); */
			
						
						morebutton.onclick = function(){
								
							var request = new window.XMLHttpRequest();
							request.open("GET","notice.jsp",false);
							request.send();
							alert(request.responseText);
							
								var template = document.querySelector("#notice-row");
								
								for(var i in notices){
					
								var tbody = document.querySelector(".notice-table tbody");
								
								var tds = template.content.querySelectorAll("td");
								
								tds[0].innerText = notices[i].code;
								tds[1].innerText = notices[i].title;
								
								var clone = document.importNode(template.content,true);
								tbody.appendChild(clone);
							}
						};
						
					});
				</script>
				<template id ="notice-row">
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
				</template>
				<table class="table notice-table">
					<thead>
						<tr>
							<td>번호</td>
							<td>제목</td>
							<td>작성자</td>
							<td>작성일</td>
							<td>조회수</td>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="f" items="${list}">
						<tr>
							<td>${f.title }</td>
							<td><a href ="notice-detail?c=${f.code}">${f.title}</a></td>
							<td>${f.writerName }</td>
							<td>${f.regDate }</td>
							<td>${f.hit }</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="margin">
               <div><a href="">이전</a></div>
               <ul>
        <%--        	<c:forEach var="data" begin="0" end="${last}" varStatus="st">
	               
	               <li><a href="?p=${st.index + 1}&f=${parm.f }&q=${parm.q}">${st.index + 1 }</a></li>
	                  
	               
	            </c:forEach> --%>
               </ul>
               <div><a href="">다음</a></div>
            </div>    
			
			<div>
				<span id ="more-button">더보기</span>
			</div>
			
			</main>
		</div>

	</div>

	<!-- ------------footer------------------------------------------------------------------- -->
	<footer id="footer">
		<div class="content-container">
			<!-- <h2>회사정보</h2>
      <div>Copyright ⓒ newlecture.com 2012-2014 All Right Reserved.
         Contact admin@newlecture.com for more information</div> -->
		</div>
	</footer>


</body>
</html>