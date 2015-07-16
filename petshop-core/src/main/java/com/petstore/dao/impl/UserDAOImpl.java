package com.petstore.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.petstore.constants.Constants;
import com.petstore.dao.AbstractDAO;
import com.petstore.dao.UserDAO;
import com.petstore.model.bo.User;

/**
 * Implementation class for 
 * User DAO
 * 
 * @author analian
 *
 */
public class UserDAOImpl extends AbstractDAO<Integer, User> 
								implements UserDAO  
{
	
	/**
	 * Logger for UserDAOImpl
	 */
	final static Logger log = Logger.getLogger(UserDAOImpl.class);
	
	/* (non-Javadoc)
	 * @see com.petstore.dao.UserDAO#getLoginDetails(java.lang.String, java.lang.String)
	 */
	@Override
	public User getLoginDetails(String user, String password) 
	{
		 Query query = entityManager.createQuery(Constants.SELECT_USER_SQL_STRING
				 						+ user + "' and u.password = '" + password + "'" );
		 log.debug("Login validation");
		 @SuppressWarnings("unchecked")
		List<User> users = (List<User>)query.getResultList();
		 if(users!=null && !users.isEmpty())
	       {
				 if(users.size()==1)
				 {
					 return users.get(0);
				 }
	       }
		 return null;
	 }
}
