<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<title>Tracking Order</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/user/tracking/vendor/animate/animate.csso" />">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/user/tracking/vendor/select2/select2.min.css" />">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/user/tracking/vendor/perfect-scrollbar/perfect-scrollbar.css" />">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/user/tracking/css/util.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/user/tracking/css/main.css" />">
<!--===============================================================================================-->
</head>
<body>

	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">
					<center>
						<h1>Your order status</h1>
					</center>
					<table>
						<thead>
							<tr class="table100-head">
								<th class="column1">Date</th>
								<th class="column2">Order ID</th>
								<th class="column3">Name</th>
								<th class="column4">Quantity</th>
								<th class="column5">Total</th>
								<th class="column6">Status</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="item" items="${track }" varStatus="index">
								<c:if test="${ LoginInfo.username == item.customer_Code }">
									<tr>
										<td class="column1">${item.date_Sale}</td>
										<td class="column2">${item.invoice_Code}</td>
										<td class="column3">${item.name_Product}</td>
										<td class="column4">${item.amount}</td>
										<td class="column5">${item.total}</td>
										<c:choose>
											<c:when test="${item.status=='1'}">
												<td class="column6" style="color: orange">Handing</td>
											</c:when>
											<c:when test="${item.status=='2'}">
												<td class="column6" style="color: green">Delivered</td>
											</c:when>
											<c:otherwise>
												<td class="column6" style="color: red">Canceled</td>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:if>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<!--===============================================================================================-->
	<script
		src="<c:url value="/assets/user/tracking/vendor/jquery/jquery-3.2.1.min.js" />"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/assets/user/tracking/vendor/bootstrap/js/popper.js" />"></script>
	<script
		src="<c:url value="/assets/user/tracking/vendor/bootstrap/js/bootstrap.min.js" />"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/assets/user/tracking/vendor/select2/select2.min.js" />"></script>
	<!--===============================================================================================-->
	<script src="<c:url value="/assets/user/tracking/js/main.js" />"></script>
</body>