package org.emftext.language.hedl.example.dao;

import org.emftext.language.hedl.example.entities.Supplier;
import org.emftext.language.hedl.example.entities.SupplierItem;
import org.hibernate.classic.Session;

// this class is generated. any change will be overridden.
public class SupplierItemDAO {
	
	public final static String FIELD__ID = getField(SupplierItem.class, "id");
	public final static String FIELD__SUPPLIERITEMNUMBER = getField(SupplierItem.class, "supplierItemNumber");
	public final static String FIELD__SUPPLIER = getField(SupplierItem.class, "supplier");
	public final static String FIELD__ITEM = getField(SupplierItem.class, "item");
	public final static String FIELD__SUPPLIERPRICE = getField(SupplierItem.class, "supplierPrice");
	public final static String FIELD__LASTUPDATE = getField(SupplierItem.class, "lastUpdate");
	
	/**
	 * Creates a SupplierItem using all read-only properties.
	 */
	public SupplierItem create(Session session, java.lang.String supplierItemNumber, Supplier supplier) {
		SupplierItem newEntity = new SupplierItem(supplierItemNumber, supplier);
		session.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the SupplierItem with the given id.
	 */
	public SupplierItem get(Session session, int id) {
		SupplierItem entity = (SupplierItem) session.get(SupplierItem.class, id);
		return entity;
	}
	
	/**
	 * Deletes a SupplierItem.
	 */
	public void delete(Session session, SupplierItem entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of SupplierItem entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from SupplierItem").uniqueResult()).intValue();
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
