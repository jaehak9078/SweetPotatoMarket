<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>


<div class="container-fluid">
	<div class="row">
		<div class="col-md-6">
			<div class="carousel slide" id="carousel-513600">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-513600" class="active"></li>
					<li data-slide-to="1" data-target="#carousel-513600"></li>
					<li data-slide-to="2" data-target="#carousel-513600"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<c:if test="${not empty file1 }">
							<img alt="" src="../download.do?fileName=${file1}" class="ReadImg">
						</c:if>
						<img alt="" src="images/temp/${board.img}" class="ReadImg">
					</div>
					<!-- 					<div class="carousel-item"> -->
					<%-- 						<c:if test="${not empty file2 }"> --%>
					<%-- 							<img alt="" src="../download.do?fileName=${file2}" width=100 --%>
					<!-- 								height=100> -->
					<%-- 						</c:if> --%>

					<!-- 					</div> -->
					<!-- 					<div class="carousel-item"> -->
					<%-- 						<c:if test="${not empty file3 }"> --%>
					<%-- 							<img alt="" src="../download.do?fileName=${file3}" width=100 --%>
					<!-- 								height=100> -->
					<%-- 						</c:if> --%>
					<!-- 					</div> -->
				</div>
				<a class="carousel-control-prev" href="#carousel-513600"
					data-slide="prev"><span class="carousel-control-prev-icon"></span>
					<span class="sr-only">Previous</span></a> <a
					class="carousel-control-next" href="#carousel-513600"
					data-slide="next"><span class="carousel-control-next-icon"></span>
					<span class="sr-only">Next</span></a>
			</div>
		</div>
		<div class="col-md-6">
			<table class="table table-hover">
				<tr>
					<td>
						<h1>${board.title }</h1> ${board.status }
					</td>
				</tr>
				<tr>
					<td>
						<table>
							<tr>
								<td rowspan="2"><img alt=""
									src="../download.do?fileName=${file1}" class="Readimg"></td>
								<td>${board.id }</td>
							</tr>
							
							<tr>
								<td>${board.d_date}</td>
							</tr>

						</table>
				</tr>
				<tr>

				</tr>
				<!-- 				<tr> -->
				<%-- <%-- 					<td>${board.addr }</td> --%>
				<!-- 				</tr> -->
				<tr>
					<td>${board.context }</td>
				</tr>
				<tr>
					<td>조회수 ${board.readcount} 찜 ${board.likenum}</td>
					<td></td>
				</tr>


				<tr>
				
					<td><c:if test="${session_id==board.id }">
							<button type="button" id="btnUpdateForm" class="btn btn-warning">수정</button>
							<button type="button" id="btnDelete" class="btn btn-danger">삭제</button>
						</c:if>
						<button type="button" id="btnList" class="btn btn-info">목록보기</button>
						
					</td>
				
				</tr>
				
				<tr>
				<td>
				<c:if test="${not empty session_id }">
							<div class="wrap">
								<button class="button" id="btnLike">찜하기</button>
							</div>
						</c:if>
				</td>
				</tr>
			</table>
		</div>
	</div>
</div>
<!-- 댓글 -->
<div class="panel panel-default">
					<div class="panel-heading panel-comment">
						<span class="glyphicon glyphicon-comment"></span> 댓글
					<c:if test="${not empty session_id }">
						<button id="btnAddComment" type="button" class="btn btn-primary btn-xs pull-right">댓글쓰기</button>
					</c:if>
					</div>
					<div class="panel-body comment-body">
						<ul id="replyList" class="media-list">
							<c:forEach items="${replyList }" var="reply">
							<li class="media" data-rno="${reply.rno }"><a class="pull-left" href="#"> <img
									alt="not found" src="images/temp/${reply.img}" style="width:60px;height:60px ">
							</a>
								<div class="media-body">
									<div>
									
										<strong class="text-primary">${reply.id}</strong> <small
											class="pull-right text-muted">${reply.writedate}</small>
									</div>
									<p>${reply.replytext }</p>
									<c:if test="${not empty session_id && session_id==reply.id }">
									<button type="button" class="pull-right btn-xs btn-danger">삭제</button>
									</c:if>
								</div></li>
							</c:forEach>							
						</ul>
					</div>
				</div>
							
		<div class="modal" id="replyModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">댓글 달기</h4>
				</div>
				<div class="modal-body">
					<input id="replywriter" type="hidden" value="${session_id}">
					<input id="bno" type="hidden" value="${board.bno}">
					<div class="form-group">
						<label>댓글내용</label> 
						<textarea id="replytext" rows="5" cols="20" class="form-control" placeholder="댓글내용"></textarea>
					</div>
					

					
				</div>
				<div class="modal-footer">
				<button id="btnUpdateReply" type="button" class="btn btn-warning">수정</button>
				<button id="btnDeleteReply" type="button" class="btn btn-danger">삭제</button>
				<button id="btnAddReply" type="button" class="btn btn-primary">등록</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					
				</div>
			</div>
			<!-- 모달 콘텐츠 -->
		</div>
		<!-- 모달 다이얼로그 -->
	</div>

