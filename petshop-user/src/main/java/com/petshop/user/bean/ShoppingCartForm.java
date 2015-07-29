package com.petshop.user.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * ????
 *
 * @version $Id:$
 * @author analian (c) Jul 28, 2015, Sogeti B.V.
 */ 
public class ShoppingCartForm implements Serializable
{

   /**
    * <code>serialVersionUID</code> indicates/is used for.
    */
   private static final long serialVersionUID = -5596724762939716180L;

   /**
    * <code>categoryName</code> indicates/is used for.
    */
   private String categoryName;
   
   /**
    * <code>productName</code> indicates/is used for.
    */
   private String productName;
   
   
   /**
    * <code>quantity</code> indicates/is used for.
    */
   private Integer quantity;
   
   /**
    * <code>pricePerProduct</code> indicates/is used for.
    */
   private BigDecimal pricePerProduct;
   
   /**
    * <code>totalPrice</code> indicates/is used for.
    */
   private BigDecimal totalPrice;
   
   /**
    * <code>productId</code> indicates/is used for.
    */
   private Integer productId;

   /**
    * Get the productId.
    *
    * @return Returns the productId as a Integer.
    */
   public Integer getProductId()
   {
      return productId;
   }

   /**
    * Set the productId to the specified value.
    *
    * @param productId The productId to set.
    */
   public void setProductId(Integer productId)
   {
      this.productId = productId;
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
    * Get the categoryName.
    *
    * @return Returns the categoryName as a String.
    */
   public String getCategoryName()
   {
      return categoryName;
   }

   /**
    * Set the categoryName to the specified value.
    *
    * @param categoryName The categoryName to set.
    */
   public void setCategoryName(String categoryName)
   {
      this.categoryName = categoryName;
   }

   /**
    * Get the productName.
    *
    * @return Returns the productName as a String.
    */
   public String getProductName()
   {
      return productName;
   }

   /**
    * Set the productName to the specified value.
    *
    * @param productName The productName to set.
    */
   public void setProductName(String productName)
   {
      this.productName = productName;
   }

   /**
    * Get the quantity.
    *
    * @return Returns the quantity as a Integer.
    */
   public Integer getQuantity()
   {
      return quantity;
   }

   /**
    * Set the quantity to the specified value.
    *
    * @param quantity The quantity to set.
    */
   public void setQuantity(Integer quantity)
   {
      this.quantity = quantity;
   }

   /**
    * Get the pricePerProduct.
    *
    * @return Returns the pricePerProduct as a BigDecimal.
    */
   public BigDecimal getPricePerProduct()
   {
      return pricePerProduct;
   }

   /**
    * Set the pricePerProduct to the specified value.
    *
    * @param pricePerProduct The pricePerProduct to set.
    */
   public void setPricePerProduct(BigDecimal pricePerProduct)
   {
      this.pricePerProduct = pricePerProduct;
   }

   /**
    * Get the totalPrice.
    *
    * @return Returns the totalPrice as a BigDecimal.
    */
   public BigDecimal getTotalPrice()
   {
      return totalPrice;
   }

   /**
    * Set the totalPrice to the specified value.
    *
    * @param totalPrice The totalPrice to set.
    */
   public void setTotalPrice(BigDecimal totalPrice)
   {
      this.totalPrice = totalPrice;
   }
}
