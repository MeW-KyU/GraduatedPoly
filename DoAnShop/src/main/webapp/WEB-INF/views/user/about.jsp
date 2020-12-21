<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>
<title>About Us</title>
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
						<h1 class="mb-3 mt-5 bread">About</h1>
						<p class="breadcrumbs">
							<span class="mr-2"><a href="<c:url value="/home" />">Home</a></span>
							<span>About</span>
						</p>
					</div>

				</div>
			</div>
		</div>
	</section>


	<section class="ftco-intro">
		<div class="container-wrap">
			<div class="wrap d-md-flex">
				<div class="info">
					<div class="row no-gutters">
						<div class="col-md-4 d-flex ftco-animate">
							<div class="icon">
								<span class="icon-phone"></span>
							</div>
							<div class="text">
								<h3>(028) 7308 8800</h3>
								<p>Contact us by this hotline anytime</p>
							</div>
						</div>
						<div class="col-md-4 d-flex ftco-animate">
							<div class="icon">
								<span class="icon-my_location"></span>
							</div>
							<div class="text">
								<h3>Innovation Building, Lot 24</h3>
								<p>Quang Trung Software Park, District 12, Ho Chi Minh</p>
							</div>
						</div>
						<div class="col-md-4 d-flex ftco-animate">
							<div class="icon">
								<span class="icon-clock-o"></span>
							</div>
							<div class="text">
								<h3>Open Monday-Saturday</h3>
								<p>8:00am - 5:30pm</p>
							</div>
						</div>
					</div>
				</div>
				<div class="social d-md-flex pl-md-5 p-4 align-items-center">
					<ul class="social-icon">
						<li class="ftco-animate"><a
							href="https://twitter.com/fptpoly" target="_blank"><span
								class="icon-twitter"></span></a></li>
						<li class="ftco-animate"><a
							href="https://www.facebook.com/fpt.poly" target="_blank"><span
								class="icon-facebook"></span></a></li>
						<li class="ftco-animate"><a
							href="https://www.instagram.com/caodangfptpolytechnic/"
							target="_blank"><span class="icon-instagram"></span></a></li>
					</ul>
				</div>
			</div>
		</div>
	</section>

	<section class="ftco-about d-md-flex">
		<div class="one-half img"
			style="background-image: url(<c:url value="/assets/user/images/about.jpg" />);"></div>
		<div class="one-half ftco-animate">
			<div class="heading-section ftco-animate ">
				<h2 class="mb-4">
					Welcome to <span class="flaticon-pizza">Pizza</span> A Restaurant
				</h2>
			</div>
			<div>
				<p>Welcome to our restaurant with it's relaxing and friendly
					atmosphere in Ho Chi Minh City, Vietnam. We are happy to serve our
					guests the finest quality Italian cuisine. Join us for lunch or
					dinner.</p>
			</div>
		</div>
	</section>

	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center mb-5 pb-3">
				<div class="col-md-7 heading-section ftco-animate text-center">
					<h2 class="mb-4">Our Chef</h2>
					<p class="flip">
						<span class="deg1"></span><span class="deg2"></span><span
							class="deg3"></span>
					</p>
					<p class="mt-5">We always have a team of veteran and reliable
						chefs</p>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-3 d-flex mb-sm-4 ftco-animate">
					<div class="staff">
						<div class="img mb-4"
							style="background-image: url(<c:url value="/assets/user/images/person_1.jpg" />);"></div>
						<div class="info text-center">
							<h3>
								<a href="teacher-single.html">Tom Smith</a>
							</h3>
							<span class="position">Professional Chef</span>
							<div class="text">
								<p>Top chef of Italian cuisine</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 d-flex mb-sm-4 ftco-animate">
					<div class="staff">
						<div class="img mb-4"
							style="background-image: url(<c:url value="/assets/user/images/person_2.jpg" />);"></div>
						<div class="info text-center">
							<h3>
								<a href="teacher-single.html">Mark Wilson</a>
							</h3>
							<span class="position">Professional Chef</span>
							<div class="text">
								<p>Top chef of German food</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 d-flex mb-sm-4 ftco-animate">
					<div class="staff">
						<div class="img mb-4"
							style="background-image: url(<c:url value="/assets/user/images/person_3.jpg" />);"></div>
						<div class="info text-center">
							<h3>
								<a href="teacher-single.html">Patrick Jacobson</a>
							</h3>
							<span class="position">Professional Chef</span>
							<div class="text">
								<p>Top chef of French cuisine</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 d-flex mb-sm-4 ftco-animate">
					<div class="staff">
						<div class="img mb-4"
							style="background-image: url(<c:url value="/assets/user/images/person_4.jpg" />;"></div>
						<div class="info text-center">
							<h3>
								<a href="teacher-single.html">Ivan Dorchsner</a>
							</h3>
							<span class="position">Professional Chef</span>
							<div class="text">
								<p>Top chef of Indian food</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<section class="ftco-counter ftco-bg-dark img" id="section-counter"
		style="background-image: url(<c:url value="/assets/user/images/bg_2.jpg" />);"
		data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-10">
					<div class="row">
						<div
							class="col-md-6 col-lg-3 d-flex justify-content-center counter-wrap ftco-animate">
							<div class="block-18 text-center">
								<div class="text">
									<div class="icon">
										<span class="flaticon-pizza-1"></span>
									</div>
									<strong class="number" data-number="100">0</strong> <span>Pizza
										Branches</span>
								</div>
							</div>
						</div>
						<div
							class="col-md-6 col-lg-3 d-flex justify-content-center counter-wrap ftco-animate">
							<div class="block-18 text-center">
								<div class="text">
									<div class="icon">
										<span class="flaticon-medal"></span>
									</div>
									<strong class="number" data-number="85">0</strong> <span>Number
										of Awards</span>
								</div>
							</div>
						</div>
						<div
							class="col-md-6 col-lg-3 d-flex justify-content-center counter-wrap ftco-animate">
							<div class="block-18 text-center">
								<div class="text">
									<div class="icon">
										<span class="flaticon-laugh"></span>
									</div>
									<strong class="number" data-number="10567">0</strong> <span>Happy
										Customer</span>
								</div>
							</div>
						</div>
						<div
							class="col-md-6 col-lg-3 d-flex justify-content-center counter-wrap ftco-animate">
							<div class="block-18 text-center">
								<div class="text">
									<div class="icon">
										<span class="flaticon-chef"></span>
									</div>
									<strong class="number" data-number="900">0</strong> <span>Staff</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>