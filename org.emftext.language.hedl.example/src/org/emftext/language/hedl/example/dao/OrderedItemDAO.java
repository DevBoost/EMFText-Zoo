package org.emftext.language.hedl.example.dao;

import org.emftext.language.hedl.example.entities.OrderedItem;
import org.hibernate.classic.Session;

// this class is generated. any change will be overridden.
public class OrderedItemDAO {
	
	public final static String FIELD__ID = getField(OrderedItem.class, "id");
	public final static String FIELD__ITEM = getField(OrderedItem.class, "item");
	
	/**
	 * Creates a OrderedItem using all read-only properties.
	 */
	public OrderedItem create(Session session) {
		OrderedItem newEntity = new OrderedItem();
		session.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the OrderedItem with the given id.
	 */
	public OrderedItem get(Session session, int id) {
		OrderedItem entity = (OrderedItem) session.get(OrderedItem.class, id);
		return entity;
	}
	
	/**
	 * Deletes a OrderedItem.
	 */
	public void delete(Session session, OrderedItem entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of OrderedItem entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from OrderedItem").uniqueResult()).intValue();
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
