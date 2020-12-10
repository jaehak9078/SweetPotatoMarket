<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<div class="container-fluid container-border">
  <div class="row no-gutter">
    <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image">
   <!--  <img src="images/scotland.jpg" style=" width: auto; height: auto;"> -->
    </div>
    <div class="col-md-8 col-lg-6">
      <div class="login d-flex align-items-center py-5">
        <div class="container">
          <div class="row">
            <div class="col-md-9 col-lg-8 mx-auto">
              <h3 class="login-heading mb-4">반가워요!</h3>
              <form>
                <div class="form-label-group">
                  <input type="text" id="inputId" class="form-control" placeholder="Id" required autofocus>
                   <label for="inputId">Id</label> 
                </div>

                <div class="form-label-group">
                  <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                  <label for="inputPassword">Password</label>
                </div>

                <div class="custom-control custom-checkbox mb-3">
                  <input type="checkbox" class="custom-control-input" id="customCheck1">
                  <label class="custom-control-label" for="customCheck1">Remember password</label>
                </div>
                <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" id="btnLogin" type="submit">로그인</button>
                <div class="text-center">
                  <a class="small" href="joinForm.do">회원가입</a></div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script>
$(function(){
$('#btnLogin').on('click', function(){
	var query = {"id":$("#inputId").val(), "pw":$("#inputPassword").val()};
	$.ajax({
		type:"post",
		url:"login.do",
		async:false,
		data:query,
		dataType:"text",
		success:function(data,textStatus){
			if(data=="success"){
				location.href="list.do";
				alert("로그인 성공");
				
			}else if(data=="password error"){
				alert("패스워드가 틀렸습니다")
			}else{
				alert("아이디가 없음")
			}
		},error:function(data,textStatus){
			alert("error");
		},complete:function(data,textStatus){}
	});
});
});

</script>


<%@ include file="../include/footer.jsp"%>