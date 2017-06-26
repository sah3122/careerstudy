<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script>
	function fn_sign_update(){
		$("#data_form").attr("action","/sign/signUpdate.do").submit();
	}
	
	function fn_sign_delete(){
		if(confirm("삭제하시겠습니까 ?")){
			$("#data_form").attr("action","/sign/signDelete.do").submit();
		}
	}
</script>
<section id="bo_w">
	<h2 id="container_title">회원정보</h2>

	<!-- 게시물 작성/수정 시작 { -->
	<form name="data_form" id="data_form" method="post">
		<input type="hidden" id="sign_idx" name="sign_idx" value="${studentData.USER_IDX}"/>
		<div class="tbl_frm01 tbl_wrap">
			<table>
				<tbody>
					<tr>
						<th scope="row">
							<label for="wr_name">아이디<strong class="sound_only">필수</strong></label>
						</th>
						<td>
							<input type="text" name="sign_id" value="${studentData.USER_ID}" id="sign_id"	readonly class="frm_input required" size="10" maxlength="20">
						</td>
					</tr>
					<tr>
						<th scope="row">
							<label for="wr_name">이름<strong class="sound_only">필수</strong></label>
						</th>
						<td>
							<input type="text" name="sign_name" value="${studentData.USER_NAME}" id="sign_name"	readonly class="frm_input required" size="10" maxlength="20">
						</td>
					</tr>
					<tr>
						<th scope="row">
							<label for="wr_email">전화번호</label>
						</th>
						<td>
							<input type="text" name="sign_tel" value="${studentData.USER_TEL_NUM}" readonly id="sign_tel" class="frm_input" size="15" maxlength="15">
						</td>
					</tr>
					<tr>
						<th scope="row">
							<label for="wr_email">이메일</label>
						</th>
						<td>
							<input type="text" name="sign_email" value="${studentData.USER_EMAIL}" readonly id="sign_email" class="frm_input" size="30" maxlength="30">
						</td>
					</tr>
					<tr>
						<th scope="row">
							<label for="wr_email">지역</label>
						</th>
						<td>
							<input type="text" name="sign_area" value="${studentData.USER_AREA}" id="sign_area"	readonly class="frm_input required" size="15" maxlength="20">
						</td>
						<%-- <select class="form-control" id="sign_area" name="sign_area" disabled="true">
								<c:forEach items="${areaList}" var="row">
									<option value="${row.AREA_IDX}" <c:if test="${studentData.USER_AREA eq row.AREA_IDX}">selected="selected"</c:if>>${row.AREA_NAME}</option>
								</c:forEach>
							</select> --%>
					</tr>
					<tr>
						<th scope="row">
							<label for="wr_homepage">학교</label>
						</th>
						<td>
							<input type="text" name="sign_school" value="${studentData.USER_SCHOOL}" id="sign_school"	readonly class="frm_input required" size="15" maxlength="20">
						</td>
					</tr>
				</tbody>
			</table>
		</div>

		<div class="btn_confirm" style="margin-bottom:20px">
			<a href="#" class="btn_cancel" onclick="fn_sign_update()">수정</a> <a href="#" class="btn_cancel" onclick="fn_sign_delete()">삭제</a>
		</div>
	</form>
</section>
