package com.niit.ToysBackend.dao;

import java.util.List;

import com.niit.ToysBackend.model.Order;

public interface OrderDao
{
	public boolean saveorupdateOrder(Order order);

	public boolean deleteOrder(Order order);

	public Order getOrder(String OrderId);

	public List<Order> list();


}
