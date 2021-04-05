package com.duongvietanh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_related")
public class ProductRelated {
	 @Id
	 @Column(name = "id")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;  
	 @Column(name = "id_product")
	 private int id_product;
	 @Column(name = "id_related")
	 private int id_related;
	 
	 @ManyToOne
	 @JoinColumn(name ="id_product", nullable = false, insertable = false, updatable = false)
	 private Product product;
	 
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductRelated() {
		super();
	}
	
	public ProductRelated(int id, int id_product, int id_related) {
		super();
		this.id = id;
		this.id_product = id_product;
		this.id_related = id_related;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public int getId_related() {
		return id_related;
	}
	public void setId_related(int id_related) {
		this.id_related = id_related;
	}
	
	@Override
	public String toString() {
	return "Product_related [id=" + id + ", id_product=" + id_product + ", id_related=" + id_related + "]";
	}
}
