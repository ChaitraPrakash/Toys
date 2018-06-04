<%@taglib prefix="c"  uri ="http://www.springframework.org/tags" %>
<%@taglib prefix="form"  uri ="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c1" %>
<html>
<head>
<title>PRODUCT</title>
</head>
<c:url value="/addProduct" var="product"/>
<form:form action="${ product}" method="post" commandName="product" enctype="multipart/form-data"> 
<fieldset>
<legend>PRODUCT FORM</legend>
<label>PRODUCT ID</label>
<form:input type="text" name="productid" path="productId"/>
<br>
<br>
<label>PRODUCT NAME</label>
<form:input type="text" name="productname"  path="productName"/>
<br>
<br>
<label>PRODUCT DESCRIPTION</label>
<form:textarea rows="20" cols="40" name="msg" path="productDescription"/>

<br>
<br>
<label>PRODUCT QUANTITY</label>
<form:input type="text" name="productquantity" path="Quantity"/>
<br>
<br>
<label>PRODUCT PRICE</label>
<form:input type="text" name="productprice" path="Price"/>
<br>
<br>
<form:input type="file" path="pimg" name="pimg"/>
<input type="submit" value="ADD PRODUCT">
<input type="reset" value="CANCEL">
</fieldset>
</form:form>


<table border="1px solid black">

<tr>
<th>ProductId</th>
<th>ProductImage</th>
<th>ProductName</th>
<th>ProductDescription</th>
<th>Quantity</th>
<th>Price</th>
<th>Actions</th>
</tr>

<c1:forEach items="${products}" var="product">
<tr>
<td>
${product.getProductId() }
</td>
<td><img src="${pageContext.request.contextPath }/Resources/${product.getImageName() }">
</td>
<td>
${product.getProductName() }
</td>
<td>
${product.getProductDescription() }
</td>
<td>
${product.getQuantity() }
</td>
<td>
${product.getPrice() }
</td>

<td><a href="<c:url value="/editProduct/${product.getProductId()}"/>">Edit</a>/<a href="<c:url value="/deleteProduct/${product.getProductId()}"/>">Delete</a></td>
</tr>
</c1:forEach>
</table>

</html>