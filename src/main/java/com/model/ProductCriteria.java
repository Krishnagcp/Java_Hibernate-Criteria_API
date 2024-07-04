package com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class ProductCriteria {
	
	@SuppressWarnings("unchecked")

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Criteria criteria = session.createCriteria(Product.class);
		List< Product > prodList = criteria.list();
		System.out.println("All Products List :");
		for(Product prod: prodList) {
			System.out.println(prod.getSlno()+" "+ prod.pname+" "+prod.qty+" "+prod.price);
		}
		
		System.out.println("---------------------------------");
		System.out.println("Products with price > 500 : ");
		prodList = (List<Product>) session.createCriteria(Product.class).add(Restrictions.gt("price",500)).list();
		for(Product p1 : prodList) {
			System.out.println(p1.getPname());
		}
		
		System.out.println("---------------------------------");
		System.out.println("Products with Quantities > 10pcs");
		prodList = (List<Product>) session.createCriteria(Product.class).add(Restrictions.gt("qty",10)).list();
		for(Product p2 : prodList) {
			System.out.println(p2.getPname());
		}
		
		System.out.println("---------------------------------");
		Criteria c = session.createCriteria(Product.class);
		c.setProjection(Projections.rowCount());
		prodList = (List<Product>) c.add(Restrictions.gt("slno",0)).list();
		System.out.println("No of products Available : " + prodList.getLast());
		
		
		System.out.println("---------------------------------");
		Criteria d = session.createCriteria(Product.class);
		prodList = d.setProjection(Projections.min("price")).list();
		System.out.println("Lowest Amount Product " + prodList.getFirst());
		
		System.out.println("---------------------------------");
		Criteria e = session.createCriteria(Product.class);
		prodList = e.setProjection(Projections.max("price")).list();
		System.out.println("Highest Amount Product " + prodList.getFirst());
		
		
		System.out.println("---------------------------------");
		Criteria f = session.createCriteria(Product.class);
		prodList = f.setProjection(Projections.sum("price")).list();
		System.out.println("Sum of All Product's Price : " + prodList.getFirst());
		
		
		//Rollback transaction to avoid messing test data
		tr.commit();
		//closing hibernate resources
		sessionFactory.close();

		
	}

}
