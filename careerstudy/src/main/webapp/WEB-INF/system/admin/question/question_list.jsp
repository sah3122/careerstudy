<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script>
	function fn_question_update(idx){
		window.event.cancelBubble = true;
		
		$("#question_idx").val(idx);
		$("#data_form").attr("action", "/admin/question/questionUpdate.do").submit();
	}
	
	function fn_question_delete(idx){
		window.event.cancelBubble = true;
		
		if(confirm("삭제하시겠습니까 ?")){
			$("#question_idx").val(idx);
			$("#data_form").attr("action", "/admin/question/questionDelete.do").submit();
		}
	}
</script>

<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">교육만족도</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container-fluid -->
    <form id="data_form" name="data_form" method="post">
    	<input type="hidden" id="question_idx" name="question_idx" value="" />
    </form>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    	교육만족도 목록
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                            <tr>
                            	<th>번호</th>
                                <th>학교</th>
                                <th>지역</th>
                                <th>교육</th>
                                <th>학습자료</th>
                                <th>작성자</th>
                                <th>등록일시</th>
                                <th>수정</th>
                                <th>삭제</th>
                            </tr>
                        </thead>
                        <tbody>
	                        <c:choose>
								<c:when test="${fn:length(questionList) > 0}">
									<c:forEach items="${questionList}" var="row" varStatus="status">
										<tr>
											<td>${status.count}</td>
											<td>${row.QUESTION_SCHOOL_NAME}</td>
											<td>${row.QUESTION_AREA_NAME}</td>
											<td>${row.QUESTION_EDU_VAL}</td>
											<td>${row.QUESTION_STUDY_VAL}</td>
											<td>${row.QUESTION_WRITER}</td>
											<td>${row.QUESTION_INSERT_DATE}</td>
											<td>
												<button type="button" class="btn btn-info btn-circle" onclick="fn_question_update(${row.QUESTION_IDX})">
													<i class="fa fa-check"></i>
                           						</button>
                           					</td>
											<td>
												<button type="button" class="btn btn-warning btn-circle" onclick="fn_question_delete(${row.QUESTION_IDX})">
													<i class="fa fa-times"></i>
                            					</button>
											</td>
										</tr>
									</c:forEach>
								</c:when>				
								<c:otherwise>
									<tr>
										<td colspan="9">등록된 만족도 조사가 없습니다.</td>
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
