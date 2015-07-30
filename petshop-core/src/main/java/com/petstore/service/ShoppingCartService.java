package com.petstore.service;

import com.petstore.model.bo.Orders;

/**
 * 
 *
 * @version $Id:$
 * @author analian (c) Jul 30, 2015, Sogeti B.V.
 */ 
public interface ShoppingCartService
{
   void saveNewOrder(Orders orders);
}
