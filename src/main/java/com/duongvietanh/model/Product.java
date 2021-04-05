package com.duongvietanh.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;


@Entity
@Table(name = "PRODUCTS")
public class Product {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "price")
	private double price;
	@Column(name = "price_net")
	private double price_net;
	@Column(name = "available")
	private int available ;
	@Column(name = "sale ")
	private boolean sale ;
	@Column(name = "deal_timer")
	private Timestamp deal_timer ;
	@Column(name = "discount")
	private int discount;
	@Column(name = "image ")
	private String image ;
	@Column(name = "category")
	private String category ;
	@Column(name = "new_product")
	private boolean new_product ;
	@Column(name = "hot_trend")
	private boolean hot_trend ;
	@Column(name = "best_seller")
	private boolean best_seller  ;
	@Column(name = "feature")
	private boolean feature  ;
	@Column(name = "cover")
	private boolean cover;
	@Column(name = "latest_review")
	private boolean latest_review ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice_net() {
		return price_net;
	}
	public void setPrice_net(double price_net) {
		this.price_net = price_net;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public boolean isSale() {
		return sale;
	}
	public void setSale(boolean sale) {
		this.sale = sale;
	}
	public Timestamp getDeal_timer() {
		return deal_timer;
	}
	public void setDeal_timer(Timestamp deal_timer) {
		this.deal_timer = deal_timer;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isNew_product() {
		return new_product;
	}
	public void setNew_product(boolean new_product) {
		this.new_product = new_product;
	}
	public boolean isHot_trend() {
		return hot_trend;
	}
	public void setHot_trend(boolean hot_trend) {
		this.hot_trend = hot_trend;
	}
	public boolean isBest_seller() {
		return best_seller;
	}
	public void setBest_seller(boolean best_seller) {
		this.best_seller = best_seller;
	}
	public boolean isFeature() {
		return feature;
	}
	public void setFeature(boolean feature) {
		this.feature = feature;
	}
	public boolean isCover() {
		return cover;
	}
	public void setCover(boolean cover) {
		this.cover = cover;
	}
	public boolean isLatest_review() {
		return latest_review;
	}
	public void setLatest_review(boolean latest_review) {
		this.latest_review = latest_review;
	}	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_product")
	private List<ProductRelated> productRelateds;
	
	public List<ProductRelated> getproductRelated() {
		return productRelateds;
	}
	public void setproductRelated(List<ProductRelated> productRelateds) {
		this.productRelateds = productRelateds;
	}    
//	
	public Product(int id, String title, String description, double price, double price_net, int available,
			boolean sale, Timestamp deal_timer, int discount, String image, String category, boolean new_product,
			boolean hot_trend, boolean best_seller, boolean feature, boolean cover, boolean latest_review) {
		
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.price_net = price_net;
		this.available = available;
		this.sale = sale;
		this.deal_timer = deal_timer;
		this.discount = discount;
		this.image = image;
		this.category = category;
		this.new_product = new_product;
		this.hot_trend = hot_trend;
		this.best_seller = best_seller;
		this.feature = feature;
		this.cover = cover;
		this.latest_review = latest_review;
	}
	public Product() {
		
		// TODO Auto-generated constructor stub
	}
}

