<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script>
	function fn_notice_list(){
		$("#data_form").attr("action", "/career/notice/noticeList.do").submit();
	}
</script>
<article id="bo_v" style="width: 100%">
	<header>
		<h1 id="bo_v_title">${noticeData.NOTICE_TITLE}</h1>
	</header>

	<section id="bo_v_info">
		<h2>페이지 정보</h2>
		작성자 <strong><span class="sv_member">${noticeData.NOTICE_WRITER}</span></strong> <span class="sound_only">작성일</span><strong>${noticeData.NOTICE_INSERT_DATE}</strong> 조회<strong>${noticeData.NOTICE_CLICK_COUNT} 회</strong>
	</section>

	<!-- 관련링크 시작 { -->
	<section id="bo_v_link">
		<h2>관련링크</h2>
		<ul>
		</ul>
	</section>
	<!-- } 관련링크 끝 -->

	<!-- 게시물 상단 버튼 시작 { -->
	<div id="bo_v_top">
		<ul class="bo_v_com">
			<li><a href="#" class="btn_b01" onclick="fn_notice_list()">목록</a></li>
			<!-- <li><a href="./write.php?w=r&amp;bo_table=day1&amp;wr_id=1" class="btn_b01">답변</a></li>
			<li><a href="./write.php?bo_table=day1" class="btn_b02">글쓰기</a></li> -->
		</ul>
	</div>
	<!-- } 게시물 상단 버튼 끝 -->

	<section id="bo_v_atc">
		<h2 id="bo_v_atc_title">본문</h2>
		<div id="bo_v_img"></div>
		<!-- 본문 내용 시작 { -->
		<div id="bo_v_con">
			${noticeData.NOTICE_COMMENT}
		</div>
		<!-- } 본문 내용 끝 -->
	</section>
	
	<form id="data_form" name="data_form" method="post">
	</form>
</article>
<!-- } 게시판 읽기 끝 -->
