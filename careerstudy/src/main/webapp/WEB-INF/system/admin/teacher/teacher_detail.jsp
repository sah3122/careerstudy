<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">선생님 정보</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">선생님 정보</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<form id="data_form" name="data_form" role="form" method="post">
								<input type="hidden" id="teacher_idx" name="teacher_idx" value="${teacherData.USER_IDX}"/>
								<div class="form-group">
									<label>아이디</label> <input type="text" readonly="readonly" id="teacher_id" name="teacher_id" class="form-control" value="${teacherData.USER_ID}">
								</div>
								<div class="form-group">
									<label>이름</label> <input class="form-control" readonly="readonly" id="teacher_name" name="teacher_name" value="${teacherData.USER_NAME}"> 
								</div>
								<div class="form-group">
                                    <label>전화번호</label>
                                    <input class="form-control" readonly="readonly" readonly="readonly" placeholder="000-0000-0000" id="teacher_tel" name="teacher_tel" value="${teacherData.TEL}">
                                </div>
								<div class="form-group">
									<label>지역</label> 
									<select class="form-control" id="teacher_area" name="teacher_area" disabled="true">
										<c:forEach items="${areaList}" var="row">
											<option value="${row.AREA_IDX}" <c:if test="${teacherData.USER_AREA eq row.AREA_IDX}">selected="selected"</c:if>>${row.AREA_NAME}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label>학교</label> <input class="form-control" readonly="readonly" id="teacher_school" name="teacher_school" value="${teacherData.USER_SCHOOL}">
								</div>
								<div class="form-group">
									<label>이메일</label> <input class="form-control" readonly="readonly" id="teacher_email" name="teacher_email" value="${teacherData.USER_EMAIL}">
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