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
	 List<Product> fetchProductDetails();
	
	/**
	 * adding a new product.
	 * 
	 * @param product
	 */
	 void addNewProduct(Product product);
	
	/**
	 * updating an existing product.
	 * 
	 * @param product
	 */
	 void updateProduct(Product product);
	
	/**
	 * removing a selected product.
	 * 
	 * @param product
	 */
	 void removeProduct(Product product);

}
