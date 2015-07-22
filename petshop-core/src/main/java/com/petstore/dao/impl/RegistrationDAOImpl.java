package com.petstore.dao.impl;

import javax.transaction.Transactional;

import com.petstore.dao.AbstractDAO;
import com.petstore.dao.RegistrationDAO;
import com.petstore.model.bo.User;

/**
 * @author analian
 *
 */
public class RegistrationDAOImpl
extends AbstractDAO<Integer, User> implements RegistrationDAO 
{
	/* (non-Javadoc)
	 * @see com.petstore.dao.RegistrationDAO#registerNewUser(com.petstore.model.bo.User)
	 */
	@Override
	@Transactional
	public void registerNewUser(User user) 
	{
		entityManager.persist(user);
	}

}
