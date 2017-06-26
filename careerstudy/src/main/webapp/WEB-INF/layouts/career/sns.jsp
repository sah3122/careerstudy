<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="mainUri" value="${requestScope['javax.servlet.forward.request_uri']}" />
<c:choose>
	<c:when test="${fn:contains(mainUri, 'careerMain')}">
	</c:when>
	<c:otherwise>
		<div id="sns">
			<div class="call">
				<a href="tel:010-9279-0537">
					<img src="/img/career/icon1.gif">
				</a>
			</div>
		  	<div class="notice">
		  		<a href="/career/notice/noticeList.do">
		  			<img src="/img/career/icon2.gif">
		  		</a>
		  	</div>
		</div>
	</c:otherwise>
</c:choose>

<!--#sns-->