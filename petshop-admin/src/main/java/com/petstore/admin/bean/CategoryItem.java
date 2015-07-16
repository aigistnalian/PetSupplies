package com.petstore.admin.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import com.petstore.model.bo.ProductCategory;
import com.petstore.service.CategoryService;

/**
 * Main managed bean handling the category page 
 * for the pet supplies - admin 
 * 
 * @author analian
 *
 */
@ManagedBean(name = "categoryItem")
@RequestScoped
public class CategoryItem implements Serializable 
{
	/**
	 * Injecting the Category Service class through
	 * CDI
	 */
	@Inject
	CategoryService categoryService;
	
	/**
	 * Auto generated UID since it is serializable.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Name of the Category.
	 */
	private String categoryName;
	/**
	 * Description of the category.
	 */
	private String description;

	/**
	 * List of categories to be displayed on the screen
	 * as a grid data table.
	 */
	private  List<CategoryBean> catList = new ArrayList<CategoryBean>();


	/**
	 * init method that refreshes the
	 * categories 
	 */
	@PostConstruct
	public void init() 
	{
		this.refreshCategories();
	}

	/*
	 * private method handling
	 * the refreshing of the category data
	 * on the page.
	 * 
	 */
	private void refreshCategories() 
	{
		List<ProductCategory> categoriesList = categoryService.findAllCategories();
		this.catList.clear();
		
		if (categoriesList != null) 
		{
			for (ProductCategory productCategory : categoriesList) 
			{
				CategoryBean bean = new CategoryBean(productCategory.getName(),
						productCategory.getDescription());
				bean.setId(productCategory.getId());
				bean.setProducts(productCategory.getProducts());
				this.catList.add(bean);
			}
		}
	}


	/**
	 * Getter for the list of categories.
	 * 
	 * @return
	 */
	public List<CategoryBean> getCatList() 
	{
		return this.catList;
	}

	/**
	 * Getter
	 * 
	 * @return the categoryName
	 */
	public String getCategoryName() 
	{
		return this.categoryName;
	}

	/**
	 * Setter
	 * 
	 * @param categoryName
	 *            the categoryName to set
	 */
	public void setCategoryName(String categoryName) 
	{
		this.categoryName = categoryName;
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
	 * @return
	 */
	public String getDescription() 
	{
		return description;
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
}
