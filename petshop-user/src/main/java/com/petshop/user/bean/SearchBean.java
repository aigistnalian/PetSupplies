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
 * Class used as Managed Bean for rendering the various products under each category.
 * 
 * @version 1.0
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

   /**
    * <code>categoryService</code> Injected service class.
    */
   @Inject
   CategoryService categoryService;

   /**
    * <code>listOfCategories</code> list of categories
    */
   private List<ProductCategory> listOfCategories = new ArrayList<ProductCategory>();

   /**
    * <code>categoryProductsMap</code> Mapping of each category with associated products.
    */
   private Map<Integer, List<Product>> categoryProductsMap = new HashMap<Integer, List<Product>>();

   /**
    * <code>dataTableProducts</code> products shown on the data table.
    */
   private List<Product> dataTableProducts = new ArrayList<Product>();

   /**
    * <code>category</code> selected category.
    */
   private String category;

   /**
    * init method.
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

   /**
    * make changes on the datatable based on the category selected.
    */
   public void updateCategorySelected()
   {
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
