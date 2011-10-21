package org.emftext.language.hedl.example.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Supplier"
)
// this class is generated. any change will be overridden.
public class Supplier {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	private java.lang.String name;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="warehouse", nullable=true)
	private Warehouse warehouse;
	
	/**
	 * Default constructor. Only used by Hibernate.
	 */
	public Supplier() {
		super();
	}

	/**
	 * Constructor using all read-only properties.
	 */
	public Supplier(java.lang.String name) {
		super();
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	@Deprecated
	public void setId(int id) {
		this.id = id;
	}

	public java.lang.String getName() {
		return name;
	}
	
	/**
	 * This property is read-only. The setter is only provided for Hibernate.
	 */
	@Deprecated
	public void setName(java.lang.String newValue) {
		this.name = newValue;
	}
	
	public Warehouse getWarehouse() {
		return warehouse;
	}
	
	public void setWarehouse(Warehouse newValue) {
		this.warehouse = newValue;
	}
	
}
