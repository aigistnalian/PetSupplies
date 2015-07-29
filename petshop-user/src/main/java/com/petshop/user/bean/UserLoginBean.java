package com.petshop.user.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.petstore.constants.Constants;
import com.petstore.service.LoginService;
import com.petstore.util.Util;

/**
 * Managed bean used to login and logout by normal registered user.
 *
 * @version 1.0
 * @author analian (c) Jul 24, 2015, Sogeti B.V.
 */
@ManagedBean(name = "userLogin")
@SessionScoped
public class UserLoginBean implements Serializable
{

   final static Logger log = Logger.getLogger(UserLoginBean.class);

   /**
    * <code>isRegisteredUser</code> indicates/is used for.
    */
   public boolean isRegisteredUser;

   /**
    * <code>loginPage</code> indicates/is used for.
    */
   public boolean loginPage = true;

   /**
    * Constructor: create a new UserLoginBean.
    */
   public UserLoginBean()
   {
      log.debug("Created a new User Login Bean class");
      userName = Constants.GUEST;
   }

   /**
    * Injected Service class handling the login for the admin module. (Uses CDI)
    */
   @Inject
   LoginService loginService;

   /**
    * Method used to validate the user credentials.
    * 
    * @return
    */
   public String validateUserLogin()
   {
      log.debug("Validating the user logins");

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
         log.error("User is not valid");
         isRegisteredUser = false;
         FacesContext.getCurrentInstance().addMessage(null, 
               new FacesMessage(FacesMessage.SEVERITY_WARN,
                                 Constants.INVALID_LOGIN_MESSAGE, Constants.PLEASE_REGISTER_MESSAGE));
         log.trace("Returning to the login page");

         return Constants.LOGIN_PAGE_STRING;
      }
   }

   /**
    * user is logged out when the logout link is clicked
    * 
    * @return
    */
   public String logout()
   {
      log.debug("logout method for the user");
      HttpSession session = Util.getSession();
      session.invalidate();
      isRegisteredUser = false;
      return Constants.LOGIN_REDIRECT_STRING;
   }

   /**
    * Default value
    */
   private static final long serialVersionUID = 1L;

   /**
    * <code>userName</code> indicates/is used as user name for login.
    */
   private String userName;
   /**
    * <code>password</code> indicates/is used as user password.
    */
   private String password;

   /**
    * Getter
    * 
    * @return the userName
    */
   public String getUserName()
   {
      return userName;
   }

   /**
    * Setter
    * 
    * @param userName the userName to set
    */
   public void setUserName(String userName)
   {
      this.userName = userName;
   }

   /**
    * Getter
    * 
    * @return the password
    */
   public String getPassword()
   {
      return password;
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
    * @return the serialversionuid
    */
   public static long getSerialversionuid()
   {
      return serialVersionUID;
   }

   /**
    * getter
    * 
    * @return the isRegisteredUser
    */
   public boolean isRegisteredUser()
   {
      return isRegisteredUser;
   }

   /**
    * Setter
    * 
    * @param isRegisteredUser the isRegisteredUser to set
    */
   public void setRegisteredUser(boolean isRegisteredUser)
   {
      this.isRegisteredUser = isRegisteredUser;
   }

   /**
    * Getter
    * 
    * @return the loginPage
    */
   public boolean isLoginPage()
   {
      return loginPage;
   }

   /**
    * Setter
    * 
    * @param loginPage the loginPage to set
    */
   public void setLoginPage(boolean loginPage)
   {
      this.loginPage = loginPage;
   }

}
