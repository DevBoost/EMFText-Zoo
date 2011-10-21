package org.emftext.language.hedl.example.dao;

import org.emftext.language.hedl.example.entities.Item;
import org.emftext.language.hedl.example.entities.PriceSet;
import org.hibernate.classic.Session;

// this class is generated. any change will be overridden.
public class ItemDAO {
	
	public final static String FIELD__ID = getField(Item.class, "id");
	public final static String FIELD__NAME = getField(Item.class, "name");
	public final static String FIELD__PRICESET = getField(Item.class, "priceSet");
	public final static String FIELD__PRODUCER = getField(Item.class, "producer");
	
	/**
	 * Creates a Item using all read-only properties.
	 */
	public Item create(Session session, PriceSet priceSet) {
		Item newEntity = new Item(priceSet);
		session.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Item with the given id.
	 */
	public Item get(Session session, int id) {
		Item entity = (Item) session.get(Item.class, id);
		return entity;
	}
	
	/**
	 * Deletes a Item.
	 */
	public void delete(Session session, Item entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of Item entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from Item").uniqueResult()).intValue();
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
