<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<nav
	class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
	id="ftco-navbar">
	<div class="container">
		<a class="navbar-brand" href="<c:url value="/" />"><span
			class="flaticon-pizza-1 mr-1"></span>Pizza<br> <small>Delicous</small></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#ftco-nav" aria-controls="ftco-nav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="oi oi-menu"></span> Menu
		</button>
		<div class="collapse navbar-collapse" id="ftco-nav">
			<ul class="navbar-nav ml-auto">
				<c:forEach var="item" items="${menus }" varStatus="index">
					<li class="nav-item"><a
						href="<c:url value="/${item.name }" />" class="nav-link">${item.name}</a>
					</li>
				</c:forEach>
			</ul>
			<ul class="navbar-nav ml-auto">
				<c:if test="${empty LoginInfo }">
					<li class="nav-item"><a href="<c:url value="/login" />"
						class="nav-link">Login</a></li>
				</c:if>
				<c:if test="${not empty LoginInfo }">
					<ul>
						<li>Welcome, ${LoginInfo.name} <a
							href="<c:url value="logout" />" id="cart"><i
								class="fa fa-sign-out" aria-hidden="true"></i></a></li>
						<li><a href="<c:url value="/tracking" />">Tracking Order</a></li>
					</ul>
				</c:if>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a href="<c:url value="/ListCart" />"
					id="cart"><i class="fa fa-shopping-cart"></i> Cart <span
						class="badge">${TotalQuantyCart }</span></a></li>
			</ul>
		</div>
	</div>
</nav>
<!-- END nav -->