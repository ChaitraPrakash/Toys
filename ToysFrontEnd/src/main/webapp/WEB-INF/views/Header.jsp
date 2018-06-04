<%@taglib prefix="c"  uri ="http://www.springframework.org/tags" %>
<%@taglib prefix="security"  uri ="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Home Page</title>
<meta charset="utf-8" >
<c:url value="/Resources/Images" var="img"/>
<c:url value="/Resources/CSS" var="css"/>
<c:url value="/Resources/JS " var=" js"/>
<style>

body {
    background-image: url("${img}/5458256fe3c4ccb.jpg");
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
input[type=text], input[type=password] {
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
    background-color:white;
    outline: bold black;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
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
    border: 1px solid #f1f1f1;
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
<body>
<h1 align="left"><font face="Comic Sans MS" size="+77" color="purple">TOYS</font></h1>
<hr color="Blue"/>
<form name=frm method="post">

<ul class="tab" id="rcorners2">
<li><a class="active"  href="#home" >Home</a></li>
<li><a href="<c:url value="/ShoppingZone"/>">SHOPPING ZONE</a></li>
<c1:if test="${pageContext.request.userPrincipal.name!=null }">
<security:authorize access="hasRole('ROLE_ADMIN')">
<li><a href="<c:url  value="/Category"/>">CATEGORY</a></li>
<li><a href="<c:url value="/Product"/>">PRODUCT</a></li>
<li><a href="<c:url value="/Supplier"/>">SUPPLIER</a></li>
</security:authorize>
</c1:if>
<li><a href="about us.html">ABOUT US</a></li>
<li><a href="contact us.html">CONTACT US</a></li>
<c1:if test="${pageContext.request.userPrincipal.name!=null}">
${pageContext.request.userPrincipal.name}
<li style="float:right"><a href="<c:url value="/j_spring_security_logout"/>">LOGOUT</a></li>
</c1:if>
<c1:if test="${pageContext.request.userPrincipal.name==null}">
<li style="float:right"><a  onclick="document.getElementById('id02').style.display='block'">LOGIN</a></li>
<!-- <li style="float:right"><a  onclick="document.getElementById('id01').style.display='block'">SIGN UP</a></li> -->
<li style="float:right"><a  href="<c:url value="/User"/>">SIGN UP</a></li>

</c1:if>
</ul>
<br>
<br>
</body>
</html>