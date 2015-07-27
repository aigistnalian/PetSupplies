package com.petshop.user.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.petshop.user.bean.UserLoginBean;
import com.petstore.constants.Constants;

/**
 * Controller class
 * to redirect the user through various pages
 * acts as listener for most of the methods by sidelinks.
 *
 * @version 1.0
 * @author analian (c) Jul 24, 2015, Sogeti B.V.
 */
@ManagedBean(name = "redirectController")
@SessionScoped
public class RedirectController implements Serializable
{

   /**
    * <code>loginBean</code> indicates/is used 
    * as a managed property by primefaces.
    */
   @ManagedProperty(value = "#{userLogin}")
   UserLoginBean loginBean;

   public boolean showHomePageLink = false;

   /**
    * Default value generated for serializable class.
    */
   private static final long serialVersionUID = 1L;


   /**
    * Method redirects the user to the basic landing page. 
    * 
    * @return
    */
   public String redirectToHomePage()
   {
      showHomePageLink = false;
      loginBean.setLoginPage(false);
      return Constants.LANDING_PAGE_STRING;
   }

   /**
    * Method redirects the user to the login page
    * 
    * @return
    */
   public String redirectToLoginPage()
   {
      showHomePageLink = false;
      loginBean.setLoginPage(true);
      return Constants.LOGIN_PAGE_STRING;
   }

   /**
    * Method redirects the user to
    * the page where he can browse
    * through the categories for 
    * the different types of products.
    * 
    * @return
    */
   public String redirectToBrowseProducts()
   {
      showHomePageLink = true;
      loginBean.setLoginPage(false);
      return Constants.BROWSE_PRODUCTS_STRING;
   }

   /**
    * Getter
    * 
    * @return the showHomePageLink
    */
   public boolean isShowHomePageLink()
   {
      return showHomePageLink;
   }

   /**
    * Setter
    * 
    * @param showHomePageLink the showHomePageLink to set
    */
   public void setShowHomePageLink(boolean showHomePageLink)
   {
      this.showHomePageLink = showHomePageLink;
   }

   /**
    * Getter
    * 
    * @return the loginBean
    */
   public UserLoginBean getLoginBean()
   {
      return loginBean;
   }

   /**
    * Setter
    * 
    * @param loginBean the loginBean to set
    */
   public void setLoginBean(UserLoginBean loginBean)
   {
      this.loginBean = loginBean;
   }

}
