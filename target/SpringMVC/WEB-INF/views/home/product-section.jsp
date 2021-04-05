<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<section class="product spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-4 col-md-4">
				<div class="section-title">
					<h4>New product</h4>
				</div>
			</div>
			<div class="col-lg-8 col-md-8">
				<ul class="filter__controls">
					<li class="active" data-filter="*">All</li>
					<li data-filter=".women">Women</li>
					<li data-filter=".men">Men</li>
					<li data-filter=".kid">Kid</li>
					<li data-filter=".accessories">Accessories</li>
					<li data-filter=".cosmetic">Cosmetics</li>
				</ul>
			</div>
		</div>
		<div class="row property__gallery">
			<c:forEach items="${listProducts}" var="product">
				<div class="col-lg-3 col-md-4 col-sm-6 mix">

					<div class="product__item">
						<div class="product__item__pic set-bg"
							data-setbg="resources/${product.getImage()}">
							<div class="label new">New</div>
							<ul class="product__hover">
								<li><a href="resources/${product.getImage()}"
									class="image-popup"><span class="arrow_expand"></span></a></li>
								<li><a href="#"><span class="icon_heart_alt"></span></a></li>
								<li><a href="AddCart/${product.getId()}"> <span class="icon_bag_alt"></span></a></li>
							</ul>
						</div>
						<div class="product__item__text">
							<h6>
								<a href="${product.getId()}">${product.getTitle()}</a>
							</h6>
							<div class="rating">
								<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i>
							</div>
							<div class="product__price"><fmt:formatNumber value="${product.getPrice()}" type="number"
								maxIntegerDigits="14" />₫</div>
						</div>
					</div>
				</div>
			</c:forEach>
			
			
			<c:forEach items="${listProductWoman}" var="product">
				<div class="col-lg-3 col-md-4 col-sm-6 mix women">
					<div class="product__item">
						<div class="product__item__pic set-bg"
							data-setbg="resources/${product.getImage()}">
							<div class="label new">New</div>
							<ul class="product__hover">
								<li><a href="resources/${product.getImage()}"
									class="image-popup"><span class="arrow_expand"></span></a></li>
								<li><a href="#"><span class="icon_heart_alt"></span></a></li>
								<li><a href="#"><span class="icon_bag_alt"></span></a></li>
							</ul>
						</div>
						<div class="product__item__text">
							<h6>
								<a href="${product.getId()}">${product.getTitle()}</a>
							</h6>
							<div class="rating">
								<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i>
							</div>
							<div class="product__price"><fmt:formatNumber value="${product.getPrice()}" type="number"
								maxIntegerDigits="14" />₫</div>
						</div>
					</div>
				</div>
			</c:forEach>
			<c:forEach items="${listProductMan}" var="product">
			<div class="col-lg-3 col-md-4 col-sm-6 mix men">
				<div class="product__item">
					<div class="product__item__pic set-bg"
						data-setbg="resources/${product.getImage()}">
						<ul class="product__hover">
							<li><a href="resources/${product.getImage()}"
								class="image-popup"><span class="arrow_expand"></span></a></li>
							<li><a href="#"><span class="icon_heart_alt"></span></a></li>
							<li><a href="#"><span class="icon_bag_alt"></span></a></li>
						</ul>
					</div>
					<div class="product__item__text">
						<h6>
							<a href="${product.getId()}">${product.getTitle()}</a>
						</h6>
						<div class="rating">
							<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i>
						</div>
						<div class="product__price"><fmt:formatNumber value="${product.getPrice()}" type="number"
								maxIntegerDigits="14" /></div>
					</div>
				</div>
			</div>
			</c:forEach>
			<div class="col-lg-3 col-md-4 col-sm-6 mix accessories">
				<div class="product__item">
					<div class="product__item__pic set-bg"
						data-setbg="resources/img/product/product-3.jpg">
						<div class="label stockout">out of stock</div>
						<ul class="product__hover">
							<li><a href="resources/img/product/product-3.jpg"
								class="image-popup"><span class="arrow_expand"></span></a></li>
							<li><a href="#"><span class="icon_heart_alt"></span></a></li>
							<li><a href="#"><span class="icon_bag_alt"></span></a></li>
						</ul>
					</div>
					<div class="product__item__text">
						<h6>
							<a href="#">Cotton T-Shirt</a>
						</h6>
						<div class="rating">
							<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i>
						</div>
						<div class="product__price">$ 59.0</div>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-4 col-sm-6 mix cosmetic">
				<div class="product__item">
					<div class="product__item__pic set-bg"
						data-setbg="resources/img/product/product-4.jpg">
						<ul class="product__hover">
							<li><a href="resources/img/product/product-4.jpg"
								class="image-popup"><span class="arrow_expand"></span></a></li>
							<li><a href="#"><span class="icon_heart_alt"></span></a></li>
							<li><a href="#"><span class="icon_bag_alt"></span></a></li>
						</ul>
					</div>
					<div class="product__item__text">
						<h6>
							<a href="#">Slim striped pocket shirt</a>
						</h6>
						<div class="rating">
							<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i>
						</div>
						<div class="product__price">$ 59.0</div>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-4 col-sm-6 mix kid">
				<div class="product__item">
					<div class="product__item__pic set-bg"
						data-setbg="resources/img/product/product-5.jpg">
						<ul class="product__hover">
							<li><a href="resources/img/product/product-5.jpg"
								class="image-popup"><span class="arrow_expand"></span></a></li>
							<li><a href="#"><span class="icon_heart_alt"></span></a></li>
							<li><a href="#"><span class="icon_bag_alt"></span></a></li>
						</ul>
					</div>
					<div class="product__item__text">
						<h6>
							<a href="#">Fit micro corduroy shirt</a>
						</h6>
						<div class="rating">
							<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i>
						</div>
						<div class="product__price">$ 59.0</div>
					</div>
				</div>
			</div>
			<div
				class="col-lg-3 col-md-4 col-sm-6 mix kid accessories cosmetic">
				<div class="product__item sale">
					<div class="product__item__pic set-bg"
						data-setbg="resources/img/product/product-6.jpg">
						<div class="label sale">Sale</div>
						<ul class="product__hover">
							<li><a href="resources/img/product/product-6.jpg"
								class="image-popup"><span class="arrow_expand"></span></a></li>
							<li><a href="#"><span class="icon_heart_alt"></span></a></li>
							<li><a href="#"><span class="icon_bag_alt"></span></a></li>
						</ul>
					</div>
					<div class="product__item__text">
						<h6>
							<a href="#">Tropical Kimono</a>
						</h6>
						<div class="rating">
							<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i>
						</div>
						<div class="product__price">
							$ 49.0 <span>$ 59.0</span>
						</div>
					</div>
				</div>
			</div>
			<div
				class="col-lg-3 col-md-4 col-sm-6 mix kid accessories cosmetic">
				<div class="product__item">
					<div class="product__item__pic set-bg"
						data-setbg="resources/img/product/product-7.jpg">
						<ul class="product__hover">
							<li><a href="resources/img/product/product-7.jpg"
								class="image-popup"><span class="arrow_expand"></span></a></li>
							<li><a href="#"><span class="icon_heart_alt"></span></a></li>
							<li><a href="#"><span class="icon_bag_alt"></span></a></li>
						</ul>
					</div>
					<div class="product__item__text">
						<h6>
							<a href="#">Contrasting sunglasses</a>
						</h6>
						<div class="rating">
							<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i>
						</div>
						<div class="product__price">$ 59.0</div>
					</div>
				</div>
			</div>
			<div
				class="col-lg-3 col-md-4 col-sm-6 mix kid accessories cosmetic">
				<div class="product__item sale">
					<div class="product__item__pic set-bg"
						data-setbg="resources/img/product/product-8.jpg">
						<div class="label">Sale</div>
						<ul class="product__hover">
							<li><a href="resources/img/product/product-8.jpg"
								class="image-popup"><span class="arrow_expand"></span></a></li>
							<li><a href="#"><span class="icon_heart_alt"></span></a></li>
							<li><a href="#"><span class="icon_bag_alt"></span></a></li>
						</ul>
					</div>
					<div class="product__item__text">
						<h6>
							<a href="#">Water resistant backpack</a>
						</h6>
						<div class="rating">
							<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i>
						</div>
						<div class="product__price">
							$ 49.0 <span>$ 59.0</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

