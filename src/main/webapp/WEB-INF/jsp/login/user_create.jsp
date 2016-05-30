<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
 

<div id="modal-create-user" class =" col-xs-12 col-md-12 notvisible  dialog_window" title= <spring:message code="Register" text="" />>
<p>You can use: demo@localhost / demo</p>
<p id = "error-login" class = "notvisible"><spring:message code="Error.login" text="" /></p>
<form id ="form-create-user" class="form-signin"  role="form" action="" method="post">
   
    <input  id ="token-create-user" type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      
    <div>
        <label class = "col-xs-12 col-md-12"  for="email"> <spring:message code="Email.address" text="" /></label>
        <input class = "col-xs-12 col-md-12  form-control some_input" type="email" name="email" id="email" required autofocus/>
    </div>
    
    <div>
        <label  class = "col-xs-12 col-md-12" for="password"><spring:message code="Password" text="" /></label>
        <input  class = "col-xs-12 col-md-12 form-control some_input" type="password" name="password" id="password" required/>
    </div>
 
     <div>
        <label class = "col-xs-12 col-md-12" for="passwordRepeated"><spring:message code="Repeat" text="" /></label>
        <input class = "col-xs-12 col-md-12 form-control some_input" type="password" name="passwordRepeated" id="passwordRepeated" required/>
    </div>
    
    <div class = "row col-xs-12 col-md-12" style = "margin-top:10px">
      <button type="button" class="btn-sec btn btn-link" id="button-create-user"><spring:message code="Register.button" text="" /></button>  
      </div>
</form>
</div>
</body>
</html>