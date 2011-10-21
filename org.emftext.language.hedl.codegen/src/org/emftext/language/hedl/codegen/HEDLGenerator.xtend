package org.emftext.language.hedl.codegen

import org.emftext.language.hedl.EntityModel
import org.emftext.language.hedl.Entity
import org.emftext.language.hedl.JavaType
import org.emftext.language.hedl.types.HedlBuiltinTypes
import org.emftext.language.hedl.UniqueConstraint

class HEDLGenerator {
	
	def generateICommand(String packageName) {
		return '''
		package «packageName».«HEDLCodegenConstants::DAO_PACKAGE_NAME»;
		
		import «packageName».«HEDLCodegenConstants::CUSTOM_PACKAGE_NAME».IDBOperations;

		// this class is generated. any change will be overridden.
		public interface ICommand {
			
			public void execute(IDBOperations operations);
		}
		'''
	}

	def generateOngoingShutdownException(String packageName) {
		return '''
		package «packageName».«HEDLCodegenConstants::DAO_PACKAGE_NAME»;

		// this class is generated. any change will be overridden.
		public class OngoingShutdownException extends RuntimeException {
			
			private static final long serialVersionUID = 997906627613716196L;
		}
		'''
	}

	def generateIDBOperations(String packageName) {
		return '''
		package «packageName».«HEDLCodegenConstants::CUSTOM_PACKAGE_NAME»;
		
		import «packageName».«HEDLCodegenConstants::DAO_PACKAGE_NAME».IDBOperationsBase;

		// this class is only generated once. it can be customized and all changes
		// will be preserved.
		public interface IDBOperations extends IDBOperationsBase {
			
		}
		'''
	}
	
	def generateIDBOperationsBase(String packageName, EntityModel entityModel) {
		return '''
		package «packageName».«HEDLCodegenConstants::DAO_PACKAGE_NAME»;

		«FOR otherEntity : entityModel.entities »
		import «packageName».«HEDLCodegenConstants::ENTITY_PACKAGE_NAME».«otherEntity.name»;
		«ENDFOR»
		
		«FOR otherEnum : entityModel.enums »
		import «packageName».«HEDLCodegenConstants::ENTITY_PACKAGE_NAME».«otherEnum.name»;
		«ENDFOR»

		// this class is generated. any change will be overridden.
		public interface IDBOperationsBase {
			
			«FOR entity : entityModel.entities »
		«var readOnlyProperties = entity.properties.filter(p | p.readonly) »
		«var uniqueProperties = entity.properties.filter(p | p.unique) »
			/**
			 * Creates a new «entity.name» using all read-only properties.
			 */
			public «entity.name» create«entity.name»(«FOR property : readOnlyProperties »«property.type.javaClassname» «property.name.toFirstLower»«IF readOnlyProperties.last != property», «ENDIF»«ENDFOR»);
			
			/**
			 * Returns the «entity.name» with the given id.
			 */
			public «entity.name» get«entity.name»(int id);
				
			«FOR property : uniqueProperties »
			/**
			 * Returns the «entity.name» with the given «property.name».
			 */
			public «entity.name» get«entity.name»By«property.name.toFirstUpper»(«property.type.javaClassname» «property.name»);
			
			«ENDFOR»
			«FOR constraint : entity.constraints »
			«IF constraint instanceof UniqueConstraint »
			«var uniqueConstraint = constraint as UniqueConstraint »
			/**
			 * Returns the «entity.name» with the given properties.
			 */
			public «entity.name» get«entity.name»By«FOR property : uniqueConstraint.properties»«property.name.toFirstUpper»«ENDFOR»(«FOR property : uniqueConstraint.properties»«property.type.javaClassname» «property.name»«IF uniqueConstraint.properties.last != property », «ENDIF»«ENDFOR»);
			
			«ENDIF»
			«ENDFOR»
			/**
			 * Deletes a «entity.name».
			 */
			public void delete(«entity.name» entity);
			
			/**
			 * Counts the number of «entity.name» entities.
			 */
			public int count«entity.name.toFirstUpper»s();
			
			«ENDFOR»
		}
		'''
	}

