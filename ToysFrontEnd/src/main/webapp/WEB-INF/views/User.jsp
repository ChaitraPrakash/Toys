<%@taglib prefix="c"  uri ="http://www.springframework.org/tags" %>
<%@taglib prefix="form"  uri ="http://www.springframework.org/tags/form"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c1" %>
<html>
<head>
<title>USER</title>


<style>

body {
    background-image: url("C:\\Users\\PPS\\Pictures\\5458256fe3c4ccb.jpg");
    background-size:cover;
	background-position:center;
}

#rcorners2 {
    border-radius:25px;
    width:100%; 
} 

ul {
    list-style-type: none;
    margin: 1;
    padding: 0;
    overflow: hidden;
    background-color:lavender;
}

li {
    float: left;
}

li a {
    display: block;
    color: black;
    text-align: center;
    padding: 17px 20px;
    text-decoration: none;
    transition: 2s;
    font-size:7spx;
}

li a:hover:not(.active) {
    background-color:gray;
}


	div.gallery {
    border: 1px solid #ccc;
}

div.gallery:hover {
    border: 1px solid #777;
}

div.gallery img {
    width: 100%;
    height: auto;
}

div.desc {
    padding: 15px;
    text-align: center;
}

* {
    box-sizing: border-box;
}

.responsive {
    padding: 0 6px;
    float: left;
    width: 24.99999%;
}

@media only screen and (max-width: 700px) {
    .responsive {
        width: 49.99999%;
        margin: 6px 0;
    }
}

@media only screen and (max-width: 500px) {
    .responsive {
        width: 100%;
    }
}

.clearfix:after {
    content: "";
    display: table;
    clear: both;
}

<!---gdfgfd-->

body {font-family: Comic Sans MS} 
* {box-sizing: border-box}
/* Full-width input fields */
input[type=text], input[type=password], input[type=email], input[type=tel] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
	font-family: Comic Sans MS;
}

/* Add a background color when the inputs get focus */
input[type=text]:focus, input[type=password]:focus {
    background-color:black;
    outline: bold black;
}

/* Set a style for all buttons */
input{
    background-color: #4CAF50;
    color: black;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
}

button:hover {
    opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
    padding: 14px 20px;
    background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
    padding: 16px;
}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color:lavender;
	
    padding-top: 50px;
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 80%; /* Could be more or less, depending on screen size */
}

/* Style the horizontal ruler */
hr {
    border: 1px solid black;
    margin-bottom: 25px;
}
 
/* The Close Button (x) */
.close {
    position: absolute;
    right: 35px;
    top: 15px;
    font-size: 40px;
    font-weight: bold;
    color: #f1f1f1;
	font-family:Comic Sans MS;
}

.close:hover,
.close:focus {
    color: #f44336;
    cursor: pointer;
}

/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 150%;
    }
}
</style>
</head>
<c:url value="/adduser"  var="users"/>
<form:form action="${users}" method="post" commandName="user">


<label>USER ID</label>
<form:input type="text" name="userid" path="userId"/>
<br>
<br>
<label>USER NAME</label>
<form:input type="text" name="username" path="userName"/>
<br>
<br>
<label>USER ADDRESS</label>
<form:input type="text" name="useraddress" path="Address"/>
<br>
<br>
<label>USER PHONE NUMBER</label>
<form:input type="tel" name="userphonenumber" path="PhoneNumber"/>
<br>
<br>
<label>USER EMAIL</label>
<form:input type="email" name="useremail" path="email_Id"/>
<br>
<br>
<label>USER PASSWORD</label>
<form:input type="password" name="userpassword" path="password"/>
<br>
<br>
<label>BILLING ID</label>
<form:input type="text" name="billingId" path="billing.billingId"/>
<br>
<br>
<label>BILLING NAME</label>
<form:input type="text" name="billingname" path="billing.billingName"/>
<br>
<br>
<label>COUNTRY</label>
<form:input type="text" name="country" path="billing.country"/>
<br>
<br>

<input type="submit" value="REGISTER"  class="signupbtn" >
<input type="reset" value="CANCEL" class="cancelbtn">

</form:form>


</html>
