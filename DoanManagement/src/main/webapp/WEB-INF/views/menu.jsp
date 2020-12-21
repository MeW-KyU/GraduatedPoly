<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<aside class="left-sidebar" data-sidebarbg="skin6">
	<!-- Sidebar scroll-->
	<div class="scroll-sidebar">
		<!-- Sidebar navigation-->
		<nav class="sidebar-nav">
			<ul id="sidebarnav">
				<li class="p-15 m-t-10"><a href="javascript:void(0)"
					class="btn btn-block create-btn text-white no-block d-flex align-items-center"><i
						class="fa fa-eye"></i> <span class="hide-menu m-l-10">Shop
							Overview</span> </a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="admin/statistical/" aria-expanded="false"><i
						class="mdi mdi-view-dashboard"></i><span class="hide-menu">Thống
							kê</span></a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="admin/account/" aria-expanded="false"><i
						class="mdi mdi-account"></i><span class="hide-menu">Tài
							khoản</span></a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="admin/staff/" aria-expanded="false"><i
						class="mdi mdi-face"></i><span class="hide-menu">Nhân viên</span></a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="admin/customer/" aria-expanded="false"><i
						class="mdi mdi-account-multiple"></i><span class="hide-menu">Khách
							hàng</span></a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="admin/product/" aria-expanded="false"><i
						class="mdi mdi-pizza"></i><span class="hide-menu">Sản phẩm</span></a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="admin/merchandise/" aria-expanded="false"><i
						class="mdi mdi-cube"></i><span class="hide-menu">Hàng hoá</span></a></li>
				<li class="sidebar-item dropdown "><a href="javascript:void(0)"
					class="sidebar-link waves-effect waves-dark sidebar-link" id="deal"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i
						class="mdi mdi-cash-usd"></i><span class="hide-menu">Hoá
							đơn<i class="mdi mdi-chevron-down"></i>
					</span></a>
					<div class="dropdown-menu dropdown-menu-right"
						aria-labelledby="deal">
						<a class="dropdown-item m-r-5" href="admin/invoice/">Bán hàng</a>
						<a class="dropdown-item m-r-5" href="admin/import/">Nhập kho</a> <a
							class="dropdown-item m-r-5" href="admin/export/">Xuất kho</a>
					</div></li>
				<li class="text-center p-40 upgrade-btn"><a
					href="https://www.facebook.com/laym2k"
					class="btn btn-block btn-danger text-white" target="_blank">Hỗ
						trợ</a></li>
			</ul>
		</nav>
		<!-- End Sidebar navigation -->
	</div>
	<!-- End Sidebar scroll-->
</aside>
