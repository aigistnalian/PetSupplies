/**
 * 
 */
package com.petstore.model.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Roles- admin, user,etc
 * 
 * @author analian
 *
 */
@Entity
@Table(name="ROLES")
public class Roles implements Serializable 
{

	/**
	 * Auto generated for serializable class.
	 */
	private static final long serialVersionUID = 2116538630796593082L;

	/**
	 * ID Column 
	 */
	@Id
	@Column(name="ID")
	private int role_id;
	/**
	 * name of the role
	 */
	@Column(name="NAME")
	private String name;


	/**
	 * @return the name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * @return the role_id
	 */
	public int getRole_id() 
	{
		return role_id;
	}

	/**
	 * @param role_id the role_id to set
	 */
	public void setRole_id(int role_id) 
	{
		this.role_id = role_id;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() 
	{
		return serialVersionUID;
	}
	
}
