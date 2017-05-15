<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script>
	function fn_area_change(area_idx){
		if(area_idx != 0) {
			$("#area_idx").val(area_idx);
			$.ajax({
			      type: "POST",
			      url: "/sign/schoolSelect.do",
			      data: $("#ajax_form").serialize(), // 보내는 폼 데이터
			      dataType:"json", // 받는 데이터 타입
			      success: function(data){
			      	// data = 리턴받는 json객체
			          if(data.RESULT=='0'){
			        	  var html = "<option value='0'>선택</option>";
			        	  if(eval(data.schoolList).length > 0){
				        	  for(var i =0; i < eval(data.schoolList).length; i++){
				        		  html += "<option value='"+eval(data.schoolList)[i].SCHOOL_IDX+"'>"+eval(data.schoolList)[i].SCHOOL_NAME+"</option>";
				        	  }
			        	  }
			        	  $("#sign_school").html(html);
			          } else {
			        	 alert("학교정보를 불러오지 못했습니다.");
			          }
			      }
			 });	
		}
	}
	
	function fn_id_check(){
		if($("#sign_id").val() == ""){
			alert("아이디를 입력해주세요.");
			return false;
		}
		$.ajax({
		      type: "POST",
		      url: "/sign/idCheck.do",
		      data: $("#ajax_form").serialize(), // 보내는 폼 데이터
		      dataType:"json", // 받는 데이터 타입
		      success: function(data){
		      	// data = 리턴받는 json객체
		          if(data.RESULT=='0'){
		        	  $("#id_check").val("true");
		        	  $("#sign_id").attr("readonly","readonly");
		        	  alert("사용가능한 아이디입니다.");
		          } else {
		        	  alert("아이디가 중복됩니다.");
		          }
		      }
		 });	
	}
	
	function fn_sign_up(){
		if($("#id_check").val() == "false"){
			alert("아이디 중복체크를 해주세요.");
			return false;
		} 
		if($("#sign_password").val() == ""){
			alert("비밀번호를 입력 해주세요.");
			return false;
		}
		if($("#sign_password").val() != $("#sign_password2").val()){
			alert("비밀번호를 확인 해주세요.");
			return false;
		}
		if($("#sign_name").val() == ""){
			alert("이름을 입력 해주세요.");
			return false;
		}
		if($("#sign_email").val() == ""){
			alert("이메일을 입력 해주세요.");
			return false;
		}
		if($("#sign_area").val() == "0"){
			alert("지역을 선택 해주세요.");
			return false;
		}
		if($("#sign_school").val() == "0"){
			alert("학교를 선택 해주세요.");
			return false;
		}
		$.ajax({
		      type: "POST",
		      url: "/sign/signUp.do",
		      data: $("#ajax_form").serialize(), // 보내는 폼 데이터
		      dataType:"json", // 받는 데이터 타입
		      success: function(data){
		      	// data = 리턴받는 json객체
		          if(data.RESULT=='0'){
		        	  alert("회원가입 되었습니다.");
		        	  $("#ajax_form").attr("action", "/login/careerLogin.do").submit();
		          } else {
		        	  alert("알수없는 오류가 발생하였습니다.");
		          }
		      }
		 }); 
	}
</script>
<section id="bo_w">
	<h2 id="container_title">회원가입</h2>

	<!-- 게시물 작성/수정 시작 { -->
	<form name="ajax_form" id="ajax_form" method="post">
		<input type="hidden" id="area_idx" name="area_idx" />
		<input type="hidden" id="id_check" name="id_check" value="false"/>
		<div class="tbl_frm01 tbl_wrap">
			<table>
				<tbody>
					<tr>
						<th scope="row">
							<label for="wr_name">아이디<strong class="sound_only">필수</strong></label>
						</th>
						<td>
							<input type="text" name="sign_id" value="" id="sign_id"	required class="frm_input required" size="10" maxlength="20">
							<a href="#" class="btn_cancel" onclick="fn_id_check()" >중복확인</a>
						</td>
						
					</tr>
					<tr>
						<th scope="row">
							<label for="wr_password">비밀번호<strong class="sound_only">필수</strong></label>
						</th>
						<td>
							<input type="password" name="sign_password" id="sign_password" required class="frm_input required" maxlength="20">
						</td>
					</tr>
					<tr>
						<th scope="row">
							<label for="wr_password">비밀번호 확인<strong class="sound_only">필수</strong></label>
						</th>
						<td>
							<input type="password" name="sign_password2" id="sign_password2" required class="frm_input required" maxlength="20">
						</td>
					</tr>
					<tr>
						<th scope="row">
							<label for="wr_name">이름<strong class="sound_only">필수</strong></label>
						</th>
						<td>
							<input type="text" name="sign_name" value="" id="sign_name"	required class="frm_input required" size="10" maxlength="20">
						</td>
					</tr>
					<tr>
						<th scope="row">
							<label for="wr_email">이메일</label>
						</th>
						<td>
							<input type="text" name="sign_email" value="" id="sign_email" class="frm_input" size="50" maxlength="100">
						</td>
					</tr>
					<tr>
						<th scope="row">
							<label for="wr_email">지역</label>
						</th>
						<td>
							<select class="" id="sign_area" name="sign_area" onchange="fn_area_change(this.value)">
								<option value="0">선택</option>
								<c:forEach items="${AreaList}" var="row">
									<option value="${row.AREA_IDX}">${row.AREA_NAME}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th scope="row">
							<label for="wr_homepage">학교</label>
						</th>
						<td>
							<select class="" id="sign_school" name="sign_school">
								<option value="0">선택</option>
							</select>
						</td>
					</tr>
				</tbody>
			</table>
		</div>

		<div class="btn_confirm" style="margin-bottom:20px">
			<a href="#" class="btn_cancel" onclick="fn_sign_up()">가입</a> <a href="/main/careerMain.do" class="btn_cancel" >취소</a>
		</div>
	</form>
</section>
