<%@taglib prefix="c"  uri ="http://www.springframework.org/tags" %>
<%@taglib prefix="form"  uri ="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c1" %>
<html>
<head>
<title>SUPPLIER</title>
</head>
<c:url value="/addSupplier" var="supplier"/>
<form:form action="${supplier}" method="post" commandName="supplier">
<fieldset>
<legend>SUPPLIER FORM</legend>
<label>SUPPLIER ID</label>
<form:input type="text" name="supplierid" path="supplierId"/>
<br>
<br>
<label>SUPPLIER NAME</label>
<form:input type="text" name="suppliername" path="supplierName"/>
<br>
<br>
<label>SUPPLIER ADDRESS</label>
<form:input type="text" name="supplieraddress" path="Address"/>
<br>
<br>
<label>SUPPLIER PHONE NUMBER</label>
<form:input type="tel" name="supplierphonenumber" path="PhoneNumber"/>
<br>
<br>
<input type="submit" value="ADD SUPPLIER">
<input type="reset" value="CANCEL">
</fieldset>
</form:form>

<table border="1px solid black">

<tr>
<th>SupplierId</th>
<th>SupplierName</th>
<th>Address</th>
<th>PhoneNumber</th>
<th>Actions</th>
</tr>
<c1:forEach items="${suppliers}" var="supplier">
<tr>
<td>
${supplier.getSupplierId() }
</td>
<td>
${supplier.getSupplierName() }
</td>
<td>
${supplier.getAddress() }
</td>
<td>
${supplier.getPhoneNumber() }
</td>

<td><a href="<c:url value="/editSupplier/${supplier.getSupplierId()}"/>">Edit</a>/<a href="<c:url value="/deleteSupplier/${supplier.getSupplierId()}"/>">Delete</a></td>
</tr>
</c1:forEach>
</table>

</html>