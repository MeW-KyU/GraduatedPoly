<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<base href="${pageContext.servletContext.contextPath}/">
<header class="topbar" data-navbarbg="skin5">
	<nav class="navbar top-navbar navbar-expand-md navbar-dark">
		<div class="navbar-header" data-logobg="skin5">
			<!-- ============================================================== -->
			<!-- Logo -->
			<!-- ============================================================== -->
			<a class="navbar-brand" href="index.html"> <!-- Logo icon --> <b
				class="logo-icon"> <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
					<!-- Dark Logo icon --> <img
					src="resource/dist/css/images/logo-icon.png" alt="homepage"
					class="dark-logo" /> <!-- Light Logo icon --> <img
					src="resource/dist/css/images/logo-light-icon.png" alt="homepage"
					class="light-logo" />
			</b> <!--End Logo icon --> <!-- Logo text --> <span class="logo-text">
					<!-- dark Logo text --> <img
					src="resource/dist/css/images/logo-text.png" alt="homepage"
					class="dark-logo" /> <!-- Light Logo text --> <img
					src="resource/dist/css/images/logo-light-text.png"
					class="light-logo" alt="homepage" />
			</span>
			</a>
			<!-- ============================================================== -->
			<!-- End Logo -->
			<!-- ============================================================== -->
			<!-- This is for the sidebar toggle which is visible on mobile only -->
			<a class="nav-toggler waves-effect waves-light d-block d-md-none"
				href="javascript:void(0)"><i class="ti-menu ti-close"></i></a>
		</div>
		<!-- ============================================================== -->
		<!-- End Logo -->
		<!-- ============================================================== -->
		<div class="navbar-collapse collapse" id="navbarSupportedContent"
			data-navbarbg="skin5">
			<!-- ============================================================== -->
			<!-- Right side toggle and nav items -->
			<!-- ============================================================== -->
			<ul class="navbar-nav ml-auto">
				<!-- ============================================================== -->
				<!-- Noti-->
				<!-- ============================================================== -->
				<li>
					<div class="user-profile d-flex no-block dropdown"
						style="height: 100%; align-items: center"">
						<c:if test="${sessionScope.account.username != null }">
							<div class="user-content hide-menu m-l-10">
								<a href="javascript:void(0)" class="" id="Userdd" role="button"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">
									<h4 class="m-b-0 user-name font-medium">
										<i class="fa fa-bell"></i>
									</h4>
								</a>
								<div class="dropdown-menu dropdown-menu-right user-dd animated" style="right:-12vw;overflow-y:auto;max-height:600px">
									<div class="col-sm-12 ">
										<div class="row">
											<div class="col-sm-12">
												<div class="card">
													<div class="card-body dashboardStatistic p-0">
														<div class="table-responsive">
															<table class="table table-hover">
																<c:set var="count" value="0" />
																<tbody>
																	<c:forEach items="${listHistory}" var="history">
																		<tr class="alert alert-${history.typeAct}">
																			<td
																				style="text-align: center; vertical-align: middle;">${history.name }
																			</td>
																			<td
																				style="text-align: center; vertical-align: middle;">${history.nameAct }
																			</td>
																			<td
																				style="text-align: center; vertical-align: middle;">
																				<f:formatDate value="${history.dayAct}"
																					pattern="dd/MM/yy HH:mm" />
																			</td>
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
								</div>
							</div>
						</c:if>
					</div>
				</li>

				<!-- ============================================================== -->
				<!-- User profile-->
				<!-- ============================================================== -->
				<li>
					<div class="user-profile d-flex no-block dropdown">
						<c:if test="${sessionScope.account.username != null }">
							<div class="user-pic" id="Userdd" role="button"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">
								<img src="resource/dist/css/images/users/1.jpg" alt="users"
									class="rounded-circle" width="31" />
							</div>
							<div class="user-content hide-menu m-l-10">
								<a href="javascript:void(0)" class="" id="Userdd" role="button"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">
									<h5 class="m-b-0 user-name font-medium">${sessionScope.account.username},
										<i class="fa fa-angle-down"></i>
									</h5> <span class="op-5 user-email">Welcome to you</span>
								</a>
								<div class="dropdown-menu dropdown-menu-right user-dd animated">
									<a class="dropdown-item"
										href="admin/account/FormeditPass/${account.username}.htm"><i
										class="ti-settings m-r-5 m-l-5"></i> Đổi mật khẩu</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item"
										href="${pageContext.request.contextPath }/admin/login/logout.htm"><i
										class="fa fa-power-off m-r-5 m-l-5"></i> Đăng xuất</a>
								</div>
							</div>
						</c:if>
					</div> <!-- End User Profile-->
				</li>
				<!-- User Profile-->
				<!-- ============================================================== -->
				<!-- User profile and search -->
				<!-- ============================================================== -->
			</ul>
		</div>
	</nav>
</header>