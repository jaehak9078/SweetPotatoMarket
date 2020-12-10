<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<div class="container-fluid">
	<div class="row">
		<form action="write.do" method="post" enctype="multipart/form-data">
			<div class="col-md-6">

				<label class="col-xs-2 col-lg-2 control-label">파일첨부</label> <input
					type=file id="file1" name="file1" class="form-control">
					 <input 
					type=file id="file2" name="file2" class="form-control"> 
 					 <input 
					type=file id="file3" name="file3" class="form-control"> 
			</div>
			<div class="col-md-6">

				<input type="hidden" id="id" name="id" class="form-control"
					value="${session_id}">

				<div class="row">
					<div class="col-md-12">
						<label class="col-xs-2 col-lg-2 control-label"> 제목 </label> <input
							type="text" id="title" name="title" class="form-control"
							placeholder="제목을 입력하세요">
					</div>
				</div>
				<!-- 				<div class="row"> -->
				<!-- 					<div class="col-md-12"> -->
				<!-- 						<input type="text" class="form-control" "placeholder="주소 선택"> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<div class="row">
					<div class="col-md-12">
						<label class="col-xs-2 col-lg-2 control-label"> 내용 </label>
						<textarea rows="5" id="context" name="context"
							class="form-control" placeholder="내용을 입력하세요."></textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<label class="col-xs-2 col-lg-2 control-label"> 가격 </label> <input
							type="text" id="price" name="price" class="form-control"
							placeholder="가격을 입력하세요">
					</div>
				</div>
				<div class="panel-footer">
					<button type="submit" id="btnWrite" class="btn btn-warning">글등록</button>
					<button type="button" id="btnList" class="btn btn-info">목록보기</button>
				</div>

			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
	$("#btnWrite").on('click', function() {
		var title = $("#title").val();
		if (title == "") {
			alert("제목을 입력하세요");
			$("#title").focus();
			return false;
		} else if (content == "") {
			alert("내용을 입력하세요");
			$("#content").focus();
			return false;
		} else if (price == "") {
			alert("가격을 입력하세요");
			$("#price").focus();
			return false;
		}
		return true;
	});

	$("#btnList").on('click', function() {
		location.href = "list.do";
	});
</script>


<%@ include file="../include/footer.jsp"%>

