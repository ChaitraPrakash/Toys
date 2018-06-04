package com.niit.ToysBackend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ToysBackend.dao.ProductDao;
import com.niit.ToysBackend.model.Category;
import com.niit.ToysBackend.model.Product;

@Transactional
@Repository("productDao")
@EnableTransactionManagement
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;


	public ProductDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}
	@Override
	public boolean saveorupdateProduct(Product product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;
		
	}

	@Override
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(product);
		return true;
	}
	

	@Override
	public Product getProduct(String productId) {
		// TODO Auto-generated method stub
		String s="From Product Where productId='"+productId+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Product>list = (List<Product>)q.list();
		if(list==null||list.isEmpty())
		{
			System.out.println("Product list not found");
			return null;
		}
				
		
	else
	{
		System.out.println("Product list");
		return list.get(0);
		
	}
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		List<Product> Products =(List<Product>)sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return Products;
		
	}
	
	
	

}
