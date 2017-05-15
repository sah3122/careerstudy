<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script>
	function fn_update_done(){
		if($("#video_title").val() == "" || $("#video_comment").val() == ""){
			alert("제목 또는 내용을 입력해주세요.");
		} else {
			$("#data_form").attr("action", "/admin/video/videoUpdateDone.do").submit();
		}
	}
</script>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">갤러리</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">갤러리 정보</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<form id="data_form" name="data_form" role="form" method="post">
								<input type="hidden" id="video_idx" name="video_idx" value="${videoData.VIDEO_IDX}"/>
								<div class="form-group">
									<label>제목</label> <input type="text" id="video_title" name="video_title" class="form-control"  value="${videoData.VIDEO_TITLE}">
								</div>
								<div class="form-group">
                                    <label>내용</label>
                                    <textarea class="form-control" rows="15" id="video_comment" name="video_comment">${videoData.VIDEO_COMMENT}</textarea>
                                </div>
                               	<div class="form-group">
									<video width="640" height="360" controls="controls" class="video-js vjs-default-skin" data-setup="{}">
									    <source src="/videos/careerstudy/${fileList[0].VDO_STR_NAME}" type="video/mp4" />
									</video>
								</div>
                                <input type="button" class="btn btn-default" value="수정" onclick="fn_update_done()"/>
								<button type="reset" class="btn btn-default">취소</button>
							</form>
						</div>
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