package org.emftext.language.hedl.codegen;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.emftext.language.hedl.Entity;
import org.emftext.language.hedl.EntityModel;
import org.emftext.language.hedl.JavaType;
import org.emftext.language.hedl.Property;
import org.emftext.language.hedl.Type;

@SuppressWarnings("all")
public class HEDLGenerator {
  public StringConcatenation generateICommand(final String packageName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// this class is generated. any change will be overridden.");
    _builder.newLine();
    _builder.append("public interface ICommand {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void execute(IDBOperations operations);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generateOngoingShutdownException(final String packageName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// this class is generated. any change will be overridden.");
    _builder.newLine();
    _builder.append("public class OngoingShutdownException extends Exception {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final long serialVersionUID = 997906627613716196L;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generateIDBOperations(final String packageName, final EntityModel entityModel) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// this class is generated. any change will be overridden.");
    _builder.newLine();
    _builder.append("public interface IDBOperations {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Entity> _entities = entityModel.getEntities();
      for(final Entity entity : _entities) {
        EList<Property> _properties = entity.getProperties();
        final Function1<Property,Boolean> _function = new Function1<Property,Boolean>() {
            public Boolean apply(final Property p) {
              boolean _isReadonly = p.isReadonly();
              return ((Boolean)_isReadonly);
            }
          };
        Iterable<Property> _filter = IterableExtensions.<Property>filter(_properties, _function);
        Iterable<Property> readOnlyProperties = _filter;
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("* Creates a new ");
        String _name = entity.getName();
        _builder.append(_name, "	 ");
        _builder.append(" using all read-only properties.");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        String _name_1 = entity.getName();
        _builder.append(_name_1, "	");
        _builder.append(" create");
        String _name_2 = entity.getName();
        _builder.append(_name_2, "	");
        _builder.append("(");
        {
          for(final Property property : readOnlyProperties) {
            Type _type = property.getType();
            String _javaClassname = _type.getJavaClassname();
            _builder.append(_javaClassname, "	");
            _builder.append(" ");
            String _name_3 = property.getName();
            String _firstLower = StringExtensions.toFirstLower(_name_3);
            _builder.append(_firstLower, "	");
            {
              Property _last = IterableExtensions.<Property>last(readOnlyProperties);
              boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_last, property);
              if (_operator_notEquals) {
                _builder.append(", ");
              }
            }
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generateMainDAO(final String packageName, final EntityModel entityModel) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.hibernate.Criteria;");
    _builder.newLine();
    _builder.append("import org.hibernate.HibernateException;");
    _builder.newLine();
    _builder.append("import org.hibernate.SessionFactory;");
    _builder.newLine();
    _builder.append("import org.hibernate.Transaction;");
    _builder.newLine();
    _builder.append("import org.hibernate.cfg.Configuration;");
    _builder.newLine();
    _builder.append("import org.hibernate.classic.Session;");
    _builder.newLine();
    _builder.append("import org.hibernate.criterion.MatchMode;");
    _builder.newLine();
    _builder.append("import org.hibernate.criterion.Order;");
    _builder.newLine();
    _builder.append("import org.hibernate.criterion.Restrictions;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("// this class is generated. any change will be overridden.");
    _builder.newLine();
    _builder.append("public class MainDAO {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private SessionFactory sessionFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public MainDAO() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("configure();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private void configure() throws HibernateException {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Configuration configuration = getConfiguration();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//configuration.setProperty(\"hibernate.show_sql\", \"true\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.sessionFactory = configuration.buildSessionFactory();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Configuration getConfiguration() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Configuration configuration = new Configuration();");
    _builder.newLine();
    {
      EList<Entity> _entities = entityModel.getEntities();
      for(final Entity entity : _entities) {
        _builder.append("\t\t");
        _builder.append("configuration = configuration.addAnnotatedClass(");
        String _name = entity.getName();
        _builder.append(_name, "		");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("return configuration;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void executeInTransaction(ICommand command) throws OngoingShutdownException {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("SessionFactory sessionsLocal = sessionFactory;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// this can happen when the application server is shut down or restarted");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (sessionsLocal == null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new OngoingShutdownException();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Session session = sessionsLocal.openSession();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Transaction tx = null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("tx = session.beginTransaction();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("command.execute(new OperationProvider(session));");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("tx.commit();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (HibernateException he) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (tx != null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("tx.rollback();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw he;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} finally {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("session.close();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private class OperationProvider implements IDBOperations {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("private Session session;");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Entity> _entities_1 = entityModel.getEntities();
      for(final Entity entity_1 : _entities_1) {
        _builder.append("\t\t");
        _builder.append("private ");
        String _name_1 = entity_1.getName();
        _builder.append(_name_1, "		");
        _builder.append("DAO ");
        String _name_2 = entity_1.getName();
        String _firstLower = StringExtensions.toFirstLower(_name_2);
        _builder.append(_firstLower, "		");
        _builder.append("DAO = new ");
        String _name_3 = entity_1.getName();
        _builder.append(_name_3, "		");
        _builder.append("DAO();");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public OperationProvider(Session session) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.session = session;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Entity> _entities_2 = entityModel.getEntities();
      for(final Entity entity_2 : _entities_2) {
        EList<Property> _properties = entity_2.getProperties();
        final Function1<Property,Boolean> _function = new Function1<Property,Boolean>() {
            public Boolean apply(final Property p) {
              boolean _isReadonly = p.isReadonly();
              return ((Boolean)_isReadonly);
            }
          };
        Iterable<Property> _filter = IterableExtensions.<Property>filter(_properties, _function);
        Iterable<Property> readOnlyProperties = _filter;
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t \t ");
        _builder.append("* Create method using all read-only properties.");
        _builder.newLine();
        _builder.append("\t \t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("public ");
        String _name_4 = entity_2.getName();
        _builder.append(_name_4, "		");
        _builder.append(" create");
        String _name_5 = entity_2.getName();
        _builder.append(_name_5, "		");
        _builder.append("(");
        {
          for(final Property property : readOnlyProperties) {
            Type _type = property.getType();
            String _javaClassname = _type.getJavaClassname();
            _builder.append(_javaClassname, "		");
            _builder.append(" ");
            String _name_6 = property.getName();
            String _firstLower_1 = StringExtensions.toFirstLower(_name_6);
            _builder.append(_firstLower_1, "		");
            {
              Property _last = IterableExtensions.<Property>last(readOnlyProperties);
              boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_last, property);
              if (_operator_notEquals) {
                _builder.append(", ");
              }
            }
          }
        }
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("return ");
        String _name_7 = entity_2.getName();
        String _firstLower_2 = StringExtensions.toFirstLower(_name_7);
        _builder.append(_firstLower_2, "			");
        _builder.append("DAO.create");
        String _name_8 = entity_2.getName();
        _builder.append(_name_8, "			");
        _builder.append("(session");
        {
          for(final Property property_1 : readOnlyProperties) {
            _builder.append(", ");
            String _name_9 = property_1.getName();
            String _firstLower_3 = StringExtensions.toFirstLower(_name_9);
            _builder.append(_firstLower_3, "			");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generateEntityDAO(final String packageName, final Entity entity) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.hibernate.classic.Session;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("// this class is generated. any change will be overridden.");
    _builder.newLine();
    _builder.append("public class ");
    String _name = entity.getName();
    _builder.append(_name, "");
    _builder.append("DAO {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    EList<Property> _properties = entity.getProperties();
    final Function1<Property,Boolean> _function = new Function1<Property,Boolean>() {
        public Boolean apply(final Property p) {
          boolean _isReadonly = p.isReadonly();
          return ((Boolean)_isReadonly);
        }
      };
    Iterable<Property> _filter = IterableExtensions.<Property>filter(_properties, _function);
    Iterable<Property> readOnlyProperties = _filter;
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Create method using all read-only properties.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _name_1 = entity.getName();
    _builder.append(_name_1, "	");
    _builder.append(" create");
    String _name_2 = entity.getName();
    _builder.append(_name_2, "	");
    _builder.append("(Session session");
    {
      for(final Property property : readOnlyProperties) {
        _builder.append(", ");
        Type _type = property.getType();
        String _javaClassname = _type.getJavaClassname();
        _builder.append(_javaClassname, "	");
        _builder.append(" ");
        String _name_3 = property.getName();
        String _firstLower = StringExtensions.toFirstLower(_name_3);
        _builder.append(_firstLower, "	");
      }
    }
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _name_4 = entity.getName();
    _builder.append(_name_4, "		");
    _builder.append(" newEntity = new ");
    String _name_5 = entity.getName();
    _builder.append(_name_5, "		");
    _builder.append("(");
    {
      for(final Property property_1 : readOnlyProperties) {
        String _name_6 = property_1.getName();
        String _firstLower_1 = StringExtensions.toFirstLower(_name_6);
        _builder.append(_firstLower_1, "		");
        {
          Property _last = IterableExtensions.<Property>last(readOnlyProperties);
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_last, property_1);
          if (_operator_notEquals) {
            _builder.append(", ");
          }
        }
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("session.persist(newEntity);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return newEntity;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generateEntityBaseClass(final String packageName, final Entity entity) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import javax.persistence.Entity;");
    _builder.newLine();
    _builder.append("import javax.persistence.GeneratedValue;");
    _builder.newLine();
    _builder.append("import javax.persistence.Id;");
    _builder.newLine();
    _builder.append("import javax.persistence.JoinColumn;");
    _builder.newLine();
    _builder.append("import javax.persistence.ManyToOne;");
    _builder.newLine();
    _builder.append("import javax.persistence.OneToOne;");
    _builder.newLine();
    _builder.append("import javax.persistence.Table;");
    _builder.newLine();
    _builder.append("import javax.persistence.Temporal;");
    _builder.newLine();
    _builder.append("import javax.persistence.TemporalType;");
    _builder.newLine();
    _builder.append("import javax.persistence.UniqueConstraint;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.hibernate.annotations.GenericGenerator;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Entity");
    _builder.newLine();
    _builder.append("@Table(name = \"");
    String _name = entity.getName();
    _builder.append(_name, "");
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    _builder.append("// this class is generated. any change will be overridden.");
    _builder.newLine();
    _builder.append("public class ");
    String _name_1 = entity.getName();
    _builder.append(_name_1, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Id");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@GeneratedValue(generator = \"increment\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@GenericGenerator(name = \"increment\", strategy = \"increment\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private int id;");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Property> _properties = entity.getProperties();
      for(final Property property : _properties) {
        {
          Type _type = property.getType();
          if ((_type instanceof JavaType)) {
            Type _type_1 = property.getType();
            JavaType javaType = ((JavaType) _type_1);
            _builder.newLineIfNotEmpty();
            {
              Class _javaClass = javaType.getJavaClass();
              boolean _equals = _javaClass.equals(java.util.Date.class);
              if (_equals) {
                _builder.append("\t");
                _builder.append("@Temporal(TemporalType.TIMESTAMP)");
                _builder.newLine();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("private ");
        Type _type_2 = property.getType();
        String _javaClassname = _type_2.getJavaClassname();
        _builder.append(_javaClassname, "	");
        _builder.append(" ");
        String _name_2 = property.getName();
        _builder.append(_name_2, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Default constructor. Only used by Hibernate.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _name_3 = entity.getName();
    _builder.append(_name_3, "	");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    EList<Property> _properties_1 = entity.getProperties();
    final Function1<Property,Boolean> _function = new Function1<Property,Boolean>() {
        public Boolean apply(final Property p) {
          boolean _isReadonly = p.isReadonly();
          return ((Boolean)_isReadonly);
        }
      };
    Iterable<Property> _filter = IterableExtensions.<Property>filter(_properties_1, _function);
    Iterable<Property> readOnlyProperties = _filter;
    _builder.newLineIfNotEmpty();
    {
      boolean _isEmpty = IterableExtensions.isEmpty(readOnlyProperties);
      boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
      if (_operator_not) {
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(" ");
        _builder.append("* Constructor using all read-only properties.");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        String _name_4 = entity.getName();
        _builder.append(_name_4, "	");
        _builder.append("(");
        {
          for(final Property property_1 : readOnlyProperties) {
            Type _type_3 = property_1.getType();
            String _javaClassname_1 = _type_3.getJavaClassname();
            _builder.append(_javaClassname_1, "	");
            _builder.append(" ");
            String _name_5 = property_1.getName();
            String _firstLower = StringExtensions.toFirstLower(_name_5);
            _builder.append(_firstLower, "	");
            {
              Property _last = IterableExtensions.<Property>last(readOnlyProperties);
              boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_last, property_1);
              if (_operator_notEquals) {
                _builder.append(", ");
              }
            }
          }
        }
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("super();");
        _builder.newLine();
        {
          for(final Property property_2 : readOnlyProperties) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("this.");
            String _name_6 = property_2.getName();
            String _firstLower_1 = StringExtensions.toFirstLower(_name_6);
            _builder.append(_firstLower_1, "		");
            _builder.append(" = ");
            String _name_7 = property_2.getName();
            String _firstLower_2 = StringExtensions.toFirstLower(_name_7);
            _builder.append(_firstLower_2, "		");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public int getId() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return id;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setId(int id) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.id = id;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Property> _properties_2 = entity.getProperties();
      for(final Property property_3 : _properties_2) {
        _builder.append("\t");
        _builder.append("public ");
        Type _type_4 = property_3.getType();
        String _javaClassname_2 = _type_4.getJavaClassname();
        _builder.append(_javaClassname_2, "	");
        _builder.append(" get");
        String _name_8 = property_3.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name_8);
        _builder.append(_firstUpper, "	");
        _builder.append("() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return ");
        String _name_9 = property_3.getName();
        _builder.append(_name_9, "		");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        {
          boolean _isReadonly = property_3.isReadonly();
          if (_isReadonly) {
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* This property is read-only. The setter is only provided for Hibernate.");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("@Deprecated");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("public void set");
        String _name_10 = property_3.getName();
        String _firstUpper_1 = StringExtensions.toFirstUpper(_name_10);
        _builder.append(_firstUpper_1, "	");
        _builder.append("(");
        Type _type_5 = property_3.getType();
        String _javaClassname_3 = _type_5.getJavaClassname();
        _builder.append(_javaClassname_3, "	");
        _builder.append(" newValue) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("this.");
        String _name_11 = property_3.getName();
        _builder.append(_name_11, "		");
        _builder.append(" = newValue;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
