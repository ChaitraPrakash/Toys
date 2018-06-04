<%@taglib prefix="c"  uri ="http://www.springframework.org/tags" %>
<%@taglib prefix="security"  uri ="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>LOGIN</title>
</head>
<c:url value="/j_spring_security_check" var="login"/>
<form:form action=" ${login}" method="post">  
<fieldset>
<legend>LOGIN INFORMATION</legend>
<label>USERNAME</label>
<input type="text" name="j_username">
<br>
<br>
<label>PASSWORD</label>
<input type="text" name="j_password">
<br>
<br>
<input type="submit" value="LOGIN">
<input type="reset" value="CANCEL">
</fieldset>
</form:form>
</html>