package com.duongvietanh.dao;

import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.duongvietanh.model.Product; 
import com.duongvietanh.model.ProductRelated;

import java.util.*;
import javax.persistence.TypedQuery;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

@Transactional
@Repository
public class ProductRelatedDAOImpl implements ProductRelatedDAO{
	private static final Logger logger = LoggerFactory.getLogger(ProductRelatedDAOImpl.class);
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> listProductRelated(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();	
		List<Product> productlelated = session.createQuery("from Product p WHERE id in(select id_product from p.productRelateds where id_related =" + id + ")").list();
		return productlelated;		
	}
	
}
