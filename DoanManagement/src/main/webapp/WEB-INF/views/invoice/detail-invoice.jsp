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

.form-control:disabled, .form-control[readonly] {
	background-color: #fff;
	opacity: 1;
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
											class="form-control form-control-line" readonly="true" />
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
											class="form-control form-control-line" readonly="true" />
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
											class="form-control form-control-line" readonly="true" />
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
											id="example-email" readonly="true" />
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
											class="form-control form-control-line" readonly="true" />
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
											id="example-email" readonly="true" />
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
											class="form-control form-control-line" readonly="true"></form:textarea>
									</div>
								</div>
							</div>
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Ghi chú <form:errors
											path="note" class="error" /></label>
									<div class="col-md-12">
										<form:textarea path="note" rows="3"
											class="form-control form-control-line" readonly="true"></form:textarea>
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
					<div class="table-responsive">
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col">STT</th>
									<th scope="col">Tên sản phẩm</th>
									<th scope="col">Hình ảnh</th>
									<th scope="col">Số lượng</th>
									<th scope="col">Tổng tiền</th>
								</tr>
							</thead>
							<c:set var="count" value="0" />
							<tbody>
								<c:forEach items="${detail}" var="detail">
									<tr>
										<c:set var="count" value="${count+1 }" />
										<th scope="row">${count}</th>
										<td>${detail.product.name_Product }</td>
										<td><img
											src='<c:url value="data:image/jpg;base64,${detail.product.base64Image }"></c:url>'
											height="10%"></td>
										<td>${detail.amount }</td>
										<td><f:formatNumber value="${detail.total }"
												pattern="###,###" /> VNĐ</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>