	def generateMainDAO(String packageName, String className) {
		return '''
		package «packageName».«HEDLCodegenConstants::CUSTOM_PACKAGE_NAME»;
		
		import «packageName».«HEDLCodegenConstants::DAO_PACKAGE_NAME».«className»Base;
		
		// this class is only generated once. it can be customized and all changes
		// will be preserved.
		public class «className» extends «className»Base {
			
		}
		''';
	}

	def generateMainDAOBase(String packageName, String className, EntityModel entityModel) {
		return '''
		package «packageName».«HEDLCodegenConstants::DAO_PACKAGE_NAME»;

		import java.util.List;
		
		import java.util.logging.Level;
		import java.util.logging.Logger;

		import org.hibernate.TransactionException;
		import org.hibernate.HibernateException;
		import org.hibernate.SessionFactory;
		import org.hibernate.Transaction;
		import org.hibernate.cfg.Configuration;
		import org.hibernate.classic.Session;

		import org.hibernate.tool.hbm2ddl.SchemaExport;
		import org.hibernate.tool.hbm2ddl.SchemaUpdate;

		import «packageName».«HEDLCodegenConstants::CUSTOM_PACKAGE_NAME».OperationProvider;
		import «packageName».«HEDLCodegenConstants::CUSTOM_PACKAGE_NAME».IDBOperations;
		
		«FOR otherEntity : entityModel.entities »
		import «packageName».«HEDLCodegenConstants::ENTITY_PACKAGE_NAME».«otherEntity.name»;
		«ENDFOR»

		«FOR otherEnum : entityModel.enums »
		import «packageName».«HEDLCodegenConstants::ENTITY_PACKAGE_NAME».«otherEnum.name»;
		«ENDFOR»

		// this class is generated. any change will be overridden.
		public class «className» implements IDBOperationsBase {
			
			private Logger logger = Logger.getLogger(getClass().getName());
			
			private SessionFactory sessionFactory;
		
			public «className»() {
				configure();
			}

			private void configure() throws HibernateException {
				Configuration configuration = getConfiguration();
				//configuration.setProperty("hibernate.show_sql", "true");
				this.sessionFactory = configuration.buildSessionFactory();
			}

			private Configuration getConfiguration() {
				Configuration configuration = new Configuration();
				«FOR entity : entityModel.entities »
				configuration = configuration.addAnnotatedClass(«entity.name».class);
				«ENDFOR»
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

			«FOR entity : entityModel.entities »
		«var readOnlyProperties = entity.properties.filter(p | p.readonly) »
		«var uniqueProperties = entity.properties.filter(p | p.unique) »
			/**
			 * Creates a new «entity.name» using all read-only properties.
			 */
			public «entity.name» create«entity.name»(«FOR property : readOnlyProperties »«property.type.javaClassname» «property.name.toFirstLower»«IF readOnlyProperties.last != property», «ENDIF»«ENDFOR») {
				final «entity.name»[] entity = new «entity.name»[1];
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						
					}
				});
				return entity[0];
			}
			
			/**
			 * Returns the «entity.name» with the given id.
			 */
			public «entity.name» get«entity.name»(int id) {
				final «entity.name»[] entity = new «entity.name»[1];
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						
					}
				});
				return entity[0];
			}
			
			«FOR property : uniqueProperties »
			/**
			 * Returns the «entity.name» with the given «property.name».
			 */
			public «entity.name» get«entity.name»By«property.name.toFirstUpper»(«property.type.javaClassname» «property.name») {
				final «entity.name»[] entity = new «entity.name»[1];
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						
					}
				});
				return entity[0];
			}
			
			«ENDFOR»
			«FOR constraint : entity.constraints »
			«IF constraint instanceof UniqueConstraint »
			«var uniqueConstraint = constraint as UniqueConstraint »
			/**
			 * Returns the «entity.name» with the given properties.
			 */
			public «entity.name» get«entity.name»By«FOR property : uniqueConstraint.properties»«property.name.toFirstUpper»«ENDFOR»(«FOR property : uniqueConstraint.properties»«property.type.javaClassname» «property.name»«IF uniqueConstraint.properties.last != property », «ENDIF»«ENDFOR») {
				final «entity.name»[] entity = new «entity.name»[1];
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						
					}
				});
				return entity[0];
			}
			
			«ENDIF»
			«ENDFOR»
			/**
			 * Deletes a «entity.name».
			 */
			public void delete(«entity.name» entity) {
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						
					}
				});
			}
			
			/**
			 * Counts the number of «entity.name» entities.
			 */
			public int count«entity.name.toFirstUpper»s() {
				final int[] count = new int[1];
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						count[0] = operations.count«entity.name.toFirstUpper»s();
					}
				});
				return count[0];
			}
			
			«ENDFOR»
		}
		'''
	}

