package com.petshop.user.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.primefaces.event.RowEditEvent;

import com.petshop.user.bean.ShoppingCartBean;
import com.petshop.user.bean.ShoppingCartForm;
import com.petshop.user.bean.UserLoginBean;
import com.petstore.constants.Constants;
import com.petstore.model.bo.LineItem;
import com.petstore.model.bo.Orders;
import com.petstore.model.bo.User;
import com.petstore.service.LoginService;
import com.petstore.service.ShoppingCartService;

/**
 * Controller class that handles the shopping cart changes like changing the no of products, editing and deleting products in the cart, etc.
 *
 * @version 1.0
 * @author analian (c) Jul 28, 2015, Sogeti B.V.
 */
@ManagedBean
@SessionScoped
public class ShoppingCartController implements Serializable
{
   /**
    * <code>user</code> indicates/is used for.
    */
   public User user;

   /**
    * <code>loginService</code> indicates/is used for.
    */
   @Inject
   LoginService loginService;

   /**
    * <code>shoppingCartService</code> indicates/is used for.
    */
   @Inject
   ShoppingCartService shoppingCartService;

   /**
    * <code>loginBean</code> indicates/is used for.
    */
   @ManagedProperty(value = "#{userLogin}")
   UserLoginBean loginBean;

   /**
    * <code>log</code> indicates/is used for.
    */
   final static Logger log = Logger.getLogger(ShoppingCartController.class);

   /**
    * <code>serialVersionUID</code> indicates/is used for.
    */
   private static final long serialVersionUID = 1L;

   /**
    * <code>bean</code> indicates/is used for.
    */
   @ManagedProperty(value = "#{shoppingCartBean}")
   ShoppingCartBean bean;

   /**
    * Method that handles the update on the shopping cart - 
    * single product row. Handles the change in the no of products.
    * 
    * @param editEvent
    */
   public void updateCartDetails(RowEditEvent editEvent)
   {
      ShoppingCartForm form = (ShoppingCartForm) editEvent.getObject();
      form.setTotalPrice(new BigDecimal(form.getQuantity()).multiply(form.getPricePerProduct()));
      bean.getCart().put(form.getProductId(), form);
   }

   /**
    * Method that handles the update on the shopping cart - single product row. Handles the delete of a row on the table.
    * 
    * @param editEvent
    */
   public void deleteCartItem(RowEditEvent editEvent)
   {
      log.debug("The edit event object" + editEvent.getObject());
      ShoppingCartForm form = (ShoppingCartForm) editEvent.getObject();
      bean.getCart().remove(form.getProductId());
   }

   /**
    * Handles the user button click to confirm the user order and place it.
    */
   public String confirmOrder()
   {
      log.debug("inside the confirm order method");
      if (loginBean.isRegisteredUser())
      {
         setUser(loginService.getUserObj());
      }
      else
      {
         setUser(new User());
      }
      
      return Constants.ORDER_CONFIRMATION_PAGE_STRING;
   }

   /**
    * Method called when the user wants to place the order.
    * 
    * @return
    */
   public String placeOrder()
   {
      Map<Integer, ShoppingCartForm> cart = bean.getCart();
      List<LineItem> lineItemsSet = new ArrayList<LineItem>();
      
      try
      {
         Orders order = createNewOrderObject(cart, lineItemsSet);
         shoppingCartService.saveNewOrder(order);
      }
      catch (Exception e)
      {
         FacesMessage msg = new FacesMessage("Error occurred while placing Order...", "Please Try Again Later!");
         FacesContext.getCurrentInstance().addMessage(null, msg);
         return null;
      }
      
      FacesMessage msg = new FacesMessage("Thank You for placing Order...", "Please Visit Again Later!");
      FacesContext.getCurrentInstance().addMessage(null, msg);
      return "thankYouPage";
   }

   /**
    *  Refactored private method
    *  to create the order object for the user.
    *  
    * @param cart
    * @param lineItemsSet
    * @return
    */
   private Orders createNewOrderObject(Map<Integer, ShoppingCartForm> cart, List<LineItem> lineItemsSet)
   {
      Orders order = new Orders();
      
      for (Entry<Integer, ShoppingCartForm> entry : cart.entrySet())
      {
         ShoppingCartForm cartItem = entry.getValue();
         LineItem item = new LineItem();
         item.setAmount(cartItem.getTotalPrice().intValueExact());
         item.setNo_of_products(cartItem.getQuantity());
         item.setProduct_id(cartItem.getProductId());
         item.setOrder(order);
         lineItemsSet.add(item);
      }
      
      order.setCity(getUser().getCity());
      order.setLineItems(lineItemsSet);
      order.setOrder_date(new Date());
      order.setPin(getUser().getPin());
      order.setShipping_address(getUser().getAddress());
      order.setStatus(Constants.ORDER_STATUS_PLACED);
      order.setUser(getUser());
      return order;
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

   /**
    * Get the user.
    *
    * @return Returns the user as a User.
    */
   public User getUser()
   {
      return this.user;
   }

   /**
    * Set the user to the specified value.
    *
    * @param user The user to set.
    */
   public void setUser(User user)
   {
      this.user = user;
   }

   /**
    * Get the loginBean.
    *
    * @return Returns the loginBean as a UserLoginBean.
    */
   public UserLoginBean getLoginBean()
   {
      return loginBean;
   }

   /**
    * Set the loginBean to the specified value.
    *
    * @param loginBean The loginBean to set.
    */
   public void setLoginBean(UserLoginBean loginBean)
   {
      this.loginBean = loginBean;
   }
}
