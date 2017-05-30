<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script>
	var questionIdx = 0;
	function fn_insert_done(){
		if($("#question_area").val() == "" || $("#question_area").val() == 0){
			alert("지역을 입력해주세요.");
		} else if($("#question_school").val() == "" || $("#question_school").val() == 0){
			alert("학교를 입력해주세요.");
		} else if(!check_question_val()){
			alert("문항전체를 체크해주세요.");
		}  else {
			$.ajax({
			      type: "POST",
			      url: "/admin/question/questionEmpty.do",
			      data: $("#data_form").serialize(), // 보내는 폼 데이터
			      dataType:"json", // 받는 데이터 타입
			      success: function(data){
			      	// data = 리턴받는 json객체
			      	console.log(data.RESULT);
			          if(data.RESULT=='0' || data.RESULT==0){
			        	  $("#data_form").attr("action", "/admin/question/questionInsertDone.do").submit();
			          } else {
			        	 alert("이미 등록되어진 학교 입니다.");
			          }
			      }
			 });	
		}
	}
	
	function fn_area_change(area_idx){
		if(area_idx != 0) {
			$("#area_idx").val(area_idx);
			$.ajax({
			      type: "POST",
			      url: "/admin/question/schoolSelect.do",
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
			        	  $("#question_school").html(html);
			          } else {
			        	 alert("학교정보를 불러오지 못했습니다.");
			          }
			      }
			 });	
		}
	}
	
	function fn_add_question(){
		questionIdx++;
		
		var html = "";
		html += "<label>교육에 대한 만족</label>";
		html += "<div class='radio'>";
		html += "  <label class='radio-inline'>";
		html += "      <input type='radio' name='education_satis_radio_" + questionIdx + "' id='education_satis_radio_" + questionIdx + "' value='1'>매우 불만족";
		html += "  </label>";
		html += "  <label class='radio-inline'>";
		html += "      <input type='radio' name='education_satis_radio_" + questionIdx + "' id='education_satis_radio_" + questionIdx + "' value='2'>불만족";
		html += "  </label>";
		html += "  <label class='radio-inline'>";
		html += "      <input type='radio' name='education_satis_radio_" + questionIdx + "' id='education_satis_radio_" + questionIdx + "' value='3'>보통";
		html += "  </label>";
		html += "  <label class='radio-inline'>";
		html += "      <input type='radio' name='education_satis_radio_" + questionIdx + "' id='education_satis_radio_" + questionIdx + "' value='4'>만족";
		html += "  </label>";
		html += "  <label class='radio-inline'>";
		html += "      <input type='radio' name='education_satis_radio_" + questionIdx + "' id='education_satis_radio_" + questionIdx + "' value='5'>매우 만족";
		html += "  </label>";
		html += "</div>";

		html += "<label>학습자료에 대한 준비</label>";
		html += "<div class='radio'>";
		html += "  <label class='radio-inline'>";
		html += "      <input type='radio' name='stduy_materials_radio_" + questionIdx + "' id='stduy_materials_radio_" + questionIdx + "' value='1'>매우 불만족";
		html += "  </label>";
		html += "  <label class='radio-inline'>";
		html += "      <input type='radio' name='stduy_materials_radio_" + questionIdx + "' id='stduy_materials_radio_" + questionIdx + "' value='2'>불만족";
		html += "  </label>";
		html += "  <label class='radio-inline'>";
		html += "      <input type='radio' name='stduy_materials_radio_" + questionIdx + "' id='stduy_materials_radio_" + questionIdx + "' value='3'>보통";
		html += "  </label>";
		html += "  <label class='radio-inline'>";
		html += "      <input type='radio' name='stduy_materials_radio_" + questionIdx + "' id='stduy_materials_radio_" + questionIdx + "' value='4'>만족";
		html += "  </label>";
		html += "  <label class='radio-inline'>";
		html += "      <input type='radio' name='stduy_materials_radio_" + questionIdx + "' id='stduy_materials_radio_" + questionIdx + "' value='5'>매우 만족";
		html += "  </label>";
		html += "</div>";
		
        $("#question_group").append(html);
	}
	
	function check_question_val(){
		var studyAvg=0, studySum=0, educationAvg=0, educationSum=0;
		for(var i = 0; i<= questionIdx; i++){
			if(typeof $(":input:radio[name=stduy_materials_radio_"+i+"]:checked").val() == "undefined" || typeof $(":input:radio[name=education_satis_radio_"+i+"]:checked").val() == "undefined"){
				return false;
			}
			studySum += Number($(":input:radio[name=stduy_materials_radio_"+i+"]:checked").val());
			educationSum += Number($(":input:radio[name=education_satis_radio_"+i+"]:checked").val());
		}
		studyAvg = Math.round(studySum/(questionIdx+1));
		educationAvg = Math.round(educationSum/(questionIdx+1));

		$("#education_satis").val(studyAvg);
		$("#stduy_materials").val(educationAvg);
		return true;
	} 
	
	
