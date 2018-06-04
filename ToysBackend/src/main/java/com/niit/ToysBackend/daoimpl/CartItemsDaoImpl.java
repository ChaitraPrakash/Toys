package com.niit.ToysBackend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ToysBackend.dao.CartItemsDao;
import com.niit.ToysBackend.model.CartItems;
@Transactional
@Repository("cartItemsDao")
@EnableTransactionManagement

public class CartItemsDaoImpl implements CartItemsDao {
	@Autowired
	SessionFactory sessionFactory;

	public CartItemsDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveorupdateCartItems(CartItems cartItems) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().saveOrUpdate(cartItems);
		return true;
	}

	@Override
	public boolean deleteCartItems(CartItems cartItems) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().delete(cartItems);
		return true;
	}

	@Override
	public CartItems getCartItems(String cartItemsId) {
		// TODO Auto-generated method stub
		String s = "From CartItems where cartItemsId='" + cartItemsId + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(s);
		List<CartItems> list = (List<CartItems>) q.list();
		if (list == null || list.isEmpty()) {
			System.out.println("CartItems is Empty");
			return null;

		} else {
			System.out.println("CartItems Info");
			return list.get(0);
		}
	}

	@Override
	public List<CartItems> list() {
		// TODO Auto-generated method stub
		List<CartItems> list = (List<CartItems>) sessionFactory.getCurrentSession().createCriteria(CartItems.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}

	@Override
	public List<CartItems> getlist(String cartId) {
		// TODO Auto-generated method stub
		String s = "From CartItems where cartId='" + cartId + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(s);
		List<CartItems> list = (List<CartItems>) q.list();
		if (list == null || list.isEmpty()) {
			System.out.println("CartItems is Empty");
			return null;

		} else {
			System.out.println("CartItems Info");
			return list;
		}
	}

}
