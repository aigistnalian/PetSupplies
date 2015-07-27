package com.petshop.user.bean;

/**
 * Backing bean class for the form
 * on registration page.
 *
 * @version 1.0
 * @author analian (c) Jul 24, 2015, Sogeti B.V.
 */ 
public class RegistrationForm
{

   /**
    * <code>userId</code> indicates/is used for user id.
    */
   private Integer userId;

   /**
    * <code>userName</code> indicates/is used for user name.
    */
   private String userName;
   /**
    * <code>password</code> indicates/is used for password.
    */
   private String password;
   /**
    * <code>firstName</code> indicates/is used for first name.
    */
   private String firstName;
   /**
    * <code>lastName</code> indicates/is used for last name.
    */
   private String lastName;
   /**
    * <code>email</code> indicates/is used for email id.
    */
   private String email;
   /**
    * <code>address</code> indicates/is used for address.
    */
   private String address;
   /**
    * <code>city</code> indicates/is used for city.
    */
   private String city;
   /**
    * <code>pin</code> indicates/is used for pin code.
    */
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
