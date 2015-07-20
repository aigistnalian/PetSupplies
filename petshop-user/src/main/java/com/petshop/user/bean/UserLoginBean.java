package com.petshop.user.bean;

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
 * @author analian
 *
 */
@ManagedBean (name="userLogin")
@SessionScoped
public class UserLoginBean implements Serializable
{
	public boolean isRegisteredUser;
	
	public boolean loginPage = true;
	
	public UserLoginBean() {
		userName = Constants.GUEST;
	}
	
	 /**
     * Injected Service class handling
     * the login for the admin module.
     * (Uses CDI)
     */
    @Inject 
    LoginService loginService;
    
	
	public String validateUserLogin(){
		boolean result = loginService.validateUserLogin(userName, password);
        if (result) 
        {
            // get Http Session and store username
            HttpSession session = Util.getSession();
            session.setAttribute(Constants.USERNAME, userName);
            isRegisteredUser = true;
            return Constants.LANDING_PAGE_STRING;
        } 
        else 
        {
        	isRegisteredUser = false;
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    Constants.INVALID_LOGIN_MESSAGE,
                    Constants.PLEASE_REGISTER_MESSAGE));
 
            // invalidate session, and redirect to other pages
            return Constants.LOGIN_PAGE_STRING;
        }
	}

	/**
	  * user is logged out when the
	  * logout link is clicked
	  * 
	 * @return
	 */
	public String logout() 
	{
	        HttpSession session = Util.getSession();
	        session.invalidate();
	        isRegisteredUser = false;
	         return Constants.LOGIN_REDIRECT_STRING;
	 }
	
	/**
	 * Default value
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the isRegisteredUser
	 */
	public boolean isRegisteredUser() {
		return isRegisteredUser;
	}

	/**
	 * @param isRegisteredUser the isRegisteredUser to set
	 */
	public void setRegisteredUser(boolean isRegisteredUser) {
		this.isRegisteredUser = isRegisteredUser;
	}

	/**
	 * @return the loginPage
	 */
	public boolean isLoginPage() {
		return loginPage;
	}

	/**
	 * @param loginPage the loginPage to set
	 */
	public void setLoginPage(boolean loginPage) {
		this.loginPage = loginPage;
	}
	

}
