package org.emftext.language.hedl.codegen

import org.emftext.language.hedl.EntityModel
import org.emftext.language.hedl.Entity
import org.emftext.language.hedl.JavaType

class HEDLGenerator {

	def generateICommand(String packageName) {
		return '''
		package «packageName»;

		// this class is generated. any change will be overridden.
		public interface ICommand {
			
			public void execute(IDBOperations operations);
		}
		'''
	}

	def generateOngoingShutdownException(String packageName) {
		return '''
		package «packageName»;

		// this class is generated. any change will be overridden.
		public class OngoingShutdownException extends Exception {
			
			private static final long serialVersionUID = 997906627613716196L;
		}
		'''
	}

	def generateIDBOperations(String packageName, EntityModel entityModel) {
		return '''
		package «packageName»;

		// this class is generated. any change will be overridden.
		public interface IDBOperations {
			
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
			/**
			 * Deletes a «entity.name».
			 */
			public void delete(«entity.name» entity);
		«ENDFOR»
		}
		'''
	}

	def generateMainDAO(String packageName, EntityModel entityModel) {
		return '''
		package «packageName»;

		import org.hibernate.Criteria;
		import org.hibernate.HibernateException;
		import org.hibernate.SessionFactory;
		import org.hibernate.Transaction;
		import org.hibernate.cfg.Configuration;
		import org.hibernate.classic.Session;
		import org.hibernate.criterion.MatchMode;
		import org.hibernate.criterion.Order;
		import org.hibernate.criterion.Restrictions;

		// this class is generated. any change will be overridden.
		public class MainDAO {
			
			private SessionFactory sessionFactory;
		
			public MainDAO() {
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
			
			public void executeInTransaction(ICommand command) throws OngoingShutdownException {
				SessionFactory sessionsLocal = sessionFactory;
				// this can happen when the application server is shut down or restarted
				if (sessionsLocal == null) {
					throw new OngoingShutdownException();
				}
				Session session = sessionsLocal.openSession();
				Transaction tx = null;
				try {
					tx = session.beginTransaction();
					command.execute(new OperationProvider(session));
					tx.commit();
				} catch (HibernateException he) {
					if (tx != null) {
						tx.rollback();
					}
					throw he;
				} finally {
					session.close();
				}
			}
			
			private class OperationProvider implements IDBOperations {
				
				private Session session;

				«FOR entity : entityModel.entities »
				private «entity.name»DAO «entity.name.toFirstLower»DAO = new «entity.name»DAO();
				«ENDFOR»
		
				public OperationProvider(Session session) {
					this.session = session;
				}

				«FOR entity : entityModel.entities »
		«var readOnlyProperties = entity.properties.filter(p | p.readonly) »
		«var uniqueProperties = entity.properties.filter(p | p.unique) »
				/**
			 	 * Create method using all read-only properties.
			 	 */
				public «entity.name» create«entity.name»(«FOR property : readOnlyProperties »«property.type.javaClassname» «property.name.toFirstLower»«IF readOnlyProperties.last != property», «ENDIF»«ENDFOR») {
					return «entity.name.toFirstLower»DAO.create(session«FOR property : readOnlyProperties », «property.name.toFirstLower»«ENDFOR»);
				}
				
				/**
				 * Returns the «entity.name» with the given id.
				 */
				public «entity.name» get«entity.name»(int id) {
					«entity.name» entity = «entity.name.toFirstLower»DAO.get(session, id);
					return entity;
				}
				
				«FOR property : uniqueProperties »
				/**
				 * Returns the «entity.name» with the given «property.name».
				 */
				public «entity.name» get«entity.name»By«property.name.toFirstUpper»(«property.type.javaClassname» «property.name») {
					«entity.name» entity = «entity.name.toFirstLower»DAO.getBy«property.name.toFirstUpper»(session, «property.name»);
					return entity;
				}
				
				«ENDFOR»
				/**
				 * Deletes a «entity.name».
				 */
				public void delete(«entity.name» entity) {
					«entity.name.toFirstLower»DAO.delete(session, entity);
				}
				«ENDFOR»
			}
		}
		'''
	}

	def generateEntityDAO(String packageName, Entity entity) {
		return '''
		package «packageName»;
		
		import org.hibernate.classic.Session;
		import org.hibernate.Criteria;
		import org.hibernate.HibernateException;
		import org.hibernate.criterion.MatchMode;
		import org.hibernate.criterion.Order;
		import org.hibernate.criterion.Restrictions;
		
		import java.util.List;

		// this class is generated. any change will be overridden.
		public class «entity.name»DAO {
			
			«FOR property : entity.properties »
			private final String FIELD__«entity.name.toUpperCase»__«property.name.toUpperCase» = getField(«entity.name».class, "«property.name»");
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
				criteria = criteria.add(Restrictions.eq(FIELD__«entity.name.toUpperCase»__«property.name.toUpperCase», «property.name»));
				List<?> list = criteria.list();
				if (list != null && !list.isEmpty()) {
					return («entity.name») list.get(0);
				}
				return null;
			}
			
			«ENDFOR»

			/**
			 * Deletes a «entity.name».
			 */
			public void delete(Session session, «entity.name» entity) {
				session.delete(entity);
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
		package «packageName»;
		
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

		import org.hibernate.annotations.GenericGenerator;
		
		@Entity
		@Table(name = "«entity.name»")
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
		package «packageName»;
		
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