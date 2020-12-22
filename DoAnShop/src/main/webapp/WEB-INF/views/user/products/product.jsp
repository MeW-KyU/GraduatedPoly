<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Product details</title>
<link href="<c:url value="/assets/user/css/css.css" />" rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="card ">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6 ">
						<div class="preview-pic tab-content">
							<img
								src="<c:url value="data:image/jpg;base64,${product.image}" />"
								height="450" />
						</div>
					</div>
					<div class="details col-md-6">
						<h3 class="product-title" class="text-light" style="color: white">${product.name_Product }</h3>
						<div class="rating">
							<div class="stars">
								<span class="fa fa-star checked"></span> <span
									class="fa fa-star checked"></span> <span
									class="fa fa-star checked"></span> <span
									class="fa fa-star checked"></span> <span
									class="fa fa-star checked"></span>
							</div>
						</div>
						<p class="product-description" style="color: white;">${product.description }</p>
						<h4 class="price ">
							price: <span>$ ${product.price }</span>
						</h4>
						<div class="sizes">
							amount: <input class="col-3" value="0" type="number" min="0"
								style="border: 5px"></input>
						</div>
						<h5 class="sizes">
							sizes: <strong style="color: orange">${product.size }</strong>
						</h5>
						<p>Please write the size you choose in "Note", otherwise the
							default will be size M</p>
						<div class="action">
							<a href="<c:url value="/AddCart/${product.product_Code }" />"
								class="ml-2 btn btn-white btn-outline-white">Add to cart</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<h3 style="color: white; font-weight: bold;">Other dishes:</h3>
	<br>
	<%-- Show products --%>
	<c:if test="${otherProducts.size()>0 }">
		<div class="row no-gutters d-flex">
			<c:forEach var="item" items="${otherProducts}" varStatus="Loop">
				<div class="col-lg-4 d-flex ftco-animate">
					<div class="services-wrap d-flex">
						<a href="<c:url value="/product-details/${item.product_Code }" />"
							class="img"
							style="background-image: url(<c:url value="data:image/jpg;base64,${item.image}" />);"></a>
						<div class="text p-4">
							<h3>${item.name_Product }</h3>
							<p>${item.description }</p>
							<p class="price">
								<span>$ ${item.price }</span> <a
									href="<c:url value="/AddCart/${item.product_Code }" />"
									class="ml-2 btn btn-white btn-outline-white">Order</a>
							</p>
						</div>
					</div>
				</div>
				<c:if
					test="${(loop.index + 1)  % 3 == 0 || (loop.index + 1) == otherProducts.size() }">
		</div>
		<c:if test="${(loop.index + 1) < otherProducts.size() }">
			<div class="row no-gutters d-flex">
				<div class="col-lg-4 d-flex ftco-animate">
		</c:if>
	</c:if>
	</c:forEach>
	</c:if>
	<%-- End show products --%>
	</div>
	<br>
	<br>
</body>