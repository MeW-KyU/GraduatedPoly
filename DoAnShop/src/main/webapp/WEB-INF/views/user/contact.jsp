<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<title>Contact Us</title>
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
						<h1 class="mb-3 mt-5 bread">Contact Us</h1>
						<p class="breadcrumbs">
							<span class="mr-2"><a href="<c:url value="/home" />">Home</a></span>
							<span>Contact</span>
						</p>
					</div>

				</div>
			</div>
		</div>
	</section>

	<section class="ftco-section contact-section">
		<div class="container mt-5">
			<div class="row block-9">
				<div class="col-md-4 contact-info ftco-animate">
					<div class="row">
						<div class="col-md-12 mb-4">
							<h2 class="h4">Contact Information</h2>
						</div>
						<div class="col-md-12 mb-3">
							<p>
								<span>Address:</span> Innovation Building, Lot 24, Quang Trung
								Software Park, District 12, Ho Chi Minh City
							</p>
						</div>
						<div class="col-md-12 mb-3">
							<p>
								<span>Phone:</span> <a href="tel://02873088800">(028) 7308
									8800</a>
							</p>
						</div>
						<div class="col-md-12 mb-3">
							<p>
								<span>Email:</span> <a href="mailto:caodangfpt.hcm@fpt.edu.vn">caodangfpt.hcm@fpt.edu.vn</a>
							</p>
						</div>
						<div class="col-md-12 mb-3">
							<p>
								<span>Website:</span> <a href="<c:url value="/home" />">DoAn</a>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
				<div class="col-md-6 ftco-animate">
					<form action="mailto:caodangfpt.hcm@fpt.edu.vn" method="post"
						enctype="text/plain" class="contact-form">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<input type="text" class="form-control" name="name"
										placeholder="Your Name">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<input type="text" class="form-control" name="mail"
										placeholder="Your Email">
								</div>
							</div>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="subject"
								placeholder="Subject">
						</div>
						<div class="form-group">
							<textarea id="" cols="30" rows="7" class="form-control"
								type="text" name="message" placeholder="Message"></textarea>
						</div>

						<div class="form-group">
							<input type="submit" value="Send Message"
								class="btn btn-primary py-3 px-5">
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>

	<div id="map"></div>
</body>