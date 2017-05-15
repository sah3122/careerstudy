<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link href="http://vjs.zencdn.net/c/video-js.css" rel="stylesheet" />
<script src="http://vjs.zencdn.net/c/video.js"></script>

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
				<div class="panel-heading">동영상 정보</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<form id="data_form" name="data_form" role="form" method="post">
								<div class="form-group">
									<label>제목</label> <input type="text" id="gallery_title" name="gallery_title" class="form-control" readonly="readonly" value="${videoData.VIDEO_TITLE}">
								</div>
								<div class="form-group">
                                    <label>내용</label>
                                    <textarea class="form-control" rows="15" id="gallery_comment" name="gallery_comment" readonly="readonly">${videoData.VIDEO_COMMENT}</textarea>
                                </div>
                                <div class="form-group">
									<video width="640" height="360" controls="controls" class="video-js vjs-default-skin" data-setup="{}">
									    <source src="/videos/careerstudy/${fileList[0].VDO_STR_NAME}" type="video/mp4" />
									    <source src="/videos/careerstudy/${fileList[0].VDO_STR_NAME}" type="video/ogv" />
									</video>
								</div>
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