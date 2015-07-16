package com.petstore.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.petstore.constants.Constants;

/**
 * @author analian
 *
 */
public class Util 
{
	/**
	 * Getter for the current HTTP Session
	 * 
	 * @return
	 */
	public static HttpSession getSession() 
	{
        return (HttpSession)
          FacesContext.
          getCurrentInstance().
          getExternalContext().
          getSession(false);
    }
       
    /**
     * Gets the current request object.
     * 
     * @return
     */
    public static HttpServletRequest getRequest() {
       return (HttpServletRequest) FacesContext.
          getCurrentInstance().
          getExternalContext().getRequest();
      }
 
    /**
     * Gets the user name
     * 
     * @return
     */
    public static String getUserName()
      {
        HttpSession session = (HttpSession) 
        		FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return  session.getAttribute(Constants.USERNAME).toString();
      }
       
    /**
     * Gets the user id
     * 
     * @return
     */
    public static String getUserId()
      {
        HttpSession session = getSession();
        if ( session != null )
            return (String) session.getAttribute(Constants.USER_ID);
        else
            return null;
      }
}
