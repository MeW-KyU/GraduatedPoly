<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<base href="${pageContext.servletContext.contextPath }/">
<%
	System.out.println("staff/edit-staff.jsp");
%>
<title>Edit staff - Doan Delivery Online</title>
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
		<div class="col-sm-6">
			<h4 class="page-title">Nhân viên</h4>
			<div class="d-flex align-items-center">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="admin/statistical/">Trang
								chủ</a></li>
						<li class="breadcrumb-item" aria-current="page">Quản lí nhân
							viên</li>
						<li class="breadcrumb-item" aria-current="page">Sửa thông tin
							nhân viên</li>
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
					<form:form action="admin/staff/edit-sta/${staff.staff_Code}.htm"
						method="POST" commandName="staff"
						class="form-horizontal form-material">
						<div class="row">
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Mã nhân viên</label>
									<div class="col-md-12">
										<form:input path="staff_Code"
											class="form-control form-control-line" readonly="true" />
									</div>
								</div>
							</div>
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Tên nhân viên <span
										style="color: red;">*</span> <form:errors path="name_Staff"
											class="error" /></label>
									<div class="col-md-12">
										<form:input path="name_Staff"
											class="form-control form-control-line" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Vị trí <span
										style="color: red;">*</span> <form:errors path="position"
											class="error" /></label>
									<div class="col-md-12">
										<form:select path="position"
											class="form-control form-control-line">
											<option selected="selected" value=0>Select</option>
											<form:option value="1">Chủ cửa hàng</form:option>
											<form:option value="2">Quản lí</form:option>
											<form:option value="3">Cửa hàng trưởng</form:option>
											<form:option value="4">Nhân viên</form:option>
											<form:option value="5">Shiper</form:option>
										</form:select>
									</div>
								</div>
							</div>
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Lương <span
										style="color: red;">*</span> <form:errors path="salary"
											class="error" /></label>
									<div class="col-md-12">
										<form:input path="salary"
											class="form-control form-control-line" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Giới tính <span
										style="color: red;">*</span> <form:errors path="gender"
											class="error" /></label>
									<div class="col-md-12">
										<form:select path="gender"
											class="form-control form-control-line">
											<option selected="selected" value=0>Select</option>
											<form:option value="1">Nam</form:option>
											<form:option value="2">Nữ</form:option>
											<form:option value="3">Khác</form:option>
										</form:select>
									</div>
								</div>
							</div>
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Năm sinh <span
										style="color: red;">*</span> <form:errors path="birthday"
											class="error" /></label>
									<div class="col-md-12">
										<form:input path="birthday" placeholder="dd/MM/yy"
											class="form-control form-control-line" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Số điện thoại <span
										style="color: red;">*</span> <form:errors path="phone_Staff"
											class="error" /></label>
									<div class="col-md-12">
										<form:input path="phone_Staff"
											class="form-control form-control-line" />
									</div>
								</div>
							</div>
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label for="example-email" class="col-md-12">Email <span
										style="color: red;">*</span> <form:errors path="email_Staff"
											class="error" /></label>
									<div class="col-md-12">
										<form:input path="email_Staff"
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
										style="color: red;">*</span> <form:errors path="address_Staff"
											class="error" /></label>
									<div class="col-md-12">
										<form:textarea path="address_Staff" rows="5"
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

	<!-- Danh sach nhân viên -->
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-lg-4 p-2">
							<form:form id="form_search" role="search"
								action="admin/staff/search.htm" method="get">
								<label for="search">Search for stuff</label>
								<input id="search" name="search" type="search"
									placeholder="Search..." />
								<button type="submit" class="button_search">Search</button>
							</form:form>
						</div>
						<div class="col-lg-8 p-2">
							<div class="text-right">
								<a href="admin/staff/add-sta.htm"
									class="btn btn-dropbox text-white">Thêm nhân viên</a>
							</div>
						</div>
					</div>
					<br>
					<div class="table-responsive">
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col">STT</th>
									<th scope="col">Mã nhân viên</th>
									<th scope="col">Tên nhân viên</th>
									<th scope="col">Vị trí</th>
									<th scope="col">Lương</th>
									<th scope="col">Giới tính</th>
									<th scope="col">Năm sinh</th>
									<th scope="col">Số điện thoại</th>
									<th scope="col">Email</th>
									<th scope="col">Địa chỉ</th>
									<th scope="col">Chức năng</th>
								</tr>
							</thead>
							<c:set var="count" value="0" />
							<tbody>
								<c:forEach items="${listStaff}" var="staff">
									<tr>
										<c:set var="count" value="${count+1 }" />
										<th scope="row">${count}</th>
										<td>${staff.staff_Code }</td>
										<td>${staff.name_Staff }</td>
										<td><c:choose>
												<c:when test="${staff.position == 1 }">
													Chủ cửa hàng
												</c:when>
												<c:when test="${staff.position == 2}">
													Quản lí
												</c:when>
												<c:when test="${staff.position == 3}">
													Của hàng trưởng
												</c:when>
												<c:when test="${staff.position == 4}">
													Nhân viên
												</c:when>
												<c:when test="${staff.position == 5}">
													Shiper
												</c:when>
											</c:choose></td>
										<td><f:formatNumber value="${staff.salary }"
												pattern="###,###" />VNĐ</td>
										<td><c:choose>
												<c:when test="${staff.gender == 1 }">
													Nam
												</c:when>
												<c:when test="${staff.gender == 2}">
													Nữ
												</c:when>
												<c:when test="${staff.gender == 3}">
													Khác
												</c:when>
											</c:choose></td>
										<td>${staff.birthday }</td>
										<td>${staff.phone_Staff }</td>
										<td>${staff.email_Staff }</td>
										<td>${staff.address_Staff }</td>
										<td><a
											href="admin/staff/edit-sta/${staff.staff_Code}.htm"
											type="button" rel="tooltip" title="Sửa"
											class="btn btn-info btn-simple btn-xs"> <i
												class="fa fa-edit"></i></a> <a
											href="admin/staff/delete-sta/${staff.staff_Code}.htm"
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
									<a
										href="admin/staff/${staff.staff_Code}.htm/?page=${row.index}"
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