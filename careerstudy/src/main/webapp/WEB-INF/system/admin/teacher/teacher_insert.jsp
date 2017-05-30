<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script>
	function fn_insert_done(){
		if($("#teacher_pass").val() != null && $("#teacher_pass2").val() != null && $("#teacher_pass").val() != "" && $("#teacher_pass2").val() != "" && $("#teacher_pass").val() == $("#teacher_pass2").val()){
			$.ajax({
			      type: "POST",
			      url: "/admin/teacher/teacherInsertDone.do",
			      data: $("#data_form").serialize(), // 보내는 폼 데이터
			      dataType:"json", // 받는 데이터 타입
			      success: function(data){
			      	// r = 리턴받는 json객체
			          if(data.RESULT=='0'){ 
			             alert("회원가입 되었습니다.");
			          }else if (data.RESULT == '1'){
			        	 alert("id가 중복됩니다."); 
			          }else if (data.RESULT == '2'){
			        	 alert("해당학교에 선생님이 존재합니다."); 
			          } else {
			        	 alert("알수없는 오류가 발생하였습니다.");
			          }
			      }
			 });	
		} else {
			alert("비밀번호를 확인해주세요.");
		} 
	}
</script>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">선생님 추가</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">선생님 추가</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<form id="data_form" name="data_form" role="form" method="post">
								<input type="hidden" id="user_code" name="user_code" value="000"/>
								<div class="form-group">
									<label>아이디</label> <input type="text" id="teacher_id" name="teacher_id" class="form-control">
								</div>
								<div class="form-group">
									<label>비밀번호</label> <input class="form-control" type="password" id="teacher_pass" name="teacher_pass">
								</div>
								<div class="form-group">
									<label>비밀번호 확인</label> <input class="form-control" type="password" id="teacher_pass2" name="teacher_pass2">
								</div>
								<div class="form-group">
									<label>이름</label> <input class="form-control" id="teacher_name" name="teacher_name">
								</div>
								<div class="form-group">
                                    <label>전화번호</label>
                                    <input class="form-control" placeholder="000-0000-0000" id="teacher_tel" name="teacher_tel">
                                </div>
								<div class="form-group">
									<label>지역</label> 
									<select class="form-control" id="teacher_area" name="teacher_area">
										<c:forEach items="${AreaList}" var="row">
											<option value="${row.AREA_IDX}">${row.AREA_NAME}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label>학교</label> <input class="form-control" id="teacher_school" name="teacher_school">
								</div>
								<div class="form-group">
									<label>이메일</label> <input class="form-control" id="teacher_email" name="teacher_email">
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