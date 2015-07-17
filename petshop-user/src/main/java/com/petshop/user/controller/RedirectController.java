/**
 * 
 */
package com.petshop.user.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author analian
 *
 */
@ManagedBean(name = "redirectController")
@SessionScoped
public class RedirectController implements Serializable 
{

	/**
	 * Default value
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @return
	 */
	public String redirectToRegistrationPage(){
		System.out.println("Inside Redirect Method");
		return "landing";
	}
	
}
