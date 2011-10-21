package org.emftext.language.hedl.example.dao;

import org.emftext.language.hedl.example.entities.CustomerOrder;
import org.hibernate.classic.Session;

// this class is generated. any change will be overridden.
public class CustomerOrderDAO {
	
	public final static String FIELD__ID = getField(CustomerOrder.class, "id");
	public final static String FIELD__ITEMS = getField(CustomerOrder.class, "items");
	public final static String FIELD__CUSTOMER = getField(CustomerOrder.class, "customer");
	
	/**
	 * Creates a CustomerOrder using all read-only properties.
	 */
	public CustomerOrder create(Session session) {
		CustomerOrder newEntity = new CustomerOrder();
		session.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the CustomerOrder with the given id.
	 */
	public CustomerOrder get(Session session, int id) {
		CustomerOrder entity = (CustomerOrder) session.get(CustomerOrder.class, id);
		return entity;
	}
	
	/**
	 * Deletes a CustomerOrder.
	 */
	public void delete(Session session, CustomerOrder entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of CustomerOrder entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from CustomerOrder").uniqueResult()).intValue();
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
