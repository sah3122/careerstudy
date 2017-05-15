<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
								<div class="form-group">
									<label>제목</label> <input type="text" id="gallery_title" name="gallery_title" class="form-control" readonly="readonly" value="${galleryData.GALLERY_TITLE}">
								</div>
								<div class="form-group">
                                    <label>내용</label>
                                    <textarea class="form-control" rows="15" id="gallery_comment" name="gallery_comment" readonly="readonly">${galleryData.GALLERY_COMMENT}</textarea>
                                </div>
                                <c:choose>
									<c:when test="${fn:length(fileList) > 0}">
										<c:forEach items="${fileList}" var="row" varStatus="status">
											<div class="form-group">
												<img style="width:100%" src="/images/careerstudy/${fileList[status.index].IMG_STR_NAME}" />
											</div>
										</c:forEach>
									</c:when>				
									<c:otherwise>
									</c:otherwise>
								</c:choose>
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