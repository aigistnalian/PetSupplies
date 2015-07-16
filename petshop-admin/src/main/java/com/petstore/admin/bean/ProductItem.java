package com.petstore.admin.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.petstore.model.bo.Product;
import com.petstore.model.bo.ProductCategory;
import com.petstore.service.CategoryService;
import com.petstore.service.ProductService;

/**
 * Main managed bean
 * for the products page of
 * the admin module
 * 
 * @author analian
 *
 */
@ManagedBean(name = "item")
@RequestScoped
public class ProductItem implements Serializable 
{
	
	static final Logger log = Logger.getLogger(ProductItem.class);
	
	/**
	 * Injected service class
	 * handling the actions related to 
	 * products with the DAO
	 */
	@Inject
	ProductService productService;
	
	/**
	 * Injected Service class
	 * handling the actions related to
	 * Products and their Categories.
	 */
	@Inject
	CategoryService categoryService;


	/**
	 * auto generated for Serializable class.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * item name of the product.
	 */
	private String item;
	/**
	 * description of each product.
	 */
	private String description;
	/**
	 * price of each product.
	 */
	private Double price;
	/**
	 * category to which the product belongs.
	 */
	private String category;

	/**
	 * Map of categories from DB
	 * maps to the dropdown for adding the product.
	 */
	private Map<Integer, String> categories;

	/**
	 * List of products shown on the page
	 * as an editable grid datatable.
	 */
	private ArrayList<ProductBean> productList = new ArrayList<ProductBean>();

	/**
	 * init method 
	 */
	@PostConstruct
	public void init() 
	{
		this.refreshProductList();
		this.categories = new HashMap<Integer, String>();
		List<ProductCategory> categoriesList = categoryService.findAllCategories();
		for (ProductCategory productCategory : categoriesList) 
		{
			categories.put(productCategory.getId(), productCategory.getName());
		}
	}

	/**
	 * method called to 
	 * refresh the list of products on the datatable
	 * and show to the user correct list.
	 */
	public void refreshProductList() 
	{
		List<Product> productsList = productService.fetchAllProductDetails();
		System.out.println(productsList);

		productList.clear();

		for (Product product : productsList) 
		{
			ProductBean pBean = new ProductBean(product.getName(),
					product.getDescription(), product.getPrice().doubleValue());
			pBean.setId(product.getId());
			pBean.setPcId(product.getProduct_category_id());
			pBean.setSku(product.getSku());
			productList.add(pBean);
		}
	}

	/**
	 * method called on changing the category.
	 * Doesn't do anything, just logs that 
	 * category has been changed.
	 */
	public void onCategoryChange() 
	{
		log.debug("category changed to -->" + category);
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
	 * @return
	 */
	public ArrayList<ProductBean> getProductList() 
	{
		if (this.productList == null) 
		{
			refreshProductList();
		}
		return productList;
	}

	/**
	 * Getter
	 * 
	 * @return the category
	 */
	public String getCategory() 
	{
		return this.category;
	}

	/**
	 * Setter
	 * 
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) 
	{
		this.category = category;
	}

	/**
	 * Getter
	 * 
	 * @return the categories
	 */
	public Map<Integer, String> getCategories() 
	{
		categories = new HashMap<Integer, String>();
		List<ProductCategory> categoriesList = categoryService
				.findAllCategories();
		for (ProductCategory productCategory : categoriesList)
		{
			categories.put(productCategory.getId(), productCategory.getName());
		}
		return categories;
	}

	/**
	 * Setter
	 * 
	 * @param categories
	 *            the categories to set
	 */
	public void setCategories(Map<Integer, String> categories) 
	{
		this.categories = categories;
	}

	/**
	 * Getter
	 * 
	 * @return the description
	 */
	public String getDescription() 
	{
		return this.description;
	}

	/**
	 * Setter
	 * 
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) 
	{
		this.description = description;
	}

}