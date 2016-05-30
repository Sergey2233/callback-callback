<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page  import="javax.servlet.jsp.PageContext"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>callback</title>



<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/bootstrap.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/site.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/jquery-ui.css" />" />
	<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/jquery-ui.min.css" />" />
	
	<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/jquery-ui.structure.min.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/jquery-ui.theme.css" />" />
	<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/jquery-ui.theme.min.css" />" />
	<script>var ctx = "${ pageContext.servletContext.contextPath }"
   
		console.log(ctx +"ctx")</script>
	
</head>
<body>
<%=request.getContextPath()%>
	<div class="conrainer ">
		<%@ include file="header.jsp"%>
	</div>
	
	<%@ include file="../login/login.jsp"%>
	<%@ include file="../login/user_create.jsp"%>

<script type="text/javascript" src="<c:url value="/js/bootstrap.js" />">
	</script>
	<script type="text/javascript"
		src="<c:url value="/js/jquery-2.1.4.js" />"></script>
	<script type="text/javascript" src="<c:url value="/js/site.js" />"></script>
	<script type="text/javascript" src="<c:url value="/js/site-ajax.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/js/jquery-ui.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/js/jquery-ui.js" />"></script>

</body>
</html>
