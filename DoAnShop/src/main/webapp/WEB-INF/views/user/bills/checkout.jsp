<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>
<title>Checkout</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/user/account/fonts/font-awesome-4.7.0/css/font-awesome.min.css" />">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/user/account/fonts/iconic/css/material-design-iconic-font.min.css" />">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/user/account/vendor/animate/animate.css" />">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/user/account/vendor/css-hamburgers/hamburgers.min.css" />">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/user/account/vendor/animsition/css/animsition.min.css" />">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/user/account/vendor/select2/select2.min.css" />">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/user/account/vendor/daterangepicker/daterangepicker.css" />">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/user/account/css/utillogin.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/user/account/css/main_login.css" />">
<!--===============================================================================================-->
</head>
<body>

	<div class="container-login100"
		style="background-image: url('<c:url value="/assets/user/account/images/bg-01.jpg" />');">

		<div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30">
			<a href="#"><img
				src="<c:url value="/assets/user/account/images/back.png" />"
				style="height: 25px; width: 25px;"></a>

			<form:form action="checkout" method="POST" modelAttribute="bills"
				class="login100-form validate-form">

				<span class="login100-form-title p-b-37">Payment orders</span>
				<form:input type="hidden" path="username" />
				<span>Fullname:</span>
				<div class="wrap-input100 validate-input m-b-25"
					data-validate="Fullname">
					<form:input type="text" path="name" class="input100"
						placeholder="Enter fullname" />
					<span class="focus-input100"></span>
				</div>
				<span>Phone:</span>
				<div class="wrap-input100 validate-input m-b-25"
					data-validate="Phone">
					<form:input type="text" path="phone" class="input100"
						placeholder="Enter phone" />
					<span class="focus-input100"></span>
				</div>
				<span>Email:</span>
				<div class="wrap-input100 validate-input m-b-25"
					data-validate="Email">
					<form:input type="text" path="email" class="input100"
						placeholder="Enter email" />
					<span class="focus-input100"></span>
				</div>
				<span>Address:</span>
				<div class="wrap-input100 validate-input m-b-25"
					data-validate="Address">
					<form:input type="text" path="address" class="input100"
						placeholder="Enter address" />
					<span class="focus-input100"></span>
				</div>
				<span>Note:</span>
				<div class="wrap-input100">
					<form:input type="text" path="note" class="input100"
						placeholder="Add notes (if any)" />
					<span class="focus-input100"></span>
				</div>

				<div class="container-login100-form-btn">
					<button type="submit" class="login100-form-btn">Order</button>
				</div>
			</form:form>
		</div>
	</div>


	<div id="dropDownSelect1"></div>

	<!--===============================================================================================-->
	<script
		src="<c:url value="/assets/user/account/vendor/jquery/jquery-3.2.1.min.js" />"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/assets/user/account/vendor/animsition/js/animsition.min.js" />"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/assets/user/account/vendor/bootstrap/js/popper.js" />"></script>
	<script
		src="<c:url value="/assets/user/account/vendor/bootstrap/js/bootstrap.min.js" />"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/assets/user/account/vendor/select2/select2.min.js" />"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/assets/user/account/vendor/daterangepicker/moment.min.js" />"></script>
	<script
		src="<c:url value="/assets/user/account/vendor/daterangepicker/daterangepicker.js" />"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/assets/user/account/vendor/countdowntime/countdowntime.js" />"></script>
	<!--===============================================================================================-->
	<script src="<c:url value="/assets/user/account/js/main_login.js" />"></script>

</body>