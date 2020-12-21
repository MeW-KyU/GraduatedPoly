<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<title>Home</title>
<body>

	<section class="home-slider owl-carousel img"
		style="background-image: url(<c:url value="/assets/user/images/bg_1.jpg" />);">
		<div class="slider-item">
			<div class="overlay"></div>
			<div class="container">
				<div class="row slider-text align-items-center"
					data-scrollax-parent="true">

					<div class="col-md-6 col-sm-12 ftco-animate">
						<span class="subheading">Delicious</span>
						<h1 class="mb-4">Italian Cuizine</h1>
						<p class="mb-4 mb-md-5">A small river named Duden flows by
							their place and supplies it with the necessary regelialia.</p>
					</div>
					<div class="col-md-6 ftco-animate">
						<img src="<c:url value="/assets/user/images/bg_1.png" />"
							class="img-fluid" alt="">
					</div>

				</div>
			</div>
		</div>

		<div class="slider-item">
			<div class="overlay"></div>
			<div class="container">
				<div class="row slider-text align-items-center"
					data-scrollax-parent="true">

					<div class="col-md-6 col-sm-12 order-md-last ftco-animate">
						<span class="subheading">Crunchy</span>
						<h1 class="mb-4">Italian Pizza</h1>
						<p class="mb-4 mb-md-5">A small river named Duden flows by
							their place and supplies it with the necessary regelialia.</p>
					</div>
					<div class="col-md-6 ftco-animate">
						<img src="<c:url value="/assets/user/images/bg_2.png" />"
							class="img-fluid" alt="">
					</div>

				</div>
			</div>
		</div>

		<div class="slider-item"
			style="background-image: url(<c:url value="/assets/user/images/bg_3.jpg" />);">
			<div class="overlay"></div>
			<div class="container">
				<div
					class="row slider-text justify-content-center align-items-center"
					data-scrollax-parent="true">

					<div class="col-md-7 col-sm-12 text-center ftco-animate">
						<span class="subheading">Welcome</span>
						<h1 class="mb-4">We cooked your desired Pizza Recipe</h1>
						<p class="mb-4 mb-md-5">A small river named Duden flows by
							their place and supplies it with the necessary regelialia.</p>
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

	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center mb-5 pb-3">
				<div class="col-md-7 heading-section ftco-animate text-center">
					<h2 class="mb-4">Hot Meals</h2>
					<p>Far far away, behind the word mountains, far from the
						countries Vokalia and Consonantia, there live the blind texts.</p>
				</div>
			</div>
		</div>
		<div class="container-wrap">

			<%-- Show products --%>
			<c:if test="${products.size()>0 }">
				<div class="row no-gutters d-flex">
					<c:forEach var="item" items="${products }" varStatus="Loop">
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
							test="${(loop.index + 1)  % 3 == 0 || (loop.index + 1) == products.size() }">
				</div>
				<c:if test="${(loop.index + 1) < products.size() }">
					<div class="row no-gutters d-flex">
						<div class="col-lg-4 d-flex ftco-animate">
				</c:if>
			</c:if>
			</c:forEach>
			</c:if>
			<%-- End show products --%>

		</div>
	</section>

	<section class="ftco-menu">
		<div class="container-fluid">
			<div class="row d-md-flex">
				<div class="col-lg-4 ftco-animate img f-menu-img mb-5 mb-md-0"
					style="background-image: url(<c:url value="/assets/user/images/about.jpg" />);"></div>
				<div class="col-lg-8 ftco-animate p-md-5">
					<div class="row">
						<div class="col-md-12 nav-link-wrap mb-5">
							<div class="nav ftco-animate nav-pills" id="v-pills-tab"
								role="tablist" aria-orientation="vertical">

								<c:forEach var="item" items="${categories }">
									<a href="<c:url value="/categories/${item.ID_Categories}" />"
										class="nav-link">${item.name_Categories}</a>
								</c:forEach>

							</div>
						</div>
						<div class="col-md-12 d-flex align-items-center">

							<div class="tab-content ftco-animate" id="v-pills-tabContent">

								<div class="row">
									<div class="col-md-4 text-center">
										<div class="menu-wrap">
											<a href="#" class="menu-img img mb-4"
												style="background-image: url(<c:url value="/assets/user/images/pizza-1.jpg" />);"></a>
											<div class="text">
												<h3>
													<a href="#">Itallian Pizza</a>
												</h3>
												<p>Far far away, behind the word mountains, far from the
													countries Vokalia and Consonantia.</p>
											</div>
										</div>
									</div>
									<div class="col-md-4 text-center">
										<div class="menu-wrap">
											<a href="#" class="menu-img img mb-4"
												style="background-image: url(<c:url value="/assets/user/images/pizza-2.jpg" />);"></a>
											<div class="text">
												<h3>
													<a href="#">Itallian Pizza</a>
												</h3>
												<p>Far far away, behind the word mountains, far from the
													countries Vokalia and Consonantia.</p>
											</div>
										</div>
									</div>
									<div class="col-md-4 text-center">
										<div class="menu-wrap">
											<a href="#" class="menu-img img mb-4"
												style="background-image: url(<c:url value="/assets/user/images/pizza-3.jpg" />);"></a>
											<div class="text">
												<h3>
													<a href="#">Itallian Pizza</a>
												</h3>
												<p>Far far away, behind the word mountains, far from the
													countries Vokalia and Consonantia.</p>
												<p class="price">
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>

