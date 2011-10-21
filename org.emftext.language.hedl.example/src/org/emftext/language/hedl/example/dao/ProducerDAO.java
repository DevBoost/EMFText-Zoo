package org.emftext.language.hedl.example.dao;

import org.emftext.language.hedl.example.entities.Producer;
import org.hibernate.classic.Session;

// this class is generated. any change will be overridden.
public class ProducerDAO {
	
	public final static String FIELD__ID = getField(Producer.class, "id");
	public final static String FIELD__NAME = getField(Producer.class, "name");
	
	/**
	 * Creates a Producer using all read-only properties.
	 */
	public Producer create(Session session) {
		Producer newEntity = new Producer();
		session.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Producer with the given id.
	 */
	public Producer get(Session session, int id) {
		Producer entity = (Producer) session.get(Producer.class, id);
		return entity;
	}
	
	/**
	 * Deletes a Producer.
	 */
	public void delete(Session session, Producer entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of Producer entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from Producer").uniqueResult()).intValue();
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
