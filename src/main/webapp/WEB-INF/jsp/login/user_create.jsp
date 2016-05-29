<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<!--  <nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<h1>Create a new user</h1>
-->
<div id="modal-create-user" class =" col-xs-12 col-md-12 notvisible  dialog_window" title= <spring:message code="Enter" text="" />>
<form role="form" name="form" action="public/create" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div>
        <label for="email">Email address</label>
        <input type="email" name="email" id="email" value="${form.email}" required autofocus/>
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password" required/>
    </div>
    <div>
        <label for="passwordRepeated">Repeat</label>
        <input type="password" name="passwordRepeated" id="passwordRepeated" required/>
    </div>
    <div>
        <label for="role">Role</label>
        <select name="role" id="role" required>
            <option value='USER'>USER</option>
            <option value='ADMIN'>ADMIN</option>
        </select>
    </div>
    <button type="submit">Save</button>
</form>
</div>
</body>
</html>