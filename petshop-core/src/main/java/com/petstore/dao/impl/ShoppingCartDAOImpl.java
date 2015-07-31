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
package com.petstore.dao.impl;

import javax.transaction.Transactional;

import com.petstore.dao.AbstractDAO;
import com.petstore.dao.ShoppingCartDAO;
import com.petstore.model.bo.Orders;
import com.petstore.model.bo.User;

/**
 * 
 *
 * @version 1.0
 * @author analian (c) Jul 29, 2015, Sogeti B.V.
 */
public class ShoppingCartDAOImpl extends AbstractDAO<Integer, Orders>  implements ShoppingCartDAO
{

   @Override
   @Transactional
   public void saveShoppingOrder(Orders order)
   {
     User user =  entityManager.find(User.class, order.getUser().getUser_id());
     
     if(user!=null)
     {
        order.setUser(user);
        order.setUser_id(user.getUser_id());
     }
      entityManager.persist(order);
   }

}
