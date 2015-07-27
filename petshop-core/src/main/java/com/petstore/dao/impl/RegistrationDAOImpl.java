package com.petstore.dao.impl;

import javax.transaction.Transactional;

import com.petstore.dao.AbstractDAO;
import com.petstore.dao.RegistrationDAO;
import com.petstore.model.bo.User;

/**
 * DAO implementation class for Registration activites on DB Side.
 *
 * @version 1.0
 * @author analian (c) Jul 24, 2015, Sogeti B.V.
 */
public class RegistrationDAOImpl extends AbstractDAO<Integer, User> implements RegistrationDAO
{
   /*
    * (non-Javadoc)
    * @see com.petstore.dao.RegistrationDAO#registerNewUser(com.petstore.model.bo.User)
    */
   @Override
   @Transactional
   public void registerNewUser(User user)
   {
      entityManager.persist(user);
   }

}
