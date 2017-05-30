<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script>
	var questionIdx = 0;
	$(document).ready(function(){
		
	});
	function fn_update_done(){
		if(!check_question_val()){
			alert("문항전체를 체크해주세요.");
		} else {
			$("#data_form").attr("action", "/admin/question/questionUpdateDone.do").submit();
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
		$("#question_cnt").val(questionIdx+1);
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
				<div class="panel-heading">교육만족도 수정</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<form id="data_form" name="data_form" role="form" method="post" >
								<input type="hidden" id="education_satis" name="education_satis" />
								<input type="hidden" id="stduy_materials" name="stduy_materials" />
								<input type="hidden" id="question_idx" name="question_idx" value="${questionData.QUESTION_IDX}"/>		
                                <div class="form-group">
									<label>지역</label> 
									<input type="text" readonly="readonly" id="question_area" name="question_area" class="form-control" value="${questionData.QUESTION_AREA_NAME}">
								</div>
								<div class="form-group">
									<label>학교</label>
									<input type="text" readonly="readonly" id="question_school" name="question_school" class="form-control" value="${questionData.QUESTION_SCHOOL_NAME}">
								</div>
                                <div class="form-group" id="question_group">
                                    <label>교육에 대한 만족</label>
                                    <div class="radio">
	                                    <label class="radio-inline">
	                                        <input type="radio" name="education_satis_radio_0" id="education_satis_radio_0" value="1" disabled <c:if test="${questionData.QUESTION_EDU eq 1}">checked</c:if>>매우 불만족
	                                    </label>
	                                    <label class="radio-inline">
	                                        <input type="radio" name="education_satis_radio_0" id="education_satis_radio_0" value="2" disabled <c:if test="${questionData.QUESTION_EDU eq 2}">checked</c:if>>불만족
	                                    </label>
	                                    <label class="radio-inline">
	                                        <input type="radio" name="education_satis_radio_0" id="education_satis_radio_0" value="3" disabled <c:if test="${questionData.QUESTION_EDU eq 3}">checked</c:if>>보통
	                                    </label>
	                                    <label class="radio-inline">
	                                        <input type="radio" name="education_satis_radio_0" id="education_satis_radio_0" value="4" disabled <c:if test="${questionData.QUESTION_EDU eq 4}">checked</c:if>>만족
	                                    </label>
	                                    <label class="radio-inline">
	                                        <input type="radio" name="education_satis_radio_0" id="education_satis_radio_0" value="5" disabled <c:if test="${questionData.QUESTION_EDU eq 5}">checked</c:if>>매우 만족
	                                    </label>
                                    </div>
                                
                                    <label>학습자료에 대한 준비</label>
                                    <div class="radio">
	                                    <label class="radio-inline">
	                                        <input type="radio" name="stduy_materials_radio_0" id="stduy_materials_radio_0" value="1" disabled <c:if test="${questionData.QUESTION_STUDY eq 1}">checked</c:if>>매우 불만족
	                                    </label>
	                                    <label class="radio-inline">
	                                        <input type="radio" name="stduy_materials_radio_0" id="stduy_materials_radio_0" value="2" disabled <c:if test="${questionData.QUESTION_STUDY eq 2}">checked</c:if>>불만족
	                                    </label>
	                                    <label class="radio-inline">
	                                        <input type="radio" name="stduy_materials_radio_0" id="stduy_materials_radio_0" value="3" disabled <c:if test="${questionData.QUESTION_STUDY eq 3}">checked</c:if>>보통
	                                    </label>
	                                    <label class="radio-inline">
	                                        <input type="radio" name="stduy_materials_radio_0" id="stduy_materials_radio_0" value="4" disabled <c:if test="${questionData.QUESTION_STUDY eq 4}">checked</c:if>>만족
	                                    </label>
	                                    <label class="radio-inline">
	                                        <input type="radio" name="stduy_materials_radio_0" id="stduy_materials_radio_0" value="5" disabled <c:if test="${questionData.QUESTION_STUDY eq 5}">checked</c:if>>매우 만족
	                                    </label>
                                    </div>
                                </div>
                                <input type="button" class="btn btn-default" value="수정" onclick="fn_update_done()"/>
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