package org.emftext.language.hedl.example.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "SupplierItem"
)
// this class is generated. any change will be overridden.
public class SupplierItem {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	private java.lang.String supplierItemNumber;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="supplier", updatable=false, nullable=false)
	private Supplier supplier;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="item", nullable=false)
	private Item item;
	
	private double supplierPrice;
	
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date lastUpdate;
	
	/**
	 * Default constructor. Only used by Hibernate.
	 */
	public SupplierItem() {
		super();
	}

	/**
	 * Constructor using all read-only properties.
	 */
	public SupplierItem(java.lang.String supplierItemNumber, Supplier supplier) {
		super();
		this.supplierItemNumber = supplierItemNumber;
		this.supplier = supplier;
	}
	
	public int getId() {
		return id;
	}

	@Deprecated
	public void setId(int id) {
		this.id = id;
	}

	public java.lang.String getSupplierItemNumber() {
		return supplierItemNumber;
	}
	
	/**
	 * This property is read-only. The setter is only provided for Hibernate.
	 */
	@Deprecated
	public void setSupplierItemNumber(java.lang.String newValue) {
		this.supplierItemNumber = newValue;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}
	
	/**
	 * This property is read-only. The setter is only provided for Hibernate.
	 */
	@Deprecated
	public void setSupplier(Supplier newValue) {
		this.supplier = newValue;
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item newValue) {
		this.item = newValue;
	}
	
	public double getSupplierPrice() {
		return supplierPrice;
	}
	
	public void setSupplierPrice(double newValue) {
		this.supplierPrice = newValue;
	}
	
	public java.util.Date getLastUpdate() {
		return lastUpdate;
	}
	
	public void setLastUpdate(java.util.Date newValue) {
		this.lastUpdate = newValue;
	}
	
}
