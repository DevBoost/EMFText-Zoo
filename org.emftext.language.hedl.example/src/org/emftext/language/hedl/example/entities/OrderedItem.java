package org.emftext.language.hedl.example.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "OrderedItem"
)
/*
 * This class is generated from the entity 'OrderedItem' defined in the HEDL model.
 * Note: Any change made to this class will be overridden.
 */
public class OrderedItem {
	
	@GenericGenerator(name="OrderedItemIdGenerator", strategy="org.hibernate.id.MultipleHiLoPerTableGenerator",
	  parameters = {
	    @Parameter(name="table", value="IdentityGenerator"),
	    @Parameter(name="primary_key_column", value="sequence_name"),
	    @Parameter(name="primary_key_value", value="OrderedItem"),
	    @Parameter(name="value_column", value="next_hi_value"),
	    @Parameter(name="primary_key_length", value="100"),
	    @Parameter(name="max_lo", value="1000")
	  }
	)
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE, generator="OrderedItemIdGenerator")
	private int id;

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="item", nullable=false)
	private Item item;
	
	/**
	 * Default constructor. Only used by Hibernate.
	 */
	public OrderedItem() {
		super();
	}

	/**
	 * Returns the automatically generated id the identifies this entity object.
	 */
	public int getId() {
		return id;
	}

	/**
	 * The property 'id' is read-only. 
	 * This setter is only provided for Hibernate. 
	 * It must not be used directly.
	 */
	@Deprecated
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the value of property 'item'.
	 */
	public Item getItem() {
		return item;
	}
	
	/**
	 * Sets the value of property 'item'.
	 */
	public void setItem(Item newValue) {
		this.item = newValue;
	}
	
}
