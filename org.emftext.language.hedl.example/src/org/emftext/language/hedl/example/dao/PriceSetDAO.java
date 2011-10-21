package org.emftext.language.hedl.example.dao;

import org.emftext.language.hedl.example.entities.PriceSet;
import org.hibernate.classic.Session;

// this class is generated. any change will be overridden.
public class PriceSetDAO {
	
	public final static String FIELD__ID = getField(PriceSet.class, "id");
	public final static String FIELD__SELLINGPRICE = getField(PriceSet.class, "sellingPrice");
	public final static String FIELD__LASTUPDATE = getField(PriceSet.class, "lastUpdate");
	
	/**
	 * Creates a PriceSet using all read-only properties.
	 */
	public PriceSet create(Session session) {
		PriceSet newEntity = new PriceSet();
		session.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the PriceSet with the given id.
	 */
	public PriceSet get(Session session, int id) {
		PriceSet entity = (PriceSet) session.get(PriceSet.class, id);
		return entity;
	}
	
	/**
	 * Deletes a PriceSet.
	 */
	public void delete(Session session, PriceSet entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of PriceSet entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from PriceSet").uniqueResult()).intValue();
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
