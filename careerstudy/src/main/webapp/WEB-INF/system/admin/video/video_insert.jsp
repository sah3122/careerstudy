<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script>
	var file_idx = 0;
	function fn_insert_done(){
		if($("#video_title").val() == "" || $("#video_comment").val() == ""){
			alert("제목 또는 내용을 입력해주세요.");
		} else if($("#video_area").val() == "" || $("#video_area").val() == "0"){
			alert("지역을 입력해주세요.");
		} else if($("#video_school").val() == "" || $("#video_school").val() == "0"){
			alert("학교를 입력해주세요.");
		} else {
			$("#data_form").attr("action", "/admin/video/videoInsertDone.do").submit();
		}
	}
	
	function fn_area_change(area_idx){
		if(area_idx != 0) {
			$("#area_idx").val(area_idx);
			$.ajax({
			      type: "POST",
			      url: "/admin/video/schoolSelect.do",
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
			        	  $("#video_school").html(html);
			          } else {
			        	 alert("학교정보를 불러오지 못했습니다.");
			          }
			      }
			 });	
		}
	}
	function fn_delete_file(idx){
		$("#file_p"+idx).remove();
    }
	
	
</script>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">동영상</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">동영상 등록</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<form id="ajax_form" name="ajax_form" method="post">
								<input type="hidden" id="area_idx" name="area_idx" value=""/>
							</form>
							<form id="data_form" name="data_form" role="form" method="post" enctype="multipart/form-data">
								<div class="form-group">
									<label>제목</label> <input type="text" id="video_title" name="video_title" class="form-control">
								</div>
								<div class="form-group">
                                    <label>내용</label>
                                    <textarea class="form-control" rows="15" id="video_comment" name="video_comment"></textarea>
                                </div>
                                <div class="form-group">
									<label>지역</label> 
									<select class="form-control" id="video_area" name="video_area" onchange="fn_area_change(this.value)">
										<option value="0">선택</option>
										<c:forEach items="${AreaList}" var="row">
											<option value="${row.AREA_IDX}">${row.AREA_NAME}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label>학교</label>
									<select class="form-control" id="video_school" name="video_school">
										<option value="0">선택</option>
									</select>
								</div>
								<div class="form-group" id="file_form">
	                                <label>파일 선택</label>
	                                <p>
	                                	<input type="file" id="video_file" name="video_file">
	                                <p>
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