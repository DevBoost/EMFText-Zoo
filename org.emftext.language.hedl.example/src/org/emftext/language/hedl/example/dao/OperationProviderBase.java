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
import org.hibernate.classic.Session;


public abstract class OperationProviderBase implements IDBOperationsBase {
		
	private Session session;
	
	private ProducerDAO producerDAO = new ProducerDAO();
	private PriceSetDAO priceSetDAO = new PriceSetDAO();
	private ItemDAO itemDAO = new ItemDAO();
	private SupplierItemDAO supplierItemDAO = new SupplierItemDAO();
	private SupplierDAO supplierDAO = new SupplierDAO();
	private WarehouseDAO warehouseDAO = new WarehouseDAO();
	private CustomerOrderDAO customerOrderDAO = new CustomerOrderDAO();
	private OrderedItemDAO orderedItemDAO = new OrderedItemDAO();
	private CustomerDAO customerDAO = new CustomerDAO();

	public OperationProviderBase(Session session) {
		this.session = session;
	}
	
	public Session getSession() {
		return session;
	}
	
	/** Create method using all read-only properties. */
	public Producer createProducer() {
		return producerDAO.create(session);
	}
	
	/**
	 * Returns the Producer with the given id.
	 */
	public Producer getProducer(int id) {
		Producer entity = producerDAO.get(session, id);
		return entity;
	}
	
	/**
	 * Deletes a Producer.
	 */
	public void delete(Producer entity) {
		producerDAO.delete(session, entity);
	}
	
	/**
	 * Counts the number of Producer entities.
	 */
	public int countProducers() {
		return producerDAO.count(session);
	}
	
	/** Create method using all read-only properties. */
	public PriceSet createPriceSet() {
		return priceSetDAO.create(session);
	}
	
	/**
	 * Returns the PriceSet with the given id.
	 */
	public PriceSet getPriceSet(int id) {
		PriceSet entity = priceSetDAO.get(session, id);
		return entity;
	}
	
	/**
	 * Deletes a PriceSet.
	 */
	public void delete(PriceSet entity) {
		priceSetDAO.delete(session, entity);
	}
	
	/**
	 * Counts the number of PriceSet entities.
	 */
	public int countPriceSets() {
		return priceSetDAO.count(session);
	}
	
	/** Create method using all read-only properties. */
	public Item createItem(PriceSet priceSet) {
		return itemDAO.create(session, priceSet);
	}
	
	/**
	 * Returns the Item with the given id.
	 */
	public Item getItem(int id) {
		Item entity = itemDAO.get(session, id);
		return entity;
	}
	
	/**
	 * Deletes a Item.
	 */
	public void delete(Item entity) {
		itemDAO.delete(session, entity);
	}
	
	/**
	 * Counts the number of Item entities.
	 */
	public int countItems() {
		return itemDAO.count(session);
	}
	
	/** Create method using all read-only properties. */
	public SupplierItem createSupplierItem(java.lang.String supplierItemNumber, Supplier supplier) {
		return supplierItemDAO.create(session, supplierItemNumber, supplier);
	}
	
	/**
	 * Returns the SupplierItem with the given id.
	 */
	public SupplierItem getSupplierItem(int id) {
		SupplierItem entity = supplierItemDAO.get(session, id);
		return entity;
	}
	
	/**
	 * Deletes a SupplierItem.
	 */
	public void delete(SupplierItem entity) {
		supplierItemDAO.delete(session, entity);
	}
	
	/**
	 * Counts the number of SupplierItem entities.
	 */
	public int countSupplierItems() {
		return supplierItemDAO.count(session);
	}
	
	/** Create method using all read-only properties. */
	public Supplier createSupplier(java.lang.String name) {
		return supplierDAO.create(session, name);
	}
	
	/**
	 * Returns the Supplier with the given id.
	 */
	public Supplier getSupplier(int id) {
		Supplier entity = supplierDAO.get(session, id);
		return entity;
	}
	
	/**
	 * Deletes a Supplier.
	 */
	public void delete(Supplier entity) {
		supplierDAO.delete(session, entity);
	}
	
	/**
	 * Counts the number of Supplier entities.
	 */
	public int countSuppliers() {
		return supplierDAO.count(session);
	}
	
	/** Create method using all read-only properties. */
	public Warehouse createWarehouse(java.lang.String name) {
		return warehouseDAO.create(session, name);
	}
	
	/**
	 * Returns the Warehouse with the given id.
	 */
	public Warehouse getWarehouse(int id) {
		Warehouse entity = warehouseDAO.get(session, id);
		return entity;
	}
	
	/**
	 * Deletes a Warehouse.
	 */
	public void delete(Warehouse entity) {
		warehouseDAO.delete(session, entity);
	}
	
	/**
	 * Counts the number of Warehouse entities.
	 */
	public int countWarehouses() {
		return warehouseDAO.count(session);
	}
	
	/** Create method using all read-only properties. */
	public CustomerOrder createCustomerOrder() {
		return customerOrderDAO.create(session);
	}
	
	/**
	 * Returns the CustomerOrder with the given id.
	 */
	public CustomerOrder getCustomerOrder(int id) {
		CustomerOrder entity = customerOrderDAO.get(session, id);
		return entity;
	}
	
	/**
	 * Deletes a CustomerOrder.
	 */
	public void delete(CustomerOrder entity) {
		customerOrderDAO.delete(session, entity);
	}
	
	/**
	 * Counts the number of CustomerOrder entities.
	 */
	public int countCustomerOrders() {
		return customerOrderDAO.count(session);
	}
	
	/** Create method using all read-only properties. */
	public OrderedItem createOrderedItem() {
		return orderedItemDAO.create(session);
	}
	
	/**
	 * Returns the OrderedItem with the given id.
	 */
	public OrderedItem getOrderedItem(int id) {
		OrderedItem entity = orderedItemDAO.get(session, id);
		return entity;
	}
	
	/**
	 * Deletes a OrderedItem.
	 */
	public void delete(OrderedItem entity) {
		orderedItemDAO.delete(session, entity);
	}
	
	/**
	 * Counts the number of OrderedItem entities.
	 */
	public int countOrderedItems() {
		return orderedItemDAO.count(session);
	}
	
	/** Create method using all read-only properties. */
	public Customer createCustomer() {
		return customerDAO.create(session);
	}
	
	/**
	 * Returns the Customer with the given id.
	 */
	public Customer getCustomer(int id) {
		Customer entity = customerDAO.get(session, id);
		return entity;
	}
	
	/**
	 * Deletes a Customer.
	 */
	public void delete(Customer entity) {
		customerDAO.delete(session, entity);
	}
	
	/**
	 * Counts the number of Customer entities.
	 */
	public int countCustomers() {
		return customerDAO.count(session);
	}
	
}
