<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<h2 id="container_title">교육만족도</h2>
<div class="tbl_frm01 tbl_wrap">
	<section id="bo_v_atc">
		<div id="bo_v_con">
		<c:choose>
			<c:when test="${questionData.QUESTION_EDU_VAL eq null}">
				교육만족도를 등록하지 않았습니다.
			</c:when>
			<c:otherwise>
				교육에 대한 만족 : ${questionData.QUESTION_EDU_VAL} </br>
				학습자료에 대한 만족 : ${questionData.QUESTION_STUDY_VAL}
			</c:otherwise> 
		</c:choose>
		</div>
	</section>
</div>
