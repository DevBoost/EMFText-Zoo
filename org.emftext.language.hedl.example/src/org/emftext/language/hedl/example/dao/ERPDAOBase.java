package org.emftext.language.hedl.example.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.emftext.language.hedl.example.custom.IDBOperations;
import org.emftext.language.hedl.example.custom.OperationProvider;
import org.emftext.language.hedl.example.entities.Customer;
import org.emftext.language.hedl.example.entities.CustomerOrder;
import org.emftext.language.hedl.example.entities.Item;
import org.emftext.language.hedl.example.entities.OrderedItem;
import org.emftext.language.hedl.example.entities.PriceSet;
import org.emftext.language.hedl.example.entities.Producer;
import org.emftext.language.hedl.example.entities.Supplier;
import org.emftext.language.hedl.example.entities.SupplierItem;
import org.emftext.language.hedl.example.entities.Warehouse;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;


// this class is generated. any change will be overridden.
public class ERPDAOBase implements IDBOperationsBase {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	private SessionFactory sessionFactory;

	public ERPDAOBase() {
		configure();
	}

	private void configure() throws HibernateException {
		Configuration configuration = getConfiguration();
		//configuration.setProperty("hibernate.show_sql", "true");
		this.sessionFactory = configuration.buildSessionFactory();
	}

	private Configuration getConfiguration() {
		Configuration configuration = new Configuration();
		configuration = configuration.addAnnotatedClass(Producer.class);
		configuration = configuration.addAnnotatedClass(PriceSet.class);
		configuration = configuration.addAnnotatedClass(Item.class);
		configuration = configuration.addAnnotatedClass(SupplierItem.class);
		configuration = configuration.addAnnotatedClass(Supplier.class);
		configuration = configuration.addAnnotatedClass(Warehouse.class);
		configuration = configuration.addAnnotatedClass(CustomerOrder.class);
		configuration = configuration.addAnnotatedClass(OrderedItem.class);
		configuration = configuration.addAnnotatedClass(Customer.class);
		return configuration;
	}
	
	public void createSchema() throws HibernateException {
		SchemaExport schemaExport = new SchemaExport(getConfiguration());
		schemaExport.setFormat(true);
		schemaExport.create(false, false);
	}

	public void updateSchema() {
		SchemaUpdate update = new SchemaUpdate(getConfiguration());
		update.execute(true, true);
		List<?> exceptions = update.getExceptions();
		for (Object object : exceptions) {
			System.err.println("Exception while updating schema " + object);
		}
	}
	
	public void executeInTransaction(ICommand command) {
		executeInTransaction(command, true);
	}
	
