/**
 * 
 */
package com.petstore.model.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Order table to track the user orders
 * from the pet supplies store.
 * 
 * @author analian
 *
 */
@Entity
@Table(name="ORDERS")
public class Orders implements Serializable
{

	/**
    * <code>serialVersionUID</code> indicates/is used for.
    */
   private static final long serialVersionUID = -6292688702395346389L;
   /**
	 * ID Column
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	/**
	 * Order ID
	 */
	@Column(name="ORDER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String order_id;
	/**
	 * user id
	 */
	@Column(name="USER_ID")
	private int user_id;
	/**
	 * status of the order
	 */
	@Column(name="STATUS")
	private String status;
	/**
	 * date of order placed.
	 */
	@Column(name="ORDER_DATE")
	private Date order_date;
	/**
	 * shipping address for this order.
	 */
	@Column(name="SHIPPING_ADDRESS") 
	private String shipping_address;
	/**
	 * city
	 */
	@Column(name="CITY")
	private String city;
	/**
	 * pin code
	 */
	@Column(name="PIN")
	private String pin;
	
	/**
    * order.
    */
   @ManyToOne
   @JoinColumn( referencedColumnName="ID",name="user_id",
            insertable=false,updatable=false)
   private User user;

   @OneToMany(cascade=CascadeType.ALL, mappedBy="order",fetch=FetchType.EAGER)
   @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<LineItem> lineItems;

	/**
	 * *@return Getter for the id
	 */
	public int getId() 
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) 
	{
		this.id = id;
	}

	/**
	 * *@return Getter for the order_id
	 */
	public String getOrder_id() 
	{
		return order_id;
	}

	/**
	 * @param order_id the order_id to set
	 */
	public void setOrder_id(String order_id) 
	{
		this.order_id = order_id;
	}

	/**
	 * *@return Getter for the user_id
	 */
	public int getUser_id() 
	{
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) 
	{
		this.user_id = user_id;
	}

	/**
	 * *@return Getter for the status
	 */
	public String getStatus() 
	{
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) 
	{
		this.status = status;
	}

	/**
	 * *@return Getter for the order_date
	 */
	public Date getOrder_date() 
	{
		return order_date;
	}

	/**
	 * @param order_date the order_date to set
	 */
	public void setOrder_date(Date order_date) 
	{
		this.order_date = order_date;
	}

	/**
	 * *@return Getter for the shipping_address
	 */
	public String getShipping_address() 
	{
		return shipping_address;
	}

	/**
	 * @param shipping_address the shipping_address to set
	 */
	public void setShipping_address(String shipping_address) 
	{
		this.shipping_address = shipping_address;
	}

	/**
	 * *@return Getter for the city
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
	 * @return Getter for the pin
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

   /**
    * Get the user.
    *
    * @return Returns the user as a User.
    */
   public User getUser()
   {
      return user;
   }

   /**
    * Set the user to the specified value.
    *
    * @param user The user to set.
    */
   public void setUser(User user)
   {
      this.user = user;
   }

   /**
    * Get the lineItems.
    *
    * @return Returns the lineItems as a Set<LineItem>.
    */
   public Set<LineItem> getLineItems()
   {
      return lineItems;
   }

   /**
    * Set the lineItems to the specified value.
    *
    * @param lineItems The lineItems to set.
    */
   public void setLineItems(Set<LineItem> lineItems)
   {
      this.lineItems = lineItems;
   }
	
	
}
