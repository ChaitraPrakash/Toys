<%@taglib prefix="c"  uri ="http://www.springframework.org/tags" %>
<%@taglib prefix="security"  uri ="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  font-family: Comic Sans MS;
  font-size: 17px;
  padding: 8px;
}

* {
  box-sizing: border-box;
}

.row {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 -16px;
}

.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}

.container {
  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid grey;
  border-radius: 3px;
}

input[type=text] {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid black;
  border-radius: 3px;
}

label {
  margin-bottom: 10px;
  display: block;
}

.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}

.btn {
  background-color:green;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}

.btn:hover {
  background-color: #45a049;
}

a {
  color: #2196F3;
}

hr {
  border: 1px solid lightgrey;
}

span.price {
  float: right;
  color: grey;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
@media (max-width: 800px) {
  .row {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 20px;
  }
}
</style>
</head>
<body>

<h2>Responsive Form</h2>

<div class="row">
  <div class="col-75">
    <div class="container">
    
        <div class="row">
          <div class="col-50">
            <h3>BILLING</h3>
			 <label for="id"><i class="fa fa-id"></i>Billing ID</label>
            <form:input type="text" id="id" name="id" placeholder="ENTER ID"  path="billing.billingId"/>
			<label for="fname"><i class="fa fa-user"></i> Name</label>
            <form:input type="text" id="fname" name="firstname" placeholder="ENTER NAME" path="billing.billingName"/>
			 <label for="phone number"><i class="fa fa-phone number"></i>Phone Number</label>
            <form:input type="text" id="phone number" name="phone number" placeholder="ENTER NUMBER" path="billing.phone_No"/>
            <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
            <form:input type="text" id="adr" name="address" placeholder="ENTER ADDRESS" path="billing.address"/>
            <label for="country"><i class="fa fa-map"></i> Country</label>
            <form:input type="text" id="country" name="country" placeholder="ENTER COUNTRY" path="billing.country"/>

            </div>

          <div class="col-50">
            <h3>SHIPPING</h3>
            <c:url value="/orderConfirm" var="con"/>
      <form:form action="${con}" method="post"  commandName="shipping">
      		<label for="id"> Shipping ID</label>
            <form:input type="text" id="id" name="id" placeholder="ENTER ID" path="shippingId"/>
            <label for="fname"><i class="fa fa-user"></i> Name</label>
            <form:input type="text" id="fname" name="firstname" placeholder="ENTER NAME" path="shippingName"/>
			<label for="phone number"><i class="fa fa-phone number"></i>Phone Number</label>
            <form:input type="text" id="phone number" name="phone number" placeholder="ENTER NUMBER" path="PhoneNumber"/>        
			<label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
            <form:input type="text" id="adr" name="address" placeholder="ENTER ADDRESS"  path="Address"/>
            <label for="country"><i class="fa fa-map"></i> Country</label>
            <form:input type="text" id="country" name="country" placeholder="ENTER COUNTRY"  path="country"/>
            <input type="submit" value="CONTINUE" class="btn" style=font-family="Comic Sans MS">
      
          </form:form>
        </div>
     
        
    </div>
  </div>

</body>
</html>
