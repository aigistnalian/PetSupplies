package com.petstore.service;

import com.petstore.model.bo.User;


/**
 * Interface for the Service layer
 * For the login level services/business logic
 * @author analian
 *
 */

public interface LoginService 
{

	/**
	 * for validating the admin user login credentials
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	boolean validateAdminUserLogin(String userId, String password);
	
	/**
	 * @param userName
	 * @param password
	 * @return
	 */
	boolean validateUserLogin(String userName, String password);
	
	User getUserObj();
}
