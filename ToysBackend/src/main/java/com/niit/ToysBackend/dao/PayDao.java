package com.niit.ToysBackend.dao;

import java.util.List;

import com.niit.ToysBackend.model.Pay;

public interface PayDao {

	public boolean saveorupdatePay(Pay pay);

	public boolean deletePay(Pay pay);

	public Pay getPay(String payId);

	public List<Pay> list();

}
