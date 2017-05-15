<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="utill">
	<p class="home">
		<a href="/main/careerMain.do">HOME</a>
	</p>
	<p class="blog">
		<c:choose>
			<c:when test="${session == null}">	
				<a href="/login/careerLogin.do">LOGIN</a>
			</c:when>
			<c:otherwise>
				<a href="/login/careerLogout.do">LOGOUT</a>
			</c:otherwise>
		</c:choose>
	</p>
	<p class="way">
		<a href="/sign/careerSign.do">SIGN UP</a>
	</p>
</div>
<!--.utill-->

