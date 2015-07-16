/**
 * 
 */
package com.petstore.model.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author analian
 *
 */
@Entity
@Table(name="LINE_ITEM")
public class LineItem implements Serializable
{
	
	/**
	 * Auto generated for serializable class.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ID column
	 */
	@Id
	@Column(name="ID")
	private int id;
	/**
	 * ORDER ID column
	 */
	@Column(name="ORDER_ID")
	private int order_id;
	/**
	 * PRODUCT ID column
	 */
	@Column(name="PRODUCT_ID")
	private int product_id;
	/**
	 * Amount column
	 */
	@Column(name="AMOUNT")
	private int amount;
	/**
	 * Number of products in this line item.
	 */
	@Column(name="NO_OF_PRODUCTS")
	private int no_of_products;

	/**
	 * Getter
	 * *@return Getter for the id
	 */
	public int getId() 
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) 
	{
		this.id = id;
	}

	/**
	 * *@return Getter for the order_id
	 */
	public int getOrder_id() 
	{
		return order_id;
	}

	/**
	 * @param order_id the order_id to set
	 */
	public void setOrder_id(int order_id)
	{
		this.order_id = order_id;
	}

	/**
	 * *@return Getter for the product_id
	 */
	public int getProduct_id() 
	{
		return product_id;
	}

	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(int product_id) 
	{
		this.product_id = product_id;
	}

	/**
	 * *@return Getter for the amount
	 */
	public int getAmount() 
	{
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) 
	{
		this.amount = amount;
	}

	/**
	 * *@return Getter for the no_of_products
	 */
	public int getNo_of_products() 
	{
		return no_of_products;
	}

	/**
	 * @param no_of_products the no_of_products to set
	 */
	public void setNo_of_products(int no_of_products) 
	{
		this.no_of_products = no_of_products;
	}
	
	

}
