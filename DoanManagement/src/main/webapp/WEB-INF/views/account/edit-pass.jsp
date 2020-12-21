<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<base href="${pageContext.servletContext.contextPath }/">
<%
	System.out.println("account/edit-account.jsp");
%>
<title>Edit password account - Doan Delivery Online</title>
<style>
.form-control {
	height: calc(1.5em + 0.75rem + 2px);
}

*[id$=errors] {
	color: red;
	font-style: italic;
}
</style>
<div class="container-fluid">
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					<form:form action="admin/account/editPass/${account.username}.htm"
						method="POST" commandName="account"
						class="form-horizontal form-material">
						<div class="row">
							<div class="col-md-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Tên đăng nhập <form:errors
											path="username" class="error" /></label>
									<div class="col-md-12">
										<form:input path="username"
											class="form-control form-control-line" readonly="true" />
									</div>
								</div>
							</div>
							<div class="col-sm-6 p-0">
								<div class="form-group">
									<label class="col-md-12">Mật khẩu <span
										style="color: red;">*</span> <form:errors path="password"
											class="error" /></label>
									<div class="col-md-12">
										<form:input path="password"
											class="form-control form-control-line" />
									</div>
								</div>
							</div>
						</div>
						<input id="nameu" name="nameu" type="hidden" value="${sessionScope.account.username}" />
						<div class="row">
							<div class="col-sm-12 p-0">
								<div class="form-group">
									<div class="col-lg-3 text-right float-right">
										<p>${message }</p>
										<button class="btn btn-success">Đổi mật khẩu</button>
									</div>
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>