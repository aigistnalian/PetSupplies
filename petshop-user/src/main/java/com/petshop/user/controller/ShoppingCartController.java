package com.petshop.user.controller;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import org.primefaces.event.RowEditEvent;

import com.petshop.user.bean.ShoppingCartBean;
import com.petshop.user.bean.ShoppingCartForm;

/**
 * Controller class that handles
 * the shopping cart changes like changing the 
 * no of products, editing and deleting products 
 * in the cart, etc.
 *
 * @version 1.0
 * @author analian (c) Jul 28, 2015, Sogeti B.V.
 */ 
@ManagedBean
@SessionScoped
public class ShoppingCartController implements Serializable
{
   
   final static Logger log = Logger.getLogger(ShoppingCartController.class);
   
   /**
    * <code>serialVersionUID</code> indicates/is used for.
    */
   private static final long serialVersionUID = 1L;
   
   /**
    * <code>bean</code> indicates/is used for.
    */
   @ManagedProperty(value="#{shoppingCartBean}")
   ShoppingCartBean bean;
   
   /**
    * Method that handles the update on the 
    * shopping cart - single product row.
    * Handles the change in the no of products.
    * @param editEvent
    */
   public void updateCartDetails(RowEditEvent editEvent)
   {
        ShoppingCartForm form = (ShoppingCartForm) editEvent.getObject();
        form.setTotalPrice(new BigDecimal(form.getQuantity()).multiply(form.getPricePerProduct()));
        bean.getCart().put(form.getProductId(), form);
   }
   
   /**
    * Method that handles the update on the 
    * shopping cart - single product row.
    * Handles the delete of a row on the table.
    * 
    * @param editEvent
    */
   public void deleteCartItem(RowEditEvent editEvent){
     log.debug("The edit event object" + editEvent.getObject());
      ShoppingCartForm form = (ShoppingCartForm) editEvent.getObject();
      bean.getCart().remove(form.getProductId());
   }

   /**
    * Handles the user button click to confirm
    * the user order and place it.
    */
   public void confirmOrder(){
    log.debug("inside the confirm order method");
   }
   /**
    * Get the bean.
    *
    * @return Returns the bean as a ShoppingCartBean.
    */
   public ShoppingCartBean getBean()
   {
      return bean;
   }

   /**
    * Set the bean to the specified value.
    *
    * @param bean The bean to set.
    */
   public void setBean(ShoppingCartBean bean)
   {
      this.bean = bean;
   }
}
