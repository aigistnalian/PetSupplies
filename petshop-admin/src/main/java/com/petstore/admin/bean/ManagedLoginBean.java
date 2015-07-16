 /**
 * 
 */
package com.petstore.admin.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.petstore.constants.Constants;
import com.petstore.service.LoginService;
import com.petstore.util.Util;

/**
 * Managed bean handling
 * the user login for the admin
 *  moodule
 * 
 * @author analian
 *
 */
@ManagedBean(name="loginBean")
@SessionScoped
public class ManagedLoginBean implements Serializable 
{
    /**
     * Injected Service class handling
     * the login for the admin module.
     * (Uses CDI)
     */
    @Inject 
    LoginService loginService;
    
	/**
	 * Auto generated UID for serializable class.
	 */
	private static final long serialVersionUID = 7829457603314371883L;
    /**
     * password for the admin user.
     */
    private String password;
    /**
     * Message for errors shown on screen
     */
    private String message;
    
    /**
     * Username for the admin user to login.
     */
    private String uname;
    

    /**
     * Main method called for logging in 
     * to the admin module
     * 
     * @return String path of the landing page.
     */
    public String loginProject()
    {
    	  boolean result = loginService.validateAdminUserLogin(uname, password);
          System.out.println(result);
          if (result) 
          {
              // get Http Session and store username
              HttpSession session = Util.getSession();
              session.setAttribute(Constants.USERNAME, uname);
              return Constants.LANDING_PAGE_STRING;
          } 
          else 
          {
              FacesContext.getCurrentInstance().addMessage(
                      null,
                      new FacesMessage(FacesMessage.SEVERITY_WARN,
                      Constants.INVALID_LOGIN_MESSAGE,
                      Constants.TRY_AGAIN_MESSAGE));
   
              // invalidate session, and redirect to other pages
              return Constants.LOGIN_PAGE_STRING;
          }
    }

	/**
	 * Getter
	 * 
	 * @return the password
	 */
	public String getPassword() 
	{
		return this.password;
	}

	/**
	 * Setter
	 * 
	 * @param password the password to set
	 */
	public void setPassword(String password) 
	{
		this.password = password;
	}

	/**
	 * Getter
	 * 
	 * @return the message
	 */
	public String getMessage() 
	{
		return this.message;
	}

	/**
	 * Setter
	 * 
	 * @param message the message to set
	 */
	public void setMessage(String message) 
	{
		this.message = message;
	}

	/**
	 * Getter
	 * 
	 * @return the uname
	 */
	public String getUname() 
	{
		return this.uname;
	}

	/**
	 * Setter
	 * 
	 * @param uname the uname to set
	 */
	public void setUname(String uname) 
	{
		this.uname = uname;
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
