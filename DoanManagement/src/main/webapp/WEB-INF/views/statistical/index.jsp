<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<base href="${pageContext.servletContext.contextPath }/">
<%
	System.out.println("statistical/index.jsp");
%>
<title>Statistical - Doan Delivery Online</title>
<!-- ============================================================== -->
<!-- Bread crumb and right sidebar toggle -->
<!-- ============================================================== -->

<div class="page-breadcrumb">
	<div class="row align-items-center">
		<div class="col-sm-3">
			<h4 class="page-title">Thống kê</h4>
			<div class="d-flex align-items-center">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="home">Trang chủ</a></li>
						<li class="breadcrumb-item" aria-current="page">Thống kê</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
</div>

<style>
.canvasjs-chart-credit {
	visibility: hidden;
}
</style>

<script type="text/javascript">
	window.onload = function() {

		var dpsHD = [ [] ];
		var chartHD = new CanvasJS.Chart("chartContainerHD", {
			theme : "light2", // "light1", "dark1", "dark2"
			animationEnabled : true,
			title : {
				text : "Doanh thu các tháng trong năm"
			},
			subtitles : [ {
				text : "${department}"
			} ],
			axisX : {
				valueFormatString : "Tháng ####"
			},
			axisY : {
				title : "Doanh số"
			},
			data : [ {
				type : "line",
				xValueFormatString : "Tháng ####",
				yValueFormatString : "#,##0.0 VND",
				dataPoints : dpsHD[0]
			} ]
		});
		var xValueHD;
		var yValueHD;
		<c:forEach items="${dataPointsListHD}" var="dataPointsHD" varStatus="loop">
		<c:forEach items="${dataPointsHD}" var="dataPointHD">
		xValueHD = parseInt("${dataPointHD.x}");
		yValueHD = parseFloat("${dataPointHD.y}");
		dpsHD[parseInt("${loop.index}")].push({
			x : xValueHD,
			y : yValueHD
		});
		</c:forEach>
		</c:forEach>
		chartHD.render();

	}
</script>




