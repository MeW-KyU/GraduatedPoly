<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<base href="${pageContext.servletContext.contextPath }/">
<%
	System.out.println("product/edit-product.jsp");
%>
<title>Edit product - Doan Delivery Online</title>
<style>
.form-control {
	height: calc(1.5em + 0.75rem + 2px);
}

*[id$=errors] {
	color: red;
	font-style: italic;
}
</style>
<div class="page-breadcrumb">
	<div class="row align-items-center">
		<div class="col-sm-5">
			<h4 class="page-title">Sản phẩm</h4>
			<div class="d-flex align-items-center">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="admin/statistical/">Trang
								chủ</a></li>
						<li class="breadcrumb-item" aria-current="page">Quản lí sản
							phẩm</li>
						<li class="breadcrumb-item" aria-current="page">Sửa thông tin
							sản phẩm</li>
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
					<form:form
						action="admin/invoice/edit-invoice/${invoice.invoice_Code }.htm"
						method="POST" commandName="invoice"
						class="form-horizontal form-material">
						<div class="row">
							<div class="col-sm-12 p-0">
								<div class="form-group">
									<label class="col-md-12">Mã hoá đơn <span
										style="color: red;">*</span> <form:errors path="invoice_Code"
											class="error" /></label>
									<div class="col-md-12">
										<form:input path="invoice_Code"
											class="form-control form-control-line" readonly="true" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Ngày bán <span
										style="color: red;">*</span> <form:errors path="date_Sale"
											class="error" /></label>
									<div class="col-md-12">
										<form:input path="date_Sale" placeholder="dd/MM/yy"
											class="form-control form-control-line" />
									</div>
								</div>
							</div>
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Tên khách hàng <span
										style="color: red;">*</span> <form:errors path="name_Mask"
											class="error" /></label>
									<div class="col-md-12">
										<form:input path="name_Mask"
											class="form-control form-control-line" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Số điện thoại <span
										style="color: red;">*</span> <form:errors path="phone_Mask"
											class="error" /></label>
									<div class="col-md-12">
										<form:input path="phone_Mask"
											class="form-control form-control-line" />
									</div>
								</div>
							</div>
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label for="example-email" class="col-md-12">Email <span
										style="color: red;">*</span> <form:errors path="email_Mask"
											class="error" /></label>
									<div class="col-md-12">
										<form:input path="email_Mask"
											class="form-control form-control-line" name="example-email"
											id="example-email" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Số lượng <span
										style="color: red;">*</span> <form:errors path="amount"
											class="error" /></label>
									<div class="col-md-12">
										<form:input path="amount"
											class="form-control form-control-line" />
									</div>
								</div>
							</div>
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label for="example-email" class="col-md-12">Tổng hoá
										đơn <span style="color: red;">*</span> <form:errors
											path="total" class="error" />
									</label>
									<div class="col-md-12">
										<form:input path="total"
											class="form-control form-control-line" name="example-email"
											id="example-email" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Địa chỉ <form:errors
											path="address_Mask" class="error" /></label>
									<div class="col-md-12">
										<form:textarea path="address_Mask" rows="3"
											class="form-control form-control-line"></form:textarea>
									</div>
								</div>
							</div>
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Ghi chú <form:errors
											path="note" class="error" /></label>
									<div class="col-md-12">
										<form:textarea path="note" rows="3"
											class="form-control form-control-line"></form:textarea>
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
										<button class="btn btn-success">Cập nhật</button>
									</div>
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<!-- Danh sach đơn hàng -->
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-lg-4 p-2">
							<form:form id="form_search" role="search"
								action="admin/invoice/search.htm" method="get">
								<label for="search">Search for stuff</label>
								<input id="search" name="search" type="search"
									placeholder="Search..." />
								<button type="submit" class="button_search">Search</button>
							</form:form>
						</div>
						<div class="col-lg-4 p-2"></div>
						<div class="col-lg-4 p-2">
							<form:form action="admin/invoice/filter.htm" method="get">
								<div class="row">
									<div class="col-lg-9 text-right">
										<select name="filter" class="form-control form-control-line">
											<option selected="selected" value="">Filter by
												status...</option>
											<option value="1">Đã huỷ</option>
											<option value="2">Đang chờ</option>
											<option value="3">Đã xác nhận</option>
										</select>
									</div>
									<div class="col-lg-3 text-right">
										<button type="submit" class="btn btn-info" style="width: 100%">Filter</button>
									</div>
								</div>
							</form:form>
						</div>
					</div>
					<br>
					<div class="table-responsive">
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col">STT</th>
									<th scope="col">Mã HD</th>
									<th scope="col">Ngày</th>
									<th scope="col">Tên khách hàng</th>
									<th scope="col">Số điện thoại</th>
									<th scope="col">Địa chỉ</th>
									<th scope="col">Tổng hoá đơn</th>
									<th scope="col">Trạng thái</th>
									<th scope="col">Chức năng</th>
								</tr>
							</thead>
							<c:set var="count" value="0" />
							<tbody>
								<c:forEach items="${listInvoice}" var="invoice">
									<tr>
										<c:set var="count" value="${count+1 }" />
										<th scope="row">${count}</th>
										<td>${invoice.invoice_Code }</td>
										<td><f:formatDate value="${invoice.date_Sale }"
												pattern="dd/MM/yyyy" /></td>
										<td>${invoice.name_Mask }</td>
										<td>0${invoice.phone_Mask }</td>
										<td>${invoice.address_Mask }</td>
										<td><f:formatNumber value="${invoice.total }"
												pattern="###,###" />VNĐ</td>
										<td><c:choose>
												<c:when test="${invoice.status == 1 }">
													<button id="user" type="button"
														class="btn btn-danger btn-xs">Đã huỷ</button>
												</c:when>
												<c:when test="${invoice.status == 2}">
													<button id="admin" type="button"
														class="btn btn-warning btn-xs">Đang chờ</button>
												</c:when>
												<c:when test="${invoice.status == 3}">
													<button id="admin" type="button"
														class="btn btn-info btn-xs">Đã xác nhận</button>
												</c:when>
											</c:choose></td>
										<td><a
											href="admin/invoice/edit-invoice/${invoice.invoice_Code}.htm"
											type="button" rel="tooltip" title="Sửa"
											class="btn btn-info btn-simple btn-xs"> <i
												class="fa fa-edit"></i></a> <a
											href="admin/invoice/detail-invoice/${invoice.invoice_Code}.htm"
											type="button" rel="tooltip" title="Xem chi tiết"
											class="btn btn-warning btn-simple btn-xs"> <i
												class="fa fa-eye"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="pagination">
							<div class="pagination-container">
								<div class="pagination-hover-overlay"></div>
								<c:forEach begin="1" end="${rowCount}" varStatus="row">
									<a href="admin/invoice/?page=${row.index}"
										class="pagination-page-number">${row.index}</a>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>