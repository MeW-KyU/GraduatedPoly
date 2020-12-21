<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<base href="${pageContext.servletContext.contextPath }/">
<%
	System.out.println("staff/index.jsp");
%>
<title>Staff - Doan Delivery Online</title>
<!-- ============================================================== -->
<!-- Bread crumb and right sidebar toggle -->
<!-- ============================================================== -->
<div class="page-breadcrumb">
	<div class="row align-items-center">
		<div class="col-sm-3">
			<h4 class="page-title">Nhân viên</h4>
			<div class="d-flex align-items-center">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="admin/statistical/">Trang chủ</a></li>
						<li class="breadcrumb-item" aria-current="page">Quản lí nhân
							viên</li>
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
	<!-- Danh sach nhân viên -->
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-lg-4 p-2">
							<form:form id="form_search" role="search"
								action="admin/staff/search.htm" method="get">
								<label for="search">Search for staff</label>
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
										<td><f:formatDate value="${staff.birthday }"
												pattern="dd/MM/yyyy" /></td>
										<td>${staff.phone_Staff }</td>
										<td>${staff.email_Staff }</td>
										<td>${staff.address_Staff }</td>
										<td><a
											href="admin/staff/edit-sta/${staff.staff_Code}.htm"
											type="button" rel="tooltip" title="Sửa"
											class="btn btn-info btn-simple btn-xs"> <i
												class="fa fa-edit"></i></a> <a
											href="admin/staff/delete-sta/${staff.staff_Code}/${sessionScope.account.username}.htm"
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
									<a href="admin/staff/?page=${row.index}"
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