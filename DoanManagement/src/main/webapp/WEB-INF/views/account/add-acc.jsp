<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<base href="${pageContext.servletContext.contextPath }/">
<%
	System.out.println("account/add-account.jsp");
%>
<title>Add account - Doan Delivery Online</title>
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
			<h4 class="page-title">Tài khoản</h4>
			<div class="d-flex align-items-center">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="admin/statistical/">Trang
								chủ</a></li>
						<li class="breadcrumb-item" aria-current="page">Tài khoản</li>
						<li class="breadcrumb-item active" aria-current="page">Thêm
							tài khoản</li>
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
					<form:form action="admin/account/save-acc.htm" method="POST"
						modelAttribute="account" class="form-horizontal form-material">
						<div class="row">
							<div class="col-sm-12 p-0">
								<div class="form-group">
									<label class="col-md-12">Tên đăng nhập <span
										style="color: red;">*</span> <form:errors path="username"
											class="error" /></label>
									<div class="col-md-12">
										<form:input path="username"
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
										<form:password path="password"
											class="form-control form-control-line" />
									</div>
								</div>
							</div>
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-sm-12">Quyền truy cập <span
										style="color: red;">*</span> <form:errors path="access"
											class="error" /></label>
									<div class="col-sm-12">
										<form:select path="access"
											class="form-control form-control-line"
											style="height: calc(1.5em + 0.75rem + 2px)">
											<option selected="selected" value=0>Select</option>
											<form:option value="1">Quản trị viên</form:option>
											<form:option value="2">Nhân viên</form:option>
										</form:select>
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

	<!-- Danh sach tai khoan -->
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-lg-4 p-2">
							<form:form id="form_search" role="search"
								action="admin/account/search.htm" method="get">
								<label for="search">Search for stuff</label>
								<input id="search" name="search" type="search"
									placeholder="Search..." />
								<button type="submit" class="button_search">Search</button>
							</form:form>
						</div>
						<div class="col-lg-8 p-2">
							<div class="text-right">
								<a href="admin/account/add-acc.htm"
									class="btn btn-dropbox text-white">Thêm tài khoản</a>
							</div>
						</div>
					</div>
					<br>
					<div class="table-responsive">
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col">STT</th>
									<th scope="col">Tên đăng nhập</th>
									<th scope="col">Quyền truy cập</th>
									<th scope="col">Chức năng</th>
								</tr>
							</thead>
							<c:set var="count" value="0" />
							<tbody>
								<c:forEach items="${listAccount}" var="account">
									<tr>
										<c:set var="count" value="${count+1 }" />
										<th scope="row">${count}</th>
										<td>${account.username }</td>
										<td><c:choose>
												<c:when test="${account.access < 2 }">
													<button id="admin" type="button"
														class="btn btn-warning btn-xs">Quản trị viên</button>
												</c:when>
												<c:when test="${account.access >= 2}">
													<button id="user" type="button" class="btn btn-info btn-xs">Nhân
														viên</button>
												</c:when>
											</c:choose></td>
										<td><a
											href="admin/account/edit-acc/${account.username}.htm"
											type="button" rel="tooltip" title="Sửa"
											class="btn btn-info btn-simple btn-xs"> <i
												class="fa fa-edit"></i></a> <a
											href="admin/account/delete-acc/${account.username}.htm"
											onclick="return confirm('Bạn chắc chắn chứ ?')" type="button"
											rel="tooltip" title="Xóa"
											class="btn btn-danger btn-simple btn-xs"> <i
												class="fas fa-times"></i></a> <a
											href="admin/account/reset-acc/${account.username}.htm"
											onclick="return confirm('Bạn chắc chắn chứ? password sẽ được thay đổi thành 123')"
											type="button" rel="tooltip" title="Reset"
											class="btn btn-danger btn-simple btn-xs"> <i
												class="fas fa-sync-alt"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
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