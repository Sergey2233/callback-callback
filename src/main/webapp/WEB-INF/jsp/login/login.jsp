<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
 

<div id="modallogin" class =" col-xs-12 col-md-12 notvisible  dialog_window" title= <spring:message code="Enter" text="" />>
<p>You can use: demo@localhost / demo</p>
<p id = "error-login" class = "notvisible"><spring:message code="Error.login" text="" /></p>
<form id ="formlogin"  class="form-signin" role="form" action="" method="post">
    <input  id ="token" type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      
    <div>
        <label class = "col-xs-12 col-md-12"  for="email"> <spring:message code="Email.address" text="" /></label>
        <input class = "col-xs-12 col-md-12 form-control some_input" type="email" name="email" id="email" required autofocus/>
    </div>
    <div>
        <label  class = "col-xs-12 col-md-12" for="password"><spring:message code="Password" text="" /></label>
        <input  class = "col-xs-12 col-md-12 form-control some_input "type="password" name="password" id="password" required/>
    </div>
    <div>
        <label for="remember-me"><spring:message code="Remember.me" text="" /></label>
        <input type="checkbox" name="remember-me" id="remember-me"/>
    </div>
    <div class = "row col-xs-12 col-md-12">
      <div class = "col-xs-4 col-md-4">
      <button type="button"  id = "button-login" class="btn-sec btn btn-link"   ><spring:message code="Sign.in" text="" /></button>
      </div> 
       <div class = "col-xs-8 col-md-8">
           <div class ="col-xs-offset-2 col-md-offset-2">
            <button type="button" id ="check-in" class="btn-sec btn btn-link"><spring:message code="Check.in" text="" /></button>
            </div>
      </div> 
      </div>
</form>
</div>
</body>
</html>