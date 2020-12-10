<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<title>고구마마켓 게시판</title>
<link href="css/custom2.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-theme.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<style>
a{
	text-decoration:none;
	color:#000000;	
	font-size:2rem;
}
td{
	font-size:2.5rem;
	vertical-align:middle!important;
}
td>img{
	width:100px;
	height:100px;
}
.navbar {
    min-height: 90px !important;
}
/* change the background color */
.navbar-custom {
       background-color: #ff5500;
}
/* change the brand and text color */
.navbar-custom .navbar-brand,
.navbar-custom .navbar-text {
       color: rgba(255,255,255,.8);
}
/* change the link color */
.navbar-custom .navbar-nav .nav-link {
       color: rgba(255,255,255,.5);
}

/* change the color of active or hovered links */
.navbar-custom .nav-item.active .nav-link,
.navbar-custom .nav-item:hover .nav-link {
       color: #ffffff;
}

.navbar-toggler-icon {
  background-image: url("data:image/svg+xml;charset=utf8,%3Csvg viewBox='0 0 32 32' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath stroke='rgba(47, 46, 54, 0.5)' stroke-width='2' stroke-linecap='round' stroke-miterlimit='10' d='M4 8h24M4 16h24M4 24h24'/%3E%3C/svg%3E");
}

.navbar-toggler {
  border-color: rgb(47, 46, 54);
} 
footer{
 background-color: #ff5500;
 font-size: 2rem;
}
</style>

	  <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
</head>

<body>

<!--컨테이너 시작  -->

	<nav class="navbar navbar-expand-sm navbar-custom fixed-top">

	<!--nav바 로고 이미지  -->

   <a class="navbar-brand" href="list.do">
   <span class="brandfont"> <img src="images/potato.png" alt="Logo" style="width:60px;">&nbsp; SweetPotato Market</span>
  </a>

  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navMenu">
  	<span class="navbar-toggler-icon"></span>
  </button>
	<div class="collapse navbar-collapse" id="navMenu">
		<ul class="navbar-nav">
			<li class="nav-item">
				 <a href="areaList.do?id=${session_id}">쇼핑하기&nbsp;&nbsp;&nbsp;</a>
			</li>
			<li class="nav-item">
				 <a href="dip.do">찜목록2&nbsp;&nbsp;&nbsp;</a>
			</li>
			<li class="nav-item">
				 <a href="#">Link 3</a>
			</li>
		</ul>	
		<ul class="navbar-nav ml-auto">
			<c:choose>
					<c:when test="${empty session_id }">
						<li class="nav-item"><a class="nav-link" href="loginForm.do"
							id="login_a">로그인
						</a></li>
					</c:when>
					<c:otherwise>
						<span id="loginStatus">${session_id }님 반갑습니다</span>
						<li class="nav-item"><a class="nav-link" href="#"
							id="logout_a">로그아웃
						</a></li>
					</c:otherwise>
				</c:choose>
		</ul>	
	</div>
</nav>

<script type="text/javascript">
$('#logout_a').on('click', function(event){
	event.stopPropagation();
	location.href="logout.do";

});
</script>
<div class="container" style="margin-top: 100px">
<section class="py-5">