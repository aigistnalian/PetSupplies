package com.petstore.dao;

import java.util.List;

import com.petstore.model.bo.Product;

/**
 * DAO class for Products table.
 * 
 * @author analian
 *
 */
public interface ProductDAO  extends DAO<Integer, Product>
{
	
	/**
	 * fetching all the product details.
	 * 
	 * @return
	 */
	public List<Product> fetchProductDetails();
	
	/**
	 * adding a new product.
	 * 
	 * @param product
	 */
	public void addNewProduct(Product product);
	
	/**
	 * updating an existing product.
	 * 
	 * @param product
	 */
	public void updateProduct(Product product);
	
	/**
	 * removing a selected product.
	 * 
	 * @param product
	 */
	public void removeProduct(Product product);

}
