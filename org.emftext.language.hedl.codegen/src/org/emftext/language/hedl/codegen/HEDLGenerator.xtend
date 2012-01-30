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

		import java.util.List;
		
		«FOR otherEntity : entityModel.entities »
		import «packageName».«HEDLCodegenConstants::ENTITY_PACKAGE_NAME».«otherEntity.name»;
		«ENDFOR»
		
		«FOR otherEnum : entityModel.enums »
		import «packageName».«HEDLCodegenConstants::ENTITY_PACKAGE_NAME».«otherEnum.name»;
		«ENDFOR»

		// this class is generated. any change will be overridden.
		public interface IDBOperationsBase {
			
			«FOR entity : entityModel.entities »
		«var uniqueProperties = entity.properties.filter(p | p.unique) »
		«var enumProperties = entity.properties.filter(p | p.type instanceof org.emftext.language.hedl.Enum && !p.unique) »
		«var toOneProperties = entity.properties.filter(p | p.type instanceof Entity && !p.toMultiplicity && !p.unique) »
		«var dateProperties = entity.properties.filter(p | typeof(java.util.Date).getName().equals(p.type?.getJavaClassname()) && !p.unique) »
		«var constructorProperties = entity.constructorProperties »
			/**
			 * Creates a new «entity.name» using all read-only and all non-null properties.
			 */
			public «entity.name» create«entity.name»(«FOR property : constructorProperties »«property.type.javaClassname» «property.name.toFirstLower»«IF constructorProperties.last != property», «ENDIF»«ENDFOR»);
			
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
			«FOR property : toOneProperties »
			/**
			 * Returns the «entity.name»s with the given «property.name».
			 */
			public List<«entity.name»> get«entity.name»sBy«property.name.toFirstUpper»(«property.type.javaClassname» «property.name»);
			
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
			«FOR property : enumProperties »
			/**
			 * Returns all «entity.name»s with the given «property.name».
			 */
			public List<«entity.name»> get« entity.name »sBy«property.name.toFirstUpper»(«property.type.javaClassname» «property.name»);
			
			«ENDFOR»
			«FOR property : dateProperties »
			/**
			 * Returns all «entity.name»s where «property.name» is set to a value before '_maxDate'.
			 */
			public List<«entity.name»> get«entity.name»sWith«property.name.toFirstUpper»Before(«property.type.javaClassname» _maxDate);
			
			«ENDFOR»
			«FOR property : dateProperties »
			/**
			 * Returns all «entity.name»s where «property.name» is set to a value after '_minDate'.
			 */
			public List<«entity.name»> get«entity.name»sWith«property.name.toFirstUpper»After(«property.type.javaClassname» _minDate);
			
			«ENDFOR»
			/**
			 * Returns all entities of type «entity.name».
			 */
			public List<«entity.name»> getAll«entity.name»s();
				
			/**
			 * Searches for entities of type «entity.name».
			 */
			public List<«entity.name»> search«entity.name»s(String _searchString, int _maxResults);
			
		«var toOneReferences = entity.properties.filter(p | p.toOneReference) »
			«FOR toOneReference : toOneReferences »
			/**
			 * Searches for entities of type «entity.name».
			 */
			public List<«entity.name»> search«entity.name»With« toOneReference.name.toFirstUpper »(final « toOneReference.typeClassname » « toOneReference.name», String _searchString, int _maxResults);
			
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
			
			public void handleException(Exception e, boolean retry) {
				e.printStackTrace();
			}
		}
		''';
	}

	def generateMainDAOBase(String packageName, String className, EntityModel entityModel) {
		return '''
		package «packageName».«HEDLCodegenConstants::DAO_PACKAGE_NAME»;

		import java.util.ArrayList;
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
		public abstract class «className» implements IDBOperationsBase {
			
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
				boolean successful = false;
				boolean closed = false;
				
				Session session = sessionFactory.openSession();
				Transaction tx = null;
				try {
					tx = session.beginTransaction();
					command.execute(new OperationProvider(session));
					tx.commit();
					successful = true;
				} catch (Exception e) {
					handleException(e, retry);
					if (tx != null) {
						try {
							tx.rollback();
						} catch (TransactionException te) {
							handleException(te, retry);
						}
					}
				} finally {
					try {
						session.close();
						closed = true;
					} catch (HibernateException he) {
						handleException(he, retry);
					}
				}
				
				if ((!successful || !closed) && retry) {
					// retry once
					executeInTransaction(command, false);
				}
			}
			
			public abstract void handleException(Exception e, boolean retry);
			
			public void tearDown() {
				sessionFactory.close();
			}

			«FOR entity : entityModel.entities »
		«var uniqueProperties = entity.properties.filter(p | p.unique) »
		«var enumProperties = entity.properties.filter(p | p.type instanceof org.emftext.language.hedl.Enum && !p.unique) »
		«var toOneProperties = entity.properties.filter(p | p.type instanceof Entity && !p.toMultiplicity && !p.unique) »
		«var dateProperties = entity.properties.filter(p | typeof(java.util.Date).getName().equals(p.type?.getJavaClassname()) && !p.unique) »
		«var constructorProperties = entity.constructorProperties »
			/**
			 * Creates a new «entity.name» using all read-only and all non-null properties.
			 */
			public «entity.name» create«entity.name»(«FOR property : constructorProperties »final «property.type.javaClassname» «property.name.toFirstLower»«IF constructorProperties.last != property», «ENDIF»«ENDFOR») {
				final «entity.name»[] entity = new «entity.name»[1];
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						entity[0] = operations.create«entity.name»(«FOR property : constructorProperties »«property.name.toFirstLower»«IF constructorProperties.last != property», «ENDIF»«ENDFOR»);
					}
				});
				return entity[0];
			}
			
			/**
			 * Returns the «entity.name» with the given id.
			 */
			public «entity.name» get«entity.name»(final int id) {
				final «entity.name»[] entity = new «entity.name»[1];
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						entity[0] = operations.get«entity.name»(id);
					}
				});
				return entity[0];
			}
			
			«FOR property : uniqueProperties »
			/**
			 * Returns the «entity.name» with the given «property.name».
			 */
			public «entity.name» get«entity.name»By«property.name.toFirstUpper»(final «property.type.javaClassname» «property.name») {
				final «entity.name»[] entity = new «entity.name»[1];
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						entity[0] = operations.get«entity.name»By«property.name.toFirstUpper»(«property.name»);
					}
				});
				return entity[0];
			}
			
			«ENDFOR»
			«FOR property : toOneProperties »
			/**
			 * Returns the «entity.name»s with the given «property.name».
			 */
			public List<«entity.name»> get«entity.name»sBy«property.name.toFirstUpper»(final «property.type.javaClassname» «property.name») {
				final List<«entity.name»> entities = new ArrayList<«entity.name»>();
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						entities.addAll(operations.get«entity.name»sBy«property.name.toFirstUpper»(«property.name»));
					}
				});
				return entities;
			}
			
			«ENDFOR»
			«FOR property : enumProperties »
			/**
			 * Returns all «entity.name»s with the given «property.name».
			 */
			public List<«entity.name»> get« entity.name »sBy«property.name.toFirstUpper»(final «property.type.javaClassname» «property.name») {
				final List<«entity.name»> entities = new ArrayList<«entity.name»>();
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						entities.addAll(operations.get« entity.name »sBy«property.name.toFirstUpper»(«property.name»));
					}
				});
				return entities;
			}
			
			«ENDFOR»
			«FOR constraint : entity.constraints »
			«IF constraint instanceof UniqueConstraint »
			«var uniqueConstraint = constraint as UniqueConstraint »
			/**
			 * Returns the «entity.name» with the given properties.
			 */
			public «entity.name» get«entity.name»By«FOR property : uniqueConstraint.properties»«property.name.toFirstUpper»«ENDFOR»(«FOR property : uniqueConstraint.properties»final «property.type.javaClassname» «property.name»«IF uniqueConstraint.properties.last != property », «ENDIF»«ENDFOR») {
				final «entity.name»[] entity = new «entity.name»[1];
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						entity[0] = operations.get«entity.name»By«FOR property : uniqueConstraint.properties»«property.name.toFirstUpper»«ENDFOR»(«FOR property : uniqueConstraint.properties»«property.name»«IF uniqueConstraint.properties.last != property », «ENDIF»«ENDFOR»);
					}
				});
				return entity[0];
			}
			
			«ENDIF»
			«ENDFOR»
			«FOR property : dateProperties »
			/**
			 * Returns all «entity.name»s where «property.name» is set to a value before '_maxDate'.
			 */
			public List<«entity.name»> get«entity.name»sWith«property.name.toFirstUpper»Before(final «property.type.javaClassname» _maxDate) {
				final List<«entity.name»> entities = new ArrayList<«entity.name»>();
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						entities.addAll(operations.get«entity.name»sWith«property.name.toFirstUpper»Before(_maxDate));
					}
				});
				return entities;
			}
			
			«ENDFOR»
			«FOR property : dateProperties »
			/**
			 * Returns all «entity.name»s where «property.name» is set to a value after '_minDate'.
			 */
			public List<«entity.name»> get«entity.name»sWith«property.name.toFirstUpper»After(final «property.type.javaClassname» _minDate) {
				final List<«entity.name»> entities = new ArrayList<«entity.name»>();
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						entities.addAll(operations.get«entity.name»sWith«property.name.toFirstUpper»After(_minDate));
					}
				});
				return entities;
			}
			
			«ENDFOR»
			/**
			 * Returns all entities of type «entity.name».
			 */
			public List<«entity.name»> getAll«entity.name»s() {
				final List<«entity.name»> entities = new ArrayList<«entity.name»>();
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						entities.addAll(operations.getAll«entity.name»s());
					}
				});
				return entities;
			}
			
			/**
			 * Searches for entities of type «entity.name».
			 */
			public List<«entity.name»> search«entity.name»s(final String _searchString, final int _maxResults) {
				final List<«entity.name»> entities = new ArrayList<«entity.name»>();
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						entities.addAll(operations.search«entity.name»s(_searchString, _maxResults));
					}
				});
				return entities;
			}
			
		«var toOneReferences = entity.properties.filter(p | p.toOneReference) »
			«FOR toOneReference : toOneReferences »
			/**
			 * Searches for entities of type «entity.name».
			 */
			public List<«entity.name»> search«entity.name»With« toOneReference.name.toFirstUpper »(final « toOneReference.typeClassname » « toOneReference.name», final String _searchString, final int _maxResults) {
				final List<«entity.name»> entities = new ArrayList<«entity.name»>();
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						entities.addAll(operations.search«entity.name»With« toOneReference.name.toFirstUpper »(« toOneReference.name», _searchString, _maxResults));
					}
				});
				return entities;
			}
			
			«ENDFOR»
			/**
			 * Deletes a «entity.name».
			 */
			public void delete(final «entity.name» entity) {
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						operations.delete(entity);
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

		import java.util.List;

		import org.hibernate.Criteria;
		import org.hibernate.HibernateException;
		import org.hibernate.SessionFactory;
		import org.hibernate.Transaction;
		import org.hibernate.cfg.Configuration;
		import org.hibernate.classic.Session;
		import org.hibernate.criterion.MatchMode;
		import org.hibernate.criterion.Order;
		import org.hibernate.criterion.Restrictions;
		import org.hibernate.metadata.ClassMetadata;
		import org.hibernate.persister.entity.AbstractEntityPersister;
		
		«FOR otherEntity : entityModel.entities »
			import «packageName».«HEDLCodegenConstants::ENTITY_PACKAGE_NAME».«otherEntity.name»;
		«ENDFOR»
		«FOR otherEnum : entityModel.enums »
			import «packageName».«HEDLCodegenConstants::ENTITY_PACKAGE_NAME».«otherEnum.name»;
		«ENDFOR»
		
		/**
		 * This class provides all default operations that are derived from the HEDL entity model.
		 *
		 * Note: This class is generated. Any change will be overridden.
		 */
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
		«var uniqueProperties = entity.properties.filter(p | p.unique) »
		«var enumProperties = entity.properties.filter(p | p.type instanceof org.emftext.language.hedl.Enum && !p.unique) »
		«var toOneProperties = entity.properties.filter(p | p.type instanceof Entity && !p.toMultiplicity && !p.unique) »
		«var dateProperties = entity.properties.filter(p | typeof(java.util.Date).getName().equals(p.type?.getJavaClassname()) && !p.unique) »
		«var constructorProperties = entity.constructorProperties »
			/** 
			 * Creates an instance of type «entity.name» using all read-only and all non-null properties.
			 */
			public «entity.name» create«entity.name»(«FOR property : constructorProperties »«property.type.javaClassname» «property.name.toFirstLower»«IF constructorProperties.last != property», «ENDIF»«ENDFOR») {
				return «entity.name.toFirstLower»DAO.create(session«FOR property : constructorProperties », «property.name.toFirstLower»«ENDFOR»);
			}
			
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
			«FOR property : toOneProperties »
			/** Returns the «entity.name»s with the given «property.name». */
			public List<«entity.name»> get«entity.name»sBy«property.name.toFirstUpper»(«property.type.javaClassname» «property.name») {
				List<«entity.name»> entities = «entity.name.toFirstLower»DAO.getBy«property.name.toFirstUpper»(session, «property.name»);
				return entities;
			}
				
			«ENDFOR»
			«FOR property : enumProperties »
			/**
			 * Returns all «entity.name»s with the given «property.name».
			 */
			public List<«entity.name»> get« entity.name »sBy«property.name.toFirstUpper»(«property.type.javaClassname» «property.name») {
				return «entity.name.toFirstLower»DAO.getBy«property.name.toFirstUpper»(session, «property.name»);
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
			«FOR property : dateProperties »
			/**
			 * Returns all «entity.name»s where «property.name» is set to a value before '_maxDate'.
			 */
			public List<«entity.name»> get«entity.name»sWith«property.name.toFirstUpper»Before(«property.type.javaClassname» _maxDate) {
				final List<«entity.name»> entities = «entity.name.toFirstLower»DAO.get«property.name.toFirstUpper»Before(session, _maxDate);
				return entities;
			}
			
			«ENDFOR»
			«FOR property : dateProperties »
			/**
			 * Returns all «entity.name»s where «property.name» is set to a value after '_minDate'.
			 */
			public List<«entity.name»> get«entity.name»sWith«property.name.toFirstUpper»After(«property.type.javaClassname» _minDate) {
				final List<«entity.name»> entities = «entity.name.toFirstLower»DAO.get«property.name.toFirstUpper»After(session, _minDate);
				return entities;
			}
			
			«ENDFOR»
			/**
			 * Returns all entities of type «entity.name».
			 */
			public List<«entity.name»> getAll«entity.name»s() {
				final List<«entity.name»> entities = «entity.name.toFirstLower»DAO.getAll(session);
				return entities;
			}
			
			/**
			 * Searches for entities of type «entity.name».
			 */
			public List<«entity.name»> search«entity.name»s(String _searchString, int _maxResults) {
				return «entity.name.toFirstLower»DAO.search(session, _searchString, _maxResults);
			}
			
		«var toOneReferences = entity.properties.filter(p | p.toOneReference) »
			«FOR toOneReference : toOneReferences »
			/**
			 * Searches for entities of type «entity.name».
			 */
			public List<«entity.name»> search«entity.name»With« toOneReference.name.toFirstUpper »(« toOneReference.typeClassname » « toOneReference.name», String _searchString, int _maxResults) {
				return «entity.name.toFirstLower»DAO.searchWith« toOneReference.name.toFirstUpper »(session, « toOneReference.name», _searchString, _maxResults);
			}
			
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
			/**
			 * Returns the name of the table that contains entities of the given type.
			 */
			public String getTableName(Class<?> clazz) {
				ClassMetadata hibernateMetadata = getSession().getSessionFactory().getClassMetadata(clazz);
				if (hibernateMetadata == null) {
				    return null;
				}
				if (hibernateMetadata instanceof AbstractEntityPersister) {
				     AbstractEntityPersister persister = (AbstractEntityPersister) hibernateMetadata;
				     return persister.getTableName();
				}
				return null;
			}
		}
		''';
	}

	def generateEntityDAO(String packageName, Entity entity) {
		return '''
		package «packageName».«HEDLCodegenConstants::DAO_PACKAGE_NAME»;
		
		import java.util.List;
		
		import org.hibernate.classic.Session;
		import org.hibernate.Criteria;
		import org.hibernate.HibernateException;
		import org.hibernate.criterion.Disjunction;
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

		/**
		 * This class provides all default operations that are derived from the HEDL entity model
		 * for type «entity.name».
		 *
		 * Note: This class is generated. Any change will be overridden.
		 */
		public class «entity.name»DAO {
			
			«IF entity.superType == null »
			public final static String FIELD__ID = getField(«entity.name».class, "id");
			«ENDIF»
			«FOR property : entity.properties »
			public final static String FIELD__«property.name.toUpperCase» = getField(«entity.name».class, "«property.name»");
			«ENDFOR»
			
		«var uniqueProperties = entity.properties.filter(p | p.unique) »
		«var enumProperties = entity.properties.filter(p | p.type instanceof org.emftext.language.hedl.Enum && !p.unique) »
		«var dateProperties = entity.properties.filter(p | typeof(java.util.Date).getName().equals(p.type?.getJavaClassname()) && !p.unique) »
		«var toOneProperties = entity.properties.filter(p | p.type instanceof Entity && !p.toMultiplicity && !p.unique) »
		«var constructorProperties = entity.constructorProperties »
			/**
			 * Creates a «entity.name» using all read-only and all non-null properties.
			 */
			public «entity.name» create(Session session«FOR property : constructorProperties », «property.type.javaClassname» «property.name.toFirstLower»«ENDFOR») {
				«entity.name» newEntity = new «entity.name»(«FOR property : constructorProperties »«property.name.toFirstLower»«IF constructorProperties.last != property», «ENDIF»«ENDFOR»);
				session.save(newEntity);
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
				criteria = criteria.add(Restrictions.eq(FIELD__«property.name.toUpperCase», «property.name»));
				List<?> list = criteria.list();
				if (list != null && !list.isEmpty()) {
					return («entity.name») list.get(0);
				}
				return null;
			}
			
			«ENDFOR»
			«FOR property : toOneProperties »
			/**
			 * Returns the «entity.name»s with the given «property.name».
			 */
			public List<«entity.name»> getBy«property.name.toFirstUpper»(Session session, «property.type.javaClassname» «property.name») {
				Criteria criteria = session.createCriteria(«entity.name».class);
				criteria = criteria.add(Restrictions.eq(FIELD__«property.name.toUpperCase», «property.name»));
				@SuppressWarnings("unchecked")
				List<«entity.name»> list = (List<«entity.name»>) criteria.list();
				return list;
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
			«FOR property : enumProperties »
			/**
			 * Returns all «entity.name»s with the given «property.name».
			 */
			public List<«entity.name»> getBy«property.name.toFirstUpper»(Session session, «property.type.javaClassname» «property.name») {
				Criteria criteria = session.createCriteria(«entity.name».class);
				criteria = criteria.add(Restrictions.eq(FIELD__«property.name.toUpperCase», «property.name»));
				List<?> list = criteria.list();
				@SuppressWarnings("unchecked")
				List<«entity.name»> entities = (List<«entity.name»>) list;
				return entities;
			}
			
			«ENDFOR»
			«FOR property : dateProperties »
			/**
			 * Returns all «entity.name»s where «property.name» is set to a value before '_maxDate'.
			 */
			public List<«entity.name»> get«property.name.toFirstUpper»Before(Session session, «property.type.javaClassname» _maxDate) {
				Criteria criteria = session.createCriteria(«entity.name».class);
				criteria = criteria.add(Restrictions.le(FIELD__«property.name.toUpperCase», _maxDate));
				List<?> list = criteria.list();
				@SuppressWarnings("unchecked")
				List<«entity.name»> entities = (List<«entity.name»>) list;
				return entities;
			}
			
			«ENDFOR»
			«FOR property : dateProperties »
			/**
			 * Returns all «entity.name»s where «property.name» is set to a value after '_minDate'.
			 */
			public List<«entity.name»> get«property.name.toFirstUpper»After(Session session, «property.type.javaClassname» _minDate) {
				Criteria criteria = session.createCriteria(«entity.name».class);
				criteria = criteria.add(Restrictions.ge(FIELD__«property.name.toUpperCase», _minDate));
				List<?> list = criteria.list();
				@SuppressWarnings("unchecked")
				List<«entity.name»> entities = (List<«entity.name»>) list;
				return entities;
			}
			
			«ENDFOR»
			/**
			 * Returns all entities of type «entity.name».
			 */
			public List<«entity.name»> getAll(Session session) {
				Criteria criteria = session.createCriteria(«entity.name».class);
				@SuppressWarnings("unchecked")
				List<«entity.name»> entities = (List<«entity.name»>) criteria.list();
				return entities;
			}
			
			/**
			 * Searches for entities of type «entity.name».
			 */
			public List<«entity.name»> search(Session _session, String _searchString, int _maxResults) {
				Criteria criteria = _session.createCriteria(«entity.name».class);
				Disjunction disjunction = Restrictions.disjunction();
				«FOR property : entity.properties »
				«IF property.type.javaClassname.equals(typeof(String).getName()) »
				disjunction.add(Restrictions.like(FIELD__«property.name.toUpperCase», _searchString.trim(), MatchMode.ANYWHERE));
				«ENDIF»
				«ENDFOR»
				criteria = criteria.add(disjunction);
				criteria = criteria.setMaxResults(_maxResults);
				@SuppressWarnings("unchecked")
				List<«entity.name»> entities = (List<«entity.name»>) criteria.list();
				return entities;
			}
			
		«var toOneReferences = entity.properties.filter(p | p.toOneReference) »
			«FOR toOneReference : toOneReferences »
			/**
			 * Searches for entities of type «entity.name».
			 */
			public List<«entity.name»> searchWith« toOneReference.name.toFirstUpper »(Session _session, « toOneReference.typeClassname » « toOneReference.name», String _searchString, int _maxResults) {
				Criteria criteria = _session.createCriteria(«entity.name».class);
				// restrict by the value of the unique property
				criteria = criteria.add(Restrictions.eq(FIELD__«toOneReference.name.toUpperCase», « toOneReference.name»));
				Disjunction disjunction = Restrictions.disjunction();
				«FOR property : entity.properties »
				«IF property.type.javaClassname.equals(typeof(String).getName()) »
				disjunction.add(Restrictions.like(FIELD__«property.name.toUpperCase», _searchString.trim(), MatchMode.ANYWHERE));
				«ENDIF»
				«ENDFOR»
				criteria = criteria.add(disjunction);
				criteria = criteria.setMaxResults(_maxResults);
				@SuppressWarnings("unchecked")
				List<«entity.name»> entities = (List<«entity.name»>) criteria.list();
				return entities;
			}
			
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
		
		import java.util.List;
		
		import javax.persistence.Entity;
		import javax.persistence.GeneratedValue;
		import javax.persistence.GenerationType;
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
		import javax.persistence.OneToMany;
		import javax.persistence.Column;

		import org.hibernate.annotations.GenericGenerator;
		import org.hibernate.annotations.Parameter;
		
		@Entity
		@Table(name = "«entity.name»"
		«FOR constraint : entity.constraints »
		«IF constraint instanceof UniqueConstraint »
		«var uniqueConstraint = constraint as UniqueConstraint »
		, uniqueConstraints=@UniqueConstraint(columnNames={«FOR property : uniqueConstraint.properties»"«property.name»", «ENDFOR»})
		«ENDIF»
		«ENDFOR»)
		«IF entity.comment != null »
		« entity.comment.replace("\t", "") »
		«ENDIF»
		/*
		 * This class is generated from the entity '«entity.name»' defined in the HEDL model.
		 * Note: Any change made to this class will be overridden.
		 */
		public class «entity.name» « IF entity.superType != null »extends « entity.superType.name » «ENDIF»{
			
			«IF entity.superType == null »
			@GenericGenerator(name="«entity.name»IdGenerator", strategy="org.hibernate.id.MultipleHiLoPerTableGenerator",
			  parameters = {
			    @Parameter(name="table", value="IdentityGenerator"),
			    @Parameter(name="primary_key_column", value="sequence_name"),
			    @Parameter(name="primary_key_value", value="«entity.name»"),
			    @Parameter(name="value_column", value="next_hi_value"),
			    @Parameter(name="primary_key_length", value="100"),
			    @Parameter(name="max_lo", value="1000")
			  }
			)
			@Id 
			@GeneratedValue(strategy=GenerationType.TABLE, generator="«entity.name»IdGenerator")
			private int id;

			«ENDIF»
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
			@OneToMany(cascade={«IF property.persist»CascadeType.PERSIST, «ENDIF»«IF property.refresh»CascadeType.REFRESH«ENDIF»«IF !property.persist && !property.refresh»CascadeType.ALL«ENDIF»}«IF property.mappedBy != null », mappedBy="« property.mappedBy.name »"«ENDIF»)
			«ENDIF»
			«ENDIF»
			«IF property.type == HedlBuiltinTypes::LONGSTRING »
			@Column(length=100000)
			«ENDIF»
			«IF property.comment != null »
			« property.comment.replace("\t", "") »
			«ENDIF»
			private «property.typeClassname» «property.name»;
			
			«ENDFOR»
			/**
			 * Default constructor. Only used by Hibernate.
			 */
			public «entity.name»() {
				super();
			}

		«var constructorProperties = entity.constructorProperties »
			«IF !constructorProperties.empty »
			/**
			 * Constructor using all read-only and all non-nullable properties.
			 */
			public «entity.name»(«FOR property : constructorProperties »«property.type.javaClassname» «property.name.toFirstLower»«IF constructorProperties.last != property», «ENDIF»«ENDFOR») {
				super();
				«FOR property : constructorProperties »
				this.«property.name.toFirstLower» = «property.name.toFirstLower»;
				«ENDFOR»
			}
			
			«ENDIF»
			«IF entity.superType == null »
			/**
			 * Returns the automatically generated id that identifies this entity object.
			 */
			public int getId() {
				return id;
			}

			/**
			 * The property 'id' is read-only. 
			 * This setter is only provided for Hibernate. 
			 * It must not be used directly.
			 */
			@Deprecated
			public void setId(int id) {
				this.id = id;
			}

			«ENDIF»
			«FOR property : entity.properties »
			/**
			 * Returns the value of property '« property.name »'.
			 */
			public «property.typeClassname» get«property.name.toFirstUpper»() {
				return «property.name»;
			}
			
			«IF property.readonly »
			/**
			 * The property '« property.name »' is read-only. 
			 * This setter is only provided for Hibernate. 
			 * It must not be used directly.
			 */
			@Deprecated
			«ELSE»
			/**
			 * Sets the value of property '« property.name »'.
			 */
			«ENDIF»
			public void set«property.name.toFirstUpper»(«property.typeClassname» newValue) {
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
			«IF literal.comment != null »
			« literal.comment.replace("\t", "") »
			«ENDIF»
			«literal.name»,
			«ENDFOR»
		}
		'''
	}
}