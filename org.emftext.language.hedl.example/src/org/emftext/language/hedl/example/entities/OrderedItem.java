package org.emftext.language.hedl.example.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "OrderedItem"
)
// this class is generated. any change will be overridden.
public class OrderedItem {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
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

	public int getId() {
		return id;
	}

	@Deprecated
	public void setId(int id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}
	
	public void setItem(Item newValue) {
		this.item = newValue;
	}
	
}