	def generateOperationProvider(String packageName) {
		return '''
			package «packageName».«HEDLCodegenConstants::CUSTOM_PACKAGE_NAME»;

			import org.hibernate.classic.Session;
			import «packageName».«HEDLCodegenConstants::DAO_PACKAGE_NAME».OperationProviderBase;

			// this class is only generated once. it can be customized and all changes
			// will be preserved.
			public class OperationProvider extends OperationProviderBase implements IDBOperations {

				public OperationProvider(Session session) {
					super(session);
				}

			}
			'''
	}
				
	def generateOperationProviderBase(String packageName, EntityModel entityModel) {
		return '''
		package «packageName».«HEDLCodegenConstants::DAO_PACKAGE_NAME»;

		import org.hibernate.Criteria;
		import org.hibernate.HibernateException;
		import org.hibernate.SessionFactory;
		import org.hibernate.Transaction;
		import org.hibernate.cfg.Configuration;
		import org.hibernate.classic.Session;
		import org.hibernate.criterion.MatchMode;
		import org.hibernate.criterion.Order;
		import org.hibernate.criterion.Restrictions;
		
		«FOR otherEntity : entityModel.entities »
			import «packageName».«HEDLCodegenConstants::ENTITY_PACKAGE_NAME».«otherEntity.name»;
		«ENDFOR»
		
		«FOR otherEnum : entityModel.enums »
			import «packageName».«HEDLCodegenConstants::ENTITY_PACKAGE_NAME».«otherEnum.name»;
		«ENDFOR»
		
		public abstract class OperationProviderBase implements IDBOperationsBase {
				
			private Session session;
			
			«FOR entity : entityModel.entities »
			private «entity.name»DAO «entity.name.toFirstLower»DAO = new «entity.name»DAO();
			«ENDFOR»
		
			public OperationProviderBase(Session session) {
				this.session = session;
			}
			
			public Session getSession() {
				return session;
			}
			
			«FOR entity : entityModel.entities »
			«var readOnlyProperties = entity.properties.filter(p | p.readonly) »
			«var uniqueProperties = entity.properties.filter(p | p.unique) »
			/** Create method using all read-only properties. */
			public «entity.name» create«entity.name»(«FOR property : readOnlyProperties »«property.type.javaClassname» «property.name.toFirstLower»«IF readOnlyProperties.last != property», «ENDIF»«ENDFOR») {
				return «entity.name.toFirstLower»DAO.create(session«FOR property : readOnlyProperties », «property.name.toFirstLower»«ENDFOR»);
			}
			
			«FOR property : uniqueProperties »
			/** Constructor using the unique property «property.name». */
			public «entity.name» create«entity.name»With«property.name.toFirstUpper»(«property.type.javaClassname» «property.name.toFirstLower») {
				return «entity.name.toFirstLower»DAO.createWith«property.name.toFirstUpper»(session, «property.name.toFirstLower»);
			}
			
			«ENDFOR»
			/**
			 * Returns the «entity.name» with the given id.
			 */
			public «entity.name» get«entity.name»(int id) {
				«entity.name» entity = «entity.name.toFirstLower»DAO.get(session, id);
				return entity;
			}
			
			«FOR property : uniqueProperties »
			/** Returns the «entity.name» with the given «property.name». */
			public «entity.name» get«entity.name»By«property.name.toFirstUpper»(«property.type.javaClassname» «property.name») {
				«entity.name» entity = «entity.name.toFirstLower»DAO.getBy«property.name.toFirstUpper»(session, «property.name»);
				return entity;
			}
				
			«ENDFOR»
			«FOR constraint : entity.constraints »
			«IF constraint instanceof UniqueConstraint »
			«var uniqueConstraint = constraint as UniqueConstraint »
			/**
			 * Returns the «entity.name» with the given properties.
			 */
			public «entity.name» get«entity.name»By«FOR property : uniqueConstraint.properties»«property.name.toFirstUpper»«ENDFOR»(«FOR property : uniqueConstraint.properties»«property.type.javaClassname» «property.name»«IF uniqueConstraint.properties.last != property », «ENDIF»«ENDFOR») {
				«entity.name» entity = «entity.name.toFirstLower»DAO.getBy«FOR property : uniqueConstraint.properties»«property.name.toFirstUpper»«ENDFOR»(session, «FOR property : uniqueConstraint.properties»«property.name»«IF uniqueConstraint.properties.last != property », «ENDIF»«ENDFOR»);
				return entity;
			}
			
			«ENDIF»
			«ENDFOR»
			/**
			 * Deletes a «entity.name».
			 */
			public void delete(«entity.name» entity) {
				«entity.name.toFirstLower»DAO.delete(session, entity);
			}
			
			/**
			 * Counts the number of «entity.name» entities.
			 */
			public int count«entity.name.toFirstUpper»s() {
				return «entity.name.toFirstLower»DAO.count(session);
			}
			
			«ENDFOR»
		}
		''';
	}

