/**
 * 
 */
package com.petstore.admin.bean;

import java.io.Serializable;

/**
 * Bean class as the backing bean
 * for the products page of admin module
 * 
 * @author analian
 */
public class ProductBean implements Serializable 
{
    /**
     * Auto generated for serializable class
     */
    private static final long serialVersionUID = 1L;
    /**
     * Item name = product name.
     */
    private String item;
    /**
     * description of the product.
     */
    private String desc;
    /**
     * Price of each product.
     */
    private Double price;
	/**
	 * identifier for each product in DB.
	 */
	private int id;
	/**
	 * product_category Id
	 * joins with product_Category to 
	 * identify which category it belongs to
	 * 
	 */
	private int pcId;
	/**
	 * stock keeping unit. (No particular use!) 
	 */
	private String sku;
 
    /**
     * Constructor
     * 
     * @param item
     * @param desc
     * @param price
     */
    public ProductBean(String item, String desc, Double price) 
    {
        this.item = item;
        this.desc = desc;
        this.price = price;
    }    
 
    /**
     * Getter
     * 
     * @return
     */
    public String getItem() 
    {
        return item;
    }
 
    /**
     * Setter
     * 
     * @param item
     */
    public void setItem(String item) 
    {
        this.item = item;
    }
 
    /**
     * Getter
     * 
     * @return
     */
    public Double getPrice() 
    {
        return price;
    }
 
    /**
     * Setter
     * 
     * @param price
     */
    public void setPrice(Double price) 
    {
        this.price = price;
    }
 
	/**
	 * Getter
	 * 
	 * @return the desc
	 */
	public String getDesc() 
	{
		return desc;
	}

	/**
	 * Setter
	 * 
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) 
	{
		this.desc = desc;
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
	 * Getter
	 * 
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() 
	{
		return serialVersionUID;
	}

	/**
	 * Getter
	 * 
	 * @return the pcId
	 */
	public int getPcId() 
	{
		return this.pcId;
	}

	/**
	 * Setter
	 * 
	 * @param pcId the pcId to set
	 */
	public void setPcId(int pcId) 
	{
		this.pcId = pcId;
	}

	/**
	 * Getter
	 * 
	 * @return the sku
	 */
	public String getSku() 
	{
		return this.sku;
	}

	/**
	 * Setter
	 * 
	 * @param sku the sku to set
	 */
	public void setSku(String sku) 
	{
		this.sku = sku;
	}    
}