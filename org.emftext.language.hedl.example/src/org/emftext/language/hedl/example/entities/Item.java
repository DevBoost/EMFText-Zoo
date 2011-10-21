package org.emftext.language.hedl.example.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Item"
)
// this class is generated. any change will be overridden.
public class Item {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	private java.lang.String name;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="priceSet", updatable=false, nullable=true)
	private PriceSet priceSet;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="producer", nullable=true)
	private Producer producer;
	
	/**
	 * Default constructor. Only used by Hibernate.
	 */
	public Item() {
		super();
	}

	/**
	 * Constructor using all read-only properties.
	 */
	public Item(PriceSet priceSet) {
		super();
		this.priceSet = priceSet;
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
	
	public void setName(java.lang.String newValue) {
		this.name = newValue;
	}
	
	public PriceSet getPriceSet() {
		return priceSet;
	}
	
	/**
	 * This property is read-only. The setter is only provided for Hibernate.
	 */
	@Deprecated
	public void setPriceSet(PriceSet newValue) {
		this.priceSet = newValue;
	}
	
	public Producer getProducer() {
		return producer;
	}
	
	public void setProducer(Producer newValue) {
		this.producer = newValue;
	}
	
}
