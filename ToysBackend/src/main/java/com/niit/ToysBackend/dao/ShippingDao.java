package com.niit.ToysBackend.dao;

import java.util.List;

import com.niit.ToysBackend.model.Shipping;

public interface ShippingDao
{
	public boolean saveorupdateShipping(Shipping shipping);

	public boolean deleteShipping(Shipping shipping);

	public Shipping getShipping(String ShippingId);

	public List<Shipping> list();

	public List<Shipping> getaddbyuser(String userId);


}
