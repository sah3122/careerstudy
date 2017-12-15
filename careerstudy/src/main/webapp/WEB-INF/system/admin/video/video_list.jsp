<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script>
	function fn_video_detail(idx){
		$("#video_idx").val(idx);
		$("#data_form").attr("action", "/admin/video/videoDetail.do").submit();
	}
	
	function fn_video_update(idx){
		window.event.cancelBubble = true;
		
		$("#video_idx").val(idx);
		$("#data_form").attr("action", "/admin/video/videoUpdate.do").submit();
	}
	
	function fn_video_delete(idx){
		window.event.cancelBubble = true;
		
		if(confirm("삭제하시겠습니까 ?")){
			$("#video_idx").val(idx);
			$("#data_form").attr("action", "/admin/video/videoDelete.do").submit();
		}
	}
</script>

<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">동영상</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container-fluid -->
    <form id="data_form" name="data_form" method="post">
    	<input type="hidden" id="video_idx" name="video_idx" value="" />
    </form>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    	동영상 목록
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                            <tr>
                            	<th>번호</th>
                                <th>제목</th>
                                <th>학교</th>
                                <th>지역</th>
                                <th>작성자</th>
                                <th>등록일시</th>
                                <th>수정</th>
                                <th>삭제</th>
                            </tr>
                        </thead>
                        <tbody>
	                        <c:choose>
								<c:when test="${fn:length(videoList) > 0}">
									<c:forEach items="${videoList}" var="row" varStatus="status">
										<tr onclick="fn_video_detail(${row.VIDEO_IDX})">
											<td>${status.count}</td>
											<td>${row.VIDEO_TITLE}</td>
											<td>${row.VIDEO_SCHOOL_IDX}</td>
											<td>${row.VIDEO_SCHOOL_AREA}</td>
											<td>${row.VIDEO_WRITER}</td>
											<td>${row.VIDEO_INSERT_DATE}</td>
											<td>
												<button type="button" class="btn btn-info btn-circle" onclick="fn_video_update(${row.VIDEO_IDX})">
													<i class="fa fa-check"></i>
                           						</button>
                           					</td>
											<td>
												<button type="button" class="btn btn-warning btn-circle" onclick="fn_video_delete(${row.VIDEO_IDX})">
													<i class="fa fa-times"></i>
                            					</button>
											</td>
										</tr>
									</c:forEach>
								</c:when>				
								<c:otherwise>
									<tr>
										<td colspan="8">동영상이 없습니다.</td>
									</tr>
								</c:otherwise>
							</c:choose>
                        </tbody>
                    </table>
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-12 -->
    </div>
</div>
<!-- /#page-wrapper -->
