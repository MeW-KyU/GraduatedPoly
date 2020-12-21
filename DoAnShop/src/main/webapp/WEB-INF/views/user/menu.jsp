<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>
<title>Food</title>

</head>
<body>

	<section class="home-slider owl-carousel img"
		style="background-image: url(<c:url value="/assets/user/images/bg_1.jpg" />);">

		<div class="slider-item"
			style="background-image: url(<c:url value="/assets/user/images/bg_3.jpg" />);">
			<div class="overlay"></div>
			<div class="container">
				<div
					class="row slider-text justify-content-center align-items-center">

					<div class="col-md-7 col-sm-12 text-center ftco-animate">
						<h1 class="mb-3 mt-5 bread">Our Menu</h1>
						<p class="breadcrumbs">
							<span class="mr-2"><a href="<c:url value="/home" />">Home</a></span>
							<span>Menu</span>
						</p>
					</div>

				</div>
			</div>
		</div>
	</section>

	<section class="ftco-menu">
		<div class="col-lg-8 ftco-animate p-md-5">
			<h3>The catalog of our dishes:</h3>
			<div class="nav ftco-animate nav-pills" id="v-pills-tab"
				role="tablist" aria-orientation="vertical">
				<a href="<c:url value="Menu" />"
						class="nav-link active">All</a>
				<c:forEach var="item" items="${categories }">
					<a href="<c:url value="/categories/${item.ID_Categories}" />"
						class="nav-link">${item.name_Categories}</a>
				</c:forEach>
			</div>
		</div>
	</section>

	<section class="ftco-section" style="padding: 0px !important;">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-7 heading-section ftco-animate text-center">
				</div>
			</div>
		</div>
		<div class="container-wrap">
			<%-- Show products --%>
			<c:if test="${AllProducts.size()>0 }">
				<div class="row no-gutters d-flex">
					<c:forEach var="item" items="${AllProducts}" varStatus="Loop">
						<div class="col-lg-4 d-flex ftco-animate">
							<div class="services-wrap d-flex">
								<a
									href="<c:url value="/product-details/${item.product_Code }" />"
									class="img"
									style="background-image: url(<c:url value="data:image/jpg;base64,${item.image}" />);"></a>
								<div class="text p-4">
									<h3>${item.name_Product }</h3>
									<p>${item.description }</p>
									<p class="price">
										<span>$ ${item.price }</span> <a
											href="<c:url value="/AddCart/${item.product_Code }" />"
											class="ml-2 btn btn-white btn-outline-white">Add to cart</a>
									</p>
								</div>
							</div>
						</div>
						<c:if
							test="${(loop.index + 1)  % 3 == 0 || (loop.index + 1) == AllProductsByID.size() }">
				</div>
				<c:if test="${(loop.index + 1) < AllProductsByID.size() }">
					<div class="row no-gutters d-flex">
						<div class="col-lg-4 d-flex ftco-animate">
				</c:if>
			</c:if>
			</c:forEach>
			</c:if>
			<%-- End show products --%>
		</div>
	</section>

</body>