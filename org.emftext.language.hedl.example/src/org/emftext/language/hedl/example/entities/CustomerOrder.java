package org.emftext.language.hedl.example.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CustomerOrder"
)
// this class is generated. any change will be overridden.
public class CustomerOrder {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	@OneToMany(cascade={CascadeType.ALL})
	private List<OrderedItem> items;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="customer", nullable=false)
	private Customer customer;
	
	/**
	 * Default constructor. Only used by Hibernate.
	 */
	public CustomerOrder() {
		super();
	}

	public int getId() {
		return id;
	}

	@Deprecated
	public void setId(int id) {
		this.id = id;
	}

	public List<OrderedItem> getItems() {
		return items;
	}
	
	public void setItems(List<OrderedItem> newValue) {
		this.items = newValue;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer newValue) {
		this.customer = newValue;
	}
	
}
