<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script>
	function fn_insert_done(){
		if($("#notice_title").val() == "" || $("#notice_comment").val() == ""){
			alert("제목 또는 내용을 입력해주세요.");
		} else {
			$("#notice_comment").replace("\r\n","<br>");
			alert($("#notice_comment").val());
			//$("#data_form").attr("action", "/admin/notice/noticeInsertDone.do").submit();
		}
	}
</script>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">공지사항</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">공지사항 등록</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<form id="data_form" name="data_form" role="form" method="post">
								<div class="form-group">
									<label>제목</label> <input type="text" id="notice_title" name="notice_title" class="form-control">
								</div>
								<div class="form-group">
                                    <label>내용</label>
                                    <textarea class="form-control" rows="15" id="notice_comment" name="notice_comment"></textarea>
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