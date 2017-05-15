<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script>
	function fn_notice_detail(idx){
		$("#notice_idx").val(idx);
		$("#data_form").attr("action", "/admin/notice/noticeDetail.do").submit();
	}
	
	function fn_notice_update(idx){
		window.event.cancelBubble = true;
		
		$("#notice_idx").val(idx);
		$("#data_form").attr("action", "/admin/notice/noticeUpdate.do").submit();
	}
	
	function fn_notice_delete(idx){
		window.event.cancelBubble = true;
		
		if(confirm("삭제하시겠습니까 ?")){
			$("#notice_idx").val(idx);
			$("#data_form").attr("action", "/admin/notice/noticeDelete.do").submit();
		}
	}
</script>

<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">공지사항</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container-fluid -->
    <form id="data_form" name="data_form" method="post">
    	<input type="hidden" id="notice_idx" name="notice_idx" value="" />
    </form>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    	공지사항 목록
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                            <tr>
                            	<th>번호</th>
                                <th>제목</th>
                                <th>작성자</th>
                                <th>등록일시</th>
                                <th>수정</th>
                                <th>삭제</th>
                            </tr>
                        </thead>
                        <tbody>
	                        <c:choose>
								<c:when test="${fn:length(noticeList) > 0}">
									<c:forEach items="${noticeList}" var="row" varStatus="status">
										<tr onclick="fn_notice_detail(${row.NOTICE_IDX})">
											<td>${status.count}</td>
											<td>${row.NOTICE_TITLE}</td>
											<td>${row.NOTICE_WRITER}</td>
											<td>${row.NOTICE_INSERT_DATE}</td>
											<td>
												<button type="button" class="btn btn-info btn-circle" onclick="fn_notice_update(${row.NOTICE_IDX})">
													<i class="fa fa-check"></i>
                           						</button>
                           					</td>
											<td>
												<button type="button" class="btn btn-warning btn-circle" onclick="fn_notice_delete(${row.NOTICE_IDX})">
													<i class="fa fa-times"></i>
                            					</button>
											</td>
										</tr>
									</c:forEach>
								</c:when>				
								<c:otherwise>
									<tr>
										<td colspan="6">공지사항이 없습니다.</td>
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
