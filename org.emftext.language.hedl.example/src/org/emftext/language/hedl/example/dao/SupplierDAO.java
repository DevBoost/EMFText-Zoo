package org.emftext.language.hedl.example.dao;

import org.emftext.language.hedl.example.entities.Supplier;
import org.hibernate.classic.Session;

// this class is generated. any change will be overridden.
public class SupplierDAO {
	
	public final static String FIELD__ID = getField(Supplier.class, "id");
	public final static String FIELD__NAME = getField(Supplier.class, "name");
	public final static String FIELD__WAREHOUSE = getField(Supplier.class, "warehouse");
	
	/**
	 * Creates a Supplier using all read-only properties.
	 */
	public Supplier create(Session session, java.lang.String name) {
		Supplier newEntity = new Supplier(name);
		session.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Supplier with the given id.
	 */
	public Supplier get(Session session, int id) {
		Supplier entity = (Supplier) session.get(Supplier.class, id);
		return entity;
	}
	
	/**
	 * Deletes a Supplier.
	 */
	public void delete(Session session, Supplier entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of Supplier entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from Supplier").uniqueResult()).intValue();
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
