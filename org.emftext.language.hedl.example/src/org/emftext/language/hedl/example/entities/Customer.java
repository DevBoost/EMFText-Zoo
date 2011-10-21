package org.emftext.language.hedl.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Customer"
)
// this class is generated. any change will be overridden.
public class Customer {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	private java.lang.String firstname;
	
	private java.lang.String lastname;
	
	/**
	 * Default constructor. Only used by Hibernate.
	 */
	public Customer() {
		super();
	}

	public int getId() {
		return id;
	}

	@Deprecated
	public void setId(int id) {
		this.id = id;
	}

	public java.lang.String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(java.lang.String newValue) {
		this.firstname = newValue;
	}
	
	public java.lang.String getLastname() {
		return lastname;
	}
	
	public void setLastname(java.lang.String newValue) {
		this.lastname = newValue;
	}
	
}
