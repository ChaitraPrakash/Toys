package com.niit.ToysBackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.ToysBackend.dao.PayDao;
import com.niit.ToysBackend.model.Category;
import com.niit.ToysBackend.model.Pay;

@Transactional
@Repository("payDao")
@EnableTransactionManagement
public class PayDaoImpl implements PayDao{

	@Autowired
	SessionFactory sessionFactory;


	public PayDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}
	@Override
	public boolean saveorupdatePay(Pay pay) {
		sessionFactory.getCurrentSession().saveOrUpdate(pay);
		return true;
		
	}

	@Override
	public boolean deletePay(Pay pay) {
		// TODO Auto-generated method stub
				sessionFactory.getCurrentSession().delete(pay);
				return true;
	}

	@Override
	public Pay getPay(String payId) {
		String s="From Pay Where pay_Id='"+payId+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Pay>list = (List<Pay>)q.list();
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

	@Override
	public List<Pay> list() {
		List<Pay> pay =(List<Pay>)sessionFactory.getCurrentSession().createCriteria(Pay.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return pay;
	}

}
