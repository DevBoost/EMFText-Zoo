package org.emftext.language.hedl.example.dao;

import org.emftext.language.hedl.example.entities.Customer;
import org.hibernate.classic.Session;

// this class is generated. any change will be overridden.
public class CustomerDAO {
	
	public final static String FIELD__ID = getField(Customer.class, "id");
	public final static String FIELD__FIRSTNAME = getField(Customer.class, "firstname");
	public final static String FIELD__LASTNAME = getField(Customer.class, "lastname");
	
	/**
	 * Creates a Customer using all read-only properties.
	 */
	public Customer create(Session session) {
		Customer newEntity = new Customer();
		session.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Customer with the given id.
	 */
	public Customer get(Session session, int id) {
		Customer entity = (Customer) session.get(Customer.class, id);
		return entity;
	}
	
	/**
	 * Deletes a Customer.
	 */
	public void delete(Session session, Customer entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of Customer entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from Customer").uniqueResult()).intValue();
	}
		
	private static String getField(Class<?> clazz, String fieldName) {
		try {
			return clazz.getDeclaredField(fieldName).getName();
		} catch (SecurityException e) {
			throw new RuntimeException(e.getClass().getSimpleName() + ": " + e.getMessage());
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e.getClass().getSimpleName() + ": " + e.getMessage());
		}
	}
}