	def generateEntityDAO(String packageName, Entity entity) {
		return '''
		package «packageName».«HEDLCodegenConstants::DAO_PACKAGE_NAME»;
		
		import org.hibernate.classic.Session;
		import org.hibernate.Criteria;
		import org.hibernate.HibernateException;
		import org.hibernate.criterion.MatchMode;
		import org.hibernate.criterion.Order;
		import org.hibernate.criterion.Restrictions;

		«FOR otherEntity : entity.entityModel.entities »
		import «packageName».«HEDLCodegenConstants::ENTITY_PACKAGE_NAME».«otherEntity.name»;
		«ENDFOR»
		
		«FOR otherEnum : entity.entityModel.enums »
		import «packageName».«HEDLCodegenConstants::ENTITY_PACKAGE_NAME».«otherEnum.name»;
		«ENDFOR»
		
		import java.util.List;

		// this class is generated. any change will be overridden.
		public class «entity.name»DAO {
			
			public final static String FIELD__ID = getField(«entity.name».class, "id");
			«FOR property : entity.properties »
			public final static String FIELD__«property.name.toUpperCase» = getField(«entity.name».class, "«property.name»");
			«ENDFOR»
			
		«var readOnlyProperties = entity.properties.filter(p | p.readonly) »
		«var uniqueProperties = entity.properties.filter(p | p.unique) »
			/**
			 * Creates a «entity.name» using all read-only properties.
			 */
			public «entity.name» create(Session session«FOR property : readOnlyProperties », «property.type.javaClassname» «property.name.toFirstLower»«ENDFOR») {
				«entity.name» newEntity = new «entity.name»(«FOR property : readOnlyProperties »«property.name.toFirstLower»«IF readOnlyProperties.last != property», «ENDIF»«ENDFOR»);
				session.persist(newEntity);
				return newEntity;
			}
			
			«FOR property : uniqueProperties »
			/**
			 * Creates a «entity.name» using the unique property «property.name».
			 */
			public «entity.name» createWith«property.name.toFirstUpper»(Session session, «property.type.javaClassname» «property.name.toFirstLower») {
				«entity.name» newEntity = new «entity.name»();
				newEntity.set«property.name.toFirstUpper»(«property.name.toFirstLower»);
				session.persist(newEntity);
				return newEntity;
			}
			
			«ENDFOR»
			/**
			 * Returns the «entity.name» with the given id.
			 */
			public «entity.name» get(Session session, int id) {
				«entity.name» entity = («entity.name») session.get(«entity.name».class, id);
				return entity;
			}
			
			«FOR property : uniqueProperties »
			/**
			 * Returns the «entity.name» with the given «property.name».
			 */
			public «entity.name» getBy«property.name.toFirstUpper»(Session session, «property.type.javaClassname» «property.name») {
				Criteria criteria = session.createCriteria(«entity.name».class);
				criteria = criteria.add(Restrictions.eq(FIELD__«property.name.toUpperCase», «property.name»));
				List<?> list = criteria.list();
				if (list != null && !list.isEmpty()) {
					return («entity.name») list.get(0);
				}
				return null;
			}
			
			«ENDFOR»
			«FOR constraint : entity.constraints »
			«IF constraint instanceof UniqueConstraint »
		«var uniqueConstraint = constraint as UniqueConstraint »
			/**
			 * Returns the «entity.name» with the given properties.
			 */
			public «entity.name» getBy«FOR property : uniqueConstraint.properties»«property.name.toFirstUpper»«ENDFOR»(Session session, «FOR property : uniqueConstraint.properties»«property.type.javaClassname» «property.name»«IF uniqueConstraint.properties.last != property », «ENDIF»«ENDFOR») {
				Criteria criteria = session.createCriteria(«entity.name».class);
				«FOR property : uniqueConstraint.properties»
				criteria = criteria.add(Restrictions.eq(FIELD__«property.name.toUpperCase», «property.name»));
				«ENDFOR»
				List<?> list = criteria.list();
				if (list != null && !list.isEmpty()) {
					return («entity.name») list.get(0);
				}
				return null;
			}
			
			«ENDIF»
			«ENDFOR»
			/**
			 * Deletes a «entity.name».
			 */
			public void delete(Session session, «entity.name» entity) {
				session.delete(entity);
			}
			
			/**
			 * Counts the number of «entity.name» entities.
			 */
			public int count(Session session) {
				return ((Long) session.createQuery("select count(*) from «entity.name»").uniqueResult()).intValue();
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
		'''
	}

