package com.petshop.user.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.petstore.model.bo.Product;

/**
 * @version 1.0
 * @author analian (c) Jul 27, 2015, Sogeti B.V.
 */
@ManagedBean(name = "shoppingCartBean")
@SessionScoped
public class ShoppingCartBean implements Serializable
{

   final static Logger log = Logger.getLogger(ShoppingCartBean.class);
   /**
    * <code>serialVersionUID</code> indicates/is used for.
    */
   private static final long serialVersionUID = 1L;

   private List<Product> addedToCartProducts = new ArrayList<Product>();

   private Map<Integer, ShoppingCartForm> cart = new HashMap<Integer, ShoppingCartForm>();

  
   /**
    * Method that adds the products to the Shopping Cart
    */
   public void addProductsToCart()
   {
      
      log.trace("Inside the add to cart method");
      if (getAddedToCartProducts() != null && !getAddedToCartProducts().isEmpty())

      {
         for (Product product : addedToCartProducts)
         {
            createShoppingCartView(product);
         }

      }
      log.debug(getAddedToCartProducts());
   }

   /**
    * Method that creates/updates the shopping cart after product
    * is added to the cart
    * 
    * @param p
    */
   private void createShoppingCartView(Product p)
   {
      ShoppingCartForm cartForm = new ShoppingCartForm();

      log.info("cart view creation" );
      if (cart.containsKey(p.getId()))
      {
         cartForm = cart.get(p.getId());
         cartForm.setQuantity(cartForm.getQuantity() + 1);
         cartForm.setTotalPrice(new BigDecimal(cartForm.getQuantity() * p.getPrice().intValue()));
         cartForm.setProductId(p.getId());
         
      }
      else
      {
         log.info("adding the product because it doesnt already exist");
         cartForm.setCategoryName(p.getCategory().getName());
         cartForm.setPricePerProduct(p.getPrice());
         cartForm.setProductName(p.getName());
         cartForm.setQuantity(1);
         cartForm.setProductId(p.getId());
         cartForm.setTotalPrice(new BigDecimal(cartForm.getQuantity() * p.getPrice().intValue()));
         cart.put(p.getId(), cartForm);
      }
   }

   /**
    * Get the addedToCartProducts.
    *
    * @return Returns the addedToCartProducts as a List<Product>.
    */
   public List<Product> getAddedToCartProducts()
   {
      return addedToCartProducts;
   }

   /**
    * Set the addedToCartProducts to the specified value.
    *
    * @param addedToCartProducts The addedToCartProducts to set.
    */
   public void setAddedToCartProducts(List<Product> addedToCartProducts)
   {
      this.addedToCartProducts = addedToCartProducts;
   }

   /**
    * Get the serialversionuid.
    *
    * @return Returns the serialversionuid as a long.
    */
   public static long getSerialversionuid()
   {
      return serialVersionUID;
   }
   
   /**
    * Get the cart.
    *
    * @return Returns the cart as a Map<Integer,LineItem>.
    */
   public Map<Integer, ShoppingCartForm> getCart()
   {
      return cart;
   }

   /**
    * Set the cart to the specified value.
    *
    * @param cart The cart to set.
    */
   public void setCart(Map<Integer, ShoppingCartForm> cart)
   {
      this.cart = cart;
   }

}
