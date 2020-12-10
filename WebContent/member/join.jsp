<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<style>
select {

    width: 200px; /* 원하는 너비설정 */
    padding: .8em .5em; /* 여백으로 높이 설정 */
    font-family: inherit;  /* 폰트 상속 */
    
    
    border: 1px solid #999;
    border-radius: 50px; /* iOS 둥근모서리 제거 */
   
}


.text1{
	margin-bottom: .5rem;
	font-weight: bold;
}

</style>

  <div class="container">
    <div class="row">
      <div class="col-lg-10 col-xl-9 mx-auto">
        <div class="card card-signin flex-row my-5">
          <div class="card-img-left d-none d-md-flex">
             <!-- Background image for card set in CSS! -->
          </div>
          <div class="card-body">
            <h5 class="card-title text-center">회원가입</h5>
            <form class="form-signin" action="join.do" method="post" enctype="multipart/form-data">
              <div class="form-label-group">
                <input type="text" id="id" name="id" class="form-control" placeholder="Username" required autofocus>
                <label for="id">Username</label>
              </div>
              
                <div class="form-label-group">
                <input type="text" id="tel" name="tel" class="form-control" placeholder="tel" required>
                <label for="tel">tel</label>
              </div>
              
              <div class="text1">지역선택</div>
              <div> </div>
              <div class="form-label-group">
              <select class="form-control" id="addr" name="addr">
                <option value="서울">서울</option>
  				<option value="부산">부산</option>
				<option value="울산">울산</option>
				<option value="대구">대구</option>
				<option value="대전"> 대전</option>
				<option value="광주">광주</option>
				<option value="인천">인천</option>
			  </select>
			  </div>
              <!-- <div class="form-label-group">
                <input type="text" id="addr" name="addr" class="form-control" placeholder="address" required>
                <label for="addr">address</label>
              </div> -->
              
            

              <div class="form-group">
              <label for="filename">프로필 사진</label>
              <br>
              <br>
                <input type="file" id="filename" name="filename">  
                   
               </div>
              
              <hr>

              <div class="form-label-group">
                <input type="password" id="pw" name="pw" class="form-control" placeholder="Password" required>
                <label for="pw">Password</label>
              </div>
              
              <div class="form-label-group">
                <input type="password" id="ConfirmPw" class="form-control" placeholder="Password" required>
                <label for="ConfirmPw">Confirm password</label>
              </div>

              <button class="btn btn-lg btn-primary btn-block text-uppercase" id="btnJoin" type="submit">회원가입</button>
              <a class="d-block text-center mt-2 small" href="loginForm.do">Sign In</a>
            
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <script>

$("#btnJoin").on('click',function(){
	var id=$("#id").val();
	var pw=$("#pw").val();
	var ConfirmPw=$("#ConfirmPw").val();
	var addr=$("#addr").val();
	var tel=$("#tel").val();
	var img=$("#filename").val();
	if(id==""){
		alert("아이디를 입력하세요");
		id.focus();
		return false;
	}else if(pw==""){
		alert("비밀번호를 입력하세요");
		pw.focus();
		return false;
	}else if(pw!=ConfirmPw){
		alert("비밀번호를 올바르게 입력해주세요");
	}else if(addr==""){
		alert("주소를 입력하세요");
		pw.focus();
		return false;
	}else if(tel==""){
		alert("전화번호를 입력하세요");
		pw.focus();
		return false;
	}
	else if(img==""){
		img="profile.png";
	}
	return true;
});
</script>
  
<%@ include file="../include/footer.jsp"%>
