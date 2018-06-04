package com.niit.ToysBackend.dao;

import java.util.List;

import com.niit.ToysBackend.model.User;

public interface UserDao {
	public boolean saveorupdateUser(User user);

	public boolean deleteUser(User user);

	public User getUser(String userId);

	public List<User> list();

	public User isValid(String umail, String pwd);

	public User getEmail(String currusername);


}
