/**
 * 
 */
package com.petshop.user.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.petshop.user.bean.UserLoginBean;

/**
 * @author analian
 *
 */
@ManagedBean(name = "redirectController")
@SessionScoped
public class RedirectController implements Serializable 
{
	
	@ManagedProperty(value="#{userLogin}")
	UserLoginBean loginBean;
	
	
	public boolean showHomePageLink = false;

	/**
	 * Default value
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @return
	 */
	public String redirectToRegistrationPage(){
		
		showHomePageLink=false;
		loginBean.setLoginPage(false);
		return "landing";
	}
	
	/**
	 * @return
	 */
	public String redirectToHomePage(){
		showHomePageLink = false;
		loginBean.setLoginPage(false);
		return "landing";
	}
	
	/**
	 * @return
	 */
	public String redirectToLoginPage(){
		showHomePageLink = false;
		loginBean.setLoginPage(true);
		return "login";
	}
	
	
	public String redirectToBrowseProducts()
	{
		showHomePageLink=true;
		loginBean.setLoginPage(false);
		return "browseProducts";
	}

	/**
	 * @return the showHomePageLink
	 */
	public boolean isShowHomePageLink() {
		return showHomePageLink;
	}

	/**
	 * @param showHomePageLink the showHomePageLink to set
	 */
	public void setShowHomePageLink(boolean showHomePageLink) {
		this.showHomePageLink = showHomePageLink;
	}

	/**
	 * @return the loginBean
	 */
	public UserLoginBean getLoginBean() {
		return loginBean;
	}

	/**
	 * @param loginBean the loginBean to set
	 */
	public void setLoginBean(UserLoginBean loginBean) {
		this.loginBean = loginBean;
	}
	
}
