package com.petstore.service;

import java.util.List;

import com.petstore.model.bo.ProductCategory;

/**
 * Interface for the Service layer
 * For the category level services/business logic
 * 
 * @author analian
 *
 */
 public interface CategoryService 
{

	/**
	 * for adding new category
	 * 
	 * @param category
	 */
	 void addNewCategory(ProductCategory category);
	
	/**
	 * for fetching all the available categories.
	 * @return
	 */
	 List<ProductCategory> findAllCategories();
	
	/**
	 * for updating a selected category.
	 * 
	 * @param category
	 */
	 void updateSelectedCategory(ProductCategory category);
	/**
	 * for removing a selected category
	 * 
	 * @param id
	 */
	void removeSelectedCategory(ProductCategory category);
	
	
}
