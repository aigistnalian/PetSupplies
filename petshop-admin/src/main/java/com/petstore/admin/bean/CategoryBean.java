package com.petstore.admin.bean;

import java.io.Serializable;
import java.util.Set;

import com.petstore.model.bo.Product;

/**
 * Bean class for the category
 * @author analian
 *
 */
public class CategoryBean implements Serializable 
{
	/**
	 * serializable uid - auto generated.
	 */
	private static final long serialVersionUID = 7613789070799055414L;
	
	/**
	 * id for the category.
	 */
	private int id;
	
	/**
	 *  Name of the Category
	 */
	private String categoryName;
	
	/**
	 * Description of the category
	 */
	private String description;
	
	/**
	 * Set of Products associated with the category.
	 */
	Set<Product> products;
	
	/**
	 * Constructor
	 * 
	 * @param categoryName
	 * @param description
	 */
	public CategoryBean(String categoryName, String description) 
	{
		this.categoryName = categoryName;
		this.description = description;
	}
	
	/**
	 * Getter
	 * @return the categoryName
	 */
	public String getCategoryName() 
	{
		return categoryName;
	}
	/**
	 * Setter
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) 
	{
		this.categoryName = categoryName;
	}
	/**
	 * Getter
	 * 
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() 
	{
		return serialVersionUID;
	}
	/**
	 * Setter
	 * 
	 * @param description
	 */
	public void setDescription(String description) 
	{
		this.description = description;
	}
	/**
	 * Getter
	 * 
	 * @return this.description
	 */
	public String getDescription() 
	{
		return description;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public int getId() 
	{
		return this.id;
	}

	/**
	 * Setter
	 * 
	 * @param id the id to set
	 */
	public void setId(int id) 
	{
		this.id = id;
	}

	/**
	 * Getter for the set of products.
	 * 
	 * @return the products
	 */
	public Set<Product> getProducts() 
	{
		return this.products;
	}

	/**
	 * Setter
	 * 
	 * @param products the products to set
	 */
	public void setProducts(Set<Product> products) 
	{
		this.products = products;
	}


}
