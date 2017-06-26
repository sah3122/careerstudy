<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script>
	function fn_insert_done(){
		if($("#student_id").val() == ""){
			alert("id를 입력해주세요");
			return 0;
		}
		if($("#student_name").val() == ""){
			alert("이름을 입력해주세요");
			return 0;
		}
		if($("#student_area").val() == 0){
			alert("지역을 선택해주세요");
			return 0;
		}
		if($("#student_school").val() == 0){
			alert("학교를 선택해주세요");
			return 0;
		}
		
		if($("#student_pass").val() != null && $("#student_pass2").val() != null && $("#student_pass").val() != "" && $("#student_pass2").val() != "" && $("#student_pass").val() == $("#student_pass2").val()){
			$.ajax({
			      type: "POST",
			      url: "/admin/student/studentInsertDone.do",
			      data: $("#data_form").serialize(), // 보내는 폼 데이터
			      dataType:"json", // 받는 데이터 타입
			      success: function(data){
			      	// r = 리턴받는 json객체
			          if(data.RESULT=='0'){ 
			             alert("회원가입 되었습니다.");
			             window.location.reload(true);
			          } else if (data.RESULT == '1'){
			        	 alert("id가 중복됩니다."); 
			          } else {
			        	 alert("알수없는 오류가 발생하였습니다.");
			          }
			      }
			 });	
		} else {
			alert("비밀번호를 확인해주세요.");
		} 
	}
	
	function fn_area_change(area_idx){
		if(area_idx != 0) {
			$("#area_idx").val(area_idx);
			$.ajax({
			      type: "POST",
			      url: "/admin/student/schoolSelect.do",
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
			        	  $("#student_school").html(html);
			          } else {
			        	 alert("학교정보를 불러오지 못했습니다.");
			          }
			      }
			 });	
		}
	}
</script>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">학생 추가</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">학생 추가</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<form id="ajax_form" name="ajax_form" method="post">
								<input type="hidden" id="area_idx" name="area_idx" value=""/>
							</form>
							<form id="data_form" name="data_form" role="form" method="post">
								<input type="hidden" id="user_code" name="user_code" value="002"/>
								<div class="form-group">
									<label>아이디</label> <input type="text" id="student_id" name="student_id" class="form-control">
								</div>
								<div class="form-group">
									<label>비밀번호</label> <input class="form-control" type="password" id="student_pass" name="student_pass">
								</div>
								<div class="form-group">
									<label>비밀번호 확인</label> <input class="form-control" type="password" id="student_pass2" name="student_pass2">
								</div>
								<div class="form-group">
									<label>이름</label> <input class="form-control" id="student_name" name="student_name">
								</div>
								<div class="form-group">
                                    <label>전화번호</label>
                                    <input class="form-control" placeholder="000-0000-0000" id="student_tel" name="student_tel">
                                </div>
								<div class="form-group">
									<label>지역</label> 
									<select class="form-control" id="student_area" name="student_area"  onchange="fn_area_change(this.value)">
										<option value="0">선택</option>
										<c:forEach items="${AreaList}" var="row">
											<option value="${row.AREA_IDX}">${row.AREA_NAME}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label>학교</label>
									<select class="form-control" id="student_school" name="student_school">
										<option value="0">선택</option>
									</select>
								</div>
								<div class="form-group">
									<label>이메일</label> <input class="form-control" id="student_email" name="student_email">
								</div>
								<input type="button" class="btn btn-default" value="등록" onclick="fn_insert_done()"/>
								<button type="reset" class="btn btn-default">취소</button>
							</form>
						</div>
						<!-- /.col-lg-6 (nested) -->
						<!-- /.col-lg-6 (nested) -->
					</div>
					<!-- /.row (nested) -->
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
	</div>
</div>