package com.niit.ToysBackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.ToysBackend.dao.AuthenticationDao;
import com.niit.ToysBackend.dao.BillingDao;
import com.niit.ToysBackend.dao.CartDao;
import com.niit.ToysBackend.dao.CartItemsDao;
import com.niit.ToysBackend.dao.Categorydao;
import com.niit.ToysBackend.dao.OrderDao;
import com.niit.ToysBackend.dao.OrderItemsDao;
import com.niit.ToysBackend.dao.ProductDao;
import com.niit.ToysBackend.dao.ShippingDao;
import com.niit.ToysBackend.dao.SupplierDao;
import com.niit.ToysBackend.dao.UserDao;
import com.niit.ToysBackend.daoimpl.AuthenticationDaoImpl;
import com.niit.ToysBackend.daoimpl.BillingDaoImpl;
import com.niit.ToysBackend.daoimpl.CartDaoImpl;
import com.niit.ToysBackend.daoimpl.CartItemsDaoImpl;
import com.niit.ToysBackend.daoimpl.CategoryDaoImpl;
import com.niit.ToysBackend.daoimpl.OrderDaoImpl;
import com.niit.ToysBackend.daoimpl.OrderItemsDaoImpl;
import com.niit.ToysBackend.daoimpl.ProductDaoImpl;
import com.niit.ToysBackend.daoimpl.ShippingDaoImpl;
import com.niit.ToysBackend.daoimpl.SupplierDaoimpl;
import com.niit.ToysBackend.daoimpl.UserDaoImpl;
import com.niit.ToysBackend.model.Authentication;
import com.niit.ToysBackend.model.Billing;
import com.niit.ToysBackend.model.Cart;
import com.niit.ToysBackend.model.CartItems;
import com.niit.ToysBackend.model.Category;
import com.niit.ToysBackend.model.Order;
import com.niit.ToysBackend.model.OrderItems;
import com.niit.ToysBackend.model.Product;
import com.niit.ToysBackend.model.Shipping;
import com.niit.ToysBackend.model.Supplier;
import com.niit.ToysBackend.model.User;

@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement

public class ApplicationContext {

	@Bean("dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test/Toys");
		dataSource.setUsername("Lavender");
		dataSource.setPassword("mylife");
		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.connection.pool_size", "10");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}

	@Autowired
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(CartItems.class);
		sessionBuilder.addAnnotatedClass(Order.class);
		sessionBuilder.addAnnotatedClass(OrderItems.class);
		sessionBuilder.addAnnotatedClass(Shipping.class);
		sessionBuilder.addAnnotatedClass(Authentication.class);
		sessionBuilder.addAnnotatedClass(Billing.class);
		
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean("transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	@Autowired
	@Bean("categoryDao")
	public Categorydao getCategoryDao(SessionFactory sessionFactory) {
		return new CategoryDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("userDao")
	public UserDao getUserDao(SessionFactory sessionFactory) {
		return new UserDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("productDao")
	public ProductDao getProductDao(SessionFactory sessionFactory) {
		return new ProductDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("supplierDao")
	public SupplierDao getSupplierDao(SessionFactory sessionFactory) {
		return new SupplierDaoimpl(sessionFactory);
	}

	@Autowired
	@Bean("cartDao")
	public CartDao getCartDao(SessionFactory sessionFactory) {
		return new CartDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("authenticationDao")
	public AuthenticationDao getAuthenticationDao(SessionFactory sessionFactory) {
		return new AuthenticationDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("cartItemsDao")
	public CartItemsDao getCartItemsDao(SessionFactory sessionFactory) {
		return new CartItemsDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("billingDao")
	public BillingDao getbillingDao(SessionFactory sessionFactory) {
		return new BillingDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("orderDao")
	public OrderDao getOrderDao(SessionFactory sessionFactory) {
		return new OrderDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("orderItemsDao")
	public OrderItemsDao getOrderItemsDao(SessionFactory sessionFactory) {
		return new OrderItemsDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("shippingDao")
	public ShippingDao getShippingDao(SessionFactory sessionFactory) {
		return new ShippingDaoImpl(sessionFactory);
	}


	



}
