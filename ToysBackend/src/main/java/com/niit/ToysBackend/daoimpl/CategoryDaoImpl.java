package com.niit.ToysBackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.ToysBackend.dao.Categorydao;
import com.niit.ToysBackend.model.Category;
@Transactional
@Repository("categoryDao")
@EnableTransactionManagement

public class CategoryDaoImpl implements Categorydao {
	@Autowired
	SessionFactory sessionFactory;


	public CategoryDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}

	public boolean saveorupdateCategory(Category category) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
		
	}

	public boolean deleteCategory(Category category) {
		
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(category);
		return true;
	}

	public Category getCategory(String catId) {
		// TODO Auto-generated method stub
		String s="From Category Where catId='"+catId+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Category>list = (List<Category>)q.list();
		if(list==null||list.isEmpty())
		{
			System.out.println("Category list not found");
			return null;
		}
				
		
	else
	{
		System.out.println("Category list");
		return list.get(0);
	}
	}

	public List<Category> list() {
		// TODO Auto-generated method stub
		List<Category> Categories =(List<Category>)sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return Categories;
	}

}
