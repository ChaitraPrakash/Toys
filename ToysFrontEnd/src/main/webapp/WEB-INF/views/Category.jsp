<%@taglib prefix="c"  uri ="http://www.springframework.org/tags" %>
<%@taglib prefix="form"  uri ="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c1" %>
<html>
<head>
<title>CATEGORY</title>
</head>
<c:url value="/addCategory" var="cat"/>
<form:form action="${ cat}" method="post" commandName="category">
<fieldset>
<legend>CATEGORY FORM</legend>
<label>CATEGORY ID</label>
<form:input type="text" name="categoryid" path="catId"/>
<br>
<br>
<label>CATEGORY NAME</label>
<form:input type="text" name="categoryname" path="catName"/>
<br>
<br>
<input type="submit" value="ADD CATEGORY">
<input type="reset" value="CANCEL">
</fieldset>
</form:form>

<table border="1px solid black">

<tr>
<th>CategoryId</th>
<th>CategoryName</th>
<th>Actions</th>
</tr>
<c1:forEach items="${categories}" var="cat">
<tr>
<td>
${cat.getCatId() }

</td>
<td>
${cat.getCatName() }
</td>
<td><a href="<c:url value="/editCategory/${cat.getCatId()}"/>">Edit</a>/<a href="<c:url value="/deleteCategory/${cat.getCatId()}"/>">Delete</a></td>
</tr>
</c1:forEach>
</table>
</html>
