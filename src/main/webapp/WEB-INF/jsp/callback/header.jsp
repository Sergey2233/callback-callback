<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="container">
	<div class="col-xs-6 col-md-9 header-color">
		<h1>CallBack</h1>
	</div>
	<div class="col-xs-3 col-md-3  center-outer">
		<ul class="ul-none">
			<li>
				<div class=" center-inner ">
					<a href="?lang=en"><img src="/images/flag/Ukraine.png"
						alt="flag Ukraine"></a>|<a href="?lang=ru"><img
						src="/images/flag/Russia.png" alt="flag Russion"></a>
				</div>

			</li>
			<c:choose>
				<c:when test="${not empty currentUser.id}">
					<li><a class="center-inner" id="logout"><spring:message
								code="login.out" text="" /></a>

						<form action="/logout" method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
							<button id="button-form-logout" type="submit" class="notvisible">Log
								out</button>
						</form></li>
				</c:when>
				<c:otherwise>
					<li><a class="center-inner" href="/login"><spring:message
								code="login.in" text="" /></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>

<div class="header-menu">
	<div class="container header-menu">
		<div class="row">
			<div class=" col-xs-8 col-md-8 header-menu"></div>
			<div class="col-xs-4 col-md-4">
				<div></div>
			</div>
		</div>
	</div>
</div>