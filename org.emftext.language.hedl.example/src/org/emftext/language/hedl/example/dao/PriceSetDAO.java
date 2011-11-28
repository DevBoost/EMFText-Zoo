package org.emftext.language.hedl.example.dao;

import java.util.List;

import org.emftext.language.hedl.example.entities.PriceSet;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type PriceSet.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class PriceSetDAO {
	
	public final static String FIELD__ID = getField(PriceSet.class, "id");
	public final static String FIELD__SELLINGPRICE = getField(PriceSet.class, "sellingPrice");
	public final static String FIELD__LASTUPDATE = getField(PriceSet.class, "lastUpdate");
	
	/**
	 * Creates a PriceSet using all read-only properties.
	 */
	public PriceSet create(Session session) {
		PriceSet newEntity = new PriceSet();
		session.save(newEntity);
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
	 * Returns all entities of type PriceSet.
	 */
	public List<PriceSet> getAll(Session session) {
		Criteria criteria = session.createCriteria(PriceSet.class);
		@SuppressWarnings("unchecked")
		List<PriceSet> entities = (List<PriceSet>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type PriceSet.
	 */
	public List<PriceSet> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(PriceSet.class);
		Disjunction disjunction = Restrictions.disjunction();
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<PriceSet> entities = (List<PriceSet>) criteria.list();
		return entities;
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
