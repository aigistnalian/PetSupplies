package com.petshop.user.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.petstore.model.bo.Product;
import com.petstore.model.bo.ProductCategory;
import com.petstore.service.CategoryService;

/**
 * @version $Id:$
 * @author analian (c) Jul 24, 2015, Sogeti B.V.
 */
@ManagedBean(name = "searchBean")
@SessionScoped
public class SearchBean implements Serializable
{

   /**
    * Default value
    */
   private static final long serialVersionUID = 1L;

   @Inject
   CategoryService categoryService;

   private List<ProductCategory> listOfCategories = new ArrayList<ProductCategory>();

   private Map<Integer, List<Product>> categoryProductsMap = new HashMap<Integer, List<Product>>();

   private List<Product> dataTableProducts = new ArrayList<Product>();

   private String category;

   /**
	 * 
	 */
   @PostConstruct
   public void init()
   {
      listOfCategories = categoryService.findAllCategories();

      if (listOfCategories != null && !listOfCategories.isEmpty())
      {

         for (ProductCategory productCategory : listOfCategories)
         {

            Collection<Product> products = productCategory.getProducts();
            List<Product> productsList = new ArrayList<Product>();

            if (products != null && !products.isEmpty())
            {
               for (Product product : products)
               {
                  productsList.add(product);
               }
            }
            categoryProductsMap.put(productCategory.getId(), productsList);
         }
      }

   }

   public void updateCategorySelected()
   {
      System.out.println(category);
      dataTableProducts.clear();
      Integer selectedCategoryValue = Integer.valueOf(category);
      dataTableProducts.addAll(categoryProductsMap.get(selectedCategoryValue));
   }

   /**
    * @return the listOfCategories
    */
   public List<ProductCategory> getListOfCategories()
   {
      return listOfCategories;
   }

   /**
    * @param listOfCategories the listOfCategories to set
    */
   public void setListOfCategories(List<ProductCategory> listOfCategories)
   {
      this.listOfCategories = listOfCategories;
   }

   /**
    * @return the serialversionuid
    */
   public static long getSerialversionuid()
   {
      return serialVersionUID;
   }

   /**
    * @return the categoryProductsMap
    */
   public Map<Integer, List<Product>> getCategoryProductsMap()
   {
      return categoryProductsMap;
   }

   /**
    * @param categoryProductsMap the categoryProductsMap to set
    */
   public void setCategoryProductsMap(Map<Integer, List<Product>> categoryProductsMap)
   {
      this.categoryProductsMap = categoryProductsMap;
   }

   /**
    * @return the dataTableProducts
    */
   public List<Product> getDataTableProducts()
   {
      return dataTableProducts;
   }

   /**
    * @param dataTableProducts the dataTableProducts to set
    */
   public void setDataTableProducts(List<Product> dataTableProducts)
   {
      this.dataTableProducts = dataTableProducts;
   }

   /**
    * @return the category
    */
   public String getCategory()
   {
      return category;
   }

   /**
    * @param category the category to set
    */
   public void setCategory(String category)
   {
      this.category = category;
   }

}
