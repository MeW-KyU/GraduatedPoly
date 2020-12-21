<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title><decorator:title default="Master-Layout" /></title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Josefin+Sans"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Nothing+You+Could+Do"
	rel="stylesheet">

<link rel="stylesheet"
	href="<c:url value="/assets/user/css/open-iconic-bootstrap.min.css" />">
<link rel="stylesheet"
	href="<c:url value="/assets/user/css/animate.css" />">

<link rel="stylesheet"
	href="<c:url value="/assets/user/css/owl.carousel.min.css" />">
<link rel="stylesheet"
	href="<c:url value="/assets/user/css/owl.theme.default.min.css" />">
<link rel="stylesheet"
	href="<c:url value="/assets/user/css/magnific-popup.css" />">

<link rel="stylesheet" href="<c:url value="/assets/user/css/aos.css" />">

<link rel="stylesheet"
	href="<c:url value="/assets/user/css/ionicons.min.css" />">

<link rel="stylesheet"
	href="<c:url value="/assets/user/css/bootstrap-datepicker.csss" />">
<link rel="stylesheet"
	href="<c:url value="/assets/user/css/jquery.timepicker.css" />">


<link rel="stylesheet"
	href="<c:url value="/assets/user/css/flaticon.css" />">
<link rel="stylesheet"
	href="<c:url value="/assets/user/css/icomoon.css" />">
<link rel="stylesheet"
	href="<c:url value="/assets/user/css/style.css" />">

<link rel="stylesheet"
	href="<c:url value="/assets/user/cart/cart.css" />">

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value="/assets/user/css/listcart.css" />">

<style>
.badge {
	background-color: #e62e00;
	border-radius: 10px;
	color: white;
	display: inline-block;
	font-size: 12px;
	line-height: 1;
	padding: 3px 7px;
	text-align: center;
	vertical-align: middle;
	white-space: nowrap;
}
</style>

<decorator:head />
</head>
<body>
	<%@include file="/WEB-INF/views/layouts/user/header.jsp"%>

	<decorator:body />

	<%@include file="/WEB-INF/views/layouts/user/footer.jsp"%>


	<!-- loader -->
	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div>


	<script src="<c:url value="/assets/user/js/jquery.min.js" />"></script>
	<script
		src="<c:url value="/assets/user/js/jquery-migrate-3.0.1.min.js" />"></script>
	<script src="<c:url value="/assets/user/js/popper.min.js" />"></script>
	<script src="<c:url value="/assets/user/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/assets/user/js/jquery.easing.1.3.js" />"></script>
	<script src="<c:url value="/assets/user/js/jquery.waypoints.min.js" />"></script>
	<script src="<c:url value="/assets/user/js/jquery.stellar.min.js" />"></script>
	<script src="<c:url value="/assets/user/js/owl.carousel.min.js" />"></script>
	<script
		src="<c:url value="/assets/user/js/jquery.magnific-popup.min.js" />"></script>
	<script src="<c:url value="/assets/user/js/aos.js" />"></script>
	<script
		src="<c:url value="/assets/user/js/jquery.animateNumber.min.js" />"></script>
	<script src="<c:url value="/assets/user/js/bootstrap-datepicker.js" />"></script>
	<script
		src="<c:url value="/assets/user/js/jquery.timepicker.min.js" />"></script>
	<script src="<c:url value="/assets/user/js/scrollax.min.js" />"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="<c:url value="/assets/user/js/google-map.js" />"></script>
	<script src="<c:url value="/assets/user/js/main.js" />"></script>

	<decorator:getProperty property="page.script"></decorator:getProperty>

</body>
</html>
