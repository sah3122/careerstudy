<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">학생 정보</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">학생 정보</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<form id="data_form" name="data_form" role="form" method="post">
								<input type="hidden" id="student_idx" name="student_idx" value="${studentData.USER_IDX}"/>
								<div class="form-group">
									<label>아이디</label> <input type="text" readonly="readonly" id="student_id" name="student_id" class="form-control" value="${studentData.USER_ID}">
								</div>
								<div class="form-group">
									<label>이름</label> <input class="form-control" readonly="readonly" id="student_name" name="student_name" value="${studentData.USER_NAME}"> 
								</div>
								<div class="form-group">
                                    <label>전화번호</label>
                                    <input class="form-control" readonly="readonly" readonly="readonly" placeholder="000-0000-0000" id="student_tel" name="student_tel" value="${studentData.TEL}">
                                </div>
								<div class="form-group">
									<label>지역</label> 
									<select class="form-control" id="student_area" name="student_area" disabled="true">
										<c:forEach items="${areaList}" var="row">
											<option value="${row.AREA_IDX}" <c:if test="${studentData.USER_AREA eq row.AREA_IDX}">selected="selected"</c:if>>${row.AREA_NAME}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label>학교</label> <input class="form-control" readonly="readonly" id="student_school" name="student_school" value="${studentData.USER_SCHOOL}">
								</div>
								<div class="form-group">
									<label>이메일</label> <input class="form-control" readonly="readonly" id="student_email" name="student_email" value="${studentData.USER_EMAIL}">
								</div>
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