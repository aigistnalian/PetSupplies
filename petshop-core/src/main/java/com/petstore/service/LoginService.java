package com.petstore.service;


/**
 * Interface for the Service layer
 * For the login level services/business logic
 * @author analian
 *
 */

public interface LoginService 
{

	/**
	 * for validating the user login credentials
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	boolean validateAdminUserLogin(String userId, String password);
	
}
