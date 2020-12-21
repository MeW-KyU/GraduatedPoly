<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>
<title>Our Services</title>
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
						<h1 class="mb-3 mt-5 bread">Services</h1>
						<p class="breadcrumbs">
							<span class="mr-2"><a href="<c:url value="/home" />">Home</a></span>
							<span>Services</span>
						</p>
					</div>

				</div>
			</div>
		</div>
	</section>


	<section class="ftco-section ftco-services">
		<div class="overlay"></div>
		<div class="container">
			<div class="row justify-content-center mb-5 pb-3">
				<div class="col-md-7 heading-section ftco-animate text-center">
					<h2 class="mb-4">Our Services</h2>
					<p>Here we always have the best services for you</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 ftco-animate">
					<div class="media d-block text-center block-6 services">
						<div
							class="icon d-flex justify-content-center align-items-center mb-5">
							<span class="flaticon-diet"></span>
						</div>
						<div class="media-body">
							<h3 class="heading">Healthy Foods</h3>
							<p>Healthy eating means eating a variety of foods that give
								you the nutrients you need to maintain your health, feel good,
								and have energy. These nutrients include protein, carbohydrates,
								fat, water, vitamins, and minerals.</p>
						</div>
					</div>
				</div>
				<div class="col-md-4 ftco-animate">
					<div class="media d-block text-center block-6 services">
						<div
							class="icon d-flex justify-content-center align-items-center mb-5">
							<span class="flaticon-bicycle"></span>
						</div>
						<div class="media-body">
							<h3 class="heading">Fastest Delivery</h3>
							<p>As online shoppers, there are not many customers who are
								believed to wait such a very long time to get what they have
								ordered. In Vietnam, no one can deny that TP. Ho Chi Minh is a
								rising market and potential for the e-commerce industry,
								therefore, DoAN has launched a fast delivery service in this
								city within only 1 hour for parcel whose more than 2 items.</p>
						</div>
					</div>
				</div>
				<div class="col-md-4 ftco-animate">
					<div class="media d-block text-center block-6 services">
						<div
							class="icon d-flex justify-content-center align-items-center mb-5">
							<span class="flaticon-pizza-1"></span>
						</div>
						<div class="media-body">
							<h3 class="heading">Original Recipes</h3>
							<p>Travel around the world without leaving your kitchen with
								these international recipes. From Canada to Australia, Mexico to
								Sweden—and everywhere in between.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="ftco-gallery">
		<div class="container-wrap">
			<div class="row no-gutters">
				<div class="col-md-3 ftco-animate">
					<a href="<c:url value="/about" />"
						class="gallery img d-flex align-items-center"
						style="background-image: url(<c:url value="/assets/user/images/gallery-1.jpg" />);">
						<div
							class="icon mb-4 d-flex align-items-center justify-content-center">
							<span class="icon-search"></span>
						</div>
					</a>
				</div>
				<div class="col-md-3 ftco-animate">
					<a href="<c:url value="/about" />"
						class="gallery img d-flex align-items-center"
						style="background-image: url(<c:url value="/assets/user/images/gallery-2.jpg" />);">
						<div
							class="icon mb-4 d-flex align-items-center justify-content-center">
							<span class="icon-search"></span>
						</div>
					</a>
				</div>
				<div class="col-md-3 ftco-animate">
					<a href="<c:url value="/about" />"
						class="gallery img d-flex align-items-center"
						style="background-image: url(<c:url value="/assets/user/images/gallery-3.jpg" />);">
						<div
							class="icon mb-4 d-flex align-items-center justify-content-center">
							<span class="icon-search"></span>
						</div>
					</a>
				</div>
				<div class="col-md-3 ftco-animate">
					<a href="<c:url value="/about" />"
						class="gallery img d-flex align-items-center"
						style="background-image: url(<c:url value="/assets/user/images/gallery-4.jpg" />);">
						<div
							class="icon mb-4 d-flex align-items-center justify-content-center">
							<span class="icon-search"></span>
						</div>
					</a>
				</div>
			</div>
		</div>
	</section>

</body>