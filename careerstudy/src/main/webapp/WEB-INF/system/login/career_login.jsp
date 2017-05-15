<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>
	function fn_login(){
		if($("#login_id").val() == ""){
			alert("아이디를 입력해주세요.");
			return false;
		}
		if($("#login_password").val() == ""){
			alert("비밀번호를 입력해주세요.");
			return false;
		}
		$.ajax({
		      type: "POST",
		      url: "/login/careerLoginDone.do",
		      data: $("#data_form").serialize(), // 보내는 폼 데이터
		      dataType:"json", // 받는 데이터 타입
		      success: function(data){
		      	// data = 리턴받는 json객체
		          if(data.RESULT=='0'){
		        	  $("#data_form").attr("action","/main/careerMain.do").submit();
		          } else {
		        	 alert("로그인 정보를 확인해주세요.");
		          }
		      }
		 });
	}
</script>
<h2 id="container_title">로그인</h2>
<div class="tbl_frm01 tbl_wrap">
	<form id="data_form" name="data_form" method="post">
		<table>
			<tbody>
				<tr>
					<th scope="row">
						<label for="wr_name">아이디<strong class="sound_only"> 필수</strong></label>
					</th>
					<td>
						<input type="text" name="login_id" value="" id="login_id" required class="frm_input required" size="10" maxLength="20">
					</td>
				</tr>
				<tr>
					<th scope="row">
						<label for="wr_password">비밀번호<strong class="sound_only"> 필수</strong></label>
					</th>
					<td>
						<input type="password" name="login_password" id="login_password" required class="frm_input required" size="20" maxLength="20">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<div class="btn_confirm" style="margin-top:10px">
        <a href="#" class="btn_cancel" onclick="fn_login()">로그인</a>
        <a href="#" class="btn_cancel" onclick="fn_cancel()">취소</a>
    </div>
</div>