<!-- Modal: 메세지 박스  -->
<div class="modal" id="deleteModal" tabindex="-1"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
<!-- 			<div class="modal-header"> -->
<!-- 				<button type="button" class="close" data-dismiss="modal"> -->
<!-- 					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span> -->
<!-- 				</button> -->
<!-- 				<h4 class="modal-title" id="myModalLabel">Login</h4> -->
<!-- 			</div> -->
			<div class="modal-body">
				<div class="form-group">
					<p>정말로 삭제하시겠습니까?</p>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" id="btnYes" class="btn btn-primary">네</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">아니오</button>
			</div>
		</div>
		<!-- 모달 콘텐츠 -->
	</div>
	<!-- 모달 다이얼로그 -->
</div>
<!-- 모달 전체 윈도우 -->
<script type="text/javascript">
		var modal = $("#deleteModal");

		$('#btnDelete').on('click', function(event) {
			//$(this).next().fadeToggle();
			event.stopPropagation(); // 부모요소에 동일한 클릭이벤트 전파를 막기
			
			modal.modal('show'); // 모달 대화상자 띄우기
		});

		$("#btnUpdateForm")
				.on(
						'click',
						function() {
							location.href = "updateForm.do?bno=${board.bno}&pageNum=${param.pageNum}";
						});
		$("#btnYes")
				.on(
						'click',
						function() {
							location.href = "delete.do?bno=${board.bno}&pageNum=${param.pageNum}";
							alert("삭제되었습니다.")
						});
		$("#btnList").on('click', function() {
			location.href = "list.do?pageNum=${param.pageNum}";
		});
		
		$("#btnLike").on('click',function(){
			
			location.href = "like.do?id=${session_id}&bno=${board.bno}";
		});
		
		
		
		
		//댓글부분
		
		
		$('.panel-comment').on('click', function() {
	$(this).next().slideToggle();
});
$("#btnUpdateForm").on('click',function(){
	location.href="updateForm.do?bno=${board.bno}&pageNum=${param.pageNum}";
});
$("#btnDelete").on('click',function(){
	location.href="delete.do?bno=${board.bno}&pageNum=${param.pageNum}";
});
$("#btnList").on('click',function(){
	location.href="list.do?pageNum=${param.pageNum}";
});

$('#btnAddComment').on('click',function(){
//	return false;
event.stopPropagation(); //부모요소에 동일한 클릭이벤트 전파를 막기

//$('#replyModal').find("button[id='btnUpdateReply]").hide();
$('#replyModal').find("#btnUpdateReply").hide();
$('#replyModal').find("#btnDeleteReply").hide();
$('#replyModal').modal('show');

});

$("#btnAddReply").on('click',function(){
var query={
		"replytext":$("#replytext").val(),
		"writer":$("#replywriter").val(),
		"bno":$("#bno").val()
};
$.ajax({
	type:"post",
	data:query,
	url:"replyAdd.do",
	async:false,
	success:function(data,textStatus){
		if(data=='success'){
			alert('1개의 댓글을 추가하였습니다.');
			$("#replyModal").modal("hide");
			location.href="read.do?bno=${board.bno}";
		}else{
			alert('댓글 추가 실패');
		}
	},error:function(data,textStatus){
		alert("error");
	}
});
});

$("#replyList li").on('click',function(){
var rno=$(this).data('rno');
$.ajax({
	type:"post",
	url:"replyDelete.do",
	data:{"rno":rno},
	async:false,
	success:function(data,textStatus){
		if(data=='success'){
			alert("1개의 댓글을 삭제 하였습니다.");
			location.href=location.href;
			location.href="read.do?bno=${board.bno}";
			
		}else{
			alert("댓글 삭제 실패");
		}
	},error:function(data,textStatus){
		alert("error");
	}
});
});
	 
	</script>
<%@ include file="../include/footer.jsp"%>