<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<base href="${pageContext.servletContext.contextPath }/">
<%
	System.out.println("merchandise/edit-merchandiser.jsp");
%>
<title>Add merchandise - Doan Delivery Online</title>
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
		<div class="col-sm-4">
			<h4 class="page-title">Hàng hoá</h4>
			<div class="d-flex align-items-center">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="admin/statistical/">Trang
								chủ</a></li>
						<li class="breadcrumb-item" aria-current="page">Quản lí hàng
							hoá</li>
						<li class="breadcrumb-item" aria-current="page">Thêm hàng hoá</li>
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
					<form:form action="admin/merchandise/save-mer.htm" method="POST"
						modelAttribute="merchandise" class="form-horizontal form-material">
						<div class="row m-b-10">
							<div class="col-sm-12 p-0">
								<div class="form-group">
									<label class="col-md-12">Mã hàng hoá <span
										style="color: red;">*</span> <form:errors
											path="merchandise_Code" class="error" /></label>
									<div class="col-md-12">
										<form:input path="merchandise_Code"
											class="form-control form-control-line" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Tên hàng hoá <span
										style="color: red;">*</span> <form:errors
											path="name_Merchandise" class="error" /></label>
									<div class="col-md-12">
										<form:input path="name_Merchandise"
											class="form-control form-control-line" />
									</div>
								</div>
							</div>
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Đơn vị <span
										style="color: red;">*</span> <form:errors path="unit"
											class="error" /></label>
									<div class="col-md-12">
										<form:select path="unit"
											class="form-control form-control-line">
											<option selected="selected" value=0>Select</option>
											<form:option value="1">Kg</form:option>
											<form:option value="2">Gói</form:option>
											<form:option value="3">Chai</form:option>
											<form:option value="4">Hộp</form:option>
											<form:option value="5">Thùng</form:option>
										</form:select>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Đơn giá <span
										style="color: red;">*</span> <form:errors path="unit_Price"
											class="error" /></label>
									<div class="col-md-12">
										<form:input path="unit_Price"
											class="form-control form-control-line" />
									</div>
								</div>
							</div>
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

	<!-- Danh sach nhân viên -->
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-lg-4 p-2">
							<form:form id="form_search" role="search"
								action="admin/merchandise/search.htm" method="get">
								<label for="search">Search for stuff</label>
								<input id="search" name="search" type="search"
									placeholder="Search..." />
								<button type="submit" class="button_search">Search</button>
							</form:form>
						</div>
						<div class="col-lg-8 p-2">
							<div class="text-right">
								<a href="admin/merchandise/add-mer.htm"
									class="btn btn-dropbox text-white">Thêm hàng hoá</a>
							</div>
						</div>
					</div>
					<br>
					<div class="table-responsive">
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col">STT</th>
									<th scope="col">Mã hàng hoá</th>
									<th scope="col">Tên hàng hoá</th>
									<th scope="col">Đơn vị</th>
									<th scope="col">Đơn giá</th>
									<th scope="col">Số lượng</th>
									<th scope="col">Chức năng</th>
								</tr>
							</thead>
							<c:set var="count" value="0" />
							<tbody>
								<c:forEach items="${listMerchandise}" var="merchandise">
									<tr>
										<c:set var="count" value="${count+1 }" />
										<th scope="row">${count}</th>
										<td>${merchandise.merchandise_Code }</td>
										<td>${merchandise.name_Merchandise }</td>
										<td><c:choose>
												<c:when test="${merchandise.unit == 1 }">
													Kg
												</c:when>
												<c:when test="${merchandise.unit == 2}">
													Gói
												</c:when>
												<c:when test="${merchandise.unit == 3}">
													Chai
												</c:when>
												<c:when test="${merchandise.unit == 4}">
													Hộp
												</c:when>
												<c:when test="${merchandise.unit == 5}">
													Thùng
												</c:when>
											</c:choose></td>
										<td><f:formatNumber value="${merchandise.unit_Price }"
												pattern="###,###" />VNĐ</td>
										<td>${merchandise.amount }</td>
										<td><a
											href="admin/merchandise/edit-mer/${merchandise.merchandise_Code}.htm"
											type="button" rel="tooltip" title="Sửa"
											class="btn btn-info btn-simple btn-xs"> <i
												class="fa fa-edit"></i></a> <a
											href="admin/merchandise/delete-mer/${merchandise.merchandise_Code}.htm"
											onclick="return confirm('Bạn chắc chắn chứ ?')" type="button"
											rel="tooltip" title="Xóa"
											class="btn btn-danger btn-simple btn-xs"> <i
												class="fas fa-times"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="pagination">
							<div class="pagination-container">
								<div class="pagination-hover-overlay"></div>
								<c:forEach begin="1" end="${rowCount}" varStatus="row">
									<a href="admin/merchandise/add-mer.htm/?page=${row.index}"
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