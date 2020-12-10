
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

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
					<h4 class="modal-title" id="myModalLabel">모달 제목</h4>
				</div>
				<div class="modal-body">
					<input id="replywriter" type="hidden" value="${session_id}">
					<input id="bno" type="hidden" value="${bno}">
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

<script type="text/javascript">
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
			location.href="reply.do?bno=${bno}";
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
			location.href="reply.do?bno=${bno}";
			
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