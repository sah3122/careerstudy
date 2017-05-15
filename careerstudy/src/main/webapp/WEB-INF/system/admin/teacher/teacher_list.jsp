<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script>
	function fn_teacher_update(idx){
		window.event.cancelBubble = true;
		
		$("#teacher_idx").val(idx);
		$("#data_form").attr("action", "/admin/teacher/teacherUpdate.do").submit();
	}
	
	function fn_teacher_detail(idx){
		$("#teacher_idx").val(idx);
		$("#data_form").attr("action", "/admin/teacher/teacherDetail.do").submit();
	}
	
	function fn_teacher_delete(idx){
		window.event.cancelBubble = true;
		
		if(confirm("삭제하시겠습니까 ?")){
			$("#teacher_idx").val(idx);
			$("#data_form").attr("action", "/admin/teacher/teacherDelete.do").submit();
		}
	}
</script>

<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">선생님 정보</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container-fluid -->
    <form id="data_form" name="data_form" method="post">
    	<input type="hidden" id="teacher_idx" name="teacher_idx" value="" />
    </form>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    	선생님 정보
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                            <tr>
                            	<th>번호</th>
                                <th>이름</th>
                                <th>학교</th>
                                <th>지역</th>
                                <th>전화번호</th>
                                <th>등록일시</th>
                                <th>수정</th>
                                <th>삭제</th>
                            </tr>
                        </thead>
                        <tbody>
	                        <c:choose>
								<c:when test="${fn:length(teacherList) > 0}">
									<c:forEach items="${teacherList}" var="row" varStatus="status">
										<tr onclick="fn_teacher_detail(${row.USER_IDX})">
											<td>${status.count}</td>
											<td>${row.USER_NAME}</td>
											<td>${row.USER_SCHOOL}</td>
											<td>${row.USER_AREA}</td>
											<td>${row.USER_TEL_NUM}</td>
											<td>${row.USER_INSERT_DATE}</td>
											<td>
												<button type="button" class="btn btn-info btn-circle" onclick="fn_teacher_update(${row.USER_IDX})">
													<i class="fa fa-check"></i>
                           						</button>
                           					</td>
											<td>
												<button type="button" class="btn btn-warning btn-circle" onclick="fn_teacher_delete(${row.USER_IDX})">
													<i class="fa fa-times"></i>
                            					</button>
											</td>
										</tr>
									</c:forEach>
								</c:when>				
								<c:otherwise>
									<tr>
										<td colspan="8">선생님이 없습니다.</td>
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
