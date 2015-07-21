/**
 * 
 */
package com.petshop.user.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.TabChangeEvent;

/**
 * @author analian
 *
 */
@ManagedBean(name="registrationBean")
public class RegistrationBean implements Serializable
{
	 private RegistrationForm registrationForm = null;

	 
	 public String register(){
		 System.out.println("Registered" + registrationForm.getUserName());
		 
		 return null;
	 }
	 
	/**
	 * Default value
	 */
	private static final long serialVersionUID = 1L;
	
	public void onTabChange(TabChangeEvent event) {
		System.out.println(event);
		 FacesMessage msg = new FacesMessage("Thank you for Entering the details!", "Active Tab: " + event.getTab().getTitle());
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
