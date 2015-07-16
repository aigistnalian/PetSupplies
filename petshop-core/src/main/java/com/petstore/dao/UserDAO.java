package com.petstore.dao;

import com.petstore.model.bo.User;

/**
 * Login related dao
 * 
 * @author analian
 *
 */
public interface UserDAO extends DAO<Integer, User> 
{

	/**
	 * getting/validating login details.
	 * 
	 * @param user
	 * @param password
	 * @return
	 */
	User getLoginDetails(String user, String password);
}
