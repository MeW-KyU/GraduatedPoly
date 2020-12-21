<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<base href="${pageContext.servletContext.contextPath }/">
<%
	System.out.println("importt/edit-import.jsp");
%>
<title>Edit import - Doan Delivery Online</title>
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
			<h4 class="page-title">Nhập kho</h4>
			<div class="d-flex align-items-center">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="admin/statistical/">Trang
								chủ</a></li>
						<li class="breadcrumb-item" aria-current="page">Quản lí thông
							tin nhập kho</li>
						<li class="breadcrumb-item" aria-current="page">Sửa thông tin</li>
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
						action="admin/import/edit-imp/${importt.import_Code }.htm"
						method="POST" commandName="import"
						class="form-horizontal form-material">
						<form:input path="import_Code" type="hidden"
							class="form-control form-control-line" />
						<div class="row">
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Ngày nhập kho <span
										style="color: red;">*</span> <form:errors path="date_Import"
											class="error" /></label>
									<div class="col-md-12">
										<form:input path="date_Import" placeholder="dd/MM/yy"
											class="form-control form-control-line" />
									</div>
								</div>
							</div>
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Tên hàng hoá</label>
									<div class="col-md-12">
										<form:select path="merchandise.merchandise_Code"
											items="${merchandise }" itemValue="merchandise_Code"
											itemLabel="name_Merchandise"
											class="form-control form-control-line" />
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
									<label class="col-md-12">Đơn giá <span
										style="color: red;">*</span> <form:errors path="unit_Price"
											class="error" /></label>
									<div class="col-md-12">
										<form:input path="unit_Price"
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

	<!-- Danh sách thông tin nhập kho -->
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-lg-4 p-2">
							<form:form id="form_search" role="search"
								action="admin/import/search.htm" method="get">
								<label for="search">Search for stuff</label>
								<input id="search" name="search" type="search"
									placeholder="Search..." />
								<button type="submit" class="button_search">Search</button>
							</form:form>
						</div>
						<div class="col-lg-8 p-2">
							<div class="text-right">
								<a href="admin/import/add-imp.htm"
									class="btn btn-dropbox text-white">Thêm</a>
							</div>
						</div>
					</div>
					<br>
					<div class="table-responsive">
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col">STT</th>
									<th scope="col">ID</th>
									<th scope="col">Ngày xuất kho</th>
									<th scope="col">Tên hàng hoá</th>
									<th scope="col">Số lượng</th>
									<th scope="col">Đơn giá</th>
									<th scope="col">Tổng tiền</th>
									<th scope="col">Chức năng</th>
								</tr>
							</thead>
							<c:set var="count" value="0" />
							<tbody>
								<c:forEach items="${listImport}" var="importt">
									<tr>
										<c:set var="count" value="${count+1 }" />
										<th scope="row">${count}</th>
										<td>${importt.import_Code }</td>
										<td><f:formatDate value="${importt.date_Import }"
												pattern="dd/MM/yyyy" /></td>
										<td>${importt.merchandise.name_Merchandise }</td>
										<td>${importt.amount }</td>
										<td><f:formatNumber value="${importt.unit_Price }"
												pattern="###,###" />VNĐ</td>
										<td><f:formatNumber value="${importt.total }"
												pattern="###,###" />VNĐ</td>
										<td><a
											href="admin/import/edit-imp/${importt.import_Code}.htm"
											type="button" rel="tooltip" title="Sửa"
											class="btn btn-info btn-simple btn-xs"> <i
												class="fa fa-edit"></i></a> <a
											href="admin/import/delete-imp/${importt.import_Code}.htm"
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
									<a href="admin/import/?page=${row.index}"
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