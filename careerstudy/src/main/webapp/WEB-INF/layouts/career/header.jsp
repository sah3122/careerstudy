<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>EDUCATION</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<!-- 내 명령을 작성할 문서.-->
<script src="/js/career/core.js"></script>
<script src="/js/career/jquery.bxslider.min.js"></script>
<script src="/js/career/jquery.menu.js"></script>
<script src="/js/career/common.js"></script>
<script src="/js/career/wrest.js"></script>
<link href="/css/career/base.css" rel="stylesheet"/>
<link href="/css/career/main.css" rel="stylesheet"/>
<link href="/css/career/jquery.bxslider.css" rel="stylesheet" />
<link href="/css/career/default.css" rel="stylesheet" />
<link href="/css/career/style.css" rel="stylesheet" />
<link href="/css/career/gallery.css" rel="stylesheet" />

<c:set var="mainUri" value="${requestScope['javax.servlet.forward.request_uri']}" />
<c:choose>
	<c:when test="${fn:contains(mainUri, 'main')}">
	</c:when>
	<c:otherwise>
		<link href="/css/career/reset.css" rel="stylesheet" type="text/css" />
	</c:otherwise>
</c:choose>
<c:if test="${fn:contains(mainUri, 'Work')}">
	<link href="/css/career/workmain.css" rel="stylesheet" type="text/css" />
</c:if>
<c:if test="${fn:contains(mainUri, 'Intro')}">
	<link href="/css/career/intromain.css" rel="stylesheet" type="text/css" />
</c:if>