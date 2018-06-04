
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
<c:url value="/Resources/Images" var="pic"/>
<style>
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


body {
    background-image: url("${img}/5458256fe3c4ccb.jpg");
    background-size:cover;
	background-position:center;
}

#rcorners2 {
    border-radius:25px;
    width:35%; 
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
    padding: 17px 10px;
    text-decoration: none;
    transition: 2s;
    font-size:7spx;
}

li a:hover:not(.active) {
    background-color:gray;
}



</style>
</head>
<body>
<c1:forEach items="${products}" var="pro">
<div class="responsive">
  <div class="picture" >
  
    <a target="_blank"  href="${pageContext.request.contextPath }/Resources/${pro.getImageName() }">
      <img src="${pageContext.request.contextPath }/Resources/${pro.getImageName() }" alt="" width="300" height="400">
    </a>
    <div class="desc">${pro.getProductDescription()}</div>
    <ul class="tab" id="rcorners2">
    <li><a class="active"  href="<c:url  value="/addtocart/${pro.getProductId()}" />">Add To Cart</a></li>
    </ul>
  
  </div>
</div>
 </c1:forEach>    
</body>
</html>