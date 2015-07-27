/**
 * 
 */
package com.petstore.service;

import com.petstore.model.bo.User;


/**
 * Interface implemented for registration activities
 *
 * @version 1.0
 * @author analian (c) Jul 24, 2015, Sogeti B.V.
 */ 
public interface RegistrationService
{
   void registerNewUser(User user);
}
