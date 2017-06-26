<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>
	$(document).ready(function(){
		var slider = $('.bxslider').bxSlider({
				auto: true, mode:'fade',
			});
		var slider_01 =	$('.bxslider_01').bxSlider({
				auto: true,autoControls: true, mode:'vertical',
			});
		var slider_02 =	$('.bxslider_02').bxSlider({
				auto: true,controls:false,pagerCustom: '#bx-pager1'
			});
		var slider_03 =	$('.bxslider_03').bxSlider({
				auto: true,controls:false,pager:false,maxSlides: 3,moveSlides:1,  slideWidth: 100,slideMargin:0,autoHover:true,
			});
			// 클릭시 멈춤 현상 해결 //
			$(document).on('click','.bx-next, .bx-prev',function() {
				slider.stopAuto();
				slider.startAuto();
				slider_01.stopAuto();
				slider_01.startAuto();
			});
			$(document).on('mouseover','.bx-pager, #bx-pager1',function() {
				slider.stopAuto();
				slider.startAuto();
				slider_01.stopAuto();
				slider_01.startAuto();
				slider_02.stopAuto();
				slider_02.startAuto();
			});
	});
</script>
<div id="s_banner_wrap">
	<ul class="bxslider">
		<li class="banner_01"><img src="/img/career/mainSlider1.jpg"></li>
		<li class="banner_02"><img src="/img/career/mainSlider2.jpg"></li>
		<li class="banner_03"><img src="/img/career/mainSlider3.jpg"></li>
	</ul>
</div>
<div id="center_wrap" class="wrap">
	<div id="conten_wrap" class="out_box">
		<div id="con_1">
			<div class="con_1_box">
				<a href="/main/careerIntro.do"><img src="/img/career/msub1.jpg"></a>
			</div>
			<div class="con_1_box">
				<a href="/main/careerWork.do"><img src="/img/career/msub2.jpg"></a>
			</div>
			<div class="con_1_box">
				<a href="/career/gallery/galleryList.do"><img src="/img/career/msub3.jpg"></a>
			</div>
			<div class="con_1_box">
				<a href="/career/video/videoList.do"><img src="/img/career/msub4.jpg"></a>
			</div>
            <div class="con_1_box">
            	<a href="/career/notice/noticeList.do"><img src="/img/career/msub5.jpg"></a>
            </div>
            <div class="con_1_box">
            	<a href="tel:010-9279-0537"><img src="/img/career/msub6.jpg"></a>
            </div>
		</div>
	</div>
</div>


<div id="pBCont">
	<div class="pSub">
		<p>
			<a href="/main/careerWork.do"><img src="/img/career/psub1.jpg"></a>
		</p>
		<p>
			<a href="/career/gallery/galleryList.do"><img src="/img/career/psub2.jpg"></a>
		</p>
		<p class="last">
			<a href="/career/notice/noticeList.do"><img src="/img/career/psub3.jpg"></a>
		</p>
	</div>
	<!--.pSub-->
</div>


