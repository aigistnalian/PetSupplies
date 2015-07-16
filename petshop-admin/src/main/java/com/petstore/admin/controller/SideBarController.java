/**
 * 
 */
package com.petstore.admin.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.petstore.constants.Constants;
import com.petstore.util.Util;

/**
 * Managed Bean Class that handles the actions 
 * of the links on the sidebar.
 * 
 * @author analian
 *
 */
@ManagedBean(name = "sidebar")
@SessionScoped
public class SideBarController implements Serializable 
{
	/**
	 * Logger for the sidebar controller class.
	 */
	static final Logger log = Logger.getLogger(SideBarController.class);
	
	/**
	 * auto generated for the serializable class.
	 */
	private static final long serialVersionUID = 8969017736390777114L;

	/**
	 * Method that redirects user to the category page 
	 * 
	 * @return
	 */
	public String sendToCategoryPage() 
	{
		HttpSession session = Util.getSession();
		String user = (String) session.getAttribute(Constants.USERNAME);
		if (user != null) 
		{
			return Constants.CATEGORY_PAGE_STRING;
		}
		else 
		{
			   this.showInvalidLinkClickedMessage();
			return Constants.LANDING_PAGE_STRING;
		}
	}

	/*
	 * Private method that shows a message 
	 * when invalid link is clicked 
	 */
	private void showInvalidLinkClickedMessage() 
	{
		FacesContext.getCurrentInstance().addMessage(
		              null,
		              new FacesMessage(FacesMessage.SEVERITY_WARN,
		              Constants.INVALID_LINK_MESSAGE,
		             Constants.PLEASE_LOGIN_MESSAGE));
	}
	
	 /**
	  * user is logged out when the
	  * logout link is clicked
	  * 
	 * @return
	 */
	public String logout() 
	{
			log.debug("LOGGING OUT!");
	        HttpSession session = Util.getSession();
	        session.invalidate();
	         return Constants.LOGIN_REDIRECT_STRING;
	 }

	/**
	 * Method that redirects the user to 
	 * the products page from the sidebar.
	 * 
	 * @return
	 */
	public String sendToProductPage() 
	{
		HttpSession session = Util.getSession();
		String user = (String) session.getAttribute(Constants.USERNAME);
		if (user != null) 
		{
			return Constants.PRODUCT_PAGE_STRING;
		} 
		else
		{
			this.showInvalidLinkClickedMessage();
			return Constants.LANDING_PAGE_STRING;
		}
	}

}
