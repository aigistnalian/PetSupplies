/**
 * 
 */
package com.petshop.user.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.primefaces.event.TabChangeEvent;

import com.petstore.constants.Constants;
import com.petstore.model.bo.User;
import com.petstore.service.RegistrationService;

/**
 * Managed Bean class handling the registration activities for a new user.
 *
 * @version 1.0
 * @author analian (c) Jul 23, 2015, Sogeti B.V.
 */
@ManagedBean(name = "registrationBean")
public class RegistrationBean implements Serializable
{
   
   /**
    * Logger for RegistrationBean class
    */
   final static Logger log = Logger.getLogger(RegistrationBean.class);
   
   /**
    * Default value
    */
   private static final long serialVersionUID = 1L;

   /**
    * <code>registrationService</code> Injected service class.
    */
   @Inject
   RegistrationService registrationService;

   /**
    * Backing bean
    */
   private RegistrationForm registrationForm = null;

   /**
    * main method called for registering.
    * 
    * @return
    */
   public String register()
   {
      log.debug("Registered" + registrationForm.getUserName());
      User user = mapRegistrationFormToUser(registrationForm);
      registrationService.registerNewUser(user);
      return Constants.LOGIN_PAGE_STRING;
   }

   /**
    * Mapping method.
    * 
    * @param registrationForm2
    * @return
    */
   private User mapRegistrationFormToUser(RegistrationForm regForm)
   {
      log.trace("Inside the mapper method for registration");
      User mappedUser = new User();
      mappedUser.setAddress(regForm.getAddress());
      mappedUser.setCity(regForm.getCity());
      mappedUser.setEmail_id(regForm.getEmail());
      mappedUser.setFirst_name(regForm.getFirstName());
      mappedUser.setLast_name(regForm.getLastName());
      mappedUser.setPassword(regForm.getPassword());
      mappedUser.setUsername(regForm.getUserName());
      mappedUser.setPin(regForm.getPin());
      return mappedUser;
   }

   /**
    * Method called on trigger for tab change event
    * 
    * @param event
    */
   public void onTabChange(TabChangeEvent event)
   {
      log.trace("Tab change method called.");
      FacesMessage msg = new FacesMessage(Constants.ENTERING_DETAILS_MESSAGE, "Active Tab: " + event.getTab().getTitle());
      FacesContext.getCurrentInstance().addMessage(null, msg);
   }

   /**
    * Returns the backing bean.
    * 
    * @return
    */
   public RegistrationForm getRegistrationForm()
   {
      log.info("getter for the form object - registration");
      if (this.registrationForm == null)
      {
         this.registrationForm = new RegistrationForm();
      }
      return registrationForm;
   }

   /**
    * @param registrationForm the registrationForm to set
    */
   public void setRegistrationForm(RegistrationForm registrationForm)
   {
      this.registrationForm = registrationForm;
   }

}
