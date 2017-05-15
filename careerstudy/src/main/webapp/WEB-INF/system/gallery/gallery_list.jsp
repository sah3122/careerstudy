<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<script>
	function fn_gallery_detail(idx){
		$("#gallery_idx").val(idx);
		$("#data_form").attr("action", "/career/gallery/galleryDetail.do").submit();
	}
	
	function fn_search(pageNo){
        $("#currentPageNo").val(pageNo);
        $("#data_form").attr("action", "/career/gallery/galleryList.do").submit();
    }
</script>
<h2 id="container_title">
	프로그램 사진<span class="sound_only"> 목록</span>
</h2>

<!-- 게시판 목록 시작 { -->
<div id="bo_gall" style="width: 100%">
	<!--게시판 목록 시작(로그인) -->
<!-- 	<ul id="tnb" style="width: 97%; text-align: right; display: block">
		<li>
			<a href="http://mrhome.kr/gnuboard5/bbs/login.php?url=http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery"><b>로그인</b></a>
		</li>
	</ul> -->

	<!-- 게시판 카테고리 시작 { -->
	<div class="bo_fx">
		<!-- <div id="bo_list_total">
			<span>Total 16건</span> 1 페이지
		</div> -->
	</div>

	<form name="data_form" id="data_form" method="post">
		<input type="hidden" id="gallery_idx" name="gallery_idx" value="">
		<input type="hidden" id="currentPageNo" name="currentPageNo"/>
		<ul id="gall_ul">
			<c:choose>
				<c:when test="${fn:length(galleryList) > 0}">
					<c:forEach items="${galleryList}" var="row" varStatus="status">
						<li class="gall_li " style="width: 150px"><span class="sound_only"> 16 </span>
							<ul class="gall_con">
								<li class="gall_href">
									<a href="#" onclick="fn_gallery_detail(${row.GALLERY_IDX})">
										<img src="/images/careerstudy/${row.IMG_STR_NAME}" alt="" width="150" height="124">
									</a>
								</li>
								<li class="gall_text_href" style="width: 150px">
									<a href="#" onclick="fn_gallery_detail(${row.GALLERY_IDX})">${row.GALLERY_TITLE} </a>
								</li>
							</ul>
						</li>
					</c:forEach>
				</c:when>				
				<c:otherwise>
					
				</c:otherwise>
			</c:choose>
			
			<!-- <li class="gall_li " style="width: 150px"><span class="sound_only"> 16 </span>
				<ul class="gall_con">
					<li class="gall_href">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=21">
							<img src="http://mrhome.kr/gnuboard5/data/file/yunint_gallery/thumb-1930844923_mU8W3CZi_2dd96700c741008922274f0ca239c017b0866ea0_150x124.jpg" alt="" width="150" height="124">
						</a>
					</li>
					<li class="gall_text_href" style="width: 150px">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=21">아트월 </a>
					</li>
				</ul>
			</li>
			<li class="gall_li " style="width: 150px">
				<span class="sound_only"> 15 </span>
				<ul class="gall_con">
					<li class="gall_href">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=20">
							<img src="http://mrhome.kr/gnuboard5/data/file/yunint_gallery/thumb-1930844923_EdBLj2An_99cfbacfae6de7e0fb7c8d0fa46072c53259b7c8_150x124.jpg" alt="" width="150" height="124">
						</a>
					</li>
					<li class="gall_text_href" style="width: 150px">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=20"> 3연동중문 </a>
					</li>
				</ul>
			</li>
			<li class="gall_li " style="width: 150px">
				<span class="sound_only"> 14 </span>
				<ul class="gall_con">
					<li class="gall_href">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=19">
							<img src="http://mrhome.kr/gnuboard5/data/file/yunint_gallery/thumb-1930844923_5kWPmKYl_6dc8e93a6510860fb2182aa67891067fda8fe7f5_150x124.jpg" alt="" width="150" height="124">
						</a>
					</li>
					<li class="gall_text_href" style="width: 150px">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=19">욕실리모델링 </a>
					</li>
				</ul>
			</li>
			<li class="gall_li " style="width: 150px">
				<span class="sound_only"> 13 </span>
				<ul class="gall_con">
					<li class="gall_href">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=18">
							<img src="http://mrhome.kr/gnuboard5/data/file/yunint_gallery/thumb-1930844923_ENRhpUQZ_82c5282be11dafb0a8e42b8bc77bcaa3f5df993b_150x124.jpg" alt="" width="150" height="124">
						</a>
					</li>
					<li class="gall_text_href" style="width: 150px">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=18"> 주방 씽크대 </a>
					</li>
				</ul>
			</li>
			<li class="gall_li " style="width: 150px">
				<span class="sound_only"> 12 </span>
				<ul class="gall_con">
					<li class="gall_href">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=17">
							<img src="http://mrhome.kr/gnuboard5/data/editor/1608/thumb-b93daa2dd572246b5d8479c3a503daf9_1472220750_1935_150x124.jpg" alt="" width="150" height="124">
						</a>
					</li>
					<li class="gall_text_href" style="width: 150px">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=17">구산 유엔아… </a>
					</li>
				</ul>
			</li>
			<li class="gall_li " style="width: 150px">
				<span class="sound_only"> 11 </span>
				<ul class="gall_con">
					<li class="gall_href">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=16">
							<img src="http://mrhome.kr/gnuboard5/data/file/yunint_gallery/thumb-654783818_K5wpxsrb_ead8c649e583e284d03b6aa40b17a41225dc39c9_150x124.jpg" alt="" width="150" height="124">
						</a>
					</li>
					<li class="gall_text_href" style="width: 150px">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=16"> 현관중문 </a>
					</li>
				</ul>
			</li>
			<li class="gall_li " style="width: 150px">
				<span class="sound_only"> 10 </span>
				<ul class="gall_con">
					<li class="gall_href">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=15">
							<img src="http://mrhome.kr/gnuboard5/data/file/yunint_gallery/thumb-1930844923_vcBgeX82_dfff5cab2461f53b42548a369665494cfa46b01a_150x124.jpg" alt="" width="150" height="124">
						</a>
					</li>
					<li class="gall_text_href" style="width: 150px">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=15">현관중문 </a>
					</li>
				</ul>
			</li>
			<li class="gall_li " style="width: 150px">
				<span class="sound_only"> 9 </span>
				<ul class="gall_con">
					<li class="gall_href">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=14">
							<img src="http://mrhome.kr/gnuboard5/data/file/yunint_gallery/thumb-1930844923_CXWe9JRP_6879e302202ca8ad238dae62df683180e42825dd_150x124.jpg" alt="" width="150" height="124">
						</a>
					</li>
					<li class="gall_text_href" style="width: 150px">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=14">아트월 </a>
					</li>
				</ul>
			</li>
			<li class="gall_li " style="width: 150px">
				<span class="sound_only"> 8 </span>
				<ul class="gall_con">
					<li class="gall_href">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=13">
							<img src="http://mrhome.kr/gnuboard5/data/file/yunint_gallery/thumb-1930844923_n0FHGjsk_8fcba3d1a96e936d434bc789b32681b4ca45a681_150x124.jpg" alt="" width="150" height="124">
						</a>
					</li>
					<li class="gall_text_href" style="width: 150px">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=13">부엌가구 시… </a>
					</li>
				</ul>
			</li>
			<li class="gall_li " style="width: 150px">
				<span class="sound_only"> 7 </span>
				<ul class="gall_con">
					<li class="gall_href">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=12">
							<img src="http://mrhome.kr/gnuboard5/data/file/yunint_gallery/thumb-1930844923_bNrwz3yQ_b447e27675c913126b5993f43ddbbe7e04d6c19b_150x124.jpg" alt="" width="150" height="124">
						</a>
					</li>
					<li class="gall_text_href" style="width: 150px">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=12">욕실2 </a>
					</li>
				</ul>
			</li>
			<li class="gall_li " style="width: 150px">
				<span class="sound_only"> 6 </span>
				<ul class="gall_con">
					<li class="gall_href">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=11">
							<img src="http://mrhome.kr/gnuboard5/data/file/yunint_gallery/thumb-1930844923_HFejrwbZ_db4c5a40b6434e26f1b96b38395b938209ef3a15_150x124.jpg" alt="" width="150" height="124">
						</a>
					</li>
					<li class="gall_text_href" style="width: 150px">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=11">욕실리모델링… </a>
					</li>
				</ul>
			</li>
			<li class="gall_li " style="width: 150px">
				<span class="sound_only"> 5 </span>
				<ul class="gall_con">
					<li class="gall_href">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=10">
							<img src="http://mrhome.kr/gnuboard5/data/file/yunint_gallery/thumb-1930844923_oADsYbUC_e94e22bb58e3ff4d4912f5e25f643d5fc2cfc8e0_150x124.jpg" alt="" width="150" height="124">
						</a>
					</li>
					<li class="gall_text_href" style="width: 150px">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=10">붙박이장 </a>
					</li>
				</ul>
			</li>
			<li class="gall_li " style="width: 150px">
				<span class="sound_only"> 4 </span>
				<ul class="gall_con">
					<li class="gall_href">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=9">
							<img src="http://mrhome.kr/gnuboard5/data/file/yunint_gallery/thumb-1930844923_iKFzCRfu_619abc7c91fc52cfd07fc940ef2d85f57c592fd9_150x124.jpg" alt="" width="150" height="124">
						</a>
					</li>
					<li class="gall_text_href" style="width: 150px">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=9">거실인테리어 </a>
					</li>
				</ul>
			</li>
			<li class="gall_li " style="width: 150px">
				<span class="sound_only"> 3 </span>
				<ul class="gall_con">
					<li class="gall_href">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=8">
							<img src="http://mrhome.kr/gnuboard5/data/file/yunint_gallery/thumb-1930844923_LKdVzmun_f7f3d5996f7e988e0c8b752ced61d4f584b73981_150x124.jpg" alt="" width="150" height="124">
						</a>
					</li>
					<li class="gall_text_href" style="width: 150px">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=8">씽크대시공 </a>
					</li>
				</ul>
			</li>
			<li class="gall_li " style="width: 150px">
				<span class="sound_only"> 2 </span>
				<ul class="gall_con">
					<li class="gall_href">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=7">
							<img src="http://mrhome.kr/gnuboard5/data/file/yunint_gallery/thumb-1930844923_MGohepDf_5756ee2274d099a047bc7e807df7f62a3a0839f5_150x124.jpg" alt="" width="150" height="124">
						</a>
					</li>
					<li class="gall_text_href" style="width: 150px">
						<a href="http://mrhome.kr/gnuboard5/bbs/board.php?bo_table=yunint_gallery&amp;wr_id=7">욕실리모델링 </a>
					</li>
				</ul>
			</li> -->
		</ul>
		<div class="bo_fx"></div>
	</form>
</div>


<!-- 페이지 -->
<nav class="pg_wrap">
	<span class="pg">
		<c:if test="${not empty paginationInfo}">
	        <ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="fn_search"/>
	    </c:if>
	</span>
	<!-- <span class="pg">
		<span class="sound_only">열린</span> <strong class="pg_current">1</strong> <span class="sound_only">페이지</span> 
		<a href="./board.php?bo_table=yunint_gallery&amp;page=2" class="pg_page">2<span class="sound_only">페이지</span></a> 
		<a href="./board.php?bo_table=yunint_gallery&amp;page=2" class="pg_page pg_end">맨끝</a> 
	</span> -->
</nav>
<!-- 게시물 검색 시작 { -->
<!-- <fieldset id="bo_sch">
	<legend>게시물 검색</legend>

	<form name="fsearch" method="get">
		<input type="hidden" name="bo_table" value="yunint_gallery"> 
		<input type="hidden" name="sca" value=""> 
		<input type="hidden" name="sop" value="and"> <label for="sfl" class="sound_only">검색대상</label>
		<select name="sfl" id="sfl">
			<option value="wr_subject">제목</option>
			<option value="wr_content">내용</option>
			<option value="wr_subject||wr_content">제목+내용</option>
			<option value="mb_id,1">회원아이디</option>
			<option value="mb_id,0">회원아이디(코)</option>
			<option value="wr_name,1">글쓴이</option>
			<option value="wr_name,0">글쓴이(코)</option>
		</select> 
		<label for="stx" class="sound_only">검색어<strong class="sound_only"> 필수</strong></label> 
		<input type="text" name="stx" value="" required id="stx" class="frm_input required" size="15" maxlength="20"> 
		<input type="submit" value="검색" class="btn_submit">
	</form>
</fieldset> -->
<!-- } 게시물 검색 끝 -->

<!-- } 게시판 목록 끝 -->

<style>
/*
#sns{ margin:0 auto; height:auto; overflow:hidden; }
#sns img{width:100%; height:auto;}
.call{width:25%;  float:left;}
.txt{width:25%;  float:left;}
.kakao{width:25%;  float:left;}
.map{width:25%;  float:left;}

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