<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12">
			<div class="card">
				<div class="card-body dashboardStatistic">
					<div class="d-md-flex align-items-baseline">
						<h4 class="card-title">Thống kê hiện tại:</h4>
					</div>
					<div class="row">
						<div class="col-sm-4 p-0">
							<div class="uln ovh p-0">
								<ul>
									<li class="total"><label class="dash_icon"> <i
											class="mdi mdi-account"></i>
									</label> <label class="dash_title">Tài khoản</label> <span
										class="number"> <span class="txt"> Số Account:
												${countAccount} </span>
									</span> <span class="yesterday"> <a href="admin/account/">Xem
												chi tiết </a>
									</span></li>
								</ul>
							</div>
						</div>
						<div class="col-sm-4 bdl p-0">
							<div class="uln ovh p-0">
								<ul>
									<li class="total"><label class="dash_icon"> <i
											class="mdi mdi-account-multiple"></i>
									</label> <label class="dash_title">Khách hàng</label> <span
										class="number"> <span class="txt">Số Customer:
												${countCustomer}</span>
									</span> <span class="yesterday"><a href="admin/customer/">Xem
												chi tiết </a></span></li>
								</ul>
							</div>
						</div>
						<div class="col-sm-4 bdl p-0">
							<div class="uln ovh p-0">
								<ul>
									<li class="total"><label class="dash_icon"> <i
											class="mdi mdi-face"></i>
									</label> <label class="dash_title">Nhân Viên</label> <span
										class="number"> <span class="txt">Số Staff:
												${countStaff}</span>
									</span> <span class="yesterday"><a href="admin/staff/">Xem
												chi tiết </a></span></li>
								</ul>
							</div>
						</div>
						<div class="col-sm-4 p-0">
							<div class="uln ovh p-0">
								<ul>
									<li class="total"><label class="dash_icon"> <i
											class="mdi mdi-pizza"></i>
									</label> <label class="dash_title">Sản Phẩm</label> <span
										class="number"> <span class="txt">Số Product:
												${countProduct}</span>
									</span> <span class="yesterday"><a href="admin/product/">Xem
												chi tiết </a></span></li>
								</ul>
							</div>
						</div>
						<div class="col-sm-4 bdl p-0">
							<div class="uln ovh p-0">
								<ul>
									<li class="total"><label class="dash_icon"> <i
											class="mdi mdi-cube"></i>
									</label> <label class="dash_title">Hàng Hóa</label> <span
										class="number"> <span class="txt">Số
												Merchandise: ${countMerchandise}</span>
									</span> <span class="yesterday"><a href="admin/merchandise/">Xem
												chi tiết </a></span></li>
								</ul>
							</div>
						</div>
						<div class="col-sm-4 bdl p-0">
							<div class="uln ovh p-0">
								<ul>
									<li class="total"><label class="dash_icon"> <i
											class="mdi mdi-cash-usd"></i>
									</label> <label class="dash_title">Hoá đơn</label> <span class="number">
											<span class="txt">Số Invoice: ${countInvoice}</span>
									</span> <span class="yesterday"><a href="admin/invoice/">Xem
												chi tiết </a></span></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Top sản phẩm bán chạy -->
	<div class="row">
		<div class="col-sm-12">
			<div class="card">
				<div class="card-body dashboardStatistic">
					<div class="table-responsive">
						<h1 style="text-align: center;">Sản phẩm bán chạy</h1>
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col"
										style="text-align: center; vertical-align: middle;">Hình</th>
									<th scope="col"
										style="text-align: center; vertical-align: middle;">Mã
										sản phẩm</th>
									<th scope="col"
										style="text-align: center; vertical-align: middle;">Tên
										sản phẩm</th>
									<th scope="col"
										style="text-align: center; vertical-align: middle;">Đơn
										vị</th>
									<th scope="col"
										style="text-align: center; vertical-align: middle;">Giá</th>
									<th scope="col"
										style="text-align: center; vertical-align: middle;">Mô tả</th>
									<th scope="col"
										style="text-align: center; vertical-align: middle;">Loại</th>
									<th scope="col"
										style="text-align: center; vertical-align: middle;">Kích
										thước</th>
									<th scope="col"
										style="text-align: center; vertical-align: middle;">Số
										lượng</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="count" value="-1" />
								<c:forEach items="${listProduct}" var="product">
									<tr>
										<td style="text-align: center; vertical-align: middle;"><img
											src='<c:url value="data:image/jpg;base64,${product.base64Image }"></c:url>'
											height="10%"></td>
										<td style="text-align: center; vertical-align: middle;">${product.product_Code }</td>
										<td style="text-align: center; vertical-align: middle;">${product.name_Product }</td>
										<td style="text-align: center; vertical-align: middle;"><c:choose>
												<c:when test="${product.unit == 1 }">
													Cái
												</c:when>
												<c:when test="${product.unit == 2}">
													Ly
												</c:when>
												<c:when test="${product.unit == 3}">
													Phần
												</c:when>
											</c:choose></td>
										<td style="text-align: center; vertical-align: middle;">${product.price }</td>
										<td style="text-align: center; vertical-align: middle;">${product.description }</td>
										<td style="text-align: center; vertical-align: middle;">${product.categories.name_Categories }</td>
										<td style="text-align: center; vertical-align: middle;">${product.size }</td>
										<c:set var="count" value="${count+1}" />
										<c:forEach items="${idTop}" var="top" begin="${count}"
											end="${count}">
											<td style="text-align: center; vertical-align: middle;">
												${top.amount}</td>
										</c:forEach>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Chart -->
	<div class="row">
		<div class="col-sm-12">
			<div class="card">
				<div class="card-body dashboardStatistic">
					<div class="row">
						<div class="col-lg-4"></div>
						<div class="col-lg-4 p-2"></div>
						<div class="col-lg-4 p-2">
							<form action="admin/statistical/" method="post">
								<div class="row">
									<div class="col-lg-3"></div>
									<div class="col-lg-6 text-right">
										<select name="department" id="department"
											class="form-control form-control-line">
											<option selected="selected" value="">Select year...</option>
											<c:forEach var="item" items="${listOfYears}">
												<option value="${item.yead}">${item.yead}</option>
											</c:forEach>
										</select>
									</div>
									<div class="col-lg-3 p-0">
										<button type="submit" class="btn btn-info">Submit</button>
									</div>
								</div>
							</form>
						</div>
					</div>

					<div id="chartContainerHD" style="height: 450px; width: 100%;"></div>
				</div>
			</div>
		</div>
	</div>

	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

</div>