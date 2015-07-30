package com.petstore.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.petstore.dao.UserDAO;
import com.petstore.model.bo.User;
import com.petstore.service.LoginService;

/**
 * Stateless class so that CDI can inject
 * the service class in bean
 * Acts as EJB Business layer
 * 
 * @author analian
 *
 */
@Stateless
public class LoginServiceImpl implements LoginService
{

	/**
	 * Logger for the Login Service implementation class.
	 */
	final static Logger log = Logger.getLogger(LoginServiceImpl.class);
	
	/**
	 * DAO Class injected to interact with the USER table.
	 */
	@Inject
	UserDAO userDAO;
	
	public User userObj;
	
	
   /* (non-Javadoc)
	 * @see com.petstore.service.LoginService#validateAdminUserLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean validateAdminUserLogin(String userId, String password) 
	{
		boolean isUserValid = false; 
		User user = userDAO.getLoginDetails(userId, password);
		log.debug("Getting the user for -->" + userId);
		if(user!=null)
		{
			if(user.isAdminUser())
			{
				isUserValid = true;
			}
		}
		log.debug("returning after login -->"+ isUserValid);
		return isUserValid;
	}

	/* (non-Javadoc)
	 * @see com.petstore.service.LoginService#validateUserLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean validateUserLogin(String userName, String password) 
	{
		boolean isUserValid = false; 
		User user = userDAO.getLoginDetails(userName, password);
		log.debug("Getting the user for -->" + userName);
		if(user!=null)
		{
			if(!user.isAdminUser())
			{
				isUserValid = true;
			}
			
			setUserObj(user);
		}
		log.debug("returning after login -->"+ isUserValid);
		return isUserValid;
	}
	
	/**
    * Get the userObj.
    *
    * @return Returns the userObj as a User.
    */
   public User getUserObj()
   {
      return userObj;
   }

   /**
    * Set the userObj to the specified value.
    *
    * @param userObj The userObj to set.
    */
   public void setUserObj(User userObj)
   {
      this.userObj = userObj;
   }

}