	def generateEntityBaseClass(String packageName, Entity entity) {
		return '''
		package «packageName».«HEDLCodegenConstants::ENTITY_PACKAGE_NAME»;
		
		import javax.persistence.Entity;
		import javax.persistence.GeneratedValue;
		import javax.persistence.Id;
		import javax.persistence.JoinColumn;
		import javax.persistence.ManyToOne;
		import javax.persistence.OneToOne;
		import javax.persistence.Table;
		import javax.persistence.Temporal;
		import javax.persistence.TemporalType;
		import javax.persistence.UniqueConstraint;
		import javax.persistence.EnumType;
		import javax.persistence.Enumerated;
		import javax.persistence.CascadeType;
		import javax.persistence.ManyToOne;
		import javax.persistence.OneToOne;
		import javax.persistence.Column;

		import org.hibernate.annotations.GenericGenerator;
		
		@Entity
		@Table(name = "«entity.name»"
		«FOR constraint : entity.constraints »
		«IF constraint instanceof UniqueConstraint »
		«var uniqueConstraint = constraint as UniqueConstraint »
		, uniqueConstraints=@UniqueConstraint(columnNames={«FOR property : uniqueConstraint.properties»"«property.name»", «ENDFOR»})
		«ENDIF»
		«ENDFOR»)
		// this class is generated. any change will be overridden.
		public class «entity.name» {
			
			@Id
			@GeneratedValue(generator = "increment")
			@GenericGenerator(name = "increment", strategy = "increment")
			private int id;

			«FOR property : entity.properties »
			«IF property.type instanceof JavaType »
		«var javaType = property.type as JavaType »
			«IF javaType.javaClass.equals(typeof(java.util.Date)) »
			@Temporal(TemporalType.TIMESTAMP)
			«ENDIF»
			«ENDIF»
			«IF property.type instanceof org.emftext.language.hedl.Enum »
			@Enumerated(EnumType.STRING)
			«ENDIF»
			«IF property.type instanceof Entity »
			«IF (!property.fromMultiplicity) && (!property.toMultiplicity) »
			@OneToOne(cascade={«IF property.persist»CascadeType.PERSIST, «ENDIF»«IF property.refresh»CascadeType.REFRESH«ENDIF»«IF !property.persist && !property.refresh»CascadeType.ALL«ENDIF»})
			@JoinColumn(name="«property.name»"«IF property.readonly», updatable=false«ENDIF», nullable=« property.nullable»)
			«ENDIF»
			«IF property.fromMultiplicity && !property.toMultiplicity »
			@ManyToOne(cascade={«IF property.persist»CascadeType.PERSIST, «ENDIF»«IF property.refresh»CascadeType.REFRESH«ENDIF»«IF !property.persist && !property.refresh»CascadeType.ALL«ENDIF»})
			@JoinColumn(name="«property.name»"«IF property.readonly», updatable=false«ENDIF», nullable=« property.nullable»)
			«ENDIF»
			«IF !property.fromMultiplicity && property.toMultiplicity »
			@OneToMany(cascade={«IF property.persist»CascadeType.PERSIST, «ENDIF»«IF property.refresh»CascadeType.REFRESH«ENDIF»«IF !property.persist && !property.refresh»CascadeType.ALL«ENDIF»})
			«ENDIF»
			«ENDIF»
			«IF property.type == HedlBuiltinTypes::LONGSTRING »
			@Column(length=100000)
			«ENDIF»
			private «property.type.javaClassname» «property.name»;
			
			«ENDFOR»
			/**
			 * Default constructor. Only used by Hibernate.
			 */
			public «entity.name»() {
				super();
			}

		«var readOnlyProperties = entity.properties.filter(p | p.readonly) »
			«IF !readOnlyProperties.empty »
			/**
			 * Constructor using all read-only properties.
			 */
			public «entity.name»(«FOR property : readOnlyProperties »«property.type.javaClassname» «property.name.toFirstLower»«IF readOnlyProperties.last != property», «ENDIF»«ENDFOR») {
				super();
				«FOR property : readOnlyProperties »
				this.«property.name.toFirstLower» = «property.name.toFirstLower»;
				«ENDFOR»
			}
			
			«ENDIF»
			public int getId() {
				return id;
			}

			@Deprecated
			public void setId(int id) {
				this.id = id;
			}

			«FOR property : entity.properties »
			public «property.type.javaClassname» get«property.name.toFirstUpper»() {
				return «property.name»;
			}
			
			«IF property.readonly »
			/**
			 * This property is read-only. The setter is only provided for Hibernate.
			 */
			@Deprecated
			«ENDIF»
			public void set«property.name.toFirstUpper»(«property.type.javaClassname» newValue) {
				this.«property.name» = newValue;
			}
			
			«ENDFOR»
		}
		'''
	}

	def generateEnum(String packageName, org.emftext.language.hedl.Enum enumeration) {
		return '''
		package «packageName».«HEDLCodegenConstants::ENTITY_PACKAGE_NAME»;
		
		// this class is generated. any change will be overridden.
		public enum «enumeration.name» {
			
			«FOR literal : enumeration.literals »
			«literal.comment»
			«literal.name»,
			«ENDFOR»
		}
		'''
	}
}