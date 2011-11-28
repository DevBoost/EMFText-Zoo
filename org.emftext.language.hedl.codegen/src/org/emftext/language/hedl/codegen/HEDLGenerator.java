package org.emftext.language.hedl.codegen;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.emftext.language.hedl.Constraint;
import org.emftext.language.hedl.Entity;
import org.emftext.language.hedl.EntityModel;
import org.emftext.language.hedl.Enum;
import org.emftext.language.hedl.EnumLiteral;
import org.emftext.language.hedl.JavaType;
import org.emftext.language.hedl.Property;
import org.emftext.language.hedl.Type;
import org.emftext.language.hedl.UniqueConstraint;
import org.emftext.language.hedl.codegen.HEDLCodegenConstants;
import org.emftext.language.hedl.types.HedlBuiltinTypes;

@SuppressWarnings("all")
public class HEDLGenerator {
  public StringConcatenation generateICommand(final String packageName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(packageName, "");
    _builder.append(".");
    _builder.append(HEDLCodegenConstants.DAO_PACKAGE_NAME, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ");
    _builder.append(packageName, "");
    _builder.append(".");
    _builder.append(HEDLCodegenConstants.CUSTOM_PACKAGE_NAME, "");
    _builder.append(".IDBOperations;");
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
    _builder.append(".");
    _builder.append(HEDLCodegenConstants.DAO_PACKAGE_NAME, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// this class is generated. any change will be overridden.");
    _builder.newLine();
    _builder.append("public class OngoingShutdownException extends RuntimeException {");
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
  
  public StringConcatenation generateIDBOperations(final String packageName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(packageName, "");
    _builder.append(".");
    _builder.append(HEDLCodegenConstants.CUSTOM_PACKAGE_NAME, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ");
    _builder.append(packageName, "");
    _builder.append(".");
    _builder.append(HEDLCodegenConstants.DAO_PACKAGE_NAME, "");
    _builder.append(".IDBOperationsBase;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// this class is only generated once. it can be customized and all changes");
    _builder.newLine();
    _builder.append("// will be preserved.");
    _builder.newLine();
    _builder.append("public interface IDBOperations extends IDBOperationsBase {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generateIDBOperationsBase(final String packageName, final EntityModel entityModel) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(packageName, "");
    _builder.append(".");
    _builder.append(HEDLCodegenConstants.DAO_PACKAGE_NAME, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Entity> _entities = entityModel.getEntities();
      for(final Entity otherEntity : _entities) {
        _builder.append("import ");
        _builder.append(packageName, "");
        _builder.append(".");
        _builder.append(HEDLCodegenConstants.ENTITY_PACKAGE_NAME, "");
        _builder.append(".");
        String _name = otherEntity.getName();
        _builder.append(_name, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    {
      EList<Enum> _enums = entityModel.getEnums();
      for(final Enum otherEnum : _enums) {
        _builder.append("import ");
        _builder.append(packageName, "");
        _builder.append(".");
        _builder.append(HEDLCodegenConstants.ENTITY_PACKAGE_NAME, "");
        _builder.append(".");
        String _name_1 = otherEnum.getName();
        _builder.append(_name_1, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("// this class is generated. any change will be overridden.");
    _builder.newLine();
    _builder.append("public interface IDBOperationsBase {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Entity> _entities_1 = entityModel.getEntities();
      for(final Entity entity : _entities_1) {
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
        EList<Property> _properties_1 = entity.getProperties();
        final Function1<Property,Boolean> _function_1 = new Function1<Property,Boolean>() {
            public Boolean apply(final Property p) {
              boolean _isUnique = p.isUnique();
              return ((Boolean)_isUnique);
            }
          };
        Iterable<Property> _filter_1 = IterableExtensions.<Property>filter(_properties_1, _function_1);
        Iterable<Property> uniqueProperties = _filter_1;
        _builder.newLineIfNotEmpty();
        EList<Property> _properties_2 = entity.getProperties();
        final Function1<Property,Boolean> _function_2 = new Function1<Property,Boolean>() {
            public Boolean apply(final Property p) {
              boolean _operator_and = false;
              Type _type = p.getType();
              if (!(_type instanceof Enum)) {
                _operator_and = false;
              } else {
                boolean _isUnique = p.isUnique();
                boolean _operator_not = BooleanExtensions.operator_not(_isUnique);
                _operator_and = BooleanExtensions.operator_and((_type instanceof Enum), _operator_not);
              }
              return ((Boolean)_operator_and);
            }
          };
        Iterable<Property> _filter_2 = IterableExtensions.<Property>filter(_properties_2, _function_2);
        Iterable<Property> enumProperties = _filter_2;
        _builder.newLineIfNotEmpty();
        EList<Property> _properties_3 = entity.getProperties();
        final Function1<Property,Boolean> _function_3 = new Function1<Property,Boolean>() {
            public Boolean apply(final Property p) {
              boolean _operator_and = false;
              boolean _operator_and_1 = false;
              Type _type = p.getType();
              if (!(_type instanceof Entity)) {
                _operator_and_1 = false;
              } else {
                boolean _isToMultiplicity = p.isToMultiplicity();
                boolean _operator_not = BooleanExtensions.operator_not(_isToMultiplicity);
                _operator_and_1 = BooleanExtensions.operator_and((_type instanceof Entity), _operator_not);
              }
              if (!_operator_and_1) {
                _operator_and = false;
              } else {
                boolean _isUnique = p.isUnique();
                boolean _operator_not_1 = BooleanExtensions.operator_not(_isUnique);
                _operator_and = BooleanExtensions.operator_and(_operator_and_1, _operator_not_1);
              }
              return ((Boolean)_operator_and);
            }
          };
        Iterable<Property> _filter_3 = IterableExtensions.<Property>filter(_properties_3, _function_3);
        Iterable<Property> toOneProperties = _filter_3;
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("* Creates a new ");
        String _name_2 = entity.getName();
        _builder.append(_name_2, "	 ");
        _builder.append(" using all read-only properties.");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        String _name_3 = entity.getName();
        _builder.append(_name_3, "	");
        _builder.append(" create");
        String _name_4 = entity.getName();
        _builder.append(_name_4, "	");
        _builder.append("(");
        {
          for(final Property property : readOnlyProperties) {
            Type _type = property.getType();
            String _javaClassname = _type.getJavaClassname();
            _builder.append(_javaClassname, "	");
            _builder.append(" ");
            String _name_5 = property.getName();
            String _firstLower = StringExtensions.toFirstLower(_name_5);
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
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("* Returns the ");
        String _name_6 = entity.getName();
        _builder.append(_name_6, "	 ");
        _builder.append(" with the given id.");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        String _name_7 = entity.getName();
        _builder.append(_name_7, "	");
        _builder.append(" get");
        String _name_8 = entity.getName();
        _builder.append(_name_8, "	");
        _builder.append("(int id);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.newLine();
        {
          for(final Property property_1 : uniqueProperties) {
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* Returns the ");
            String _name_9 = entity.getName();
            _builder.append(_name_9, "	 ");
            _builder.append(" with the given ");
            String _name_10 = property_1.getName();
            _builder.append(_name_10, "	 ");
            _builder.append(".");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public ");
            String _name_11 = entity.getName();
            _builder.append(_name_11, "	");
            _builder.append(" get");
            String _name_12 = entity.getName();
            _builder.append(_name_12, "	");
            _builder.append("By");
            String _name_13 = property_1.getName();
            String _firstUpper = StringExtensions.toFirstUpper(_name_13);
            _builder.append(_firstUpper, "	");
            _builder.append("(");
            Type _type_1 = property_1.getType();
            String _javaClassname_1 = _type_1.getJavaClassname();
            _builder.append(_javaClassname_1, "	");
            _builder.append(" ");
            String _name_14 = property_1.getName();
            _builder.append(_name_14, "	");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.newLine();
          }
        }
        {
          for(final Property property_2 : toOneProperties) {
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* Returns the ");
            String _name_15 = entity.getName();
            _builder.append(_name_15, "	 ");
            _builder.append("s with the given ");
            String _name_16 = property_2.getName();
            _builder.append(_name_16, "	 ");
            _builder.append(".");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public List<");
            String _name_17 = entity.getName();
            _builder.append(_name_17, "	");
            _builder.append("> get");
            String _name_18 = entity.getName();
            _builder.append(_name_18, "	");
            _builder.append("sBy");
            String _name_19 = property_2.getName();
            String _firstUpper_1 = StringExtensions.toFirstUpper(_name_19);
            _builder.append(_firstUpper_1, "	");
            _builder.append("(");
            Type _type_2 = property_2.getType();
            String _javaClassname_2 = _type_2.getJavaClassname();
            _builder.append(_javaClassname_2, "	");
            _builder.append(" ");
            String _name_20 = property_2.getName();
            _builder.append(_name_20, "	");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.newLine();
          }
        }
        {
          EList<Constraint> _constraints = entity.getConstraints();
          for(final Constraint constraint : _constraints) {
            {
              if ((constraint instanceof UniqueConstraint)) {
                _builder.append("\t");
                UniqueConstraint uniqueConstraint = ((UniqueConstraint) constraint);
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("/**");
                _builder.newLine();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* Returns the ");
                String _name_21 = entity.getName();
                _builder.append(_name_21, "	 ");
                _builder.append(" with the given properties.");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("*/");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("public ");
                String _name_22 = entity.getName();
                _builder.append(_name_22, "	");
                _builder.append(" get");
                String _name_23 = entity.getName();
                _builder.append(_name_23, "	");
                _builder.append("By");
                {
                  EList<Property> _properties_4 = uniqueConstraint.getProperties();
                  for(final Property property_3 : _properties_4) {
                    String _name_24 = property_3.getName();
                    String _firstUpper_2 = StringExtensions.toFirstUpper(_name_24);
                    _builder.append(_firstUpper_2, "	");
                  }
                }
                _builder.append("(");
                {
                  EList<Property> _properties_5 = uniqueConstraint.getProperties();
                  for(final Property property_4 : _properties_5) {
                    Type _type_3 = property_4.getType();
                    String _javaClassname_3 = _type_3.getJavaClassname();
                    _builder.append(_javaClassname_3, "	");
                    _builder.append(" ");
                    String _name_25 = property_4.getName();
                    _builder.append(_name_25, "	");
                    {
                      EList<Property> _properties_6 = uniqueConstraint.getProperties();
                      Property _last_1 = IterableExtensions.<Property>last(_properties_6);
                      boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_last_1, property_4);
                      if (_operator_notEquals_1) {
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
          }
        }
        {
          for(final Property property_5 : enumProperties) {
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* Returns all ");
            String _name_26 = entity.getName();
            _builder.append(_name_26, "	 ");
            _builder.append("s with the given ");
            String _name_27 = property_5.getName();
            _builder.append(_name_27, "	 ");
            _builder.append(".");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public List<");
            String _name_28 = entity.getName();
            _builder.append(_name_28, "	");
            _builder.append("> get");
            String _name_29 = entity.getName();
            _builder.append(_name_29, "	");
            _builder.append("sBy");
            String _name_30 = property_5.getName();
            String _firstUpper_3 = StringExtensions.toFirstUpper(_name_30);
            _builder.append(_firstUpper_3, "	");
            _builder.append("(");
            Type _type_4 = property_5.getType();
            String _javaClassname_4 = _type_4.getJavaClassname();
            _builder.append(_javaClassname_4, "	");
            _builder.append(" ");
            String _name_31 = property_5.getName();
            _builder.append(_name_31, "	");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("* Returns all entities of type ");
        String _name_32 = entity.getName();
        _builder.append(_name_32, "	 ");
        _builder.append(".");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public List<");
        String _name_33 = entity.getName();
        _builder.append(_name_33, "	");
        _builder.append("> getAll");
        String _name_34 = entity.getName();
        _builder.append(_name_34, "	");
        _builder.append("s();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("* Searches for entities of type ");
        String _name_35 = entity.getName();
        _builder.append(_name_35, "	 ");
        _builder.append(".");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public List<");
        String _name_36 = entity.getName();
        _builder.append(_name_36, "	");
        _builder.append("> search");
        String _name_37 = entity.getName();
        _builder.append(_name_37, "	");
        _builder.append("s(String _searchString, int _maxResults);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        EList<Property> _properties_7 = entity.getProperties();
        final Function1<Property,Boolean> _function_4 = new Function1<Property,Boolean>() {
            public Boolean apply(final Property p) {
              boolean _isToOneReference = p.isToOneReference();
              return ((Boolean)_isToOneReference);
            }
          };
        Iterable<Property> _filter_4 = IterableExtensions.<Property>filter(_properties_7, _function_4);
        Iterable<Property> toOneReferences = _filter_4;
        _builder.newLineIfNotEmpty();
        {
          for(final Property toOneReference : toOneReferences) {
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* Searches for entities of type ");
            String _name_38 = entity.getName();
            _builder.append(_name_38, "	 ");
            _builder.append(".");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public List<");
            String _name_39 = entity.getName();
            _builder.append(_name_39, "	");
            _builder.append("> search");
            String _name_40 = entity.getName();
            _builder.append(_name_40, "	");
            _builder.append("With");
            String _name_41 = toOneReference.getName();
            String _firstUpper_4 = StringExtensions.toFirstUpper(_name_41);
            _builder.append(_firstUpper_4, "	");
            _builder.append("(final ");
            String _typeClassname = toOneReference.getTypeClassname();
            _builder.append(_typeClassname, "	");
            _builder.append(" ");
            String _name_42 = toOneReference.getName();
            _builder.append(_name_42, "	");
            _builder.append(", String _searchString, int _maxResults);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("* Deletes a ");
        String _name_43 = entity.getName();
        _builder.append(_name_43, "	 ");
        _builder.append(".");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void delete(");
        String _name_44 = entity.getName();
        _builder.append(_name_44, "	");
        _builder.append(" entity);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("* Counts the number of ");
        String _name_45 = entity.getName();
        _builder.append(_name_45, "	 ");
        _builder.append(" entities.");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public int count");
        String _name_46 = entity.getName();
        String _firstUpper_5 = StringExtensions.toFirstUpper(_name_46);
        _builder.append(_firstUpper_5, "	");
        _builder.append("s();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generateMainDAO(final String packageName, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(packageName, "");
    _builder.append(".");
    _builder.append(HEDLCodegenConstants.CUSTOM_PACKAGE_NAME, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ");
    _builder.append(packageName, "");
    _builder.append(".");
    _builder.append(HEDLCodegenConstants.DAO_PACKAGE_NAME, "");
    _builder.append(".");
    _builder.append(className, "");
    _builder.append("Base;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// this class is only generated once. it can be customized and all changes");
    _builder.newLine();
    _builder.append("// will be preserved.");
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(className, "");
    _builder.append(" extends ");
    _builder.append(className, "");
    _builder.append("Base {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void handleException(Exception e, boolean retry) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("e.printStackTrace();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generateMainDAOBase(final String packageName, final String className, final EntityModel entityModel) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(packageName, "");
    _builder.append(".");
    _builder.append(HEDLCodegenConstants.DAO_PACKAGE_NAME, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.logging.Level;");
    _builder.newLine();
    _builder.append("import java.util.logging.Logger;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.hibernate.TransactionException;");
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
    _builder.newLine();
    _builder.append("import org.hibernate.tool.hbm2ddl.SchemaExport;");
    _builder.newLine();
    _builder.append("import org.hibernate.tool.hbm2ddl.SchemaUpdate;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import ");
    _builder.append(packageName, "");
    _builder.append(".");
    _builder.append(HEDLCodegenConstants.CUSTOM_PACKAGE_NAME, "");
    _builder.append(".OperationProvider;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(packageName, "");
    _builder.append(".");
    _builder.append(HEDLCodegenConstants.CUSTOM_PACKAGE_NAME, "");
    _builder.append(".IDBOperations;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<Entity> _entities = entityModel.getEntities();
      for(final Entity otherEntity : _entities) {
        _builder.append("import ");
        _builder.append(packageName, "");
        _builder.append(".");
        _builder.append(HEDLCodegenConstants.ENTITY_PACKAGE_NAME, "");
        _builder.append(".");
        String _name = otherEntity.getName();
        _builder.append(_name, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    {
      EList<Enum> _enums = entityModel.getEnums();
      for(final Enum otherEnum : _enums) {
        _builder.append("import ");
        _builder.append(packageName, "");
        _builder.append(".");
        _builder.append(HEDLCodegenConstants.ENTITY_PACKAGE_NAME, "");
        _builder.append(".");
        String _name_1 = otherEnum.getName();
        _builder.append(_name_1, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("// this class is generated. any change will be overridden.");
    _builder.newLine();
    _builder.append("public abstract class ");
    _builder.append(className, "");
    _builder.append(" implements IDBOperationsBase {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private SessionFactory sessionFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    _builder.append(className, "	");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
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
      EList<Entity> _entities_1 = entityModel.getEntities();
      for(final Entity entity : _entities_1) {
        _builder.append("\t\t");
        _builder.append("configuration = configuration.addAnnotatedClass(");
        String _name_2 = entity.getName();
        _builder.append(_name_2, "		");
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
    _builder.append("public void createSchema() throws HibernateException {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("SchemaExport schemaExport = new SchemaExport(getConfiguration());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("schemaExport.setFormat(true);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("schemaExport.create(false, false);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void updateSchema() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("SchemaUpdate update = new SchemaUpdate(getConfiguration());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("update.execute(true, true);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("List<?> exceptions = update.getExceptions();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (Object object : exceptions) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("System.err.println(\"Exception while updating schema \" + object);");
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
    _builder.append("public void executeInTransaction(ICommand command) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("executeInTransaction(command, true);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private void executeInTransaction(ICommand command, boolean retry) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("boolean successful = false;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("boolean closed = false;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Session session = sessionFactory.openSession();");
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
    _builder.append("\t\t\t");
    _builder.append("successful = true;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (Exception e) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("handleException(e, retry);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (tx != null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("tx.rollback();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("} catch (TransactionException te) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("handleException(te, retry);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} finally {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("session.close();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("closed = true;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} catch (HibernateException he) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("handleException(he, retry);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if ((!successful || !closed) && retry) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// retry once");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("executeInTransaction(command, false);");
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
    _builder.append("public abstract void handleException(Exception e, boolean retry);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void tearDown() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sessionFactory.close();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Entity> _entities_2 = entityModel.getEntities();
      for(final Entity entity_1 : _entities_2) {
        EList<Property> _properties = entity_1.getProperties();
        final Function1<Property,Boolean> _function = new Function1<Property,Boolean>() {
            public Boolean apply(final Property p) {
              boolean _isReadonly = p.isReadonly();
              return ((Boolean)_isReadonly);
            }
          };
        Iterable<Property> _filter = IterableExtensions.<Property>filter(_properties, _function);
        Iterable<Property> readOnlyProperties = _filter;
        _builder.newLineIfNotEmpty();
        EList<Property> _properties_1 = entity_1.getProperties();
        final Function1<Property,Boolean> _function_1 = new Function1<Property,Boolean>() {
            public Boolean apply(final Property p) {
              boolean _isUnique = p.isUnique();
              return ((Boolean)_isUnique);
            }
          };
        Iterable<Property> _filter_1 = IterableExtensions.<Property>filter(_properties_1, _function_1);
        Iterable<Property> uniqueProperties = _filter_1;
        _builder.newLineIfNotEmpty();
        EList<Property> _properties_2 = entity_1.getProperties();
        final Function1<Property,Boolean> _function_2 = new Function1<Property,Boolean>() {
            public Boolean apply(final Property p) {
              boolean _operator_and = false;
              Type _type = p.getType();
              if (!(_type instanceof Enum)) {
                _operator_and = false;
              } else {
                boolean _isUnique = p.isUnique();
                boolean _operator_not = BooleanExtensions.operator_not(_isUnique);
                _operator_and = BooleanExtensions.operator_and((_type instanceof Enum), _operator_not);
              }
              return ((Boolean)_operator_and);
            }
          };
        Iterable<Property> _filter_2 = IterableExtensions.<Property>filter(_properties_2, _function_2);
        Iterable<Property> enumProperties = _filter_2;
        _builder.newLineIfNotEmpty();
        EList<Property> _properties_3 = entity_1.getProperties();
        final Function1<Property,Boolean> _function_3 = new Function1<Property,Boolean>() {
            public Boolean apply(final Property p) {
              boolean _operator_and = false;
              boolean _operator_and_1 = false;
              Type _type = p.getType();
              if (!(_type instanceof Entity)) {
                _operator_and_1 = false;
              } else {
                boolean _isToMultiplicity = p.isToMultiplicity();
                boolean _operator_not = BooleanExtensions.operator_not(_isToMultiplicity);
                _operator_and_1 = BooleanExtensions.operator_and((_type instanceof Entity), _operator_not);
              }
              if (!_operator_and_1) {
                _operator_and = false;
              } else {
                boolean _isUnique = p.isUnique();
                boolean _operator_not_1 = BooleanExtensions.operator_not(_isUnique);
                _operator_and = BooleanExtensions.operator_and(_operator_and_1, _operator_not_1);
              }
              return ((Boolean)_operator_and);
            }
          };
        Iterable<Property> _filter_3 = IterableExtensions.<Property>filter(_properties_3, _function_3);
        Iterable<Property> toOneProperties = _filter_3;
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("* Creates a new ");
        String _name_3 = entity_1.getName();
        _builder.append(_name_3, "	 ");
        _builder.append(" using all read-only properties.");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        String _name_4 = entity_1.getName();
        _builder.append(_name_4, "	");
        _builder.append(" create");
        String _name_5 = entity_1.getName();
        _builder.append(_name_5, "	");
        _builder.append("(");
        {
          for(final Property property : readOnlyProperties) {
            _builder.append("final ");
            Type _type = property.getType();
            String _javaClassname = _type.getJavaClassname();
            _builder.append(_javaClassname, "	");
            _builder.append(" ");
            String _name_6 = property.getName();
            String _firstLower = StringExtensions.toFirstLower(_name_6);
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
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("final ");
        String _name_7 = entity_1.getName();
        _builder.append(_name_7, "		");
        _builder.append("[] entity = new ");
        String _name_8 = entity_1.getName();
        _builder.append(_name_8, "		");
        _builder.append("[1];");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("executeInTransaction(new ICommand() {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("public void execute(IDBOperations operations) {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("entity[0] = operations.create");
        String _name_9 = entity_1.getName();
        _builder.append(_name_9, "				");
        _builder.append("(");
        {
          for(final Property property_1 : readOnlyProperties) {
            String _name_10 = property_1.getName();
            String _firstLower_1 = StringExtensions.toFirstLower(_name_10);
            _builder.append(_firstLower_1, "				");
            {
              Property _last_1 = IterableExtensions.<Property>last(readOnlyProperties);
              boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_last_1, property_1);
              if (_operator_notEquals_1) {
                _builder.append(", ");
              }
            }
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("});");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return entity[0];");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("* Returns the ");
        String _name_11 = entity_1.getName();
        _builder.append(_name_11, "	 ");
        _builder.append(" with the given id.");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        String _name_12 = entity_1.getName();
        _builder.append(_name_12, "	");
        _builder.append(" get");
        String _name_13 = entity_1.getName();
        _builder.append(_name_13, "	");
        _builder.append("(final int id) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("final ");
        String _name_14 = entity_1.getName();
        _builder.append(_name_14, "		");
        _builder.append("[] entity = new ");
        String _name_15 = entity_1.getName();
        _builder.append(_name_15, "		");
        _builder.append("[1];");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("executeInTransaction(new ICommand() {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("public void execute(IDBOperations operations) {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("entity[0] = operations.get");
        String _name_16 = entity_1.getName();
        _builder.append(_name_16, "				");
        _builder.append("(id);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("});");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return entity[0];");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        {
          for(final Property property_2 : uniqueProperties) {
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* Returns the ");
            String _name_17 = entity_1.getName();
            _builder.append(_name_17, "	 ");
            _builder.append(" with the given ");
            String _name_18 = property_2.getName();
            _builder.append(_name_18, "	 ");
            _builder.append(".");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public ");
            String _name_19 = entity_1.getName();
            _builder.append(_name_19, "	");
            _builder.append(" get");
            String _name_20 = entity_1.getName();
            _builder.append(_name_20, "	");
            _builder.append("By");
            String _name_21 = property_2.getName();
            String _firstUpper = StringExtensions.toFirstUpper(_name_21);
            _builder.append(_firstUpper, "	");
            _builder.append("(final ");
            Type _type_1 = property_2.getType();
            String _javaClassname_1 = _type_1.getJavaClassname();
            _builder.append(_javaClassname_1, "	");
            _builder.append(" ");
            String _name_22 = property_2.getName();
            _builder.append(_name_22, "	");
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("final ");
            String _name_23 = entity_1.getName();
            _builder.append(_name_23, "		");
            _builder.append("[] entity = new ");
            String _name_24 = entity_1.getName();
            _builder.append(_name_24, "		");
            _builder.append("[1];");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("executeInTransaction(new ICommand() {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("public void execute(IDBOperations operations) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("entity[0] = operations.get");
            String _name_25 = entity_1.getName();
            _builder.append(_name_25, "				");
            _builder.append("By");
            String _name_26 = property_2.getName();
            String _firstUpper_1 = StringExtensions.toFirstUpper(_name_26);
            _builder.append(_firstUpper_1, "				");
            _builder.append("(");
            String _name_27 = property_2.getName();
            _builder.append(_name_27, "				");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("});");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return entity[0];");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
          }
        }
        {
          for(final Property property_3 : toOneProperties) {
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* Returns the ");
            String _name_28 = entity_1.getName();
            _builder.append(_name_28, "	 ");
            _builder.append("s with the given ");
            String _name_29 = property_3.getName();
            _builder.append(_name_29, "	 ");
            _builder.append(".");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public List<");
            String _name_30 = entity_1.getName();
            _builder.append(_name_30, "	");
            _builder.append("> get");
            String _name_31 = entity_1.getName();
            _builder.append(_name_31, "	");
            _builder.append("sBy");
            String _name_32 = property_3.getName();
            String _firstUpper_2 = StringExtensions.toFirstUpper(_name_32);
            _builder.append(_firstUpper_2, "	");
            _builder.append("(final ");
            Type _type_2 = property_3.getType();
            String _javaClassname_2 = _type_2.getJavaClassname();
            _builder.append(_javaClassname_2, "	");
            _builder.append(" ");
            String _name_33 = property_3.getName();
            _builder.append(_name_33, "	");
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("final List<");
            String _name_34 = entity_1.getName();
            _builder.append(_name_34, "		");
            _builder.append("> entities = new ArrayList<");
            String _name_35 = entity_1.getName();
            _builder.append(_name_35, "		");
            _builder.append(">();");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("executeInTransaction(new ICommand() {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("public void execute(IDBOperations operations) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("entities.addAll(operations.get");
            String _name_36 = entity_1.getName();
            _builder.append(_name_36, "				");
            _builder.append("sBy");
            String _name_37 = property_3.getName();
            String _firstUpper_3 = StringExtensions.toFirstUpper(_name_37);
            _builder.append(_firstUpper_3, "				");
            _builder.append("(");
            String _name_38 = property_3.getName();
            _builder.append(_name_38, "				");
            _builder.append("));");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("});");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return entities;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
          }
        }
        {
          for(final Property property_4 : enumProperties) {
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* Returns all ");
            String _name_39 = entity_1.getName();
            _builder.append(_name_39, "	 ");
            _builder.append("s with the given ");
            String _name_40 = property_4.getName();
            _builder.append(_name_40, "	 ");
            _builder.append(".");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public List<");
            String _name_41 = entity_1.getName();
            _builder.append(_name_41, "	");
            _builder.append("> get");
            String _name_42 = entity_1.getName();
            _builder.append(_name_42, "	");
            _builder.append("sBy");
            String _name_43 = property_4.getName();
            String _firstUpper_4 = StringExtensions.toFirstUpper(_name_43);
            _builder.append(_firstUpper_4, "	");
            _builder.append("(final ");
            Type _type_3 = property_4.getType();
            String _javaClassname_3 = _type_3.getJavaClassname();
            _builder.append(_javaClassname_3, "	");
            _builder.append(" ");
            String _name_44 = property_4.getName();
            _builder.append(_name_44, "	");
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("final List<");
            String _name_45 = entity_1.getName();
            _builder.append(_name_45, "		");
            _builder.append("> entities = new ArrayList<");
            String _name_46 = entity_1.getName();
            _builder.append(_name_46, "		");
            _builder.append(">();");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("executeInTransaction(new ICommand() {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("public void execute(IDBOperations operations) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("entities.addAll(operations.get");
            String _name_47 = entity_1.getName();
            _builder.append(_name_47, "				");
            _builder.append("sBy");
            String _name_48 = property_4.getName();
            String _firstUpper_5 = StringExtensions.toFirstUpper(_name_48);
            _builder.append(_firstUpper_5, "				");
            _builder.append("(");
            String _name_49 = property_4.getName();
            _builder.append(_name_49, "				");
            _builder.append("));");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("});");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return entities;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
          }
        }
        {
          EList<Constraint> _constraints = entity_1.getConstraints();
          for(final Constraint constraint : _constraints) {
            {
              if ((constraint instanceof UniqueConstraint)) {
                _builder.append("\t");
                UniqueConstraint uniqueConstraint = ((UniqueConstraint) constraint);
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("/**");
                _builder.newLine();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* Returns the ");
                String _name_50 = entity_1.getName();
                _builder.append(_name_50, "	 ");
                _builder.append(" with the given properties.");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("*/");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("public ");
                String _name_51 = entity_1.getName();
                _builder.append(_name_51, "	");
                _builder.append(" get");
                String _name_52 = entity_1.getName();
                _builder.append(_name_52, "	");
                _builder.append("By");
                {
                  EList<Property> _properties_4 = uniqueConstraint.getProperties();
                  for(final Property property_5 : _properties_4) {
                    String _name_53 = property_5.getName();
                    String _firstUpper_6 = StringExtensions.toFirstUpper(_name_53);
                    _builder.append(_firstUpper_6, "	");
                  }
                }
                _builder.append("(");
                {
                  EList<Property> _properties_5 = uniqueConstraint.getProperties();
                  for(final Property property_6 : _properties_5) {
                    _builder.append("final ");
                    Type _type_4 = property_6.getType();
                    String _javaClassname_4 = _type_4.getJavaClassname();
                    _builder.append(_javaClassname_4, "	");
                    _builder.append(" ");
                    String _name_54 = property_6.getName();
                    _builder.append(_name_54, "	");
                    {
                      EList<Property> _properties_6 = uniqueConstraint.getProperties();
                      Property _last_2 = IterableExtensions.<Property>last(_properties_6);
                      boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(_last_2, property_6);
                      if (_operator_notEquals_2) {
                        _builder.append(", ");
                      }
                    }
                  }
                }
                _builder.append(") {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("final ");
                String _name_55 = entity_1.getName();
                _builder.append(_name_55, "		");
                _builder.append("[] entity = new ");
                String _name_56 = entity_1.getName();
                _builder.append(_name_56, "		");
                _builder.append("[1];");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("executeInTransaction(new ICommand() {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("public void execute(IDBOperations operations) {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t\t");
                _builder.append("entity[0] = operations.get");
                String _name_57 = entity_1.getName();
                _builder.append(_name_57, "				");
                _builder.append("By");
                {
                  EList<Property> _properties_7 = uniqueConstraint.getProperties();
                  for(final Property property_7 : _properties_7) {
                    String _name_58 = property_7.getName();
                    String _firstUpper_7 = StringExtensions.toFirstUpper(_name_58);
                    _builder.append(_firstUpper_7, "				");
                  }
                }
                _builder.append("(");
                {
                  EList<Property> _properties_8 = uniqueConstraint.getProperties();
                  for(final Property property_8 : _properties_8) {
                    String _name_59 = property_8.getName();
                    _builder.append(_name_59, "				");
                    {
                      EList<Property> _properties_9 = uniqueConstraint.getProperties();
                      Property _last_3 = IterableExtensions.<Property>last(_properties_9);
                      boolean _operator_notEquals_3 = ObjectExtensions.operator_notEquals(_last_3, property_8);
                      if (_operator_notEquals_3) {
                        _builder.append(", ");
                      }
                    }
                  }
                }
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("});");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("return entity[0];");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.newLine();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("* Returns all entities of type ");
        String _name_60 = entity_1.getName();
        _builder.append(_name_60, "	 ");
        _builder.append(".");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public List<");
        String _name_61 = entity_1.getName();
        _builder.append(_name_61, "	");
        _builder.append("> getAll");
        String _name_62 = entity_1.getName();
        _builder.append(_name_62, "	");
        _builder.append("s() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("final List<");
        String _name_63 = entity_1.getName();
        _builder.append(_name_63, "		");
        _builder.append("> entities = new ArrayList<");
        String _name_64 = entity_1.getName();
        _builder.append(_name_64, "		");
        _builder.append(">();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("executeInTransaction(new ICommand() {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("public void execute(IDBOperations operations) {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("entities.addAll(operations.getAll");
        String _name_65 = entity_1.getName();
        _builder.append(_name_65, "				");
        _builder.append("s());");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("});");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return entities;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("* Searches for entities of type ");
        String _name_66 = entity_1.getName();
        _builder.append(_name_66, "	 ");
        _builder.append(".");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public List<");
        String _name_67 = entity_1.getName();
        _builder.append(_name_67, "	");
        _builder.append("> search");
        String _name_68 = entity_1.getName();
        _builder.append(_name_68, "	");
        _builder.append("s(final String _searchString, final int _maxResults) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("final List<");
        String _name_69 = entity_1.getName();
        _builder.append(_name_69, "		");
        _builder.append("> entities = new ArrayList<");
        String _name_70 = entity_1.getName();
        _builder.append(_name_70, "		");
        _builder.append(">();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("executeInTransaction(new ICommand() {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("public void execute(IDBOperations operations) {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("entities.addAll(operations.search");
        String _name_71 = entity_1.getName();
        _builder.append(_name_71, "				");
        _builder.append("s(_searchString, _maxResults));");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("});");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return entities;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        EList<Property> _properties_10 = entity_1.getProperties();
        final Function1<Property,Boolean> _function_4 = new Function1<Property,Boolean>() {
            public Boolean apply(final Property p) {
              boolean _isToOneReference = p.isToOneReference();
              return ((Boolean)_isToOneReference);
            }
          };
        Iterable<Property> _filter_4 = IterableExtensions.<Property>filter(_properties_10, _function_4);
        Iterable<Property> toOneReferences = _filter_4;
        _builder.newLineIfNotEmpty();
        {
          for(final Property toOneReference : toOneReferences) {
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* Searches for entities of type ");
            String _name_72 = entity_1.getName();
            _builder.append(_name_72, "	 ");
            _builder.append(".");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public List<");
            String _name_73 = entity_1.getName();
            _builder.append(_name_73, "	");
            _builder.append("> search");
            String _name_74 = entity_1.getName();
            _builder.append(_name_74, "	");
            _builder.append("With");
            String _name_75 = toOneReference.getName();
            String _firstUpper_8 = StringExtensions.toFirstUpper(_name_75);
            _builder.append(_firstUpper_8, "	");
            _builder.append("(final ");
            String _typeClassname = toOneReference.getTypeClassname();
            _builder.append(_typeClassname, "	");
            _builder.append(" ");
            String _name_76 = toOneReference.getName();
            _builder.append(_name_76, "	");
            _builder.append(", final String _searchString, final int _maxResults) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("final List<");
            String _name_77 = entity_1.getName();
            _builder.append(_name_77, "		");
            _builder.append("> entities = new ArrayList<");
            String _name_78 = entity_1.getName();
            _builder.append(_name_78, "		");
            _builder.append(">();");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("executeInTransaction(new ICommand() {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("public void execute(IDBOperations operations) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("entities.addAll(operations.search");
            String _name_79 = entity_1.getName();
            _builder.append(_name_79, "				");
            _builder.append("With");
            String _name_80 = toOneReference.getName();
            String _firstUpper_9 = StringExtensions.toFirstUpper(_name_80);
            _builder.append(_firstUpper_9, "				");
            _builder.append("(");
            String _name_81 = toOneReference.getName();
            _builder.append(_name_81, "				");
            _builder.append(", _searchString, _maxResults));");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("});");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return entities;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("* Deletes a ");
        String _name_82 = entity_1.getName();
        _builder.append(_name_82, "	 ");
        _builder.append(".");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void delete(final ");
        String _name_83 = entity_1.getName();
        _builder.append(_name_83, "	");
        _builder.append(" entity) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("executeInTransaction(new ICommand() {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("public void execute(IDBOperations operations) {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("operations.delete(entity);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("});");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("* Counts the number of ");
        String _name_84 = entity_1.getName();
        _builder.append(_name_84, "	 ");
        _builder.append(" entities.");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public int count");
        String _name_85 = entity_1.getName();
        String _firstUpper_10 = StringExtensions.toFirstUpper(_name_85);
        _builder.append(_firstUpper_10, "	");
        _builder.append("s() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("final int[] count = new int[1];");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("executeInTransaction(new ICommand() {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("public void execute(IDBOperations operations) {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("count[0] = operations.count");
        String _name_86 = entity_1.getName();
        String _firstUpper_11 = StringExtensions.toFirstUpper(_name_86);
        _builder.append(_firstUpper_11, "				");
        _builder.append("s();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("});");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return count[0];");
        _builder.newLine();
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
  
  public StringConcatenation generateOperationProvider(final String packageName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(packageName, "");
    _builder.append(".");
    _builder.append(HEDLCodegenConstants.CUSTOM_PACKAGE_NAME, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.hibernate.classic.Session;");
    _builder.newLine();
    _builder.append("import ");
    _builder.append(packageName, "");
    _builder.append(".");
    _builder.append(HEDLCodegenConstants.DAO_PACKAGE_NAME, "");
    _builder.append(".OperationProviderBase;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// this class is only generated once. it can be customized and all changes");
    _builder.newLine();
    _builder.append("// will be preserved.");
    _builder.newLine();
    _builder.append("public class OperationProvider extends OperationProviderBase implements IDBOperations {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public OperationProvider(Session session) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(session);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generateOperationProviderBase(final String packageName, final EntityModel entityModel) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(packageName, "");
    _builder.append(".");
    _builder.append(HEDLCodegenConstants.DAO_PACKAGE_NAME, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
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
    _builder.append("import org.hibernate.metadata.ClassMetadata;");
    _builder.newLine();
    _builder.append("import org.hibernate.persister.entity.AbstractEntityPersister;");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Entity> _entities = entityModel.getEntities();
      for(final Entity otherEntity : _entities) {
        _builder.append("import ");
        _builder.append(packageName, "");
        _builder.append(".");
        _builder.append(HEDLCodegenConstants.ENTITY_PACKAGE_NAME, "");
        _builder.append(".");
        String _name = otherEntity.getName();
        _builder.append(_name, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Enum> _enums = entityModel.getEnums();
      for(final Enum otherEnum : _enums) {
        _builder.append("import ");
        _builder.append(packageName, "");
        _builder.append(".");
        _builder.append(HEDLCodegenConstants.ENTITY_PACKAGE_NAME, "");
        _builder.append(".");
        String _name_1 = otherEnum.getName();
        _builder.append(_name_1, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* This class provides all default operations that are derived from the HEDL entity model.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Note: This class is generated. Any change will be overridden.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public abstract class OperationProviderBase implements IDBOperationsBase {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Session session;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Entity> _entities_1 = entityModel.getEntities();
      for(final Entity entity : _entities_1) {
        _builder.append("\t");
        _builder.append("private ");
        String _name_2 = entity.getName();
        _builder.append(_name_2, "	");
        _builder.append("DAO ");
        String _name_3 = entity.getName();
        String _firstLower = StringExtensions.toFirstLower(_name_3);
        _builder.append(_firstLower, "	");
        _builder.append("DAO = new ");
        String _name_4 = entity.getName();
        _builder.append(_name_4, "	");
        _builder.append("DAO();");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public OperationProviderBase(Session session) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.session = session;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Session getSession() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return session;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Entity> _entities_2 = entityModel.getEntities();
      for(final Entity entity_1 : _entities_2) {
        EList<Property> _properties = entity_1.getProperties();
        final Function1<Property,Boolean> _function = new Function1<Property,Boolean>() {
            public Boolean apply(final Property p) {
              boolean _isReadonly = p.isReadonly();
              return ((Boolean)_isReadonly);
            }
          };
        Iterable<Property> _filter = IterableExtensions.<Property>filter(_properties, _function);
        Iterable<Property> readOnlyProperties = _filter;
        _builder.newLineIfNotEmpty();
        EList<Property> _properties_1 = entity_1.getProperties();
        final Function1<Property,Boolean> _function_1 = new Function1<Property,Boolean>() {
            public Boolean apply(final Property p) {
              boolean _isUnique = p.isUnique();
              return ((Boolean)_isUnique);
            }
          };
        Iterable<Property> _filter_1 = IterableExtensions.<Property>filter(_properties_1, _function_1);
        Iterable<Property> uniqueProperties = _filter_1;
        _builder.newLineIfNotEmpty();
        EList<Property> _properties_2 = entity_1.getProperties();
        final Function1<Property,Boolean> _function_2 = new Function1<Property,Boolean>() {
            public Boolean apply(final Property p) {
              boolean _operator_and = false;
              Type _type = p.getType();
              if (!(_type instanceof Enum)) {
                _operator_and = false;
              } else {
                boolean _isUnique = p.isUnique();
                boolean _operator_not = BooleanExtensions.operator_not(_isUnique);
                _operator_and = BooleanExtensions.operator_and((_type instanceof Enum), _operator_not);
              }
              return ((Boolean)_operator_and);
            }
          };
        Iterable<Property> _filter_2 = IterableExtensions.<Property>filter(_properties_2, _function_2);
        Iterable<Property> enumProperties = _filter_2;
        _builder.newLineIfNotEmpty();
        EList<Property> _properties_3 = entity_1.getProperties();
        final Function1<Property,Boolean> _function_3 = new Function1<Property,Boolean>() {
            public Boolean apply(final Property p) {
              boolean _operator_and = false;
              boolean _operator_and_1 = false;
              Type _type = p.getType();
              if (!(_type instanceof Entity)) {
                _operator_and_1 = false;
              } else {
                boolean _isToMultiplicity = p.isToMultiplicity();
                boolean _operator_not = BooleanExtensions.operator_not(_isToMultiplicity);
                _operator_and_1 = BooleanExtensions.operator_and((_type instanceof Entity), _operator_not);
              }
              if (!_operator_and_1) {
                _operator_and = false;
              } else {
                boolean _isUnique = p.isUnique();
                boolean _operator_not_1 = BooleanExtensions.operator_not(_isUnique);
                _operator_and = BooleanExtensions.operator_and(_operator_and_1, _operator_not_1);
              }
              return ((Boolean)_operator_and);
            }
          };
        Iterable<Property> _filter_3 = IterableExtensions.<Property>filter(_properties_3, _function_3);
        Iterable<Property> toOneProperties = _filter_3;
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("/** ");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("* Create an instance of type ");
        String _name_5 = entity_1.getName();
        _builder.append(_name_5, "	 ");
        _builder.append(" using all read-only properties.");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        String _name_6 = entity_1.getName();
        _builder.append(_name_6, "	");
        _builder.append(" create");
        String _name_7 = entity_1.getName();
        _builder.append(_name_7, "	");
        _builder.append("(");
        {
          for(final Property property : readOnlyProperties) {
            Type _type = property.getType();
            String _javaClassname = _type.getJavaClassname();
            _builder.append(_javaClassname, "	");
            _builder.append(" ");
            String _name_8 = property.getName();
            String _firstLower_1 = StringExtensions.toFirstLower(_name_8);
            _builder.append(_firstLower_1, "	");
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
        _builder.append("\t\t");
        _builder.append("return ");
        String _name_9 = entity_1.getName();
        String _firstLower_2 = StringExtensions.toFirstLower(_name_9);
        _builder.append(_firstLower_2, "		");
        _builder.append("DAO.create(session");
        {
          for(final Property property_1 : readOnlyProperties) {
            _builder.append(", ");
            String _name_10 = property_1.getName();
            String _firstLower_3 = StringExtensions.toFirstLower(_name_10);
            _builder.append(_firstLower_3, "		");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("* Returns the ");
        String _name_11 = entity_1.getName();
        _builder.append(_name_11, "	 ");
        _builder.append(" with the given id.");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        String _name_12 = entity_1.getName();
        _builder.append(_name_12, "	");
        _builder.append(" get");
        String _name_13 = entity_1.getName();
        _builder.append(_name_13, "	");
        _builder.append("(int id) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        String _name_14 = entity_1.getName();
        _builder.append(_name_14, "		");
        _builder.append(" entity = ");
        String _name_15 = entity_1.getName();
        String _firstLower_4 = StringExtensions.toFirstLower(_name_15);
        _builder.append(_firstLower_4, "		");
        _builder.append("DAO.get(session, id);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return entity;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        {
          for(final Property property_2 : uniqueProperties) {
            _builder.append("\t");
            _builder.append("/** Returns the ");
            String _name_16 = entity_1.getName();
            _builder.append(_name_16, "	");
            _builder.append(" with the given ");
            String _name_17 = property_2.getName();
            _builder.append(_name_17, "	");
            _builder.append(". */");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("public ");
            String _name_18 = entity_1.getName();
            _builder.append(_name_18, "	");
            _builder.append(" get");
            String _name_19 = entity_1.getName();
            _builder.append(_name_19, "	");
            _builder.append("By");
            String _name_20 = property_2.getName();
            String _firstUpper = StringExtensions.toFirstUpper(_name_20);
            _builder.append(_firstUpper, "	");
            _builder.append("(");
            Type _type_1 = property_2.getType();
            String _javaClassname_1 = _type_1.getJavaClassname();
            _builder.append(_javaClassname_1, "	");
            _builder.append(" ");
            String _name_21 = property_2.getName();
            _builder.append(_name_21, "	");
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            String _name_22 = entity_1.getName();
            _builder.append(_name_22, "		");
            _builder.append(" entity = ");
            String _name_23 = entity_1.getName();
            String _firstLower_5 = StringExtensions.toFirstLower(_name_23);
            _builder.append(_firstLower_5, "		");
            _builder.append("DAO.getBy");
            String _name_24 = property_2.getName();
            String _firstUpper_1 = StringExtensions.toFirstUpper(_name_24);
            _builder.append(_firstUpper_1, "		");
            _builder.append("(session, ");
            String _name_25 = property_2.getName();
            _builder.append(_name_25, "		");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return entity;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.newLine();
          }
        }
        {
          for(final Property property_3 : toOneProperties) {
            _builder.append("\t");
            _builder.append("/** Returns the ");
            String _name_26 = entity_1.getName();
            _builder.append(_name_26, "	");
            _builder.append("s with the given ");
            String _name_27 = property_3.getName();
            _builder.append(_name_27, "	");
            _builder.append(". */");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("public List<");
            String _name_28 = entity_1.getName();
            _builder.append(_name_28, "	");
            _builder.append("> get");
            String _name_29 = entity_1.getName();
            _builder.append(_name_29, "	");
            _builder.append("sBy");
            String _name_30 = property_3.getName();
            String _firstUpper_2 = StringExtensions.toFirstUpper(_name_30);
            _builder.append(_firstUpper_2, "	");
            _builder.append("(");
            Type _type_2 = property_3.getType();
            String _javaClassname_2 = _type_2.getJavaClassname();
            _builder.append(_javaClassname_2, "	");
            _builder.append(" ");
            String _name_31 = property_3.getName();
            _builder.append(_name_31, "	");
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("List<");
            String _name_32 = entity_1.getName();
            _builder.append(_name_32, "		");
            _builder.append("> entities = ");
            String _name_33 = entity_1.getName();
            String _firstLower_6 = StringExtensions.toFirstLower(_name_33);
            _builder.append(_firstLower_6, "		");
            _builder.append("DAO.getBy");
            String _name_34 = property_3.getName();
            String _firstUpper_3 = StringExtensions.toFirstUpper(_name_34);
            _builder.append(_firstUpper_3, "		");
            _builder.append("(session, ");
            String _name_35 = property_3.getName();
            _builder.append(_name_35, "		");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return entities;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.newLine();
          }
        }
        {
          for(final Property property_4 : enumProperties) {
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* Returns all ");
            String _name_36 = entity_1.getName();
            _builder.append(_name_36, "	 ");
            _builder.append("s with the given ");
            String _name_37 = property_4.getName();
            _builder.append(_name_37, "	 ");
            _builder.append(".");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public List<");
            String _name_38 = entity_1.getName();
            _builder.append(_name_38, "	");
            _builder.append("> get");
            String _name_39 = entity_1.getName();
            _builder.append(_name_39, "	");
            _builder.append("sBy");
            String _name_40 = property_4.getName();
            String _firstUpper_4 = StringExtensions.toFirstUpper(_name_40);
            _builder.append(_firstUpper_4, "	");
            _builder.append("(");
            Type _type_3 = property_4.getType();
            String _javaClassname_3 = _type_3.getJavaClassname();
            _builder.append(_javaClassname_3, "	");
            _builder.append(" ");
            String _name_41 = property_4.getName();
            _builder.append(_name_41, "	");
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return ");
            String _name_42 = entity_1.getName();
            String _firstLower_7 = StringExtensions.toFirstLower(_name_42);
            _builder.append(_firstLower_7, "		");
            _builder.append("DAO.getBy");
            String _name_43 = property_4.getName();
            String _firstUpper_5 = StringExtensions.toFirstUpper(_name_43);
            _builder.append(_firstUpper_5, "		");
            _builder.append("(session, ");
            String _name_44 = property_4.getName();
            _builder.append(_name_44, "		");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
          }
        }
        {
          EList<Constraint> _constraints = entity_1.getConstraints();
          for(final Constraint constraint : _constraints) {
            {
              if ((constraint instanceof UniqueConstraint)) {
                _builder.append("\t");
                UniqueConstraint uniqueConstraint = ((UniqueConstraint) constraint);
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("/**");
                _builder.newLine();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* Returns the ");
                String _name_45 = entity_1.getName();
                _builder.append(_name_45, "	 ");
                _builder.append(" with the given properties.");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("*/");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("public ");
                String _name_46 = entity_1.getName();
                _builder.append(_name_46, "	");
                _builder.append(" get");
                String _name_47 = entity_1.getName();
                _builder.append(_name_47, "	");
                _builder.append("By");
                {
                  EList<Property> _properties_4 = uniqueConstraint.getProperties();
                  for(final Property property_5 : _properties_4) {
                    String _name_48 = property_5.getName();
                    String _firstUpper_6 = StringExtensions.toFirstUpper(_name_48);
                    _builder.append(_firstUpper_6, "	");
                  }
                }
                _builder.append("(");
                {
                  EList<Property> _properties_5 = uniqueConstraint.getProperties();
                  for(final Property property_6 : _properties_5) {
                    Type _type_4 = property_6.getType();
                    String _javaClassname_4 = _type_4.getJavaClassname();
                    _builder.append(_javaClassname_4, "	");
                    _builder.append(" ");
                    String _name_49 = property_6.getName();
                    _builder.append(_name_49, "	");
                    {
                      EList<Property> _properties_6 = uniqueConstraint.getProperties();
                      Property _last_1 = IterableExtensions.<Property>last(_properties_6);
                      boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_last_1, property_6);
                      if (_operator_notEquals_1) {
                        _builder.append(", ");
                      }
                    }
                  }
                }
                _builder.append(") {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                String _name_50 = entity_1.getName();
                _builder.append(_name_50, "		");
                _builder.append(" entity = ");
                String _name_51 = entity_1.getName();
                String _firstLower_8 = StringExtensions.toFirstLower(_name_51);
                _builder.append(_firstLower_8, "		");
                _builder.append("DAO.getBy");
                {
                  EList<Property> _properties_7 = uniqueConstraint.getProperties();
                  for(final Property property_7 : _properties_7) {
                    String _name_52 = property_7.getName();
                    String _firstUpper_7 = StringExtensions.toFirstUpper(_name_52);
                    _builder.append(_firstUpper_7, "		");
                  }
                }
                _builder.append("(session, ");
                {
                  EList<Property> _properties_8 = uniqueConstraint.getProperties();
                  for(final Property property_8 : _properties_8) {
                    String _name_53 = property_8.getName();
                    _builder.append(_name_53, "		");
                    {
                      EList<Property> _properties_9 = uniqueConstraint.getProperties();
                      Property _last_2 = IterableExtensions.<Property>last(_properties_9);
                      boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(_last_2, property_8);
                      if (_operator_notEquals_2) {
                        _builder.append(", ");
                      }
                    }
                  }
                }
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("return entity;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.newLine();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("* Returns all entities of type ");
        String _name_54 = entity_1.getName();
        _builder.append(_name_54, "	 ");
        _builder.append(".");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public List<");
        String _name_55 = entity_1.getName();
        _builder.append(_name_55, "	");
        _builder.append("> getAll");
        String _name_56 = entity_1.getName();
        _builder.append(_name_56, "	");
        _builder.append("s() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("final List<");
        String _name_57 = entity_1.getName();
        _builder.append(_name_57, "		");
        _builder.append("> entities = ");
        String _name_58 = entity_1.getName();
        String _firstLower_9 = StringExtensions.toFirstLower(_name_58);
        _builder.append(_firstLower_9, "		");
        _builder.append("DAO.getAll(session);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return entities;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("* Searches for entities of type ");
        String _name_59 = entity_1.getName();
        _builder.append(_name_59, "	 ");
        _builder.append(".");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public List<");
        String _name_60 = entity_1.getName();
        _builder.append(_name_60, "	");
        _builder.append("> search");
        String _name_61 = entity_1.getName();
        _builder.append(_name_61, "	");
        _builder.append("s(String _searchString, int _maxResults) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return ");
        String _name_62 = entity_1.getName();
        String _firstLower_10 = StringExtensions.toFirstLower(_name_62);
        _builder.append(_firstLower_10, "		");
        _builder.append("DAO.search(session, _searchString, _maxResults);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        EList<Property> _properties_10 = entity_1.getProperties();
        final Function1<Property,Boolean> _function_4 = new Function1<Property,Boolean>() {
            public Boolean apply(final Property p) {
              boolean _isToOneReference = p.isToOneReference();
              return ((Boolean)_isToOneReference);
            }
          };
        Iterable<Property> _filter_4 = IterableExtensions.<Property>filter(_properties_10, _function_4);
        Iterable<Property> toOneReferences = _filter_4;
        _builder.newLineIfNotEmpty();
        {
          for(final Property toOneReference : toOneReferences) {
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* Searches for entities of type ");
            String _name_63 = entity_1.getName();
            _builder.append(_name_63, "	 ");
            _builder.append(".");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public List<");
            String _name_64 = entity_1.getName();
            _builder.append(_name_64, "	");
            _builder.append("> search");
            String _name_65 = entity_1.getName();
            _builder.append(_name_65, "	");
            _builder.append("With");
            String _name_66 = toOneReference.getName();
            String _firstUpper_8 = StringExtensions.toFirstUpper(_name_66);
            _builder.append(_firstUpper_8, "	");
            _builder.append("(");
            String _typeClassname = toOneReference.getTypeClassname();
            _builder.append(_typeClassname, "	");
            _builder.append(" ");
            String _name_67 = toOneReference.getName();
            _builder.append(_name_67, "	");
            _builder.append(", String _searchString, int _maxResults) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return ");
            String _name_68 = entity_1.getName();
            String _firstLower_11 = StringExtensions.toFirstLower(_name_68);
            _builder.append(_firstLower_11, "		");
            _builder.append("DAO.searchWith");
            String _name_69 = toOneReference.getName();
            String _firstUpper_9 = StringExtensions.toFirstUpper(_name_69);
            _builder.append(_firstUpper_9, "		");
            _builder.append("(session, ");
            String _name_70 = toOneReference.getName();
            _builder.append(_name_70, "		");
            _builder.append(", _searchString, _maxResults);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("* Deletes a ");
        String _name_71 = entity_1.getName();
        _builder.append(_name_71, "	 ");
        _builder.append(".");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void delete(");
        String _name_72 = entity_1.getName();
        _builder.append(_name_72, "	");
        _builder.append(" entity) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        String _name_73 = entity_1.getName();
        String _firstLower_12 = StringExtensions.toFirstLower(_name_73);
        _builder.append(_firstLower_12, "		");
        _builder.append("DAO.delete(session, entity);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t ");
        _builder.append("* Counts the number of ");
        String _name_74 = entity_1.getName();
        _builder.append(_name_74, "	 ");
        _builder.append(" entities.");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public int count");
        String _name_75 = entity_1.getName();
        String _firstUpper_10 = StringExtensions.toFirstUpper(_name_75);
        _builder.append(_firstUpper_10, "	");
        _builder.append("s() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return ");
        String _name_76 = entity_1.getName();
        String _firstLower_13 = StringExtensions.toFirstLower(_name_76);
        _builder.append(_firstLower_13, "		");
        _builder.append("DAO.count(session);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Returns the name of the table that contains entities of the given type.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getTableName(Class<?> clazz) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ClassMetadata hibernateMetadata = getSession().getSessionFactory().getClassMetadata(clazz);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (hibernateMetadata == null) {");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (hibernateMetadata instanceof AbstractEntityPersister) {");
    _builder.newLine();
    _builder.append("\t\t     ");
    _builder.append("AbstractEntityPersister persister = (AbstractEntityPersister) hibernateMetadata;");
    _builder.newLine();
    _builder.append("\t\t     ");
    _builder.append("return persister.getTableName();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
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
    _builder.append(".");
    _builder.append(HEDLCodegenConstants.DAO_PACKAGE_NAME, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.hibernate.classic.Session;");
    _builder.newLine();
    _builder.append("import org.hibernate.Criteria;");
    _builder.newLine();
    _builder.append("import org.hibernate.HibernateException;");
    _builder.newLine();
    _builder.append("import org.hibernate.criterion.Disjunction;");
    _builder.newLine();
    _builder.append("import org.hibernate.criterion.MatchMode;");
    _builder.newLine();
    _builder.append("import org.hibernate.criterion.Order;");
    _builder.newLine();
    _builder.append("import org.hibernate.criterion.Restrictions;");
    _builder.newLine();
    _builder.newLine();
    {
      EntityModel _entityModel = entity.getEntityModel();
      EList<Entity> _entities = _entityModel.getEntities();
      for(final Entity otherEntity : _entities) {
        _builder.append("import ");
        _builder.append(packageName, "");
        _builder.append(".");
        _builder.append(HEDLCodegenConstants.ENTITY_PACKAGE_NAME, "");
        _builder.append(".");
        String _name = otherEntity.getName();
        _builder.append(_name, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    {
      EntityModel _entityModel_1 = entity.getEntityModel();
      EList<Enum> _enums = _entityModel_1.getEnums();
      for(final Enum otherEnum : _enums) {
        _builder.append("import ");
        _builder.append(packageName, "");
        _builder.append(".");
        _builder.append(HEDLCodegenConstants.ENTITY_PACKAGE_NAME, "");
        _builder.append(".");
        String _name_1 = otherEnum.getName();
        _builder.append(_name_1, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* This class provides all default operations that are derived from the HEDL entity model");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* for type ");
    String _name_2 = entity.getName();
    _builder.append(_name_2, " ");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Note: This class is generated. Any change will be overridden.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public class ");
    String _name_3 = entity.getName();
    _builder.append(_name_3, "");
    _builder.append("DAO {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public final static String FIELD__ID = getField(");
    String _name_4 = entity.getName();
    _builder.append(_name_4, "	");
    _builder.append(".class, \"id\");");
    _builder.newLineIfNotEmpty();
    {
      EList<Property> _properties = entity.getProperties();
      for(final Property property : _properties) {
        _builder.append("\t");
        _builder.append("public final static String FIELD__");
        String _name_5 = property.getName();
        String _upperCase = _name_5.toUpperCase();
        _builder.append(_upperCase, "	");
        _builder.append(" = getField(");
        String _name_6 = entity.getName();
        _builder.append(_name_6, "	");
        _builder.append(".class, \"");
        String _name_7 = property.getName();
        _builder.append(_name_7, "	");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
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
    EList<Property> _properties_2 = entity.getProperties();
    final Function1<Property,Boolean> _function_1 = new Function1<Property,Boolean>() {
        public Boolean apply(final Property p) {
          boolean _isUnique = p.isUnique();
          return ((Boolean)_isUnique);
        }
      };
    Iterable<Property> _filter_1 = IterableExtensions.<Property>filter(_properties_2, _function_1);
    Iterable<Property> uniqueProperties = _filter_1;
    _builder.newLineIfNotEmpty();
    EList<Property> _properties_3 = entity.getProperties();
    final Function1<Property,Boolean> _function_2 = new Function1<Property,Boolean>() {
        public Boolean apply(final Property p) {
          boolean _operator_and = false;
          Type _type = p.getType();
          if (!(_type instanceof Enum)) {
            _operator_and = false;
          } else {
            boolean _isUnique = p.isUnique();
            boolean _operator_not = BooleanExtensions.operator_not(_isUnique);
            _operator_and = BooleanExtensions.operator_and((_type instanceof Enum), _operator_not);
          }
          return ((Boolean)_operator_and);
        }
      };
    Iterable<Property> _filter_2 = IterableExtensions.<Property>filter(_properties_3, _function_2);
    Iterable<Property> enumProperties = _filter_2;
    _builder.newLineIfNotEmpty();
    EList<Property> _properties_4 = entity.getProperties();
    final Function1<Property,Boolean> _function_3 = new Function1<Property,Boolean>() {
        public Boolean apply(final Property p) {
          boolean _operator_and = false;
          boolean _operator_and_1 = false;
          Type _type = p.getType();
          if (!(_type instanceof Entity)) {
            _operator_and_1 = false;
          } else {
            boolean _isToMultiplicity = p.isToMultiplicity();
            boolean _operator_not = BooleanExtensions.operator_not(_isToMultiplicity);
            _operator_and_1 = BooleanExtensions.operator_and((_type instanceof Entity), _operator_not);
          }
          if (!_operator_and_1) {
            _operator_and = false;
          } else {
            boolean _isUnique = p.isUnique();
            boolean _operator_not_1 = BooleanExtensions.operator_not(_isUnique);
            _operator_and = BooleanExtensions.operator_and(_operator_and_1, _operator_not_1);
          }
          return ((Boolean)_operator_and);
        }
      };
    Iterable<Property> _filter_3 = IterableExtensions.<Property>filter(_properties_4, _function_3);
    Iterable<Property> toOneProperties = _filter_3;
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Creates a ");
    String _name_8 = entity.getName();
    _builder.append(_name_8, "	 ");
    _builder.append(" using all read-only properties.");
    _builder.newLineIfNotEmpty();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _name_9 = entity.getName();
    _builder.append(_name_9, "	");
    _builder.append(" create(Session session");
    {
      for(final Property property_1 : readOnlyProperties) {
        _builder.append(", ");
        Type _type = property_1.getType();
        String _javaClassname = _type.getJavaClassname();
        _builder.append(_javaClassname, "	");
        _builder.append(" ");
        String _name_10 = property_1.getName();
        String _firstLower = StringExtensions.toFirstLower(_name_10);
        _builder.append(_firstLower, "	");
      }
    }
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _name_11 = entity.getName();
    _builder.append(_name_11, "		");
    _builder.append(" newEntity = new ");
    String _name_12 = entity.getName();
    _builder.append(_name_12, "		");
    _builder.append("(");
    {
      for(final Property property_2 : readOnlyProperties) {
        String _name_13 = property_2.getName();
        String _firstLower_1 = StringExtensions.toFirstLower(_name_13);
        _builder.append(_firstLower_1, "		");
        {
          Property _last = IterableExtensions.<Property>last(readOnlyProperties);
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_last, property_2);
          if (_operator_notEquals) {
            _builder.append(", ");
          }
        }
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("session.save(newEntity);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return newEntity;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Returns the ");
    String _name_14 = entity.getName();
    _builder.append(_name_14, "	 ");
    _builder.append(" with the given id.");
    _builder.newLineIfNotEmpty();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _name_15 = entity.getName();
    _builder.append(_name_15, "	");
    _builder.append(" get(Session session, int id) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _name_16 = entity.getName();
    _builder.append(_name_16, "		");
    _builder.append(" entity = (");
    String _name_17 = entity.getName();
    _builder.append(_name_17, "		");
    _builder.append(") session.get(");
    String _name_18 = entity.getName();
    _builder.append(_name_18, "		");
    _builder.append(".class, id);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return entity;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      for(final Property property_3 : uniqueProperties) {
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(" ");
        _builder.append("* Returns the ");
        String _name_19 = entity.getName();
        _builder.append(_name_19, "	 ");
        _builder.append(" with the given ");
        String _name_20 = property_3.getName();
        _builder.append(_name_20, "	 ");
        _builder.append(".");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        String _name_21 = entity.getName();
        _builder.append(_name_21, "	");
        _builder.append(" getBy");
        String _name_22 = property_3.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name_22);
        _builder.append(_firstUpper, "	");
        _builder.append("(Session session, ");
        Type _type_1 = property_3.getType();
        String _javaClassname_1 = _type_1.getJavaClassname();
        _builder.append(_javaClassname_1, "	");
        _builder.append(" ");
        String _name_23 = property_3.getName();
        _builder.append(_name_23, "	");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("Criteria criteria = session.createCriteria(");
        String _name_24 = entity.getName();
        _builder.append(_name_24, "		");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("criteria = criteria.add(Restrictions.eq(FIELD__");
        String _name_25 = property_3.getName();
        String _upperCase_1 = _name_25.toUpperCase();
        _builder.append(_upperCase_1, "		");
        _builder.append(", ");
        String _name_26 = property_3.getName();
        _builder.append(_name_26, "		");
        _builder.append("));");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("List<?> list = criteria.list();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("if (list != null && !list.isEmpty()) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("return (");
        String _name_27 = entity.getName();
        _builder.append(_name_27, "			");
        _builder.append(") list.get(0);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    {
      for(final Property property_4 : toOneProperties) {
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(" ");
        _builder.append("* Returns the ");
        String _name_28 = entity.getName();
        _builder.append(_name_28, "	 ");
        _builder.append("s with the given ");
        String _name_29 = property_4.getName();
        _builder.append(_name_29, "	 ");
        _builder.append(".");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public List<");
        String _name_30 = entity.getName();
        _builder.append(_name_30, "	");
        _builder.append("> getBy");
        String _name_31 = property_4.getName();
        String _firstUpper_1 = StringExtensions.toFirstUpper(_name_31);
        _builder.append(_firstUpper_1, "	");
        _builder.append("(Session session, ");
        Type _type_2 = property_4.getType();
        String _javaClassname_2 = _type_2.getJavaClassname();
        _builder.append(_javaClassname_2, "	");
        _builder.append(" ");
        String _name_32 = property_4.getName();
        _builder.append(_name_32, "	");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("Criteria criteria = session.createCriteria(");
        String _name_33 = entity.getName();
        _builder.append(_name_33, "		");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("criteria = criteria.add(Restrictions.eq(FIELD__");
        String _name_34 = property_4.getName();
        String _upperCase_2 = _name_34.toUpperCase();
        _builder.append(_upperCase_2, "		");
        _builder.append(", ");
        String _name_35 = property_4.getName();
        _builder.append(_name_35, "		");
        _builder.append("));");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("@SuppressWarnings(\"unchecked\")");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("List<");
        String _name_36 = entity.getName();
        _builder.append(_name_36, "		");
        _builder.append("> list = (List<");
        String _name_37 = entity.getName();
        _builder.append(_name_37, "		");
        _builder.append(">) criteria.list();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return list;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    {
      EList<Constraint> _constraints = entity.getConstraints();
      for(final Constraint constraint : _constraints) {
        {
          if ((constraint instanceof UniqueConstraint)) {
            UniqueConstraint uniqueConstraint = ((UniqueConstraint) constraint);
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t ");
            _builder.append("* Returns the ");
            String _name_38 = entity.getName();
            _builder.append(_name_38, "	 ");
            _builder.append(" with the given properties.");
            _builder.newLineIfNotEmpty();
            _builder.append("\t ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public ");
            String _name_39 = entity.getName();
            _builder.append(_name_39, "	");
            _builder.append(" getBy");
            {
              EList<Property> _properties_5 = uniqueConstraint.getProperties();
              for(final Property property_5 : _properties_5) {
                String _name_40 = property_5.getName();
                String _firstUpper_2 = StringExtensions.toFirstUpper(_name_40);
                _builder.append(_firstUpper_2, "	");
              }
            }
            _builder.append("(Session session, ");
            {
              EList<Property> _properties_6 = uniqueConstraint.getProperties();
              for(final Property property_6 : _properties_6) {
                Type _type_3 = property_6.getType();
                String _javaClassname_3 = _type_3.getJavaClassname();
                _builder.append(_javaClassname_3, "	");
                _builder.append(" ");
                String _name_41 = property_6.getName();
                _builder.append(_name_41, "	");
                {
                  EList<Property> _properties_7 = uniqueConstraint.getProperties();
                  Property _last_1 = IterableExtensions.<Property>last(_properties_7);
                  boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_last_1, property_6);
                  if (_operator_notEquals_1) {
                    _builder.append(", ");
                  }
                }
              }
            }
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("Criteria criteria = session.createCriteria(");
            String _name_42 = entity.getName();
            _builder.append(_name_42, "		");
            _builder.append(".class);");
            _builder.newLineIfNotEmpty();
            {
              EList<Property> _properties_8 = uniqueConstraint.getProperties();
              for(final Property property_7 : _properties_8) {
                _builder.append("\t\t");
                _builder.append("criteria = criteria.add(Restrictions.eq(FIELD__");
                String _name_43 = property_7.getName();
                String _upperCase_3 = _name_43.toUpperCase();
                _builder.append(_upperCase_3, "		");
                _builder.append(", ");
                String _name_44 = property_7.getName();
                _builder.append(_name_44, "		");
                _builder.append("));");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t");
            _builder.append("List<?> list = criteria.list();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("if (list != null && !list.isEmpty()) {");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("return (");
            String _name_45 = entity.getName();
            _builder.append(_name_45, "			");
            _builder.append(") list.get(0);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("return null;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
          }
        }
      }
    }
    {
      for(final Property property_8 : enumProperties) {
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(" ");
        _builder.append("* Returns all ");
        String _name_46 = entity.getName();
        _builder.append(_name_46, "	 ");
        _builder.append("s with the given ");
        String _name_47 = property_8.getName();
        _builder.append(_name_47, "	 ");
        _builder.append(".");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public List<");
        String _name_48 = entity.getName();
        _builder.append(_name_48, "	");
        _builder.append("> getBy");
        String _name_49 = property_8.getName();
        String _firstUpper_3 = StringExtensions.toFirstUpper(_name_49);
        _builder.append(_firstUpper_3, "	");
        _builder.append("(Session session, ");
        Type _type_4 = property_8.getType();
        String _javaClassname_4 = _type_4.getJavaClassname();
        _builder.append(_javaClassname_4, "	");
        _builder.append(" ");
        String _name_50 = property_8.getName();
        _builder.append(_name_50, "	");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("Criteria criteria = session.createCriteria(");
        String _name_51 = entity.getName();
        _builder.append(_name_51, "		");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("criteria = criteria.add(Restrictions.eq(FIELD__");
        String _name_52 = property_8.getName();
        String _upperCase_4 = _name_52.toUpperCase();
        _builder.append(_upperCase_4, "		");
        _builder.append(", ");
        String _name_53 = property_8.getName();
        _builder.append(_name_53, "		");
        _builder.append("));");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("List<?> list = criteria.list();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("@SuppressWarnings(\"unchecked\")");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("List<");
        String _name_54 = entity.getName();
        _builder.append(_name_54, "		");
        _builder.append("> entities = (List<");
        String _name_55 = entity.getName();
        _builder.append(_name_55, "		");
        _builder.append(">) list;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return entities;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Returns all entities of type ");
    String _name_56 = entity.getName();
    _builder.append(_name_56, "	 ");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public List<");
    String _name_57 = entity.getName();
    _builder.append(_name_57, "	");
    _builder.append("> getAll(Session session) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("Criteria criteria = session.createCriteria(");
    String _name_58 = entity.getName();
    _builder.append(_name_58, "		");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("@SuppressWarnings(\"unchecked\")");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("List<");
    String _name_59 = entity.getName();
    _builder.append(_name_59, "		");
    _builder.append("> entities = (List<");
    String _name_60 = entity.getName();
    _builder.append(_name_60, "		");
    _builder.append(">) criteria.list();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return entities;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Searches for entities of type ");
    String _name_61 = entity.getName();
    _builder.append(_name_61, "	 ");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public List<");
    String _name_62 = entity.getName();
    _builder.append(_name_62, "	");
    _builder.append("> search(Session _session, String _searchString, int _maxResults) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("Criteria criteria = _session.createCriteria(");
    String _name_63 = entity.getName();
    _builder.append(_name_63, "		");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("Disjunction disjunction = Restrictions.disjunction();");
    _builder.newLine();
    {
      EList<Property> _properties_9 = entity.getProperties();
      for(final Property property_9 : _properties_9) {
        {
          Type _type_5 = property_9.getType();
          String _javaClassname_5 = _type_5.getJavaClassname();
          String _name_64 = java.lang.String.class.getName();
          boolean _equals = _javaClassname_5.equals(_name_64);
          if (_equals) {
            _builder.append("\t\t");
            _builder.append("disjunction.add(Restrictions.like(FIELD__");
            String _name_65 = property_9.getName();
            String _upperCase_5 = _name_65.toUpperCase();
            _builder.append(_upperCase_5, "		");
            _builder.append(", _searchString.trim(), MatchMode.ANYWHERE));");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t\t");
    _builder.append("criteria = criteria.add(disjunction);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("criteria = criteria.setMaxResults(_maxResults);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("@SuppressWarnings(\"unchecked\")");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("List<");
    String _name_66 = entity.getName();
    _builder.append(_name_66, "		");
    _builder.append("> entities = (List<");
    String _name_67 = entity.getName();
    _builder.append(_name_67, "		");
    _builder.append(">) criteria.list();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return entities;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    EList<Property> _properties_10 = entity.getProperties();
    final Function1<Property,Boolean> _function_4 = new Function1<Property,Boolean>() {
        public Boolean apply(final Property p) {
          boolean _isToOneReference = p.isToOneReference();
          return ((Boolean)_isToOneReference);
        }
      };
    Iterable<Property> _filter_4 = IterableExtensions.<Property>filter(_properties_10, _function_4);
    Iterable<Property> toOneReferences = _filter_4;
    _builder.newLineIfNotEmpty();
    {
      for(final Property toOneReference : toOneReferences) {
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(" ");
        _builder.append("* Searches for entities of type ");
        String _name_68 = entity.getName();
        _builder.append(_name_68, "	 ");
        _builder.append(".");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public List<");
        String _name_69 = entity.getName();
        _builder.append(_name_69, "	");
        _builder.append("> searchWith");
        String _name_70 = toOneReference.getName();
        String _firstUpper_4 = StringExtensions.toFirstUpper(_name_70);
        _builder.append(_firstUpper_4, "	");
        _builder.append("(Session _session, ");
        String _typeClassname = toOneReference.getTypeClassname();
        _builder.append(_typeClassname, "	");
        _builder.append(" ");
        String _name_71 = toOneReference.getName();
        _builder.append(_name_71, "	");
        _builder.append(", String _searchString, int _maxResults) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("Criteria criteria = _session.createCriteria(");
        String _name_72 = entity.getName();
        _builder.append(_name_72, "		");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("// restrict by the value of the unique property");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("criteria = criteria.add(Restrictions.eq(FIELD__");
        String _name_73 = toOneReference.getName();
        String _upperCase_6 = _name_73.toUpperCase();
        _builder.append(_upperCase_6, "		");
        _builder.append(", ");
        String _name_74 = toOneReference.getName();
        _builder.append(_name_74, "		");
        _builder.append("));");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("Disjunction disjunction = Restrictions.disjunction();");
        _builder.newLine();
        {
          EList<Property> _properties_11 = entity.getProperties();
          for(final Property property_10 : _properties_11) {
            {
              Type _type_6 = property_10.getType();
              String _javaClassname_6 = _type_6.getJavaClassname();
              String _name_75 = java.lang.String.class.getName();
              boolean _equals_1 = _javaClassname_6.equals(_name_75);
              if (_equals_1) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("disjunction.add(Restrictions.like(FIELD__");
                String _name_76 = property_10.getName();
                String _upperCase_7 = _name_76.toUpperCase();
                _builder.append(_upperCase_7, "		");
                _builder.append(", _searchString.trim(), MatchMode.ANYWHERE));");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("criteria = criteria.add(disjunction);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("criteria = criteria.setMaxResults(_maxResults);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("@SuppressWarnings(\"unchecked\")");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("List<");
        String _name_77 = entity.getName();
        _builder.append(_name_77, "		");
        _builder.append("> entities = (List<");
        String _name_78 = entity.getName();
        _builder.append(_name_78, "		");
        _builder.append(">) criteria.list();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return entities;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Deletes a ");
    String _name_79 = entity.getName();
    _builder.append(_name_79, "	 ");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void delete(Session session, ");
    String _name_80 = entity.getName();
    _builder.append(_name_80, "	");
    _builder.append(" entity) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("session.delete(entity);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Counts the number of ");
    String _name_81 = entity.getName();
    _builder.append(_name_81, "	 ");
    _builder.append(" entities.");
    _builder.newLineIfNotEmpty();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public int count(Session session) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return ((Long) session.createQuery(\"select count(*) from ");
    String _name_82 = entity.getName();
    _builder.append(_name_82, "		");
    _builder.append("\").uniqueResult()).intValue();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static String getField(Class<?> clazz, String fieldName) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return clazz.getDeclaredField(fieldName).getName();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (SecurityException e) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new RuntimeException(e.getClass().getSimpleName() + \": \" + e.getMessage());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (NoSuchFieldException e) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new RuntimeException(e.getClass().getSimpleName() + \": \" + e.getMessage());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
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
    _builder.append(".");
    _builder.append(HEDLCodegenConstants.ENTITY_PACKAGE_NAME, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.persistence.Entity;");
    _builder.newLine();
    _builder.append("import javax.persistence.GeneratedValue;");
    _builder.newLine();
    _builder.append("import javax.persistence.GenerationType;");
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
    _builder.append("import javax.persistence.EnumType;");
    _builder.newLine();
    _builder.append("import javax.persistence.Enumerated;");
    _builder.newLine();
    _builder.append("import javax.persistence.CascadeType;");
    _builder.newLine();
    _builder.append("import javax.persistence.OneToMany;");
    _builder.newLine();
    _builder.append("import javax.persistence.Column;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.hibernate.annotations.GenericGenerator;");
    _builder.newLine();
    _builder.append("import org.hibernate.annotations.Parameter;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Entity");
    _builder.newLine();
    _builder.append("@Table(name = \"");
    String _name = entity.getName();
    _builder.append(_name, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    {
      EList<Constraint> _constraints = entity.getConstraints();
      for(final Constraint constraint : _constraints) {
        {
          if ((constraint instanceof UniqueConstraint)) {
            UniqueConstraint uniqueConstraint = ((UniqueConstraint) constraint);
            _builder.newLineIfNotEmpty();
            _builder.append(", uniqueConstraints=@UniqueConstraint(columnNames={");
            {
              EList<Property> _properties = uniqueConstraint.getProperties();
              for(final Property property : _properties) {
                _builder.append("\"");
                String _name_1 = property.getName();
                _builder.append(_name_1, "");
                _builder.append("\", ");
              }
            }
            _builder.append("})");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    {
      String _comment = entity.getComment();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_comment, null);
      if (_operator_notEquals) {
        String _comment_1 = entity.getComment();
        String _replace = _comment_1.replace("\t", "");
        _builder.append(_replace, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* This class is generated from the entity \'");
    String _name_2 = entity.getName();
    _builder.append(_name_2, " ");
    _builder.append("\' defined in the HEDL model.");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* Note: Any change made to this class will be overridden.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public class ");
    String _name_3 = entity.getName();
    _builder.append(_name_3, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@GenericGenerator(name=\"");
    String _name_4 = entity.getName();
    _builder.append(_name_4, "	");
    _builder.append("IdGenerator\", strategy=\"org.hibernate.id.MultipleHiLoPerTableGenerator\",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t  ");
    _builder.append("parameters = {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("@Parameter(name=\"table\", value=\"IdentityGenerator\"),");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("@Parameter(name=\"primary_key_column\", value=\"sequence_name\"),");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("@Parameter(name=\"primary_key_value\", value=\"");
    String _name_5 = entity.getName();
    _builder.append(_name_5, "	    ");
    _builder.append("\"),");
    _builder.newLineIfNotEmpty();
    _builder.append("\t    ");
    _builder.append("@Parameter(name=\"value_column\", value=\"next_hi_value\"),");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("@Parameter(name=\"primary_key_length\", value=\"100\"),");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("@Parameter(name=\"max_lo\", value=\"1000\")");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Id ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@GeneratedValue(strategy=GenerationType.TABLE, generator=\"");
    String _name_6 = entity.getName();
    _builder.append(_name_6, "	");
    _builder.append("IdGenerator\")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("private int id;");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Property> _properties_1 = entity.getProperties();
      for(final Property property_1 : _properties_1) {
        {
          Type _type = property_1.getType();
          if ((_type instanceof JavaType)) {
            Type _type_1 = property_1.getType();
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
        {
          Type _type_2 = property_1.getType();
          if ((_type_2 instanceof Enum)) {
            _builder.append("\t");
            _builder.append("@Enumerated(EnumType.STRING)");
            _builder.newLine();
          }
        }
        {
          Type _type_3 = property_1.getType();
          if ((_type_3 instanceof Entity)) {
            {
              boolean _operator_and = false;
              boolean _isFromMultiplicity = property_1.isFromMultiplicity();
              boolean _operator_not = BooleanExtensions.operator_not(_isFromMultiplicity);
              if (!_operator_not) {
                _operator_and = false;
              } else {
                boolean _isToMultiplicity = property_1.isToMultiplicity();
                boolean _operator_not_1 = BooleanExtensions.operator_not(_isToMultiplicity);
                _operator_and = BooleanExtensions.operator_and(_operator_not, _operator_not_1);
              }
              if (_operator_and) {
                _builder.append("\t");
                _builder.append("@OneToOne(cascade={");
                {
                  boolean _isPersist = property_1.isPersist();
                  if (_isPersist) {
                    _builder.append("CascadeType.PERSIST, ");
                  }
                }
                {
                  boolean _isRefresh = property_1.isRefresh();
                  if (_isRefresh) {
                    _builder.append("CascadeType.REFRESH");
                  }
                }
                {
                  boolean _operator_and_1 = false;
                  boolean _isPersist_1 = property_1.isPersist();
                  boolean _operator_not_2 = BooleanExtensions.operator_not(_isPersist_1);
                  if (!_operator_not_2) {
                    _operator_and_1 = false;
                  } else {
                    boolean _isRefresh_1 = property_1.isRefresh();
                    boolean _operator_not_3 = BooleanExtensions.operator_not(_isRefresh_1);
                    _operator_and_1 = BooleanExtensions.operator_and(_operator_not_2, _operator_not_3);
                  }
                  if (_operator_and_1) {
                    _builder.append("CascadeType.ALL");
                  }
                }
                _builder.append("})");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("@JoinColumn(name=\"");
                String _name_7 = property_1.getName();
                _builder.append(_name_7, "	");
                _builder.append("\"");
                {
                  boolean _isReadonly = property_1.isReadonly();
                  if (_isReadonly) {
                    _builder.append(", updatable=false");
                  }
                }
                _builder.append(", nullable=");
                boolean _isNullable = property_1.isNullable();
                _builder.append(_isNullable, "	");
                _builder.append(")");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _operator_and_2 = false;
              boolean _isFromMultiplicity_1 = property_1.isFromMultiplicity();
              if (!_isFromMultiplicity_1) {
                _operator_and_2 = false;
              } else {
                boolean _isToMultiplicity_1 = property_1.isToMultiplicity();
                boolean _operator_not_4 = BooleanExtensions.operator_not(_isToMultiplicity_1);
                _operator_and_2 = BooleanExtensions.operator_and(_isFromMultiplicity_1, _operator_not_4);
              }
              if (_operator_and_2) {
                _builder.append("\t");
                _builder.append("@ManyToOne(cascade={");
                {
                  boolean _isPersist_2 = property_1.isPersist();
                  if (_isPersist_2) {
                    _builder.append("CascadeType.PERSIST, ");
                  }
                }
                {
                  boolean _isRefresh_2 = property_1.isRefresh();
                  if (_isRefresh_2) {
                    _builder.append("CascadeType.REFRESH");
                  }
                }
                {
                  boolean _operator_and_3 = false;
                  boolean _isPersist_3 = property_1.isPersist();
                  boolean _operator_not_5 = BooleanExtensions.operator_not(_isPersist_3);
                  if (!_operator_not_5) {
                    _operator_and_3 = false;
                  } else {
                    boolean _isRefresh_3 = property_1.isRefresh();
                    boolean _operator_not_6 = BooleanExtensions.operator_not(_isRefresh_3);
                    _operator_and_3 = BooleanExtensions.operator_and(_operator_not_5, _operator_not_6);
                  }
                  if (_operator_and_3) {
                    _builder.append("CascadeType.ALL");
                  }
                }
                _builder.append("})");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("@JoinColumn(name=\"");
                String _name_8 = property_1.getName();
                _builder.append(_name_8, "	");
                _builder.append("\"");
                {
                  boolean _isReadonly_1 = property_1.isReadonly();
                  if (_isReadonly_1) {
                    _builder.append(", updatable=false");
                  }
                }
                _builder.append(", nullable=");
                boolean _isNullable_1 = property_1.isNullable();
                _builder.append(_isNullable_1, "	");
                _builder.append(")");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _operator_and_4 = false;
              boolean _isFromMultiplicity_2 = property_1.isFromMultiplicity();
              boolean _operator_not_7 = BooleanExtensions.operator_not(_isFromMultiplicity_2);
              if (!_operator_not_7) {
                _operator_and_4 = false;
              } else {
                boolean _isToMultiplicity_2 = property_1.isToMultiplicity();
                _operator_and_4 = BooleanExtensions.operator_and(_operator_not_7, _isToMultiplicity_2);
              }
              if (_operator_and_4) {
                _builder.append("\t");
                _builder.append("@OneToMany(cascade={");
                {
                  boolean _isPersist_4 = property_1.isPersist();
                  if (_isPersist_4) {
                    _builder.append("CascadeType.PERSIST, ");
                  }
                }
                {
                  boolean _isRefresh_4 = property_1.isRefresh();
                  if (_isRefresh_4) {
                    _builder.append("CascadeType.REFRESH");
                  }
                }
                {
                  boolean _operator_and_5 = false;
                  boolean _isPersist_5 = property_1.isPersist();
                  boolean _operator_not_8 = BooleanExtensions.operator_not(_isPersist_5);
                  if (!_operator_not_8) {
                    _operator_and_5 = false;
                  } else {
                    boolean _isRefresh_5 = property_1.isRefresh();
                    boolean _operator_not_9 = BooleanExtensions.operator_not(_isRefresh_5);
                    _operator_and_5 = BooleanExtensions.operator_and(_operator_not_8, _operator_not_9);
                  }
                  if (_operator_and_5) {
                    _builder.append("CascadeType.ALL");
                  }
                }
                _builder.append("}");
                {
                  Property _mappedBy = property_1.getMappedBy();
                  boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_mappedBy, null);
                  if (_operator_notEquals_1) {
                    _builder.append(", mappedBy=\"");
                    Property _mappedBy_1 = property_1.getMappedBy();
                    String _name_9 = _mappedBy_1.getName();
                    _builder.append(_name_9, "	");
                    _builder.append("\"");
                  }
                }
                _builder.append(")");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          Type _type_4 = property_1.getType();
          boolean _operator_equals = ObjectExtensions.operator_equals(_type_4, HedlBuiltinTypes.LONGSTRING);
          if (_operator_equals) {
            _builder.append("\t");
            _builder.append("@Column(length=100000)");
            _builder.newLine();
          }
        }
        {
          String _comment_2 = property_1.getComment();
          boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(_comment_2, null);
          if (_operator_notEquals_2) {
            _builder.append("\t");
            String _comment_3 = property_1.getComment();
            String _replace_1 = _comment_3.replace("\t", "");
            _builder.append(_replace_1, "	");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("private ");
        String _typeClassname = property_1.getTypeClassname();
        _builder.append(_typeClassname, "	");
        _builder.append(" ");
        String _name_10 = property_1.getName();
        _builder.append(_name_10, "	");
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
    String _name_11 = entity.getName();
    _builder.append(_name_11, "	");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    EList<Property> _properties_2 = entity.getProperties();
    final Function1<Property,Boolean> _function = new Function1<Property,Boolean>() {
        public Boolean apply(final Property p) {
          boolean _isReadonly = p.isReadonly();
          return ((Boolean)_isReadonly);
        }
      };
    Iterable<Property> _filter = IterableExtensions.<Property>filter(_properties_2, _function);
    Iterable<Property> readOnlyProperties = _filter;
    _builder.newLineIfNotEmpty();
    {
      boolean _isEmpty = IterableExtensions.isEmpty(readOnlyProperties);
      boolean _operator_not_10 = BooleanExtensions.operator_not(_isEmpty);
      if (_operator_not_10) {
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
        String _name_12 = entity.getName();
        _builder.append(_name_12, "	");
        _builder.append("(");
        {
          for(final Property property_2 : readOnlyProperties) {
            Type _type_5 = property_2.getType();
            String _javaClassname = _type_5.getJavaClassname();
            _builder.append(_javaClassname, "	");
            _builder.append(" ");
            String _name_13 = property_2.getName();
            String _firstLower = StringExtensions.toFirstLower(_name_13);
            _builder.append(_firstLower, "	");
            {
              Property _last = IterableExtensions.<Property>last(readOnlyProperties);
              boolean _operator_notEquals_3 = ObjectExtensions.operator_notEquals(_last, property_2);
              if (_operator_notEquals_3) {
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
          for(final Property property_3 : readOnlyProperties) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("this.");
            String _name_14 = property_3.getName();
            String _firstLower_1 = StringExtensions.toFirstLower(_name_14);
            _builder.append(_firstLower_1, "		");
            _builder.append(" = ");
            String _name_15 = property_3.getName();
            String _firstLower_2 = StringExtensions.toFirstLower(_name_15);
            _builder.append(_firstLower_2, "		");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Returns the automatically generated id the identifies this entity object.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
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
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* The property \'id\' is read-only. ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* This setter is only provided for Hibernate. ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* It must not be used directly.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
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
      EList<Property> _properties_3 = entity.getProperties();
      for(final Property property_4 : _properties_3) {
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(" ");
        _builder.append("* Returns the value of property \'");
        String _name_16 = property_4.getName();
        _builder.append(_name_16, "	 ");
        _builder.append("\'.");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        String _typeClassname_1 = property_4.getTypeClassname();
        _builder.append(_typeClassname_1, "	");
        _builder.append(" get");
        String _name_17 = property_4.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name_17);
        _builder.append(_firstUpper, "	");
        _builder.append("() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return ");
        String _name_18 = property_4.getName();
        _builder.append(_name_18, "		");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        {
          boolean _isReadonly_2 = property_4.isReadonly();
          if (_isReadonly_2) {
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* The property \'");
            String _name_19 = property_4.getName();
            _builder.append(_name_19, "	 ");
            _builder.append("\' is read-only. ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* This setter is only provided for Hibernate. ");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* It must not be used directly.");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("@Deprecated");
            _builder.newLine();} else {
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* Sets the value of property \'");
            String _name_20 = property_4.getName();
            _builder.append(_name_20, "	 ");
            _builder.append("\'.");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("*/");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("public void set");
        String _name_21 = property_4.getName();
        String _firstUpper_1 = StringExtensions.toFirstUpper(_name_21);
        _builder.append(_firstUpper_1, "	");
        _builder.append("(");
        String _typeClassname_2 = property_4.getTypeClassname();
        _builder.append(_typeClassname_2, "	");
        _builder.append(" newValue) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("this.");
        String _name_22 = property_4.getName();
        _builder.append(_name_22, "		");
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
  
  public StringConcatenation generateEnum(final String packageName, final Enum enumeration) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(packageName, "");
    _builder.append(".");
    _builder.append(HEDLCodegenConstants.ENTITY_PACKAGE_NAME, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// this class is generated. any change will be overridden.");
    _builder.newLine();
    _builder.append("public enum ");
    String _name = enumeration.getName();
    _builder.append(_name, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<EnumLiteral> _literals = enumeration.getLiterals();
      for(final EnumLiteral literal : _literals) {
        {
          String _comment = literal.getComment();
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_comment, null);
          if (_operator_notEquals) {
            _builder.append("\t");
            String _comment_1 = literal.getComment();
            String _replace = _comment_1.replace("\t", "");
            _builder.append(_replace, "	");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        String _name_1 = literal.getName();
        _builder.append(_name_1, "	");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
