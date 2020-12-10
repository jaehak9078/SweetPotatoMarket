<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>고구마마켓 게시판</title>
<link href="../css/custom2.css" rel="stylesheet">
<link href="../css/bootstrap.css" rel="stylesheet">

<link href="../css/bootstrap-theme.css" rel="stylesheet">



<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
a{
	text-decoration:none;
	color:#000000;	
	font-size:2.5rem;
}
td{
	font-size:2.5rem;
	vertical-align:middle!important;
}
td>img{
	width:100px;
	height:100px;
}

</style>
</head>

<body>

<!--컨테이너 시작  -->

<div class="container">

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

	<!--nav바 로고 이미지  -->

   <a class="navbar-brand" href="#">

   <span class="brandfont"> <img src="../images/potato.png" alt="Logo" style="width:60px;">&nbsp &nbsp고구마마켓</span>

  </a>

  

  <ul class="navbar-nav" style='font-size:2rem'>

    <li class="nav-item">

      <a class="nav-link" href="#">쇼핑하기</a>

    </li>

    <li class="nav-item">

      <a class="nav-link" href="#">찜목록</a>

    </li>

    <li class="nav-item">

      <a class="nav-link" href="#">Link 3</a>

    </li>

   

  </ul>

  <ul class="navbar-nav navbar-right" style='font-size:2rem; text-align:right' >

  	 <li class="nav-item">

      <a class="nav-link" href="#">Link 3</a>

    </li>

    <li class="nav-item">

      <a class="nav-link" href="#">Link 3</a>

    </li>

  </ul>

</nav>

<!-- 게시판 시작  -->
<div class="col-md-10">

				<h1>중고거래 품목</h1>

				<hr>

				<button type="button" class="btn btn-primary pull-right" style='font-size:10px'>판매하기 <i class='fas fa-pencil-alt'></i></button>

		<table class="table table-striped">

  <thead>

   <tr>

     <th>사 진 </th>

     <th>제 목</th>

     <th>글쓴이</th>
     
     <th>판매여부</th>

   </tr>

   </thead>

   <tr>

     <td><img src="../images/alpaca1.jpg" alt="판매사진"></td>

     <td><a href="content.html">알파카 분양합니다 </td>

     <td>김재학</td>
     
     <td>판매중</td>

   </tr>

   <tr>

     <td><img src="../images/alpaca2.jpg" alt="판매사진" ></td>

     <td><a href="content.html">알파카 분양합니다 </td>

     <td>김재학</td>
     
     <td>판매중</td>

   </tr>

   <tr>

     <td><img src="../images/alpaca3.jpg" alt="판매사진"></td>

     <td><a href="content.html">알파카 분양합니다 </td>

     <td>김재학</td>
     
     <td>판매중</td>

   </tr>

   <tr>

     <td><img src="../images/alpaca4.jpg" alt="판매사진"></td>

     <td><a href="content.html">알파카 분양합니다 </td>

     <td>김재학</td>
     
     <td>판매중</td>

   </tr>

   <tr>

     <td><img src="../images/alpaca5.jpg" alt="판매사진"></td>

     <td><a href="content.html">알파카 분양합니다 </td>

     <td>김재학</td>
     
     <td>판매중</td>

   </tr>

   <tr>

     <td><img src="../images/alpaca6.jpg" alt="판매사진""></td>

     <td><a href="content.html">알파카 분양합니다 </td>

     <td>김재학</td>
     
     <td>판매중</td>

   </tr>

 </table>

 

	<ul class="pagination">

    <li class="disabled"><a href="#">«</a></li>

    <li class="active"><a href="#">1</a></li>

    <li><a href="#">2</a></li>

    <li><a href="#">3</a></li>

    <li><a href="#">4</a></li>

    <li><a href="#">5</a></li>

    <li><a href="#">»</a></li>

   </ul>

 

</div>

 

 

 

 

 

<!-- 컨테이너 끝 -->

</div>

 

 

<script src='https://kit.fontawesome.com/a076d05399.js'></script>

<script src="../js/jquery-3.5.1.min.js"></script>

<script src="../js/bootstrap.js"></script>

</body>

</html>