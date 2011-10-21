package org.emftext.language.hedl.example.dao;

import org.emftext.language.hedl.example.entities.Warehouse;
import org.hibernate.classic.Session;

// this class is generated. any change will be overridden.
public class WarehouseDAO {
	
	public final static String FIELD__ID = getField(Warehouse.class, "id");
	public final static String FIELD__NAME = getField(Warehouse.class, "name");
	
	/**
	 * Creates a Warehouse using all read-only properties.
	 */
	public Warehouse create(Session session, java.lang.String name) {
		Warehouse newEntity = new Warehouse(name);
		session.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Warehouse with the given id.
	 */
	public Warehouse get(Session session, int id) {
		Warehouse entity = (Warehouse) session.get(Warehouse.class, id);
		return entity;
	}
	
	/**
	 * Deletes a Warehouse.
	 */
	public void delete(Session session, Warehouse entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of Warehouse entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from Warehouse").uniqueResult()).intValue();
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
