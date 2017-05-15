// JavaScript Document

$(function(){ //제이쿼리명령을 실행시킬 틀의 시작

	/*
	$("클릭할 대상").click(function(){
    	$("클릭으로 인해 상태가 변할 대상").명령어();
	})
	*/

	// 햄버거메뉴를 클릭 -> .gnb/.opaB가 보임.

	$(".openMenu").click(function(){
    	$(".gnb").css({display:"block"});
		$(".opaB").css({display:"block"});
	})

	// 메뉴닫기를 클릭 -> .gnb/.opaB가 안보임.
	$(".gnb .close").click(function(){
    	$(".gnb").css({display:"none"});
		$(".opaB").css({display:"none"});
	})


	// 돋보기를 클릭 -> .scBox/.opaB가 보임.

	$(".hSC .btn").click(function(){
    	$(".scBox").css({display:"block"});
		$(".opaB").css({display:"block"});
	})

	// 검색 닫기를 클릭 ->  .scBox/.opaB가 안보임.
	$(".scBox .close").click(function(){
    	$(".scBox").css({display:"none"});
		$(".opaB").css({display:"none"});
	})






})//제이쿼리명령을 실행시킬 틀의 시작
