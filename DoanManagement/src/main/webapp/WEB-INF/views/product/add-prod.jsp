<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<base href="${pageContext.servletContext.contextPath }/">
<%
	System.out.println("product/add-product.jsp");
%>
<title>Add product - Doan Delivery Online</title>
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
			<h4 class="page-title">Sản phẩm</h4>
			<div class="d-flex align-items-center">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="admin/statistical/">Trang
								chủ</a></li>
						<li class="breadcrumb-item" aria-current="page">Quản lí sản
							phẩm</li>
						<li class="breadcrumb-item" aria-current="page">Thêm sản phẩm</li>
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
					<form:form action="admin/product/save-prod.htm" method="POST"
						enctype="multipart/form-data" modelAttribute="product"
						class="form-horizontal form-material">
						<div class="row m-b-10">
							<div class="col-sm-3 p-0 upload form-group">
								<label class="your-face col-md-12"> <form:input
										path="image" id="image-input" type="file" name="image" />
									<div class="image-persuader">
										<span class="mdi mdi-plus-circle"
											style="font-size: 250%; color: #2AABF7;"></span>
									</div> <img id="imager" src="#" width="200" />
								</label>
							</div>
							<div class="col-sm-9 p-0">
								<div class="form-group">
									<label class="col-md-12">Mã sản phẩm <span
										style="color: red;">*</span> <form:errors path="product_Code"
											class="error" /></label>
									<div class="col-md-12">
										<form:input path="product_Code"
											class="form-control form-control-line" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">Tên sản phẩm <span
										style="color: red;">*</span> <form:errors path="name_Product"
											class="error" /></label>
									<div class="col-md-12">
										<form:input path="name_Product"
											class="form-control form-control-line" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">Đơn vị <span
										style="color: red;">*</span> <form:errors path="unit"
											class="error" /></label>
									<div class="col-md-12">
										<form:select path="unit"
											class="form-control form-control-line">
											<option selected="selected" value=0>Select</option>
											<form:option value="1">Cái</form:option>
											<form:option value="2">Ly</form:option>
											<form:option value="3">Phần</form:option>
											<form:option value="4">Khác</form:option>
										</form:select>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Giá <span style="color: red;">*</span>
										<form:errors path="price" class="error" /></label>
									<div class="col-md-12">
										<form:input path="price"
											class="form-control form-control-line" />
									</div>
								</div>
							</div>
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Loại sản phẩm</label>
									<div class="col-md-12">
										<form:select path="categories.categories_Code"
											items="${categories }" itemValue="categories_Code"
											itemLabel="name_Categories"
											class="form-control form-control-line" />
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-sm-12 p-0">
								<div class="form-group">
									<label class="col-md-12">Mô tả <form:errors
											path="description" class="error" /></label>
									<div class="col-md-12">
										<form:textarea path="description" rows="5"
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

	<!-- Danh sách sản phẩm -->
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-lg-4 p-2">
							<form:form id="form_search" role="search"
								action="admin/product/search.htm" method="get">
								<label for="search">Search for stuff</label>
								<input id="search" name="search" type="search"
									placeholder="Search..." />
								<button type="submit" class="button_search">Search</button>
							</form:form>
						</div>
						<div class="col-lg-8 p-2">
							<div class="text-right">
								<a href="admin/product/add-prod.htm"
									class="btn btn-dropbox text-white">Thêm sản phẩm</a>
							</div>
						</div>
					</div>
					<br>
					<div class="table-responsive">
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col">STT</th>
									<th scope="col"></th>
									<th scope="col">Mã sản phẩm</th>
									<th scope="col">Tên sản phẩm</th>
									<th scope="col">Đơn vị</th>
									<th scope="col">Giá</th>
									<th scope="col">Mô tả</th>
									<th scope="col">Loại</th>
									<th scope="col">Kích thước</th>
									<th scope="col">Chức năng</th>
								</tr>
							</thead>
							<c:set var="count" value="0" />
							<tbody>
								<c:forEach items="${listProduct}" var="product">
									<tr>
										<c:set var="count" value="${count+1 }" />
										<th scope="row">${count}</th>
										<td><img
											src='<c:url value="data:image/jpg;base64,${product.base64Image }"></c:url>'
											height="10%"></td>
										<td>${product.product_Code }</td>
										<td>${product.name_Product }</td>
										<td><c:choose>
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
										<td><f:formatNumber value="${product.price }"
												pattern="###,###" />VNĐ</td>
										<td>${product.description }</td>
										<td>${product.categories.name_Categories }</td>
										<td>${product.size }</td>
										<td><a
											href="admin/product/edit-prod/${product.product_Code}.htm"
											type="button" rel="tooltip" title="Sửa"
											class="btn btn-info btn-simple btn-xs"> <i
												class="fa fa-edit"></i></a> <a
											href="admin/product/delete-prod/${product.product_Code}.htm"
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
									<a href="admin/product/?page=${row.index}"
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