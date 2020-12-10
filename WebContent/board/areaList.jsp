<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>


<div class="col-md-12">

				<h1>${area} 중고거래 품목</h1>

				<hr>

				<button type="button" class="btn btn-primary pull-right" style='font-size:10px'>판매하기 <i class='fas fa-pencil-alt'></i></button>

		<table class="table table-striped">

  <thead>

   <tr>

     <th>사 진 </th>

     <th>제 목</th>

     <th>글쓴이</th>
     
     <th>가격</th>
    
     
     <th>좋아요</th>

   </tr>

   </thead>
	<tbody>

<c:forEach items="${list }" var="board">
      <tr>
          
          
          <c:choose>
             <c:when test="${board.status == '판매중'}">
             <td><img src="images/temp/${board.img}" width="200" height="200">
             <td><a href="reply.do?bno=${board.bno}&pageNum=${pageM.currentPage}">${board.title}</td>
             <td>${board.id}</td>
          	<td>${board.price}</td>
          	<td>${board.likenum }</td>
             </c:when>
             <c:otherwise>
             <td><img src="images/temp/${board.img}" width="200" height="200" class="soldout">
             <td><a href="reply.do?bno=${board.bno}&pageNum=${pageM.currentPage}" class="soldout">${board.title}(판매완료)</td>
             <td class="soldout">${board.id}</td>
          <td class="soldout">${board.price}</td>
          <td class="soldout">${board.likenum }</td>
             </c:otherwise>
          </c:choose>
          
      </tr>
   </c:forEach>
   
	</tbody>
  

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



<%@ include file="../include/footer.jsp"%>
