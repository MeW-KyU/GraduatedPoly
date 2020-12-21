<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<base href="${pageContext.servletContext.contextPath }/">
<%
	System.out.println("customer/add-customer.jsp");
%>
<title>Add customer - Doan Delivery Online</title>
<style>
.form-control {
	height: calc(1.5em + 0.75rem + 2px);
}

*[id$=errors] {
	color: red;
	font-style: italic;
}
</style>
<!-- ============================================================== -->
<!-- Bread crumb and right sidebar toggle -->
<!-- ============================================================== -->
<div class="page-breadcrumb">
	<div class="row align-items-center">
		<div class="col-sm-4">
			<h4 class="page-title">Khách hàng</h4>
			<div class="d-flex align-items-center">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="admin/statistical/">Trang
								chủ</a></li>
						<li class="breadcrumb-item" aria-current="page">Quản lí khách
							hàng</li>
						<li class="breadcrumb-item" aria-current="page">Thêm khách
							hàng</li>
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
	<!-- ============================================================== -->
	<!-- Start Page Content -->
	<!-- ============================================================== -->

	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					<form:form action="admin/customer/save-cus.htm" method="POST"
						modelAttribute="customer" class="form-horizontal form-material">
						<div class="row">
							<div class="col-sm-12 p-0">
								<div class="form-group">
									<label class="col-md-12">Mã khách hàng <span
										style="color: red;">*</span> <form:errors path="customer_Code"
											class="error" /></label>
									<div class="col-md-12">
										<form:input path="customer_Code"
											class="form-control form-control-line" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Mật khẩu <span
										style="color: red;">*</span> <form:errors path="password"
											class="error" /></label>
									<div class="col-md-12">
										<form:input path="password"
											class="form-control form-control-line" />
									</div>
								</div>
							</div>
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Tên khách hàng <span
										style="color: red;">*</span> <form:errors path="name_Customer"
											class="error" /></label>
									<div class="col-md-12">
										<form:input path="name_Customer"
											class="form-control form-control-line" />
									</div>
								</div>
							</div>

						</div>
						<div class="row">
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Số điện thoại <span
										style="color: red;">*</span> <form:errors
											path="phone_Customer" class="error" /></label>
									<div class="col-md-12">
										<form:input path="phone_Customer"
											class="form-control form-control-line" />
									</div>
								</div>
							</div>
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label for="example-email" class="col-md-12">Email <span
										style="color: red;">*</span> <form:errors
											path="email_Customer" class="error" /></label>
									<div class="col-md-12">
										<form:input path="email_Customer"
											class="form-control form-control-line" name="example-email"
											id="example-email" />
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-sm-12 p-0">
								<div class="form-group">
									<label class="col-md-12">Địa chỉ <span
										style="color: red;">*</span> <form:errors
											path="address_Customer" class="error" /></label>
									<div class="col-md-12">
										<form:textarea path="address_Customer" rows="5"
											class="form-control form-control-line" />
									</div>
								</div>
							</div>
						</div>
						<input id="nameu" name="nameu" type="hidden"
							value="${sessionScope.account.username}" />
						<div class="row">
							<div class="col-sm-12 p-0">
								<div class="form-group">
									<div class="col-lg-3 text-right float-right">
										<p>${message }</p>
										<button class="btn btn-success">Thêm</button>
									</div>
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<!-- Danh sach khách hàng -->
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-lg-4 p-2">
							<form:form id="form_search" role="search"
								action="admin/customer/search.htm" method="get">
								<label for="search">Search for stuff</label>
								<input id="search" name="search" type="search"
									placeholder="Search..." />
								<button type="submit" class="button_search">Search</button>
							</form:form>
						</div>
						<div class="col-lg-8 p-2">
							<div class="text-right">
								<a href="admin/customer/add-cus.htm"
									class="btn btn-dropbox text-white">Thêm khách hàng</a>
							</div>
						</div>
					</div>
					<br>
					<div class="table-responsive">
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col">STT</th>
									<th scope="col">Mã khách hàng</th>
									<th scope="col">Tên khách hàng</th>
									<th scope="col">Số điện thoại</th>
									<th scope="col">Email</th>
									<th scope="col">Địa chỉ</th>
									<th scope="col">Chức năng</th>
								</tr>
							</thead>
							<c:set var="count" value="0" />
							<tbody>
								<c:forEach items="${listCustomer}" var="customer">
									<tr>
										<c:set var="count" value="${count+1 }" />
										<th scope="row">${count}</th>
										<td>${customer.customer_Code }</td>
										<td>${customer.name_Customer }</td>
										<td>${customer.phone_Customer }</td>
										<td>${customer.email_Customer }</td>
										<td>${customer.address_Customer }</td>
										<td><a
											href="admin/customer/edit-cus/${customer.customer_Code}.htm"
											type="button" rel="tooltip" title="Sửa"
											class="btn btn-info btn-simple btn-xs"> <i
												class="fa fa-edit"></i></a> <a
											href="admin/customer/delete-cus/${customer.customer_Code}.htm"
											onclick="return confirm('Bạn chắc chắn chứ ?')" type="button"
											rel="tooltip" title="Xóa"
											class="btn btn-danger btn-simple btn-xs"> <i
												class="fas fa-times"></i></a> <a
											href="admin/customer/reset-cus/${customer.customer_Code}.htm"
											onclick="return confirm('Bạn chắc chắn chứ? password sẽ được thay đổi thành 123')"
											type="button" rel="tooltip" title="Reset"
											class="btn btn-danger btn-simple btn-xs"> <i
												class="fas fa-sync-alt"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="pagination">
							<div class="pagination-container">
								<div class="pagination-hover-overlay"></div>
								<c:forEach begin="1" end="${rowCount}" varStatus="row">
									<a href="admin/customer/add-cus.htm/?page=${row.index}"
										class="pagination-page-number">${row.index}</a>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ============================================================== -->
	<!-- End PAge Content -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- Right sidebar -->
	<!-- ============================================================== -->
	<!-- .right-sidebar -->
	<!-- ============================================================== -->
	<!-- End Right sidebar -->
	<!-- ============================================================== -->
</div>