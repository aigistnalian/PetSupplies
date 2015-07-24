package com.petshop.user.bean;

/**
 * 
 *
 * @version $Id:$
 * @author analian (c) Jul 24, 2015, Sogeti B.V.
 */ 
public class RegistrationForm
{

   private Integer userId;

   private String userName;
   private String password;
   private String firstName;
   private String lastName;
   private String email;
   private String address;
   private String city;
   private String pin;

   /**
    * @return the userId
    */
   public Integer getUserId()
   {
      return userId;
   }

   /**
    * @param userId the userId to set
    */
   public void setUserId(Integer userId)
   {
      this.userId = userId;
   }

   /**
    * @return the userName
    */
   public String getUserName()
   {
      return userName;
   }

   /**
    * @param userName the userName to set
    */
   public void setUserName(String userName)
   {
      this.userName = userName;
   }

   /**
    * @return the password
    */
   public String getPassword()
   {
      return password;
   }

   /**
    * @param password the password to set
    */
   public void setPassword(String password)
   {
      this.password = password;
   }

   /**
    * @return the firstName
    */
   public String getFirstName()
   {
      return firstName;
   }

   /**
    * @param firstName the firstName to set
    */
   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   /**
    * @return the lastName
    */
   public String getLastName()
   {
      return lastName;
   }

   /**
    * @param lastName the lastName to set
    */
   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   /**
    * @return the email
    */
   public String getEmail()
   {
      return email;
   }

   /**
    * @param email the email to set
    */
   public void setEmail(String email)
   {
      this.email = email;
   }

   /**
    * @return the address
    */
   public String getAddress()
   {
      return address;
   }

   /**
    * @param address the address to set
    */
   public void setAddress(String address)
   {
      this.address = address;
   }

   /**
    * @return the city
    */
   public String getCity()
   {
      return city;
   }

   /**
    * @param city the city to set
    */
   public void setCity(String city)
   {
      this.city = city;
   }

   /**
    * @return the pin
    */
   public String getPin()
   {
      return pin;
   }

   /**
    * @param pin the pin to set
    */
   public void setPin(String pin)
   {
      this.pin = pin;
   }
}
