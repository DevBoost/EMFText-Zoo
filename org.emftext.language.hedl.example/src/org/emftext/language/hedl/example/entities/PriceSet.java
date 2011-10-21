package org.emftext.language.hedl.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PriceSet"
)
// this class is generated. any change will be overridden.
public class PriceSet {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	private double sellingPrice;
	
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date lastUpdate;
	
	/**
	 * Default constructor. Only used by Hibernate.
	 */
	public PriceSet() {
		super();
	}

	public int getId() {
		return id;
	}

	@Deprecated
	public void setId(int id) {
		this.id = id;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}
	
	public void setSellingPrice(double newValue) {
		this.sellingPrice = newValue;
	}
	
	public java.util.Date getLastUpdate() {
		return lastUpdate;
	}
	
	public void setLastUpdate(java.util.Date newValue) {
		this.lastUpdate = newValue;
	}
	
}