	private void executeInTransaction(ICommand command, boolean retry) {
		boolean successfull = false;
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.setTimeout(5);
			command.execute(new OperationProvider(session));
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				try {
					tx.rollback();
				} catch (TransactionException te) {
					logger.log(Level.SEVERE, "TransactionException: " + te.getMessage());
				}
			}
			e.printStackTrace();
			logger.log(Level.SEVERE, "Exception (" + e.getClass().getName() + "): " + e.getMessage());
		} finally {
			try {
				session.close();
				successfull = true;
			} catch (HibernateException he) {
				logger.log(Level.SEVERE, "HibernateException: " + he.getMessage());
			}
		}
		
		if (!successfull && retry) {
			// retry once
			executeInTransaction(command, false);
		}
	}
	
	public void tearDown() {
		sessionFactory.close();
	}

	/**
	 * Creates a new Producer using all read-only properties.
	 */
	public Producer createProducer() {
		final Producer[] entity = new Producer[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Producer with the given id.
	 */
	public Producer getProducer(int id) {
		final Producer[] entity = new Producer[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
		return entity[0];
	}
	
	/**
	 * Deletes a Producer.
	 */
	public void delete(Producer entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
	}
	
	/**
	 * Counts the number of Producer entities.
	 */
	public int countProducers() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countProducers();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new PriceSet using all read-only properties.
	 */
	public PriceSet createPriceSet() {
		final PriceSet[] entity = new PriceSet[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the PriceSet with the given id.
	 */
	public PriceSet getPriceSet(int id) {
		final PriceSet[] entity = new PriceSet[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
		return entity[0];
	}
	
	/**
	 * Deletes a PriceSet.
	 */
	public void delete(PriceSet entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
	}
	
	/**
	 * Counts the number of PriceSet entities.
	 */
	public int countPriceSets() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countPriceSets();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Item using all read-only properties.
	 */
	public Item createItem(PriceSet priceSet) {
		final Item[] entity = new Item[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Item with the given id.
	 */
	public Item getItem(int id) {
		final Item[] entity = new Item[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
		return entity[0];
	}
	
	/**
	 * Deletes a Item.
	 */
	public void delete(Item entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
	}
	
	/**
	 * Counts the number of Item entities.
	 */
	public int countItems() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countItems();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new SupplierItem using all read-only properties.
	 */
	public SupplierItem createSupplierItem(java.lang.String supplierItemNumber, Supplier supplier) {
		final SupplierItem[] entity = new SupplierItem[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the SupplierItem with the given id.
	 */
	public SupplierItem getSupplierItem(int id) {
		final SupplierItem[] entity = new SupplierItem[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
		return entity[0];
	}
	
	/**
	 * Deletes a SupplierItem.
	 */
	public void delete(SupplierItem entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
	}
	
	/**
	 * Counts the number of SupplierItem entities.
	 */
	public int countSupplierItems() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countSupplierItems();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Supplier using all read-only properties.
	 */
	public Supplier createSupplier(java.lang.String name) {
		final Supplier[] entity = new Supplier[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Supplier with the given id.
	 */
	public Supplier getSupplier(int id) {
		final Supplier[] entity = new Supplier[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
		return entity[0];
	}
	
	/**
	 * Deletes a Supplier.
	 */
	public void delete(Supplier entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
	}
	
	/**
	 * Counts the number of Supplier entities.
	 */
	public int countSuppliers() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countSuppliers();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Warehouse using all read-only properties.
	 */
	public Warehouse createWarehouse(java.lang.String name) {
		final Warehouse[] entity = new Warehouse[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Warehouse with the given id.
	 */
	public Warehouse getWarehouse(int id) {
		final Warehouse[] entity = new Warehouse[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
		return entity[0];
	}
	
	/**
	 * Deletes a Warehouse.
	 */
	public void delete(Warehouse entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
	}
	
	/**
	 * Counts the number of Warehouse entities.
	 */
	public int countWarehouses() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countWarehouses();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new CustomerOrder using all read-only properties.
	 */
	public CustomerOrder createCustomerOrder() {
		final CustomerOrder[] entity = new CustomerOrder[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the CustomerOrder with the given id.
	 */
	public CustomerOrder getCustomerOrder(int id) {
		final CustomerOrder[] entity = new CustomerOrder[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
		return entity[0];
	}
	
	/**
	 * Deletes a CustomerOrder.
	 */
	public void delete(CustomerOrder entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
	}
	
	/**
	 * Counts the number of CustomerOrder entities.
	 */
	public int countCustomerOrders() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countCustomerOrders();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new OrderedItem using all read-only properties.
	 */
	public OrderedItem createOrderedItem() {
		final OrderedItem[] entity = new OrderedItem[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the OrderedItem with the given id.
	 */
	public OrderedItem getOrderedItem(int id) {
		final OrderedItem[] entity = new OrderedItem[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
		return entity[0];
	}
	
	/**
	 * Deletes a OrderedItem.
	 */
	public void delete(OrderedItem entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
	}
	
	/**
	 * Counts the number of OrderedItem entities.
	 */
	public int countOrderedItems() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countOrderedItems();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Customer using all read-only properties.
	 */
	public Customer createCustomer() {
		final Customer[] entity = new Customer[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Customer with the given id.
	 */
	public Customer getCustomer(int id) {
		final Customer[] entity = new Customer[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
		return entity[0];
	}
	
	/**
	 * Deletes a Customer.
	 */
	public void delete(Customer entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
			}
		});
	}
	
	/**
	 * Counts the number of Customer entities.
	 */
	public int countCustomers() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countCustomers();
			}
		});
		return count[0];
	}
	
}
