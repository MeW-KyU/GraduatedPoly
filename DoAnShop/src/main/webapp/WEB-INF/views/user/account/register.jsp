<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>
<title>Register account</title>
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
			<button onclick="goBack()">
				<img src="<c:url value="/assets/user/account/images/back.png" />"
					style="height: 25px; width: 25px;">
			</button>


			<form:form action="sign-up" method="POST" modelAttribute="customer"
				class="login100-form validate-form">
				<span class="login100-form-title p-b-37">Registration </span>

				<div class="wrap-input100 validate-input m-b-20"
					data-validate="Username">
					<form:input type="text" path="username" class="input100"
						placeholder="Enter username" />
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input m-b-25"
					data-validate="Password">
					<form:input type="password" path="password" class="input100"
						placeholder="Enter password" />
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input m-b-25"
					data-validate="FullName">
					<form:input type="text" path="name" class="input100"
						placeholder="Enter name" />
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input m-b-25"
					data-validate="Phone">
					<form:input type="text" path="phone" class="input100"
						placeholder="Enter phone" />
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input m-b-25"
					data-validate="Email">
					<form:input type="email" path="email" class="input100"
						placeholder="Enter email" />
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input m-b-25"
					data-validate="Address">
					<form:input type="text" path="address" class="input100"
						placeholder="Enter address" />
					<span class="focus-input100"></span>
				</div>


				<div class="container-login100-form-btn">
					<button type="submit" class="login100-form-btn">Sign In</button>
				</div>

				<div class="text-center p-t-57 p-b-20">
					<span class="txt1"> Or if you already have an account </span>
				</div>

				<div class="flex-c p-b-112">
					<a href="<c:url value="/login" />" class="txt2 hov1"> Sign In </a>
				</div>

				<center>
					<h3 style="color: red">${statusSU }</h3>
				</center>

			</form:form>
		</div>
	</div>


	<content tag="script"> <script>
		function goBack() {
			window.history.back();
		}
	</script> </content>
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
