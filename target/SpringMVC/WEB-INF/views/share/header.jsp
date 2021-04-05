 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<header class="header">
	<div class="container-fluid">
		<div class="row">
			<div class="col-xl-3 col-lg-2">
				<div class="header__logo">
					<a href="index"><img src="resources/img/logo.png" alt=""></a>
				</div>
			</div>
			<div class="col-xl-6 col-lg-7">
				<nav class="header__menu">
					<ul>
						<li class="active"><a href="${pageContext.request.contextPath}">Home</a></li>
						<li><a href="Womens">Women</a></li>
						<li><a href="Mens">Men</a></li>
						<li><a href="./shop.html">Shop</a></li>
						<li><a href="#">Pages</a>
							<ul class="dropdown">
								<li><a href="./product-details.html">Product Details</a></li>
								<li><a href="./shop-cart.html">Shop Cart</a></li>
								<li><a href="./checkout.html">Checkout</a></li>
								<li><a href="./blog-details.html">Blog Details</a></li>
							</ul></li>
						<li><a href="./blog.html">Blog</a></li>
						<li><a href="./contact.html">Contact</a></li>
					</ul>
				</nav>
			</div>
			<div class="col-lg-3">
				<div class="header__right">
				<c:if test="${ not empty LoginInfo}">
					<div class="header__right__auth" style="float: left;">
					
						<a href="">${LoginInfo.display_name}</a>
						<a href="Logout">Logout</a>
						<c:if test="${useradmin=='admin'}">
							<a href="Admin">Admin</a>
						</c:if>
					</div>
				</c:if>
				<c:if test="${empty LoginInfo}">
					<div class="header__right__auth">
						<a href="Login">Login/Register</a>
					</div>
				</c:if>
					
					<ul class="header__right__widget">
						<li><span class="icon_search search-switch"></span></li>
						<li><a href="#"><span class="icon_heart_alt"></span>
								<div class="tip">2</div> </a></li>
						<li><a href="Cart"><span class="icon_bag_alt"></span>
								<div class="tip">${CART.size()}</div> </a></li>					
					</ul>
				</div>
			</div>
		</div>
		<div class="canvas__open">
			<i class="fa fa-bars"></i>
		</div>
	</div>
</header>