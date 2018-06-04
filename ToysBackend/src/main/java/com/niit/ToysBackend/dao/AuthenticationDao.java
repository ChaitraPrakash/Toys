package com.niit.ToysBackend.dao;

import java.util.List;

import com.niit.ToysBackend.model.Authentication;

public interface AuthenticationDao
{
	
	public boolean saveorupdateAuthentication(Authentication authentication);

	public boolean deleteAuthentication(Authentication authentication);

	public Authentication getAuthentication(String roleId);

	public List<Authentication> list();


}
