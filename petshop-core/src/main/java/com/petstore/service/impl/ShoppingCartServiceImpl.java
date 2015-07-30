/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: analian
 ** Copyright: (c) Jul 29, 2015 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.petstore.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.petstore.dao.ShoppingCartDAO;
import com.petstore.model.bo.Orders;
import com.petstore.service.ShoppingCartService;

/**
 * ????
 *
 * @version $Id:$
 * @author analian (c) Jul 29, 2015, Sogeti B.V.
 */
@Stateless
public class ShoppingCartServiceImpl implements ShoppingCartService
{
   /**
    * <code>shoppingCartDAO</code> indicates/is used for.
    */
   @Inject
   ShoppingCartDAO shoppingCartDAO;

   /**
    * <code>log</code> indicates/is used for.
    */
   final static Logger log = Logger.getLogger(ShoppingCartServiceImpl.class);
   
   /*
    * (non-Javadoc)
    * @see com.petstore.service.ShoppingCartService#saveNewOrder(com.petstore.model.bo.Orders)
    */
   @Override
   public void saveNewOrder(Orders order)
   {
      log.info("Inside the save new order dao method" + order);
      shoppingCartDAO.saveShoppingOrder(order);
   }

}
