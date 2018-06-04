package com.niit.ToysBackend.dao;

import java.util.List;

import com.niit.ToysBackend.model.Billing;

public interface BillingDao {
	public boolean saveorupdateBilling(Billing billing);

	public boolean deleteBilling(Billing billing);

	public Billing getBilling(String billingId);

	public List<Billing> list();

}
