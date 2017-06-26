<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script>
	$(function(){
		chart = Highcharts.chart('container', {
			chart: {
		        type: 'column'
		    },
		    title: {
		        text: '교육 만족도'
		    },
		    xAxis: {
		    	categories: ['교육의 대한 만족', '학습자료에 대한 만족']
		    },
		    yAxis: {
		    	title: {
		            text: '만족도'
		        }
		    }, 
		    series: [{
		    	name: $("#area_name").val(),
		    	data: [<c:out value="${questionData.QUESTION_AREA_EDU}" escapeXml="false"/>,<c:out value="${questionData.QUESTION_AREA_STUDY}" escapeXml="false"/>],
		    	color : '#434348'
		    }, {
		    	name: $("#school_name").val(),
		    	data: [<c:out value="${questionData.QUESTION_EDU}" escapeXml="false"/>,<c:out value="${questionData.QUESTION_STUDY}" escapeXml="false"/>],
		    	color : '#7cb5ec'
		    }],
		    responsive: {
		        rules: [{
		            condition: {
		                maxWidth: 700
		            },
		            chartOptions: {
		                legend: {
		                    align: 'center',
		                    verticalAlign: 'bottom',
		                    layout: 'horizontal'
		                },
		                yAxis: {
		                    labels: {
		                        align: 'left',
		                        x: 0,
		                        y: -5
		                    },
		                    title: {
		                        text: null
		                    }
		                },
		                subtitle: {
		                    text: null
		                },
		                credits: {
		                    enabled: false
		                }
		            }
		        }]
		    }
		});
		
	    if($(window).width() < 1022){
			chart.setSize(280, 500);
			$("#bo_v_con").css('width','300px');
		} else {
			chart.setSize(700, 600);
			$("#bo_v_con").css('width','732px');
		}
	});
	$(window).resize(function() {
		if($(window).width() < 1022){
			chart.setSize(280, 500);
			$("#bo_v_con").css('width','300px');
		} else {
			chart.setSize(700, 600);
			$("#bo_v_con").css('width','732px');
		}
	});
</script>
<h2 id="container_title">교육만족도</h2>
<div class="tbl_frm01 tbl_wrap">
	<input type="hidden" id="edu_val" value="${questionData.QUESTION_EDU}"/>
	<input type="hidden" id="study_val" value="${questionData.QUESTION_STUDY}"/>
	<input type="hidden" id="area_edu_val" value="${questionData.QUESTION_AREA_EDU}"/>
	<input type="hidden" id="area_study_val" value="${questionData.QUESTION_AREA_STUDY}"/>
	<input type="hidden" id="area_name" value="${questionData.QUESTION_AREA_NAME}"/>
	<input type="hidden" id="school_name" value="${questionData.QUESTION_SCHOOL_NAME}"/>
	<section id="bo_v_atc">
		<div id="bo_v_con" style="margin:0 auto; width:732px">
		<div id="container" class="container"/>
		</div>
	</section>
</div>
