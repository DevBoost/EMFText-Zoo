package org.emftext.language.hedl.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Producer"
)
// this class is generated. any change will be overridden.
public class Producer {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	private java.lang.String name;
	
	/**
	 * Default constructor. Only used by Hibernate.
	 */
	public Producer() {
		super();
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
	
}
