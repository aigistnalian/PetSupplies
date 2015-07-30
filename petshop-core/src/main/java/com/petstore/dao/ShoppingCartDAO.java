package com.petstore.dao;

import com.petstore.model.bo.Orders;

/**
 * ????
 *
 * @version $Id:$
 * @author analian (c) Jul 29, 2015, Sogeti B.V.
 */ 
public interface ShoppingCartDAO extends DAO<Integer, Orders> 
{
   void saveShoppingOrder(Orders order);
}
