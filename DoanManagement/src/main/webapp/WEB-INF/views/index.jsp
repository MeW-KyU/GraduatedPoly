<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<base href="${pageContext.servletContext.contextPath}/">
<style>
	.fas{
		line-height: 32px;
	}
</style>
<!-- ============================================================== -->
<!-- Bread crumb and right sidebar toggle -->
<!-- ============================================================== -->
<div class="page-breadcrumb">
	<div class="row align-items-center">
		<div class="col-sm-3">
			<h4 class="page-title">Bảng điều khiển</h4>
			<div class="d-flex align-items-center">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
						<li class="breadcrumb-item active" aria-current="page">Thống
							kê</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
</div>
<!-- ============================================================== -->
<!-- End Bread crumb and right sidebar toggle -->
<!-- ============================================================== -->
<!-- ============================================================== -->
<!-- Container fluid  -->
<!-- ============================================================== -->
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12">
			<div class="card">
				<div class="card-body dashboardStatistic">
					<div class="d-md-flex align-items-baseline">
						<h4 class="card-title">Kết quả bán hàng hôm nay</h4>
					</div>
					<div class="row">
						<div class="col-sm-3 p-0">
							<div class="uln ovh p-0">
								<ul>
									<li class="total"><label class="dash_icon"> <i
											class="fas fa-dollar-sign"></i>
									</label> <label class="dash_title">Hoá đơn</label> <span class="number"><span
											class="txt">0</span></span> <span class="yesterday">Doanh thu
											thuần</span></li>
								</ul>
							</div>
						</div>
						<div class="col-sm-3 bdl p-0">
							<div class="uln ovh p-0">
								<ul>
									<li class="total"><label class="dash_icon bg-danger">
											<i class="fas fa-users"></i>
									</label> <label class="dash_title">Khách hàng mới</label> <span
										class="number"><span class="txt">0</span></span> <span
										class="yesterday">Lượt truy cập</span></li>
								</ul>
							</div>
						</div>
						<div class="col-sm-6 bdl p-0">
							<div class="uln ovh p-0">
								<div class="row">
									<div class="col-sm-3" style="padding-right: 38%;">
										<ul>
											<li class="total"><label class="dash_icon bg-success">
													<i class="fas fa-arrow-up"></i>
											</label> <label class="dash_title"> </label> <span class="number"><span
													class="txt">9.48%</span></span> <span class="yesterday">So
													với cùng kì hôm qua</span></li>
										</ul>
									</div>
									<div class="col-sm-3">
										<ul>
											<li class="total"><label class="dash_title"> </label>
												<span class="number"><span class="txt">20%</span></span> <span
												class="yesterday">So với cùng kì tháng trước</span></li>
										</ul>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ============================================================== -->
	<!-- Sales chart -->
	<!-- ============================================================== -->
	<div class="row">
		<div class="col-md-8">
			<div class="card">
				<div class="card-body">
					<div class="d-md-flex align-items-center">
						<div>
							<h4 class="card-title">Sales Summary</h4>
							<h5 class="card-subtitle">Overview of Latest Month</h5>
						</div>
						<div class="ml-auto d-flex no-block align-items-center">
							<ul class="list-inline font-12 dl m-r-15 m-b-0">
								<li class="list-inline-item text-info"><i
									class="fa fa-circle"></i> Iphone</li>
								<li class="list-inline-item text-primary"><i
									class="fa fa-circle"></i> Ipad</li>
							</ul>
						</div>
					</div>
					<div class="row">
						<!-- column -->
						<div class="col-lg-12">
							<div class="campaign ct-charts"></div>
						</div>
						<!-- column -->
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">Feeds</h4>
					<div class="feed-widget">
						<ul class="list-style-none feed-body m-0 p-b-20">
							<li class="feed-item">
								<div class="feed-icon bg-info">
									<i class="far fa-bell"></i>
								</div> You have 4 pending tasks. <span
								class="ml-auto font-12 text-muted">Just Now</span>
							</li>
							<li class="feed-item">
								<div class="feed-icon bg-success">
									<i class="ti-server"></i>
								</div> Server #1 overloaded.<span class="ml-auto font-12 text-muted">2
									Hours ago</span>
							</li>
							<li class="feed-item">
								<div class="feed-icon bg-warning">
									<i class="ti-shopping-cart"></i>
								</div> New order received.<span class="ml-auto font-12 text-muted">31
									May</span>
							</li>
							<li class="feed-item">
								<div class="feed-icon bg-danger">
									<i class="ti-user"></i>
								</div> New user registered.<span class="ml-auto font-12 text-muted">30
									May</span>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ============================================================== -->
	<!-- Sales chart -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- Table -->
	<!-- ============================================================== -->
	<div class="row">
		<!-- column -->
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					<!-- title -->
					<div class="d-md-flex align-items-center">
						<div>
							<h4 class="card-title">Top Selling Products</h4>
							<h5 class="card-subtitle">Overview of Top Selling Items</h5>
						</div>
						<div class="ml-auto">
							<div class="dl">
								<select class="custom-select">
									<option value="0" selected>Monthly</option>
									<option value="1">Daily</option>
									<option value="2">Weekly</option>
									<option value="3">Yearly</option>
								</select>
							</div>
						</div>
					</div>
					<!-- title -->
				</div>
				<div class="table-responsive">
					<table class="table v-middle">
						<thead>
							<tr class="bg-light">
								<th class="border-top-0">Products</th>
								<th class="border-top-0">License</th>
								<th class="border-top-0">Support Agent</th>
								<th class="border-top-0">Technology</th>
								<th class="border-top-0">Tickets</th>
								<th class="border-top-0">Sales</th>
								<th class="border-top-0">Earnings</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<div class="d-flex align-items-center">
										<div class="m-r-10">
											<a class="btn btn-circle d-flex btn-info text-white">EA</a>
										</div>
										<div class="">
											<h4 class="m-b-0 font-16">Elite Admin</h4>
										</div>
									</div>
								</td>
								<td>Single Use</td>
								<td>John Doe</td>
								<td><label class="label label-danger">Angular</label></td>
								<td>46</td>
								<td>356</td>
								<td>
									<h5 class="m-b-0">$2850.06</h5>
								</td>
							</tr>
							<tr>
								<td>
									<div class="d-flex align-items-center">
										<div class="m-r-10">
											<a class="btn btn-circle d-flex btn-orange text-white">MA</a>
										</div>
										<div class="">
											<h4 class="m-b-0 font-16">Monster Admin</h4>
										</div>
									</div>
								</td>
								<td>Single Use</td>
								<td>Venessa Fern</td>
								<td><label class="label label-info">Vue Js</label></td>
								<td>46</td>
								<td>356</td>
								<td>
									<h5 class="m-b-0">$2850.06</h5>
								</td>
							</tr>
							<tr>
								<td>
									<div class="d-flex align-items-center">
										<div class="m-r-10">
											<a class="btn btn-circle d-flex btn-success text-white">MP</a>
										</div>
										<div class="">
											<h4 class="m-b-0 font-16">Material Pro Admin</h4>
										</div>
									</div>
								</td>
								<td>Single Use</td>
								<td>John Doe</td>
								<td><label class="label label-success">Bootstrap</label></td>
								<td>46</td>
								<td>356</td>
								<td>
									<h5 class="m-b-0">$2850.06</h5>
								</td>
							</tr>
							<tr>
								<td>
									<div class="d-flex align-items-center">
										<div class="m-r-10">
											<a class="btn btn-circle d-flex btn-purple text-white">AA</a>
										</div>
										<div class="">
											<h4 class="m-b-0 font-16">Ample Admin</h4>
										</div>
									</div>
								</td>
								<td>Single Use</td>
								<td>John Doe</td>
								<td><label class="label label-purple">React</label></td>
								<td>46</td>
								<td>356</td>
								<td>
									<h5 class="m-b-0">$2850.06</h5>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- ============================================================== -->
	<!-- End Container fluid  -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
</div>