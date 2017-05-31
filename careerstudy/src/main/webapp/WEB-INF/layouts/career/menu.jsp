<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<header id="header">
	<h1 class="logo">
		<a href="/main/careerMain.do"><img src="/img/career/logo.png"></a>
	</h1>

	<a href="#" class="openMenu"><img src="/img/career/menu_bar.png" alt="메뉴열기"></a> 
	<nav class="gnb"> 
		<a href="#" class="close"><img	src="/img/career/close.png" alt="메뉴닫기"></a>
		<ul>
            <c:choose>
				<c:when test="${session == null}">	
					<li class="depth1">
		               	<a href="/main/careerIntro.do" class="m m0"><span>회사 소개</span><span class="arr"></span></a>
		            </li><!--.depth1-->
		            <li class="depth1">
		               	<a href="/main/careerWork.do" class="m m0"><span>프로그램 소개</span><span class="arr"></span></a>
		            	<span class="arr"></span>
		            </li><!--.depth1-->
		            <li class="depth1">
						<a href="/career/gallery/galleryList.do" class="m m0"><span>프로그램 사진</span><span class="arr"></span></a>
		                <span class="arr"></span>
		            </li><!--.depth1-->
		            <li class="depth1">
						<a href="/career/video/videoList.do" class="m m0"><span>프로그램 영상</span><span class="arr"></span></a>
		               	<span class="arr"></span>
		            </li><!--.depth1-->
		            <li class="depth1">
						<a href="/career/notice/noticeList.do" class="m m0"><span>공지사항</span><span class="arr"></span></a>
		            </li>
				</c:when>
				<c:otherwise>
					<li class="depth1">
		               	<a href="/main/careerIntro.do" class="m2 m0"><span>회사 소개</span><span class="arr"></span></a>
		            </li><!--.depth1-->
		            <li class="depth1">
		               	<a href="/main/careerWork.do" class="m2 m0"><span>프로그램 소개</span><span class="arr"></span></a>
		            	<span class="arr"></span>
		            </li><!--.depth1-->
		            <li class="depth1">
						<a href="/career/gallery/galleryList.do" class="m2 m0"><span>프로그램 사진</span><span class="arr"></span></a>
		                <span class="arr"></span>
		            </li><!--.depth1-->
		            <li class="depth1">
						<a href="/career/video/videoList.do" class="m2 m0"><span>프로그램 영상</span><span class="arr"></span></a>
		               	<span class="arr"></span>
		            </li><!--.depth1-->
		            <li class="depth1">
						<a href="/career/notice/noticeList.do" class="m2 m0"><span>공지사항</span><span class="arr"></span></a>
		            </li>
					<li class="depth1">
						<a href="/question/questionDetail.do" class="m2 m0"><span>교육만족도</span><span class="arr"></span></a>
		            </li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav><!--.gnb--> 
</header>
<!--#header-->