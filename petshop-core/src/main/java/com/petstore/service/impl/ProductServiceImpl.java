/**
 * 
 */
package com.petstore.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.petstore.dao.ProductDAO;
import com.petstore.model.bo.Product;
import com.petstore.service.ProductService;

/**
 * Stateless class so that CDI can inject
 * the service class in bean
 * Acts as EJB Business layer
 * 
 * @author analian
 *
 */
@Stateless
public class ProductServiceImpl implements ProductService 
{

	/**
	 * Logger for the Product Service implementation class.
	 */
	static final Logger log = Logger.getLogger(ProductServiceImpl.class);
	
	/**
	 * Injected DAO class for interacting with 
	 * PRODUCT table.
	 */
	@Inject
	ProductDAO productDAO;
	
	/* (non-Javadoc)
	 * @see com.petstore.service.ProductService#fetchAllProductDetails()
	 */
	@Override
	public List<Product> fetchAllProductDetails() 
	{
		log.debug("Service class --> Fetching all product Details");
		return productDAO.fetchProductDetails();
	}

	/* (non-Javadoc)
	 * @see com.petstore.service.ProductService#addNewProduct(com.petstore.model.bo.Product)
	 */
	@Override
	@Transactional
	public void addNewProduct(Product product) 
	{
		log.debug("Service class --> Adding new product -->" + product);
		productDAO.addNewProduct(product);
	}

	/* (non-Javadoc)
	 * @see com.petstore.service.ProductService#updateProduct(com.petstore.model.bo.Product)
	 */
	@Override
	@Transactional
	public void updateProduct(Product product) 
	{
		log.debug("Service class --> Updating product -->" + product);
		productDAO.updateProduct(product);
	}

	/* (non-Javadoc)
	 * @see com.petstore.service.ProductService#removeSelectedProduct(com.petstore.model.bo.Product)
	 */
	@Override
	@Transactional
	public void removeSelectedProduct(Product product) 
	{
		log.debug("Service class --> Removing selected product -->" + product);
		productDAO.removeProduct(product);
	}

}
