/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.pl0;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Relational Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.emftext.language.pl0.PL0Package#getRelationalOperator()
 * @model
 * @generated
 */
public enum RelationalOperator implements Enumerator {
	/**
   * The '<em><b>EQUAL</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #EQUAL_VALUE
   * @generated
   * @ordered
   */
	EQUAL(0, "EQUAL", "="),

	/**
   * The '<em><b>UNEQUAL</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #UNEQUAL_VALUE
   * @generated
   * @ordered
   */
	UNEQUAL(1, "UNEQUAL", "#"),

	/**
   * The '<em><b>LESS</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #LESS_VALUE
   * @generated
   * @ordered
   */
	LESS(2, "LESS", "<"),

	/**
   * The '<em><b>LESS EQUAL</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #LESS_EQUAL_VALUE
   * @generated
   * @ordered
   */
	LESS_EQUAL(3, "LESS_EQUAL", "<="),

	/**
   * The '<em><b>GREATER</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #GREATER_VALUE
   * @generated
   * @ordered
   */
	GREATER(4, "GREATER", ">"),

	/**
   * The '<em><b>GREATER EQUAL</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #GREATER_EQUAL_VALUE
   * @generated
   * @ordered
   */
	GREATER_EQUAL(5, "GREATER_EQUAL", ">=");

	/**
   * The '<em><b>EQUAL</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #EQUAL
   * @model literal="="
   * @generated
   * @ordered
   */
	public static final int EQUAL_VALUE = 0;

	/**
   * The '<em><b>UNEQUAL</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNEQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #UNEQUAL
   * @model literal="#"
   * @generated
   * @ordered
   */
	public static final int UNEQUAL_VALUE = 1;

	/**
   * The '<em><b>LESS</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LESS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #LESS
   * @model literal="<"
   * @generated
   * @ordered
   */
	public static final int LESS_VALUE = 2;

	/**
   * The '<em><b>LESS EQUAL</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LESS EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #LESS_EQUAL
   * @model literal="<="
   * @generated
   * @ordered
   */
	public static final int LESS_EQUAL_VALUE = 3;

	/**
   * The '<em><b>GREATER</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GREATER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #GREATER
   * @model literal=">"
   * @generated
   * @ordered
   */
	public static final int GREATER_VALUE = 4;

	/**
   * The '<em><b>GREATER EQUAL</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GREATER EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #GREATER_EQUAL
   * @model literal=">="
   * @generated
   * @ordered
   */
	public static final int GREATER_EQUAL_VALUE = 5;

	/**
   * An array of all the '<em><b>Relational Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private static final RelationalOperator[] VALUES_ARRAY =
		new RelationalOperator[]
    {
      EQUAL,
      UNEQUAL,
      LESS,
      LESS_EQUAL,
      GREATER,
      GREATER_EQUAL,
    };

	/**
   * A public read-only list of all the '<em><b>Relational Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static final List<RelationalOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
   * Returns the '<em><b>Relational Operator</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static RelationalOperator get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      RelationalOperator result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

	/**
   * Returns the '<em><b>Relational Operator</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static RelationalOperator getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      RelationalOperator result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

	/**
   * Returns the '<em><b>Relational Operator</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static RelationalOperator get(int value) {
    switch (value)
    {
      case EQUAL_VALUE: return EQUAL;
      case UNEQUAL_VALUE: return UNEQUAL;
      case LESS_VALUE: return LESS;
      case LESS_EQUAL_VALUE: return LESS_EQUAL;
      case GREATER_VALUE: return GREATER;
      case GREATER_EQUAL_VALUE: return GREATER_EQUAL;
    }
    return null;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private final int value;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private final String name;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private final String literal;

	/**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private RelationalOperator(int value, String name, String literal) {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public int getValue() {
    return value;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getName() {
    return name;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getLiteral() {
    return literal;
  }

	/**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public String toString() {
    return literal;
  }
	
} //RelationalOperator
