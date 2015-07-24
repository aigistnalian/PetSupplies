/**
 * 
 */
package com.petstore.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.petstore.dao.RegistrationDAO;
import com.petstore.model.bo.User;
import com.petstore.service.RegistrationService;


/**
 * ????
 *
 * @version $Id:$
 * @author analian (c) Jul 24, 2015, Sogeti B.V.
 */ 
@Stateless
public class RegistrationServiceImpl implements RegistrationService
{
   /**
	 * 
	 */
   @Inject
   RegistrationDAO registrationDAO;

   /*
    * (non-Javadoc)
    * @see com.petstore.service.RegistrationService#registerNewUser(com.petstore.model.bo.User)
    */
   @Override
   @Transactional
   public void registerNewUser(User user)
   {

      registrationDAO.registerNewUser(user);
   }

}
