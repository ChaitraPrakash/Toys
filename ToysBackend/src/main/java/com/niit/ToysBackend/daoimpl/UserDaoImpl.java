package com.niit.ToysBackend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ToysBackend.dao.UserDao;
import com.niit.ToysBackend.model.Authentication;
import com.niit.ToysBackend.model.User;

@Transactional
@Repository("userDao")
@EnableTransactionManagement
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveorupdateUser(User user) {
		// TODO Auto-generated method stub
		Authentication auth=new Authentication();
		auth.setUserName(user.getEmail_Id());
		user.getBilling().setUser(user);
		user.getBilling().setPhone_No(user.getPhoneNumber());
		user.getBilling().setAddress(user.getAddress());
		sessionFactory.getCurrentSession().saveOrUpdate(user.getCart());
		sessionFactory.getCurrentSession().saveOrUpdate(user.getBilling());
		sessionFactory.getCurrentSession().saveOrUpdate(auth);
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		String s = "From User Where userId='" + userId + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(s);
		List<User> list = (List<User>) q.list();
		if (list == null || list.isEmpty()) {
			System.out.println("User list not found");
			return null;
		} else {
			System.out.println("User list");
			return list.get(0);
		}
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		List<User> Users = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return Users;
	}

	@Override
	public User isValid(String umail, String pwd) {
		//TODO Auto-generated method stub
		String s="From User Where email_Id' "+ umail +" ' and password='"+pwd+"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		List<User> list=(List<User>) q.list();
		if(list==null || list.isEmpty())
		{
			System.out.println("User List NotFound");
			return null;
		}
		else
		{
			System.out.println("User List");
		     return list.get(0);
		}
	}

	@Override
	public User getEmail(String currusername) {
		// TODO Auto-generated method stub
		String s="From User Where email_Id= '" +currusername +"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		List<User> list=(List<User>) q.list();
		if(list==null || list.isEmpty())
		{
			System.out.println("User List NotFound");
			return null;
		}
		else
		{
			System.out.println("User List");
		     return list.get(0);
		}
		
	}

}
