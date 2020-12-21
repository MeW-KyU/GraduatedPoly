<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<base href="${pageContext.servletContext.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link href="resource/dist/css/login.css" rel="stylesheet">
<title>Login - Doan Delivery Online</title>
<style type="text/css">
*[id$=errors] {
	color: red;
	font-style: italic;
}
</style>
	<%
		System.out.println("login/index.jsp");
	%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12">
				<div class="card">
					<div class="d-flex align-items-center min-vh-100">
						<div class="container text-center">
							<i class="mdi mdi-alert-circle-outline"
								style="color: #FFE036; font-size: 700%;"></i>
							<h1>Bạn không có quyền truy cập</h1>
							<a data-toggle="modal" href="#myModal">Đăng nhập</a>
						</div>
					</div>
				</div>
			</div>
			<!-- ============================================================== -->
			<!-- End Container fluid  -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
		</div>
		<!-- ============================================================== -->
		<!-- End Page wrapper  -->
		<!-- ============================================================== -->
	</div>
	<div class="modal fade" id="myModal" style="background-color: #FDEBD0;">
		<div class="modal-dialog modal-dialog-centered modal-xl">
			<div class="modal-content border-0">
				<!-- Modal body -->
				<div class="modal-body p-0">
					<div class="row no-gutter m-0">
						<div class="d-none d-md-flex col-lg-6 bg-image p-0"></div>
						<div class="col-lg-6">
							<div class="login d-flex align-items-center py-5">
								<div class="container">
									<div class="row">
										<div class="col-md-9 col-lg-8 mx-auto p-0">
											<h3 class="login-heading mb-4">ĐĂNG NHẬP</h3>
											<div style="color: red">${message }</div>
											<form:form method="post"
												action="${pageContext.request.contextPath}/admin/login/login.htm"
												commandName="loginForm">
												<div class="form-label-group">
													<label><form:errors path="username" /></label>
													<form:input path="username" id="inputUsername"
														class="form-control" placeholder="Username"
														/>
													<label for="inputUsername">Tên tài khoản</label>
												</div>

												<div class="form-label-group">
													<label><form:errors path="password" /></label>
													<form:password path="password"
														id="inputPassword" class="form-control"
														placeholder="Password" />
													<label for="inputPassword">Mật khẩu</label>
												</div>

												<div class="custom-control custom-checkbox mb-3">
													<input type="checkbox" class="custom-control-input"
														id="customCheck1" name="remember"> <label
														class="custom-control-label" for="customCheck1">Ghi
														nhớ mật khẩu</label>
												</div>
												<button
													class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2"
													style="height: auto;" type="submit" value="${labelSubmit}">Đăng
													nhập</button>
												<div class="text-center">
													<a class="small" href="#">Quên mật khẩu</a>
												</div>
											</form:form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>

	</div>