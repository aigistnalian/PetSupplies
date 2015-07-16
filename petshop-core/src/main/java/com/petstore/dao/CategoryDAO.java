/**
 * 
 */
package com.petstore.dao;

import java.util.List;

import com.petstore.model.bo.ProductCategory;

/**
 * Interface for Category DAO 
 * 
 * @author analian
 *
 */
public interface CategoryDAO extends DAO<Integer, ProductCategory> 
{
	/**
	 * fetching all the categories.
	 * @return
	 */
	 List<ProductCategory> fetchAllCategories();
	
	/**
	 * adding a new category.
	 * 
	 * @param category
	 */
	 void addNewCategory(ProductCategory category);
	
	/**
	 * removing a selected category.
	 * 
	 * @param category
	 */
	 void removeCategory(ProductCategory category);
	
	/**
	 * updating a selected category.
	 * @param category
	 */
	 void updateCategory(ProductCategory category);
}
