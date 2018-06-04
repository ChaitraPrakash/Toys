<%@taglib prefix="c"  uri ="http://www.springframework.org/tags" %>
<%@taglib prefix="form"  uri ="http://www.springframework.org/tags/form"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c1" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script><style>
body {
	margin-top: 100px;
	font-family:"Comic Sans MS";
	background-color:black;
	margin-left:260px;
}
</style>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-xs-8">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">
						<div class="row">
							<div class="col-xs-6">
								<h5><span class="glyphicon glyphicon-shopping-cart"></span> SHOPPING CART</h5>
							</div>
							<div class="col-xs-6">
								<button type="button" class="btn btn-primary btn-sm btn-block">
									<a style="color:white" href="<c:url value="/" /> "><span class="glyphicon glyphicon-share-alt"></span> CONTINUE SHOPPING</a>
								</button>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-body">
				<c1:forEach items="${CartItems }" var="cart">
					<div class="row">
						<div class="col-xs-2"><img class="img-responsive" src="${pageContext.request.contextPath }/Resources/${cart.getProduct().getImageName() }">
						</div>
						<div class="col-xs-4">
							<h4 class="product-name"><strong>${cart.getProduct().getProductName() }</strong></h4><h4><small>${cart.getProduct().getProductDescription() }</small></h4>
						</div>
						<div class="col-xs-6">
							<div class="col-xs-6 text-right">
								<h6><strong>${cart.getProduct().getPrice() }<span class="text-muted">x</span></strong></h6>
							</div>
							<div class="col-xs-4">
								<input type="text" class="form-control input-sm" value="0">
							</div>
							<div class="col-xs-2">
							<button type="button" class="btn btn-link btn-xs">
									<a href="<c:url value="/Buy/${cart.getProduct().getProductId() }/${cart.getCartItemsId()}"/>"><span class="glyphicon glyphicon-thumbs-up"> </span></a>
									<a href="<c:url value="/Remove/${cart.getCartItemsId()}"/>"><span class="glyphicon glyphicon-trash"> </span>
								</button>
							</div>
						</div>
					</div>
					</c1:forEach>
					<hr>
					<center>
					<button type="button" class="btn btn-link btn-xs">
									<a href="<c:url value="/Buyall"/>"><span class="glyphicon glyphicon-thumbs-up"> </span>BuyAll</a>
									<a href="<c:url value="/RemoveAll"/>"><span class="glyphicon glyphicon-trash"> </span>RemoveAll</a>
								</button>
								</center>

					<hr>
					<div class="row">
						<div class="text-center">
							<div class="col-xs-9">
								<h6 class="text-right">ADDED ITEMS ?</h6>
							</div>
							<div class="col-xs-3">
								<button type="button" class="btn btn-default btn-sm btn-block">
									UPDATE CART
								</button>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-footer">
					<div class="row text-center">
						<div class="col-xs-9">
							<h4 class="text-right">TOTAL <strong>Rs ${GrandTotal}</strong></h4>
						</div>
						<div class="col-xs-3">
							<button type="button" class="btn btn-success btn-block">
							<a href="<c:url value="/pay	"/>">CHECKOUT</a>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>