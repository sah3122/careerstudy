<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="http://mrhome.kr/gnuboard5/js/viewimageresize.js"></script>

<!-- 게시물 읽기 시작 { -->

<article id="bo_v" style="width: 100%">
	<header>
		<h1 id="bo_v_title">${galleryData.GALLERY_TITLE}</h1>
	</header>

	<section id="bo_v_info">
		<h2>페이지 정보</h2>작성자 <strong><span class="sv_member">${galleryData.GALLERY_WRITER}</span></strong> 
		<span class="sound_only">작성일</span><strong>${galleryData.GALLERY_INSERT_DATE}</strong> 조회 <strong>${galleryData.GALLERY_CLICK_COUNT} 회
	</section>

	<!-- 게시물 상단 버튼 시작 { -->
	<div id="bo_v_top">
		<ul class="bo_v_com">
			<li>
				<a href="/career/gallery/galleryList.do" class="btn_b01">목록</a>
			</li>
		</ul>
	</div>
	<!-- } 게시물 상단 버튼 끝 -->

	<section id="bo_v_atc">
		<h2 id="bo_v_atc_title">본문</h2>
		<c:forEach items="${fileList}" var="row" varStatus="status">
			<div id="bo_v_img">
			<a href="#"	target="_blank" class="view_image">
				<img src="/images/careerstudy/${row.IMG_STR_NAME}" alt="" />
			</a>
		</div>
		</c:forEach>

		<!-- 본문 내용 시작 { -->
		<div id="bo_v_con">
			${galleryData.GALLERY_COMMENT}
		</div>
		<!-- } 본문 내용 끝 -->
		<!-- 스크랩 추천 비추천 시작 { -->
		<!-- } 스크랩 추천 비추천 끝 -->
	</section>

	<script>
		// 글자수 제한
		var char_min = parseInt(0); // 최소
		var char_max = parseInt(0); // 최대
	</script>

	<!-- 
	<section id="bo_vc">
		<h2>댓글목록</h2>
		<p id="bo_vc_empty">등록된 댓글이 없습니다.</p>
	</section>
	} 댓글 끝

	} 댓글 쓰기 끝
	<script src="http://mrhome.kr/gnuboard5/js/md5.js"></script>

	링크 버튼 시작 {
	<div id="bo_v_bot">
		<ul class="bo_v_nb">
			<li>
				<a href="./board.php?bo_table=yunint_gallery&amp;wr_id=20" class="btn_b01">다음글</a>
			</li>
		</ul>

		<ul class="bo_v_com">
			<li>
				<a href="./board.php?bo_table=yunint_gallery&amp;page=" class="btn_b01">목록</a>
			</li>
			<li>
				<a href="./write.php?bo_table=yunint_gallery" class="btn_b02">글쓰기</a>
			</li>
		</ul>
	</div>
	} 링크 버튼 끝 -->

</article>
<!-- } 게시판 읽기 끝 -->
<script>
	$(function() {
		$("a.view_image").click(function() {
			window.open(this.href,"large_image","location=yes,links=no,toolbar=no,top=10,left=10,width=10,height=10,resizable=yes,scrollbars=no,status=no");
			return false;
		});

		// 추천, 비추천
		$("#good_button, #nogood_button").click(function() {
			var $tx;
			if (this.id == "good_button")
				$tx = $("#bo_v_act_good");
			else
				$tx = $("#bo_v_act_nogood");

			excute_good(this.href, $(this), $tx);
			return false;
		});

		// 이미지 리사이즈
		$("#bo_v_atc").viewimageresize();
	});
</script>
<!-- } 게시글 읽기 끝 -->
<style>
/*#footer영역*/
#footer {
	width: 100%;
	height: 180px;
	background: #2a2a2a;
	position: relative;
}

#footerin .flogo {
	color: #ffffff;
	position: absolute;
	top: 20px;
	left: 50%;
	margin-left: -180px;
	font-weight: 400;
}

#footerin .fright {
	position: absolute;
	bottom: 45px;
	right: 50%;
	margin-right: -75px;
}

#footerin .hp {
	position: absolute;
	bottom: 15px;
	color: #545454;
	right: 50%;
	margin-right: -90px;
}

@media screen and (min-width:640px) {
	#wrap {
		min-width: 640px;
	}
	#header .utill {
		display: none;
	}
	#footerin .hp {
		color: #545454;
		position: absolute;
		bottom: 10px;
		right: 50%;
		margin-right: -100px;
	}
}

@media screen and (min-width:1024px) {
	#wrap {
		min-width: 1024px;
	}
	#sns {
		display: none;
	}
	/*#footer영역*/
	#footer {
		width: 100%;
		height: 140px;
		background: #2a2a2a;
		position: relative;
	}
	#footerin .flogo {
		color: #ffffff;
		position: absolute;
		top: 20px;
		left: 50%;
		margin-left: -500px;
		font-weight: 400;
	}
	#footerin .hp {
		position: absolute;
		bottom: 15px;
		color: #545454;
		right: 50%;
		margin-right: -90px;
	}
	#footerin .fright {
		color: #ffffff;
		position: absolute;
		bottom: 20px;
		right: 50%;
		margin-right: -480px;
	}
}

</style>

