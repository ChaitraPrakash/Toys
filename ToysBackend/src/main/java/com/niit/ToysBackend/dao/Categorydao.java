package com.niit.ToysBackend.dao;

import java.util.List;

import com.niit.ToysBackend.model.Category;

public interface Categorydao {
	public boolean saveorupdateCategory(Category category);

	public boolean deleteCategory(Category category);

	public Category getCategory(String catId);

	public List<Category> list();

}