</script>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">교육만족도</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">교육만족도 등록</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<form id="ajax_form" name="ajax_form" method="post">
								<input type="hidden" id="area_idx" name="area_idx" value=""/>
							</form>
							<form id="data_form" name="data_form" role="form" method="post" >
								<input type="hidden" id="education_satis" name="education_satis" />
								<input type="hidden" id="stduy_materials" name="stduy_materials" />
								<input type="hidden" id="question_cnt" name="question_cnt" />		
                                <div class="form-group">
									<label>지역</label> 
									<select class="form-control" id="question_area" name="question_area" onchange="fn_area_change(this.value)">
										<option value="0">선택</option>
										<c:forEach items="${AreaList}" var="row">
											<option value="${row.AREA_IDX}">${row.AREA_NAME}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label>학교</label>
									<select class="form-control" id="question_school" name="question_school">
										<option value="0">선택</option>
									</select>
								</div>
                                <div class="form-group" id="question_group">
                                    <label>교육에 대한 만족</label>
                                    <div class="radio">
	                                    <label class="radio-inline">
	                                        <input type="radio" name="education_satis_radio_0" id="education_satis_radio_0" value="1">매우 불만족
	                                    </label>
	                                    <label class="radio-inline">
	                                        <input type="radio" name="education_satis_radio_0" id="education_satis_radio_0" value="2">불만족
	                                    </label>
	                                    <label class="radio-inline">
	                                        <input type="radio" name="education_satis_radio_0" id="education_satis_radio_0" value="3">보통
	                                    </label>
	                                    <label class="radio-inline">
	                                        <input type="radio" name="education_satis_radio_0" id="education_satis_radio_0" value="4">만족
	                                    </label>
	                                    <label class="radio-inline">
	                                        <input type="radio" name="education_satis_radio_0" id="education_satis_radio_0" value="5">매우 만족
	                                    </label>
                                    </div>
                                
                                    <label>학습자료에 대한 준비</label>
                                    <div class="radio">
	                                    <label class="radio-inline">
	                                        <input type="radio" name="stduy_materials_radio_0" id="stduy_materials_radio_0" value="1">매우 불만족
	                                    </label>
	                                    <label class="radio-inline">
	                                        <input type="radio" name="stduy_materials_radio_0" id="stduy_materials_radio_0" value="2">불만족
	                                    </label>
	                                    <label class="radio-inline">
	                                        <input type="radio" name="stduy_materials_radio_0" id="stduy_materials_radio_0" value="3">보통
	                                    </label>
	                                    <label class="radio-inline">
	                                        <input type="radio" name="stduy_materials_radio_0" id="stduy_materials_radio_0" value="4">만족
	                                    </label>
	                                    <label class="radio-inline">
	                                        <input type="radio" name="stduy_materials_radio_0" id="stduy_materials_radio_0" value="5">매우 만족
	                                    </label>
                                    </div>
                                </div>
                                <input type="button" class="btn btn-default" value="등록" onclick="fn_insert_done()"/>
								<button type="reset" class="btn btn-default">취소</button>
								<input type="button" class="btn btn-default" value="문항 추가" onclick="fn_add_question()"/>
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