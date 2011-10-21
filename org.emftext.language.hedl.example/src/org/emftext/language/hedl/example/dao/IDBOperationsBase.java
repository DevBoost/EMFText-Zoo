package org.emftext.language.hedl.example.dao;

import org.emftext.language.hedl.example.entities.Customer;
import org.emftext.language.hedl.example.entities.CustomerOrder;
import org.emftext.language.hedl.example.entities.Item;
import org.emftext.language.hedl.example.entities.OrderedItem;
import org.emftext.language.hedl.example.entities.PriceSet;
import org.emftext.language.hedl.example.entities.Producer;
import org.emftext.language.hedl.example.entities.Supplier;
import org.emftext.language.hedl.example.entities.SupplierItem;
import org.emftext.language.hedl.example.entities.Warehouse;


// this class is generated. any change will be overridden.
public interface IDBOperationsBase {
	
	/**
	 * Creates a new Producer using all read-only properties.
	 */
	public Producer createProducer();
	
	/**
	 * Returns the Producer with the given id.
	 */
	public Producer getProducer(int id);
		
	/**
	 * Deletes a Producer.
	 */
	public void delete(Producer entity);
	
	/**
	 * Counts the number of Producer entities.
	 */
	public int countProducers();
	
	/**
	 * Creates a new PriceSet using all read-only properties.
	 */
	public PriceSet createPriceSet();
	
	/**
	 * Returns the PriceSet with the given id.
	 */
	public PriceSet getPriceSet(int id);
		
	/**
	 * Deletes a PriceSet.
	 */
	public void delete(PriceSet entity);
	
	/**
	 * Counts the number of PriceSet entities.
	 */
	public int countPriceSets();
	
	/**
	 * Creates a new Item using all read-only properties.
	 */
	public Item createItem(PriceSet priceSet);
	
	/**
	 * Returns the Item with the given id.
	 */
	public Item getItem(int id);
		
	/**
	 * Deletes a Item.
	 */
	public void delete(Item entity);
	
	/**
	 * Counts the number of Item entities.
	 */
	public int countItems();
	
	/**
	 * Creates a new SupplierItem using all read-only properties.
	 */
	public SupplierItem createSupplierItem(java.lang.String supplierItemNumber, Supplier supplier);
	
	/**
	 * Returns the SupplierItem with the given id.
	 */
	public SupplierItem getSupplierItem(int id);
		
	/**
	 * Deletes a SupplierItem.
	 */
	public void delete(SupplierItem entity);
	
	/**
	 * Counts the number of SupplierItem entities.
	 */
	public int countSupplierItems();
	
	/**
	 * Creates a new Supplier using all read-only properties.
	 */
	public Supplier createSupplier(java.lang.String name);
	
	/**
	 * Returns the Supplier with the given id.
	 */
	public Supplier getSupplier(int id);
		
	/**
	 * Deletes a Supplier.
	 */
	public void delete(Supplier entity);
	
	/**
	 * Counts the number of Supplier entities.
	 */
	public int countSuppliers();
	
	/**
	 * Creates a new Warehouse using all read-only properties.
	 */
	public Warehouse createWarehouse(java.lang.String name);
	
	/**
	 * Returns the Warehouse with the given id.
	 */
	public Warehouse getWarehouse(int id);
		
	/**
	 * Deletes a Warehouse.
	 */
	public void delete(Warehouse entity);
	
	/**
	 * Counts the number of Warehouse entities.
	 */
	public int countWarehouses();
	
	/**
	 * Creates a new CustomerOrder using all read-only properties.
	 */
	public CustomerOrder createCustomerOrder();
	
	/**
	 * Returns the CustomerOrder with the given id.
	 */
	public CustomerOrder getCustomerOrder(int id);
		
	/**
	 * Deletes a CustomerOrder.
	 */
	public void delete(CustomerOrder entity);
	
	/**
	 * Counts the number of CustomerOrder entities.
	 */
	public int countCustomerOrders();
	
	/**
	 * Creates a new OrderedItem using all read-only properties.
	 */
	public OrderedItem createOrderedItem();
	
	/**
	 * Returns the OrderedItem with the given id.
	 */
	public OrderedItem getOrderedItem(int id);
		
	/**
	 * Deletes a OrderedItem.
	 */
	public void delete(OrderedItem entity);
	
	/**
	 * Counts the number of OrderedItem entities.
	 */
	public int countOrderedItems();
	
	/**
	 * Creates a new Customer using all read-only properties.
	 */
	public Customer createCustomer();
	
	/**
	 * Returns the Customer with the given id.
	 */
	public Customer getCustomer(int id);
		
	/**
	 * Deletes a Customer.
	 */
	public void delete(Customer entity);
	
	/**
	 * Counts the number of Customer entities.
	 */
	public int countCustomers();
	
}
