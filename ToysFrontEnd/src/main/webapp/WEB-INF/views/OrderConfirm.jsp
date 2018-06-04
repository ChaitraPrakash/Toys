 <%@taglib prefix="c"  uri ="http://www.springframework.org/tags" %>
<%@taglib prefix="form"  uri ="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c1" %>
<html>
<head>
<title>ORDER CONFIRM</title>
<style> 
body{
background-color:lavender ;
font-family:"Comic Sans MS" ;

}
</style>
</head>
<body>
<h1> ORDER CONFIRM</h1>
</body>
<table border="1px solid black">

<tr>
<th>billingId</th>
<th>billingName</th>
<th>address</th>
<th>phone_No</th>
<th>country</th>
</tr>


<tr>
<td>
${billing.billingId }
</td>
<td>${billing.billingName }
</td>
<td>
${billing.address }
</td>
<td>
${billing.phone_No}
</td>
<td>
${billing.country}
</td>
</tr>

</table>

<table border="1px solid black">

<br>
<br>

<tr>
<th>shippingId</th>
<th>shippingName</th>
<th>Address</th>
<th>PhoneNumber</th>
<th>Country</th>
</tr>
<tr>
<td>
${shipping.shippingId }
</td>
<td>
${shipping.shippingName}
</td>
<td>
${shipping.address}
</td>
<td>
${shipping.phoneNumber}
</td>
<td>
${shipping.country}
</td>

</tr>

</table>


<table border="1px solid black">
<br>
<br>

<tr>
<th>ProductId</th>
<th>ProductImage</th>
<th>ProductName</th>
<th>ProductDescription</th>
<th>Quantity</th>
<th>Price</th>
</tr>
<c1:if test="${Product!=null }">
<tr>
<td>
${Product.getProductId() }
</td>
<td><img src="${pageContext.request.contextPath }/Resources/${Product.getImageName() }">
</td>
<td>
${Product.getProductName() }
</td>
<td>
${Product.getProductDescription() }
</td>
<td>
${Product.getQuantity() }
</td>
<td>
${Product.getPrice() }
</td>

</tr>
</c1:if>


<c1:if test="${Product==null }">
<c1:forEach items="${CartItem1}" var="car">
<tr>
<td>
${car.getProduct().getProductId() }
</td>
<td><img src="${pageContext.request.contextPath }/Resources/${car.getProduct().getImageName() }">
</td>
<td>
${car.getProduct().getProductName() }
</td>
<td>
${car.getProduct().getProductDescription() }
</td>
<td>
${car.getProduct().getQuantity() }
</td>
<td>
${car.getProduct().getPrice() }
</td>

</tr>
</c1:forEach>
</c1:if>
</table>
<a href="<c:url value="/pay"/>">Pay</a>
</html>