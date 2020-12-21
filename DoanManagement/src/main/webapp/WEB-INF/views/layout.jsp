<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html dir="ltr" lang="en">
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Quản lí Doan</title>
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="resource/dist/css/images/favicon.png">
<!-- Custom CSS -->
<link href="resource/assets/libs/chartist/dist/chartist.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="resource/assets/libs/bootstrap/dist/css/bootstrap.min.css">
<!-- Custom CSS -->
<link href="resource/dist/css/style.min.css" rel="stylesheet">
<link href="resource/dist/css/custom.css" rel="stylesheet">
</head>

<body>
	<div class="preloader">
		<div class="lds-ripple">
			<div class="lds-pos"></div>
			<div class="lds-pos"></div>
		</div>
	</div>
	<div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5"
		data-sidebartype="full" data-sidebar-position="absolute"
		data-header-position="absolute" data-boxed-layout="full">
		<!-- ============================================================== -->
		<!-- Topbar header - style you can find in pages.scss -->
		<!-- ============================================================== -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- ============================================================== -->
		<!-- End Topbar header -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<jsp:include page="menu.jsp"></jsp:include>
		<!-- ============================================================== -->
		<!-- End Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Page wrapper  -->
		<!-- ============================================================== -->
		<div class="page-wrapper">
			<jsp:include page="${param.view}"></jsp:include>
		</div>
		<!-- ============================================================== -->
		<!-- End Wrapper -->
		<!-- ============================================================== -->
		<!-- footer -->
		<!-- ============================================================== -->
		<jsp:include page="footer.jsp"></jsp:include>
		<!-- ============================================================== -->
		<!-- End footer -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- All Jquery -->
		<!-- ============================================================== -->
		<script src="resource/assets/libs/jquery/dist/jquery.min.js"></script>
		<!-- Bootstrap tether Core JavaScript -->
		<script src="resource/assets/libs/popper.js/dist/umd/popper.min.js"></script>
		<script src="resource/assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
		<script
			src="resource/assets/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
		<script src="resource/dist/js/app-style-switcher.js"></script>
		<!--Wave Effects -->
		<script src="resource/dist/js/waves.js"></script>
		<!--Menu sidebar -->
		<script src="resource/dist/js/sidebarmenu.js"></script>
		<!--Custom JavaScript -->
		<script src="resource/dist/js/custom.js"></script>
		<!--This page JavaScript -->
		<!--chartis chart-->
		<%-- <script src="resource/assets/libs/chartist/dist/chartist.min.js"></script>
		<script
			src="resource/assets/libs/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.min.js"></script>
		<script src="resource/dist/js/pages/dashboards/dashboard1.js"></script> --%>

		<script>
			$('#myModal').modal({
				show : true
			})
		</script>
</body>
</html>