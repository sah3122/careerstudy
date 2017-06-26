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
	<!-- 게시판 카테고리 시작 { -->
	<div class="bo_fx">
	</div>

	<form name="data_form" id="data_form" method="post">
		<input type="hidden" id="gallery_idx" name="gallery_idx" value="">
		<input type="hidden" id="currentPageNo" name="currentPageNo"/>
		<c:choose>
			<c:when test="${fn:length(galleryList) > 0 && galleryList[0].TOTAL_COUNT ne 0}">
				<ul id="gall_ul">
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
				</ul>
			</c:when>						
			<c:otherwise>
				<div style="text-align:center">
					등록된 사진이 없습니다.
				</div>
			</c:otherwise>
		</c:choose>
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
</nav>

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


