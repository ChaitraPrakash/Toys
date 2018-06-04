  <%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@taglib prefix="c"  uri ="http://www.springframework.org/tags" %>
<%@taglib prefix="form"  uri ="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
  <html>
  <head>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script  src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"> </script>
  <script>
  var  app = angular.module('myApp',[ ]);
  app.controller('myCtrl',function($scope, $http)
  {
	  $http.get("http://localhost:8080/ToysFrontEnd/SendMail")
  });
  </script>
  <style>
  body
 
   {
  font-family: Comic Sans MS;
  font-size: 17px;
  padding: 8px;
  border-color:1px solid black;
  background-color:lavender;
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
  border: 1px solid black;
  border-radius: 3px;
}

input[type=text] {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 2px solid black;
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
  border: 1px solid grey;
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
 <c:url  value="/payment" var="pa"/>
  <form:form action="${pa}" method="post" id="myForm">
 
<fieldset>

  <div class="col-50">
            <h2>PAYMENT</h2>
            <label for="fname">Accepted Cards</label>
            <div class="icon-container">
              <i class="fa fa-cc-visa" style="color:navy;"></i>
              <i class="fa fa-cc-amex" style="color:blue;"></i>
              <i class="fa fa-cc-mastercard" style="color:red;"></i>
              <i class="fa fa-cc-discover" style="color:orange;"></i>
            </div>
            <label for="cname">Name 0n Card</label>
            <input type="text" id="cname" name="cardname" placeholder="ENTER NAME">
            <label for="ccnum">Credit Card Number</label>
            <input type="text" id="ccnum" name="cardnumber" placeholder="ENTER CARD NUMBER">
            <label for="expmonth">Exp Month</label>
            <input type="text" id="expmonth" name="expmonth" placeholder="ENTER MONTH">
            <div class="row">
              <div class="col-50">
                <label for="expyear">Exp Year</label>
                <input type="text" id="expyear" name="expyear" placeholder="ENTER YEAR">
              </div>
              <div class="col-50">
                <label for="cvv">CVV</label>
                <input type="text" id="cvv" name="cvv" placeholder="CVV NUMBER">
              </div>
              
              <div class="col-50">
                <label for="cvv">OTP</label>
                <input type="text" id="otp" name="otp" ng-app="myApp" ng-controller="myCtrl"  placeholder="OTP NUMBER">
              </div>
            </div>
          </div>
          
        </div>
     
        <input type="submit" value="CONTINUE" class="btn" style=font-family="Comic Sans MS">
      </form:form>
    </div>
  </div>
</fieldset>
</body>
</html>