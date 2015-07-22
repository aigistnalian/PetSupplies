/**
 * 
 */
package com.petshop.user.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.TabChangeEvent;

import com.petstore.constants.Constants;
import com.petstore.model.bo.User;
import com.petstore.service.RegistrationService;

/**
 * @author analian
 *
 */
@ManagedBean(name="registrationBean")
public class RegistrationBean implements Serializable
{
	/**
	 * Default value
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	RegistrationService registrationService;
	
	 /**
	 * Backing bean
	 */
	private RegistrationForm registrationForm = null;

	 /**
	 * @return
	 */
	public String register()
	 {
		 System.out.println("Registered" + registrationForm.getUserName());
		 User user  = mapRegistrationFormToUser(registrationForm);
		registrationService.registerNewUser(user);
		 return Constants.LOGIN_PAGE_STRING;
	 }
	 
	/**
	 * @param registrationForm2
	 * @return
	 */
	private User mapRegistrationFormToUser(RegistrationForm regForm) 
	{
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
	 * @param event
	 */
	public void onTabChange(TabChangeEvent event) 
	{
		 FacesMessage msg = new FacesMessage(Constants.ENTERING_DETAILS_MESSAGE, 
				 					"Active Tab: " + event.getTab().getTitle());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * @return the registrationForm
	 */
	public RegistrationForm getRegistrationForm() {
		 if(this.registrationForm == null){
			   this.registrationForm = new RegistrationForm();
			  }
		return registrationForm;
	}

	/**
	 * @param registrationForm the registrationForm to set
	 */
	public void setRegistrationForm(RegistrationForm registrationForm) {
		this.registrationForm = registrationForm;
	}

	
}
