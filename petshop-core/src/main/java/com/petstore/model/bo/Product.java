package com.petstore.model.bo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author analian
 *
 */
@Entity
@Table(name="PRODUCT")
public class Product implements Serializable
{

	/**
	 * auto generated for serializable class.
	 */
	private static final long serialVersionUID = -4401489789015629512L;

	/**
	 * id column
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	/**
	 * join for product_category
	 */
	@Column(name="PRODUCT_CATEGORY_ID")
	private int product_category_id;
	/**
	 * stock keeping unit
	 */
	@Column(name="SKU")
	private String sku;
	/**
	 * name of product
	 */
	@Column(name="NAME")
	private String name;
	/**
	 * price of product.
	 */
	@Column(name="PRICE")
	private BigDecimal price;
	/**
	 * description of the product.
	 */
	@Column(name="DESCRIPTION")
	private String description;

	/**
	 * category.
	 */
	@ManyToOne
	@JoinColumn(name = "product_category_id",
				insertable=false,updatable=false)
	private ProductCategory category;
	/**
	 * @return the id
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
	 * @return the product_category_id
	 */
	public int getProduct_category_id() 
	{
		return product_category_id;
	}

	/**
	 * @param product_category_id the product_category_id to set
	 */
	public void setProduct_category_id(int product_category_id) 
	{
		this.product_category_id = product_category_id;
	}

	/**
	 * @return the sku
	 */
	public String getSku() 
	{
		return sku;
	}

	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) 
	{
		this.sku = sku;
	}

	/**
	 * @return the name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() 
	{
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) 
	{
		this.price = price;
	}

	/**
	 * @return the description
	 */
	public String getDescription() 
	{
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) 
	{
		this.description = description;
	}

	/**
	 * @return the category
	 */
	public ProductCategory getCategory() 
	{
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(ProductCategory category) 
	{
		this.category = category;
	}
	
}
