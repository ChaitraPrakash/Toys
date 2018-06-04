package com.niit.ToysBackend.dao;

import java.util.List;

import com.niit.ToysBackend.model.OrderItems;

public interface OrderItemsDao
{
	public boolean saveorupdateOrderItems(OrderItems orderItems);

	public boolean deleteOrderItems(OrderItems ordeItems);

	public OrderItems getOrderItems(String OrderItemsId);

	public List<OrderItems> list();

}
