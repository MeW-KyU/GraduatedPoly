<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<base href="${pageContext.servletContext.contextPath }/">
<%
	System.out.println("customer/index.jsp");
%>
<title>Customer - Doan Delivery Online</title>
<!-- ============================================================== -->
<!-- Bread crumb and right sidebar toggle -->
<!-- ============================================================== -->
<div class="page-breadcrumb">
	<div class="row align-items-center">
		<div class="col-sm-3">
			<h4 class="page-title">Khách hàng</h4>
			<div class="d-flex align-items-center">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="admin/statistical/">Trang chủ</a></li>
						<li class="breadcrumb-item" aria-current="page">Quản lí khách
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
	<!-- Danh sach khách hàng -->
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-lg-4 p-2">
							<form:form id="form_search"
								role="search" action="admin/customer/search.htm" method="get">
								<label for="search">Search for stuff</label>
								<input id="search" name="search" type="search" placeholder="Search..." />
								<button type="submit" class="button_search">Search</button>
							</form:form>
						</div>
						<div class="col-lg-8 p-2">
							<div class="text-right">
								<a href="admin/customer/add-cus.htm" class="btn btn-dropbox text-white">Thêm
									khách hàng</a>
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
											href="admin/customer/delete-cus/${customer.customer_Code}/${sessionScope.account.username}.htm"
											onclick="return confirm('Bạn chắc chắn chứ ?')" type="button"
											rel="tooltip" title="Xóa"
											class="btn btn-danger btn-simple btn-xs"> <i
												class="fas fa-times"></i></a> <a
											href="admin/customer/reset-cus/${customer.customer_Code}/${sessionScope.account.username}.htm"
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
									<a href="admin/customer/?page=${row.index}"
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