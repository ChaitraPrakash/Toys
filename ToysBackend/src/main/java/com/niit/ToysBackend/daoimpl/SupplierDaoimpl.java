package com.niit.ToysBackend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ToysBackend.dao.SupplierDao;
import com.niit.ToysBackend.model.Category;
import com.niit.ToysBackend.model.Supplier;

@Transactional
@Repository("supplierDao")
@EnableTransactionManagement

public class SupplierDaoimpl implements SupplierDao {
	@Autowired
	SessionFactory sessionFactory;


	public SupplierDaoimpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean saveorupdateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;
	}

	@Override
	public boolean deleteSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(supplier);
		return true;
		}

	@Override
	public Supplier getSupplier(String supplierId) {
		// TODO Auto-generated method stub
		String s ="From Supplier Where supplierId='"+supplierId+"'";
		Query q = sessionFactory.getCurrentSession().createQuery(s);
		List<Supplier>list = (List<Supplier>)q.list();
		if(list==null||list.isEmpty())
		{
			System.out.println("Supplier list not found");
	        return null;
	}
		else
		{
			System.out.println("Supplier list");
			return list.get(0);
		}
	}

	@Override
	public List<Supplier> list() {
		// TODO Auto-generated method stub
		List<Supplier> Suppliers =(List<Supplier>)sessionFactory.getCurrentSession().createCriteria(Supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return Suppliers;
	}

}
