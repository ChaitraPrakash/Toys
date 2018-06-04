package com.niit.ToysBackend.dao;

import java.util.List;

import com.niit.ToysBackend.model.Supplier;

public interface SupplierDao {
	public boolean saveorupdateSupplier(Supplier supplier);

	public boolean deleteSupplier(Supplier supplier);

	public Supplier getSupplier(String supplierId);

	public List<Supplier> list();

}
