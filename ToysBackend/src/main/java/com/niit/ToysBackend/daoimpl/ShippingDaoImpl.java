package com.niit.ToysBackend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ToysBackend.dao.ShippingDao;
import com.niit.ToysBackend.model.Shipping;

@Transactional
@Repository("shippingDao")
@EnableTransactionManagement

public class ShippingDaoImpl implements ShippingDao {
	@Autowired
	SessionFactory sessionFactory;

	public ShippingDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveorupdateShipping(Shipping shipping) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().saveOrUpdate(shipping);
		return true;
	}

	@Override
	public boolean deleteShipping(Shipping shipping) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().delete(shipping);
		return true;
	}

	@Override
	public Shipping getShipping(String ShippingId) {
		// TODO Auto-generated method stub
		String s = "From Shipping where shippingId='" + ShippingId + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(s);
		List<Shipping> list = (List<Shipping>) q.list();
		if (list == null || list.isEmpty()) {
			System.out.println("Shipping is Empty");
			return null;

		} else {
			System.out.println("Shipping Info");
			return list.get(0);
		}
	}

	@Override
	public List<Shipping> list() {
		// TODO Auto-generated method stub
		List<Shipping> list = (List<Shipping>) sessionFactory.getCurrentSession().createCriteria(Shipping.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}

	@Override
	public List<Shipping> getaddbyuser(String userId) {
		// TODO Auto-generated method stub
		String s = "From Shipping where userId='" + userId + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(s);
		List<Shipping> list = (List<Shipping>) q.list();
		if (list == null || list.isEmpty()) {
			System.out.println("Shipping is Empty");
			return null;

		} else {
			System.out.println("Shipping Info");
			return list;
		}
	}

}
