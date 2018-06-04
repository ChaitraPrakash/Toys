package com.niit.ToysBackend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ToysBackend.dao.AuthenticationDao;
import com.niit.ToysBackend.model.Authentication;
import com.niit.ToysBackend.model.Authentication;
@Transactional
@Repository("authenticationDao")
@EnableTransactionManagement
public class AuthenticationDaoImpl implements AuthenticationDao {
	@Autowired
	SessionFactory sessionFactory;

	public AuthenticationDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveorupdateAuthentication(Authentication authentication) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().saveOrUpdate(authentication);
		return true;
	}

	@Override
	public boolean deleteAuthentication(Authentication authentication) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().delete(authentication);
		return true;
	}

	@Override
	public Authentication getAuthentication(String AuthenticationId) {
		// TODO Auto-generated method stub
		String s = "From Authentication where roleId='" + AuthenticationId + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(s);
		List<Authentication> list = (List<Authentication>) q.list();
		if (list == null || list.isEmpty()) {
			System.out.println("Authentication is Empty");
			return null;

		} else {
			System.out.println("Authentication Info");
			return list.get(0);
		}
	}

	@Override
	public List<Authentication> list() {
		// TODO Auto-generated method stub
		List<Authentication> list = (List<Authentication>) sessionFactory.getCurrentSession().createCriteria(Authentication.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}

}
