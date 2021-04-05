package com.duongvietanh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.duongvietanh.model.Product;

@Transactional
@Repository
public class ProductDAOImpl implements ProductDAO {
	private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")

	public List<Product> listProducts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> productsList = session.createQuery("from Product").list();
		for (Product p : productsList) {
			logger.info("Product List::" + p);
		}
		return productsList;
	}
	@SuppressWarnings("unchecked")

	public List<Product> listCategoryWomen() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> productsList = session.createQuery("from Product WHERE category='women' AND new_product = true").list();
		for (Product p : productsList) {
			logger.info("Product List::" + p);
		}
		return productsList;
	}
	@SuppressWarnings("unchecked")

	public List<Product> listCategoryMen() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> productsList = session.createQuery("from Product WHERE category='men' AND new_product = true").list();
		for (Product p : productsList) {
			logger.info("Product List::" + p);
		}
		return productsList;
	}
	@SuppressWarnings("unchecked")

	public List<Product> listTrend() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> productsList = session.createQuery("from Product WHERE hot_trend = true").list();
		for (Product p : productsList) {
			logger.info("Product List::" + p);
		}
		return productsList;
	}
	public Product getProduct(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Product p = (Product) session.load(Product.class, new Integer(id));
		logger.info("Product loaded successfully, Product details=" + p);
		return p;
	}
	
	@SuppressWarnings("unchecked")
	public void insertProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(product);
		logger.info("Product saved successfully, Product Details=" + product);
	}
	
	public void deleteProduct(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		 String sql = "delete from Product WHERE id=" + id +"";
		 Query query = session.createQuery(sql);
		 int row = query.executeUpdate();
         if (row == 0)
             System.out.println("Doesnt deleted any row!");
         else
             System.out.println("Deleted Row: " + row);
	}
	
}