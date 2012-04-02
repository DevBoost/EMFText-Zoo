package org.emftext.language.hedl.codegen;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.emftext.language.hedl.Constraint;
import org.emftext.language.hedl.Entity;
import org.emftext.language.hedl.EntityModel;
import org.emftext.language.hedl.Enum;
import org.emftext.language.hedl.EnumLiteral;
import org.emftext.language.hedl.JavaType;
import org.emftext.language.hedl.Property;
import org.emftext.language.hedl.Type;
import org.emftext.language.hedl.UniqueConstraint;
import org.emftext.language.hedl.types.HedlBuiltinTypes;
import de.devboost.commenttemplate.LineBreak;
import de.devboost.commenttemplate.ReplacementRule;
import de.devboost.commenttemplate.VariableAntiQuotation;

@SuppressWarnings("unused")
@ReplacementRule(pattern="#/", replacement="*/")
@VariableAntiQuotation("#%s#")
@LineBreak("\r\n")
public class HEDLCodeGenerator {

	private String DAO_PACKAGE_NAME = HEDLCodegenConstants.DAO_PACKAGE_NAME;
	private String CUSTOM_PACKAGE_NAME = HEDLCodegenConstants.CUSTOM_PACKAGE_NAME;
	private String ENTITY_PACKAGE_NAME = HEDLCodegenConstants.ENTITY_PACKAGE_NAME;
	public String generateICommand(String packageName) {
	StringBuilder __content = new StringBuilder();
	__content.append("package ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(DAO_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(";\r\n");
	__content.append("\r\n");
	__content.append("import ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(CUSTOM_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(".IDBOperations;\r\n");
	__content.append("\r\n");
	__content.append("// this class is generated. any change will be overridden.\r\n");
	__content.append("public interface ICommand {\r\n");
	__content.append("\t\r\n");
	__content.append("\tpublic void execute(IDBOperations operations);\r\n");
	__content.append("}\r\n");
	__content.append("");return __content.toString();
	}
	public String generateOngoingShutdownException(String packageName) {
	StringBuilder __content = new StringBuilder();
	__content.append("package ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(DAO_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(";\r\n");
	__content.append("\r\n");
	__content.append("// this class is generated. any change will be overridden.\r\n");
	__content.append("public class OngoingShutdownException extends RuntimeException {\r\n");
	__content.append("\t\r\n");
	__content.append("\tprivate static final long serialVersionUID = 997906627613716196L;\r\n");
	__content.append("}\r\n");
	__content.append("");return __content.toString();
	}
	public String generateIDBOperations(String packageName) {
	StringBuilder __content = new StringBuilder();
	__content.append("package ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(CUSTOM_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(";\r\n");
	__content.append("\r\n");
	__content.append("import ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(DAO_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(".IDBOperationsBase;\r\n");
	__content.append("\r\n");
	__content.append("// this class is only generated once. it can be customized and all changes\r\n");
	__content.append("// will be preserved.\r\n");
	__content.append("public interface IDBOperations extends IDBOperationsBase {\r\n");
	__content.append("\t\r\n");
	__content.append("}\r\n");
	__content.append("");return __content.toString();
	}
	public String generateIDBOperationsBase(String packageName, EntityModel entityModel) {
	StringBuilder __content = new StringBuilder();
		String entityOperations = getAllEntitityOperations(entityModel);
	__content.append("package ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(DAO_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(";\r\n");
	__content.append("\r\n");
	__content.append("import java.util.List;\r\n");
	__content.append("\r\n");
	__content.append("");for (Entity otherEntity : entityModel.getEntities()) {
			String name = otherEntity.getName();
	__content.append("import ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(ENTITY_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(name.replaceAll("\\r\\n\\z",""));
	__content.append(";\r\n");
	__content.append("");}
		
		for (org.emftext.language.hedl.Enum otherEnum : entityModel.getEnums()) {
			String name = otherEnum.getName();
	__content.append("import ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(ENTITY_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(name.replaceAll("\\r\\n\\z",""));
	__content.append(";\r\n");
	__content.append("");}
	__content.append("\r\n");
	__content.append("// this class is generated. any change will be overridden.\r\n");
	__content.append("public interface IDBOperationsBase {\r\n");
	__content.append("\t\r\n");
	__content.append("\t");
	__content.append(entityOperations.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("\r\n");
	__content.append("}\r\n");
	__content.append("");return __content.toString();
	}
	private String getAllEntitityOperations(EntityModel entityModel) {
	StringBuilder __content = new StringBuilder();
		for (Entity entity : entityModel.getEntities()) {
			String operations = getEntityOperations(entity);
	__content.append("");
	__content.append(operations.replaceAll("\\r\\n\\z",""));
	__content.append("\r\n");
	__content.append("");}
		return __content.toString();
	}
	private String getEntityOperations(Entity entity) {
	StringBuilder __content = new StringBuilder();
		List<Property> uniqueProperties = getUniqueProperties(entity);
		List<Property> enumProperties = getEnumProperties(entity);
		List<Property> toOneProperties = getToOneProperties(entity);
		List<Property> dateProperties = getDateProperties(entity);
		List<Property> toOneReferences = getToOneReferences(entity);
		List<Property> constructorProperties = entity.getConstructorProperties();
		
		String entityName = entity.getName();
	__content.append("/**\r\n");
	__content.append(" * Creates a new ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(" using all read-only and all non-null properties.\r\n");
	__content.append(" */\r\n");
	__content.append("public ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(" create");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("(");for (Property property :constructorProperties) {
			String propertyTypeClass = property.getType().getJavaClassname();
			String propertyName = property.getName();
	__content.append("");
	__content.append(propertyTypeClass.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append("");if (!isLast(constructorProperties, property)) {
	__content.append(", ");}
		}
	__content.append(");\r\n");
	__content.append("\r\n");
	__content.append("/**\r\n");
	__content.append(" * Returns the ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(" with the given id.\r\n");
	__content.append(" */\r\n");
	__content.append("public ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(" get");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("(int id);\r\n");
	__content.append("\t\r\n");
	__content.append("");for (Property property :uniqueProperties) {
			String propertyName = property.getName();
			String toFirstUpper = toFirstUpper(propertyName);
			String typeClassname = property.getType().getJavaClassname();
	__content.append("/**\r\n");
	__content.append(" * Returns the ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(" with the given ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(".\r\n");
	__content.append(" */\r\n");
	__content.append("public ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(" get");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("By");
	__content.append(toFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(");
	__content.append(typeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(");\r\n");
	__content.append("\r\n");
	__content.append("");}
		for (Property property :toOneProperties) {
			String propertyName = property.getName();
			String firstUpper = toFirstUpper(property.getName());
			String typeClassname = property.getType().getJavaClassname();
	__content.append("/**\r\n");
	__content.append(" * Returns the ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("s with the given ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(".\r\n");
	__content.append(" */\r\n");
	__content.append("public List<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("> get");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("sBy");
	__content.append(firstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(");
	__content.append(typeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(");\r\n");
	__content.append("\r\n");
	__content.append("");}
		for (Constraint constraint : entity.getConstraints()) {
			if (constraint instanceof UniqueConstraint) {
				UniqueConstraint uniqueConstraint = (UniqueConstraint) constraint;
	__content.append("/**\r\n");
	__content.append(" * Returns the ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(" with the given properties.\r\n");
	__content.append(" */\r\n");
	__content.append("public ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(" get");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("By");for (Property property : uniqueConstraint.getProperties()) {
					String firstUpper = toFirstUpper(property.getName());
	__content.append("");
	__content.append(firstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("");}
	__content.append("(");for (Property property : uniqueConstraint.getProperties()) {
					String propertyName = property.getName();
					String typeClassname = property.getType().getJavaClassname();
	__content.append("");
	__content.append(typeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append("");if (!isLast(uniqueConstraint.getProperties(), property)) {
	__content.append(", ");}
				}
	__content.append(");\r\n");
	__content.append("\r\n");
	__content.append("");}
		}
		for (Property property :enumProperties) {
			String propertyName = property.getName();
			String firstUpper = toFirstUpper(property.getName());
			String typeClassname = property.getType().getJavaClassname();
	__content.append("/**\r\n");
	__content.append(" * Returns all ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("s with the given ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(".\r\n");
	__content.append(" */\r\n");
	__content.append("public List<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("> get");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("sBy");
	__content.append(firstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(");
	__content.append(typeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(");\r\n");
	__content.append("\r\n");
	__content.append("");}
		for (Property property :dateProperties) {
			String propertyName = property.getName();
			String firstUpper = toFirstUpper(property.getName());
			String typeClassname = property.getType().getJavaClassname();
	__content.append("/**\r\n");
	__content.append(" * Returns all ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("s where ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(" is set to a value before \'_maxDate\'.\r\n");
	__content.append(" */\r\n");
	__content.append("public List<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("> get");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("sWith");
	__content.append(firstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("Before(");
	__content.append(typeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" _maxDate);\r\n");
	__content.append("\r\n");
	__content.append("");}
		for (Property property :dateProperties) {
			String propertyName = property.getName();
			String firstUpper = toFirstUpper(property.getName());
			String typeClassname = property.getType().getJavaClassname();
	__content.append("/**\r\n");
	__content.append(" * Returns all ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("s where ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(" is set to a value after \'_minDate\'.\r\n");
	__content.append(" */\r\n");
	__content.append("public List<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("> get");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("sWith");
	__content.append(firstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("After(");
	__content.append(typeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" _minDate);\r\n");
	__content.append("\r\n");
	__content.append("");}
	__content.append("/**\r\n");
	__content.append(" * Returns all entities of type ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(".\r\n");
	__content.append(" */\r\n");
	__content.append("public List<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("> getAll");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("s();\r\n");
	__content.append("\t\r\n");
	__content.append("/**\r\n");
	__content.append(" * Searches for entities of type ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(".\r\n");
	__content.append(" */\r\n");
	__content.append("public List<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("> search");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("s(String _searchString, int _maxResults);\r\n");
	__content.append("\r\n");
	__content.append("");for (Property property :toOneReferences) {
			String toOneReferenceName = property.getName();
			String firstUpper = toFirstUpper(property.getName());
			String typeClassname = property.getType().getJavaClassname();
	__content.append("/**\r\n");
	__content.append(" * Searches for entities of type ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(".\r\n");
	__content.append(" */\r\n");
	__content.append("public List<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("> search");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("With");
	__content.append(firstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(final ");
	__content.append(typeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(toOneReferenceName.replaceAll("\\r\\n\\z",""));
	__content.append(", String _searchString, int _maxResults);\r\n");
	__content.append("\r\n");
	__content.append("");}
	__content.append("/**\r\n");
	__content.append(" * Deletes a ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(".\r\n");
	__content.append(" */\r\n");
	__content.append("public void delete(");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(" entity);\r\n");
	__content.append("\r\n");
	__content.append("/**\r\n");
	__content.append(" * Counts the number of ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(" entities.\r\n");
	__content.append(" */\r\n");
	__content.append("public int count");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("s();\r\n");
	__content.append("\r\n");
	__content.append("");return __content.toString();
	}

	private List<Property> getToOneReferences(Entity entity) {
		return filter(entity.getProperties(), new IFilter() {
			@Override
			public boolean accept(Property p) {
				return p.isToOneReference();
			}
		});
	}

	private List<Property> getDateProperties(Entity entity) {
		return filter(entity.getProperties(), new IFilter() {
			@Override
			public boolean accept(Property p) {
				Type type = p.getType();
				String typeName = null;
				if (type != null) {
					typeName = type.getJavaClassname();
				}
				return java.util.Date.class.getName().equals(typeName) && !p.isUnique();
			}
		});
	}

	private List<Property> getToOneProperties(Entity entity) {
		return filter(entity.getProperties(), new IFilter() {
			@Override
			public boolean accept(Property p) {
				return p.getType() instanceof Entity && !p.isToMultiplicity() && !p.isUnique();
			}
		});
	}

	private List<Property> getEnumProperties(Entity entity) {
		return filter(entity.getProperties(), new IFilter() {
			@Override
			public boolean accept(Property p) {
				return p.getType() instanceof org.emftext.language.hedl.Enum && !p.isUnique();
			}
		});
	}

	private List<Property> getUniqueProperties(Entity entity) {
		return filter(entity.getProperties(), new IFilter() {
			@Override
			public boolean accept(Property p) {
				return p.isUnique();
			}
		});
	}
	public String generateMainDAO(String packageName, String className) {
	StringBuilder __content = new StringBuilder();
	__content.append("package ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(CUSTOM_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(";\r\n");
	__content.append("\r\n");
	__content.append("import ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(DAO_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(className.replaceAll("\\r\\n\\z",""));
	__content.append("Base;\r\n");
	__content.append("\r\n");
	__content.append("// this class is only generated once. it can be customized and all changes\r\n");
	__content.append("// will be preserved.\r\n");
	__content.append("public class ");
	__content.append(className.replaceAll("\\r\\n\\z",""));
	__content.append(" extends ");
	__content.append(className.replaceAll("\\r\\n\\z",""));
	__content.append("Base {\r\n");
	__content.append("\t\r\n");
	__content.append("\tpublic void handleException(Exception e, boolean retry) {\r\n");
	__content.append("\t\te.printStackTrace();\r\n");
	__content.append("\t}\r\n");
	__content.append("}\r\n");
	__content.append("");;
		return __content.toString();
	}
	public String generateMainDAOBase(String packageName, String className, EntityModel entityModel) {
	StringBuilder __content = new StringBuilder();
		String entityMethods = getEntityOperationsBodies(entityModel);
	__content.append("package ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(DAO_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(";\r\n");
	__content.append("\r\n");
	__content.append("import java.util.ArrayList;\r\n");
	__content.append("import java.util.List;\r\n");
	__content.append("\r\n");
	__content.append("import java.util.logging.Level;\r\n");
	__content.append("import java.util.logging.Logger;\r\n");
	__content.append("\r\n");
	__content.append("import org.hibernate.TransactionException;\r\n");
	__content.append("import org.hibernate.HibernateException;\r\n");
	__content.append("import org.hibernate.SessionFactory;\r\n");
	__content.append("import org.hibernate.Transaction;\r\n");
	__content.append("import org.hibernate.cfg.Configuration;\r\n");
	__content.append("import org.hibernate.classic.Session;\r\n");
	__content.append("\r\n");
	__content.append("import org.hibernate.tool.hbm2ddl.SchemaExport;\r\n");
	__content.append("import org.hibernate.tool.hbm2ddl.SchemaUpdate;\r\n");
	__content.append("\r\n");
	__content.append("import ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(CUSTOM_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(".OperationProvider;\r\n");
	__content.append("import ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(CUSTOM_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(".IDBOperations;\r\n");
	__content.append("\r\n");
	__content.append("");for (Entity otherEntity : entityModel.getEntities()) {
			String otherEntityName = otherEntity.getName();
	__content.append("import ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(ENTITY_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(otherEntityName.replaceAll("\\r\\n\\z",""));
	__content.append(";\r\n");
	__content.append("");}

		for (Enum otherEnum : entityModel.getEnums()) {
			String otherEnumName = otherEnum.getName();
	__content.append("import ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(ENTITY_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(otherEnumName.replaceAll("\\r\\n\\z",""));
	__content.append(";\r\n");
	__content.append("");}
	__content.append("\r\n");
	__content.append("// this class is generated. any change will be overridden.\r\n");
	__content.append("public abstract class ");
	__content.append(className.replaceAll("\\r\\n\\z",""));
	__content.append(" implements IDBOperationsBase {\r\n");
	__content.append("\t\r\n");
	__content.append("\tprivate SessionFactory sessionFactory;\r\n");
	__content.append("\r\n");
	__content.append("\tpublic ");
	__content.append(className.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("() {\r\n");
	__content.append("\t\tconfigure();\r\n");
	__content.append("\t}\r\n");
	__content.append("\r\n");
	__content.append("\tprivate void configure() throws HibernateException {\r\n");
	__content.append("\t\tConfiguration configuration = getConfiguration();\r\n");
	__content.append("\t\t//configuration.setProperty(\"hibernate.show_sql\", \"true\");\r\n");
	__content.append("\t\tthis.sessionFactory = configuration.buildSessionFactory();\r\n");
	__content.append("\t}\r\n");
	__content.append("\r\n");
	__content.append("\tprivate Configuration getConfiguration() {\r\n");
	__content.append("\t\tConfiguration configuration = new Configuration();\r\n");
	__content.append("");for (Entity otherEntity : entityModel.getEntities()) {
					String otherEntityName = otherEntity.getName();
	__content.append("\t\tconfiguration = configuration.addAnnotatedClass(");
	__content.append(otherEntityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(".class);\r\n");
	__content.append("");}
	__content.append("\t\treturn configuration;\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("\tpublic void createSchema() throws HibernateException {\r\n");
	__content.append("\t\tSchemaExport schemaExport = new SchemaExport(getConfiguration());\r\n");
	__content.append("\t\tschemaExport.setFormat(true);\r\n");
	__content.append("\t\tschemaExport.create(false, false);\r\n");
	__content.append("\t}\r\n");
	__content.append("\r\n");
	__content.append("\tpublic void updateSchema() {\r\n");
	__content.append("\t\tSchemaUpdate update = new SchemaUpdate(getConfiguration());\r\n");
	__content.append("\t\tupdate.execute(true, true);\r\n");
	__content.append("\t\tList<?> exceptions = update.getExceptions();\r\n");
	__content.append("\t\tfor (Object object : exceptions) {\r\n");
	__content.append("\t\t\tSystem.err.println(\"Exception while updating schema \" + object);\r\n");
	__content.append("\t\t}\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("\tpublic void executeInTransaction(ICommand command) {\r\n");
	__content.append("\t\texecuteInTransaction(command, true);\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("\tprivate void executeInTransaction(ICommand command, boolean retry) {\r\n");
	__content.append("\t\tboolean successful = false;\r\n");
	__content.append("\t\tboolean closed = false;\r\n");
	__content.append("\t\t\r\n");
	__content.append("\t\tSession session = sessionFactory.openSession();\r\n");
	__content.append("\t\tTransaction tx = null;\r\n");
	__content.append("\t\ttry {\r\n");
	__content.append("\t\t\ttx = session.beginTransaction();\r\n");
	__content.append("\t\t\tcommand.execute(new OperationProvider(session));\r\n");
	__content.append("\t\t\ttx.commit();\r\n");
	__content.append("\t\t\tsuccessful = true;\r\n");
	__content.append("\t\t} catch (Exception e) {\r\n");
	__content.append("\t\t\thandleException(e, retry);\r\n");
	__content.append("\t\t\tif (tx != null) {\r\n");
	__content.append("\t\t\t\ttry {\r\n");
	__content.append("\t\t\t\t\ttx.rollback();\r\n");
	__content.append("\t\t\t\t} catch (TransactionException te) {\r\n");
	__content.append("\t\t\t\t\thandleException(te, retry);\r\n");
	__content.append("\t\t\t\t}\r\n");
	__content.append("\t\t\t}\r\n");
	__content.append("\t\t} finally {\r\n");
	__content.append("\t\t\ttry {\r\n");
	__content.append("\t\t\t\tsession.close();\r\n");
	__content.append("\t\t\t\tclosed = true;\r\n");
	__content.append("\t\t\t} catch (HibernateException he) {\r\n");
	__content.append("\t\t\t\thandleException(he, retry);\r\n");
	__content.append("\t\t\t}\r\n");
	__content.append("\t\t}\r\n");
	__content.append("\t\t\r\n");
	__content.append("\t\tif ((!successful || !closed) && retry) {\r\n");
	__content.append("\t\t\t// retry once\r\n");
	__content.append("\t\t\texecuteInTransaction(command, false);\r\n");
	__content.append("\t\t}\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("\tpublic abstract void handleException(Exception e, boolean retry);\r\n");
	__content.append("\t\r\n");
	__content.append("\tpublic void tearDown() {\r\n");
	__content.append("\t\tsessionFactory.close();\r\n");
	__content.append("\t}\r\n");
	__content.append("\r\n");
	__content.append("\t");
	__content.append(entityMethods.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("\r\n");
	__content.append("}\r\n");
	__content.append("");return __content.toString();
	}
	private String getEntityOperationsBodies(EntityModel entityModel) {
	StringBuilder __content = new StringBuilder();
		for (Entity entity : entityModel.getEntities()) {
			String operationBodies = getEntityOperationsBodies(entity);
	__content.append("");
	__content.append(operationBodies.replaceAll("\\r\\n\\z",""));
	__content.append("\r\n");
	__content.append("");}
		return __content.toString();
	}
	private String getEntityOperationsBodies(Entity entity) {
	StringBuilder __content = new StringBuilder();
		String entityName = entity.getName();
		String entityNameToFirstUpper = toFirstUpper(entityName);
		List<Property> uniqueProperties = getUniqueProperties(entity);
		List<Property> enumProperties = getEnumProperties(entity);
		List<Property> toOneProperties = getToOneProperties(entity);
		List<Property> dateProperties = getDateProperties(entity);
		List<Property> constructorProperties = entity.getConstructorProperties();
		List<Property> toOneReferences = getToOneReferences(entity);
	__content.append("/**\r\n");
	__content.append(" * Creates a new ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(" using all read-only and all non-null properties.\r\n");
	__content.append(" */\r\n");
	__content.append("public ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(" create");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("(");for (Property property :constructorProperties) {
				String typeClassname = property.getType().getJavaClassname();
				String toFirstLower = toFirstLower(property.getName());
	__content.append("final ");
	__content.append(typeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(toFirstLower.replaceAll("\\r\\n\\z",""));
	__content.append("");if (!isLast(constructorProperties, property)) {
	__content.append(", ");}
			}
	__content.append(") {\r\n");
	__content.append("\tfinal ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("[] entity = new ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("[1];\r\n");
	__content.append("\texecuteInTransaction(new ICommand() {\r\n");
	__content.append("\t\t\r\n");
	__content.append("\t\tpublic void execute(IDBOperations operations) {\r\n");
	__content.append("\t\t\tentity[0] = operations.create");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t\t"));
	__content.append("(");for (Property property :constructorProperties) {
						String toFirstLower = toFirstLower(property.getName());
	__content.append("");
	__content.append(toFirstLower.replaceAll("\\r\\n\\z",""));
	__content.append("");if (!isLast(constructorProperties, property)) {
	__content.append(", ");}
					}
	__content.append(");\r\n");
	__content.append("\t\t}\r\n");
	__content.append("\t});\r\n");
	__content.append("\treturn entity[0];\r\n");
	__content.append("}\r\n");
	__content.append("\r\n");
	__content.append("/**\r\n");
	__content.append(" * Returns the ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(" with the given id.\r\n");
	__content.append(" */\r\n");
	__content.append("public ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(" get");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("(final int id) {\r\n");
	__content.append("\tfinal ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("[] entity = new ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("[1];\r\n");
	__content.append("\texecuteInTransaction(new ICommand() {\r\n");
	__content.append("\t\t\r\n");
	__content.append("\t\tpublic void execute(IDBOperations operations) {\r\n");
	__content.append("\t\t\tentity[0] = operations.get");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t\t"));
	__content.append("(id);\r\n");
	__content.append("\t\t}\r\n");
	__content.append("\t});\r\n");
	__content.append("\treturn entity[0];\r\n");
	__content.append("}\r\n");
	__content.append("\r\n");
	__content.append("");for (Property property :uniqueProperties) {
			String propertyName = property.getName();
			String toFirstUpper = toFirstUpper(propertyName);
			String typeClassname = property.getType().getJavaClassname();
	__content.append("/**\r\n");
	__content.append(" * Returns the ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(" with the given ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(".\r\n");
	__content.append(" */\r\n");
	__content.append("public ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(" get");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("By");
	__content.append(toFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(final ");
	__content.append(typeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(") {\r\n");
	__content.append("\tfinal ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("[] entity = new ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("[1];\r\n");
	__content.append("\texecuteInTransaction(new ICommand() {\r\n");
	__content.append("\t\t\r\n");
	__content.append("\t\tpublic void execute(IDBOperations operations) {\r\n");
	__content.append("\t\t\tentity[0] = operations.get");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t\t"));
	__content.append("By");
	__content.append(toFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(");\r\n");
	__content.append("\t\t}\r\n");
	__content.append("\t});\r\n");
	__content.append("\treturn entity[0];\r\n");
	__content.append("}\r\n");
	__content.append("\r\n");
	__content.append("");}

		for (Property property :toOneProperties) {
			String propertyName = property.getName();
			String toFirstUpper = toFirstUpper(propertyName);
			String typeClassname = property.getType().getJavaClassname();
	__content.append("/**\r\n");
	__content.append(" * Returns the ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("s with the given ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(".\r\n");
	__content.append(" */\r\n");
	__content.append("public List<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("> get");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("sBy");
	__content.append(toFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(final ");
	__content.append(typeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(") {\r\n");
	__content.append("\tfinal List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("> entities = new ArrayList<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(">();\r\n");
	__content.append("\texecuteInTransaction(new ICommand() {\r\n");
	__content.append("\t\t\r\n");
	__content.append("\t\tpublic void execute(IDBOperations operations) {\r\n");
	__content.append("\t\t\tentities.addAll(operations.get");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t\t"));
	__content.append("sBy");
	__content.append(toFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append("));\r\n");
	__content.append("\t\t}\r\n");
	__content.append("\t});\r\n");
	__content.append("\treturn entities;\r\n");
	__content.append("}\r\n");
	__content.append("\r\n");
	__content.append("");}
		for (Property property :enumProperties) {
			String propertyName = property.getName();
			String toFirstUpper = toFirstUpper(propertyName);
			String typeClassname = property.getType().getJavaClassname();
	__content.append("/**\r\n");
	__content.append(" * Returns all ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("s with the given ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(".\r\n");
	__content.append(" */\r\n");
	__content.append("public List<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("> get");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("sBy");
	__content.append(toFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(final ");
	__content.append(typeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(") {\r\n");
	__content.append("\tfinal List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("> entities = new ArrayList<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(">();\r\n");
	__content.append("\texecuteInTransaction(new ICommand() {\r\n");
	__content.append("\t\t\r\n");
	__content.append("\t\tpublic void execute(IDBOperations operations) {\r\n");
	__content.append("\t\t\tentities.addAll(operations.get");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t\t"));
	__content.append("sBy");
	__content.append(toFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append("));\r\n");
	__content.append("\t\t}\r\n");
	__content.append("\t});\r\n");
	__content.append("\treturn entities;\r\n");
	__content.append("}\r\n");
	__content.append("\r\n");
	__content.append("");}
			
		for (Constraint constraint : entity.getConstraints()) {
			if (constraint instanceof UniqueConstraint) {
				UniqueConstraint uniqueConstraint = (UniqueConstraint) constraint;
	__content.append("/**\r\n");
	__content.append(" * Returns the ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(" with the given properties.\r\n");
	__content.append(" */\r\n");
	__content.append("public ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(" get");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("By");for (Property property : uniqueConstraint.getProperties()) {
					String toFirstUpper = toFirstUpper(property.getName());
	__content.append("");
	__content.append(toFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("");}
	__content.append("(");for (Property property : uniqueConstraint.getProperties()) {
					String propertyName = property.getName();
					String toFirstUpper = toFirstUpper(propertyName);
					String typeClassname = property.getType().getJavaClassname();
	__content.append("final ");
	__content.append(typeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append("");if (!isLast(uniqueConstraint.getProperties(), property)) {
	__content.append(", ");}
				}
	__content.append(") {\r\n");
	__content.append("\tfinal ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("[] entity = new ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("[1];\r\n");
	__content.append("\texecuteInTransaction(new ICommand() {\r\n");
	__content.append("\t\t\r\n");
	__content.append("\t\tpublic void execute(IDBOperations operations) {\r\n");
	__content.append("\t\t\tentity[0] = operations.get");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t\t"));
	__content.append("By");for (Property property : uniqueConstraint.getProperties()) {
								String toFirstUpper = toFirstUpper(property.getName());
	__content.append("");
	__content.append(toFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("");}
	__content.append("(");for (Property property : uniqueConstraint.getProperties()) {
								String propertyName = property.getName();
	__content.append("");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append("");if (!isLast(uniqueConstraint.getProperties(), property)) {
	__content.append(", ");}
							}
	__content.append(");\r\n");
	__content.append("\t\t}\r\n");
	__content.append("\t});\r\n");
	__content.append("\treturn entity[0];\r\n");
	__content.append("}\r\n");
	__content.append("\r\n");
	__content.append("");}
		}
		
		for (Property property :dateProperties) {
			String propertyName = property.getName();
			String toFirstUpper = toFirstUpper(propertyName);
			String typeClassname = property.getType().getJavaClassname();
	__content.append("/**\r\n");
	__content.append(" * Returns all ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("s where ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(" is set to a value before \'_maxDate\'.\r\n");
	__content.append(" */\r\n");
	__content.append("public List<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("> get");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("sWith");
	__content.append(toFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("Before(final ");
	__content.append(typeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" _maxDate) {\r\n");
	__content.append("\tfinal List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("> entities = new ArrayList<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(">();\r\n");
	__content.append("\texecuteInTransaction(new ICommand() {\r\n");
	__content.append("\t\t\r\n");
	__content.append("\t\tpublic void execute(IDBOperations operations) {\r\n");
	__content.append("\t\t\tentities.addAll(operations.get");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t\t"));
	__content.append("sWith");
	__content.append(toFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("Before(_maxDate));\r\n");
	__content.append("\t\t}\r\n");
	__content.append("\t});\r\n");
	__content.append("\treturn entities;\r\n");
	__content.append("}\r\n");
	__content.append("\r\n");
	__content.append("");}
		for (Property property :dateProperties) {
			String propertyName = property.getName();
			String toFirstUpper = toFirstUpper(propertyName);
			String typeClassname = property.getType().getJavaClassname();
	__content.append("/**\r\n");
	__content.append(" * Returns all ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("s where ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(" is set to a value after \'_minDate\'.\r\n");
	__content.append(" */\r\n");
	__content.append("public List<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("> get");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("sWith");
	__content.append(toFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("After(final ");
	__content.append(typeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" _minDate) {\r\n");
	__content.append("\tfinal List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("> entities = new ArrayList<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(">();\r\n");
	__content.append("\texecuteInTransaction(new ICommand() {\r\n");
	__content.append("\t\t\r\n");
	__content.append("\t\tpublic void execute(IDBOperations operations) {\r\n");
	__content.append("\t\t\tentities.addAll(operations.get");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t\t"));
	__content.append("sWith");
	__content.append(toFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("After(_minDate));\r\n");
	__content.append("\t\t}\r\n");
	__content.append("\t});\r\n");
	__content.append("\treturn entities;\r\n");
	__content.append("}\r\n");
	__content.append("\r\n");
	__content.append("");}
	__content.append("/**\r\n");
	__content.append(" * Returns all entities of type ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(".\r\n");
	__content.append(" */\r\n");
	__content.append("public List<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("> getAll");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("s() {\r\n");
	__content.append("\tfinal List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("> entities = new ArrayList<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(">();\r\n");
	__content.append("\texecuteInTransaction(new ICommand() {\r\n");
	__content.append("\t\t\r\n");
	__content.append("\t\tpublic void execute(IDBOperations operations) {\r\n");
	__content.append("\t\t\tentities.addAll(operations.getAll");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t\t"));
	__content.append("s());\r\n");
	__content.append("\t\t}\r\n");
	__content.append("\t});\r\n");
	__content.append("\treturn entities;\r\n");
	__content.append("}\r\n");
	__content.append("\r\n");
	__content.append("/**\r\n");
	__content.append(" * Searches for entities of type ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(".\r\n");
	__content.append(" */\r\n");
	__content.append("public List<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("> search");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("s(final String _searchString, final int _maxResults) {\r\n");
	__content.append("\tfinal List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("> entities = new ArrayList<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(">();\r\n");
	__content.append("\texecuteInTransaction(new ICommand() {\r\n");
	__content.append("\t\t\r\n");
	__content.append("\t\tpublic void execute(IDBOperations operations) {\r\n");
	__content.append("\t\t\tentities.addAll(operations.search");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t\t"));
	__content.append("s(_searchString, _maxResults));\r\n");
	__content.append("\t\t}\r\n");
	__content.append("\t});\r\n");
	__content.append("\treturn entities;\r\n");
	__content.append("}\r\n");
	__content.append("\r\n");
	__content.append("");for (Property toOneReference :toOneReferences) {
			String toOneReferenceName = toOneReference.getName();
			String toFirstUpper = toFirstUpper(toOneReferenceName);
			String typeClassname = toOneReference.getType().getJavaClassname();
	__content.append("/**\r\n");
	__content.append(" * Searches for entities of type ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(".\r\n");
	__content.append(" */\r\n");
	__content.append("public List<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("> search");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("With");
	__content.append(toFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(final ");
	__content.append(typeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(toOneReferenceName.replaceAll("\\r\\n\\z",""));
	__content.append(", final String _searchString, final int _maxResults) {\r\n");
	__content.append("\tfinal List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("> entities = new ArrayList<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(">();\r\n");
	__content.append("\texecuteInTransaction(new ICommand() {\r\n");
	__content.append("\t\t\r\n");
	__content.append("\t\tpublic void execute(IDBOperations operations) {\r\n");
	__content.append("\t\t\tentities.addAll(operations.search");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t\t"));
	__content.append("With");
	__content.append(toFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(");
	__content.append(toOneReferenceName.replaceAll("\\r\\n\\z",""));
	__content.append(", _searchString, _maxResults));\r\n");
	__content.append("\t\t}\r\n");
	__content.append("\t});\r\n");
	__content.append("\treturn entities;\r\n");
	__content.append("}\r\n");
	__content.append("\r\n");
	__content.append("");}
	__content.append("/**\r\n");
	__content.append(" * Deletes a ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(".\r\n");
	__content.append(" */\r\n");
	__content.append("public void delete(final ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(" entity) {\r\n");
	__content.append("\texecuteInTransaction(new ICommand() {\r\n");
	__content.append("\t\t\r\n");
	__content.append("\t\tpublic void execute(IDBOperations operations) {\r\n");
	__content.append("\t\t\toperations.delete(entity);\r\n");
	__content.append("\t\t}\r\n");
	__content.append("\t});\r\n");
	__content.append("}\r\n");
	__content.append("\r\n");
	__content.append("/**\r\n");
	__content.append(" * Counts the number of ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(" entities.\r\n");
	__content.append(" */\r\n");
	__content.append("public int count");
	__content.append(entityNameToFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("s() {\r\n");
	__content.append("\tfinal int[] count = new int[1];\r\n");
	__content.append("\texecuteInTransaction(new ICommand() {\r\n");
	__content.append("\t\t\r\n");
	__content.append("\t\tpublic void execute(IDBOperations operations) {\r\n");
	__content.append("\t\t\tcount[0] = operations.count");
	__content.append(entityNameToFirstUpper.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t\t"));
	__content.append("s();\r\n");
	__content.append("\t\t}\r\n");
	__content.append("\t});\r\n");
	__content.append("\treturn count[0];\r\n");
	__content.append("}\r\n");
	__content.append("\r\n");
	__content.append("");return __content.toString();
	}
	public String generateOperationProvider(String packageName) {
	StringBuilder __content = new StringBuilder();
	__content.append("package ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(CUSTOM_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(";\r\n");
	__content.append("\r\n");
	__content.append("import org.hibernate.classic.Session;\r\n");
	__content.append("import ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(DAO_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(".OperationProviderBase;\r\n");
	__content.append("\r\n");
	__content.append("// this class is only generated once. it can be customized and all changes\r\n");
	__content.append("// will be preserved.\r\n");
	__content.append("public class OperationProvider extends OperationProviderBase implements IDBOperations {\r\n");
	__content.append("\r\n");
	__content.append("\tpublic OperationProvider(Session session) {\r\n");
	__content.append("\t\tsuper(session);\r\n");
	__content.append("\t}\r\n");
	__content.append("\r\n");
	__content.append("}\r\n");
	__content.append("");return __content.toString();
	}
	public String generateOperationProviderBase(String packageName, EntityModel entityModel) {
	StringBuilder __content = new StringBuilder();
	__content.append("package ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(DAO_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(";\r\n");
	__content.append("\r\n");
	__content.append("import java.util.List;\r\n");
	__content.append("\r\n");
	__content.append("import org.hibernate.Criteria;\r\n");
	__content.append("import org.hibernate.HibernateException;\r\n");
	__content.append("import org.hibernate.SessionFactory;\r\n");
	__content.append("import org.hibernate.Transaction;\r\n");
	__content.append("import org.hibernate.cfg.Configuration;\r\n");
	__content.append("import org.hibernate.classic.Session;\r\n");
	__content.append("import org.hibernate.criterion.MatchMode;\r\n");
	__content.append("import org.hibernate.criterion.Order;\r\n");
	__content.append("import org.hibernate.criterion.Restrictions;\r\n");
	__content.append("import org.hibernate.metadata.ClassMetadata;\r\n");
	__content.append("import org.hibernate.persister.entity.AbstractEntityPersister;\r\n");
	__content.append("\r\n");
	__content.append("");for (Entity otherEntity : entityModel.getEntities()) {
			String otherEntityName = otherEntity.getName();
	__content.append("import ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(ENTITY_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(otherEntityName.replaceAll("\\r\\n\\z",""));
	__content.append(";\r\n");
	__content.append("");}
		for (Enum otherEnum : entityModel.getEnums()) {
			String otherEnumName = otherEnum.getName();
	__content.append("import ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(ENTITY_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(otherEnumName.replaceAll("\\r\\n\\z",""));
	__content.append(";\r\n");
	__content.append("");}
	__content.append("\r\n");
	__content.append("/**\r\n");
	__content.append(" * This class provides all default operations that are derived from the HEDL entity model.\r\n");
	__content.append(" *\r\n");
	__content.append(" * Note: This class is generated. Any change will be overridden.\r\n");
	__content.append(" */\r\n");
	__content.append("public abstract class OperationProviderBase implements IDBOperationsBase {\r\n");
	__content.append("\t\t\r\n");
	__content.append("\tprivate Session session;\r\n");
	__content.append("\t\r\n");
	__content.append("");for (Entity entity : entityModel.getEntities()) {
				String entityName = entity.getName();
				String toFirstLower = toFirstLower(entityName);
	__content.append("\tprivate ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("DAO ");
	__content.append(toFirstLower.replaceAll("\\r\\n\\z",""));
	__content.append("DAO = new ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("DAO();\r\n");
	__content.append("");}
	__content.append("\r\n");
	__content.append("\tpublic OperationProviderBase(Session session) {\r\n");
	__content.append("\t\tthis.session = session;\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("\tpublic Session getSession() {\r\n");
	__content.append("\t\treturn session;\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("\t");for (Entity entity : entityModel.getEntities()) {
				String entityName = entity.getName();
				String entityNameToFirstLower = toFirstLower(entityName);
				String entityNameToFirstUpper = toFirstUpper(entityName);
				List<Property> uniqueProperties = getUniqueProperties(entity);
				List<Property> enumProperties = getEnumProperties(entity);
				List<Property> toOneProperties = getToOneProperties(entity);
				List<Property> dateProperties = getDateProperties(entity);
				List<Property> constructorProperties = entity.getConstructorProperties();
				List<Property> toOneReferences = getToOneReferences(entity);
	__content.append("\t/** \r\n");
	__content.append("\t * Creates an instance of type ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" using all read-only and all non-null properties.\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" create");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("(");for (Property property :constructorProperties) {
						String propertyType = property.getType().getJavaClassname();
						String propertyToFirstLower = toFirstLower(property.getName());
	__content.append("");
	__content.append(propertyType.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(propertyToFirstLower.replaceAll("\\r\\n\\z",""));
	__content.append("");if (!isLast(constructorProperties, property)) {
	__content.append(", ");}
					}
	__content.append(") {\r\n");
	__content.append("\t\treturn ");
	__content.append(entityNameToFirstLower.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("DAO.create(session");for (Property property :constructorProperties) {
						String propertyToFirstLower = toFirstLower(property.getName());
	__content.append(", ");
	__content.append(propertyToFirstLower.replaceAll("\\r\\n\\z",""));
	__content.append("");}
	__content.append(");\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("\t/**\r\n");
	__content.append("\t * Returns the ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" with the given id.\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" get");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("(int id) {\r\n");
	__content.append("\t\t");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(" entity = ");
	__content.append(entityNameToFirstLower.replaceAll("\\r\\n\\z",""));
	__content.append("DAO.get(session, id);\r\n");
	__content.append("\t\treturn entity;\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("\t");for (Property property :uniqueProperties) {
					String propertyName = property.getName();
					String propertyNameToFirstUpper = toFirstUpper(propertyName);
					String propertyTypeClassname = property.getType().getJavaClassname();
	__content.append("\t/** Returns the ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" with the given ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(". */\r\n");
	__content.append("\tpublic ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" get");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("By");
	__content.append(propertyNameToFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(");
	__content.append(propertyTypeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(") {\r\n");
	__content.append("\t\t");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(" entity = ");
	__content.append(entityNameToFirstLower.replaceAll("\\r\\n\\z",""));
	__content.append("DAO.getBy");
	__content.append(propertyNameToFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(session, ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(");\r\n");
	__content.append("\t\treturn entity;\r\n");
	__content.append("\t}\r\n");
	__content.append("\t");}
				
				for (Property property :toOneProperties) {
					String propertyName = property.getName();
					String propertyNameToFirstUpper = toFirstUpper(propertyName);
					String propertyTypeClassname = property.getType().getJavaClassname();
	__content.append("\t/** Returns the ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("s with the given ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(". */\r\n");
	__content.append("\tpublic List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("> get");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("sBy");
	__content.append(propertyNameToFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(");
	__content.append(propertyTypeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(") {\r\n");
	__content.append("\t\tList<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("> entities = ");
	__content.append(entityNameToFirstLower.replaceAll("\\r\\n\\z",""));
	__content.append("DAO.getBy");
	__content.append(propertyNameToFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(session, ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(");\r\n");
	__content.append("\t\treturn entities;\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("\t");}
			
				for (Property property :enumProperties) {
					String propertyName = property.getName();
					String propertyNameToFirstUpper = toFirstUpper(propertyName);
					String propertyTypeClassname = property.getType().getJavaClassname();
	__content.append("\t/**\r\n");
	__content.append("\t * Returns all ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("s with the given ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(".\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("> get");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("sBy");
	__content.append(propertyNameToFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(");
	__content.append(propertyTypeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(") {\r\n");
	__content.append("\t\treturn ");
	__content.append(entityNameToFirstLower.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("DAO.getBy");
	__content.append(propertyNameToFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(session, ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(");\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("\t");}
				
				for (Constraint constraint : entity.getConstraints()) {
					if (constraint instanceof UniqueConstraint) {
						UniqueConstraint uniqueConstraint = (UniqueConstraint) constraint;
	__content.append("\t/**\r\n");
	__content.append("\t * Returns the ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" with the given properties.\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" get");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("By");for (Property property : uniqueConstraint.getProperties()) {
							String propertyNameToFirstUpper = toFirstUpper(property.getName());
	__content.append("");
	__content.append(propertyNameToFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("");}
	__content.append("(");for (Property property : uniqueConstraint.getProperties()) {
							String propertyName = property.getName();
							String propertyTypeClassname = property.getTypeClassname();
	__content.append("");
	__content.append(propertyTypeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append("");if (!isLast(uniqueConstraint.getProperties(), property)) {
	__content.append(", ");}
						}
	__content.append(") {\r\n");
	__content.append("\t\t");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(" entity = ");
	__content.append(entityNameToFirstLower.replaceAll("\\r\\n\\z",""));
	__content.append("DAO.getBy");for (Property property : uniqueConstraint.getProperties()) {
								String propertyNameToFirstUpper = toFirstUpper(property.getName());
	__content.append("");
	__content.append(propertyNameToFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("");}
	__content.append("(session, ");for (Property property : uniqueConstraint.getProperties()) {
								String propertyName = property.getName();
	__content.append("");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append("");if (!isLast(uniqueConstraint.getProperties(), property)) {
	__content.append(", ");}
							}
	__content.append("\t\t);\r\n");
	__content.append("\t\treturn entity;\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("\t");}
				}
			
				for (Property property :dateProperties) {
					String propertyName = property.getName();
					String propertyNameToFirstUpper = toFirstUpper(propertyName);
					String propertyTypeClassname = property.getType().getJavaClassname();
	__content.append("/**\r\n");
	__content.append("\t * Returns all ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("s where ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(" is set to a value before \'_maxDate\'.\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("> get");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("sWith");
	__content.append(propertyNameToFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("Before(");
	__content.append(propertyTypeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" _maxDate) {\r\n");
	__content.append("\t\tfinal List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("> entities = ");
	__content.append(entityNameToFirstLower.replaceAll("\\r\\n\\z",""));
	__content.append("DAO.get");
	__content.append(propertyNameToFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("Before(session, _maxDate);\r\n");
	__content.append("\t\treturn entities;\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("\t");}
				
				for (Property property :dateProperties) {
					String propertyName = property.getName();
					String propertyNameToFirstUpper = toFirstUpper(propertyName);
					String propertyTypeClassname = property.getType().getJavaClassname();
	__content.append("\t/**\r\n");
	__content.append("\t * Returns all ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("s where ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(" is set to a value after \'_minDate\'.\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("> get");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("sWith");
	__content.append(propertyNameToFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("After(");
	__content.append(propertyTypeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" _minDate) {\r\n");
	__content.append("\t\tfinal List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("> entities = ");
	__content.append(entityNameToFirstLower.replaceAll("\\r\\n\\z",""));
	__content.append("DAO.get");
	__content.append(propertyNameToFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("After(session, _minDate);\r\n");
	__content.append("\t\treturn entities;\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("\t");}
	__content.append("\t/**\r\n");
	__content.append("\t * Returns all entities of type ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(".\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("> getAll");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("s() {\r\n");
	__content.append("\t\tfinal List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("> entities = ");
	__content.append(entityNameToFirstLower.replaceAll("\\r\\n\\z",""));
	__content.append("DAO.getAll(session);\r\n");
	__content.append("\t\treturn entities;\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("\t/**\r\n");
	__content.append("\t * Searches for entities of type ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(".\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("> search");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("s(String _searchString, int _maxResults) {\r\n");
	__content.append("\t\treturn ");
	__content.append(entityNameToFirstLower.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("DAO.search(session, _searchString, _maxResults);\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("\t");for (Property property :toOneReferences) {
					String propertyName = property.getName();
					String propertyNameToFirstUpper = toFirstUpper(propertyName);
					String propertyTypeClassname = property.getTypeClassname();
	__content.append("\t/**\r\n");
	__content.append("\t * Searches for entities of type ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(".\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("> search");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("With");
	__content.append(propertyNameToFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(");
	__content.append(propertyTypeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(", String _searchString, int _maxResults) {\r\n");
	__content.append("\t\treturn ");
	__content.append(entityNameToFirstLower.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("DAO.searchWith");
	__content.append(propertyNameToFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(session, ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(", _searchString, _maxResults);\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("\t");}
	__content.append("\t/**\r\n");
	__content.append("\t * Deletes a ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(".\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic void delete(");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" entity) {\r\n");
	__content.append("\t\t");
	__content.append(entityNameToFirstLower.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("DAO.delete(session, entity);\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("\t/**\r\n");
	__content.append("\t * Counts the number of ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" entities.\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic int count");
	__content.append(entityNameToFirstUpper.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("s() {\r\n");
	__content.append("\t\treturn ");
	__content.append(entityNameToFirstLower.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("DAO.count(session);\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("\t");}
	__content.append("\t/**\r\n");
	__content.append("\t * Returns the name of the table that contains entities of the given type.\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic String getTableName(Class<?> clazz) {\r\n");
	__content.append("\t\tClassMetadata hibernateMetadata = getSession().getSessionFactory().getClassMetadata(clazz);\r\n");
	__content.append("\t\tif (hibernateMetadata == null) {\r\n");
	__content.append("\t\t    return null;\r\n");
	__content.append("\t\t}\r\n");
	__content.append("\t\tif (hibernateMetadata instanceof AbstractEntityPersister) {\r\n");
	__content.append("\t\t     AbstractEntityPersister persister = (AbstractEntityPersister) hibernateMetadata;\r\n");
	__content.append("\t\t     return persister.getTableName();\r\n");
	__content.append("\t\t}\r\n");
	__content.append("\t\treturn null;\r\n");
	__content.append("\t}\r\n");
	__content.append("}\r\n");
	__content.append("");return __content.toString();
	}
	public String generateEntityDAO(String packageName, Entity entity) {
	StringBuilder __content = new StringBuilder();
		String entityName = entity.getName();
		
		List<Property> uniqueProperties = getUniqueProperties(entity);
		List<Property> enumProperties = getEnumProperties(entity);
		List<Property> toOneProperties = getToOneProperties(entity);
		List<Property> dateProperties = getDateProperties(entity);
		List<Property> constructorProperties = entity.getConstructorProperties();
		List<Property> toOneReferences = getToOneReferences(entity);
	__content.append("package ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(DAO_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(";\r\n");
	__content.append("\r\n");
	__content.append("import java.util.List;\r\n");
	__content.append("\r\n");
	__content.append("import org.hibernate.classic.Session;\r\n");
	__content.append("import org.hibernate.Criteria;\r\n");
	__content.append("import org.hibernate.HibernateException;\r\n");
	__content.append("import org.hibernate.criterion.Disjunction;\r\n");
	__content.append("import org.hibernate.criterion.MatchMode;\r\n");
	__content.append("import org.hibernate.criterion.Order;\r\n");
	__content.append("import org.hibernate.criterion.Restrictions;\r\n");
	__content.append("");for (Entity otherEntity : entity.getEntityModel().getEntities()) {
			String otherEntityName = otherEntity.getName();
	__content.append("import ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(ENTITY_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(otherEntityName.replaceAll("\\r\\n\\z",""));
	__content.append(";\r\n");
	__content.append("");}
		
		for (Enum otherEnum : entity.getEntityModel().getEnums()) {
			String otherEnumName = otherEnum.getName();
	__content.append("import ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(ENTITY_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(otherEnumName.replaceAll("\\r\\n\\z",""));
	__content.append(";\r\n");
	__content.append("");}
	__content.append("\r\n");
	__content.append("import java.util.List;\r\n");
	__content.append("\r\n");
	__content.append("/**\r\n");
	__content.append(" * This class provides all default operations that are derived from the HEDL entity model\r\n");
	__content.append(" * for type ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(".\r\n");
	__content.append(" *\r\n");
	__content.append(" * Note: This class is generated. Any change will be overridden.\r\n");
	__content.append(" */\r\n");
	__content.append("public class ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("DAO {\r\n");
	__content.append("\t\r\n");
	__content.append("");if (entity.getSuperType() == null) {
	__content.append("\tpublic final static String FIELD__ID = getField(");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(".class, \"id\");\r\n");
	__content.append("");}
			for (Property property : entity.getProperties()) {
				String propertyName = property.getName();
				String toUpperCase = propertyName.toUpperCase();
	__content.append("\tpublic final static String FIELD__");
	__content.append(toUpperCase.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" = getField(");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(".class, \"");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append("\");\r\n");
	__content.append("");}
	__content.append("\t\r\n");
	__content.append("\t/**\r\n");
	__content.append("\t * Creates a ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" using all read-only and all non-null properties.\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" create(Session session");for (Property property :constructorProperties) {
					String propertyTypeClassname = property.getType().getJavaClassname();
					String propertyToFirstLower = toFirstLower(property.getName());
	__content.append(", ");
	__content.append(propertyTypeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(propertyToFirstLower.replaceAll("\\r\\n\\z",""));
	__content.append("");}
	__content.append(") {\r\n");
	__content.append("\t\t");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(" newEntity = new ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("(");for (Property property :constructorProperties) {
					String propertyToFirstLower = toFirstLower(property.getName());
	__content.append("");
	__content.append(propertyToFirstLower.replaceAll("\\r\\n\\z",""));
	__content.append("");if (!isLast(constructorProperties, property)) {
	__content.append(", ");}
				}
	__content.append(");\r\n");
	__content.append("\t\tsession.save(newEntity);\r\n");
	__content.append("\t\treturn newEntity;\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("\t/**\r\n");
	__content.append("\t * Returns the ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" with the given id.\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" get(Session session, int id) {\r\n");
	__content.append("\t\t");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(" entity = (");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(") session.get(");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(".class, id);\r\n");
	__content.append("\t\treturn entity;\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("");for (Property property :uniqueProperties) {
				String propertyName = property.getName();
				String propertyNameToUpperCase = propertyName.toUpperCase();
				String propertyNameToFirstUpper = toFirstUpper(propertyName);
				String propertyTypeClassname = property.getType().getJavaClassname();
	__content.append("\t/**\r\n");
	__content.append("\t * Returns the ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" with the given ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(".\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" getBy");
	__content.append(propertyNameToFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(Session session, ");
	__content.append(propertyTypeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(") {\r\n");
	__content.append("\t\tCriteria criteria = session.createCriteria(");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(".class);\r\n");
	__content.append("\t\tcriteria = criteria.add(Restrictions.eq(FIELD__");
	__content.append(propertyNameToUpperCase.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(", ");
	__content.append(propertyName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("));\r\n");
	__content.append("\t\tList<?> list = criteria.list();\r\n");
	__content.append("\t\tif (list != null && !list.isEmpty()) {\r\n");
	__content.append("\t\t\treturn (");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t\t"));
	__content.append(") list.get(0);\r\n");
	__content.append("\t\t}\r\n");
	__content.append("\t\treturn null;\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("");}
			for (Property property :toOneProperties) {
				String propertyName = property.getName();
				String propertyNameToUpperCase = propertyName.toUpperCase();
				String propertyNameToFirstUpper = toFirstUpper(propertyName);
				String propertyTypeClassname = property.getType().getJavaClassname();
	__content.append("\t/**\r\n");
	__content.append("\t * Returns the ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("s with the given ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(".\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("> getBy");
	__content.append(propertyNameToFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(Session session, ");
	__content.append(propertyTypeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(") {\r\n");
	__content.append("\t\tCriteria criteria = session.createCriteria(");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(".class);\r\n");
	__content.append("\t\tcriteria = criteria.add(Restrictions.eq(FIELD__");
	__content.append(propertyNameToUpperCase.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(", ");
	__content.append(propertyName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("));\r\n");
	__content.append("\t\t@SuppressWarnings(\"unchecked\")\r\n");
	__content.append("\t\tList<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("> list = (List<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(">) criteria.list();\r\n");
	__content.append("\t\treturn list;\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("");}
			for (Constraint constraint : entity.getConstraints()) {
				if (constraint instanceof UniqueConstraint) {
					UniqueConstraint uniqueConstraint = (UniqueConstraint) constraint;
	__content.append("\t/**\r\n");
	__content.append("\t * Returns the ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" with the given properties.\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" getBy");for (Property property : uniqueConstraint.getProperties()) {
						String propertyNameToFirstUpper = toFirstUpper(property.getName());
	__content.append("");
	__content.append(propertyNameToFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("");}
	__content.append("(Session session, ");for (Property property : uniqueConstraint.getProperties()) {
						String propertyName = property.getName();
						String propertyTypeJavaClassname = property.getType().getJavaClassname();
	__content.append("");
	__content.append(propertyTypeJavaClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append("");if (!isLast(uniqueConstraint.getProperties(), property)) {
	__content.append(", ");}
					}
	__content.append(") {\r\n");
	__content.append("\t\tCriteria criteria = session.createCriteria(");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(".class);\r\n");
	__content.append("");for (Property property : uniqueConstraint.getProperties()) {
							String propertyName = property.getName();
							String upperCasePropertyName = propertyName.toUpperCase();
	__content.append("\t\tcriteria = criteria.add(Restrictions.eq(FIELD__");
	__content.append(upperCasePropertyName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(", ");
	__content.append(propertyName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("));\r\n");
	__content.append("");}
	__content.append("\t\tList<?> list = criteria.list();\r\n");
	__content.append("\t\tif (list != null && !list.isEmpty()) {\r\n");
	__content.append("\t\t\treturn (");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t\t"));
	__content.append(") list.get(0);\r\n");
	__content.append("\t\t}\r\n");
	__content.append("\t\treturn null;\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("");}
			}
			
			for (Property property :enumProperties) {
				String propertyName = property.getName();
				String typeJavaClassname = property.getType().getJavaClassname();
				String upperCasePropertyName = propertyName.toUpperCase();
				String propertyNameToFirstUpper = toFirstUpper(propertyName);
	__content.append("\t/**\r\n");
	__content.append("\t * Returns all ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("s with the given ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(".\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("> getBy");
	__content.append(propertyNameToFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(Session session, ");
	__content.append(typeJavaClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(") {\r\n");
	__content.append("\t\tCriteria criteria = session.createCriteria(");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(".class);\r\n");
	__content.append("\t\tcriteria = criteria.add(Restrictions.eq(FIELD__");
	__content.append(upperCasePropertyName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(", ");
	__content.append(propertyName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("));\r\n");
	__content.append("\t\tList<?> list = criteria.list();\r\n");
	__content.append("\t\t@SuppressWarnings(\"unchecked\")\r\n");
	__content.append("\t\tList<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("> entities = (List<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(">) list;\r\n");
	__content.append("\t\treturn entities;\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("");}
			for (Property property :dateProperties) {
				String typeJavaClassname = property.getType().getJavaClassname();
				String propertyName = property.getName();
				String upperCasePropertyName = propertyName.toUpperCase();
				String propertyNameToFirstUpper = toFirstUpper(propertyName);
	__content.append("\t/**\r\n");
	__content.append("\t * Returns all ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("s where ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(" is set to a value before \'_maxDate\'.\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("> get");
	__content.append(propertyNameToFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("Before(Session session, ");
	__content.append(typeJavaClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" _maxDate) {\r\n");
	__content.append("\t\tCriteria criteria = session.createCriteria(");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(".class);\r\n");
	__content.append("\t\tcriteria = criteria.add(Restrictions.le(FIELD__");
	__content.append(upperCasePropertyName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(", _maxDate));\r\n");
	__content.append("\t\tList<?> list = criteria.list();\r\n");
	__content.append("\t\t@SuppressWarnings(\"unchecked\")\r\n");
	__content.append("\t\tList<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("> entities = (List<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(">) list;\r\n");
	__content.append("\t\treturn entities;\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("");}
			for (Property property :dateProperties) {
				String typeJavaClassname = property.getType().getJavaClassname();
				String propertyName = property.getName();
				String upperCasePropertyName = propertyName.toUpperCase();
				String propertyNameToFirstUpper = toFirstUpper(propertyName);
	__content.append("\t/**\r\n");
	__content.append("\t * Returns all ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("s where ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(" is set to a value after \'_minDate\'.\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("> get");
	__content.append(propertyNameToFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("After(Session session, ");
	__content.append(typeJavaClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" _minDate) {\r\n");
	__content.append("\t\tCriteria criteria = session.createCriteria(");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(".class);\r\n");
	__content.append("\t\tcriteria = criteria.add(Restrictions.ge(FIELD__");
	__content.append(upperCasePropertyName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(", _minDate));\r\n");
	__content.append("\t\tList<?> list = criteria.list();\r\n");
	__content.append("\t\t@SuppressWarnings(\"unchecked\")\r\n");
	__content.append("\t\tList<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("> entities = (List<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(">) list;\r\n");
	__content.append("\t\treturn entities;\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("");}
	__content.append("\t/**\r\n");
	__content.append("\t * Returns all entities of type ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(".\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("> getAll(Session session) {\r\n");
	__content.append("\t\tCriteria criteria = session.createCriteria(");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(".class);\r\n");
	__content.append("\t\t@SuppressWarnings(\"unchecked\")\r\n");
	__content.append("\t\tList<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("> entities = (List<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(">) criteria.list();\r\n");
	__content.append("\t\treturn entities;\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("\t/**\r\n");
	__content.append("\t * Searches for entities of type ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(".\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("> search(Session _session, String _searchString, int _maxResults) {\r\n");
	__content.append("\t\tCriteria criteria = _session.createCriteria(");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(".class);\r\n");
	__content.append("\t\tDisjunction disjunction = Restrictions.disjunction();\r\n");
	__content.append("");for (Property property : entity.getProperties()) {
					if (property.getType().getJavaClassname().equals(String.class.getName())) {
						String propertyNameToUpperCase = property.getName().toUpperCase();
	__content.append("\t\tdisjunction.add(Restrictions.like(FIELD__");
	__content.append(propertyNameToUpperCase.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(", _searchString.trim(), MatchMode.ANYWHERE));\r\n");
	__content.append("");}
				}
	__content.append("\t\tcriteria = criteria.add(disjunction);\r\n");
	__content.append("\t\tcriteria = criteria.setMaxResults(_maxResults);\r\n");
	__content.append("\t\t@SuppressWarnings(\"unchecked\")\r\n");
	__content.append("\t\tList<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("> entities = (List<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(">) criteria.list();\r\n");
	__content.append("\t\treturn entities;\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("");for (Property toOneReference :toOneReferences) {
				String toOneReferenceName = toOneReference.getName();
				String toOneReferenceNameToFirstUpper = toFirstUpper(toOneReferenceName);
				String toOneReferenceNameToUpperCase = toOneReferenceName.toUpperCase();
				String toOneReferenceTypeClassname = toOneReference.getType().getJavaClassname();
	__content.append("\t/**\r\n");
	__content.append("\t * Searches for entities of type ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(".\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic List<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("> searchWith");
	__content.append(toOneReferenceNameToFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("(Session _session, ");
	__content.append(toOneReferenceTypeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(toOneReferenceName.replaceAll("\\r\\n\\z",""));
	__content.append(", String _searchString, int _maxResults) {\r\n");
	__content.append("\t\tCriteria criteria = _session.createCriteria(");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(".class);\r\n");
	__content.append("\t\t// restrict by the value of the unique property\r\n");
	__content.append("\t\tcriteria = criteria.add(Restrictions.eq(FIELD__");
	__content.append(toOneReferenceNameToUpperCase.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(", ");
	__content.append(toOneReferenceName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("));\r\n");
	__content.append("\t\tDisjunction disjunction = Restrictions.disjunction();\r\n");
	__content.append("");for (Property property : entity.getProperties()) {
						String propertyNameToUpperCase = property.getName().toUpperCase();
						if (property.getType().getJavaClassname().equals(String.class.getName())) {
	__content.append("\t\tdisjunction.add(Restrictions.like(FIELD__");
	__content.append(propertyNameToUpperCase.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(", _searchString.trim(), MatchMode.ANYWHERE));\r\n");
	__content.append("");}
					}
	__content.append("\t\tcriteria = criteria.add(disjunction);\r\n");
	__content.append("\t\tcriteria = criteria.setMaxResults(_maxResults);\r\n");
	__content.append("\t\t@SuppressWarnings(\"unchecked\")\r\n");
	__content.append("\t\tList<");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("> entities = (List<");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(">) criteria.list();\r\n");
	__content.append("\t\treturn entities;\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("");}
	__content.append("\t/**\r\n");
	__content.append("\t * Deletes a ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(".\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic void delete(Session session, ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" entity) {\r\n");
	__content.append("\t\tsession.delete(entity);\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("\t/**\r\n");
	__content.append("\t * Counts the number of ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" entities.\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic int count(Session session) {\r\n");
	__content.append("\t\treturn ((Long) session.createQuery(\"select count(*) from ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append("\").uniqueResult()).intValue();\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\t\r\n");
	__content.append("\tprivate static String getField(Class<?> clazz, String fieldName) {\r\n");
	__content.append("\t\ttry {\r\n");
	__content.append("\t\t\treturn clazz.getDeclaredField(fieldName).getName();\r\n");
	__content.append("\t\t} catch (SecurityException e) {\r\n");
	__content.append("\t\t\tthrow new RuntimeException(e.getClass().getSimpleName() + \": \" + e.getMessage());\r\n");
	__content.append("\t\t} catch (NoSuchFieldException e) {\r\n");
	__content.append("\t\t\tthrow new RuntimeException(e.getClass().getSimpleName() + \": \" + e.getMessage());\r\n");
	__content.append("\t\t}\r\n");
	__content.append("\t}\r\n");
	__content.append("}\r\n");
	__content.append("");return __content.toString();
	}
	public String generateEntityBaseClass(String packageName, Entity entity) {
	StringBuilder __content = new StringBuilder();
		String entityName = entity.getName();
		List<Property> constructorProperties = entity.getConstructorProperties();
		String propertyDeclarations = getPropertyDeclarations(entity);
	__content.append("package ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(ENTITY_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(";\r\n");
	__content.append("\r\n");
	__content.append("import java.util.List;\r\n");
	__content.append("\r\n");
	__content.append("import javax.persistence.Entity;\r\n");
	__content.append("import javax.persistence.GeneratedValue;\r\n");
	__content.append("import javax.persistence.GenerationType;\r\n");
	__content.append("import javax.persistence.Id;\r\n");
	__content.append("import javax.persistence.JoinColumn;\r\n");
	__content.append("import javax.persistence.ManyToOne;\r\n");
	__content.append("import javax.persistence.OneToOne;\r\n");
	__content.append("import javax.persistence.Table;\r\n");
	__content.append("import javax.persistence.Temporal;\r\n");
	__content.append("import javax.persistence.TemporalType;\r\n");
	__content.append("import javax.persistence.UniqueConstraint;\r\n");
	__content.append("import javax.persistence.EnumType;\r\n");
	__content.append("import javax.persistence.FetchType;\r\n");
	__content.append("import javax.persistence.Enumerated;\r\n");
	__content.append("import javax.persistence.CascadeType;\r\n");
	__content.append("import javax.persistence.OneToMany;\r\n");
	__content.append("import javax.persistence.ManyToMany;\r\n");
	__content.append("import javax.persistence.Column;\r\n");
	__content.append("\r\n");
	__content.append("import org.hibernate.annotations.GenericGenerator;\r\n");
	__content.append("import org.hibernate.annotations.Parameter;\r\n");
	__content.append("\r\n");
	__content.append("@Entity\r\n");
	__content.append("@Table(name = \"");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("\"\r\n");
	__content.append("");for (Constraint constraint : entity.getConstraints()) {
			if (constraint instanceof UniqueConstraint) {
				UniqueConstraint uniqueConstraint = (UniqueConstraint) constraint;
	__content.append(", uniqueConstraints=@UniqueConstraint(columnNames={");for (Property property : uniqueConstraint.getProperties()) {
					String propertyName = property.getName();
	__content.append("\"");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append("\"");if (!isLast(uniqueConstraint.getProperties(), property)) {
	__content.append(", ");}
				}
	__content.append("})");}
		}
	__content.append(")\r\n");
	__content.append("");if (entity.getComment() != null) {
			String comment = entity.getComment().replace("\t", "");
	__content.append("");
	__content.append(comment.replaceAll("\\r\\n\\z",""));
	__content.append("\r\n");
	__content.append("");}
	__content.append("/*\r\n");
	__content.append(" * This class is generated from the entity \'");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append("\' defined in the HEDL model.\r\n");
	__content.append(" * Note: Any change made to this class will be overridden.\r\n");
	__content.append(" */\r\n");
	__content.append("public class ");
	__content.append(entityName.replaceAll("\\r\\n\\z",""));
	__content.append(" ");if (entity.getSuperType() != null) {
			String superTypeName = entity.getSuperType().getName();
	__content.append("extends # superTypeName # ");}
	__content.append("{\r\n");
	__content.append("\t\r\n");
	__content.append("");if (entity.getSuperType() == null) {
	__content.append("\t@GenericGenerator(name=\"");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("IdGenerator\", strategy=\"org.hibernate.id.MultipleHiLoPerTableGenerator\",\r\n");
	__content.append("\t  parameters = {\r\n");
	__content.append("\t    @Parameter(name=\"table\", value=\"IdentityGenerator\"),\r\n");
	__content.append("\t    @Parameter(name=\"primary_key_column\", value=\"sequence_name\"),\r\n");
	__content.append("\t    @Parameter(name=\"primary_key_value\", value=\"");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("\"),\r\n");
	__content.append("\t    @Parameter(name=\"value_column\", value=\"next_hi_value\"),\r\n");
	__content.append("\t    @Parameter(name=\"primary_key_length\", value=\"100\"),\r\n");
	__content.append("\t    @Parameter(name=\"max_lo\", value=\"1000\")\r\n");
	__content.append("\t  }\r\n");
	__content.append("\t)\r\n");
	__content.append("\t@Id \r\n");
	__content.append("\t@GeneratedValue(strategy=GenerationType.TABLE, generator=\"");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("IdGenerator\")\r\n");
	__content.append("\tprivate int id;\r\n");
	__content.append("\r\n");
	__content.append("");}
	__content.append("\t");
	__content.append(propertyDeclarations.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("\r\n");
	__content.append("\t/**\r\n");
	__content.append("\t * Default constructor. Only used by Hibernate.\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("() {\r\n");
	__content.append("\t\tsuper();\r\n");
	__content.append("\t}\r\n");
	__content.append("\r\n");
	__content.append("");if (!constructorProperties.isEmpty()) {
	__content.append("\t/**\r\n");
	__content.append("\t * Constructor using all read-only and all non-nullable properties.\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic ");
	__content.append(entityName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("(");for (Property property :constructorProperties) {
						String typeClassName = property.getType().getJavaClassname();
						String toFirstLower = toFirstLower(property.getName());
	__content.append("");
	__content.append(typeClassName.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(toFirstLower.replaceAll("\\r\\n\\z",""));
	__content.append("");if (!isLast(constructorProperties, property)) {
	__content.append(", ");}
					}
	__content.append(") {\r\n");
	__content.append("\t\tsuper();\r\n");
	__content.append("");for (Property property :constructorProperties) {
						String toFirstLower = toFirstLower(property.getName());
	__content.append("\t\tthis.");
	__content.append(toFirstLower.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(" = ");
	__content.append(toFirstLower.replaceAll("\\r\\n\\z",""));
	__content.append(";\r\n");
	__content.append("");}
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("");}
			if (entity.getSuperType() == null) {
	__content.append("\t/**\r\n");
	__content.append("\t * Returns the automatically generated id that identifies this entity object.\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic int getId() {\r\n");
	__content.append("\t\treturn id;\r\n");
	__content.append("\t}\r\n");
	__content.append("\r\n");
	__content.append("\t/**\r\n");
	__content.append("\t * The property \'id\' is read-only. \r\n");
	__content.append("\t * This setter is only provided for Hibernate. \r\n");
	__content.append("\t * It must not be used directly.\r\n");
	__content.append("\t */\r\n");
	__content.append("\t@Deprecated\r\n");
	__content.append("\tpublic void setId(int id) {\r\n");
	__content.append("\t\tthis.id = id;\r\n");
	__content.append("\t}\r\n");
	__content.append("\r\n");
	__content.append("");}
			for (Property property : entity.getProperties()) {
				String propertyName = property.getName();
				String toFirstUpper = toFirstUpper(propertyName);
				String typeClassName = property.getTypeClassname();
	__content.append("\t/**\r\n");
	__content.append("\t * Returns the value of property \'");
	__content.append(propertyName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("\'.\r\n");
	__content.append("\t */\r\n");
	__content.append("\tpublic ");
	__content.append(typeClassName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" get");
	__content.append(toFirstUpper.replaceAll("\\r\\n\\z",""));
	__content.append("() {\r\n");
	__content.append("\t\treturn ");
	__content.append(propertyName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(";\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("");if (property.isReadonly()) {
	__content.append("\t/**\r\n");
	__content.append("\t * The property \'");
	__content.append(propertyName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("\' is read-only. \r\n");
	__content.append("\t * This setter is only provided for Hibernate. \r\n");
	__content.append("\t * It must not be used directly.\r\n");
	__content.append("\t */\r\n");
	__content.append("\t@Deprecated\r\n");
	__content.append("");} else {
	__content.append("\t/**\r\n");
	__content.append("\t * Sets the value of property \'");
	__content.append(propertyName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("\'.\r\n");
	__content.append("\t */\r\n");
	__content.append("");}
	__content.append("\tpublic void set");
	__content.append(toFirstUpper.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("(");
	__content.append(typeClassName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(" newValue) {\r\n");
	__content.append("\t\tthis.");
	__content.append(propertyName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t\t"));
	__content.append(" = newValue;\r\n");
	__content.append("\t}\r\n");
	__content.append("\t\r\n");
	__content.append("");}
	__content.append("}\r\n");
	__content.append("");return __content.toString();
	}
	private String getPropertyDeclarations(Entity entity) {
	StringBuilder __content = new StringBuilder();
	__content.append("");for (Property property : entity.getProperties()) {
			String propertyName = property.getName();
			String propertyTypeClassname = property.getTypeClassname();
			String nullable = Boolean.toString(property.isNullable());
			if (property.getType() instanceof JavaType) {
				JavaType javaType = (JavaType) property.getType();
				if (javaType.getJavaClass().equals(java.util.Date.class)) {
	__content.append("@Temporal(TemporalType.TIMESTAMP)\r\n");
	__content.append("");}
			}
			if (property.getType() instanceof org.emftext.language.hedl.Enum) {
	__content.append("@Enumerated(EnumType.STRING)\r\n");
	__content.append("");}
			if (property.getType() instanceof Entity) {
				if (!property.isFromMultiplicity() && !property.isToMultiplicity()) {
	__content.append("@OneToOne(cascade={");if (property.isPersist()) {
	__content.append("CascadeType.PERSIST, ");}
					if (property.isRefresh()) {
	__content.append("CascadeType.REFRESH");}
					if (!property.isPersist() && !property.isRefresh()) {
	__content.append("CascadeType.ALL");}
	__content.append("})\r\n");
	__content.append("@JoinColumn(name=\"");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append("\"");if (property.isReadonly()) {
	__content.append(", updatable=false");}
	__content.append(", nullable=");
	__content.append(nullable.replaceAll("\\r\\n\\z",""));
	__content.append(")\r\n");
	__content.append("");}
				if (property.isFromMultiplicity() && !property.isToMultiplicity()) {
	__content.append("@ManyToOne(cascade={");if (property.isPersist()) {
	__content.append("CascadeType.PERSIST, ");}
					if (property.isRefresh()) {
	__content.append("CascadeType.REFRESH");}
					if (!property.isPersist() && !property.isRefresh()) {
	__content.append("CascadeType.ALL");}
	__content.append("})\r\n");
	__content.append("@JoinColumn(name=\"");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append("\"");if (property.isReadonly()) {
	__content.append(", updatable=false");}
	__content.append(", nullable=");
	__content.append(nullable.replaceAll("\\r\\n\\z",""));
	__content.append(")\r\n");
	__content.append("");}
				if (!property.isFromMultiplicity() && property.isToMultiplicity()) {
	__content.append("@OneToMany(cascade={");if (property.isPersist()) {
	__content.append("CascadeType.PERSIST, ");}
					if (property.isRefresh()) {
	__content.append("CascadeType.REFRESH");}
					if (!property.isPersist() && !property.isRefresh()) {
	__content.append("CascadeType.ALL");}
	__content.append("}");if (property.getMappedBy() != null) {
						String mappedByName = property.getMappedBy().getName();
	__content.append(", mappedBy=\"");
	__content.append(mappedByName.replaceAll("\\r\\n\\z",""));
	__content.append("\"");}
	__content.append(")\r\n");
	__content.append("");}
				if (property.isFromMultiplicity() && property.isToMultiplicity()) {
					String target = property.getType().getJavaClassname();
					String fetchType = property.isEager() ? "EAGER" : "LAZY";
	__content.append("@ManyToMany(targetEntity=");
	__content.append(target.replaceAll("\\r\\n\\z",""));
	__content.append(".class, fetch=FetchType.");
	__content.append(fetchType.replaceAll("\\r\\n\\z",""));
	__content.append(", cascade={");if (property.isPersist()) {
	__content.append("CascadeType.PERSIST, ");}
					if (property.isRefresh()) {
	__content.append("CascadeType.REFRESH");}
					if (!property.isPersist() && !property.isRefresh()) {
	__content.append("CascadeType.ALL");}
	__content.append("})\r\n");
	__content.append("");}
			}
			if (property.getType() == HedlBuiltinTypes.LONGSTRING) {
	__content.append("@Column(length=100000)\r\n");
	__content.append("");}
			if (property.getComment() != null) {
				String comment = property.getComment().replace("\t", "");
	__content.append("");
	__content.append(comment.replaceAll("\\r\\n\\z",""));
	__content.append("\r\n");
	__content.append("");}
	__content.append("private ");
	__content.append(propertyTypeClassname.replaceAll("\\r\\n\\z",""));
	__content.append(" ");
	__content.append(propertyName.replaceAll("\\r\\n\\z",""));
	__content.append(";\r\n");
	__content.append("\r\n");
	__content.append("");}
		return __content.toString();
	}
	public String generateEnum(String packageName, org.emftext.language.hedl.Enum enumeration) {
	StringBuilder __content = new StringBuilder();
		String enumerationName = enumeration.getName();
	__content.append("package ");
	__content.append(packageName.replaceAll("\\r\\n\\z",""));
	__content.append(".");
	__content.append(ENTITY_PACKAGE_NAME.replaceAll("\\r\\n\\z",""));
	__content.append(";\r\n");
	__content.append("\r\n");
	__content.append("");if (enumeration.getComment() != null) {
			String comment = enumeration.getComment().replace("\t", "");
	__content.append("");
	__content.append(comment.replaceAll("\\r\\n\\z",""));
	__content.append("\r\n");
	__content.append("");}
	__content.append("// this class is generated. any change will be overridden.\r\n");
	__content.append("public enum ");
	__content.append(enumerationName.replaceAll("\\r\\n\\z",""));
	__content.append(" {\r\n");
	__content.append("");for (EnumLiteral literal : enumeration.getLiterals()) {
				String literalName = literal.getName();
				if (literal.getComment() != null) {
					String comment = literal.getComment().replace("\t", "");
	__content.append("\t");
	__content.append(comment.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append("\r\n");
	__content.append("\t");}
	__content.append("\t");
	__content.append(literalName.replaceAll("\\r\\n\\z","").replace("\r\n","\r\n\t"));
	__content.append(",\r\n");
	__content.append("\t");}
	__content.append("}\r\n");
	__content.append("");return __content.toString();
	}

	private String toFirstUpper(String name) {
		return name.substring(0,1).toUpperCase() + name.substring(1);
	}

	private String toFirstLower(String name) {
		return name.substring(0,1).toLowerCase() + name.substring(1);
	}

	private <T> boolean isLast(List<T> list, T element) {
		return getLast(list) == element;
	}

	private <T>T getLast(List<T> list) {
		if (list.isEmpty()) {
			return null;
		}
		return list.get(list.size() - 1);
	}

	private List<Property> filter(List<Property> properties, IFilter filter) {
		List<Property> matching = new ArrayList<Property>();
		for (Property property :properties) {
			if (filter.accept(property)) {
				matching.add(property);
			}
		}
		return matching;
	}
}
