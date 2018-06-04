package com.niit.ToysBackend.dao;

import java.util.List;

import com.niit.ToysBackend.model.Product;

public interface ProductDao {
public boolean saveorupdateProduct(Product product);
public boolean deleteProduct(Product product);
public Product getProduct(String productId);
public List<Product>list();


}
