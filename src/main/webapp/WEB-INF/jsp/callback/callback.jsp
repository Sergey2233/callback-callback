<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>callback</title>



<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/bootstrap.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/site.css" />" />
</head>
<body>
	<div class="conrainer ">
		<%@ include file="header.jsp"%>
	</div>
	<script type="text/javascript" src="<c:url value="/js/bootstrap.js" />">
		
	</script>
	<script type="text/javascript"
		src="<c:url value="/js/jquery-2.1.4.js" />"></script>
	<script type="text/javascript" src="<c:url value="/js/site.js" />"></script>

</body>
</html>
