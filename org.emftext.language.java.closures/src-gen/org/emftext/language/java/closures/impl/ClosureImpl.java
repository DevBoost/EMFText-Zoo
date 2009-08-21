/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.java.closures.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.emftext.language.java.annotations.AnnotationValue;
import org.emftext.language.java.arrays.ArrayInitializationValue;
import org.emftext.language.java.arrays.ArraySelector;
import org.emftext.language.java.closures.Closure;
import org.emftext.language.java.closures.ClosuresPackage;
import org.emftext.language.java.expressions.AdditiveExpressionChild;
import org.emftext.language.java.expressions.AndExpressionChild;
import org.emftext.language.java.expressions.AssignmentExpressionChild;
import org.emftext.language.java.expressions.ConditionalAndExpressionChild;
import org.emftext.language.java.expressions.ConditionalExpressionChild;
import org.emftext.language.java.expressions.ConditionalOrExpressionChild;
import org.emftext.language.java.expressions.EqualityExpressionChild;
import org.emftext.language.java.expressions.ExclusiveOrExpressionChild;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.expressions.InclusiveOrExpressionChild;
import org.emftext.language.java.expressions.InstanceOfExpressionChild;
import org.emftext.language.java.expressions.MultiplicativeExpressionChild;
import org.emftext.language.java.expressions.PrimaryExpression;
import org.emftext.language.java.expressions.RelationExpressionChild;
import org.emftext.language.java.expressions.ShiftExpressionChild;
import org.emftext.language.java.expressions.UnaryExpressionChild;
import org.emftext.language.java.expressions.UnaryModificationExpressionChild;
import org.emftext.language.java.generics.GenericsPackage;
import org.emftext.language.java.generics.TypeArgument;
import org.emftext.language.java.generics.TypeArgumentable;
import org.emftext.language.java.parameters.impl.ParametrizableImpl;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.references.ReferencesPackage;
import org.emftext.language.java.statements.FeatureStatementListContainerStatements;
import org.emftext.language.java.statements.StatementListContainer;
import org.emftext.language.java.statements.StatementsPackage;
import org.emftext.language.java.types.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Closure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.java.closures.impl.ClosureImpl#getStatements <em>Statements</em>}</li>
 *   <li>{@link org.emftext.language.java.closures.impl.ClosureImpl#getTypeArguments <em>Type Arguments</em>}</li>
 *   <li>{@link org.emftext.language.java.closures.impl.ClosureImpl#getNext <em>Next</em>}</li>
 *   <li>{@link org.emftext.language.java.closures.impl.ClosureImpl#getArraySelectors <em>Array Selectors</em>}</li>
 *   <li>{@link org.emftext.language.java.closures.impl.ClosureImpl#getPrevious <em>Previous</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClosureImpl extends ParametrizableImpl implements Closure {
	/**
   * The cached value of the '{@link #getStatements() <em>Statements</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getStatements()
   * @generated
   * @ordered
   */
	protected EList<FeatureStatementListContainerStatements> statements;

	/**
   * The cached value of the '{@link #getTypeArguments() <em>Type Arguments</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeArguments()
   * @generated
   * @ordered
   */
  protected EList<TypeArgument> typeArguments;
  /**
   * The cached value of the '{@link #getNext() <em>Next</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNext()
   * @generated
   * @ordered
   */
  protected Reference next;
  /**
   * The cached value of the '{@link #getArraySelectors() <em>Array Selectors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArraySelectors()
   * @generated
   * @ordered
   */
  protected EList<ArraySelector> arraySelectors;

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected ClosureImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return ClosuresPackage.Literals.CLOSURE;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<FeatureStatementListContainerStatements> getStatements() {
    if (statements == null)
    {
      statements = new EObjectContainmentEList.Resolving<FeatureStatementListContainerStatements>(FeatureStatementListContainerStatements.class, this, ClosuresPackage.CLOSURE__STATEMENTS);
    }
    return statements;
  }

	/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TypeArgument> getTypeArguments()
  {
    if (typeArguments == null)
    {
      typeArguments = new EObjectContainmentEList.Resolving<TypeArgument>(TypeArgument.class, this, ClosuresPackage.CLOSURE__TYPE_ARGUMENTS);
    }
    return typeArguments;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Reference getNext()
  {
    if (next != null && next.eIsProxy())
    {
      InternalEObject oldNext = (InternalEObject)next;
      next = (Reference)eResolveProxy(oldNext);
      if (next != oldNext)
      {
        InternalEObject newNext = (InternalEObject)next;
        NotificationChain msgs =  oldNext.eInverseRemove(this, ReferencesPackage.REFERENCE__PREVIOUS, Reference.class, null);
        if (newNext.eInternalContainer() == null)
        {
          msgs =  newNext.eInverseAdd(this, ReferencesPackage.REFERENCE__PREVIOUS, Reference.class, msgs);
        }
        if (msgs != null) msgs.dispatch();
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClosuresPackage.CLOSURE__NEXT, oldNext, next));
      }
    }
    return next;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Reference basicGetNext()
  {
    return next;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNext(Reference newNext, NotificationChain msgs)
  {
    Reference oldNext = next;
    next = newNext;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClosuresPackage.CLOSURE__NEXT, oldNext, newNext);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNext(Reference newNext)
  {
    if (newNext != next)
    {
      NotificationChain msgs = null;
      if (next != null)
        msgs = ((InternalEObject)next).eInverseRemove(this, ReferencesPackage.REFERENCE__PREVIOUS, Reference.class, msgs);
      if (newNext != null)
        msgs = ((InternalEObject)newNext).eInverseAdd(this, ReferencesPackage.REFERENCE__PREVIOUS, Reference.class, msgs);
      msgs = basicSetNext(newNext, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClosuresPackage.CLOSURE__NEXT, newNext, newNext));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ArraySelector> getArraySelectors()
  {
    if (arraySelectors == null)
    {
      arraySelectors = new EObjectContainmentEList.Resolving<ArraySelector>(ArraySelector.class, this, ClosuresPackage.CLOSURE__ARRAY_SELECTORS);
    }
    return arraySelectors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Reference getPrevious()
  {
    if (eContainerFeatureID != ClosuresPackage.CLOSURE__PREVIOUS) return null;
    return (Reference)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Reference basicGetPrevious()
  {
    if (eContainerFeatureID != ClosuresPackage.CLOSURE__PREVIOUS) return null;
    return (Reference)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrevious(Reference newPrevious, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newPrevious, ClosuresPackage.CLOSURE__PREVIOUS, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrevious(Reference newPrevious)
  {
    if (newPrevious != eInternalContainer() || (eContainerFeatureID != ClosuresPackage.CLOSURE__PREVIOUS && newPrevious != null))
    {
      if (EcoreUtil.isAncestor(this, newPrevious))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newPrevious != null)
        msgs = ((InternalEObject)newPrevious).eInverseAdd(this, ReferencesPackage.REFERENCE__NEXT, Reference.class, msgs);
      msgs = basicSetPrevious(newPrevious, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClosuresPackage.CLOSURE__PREVIOUS, newPrevious, newPrevious));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getReferencedType()
  {
    if ( this instanceof org.emftext.language.java.literals.Literal ) { return ( ( org.emftext.language.java.literals.Literal ) this ) .getType ( ) ; } 
    org.emftext.language.java.types.Type type = null ; 
    //referenced element point to a type
    //element points to this or super
    if ( this instanceof org.emftext.language.java.types.TypedElement ) { org.emftext.language.java.types.TypeReference typeRef = ( ( org.emftext.language.java.types.TypedElement ) this ) .getTypeReference ( ) ; type = typeRef .getBoundTarget ( this ) ; } else //element points to the object's class object
    if ( this instanceof org.emftext.language.java.references.SelfReference ) { org.emftext.language.java.types.Type thisClass = null ; if ( this .getPrevious ( ) != null ) { thisClass = this .getPrevious ( ) .getReferencedType ( ) ; } else { org.emftext.language.java.classifiers.AnonymousClass anonymousContainer = getContainingAnonymousClass ( ) ; if ( anonymousContainer != null ) { thisClass = anonymousContainer ; } else { thisClass = getContainingConcreteClassifier ( ) ; } } //find super class if "self" is "super"
    if ( ( ( org.emftext.language.java.references.SelfReference ) this ) .getSelf ( ) instanceof org.emftext.language.java.literals.Super ) { if ( thisClass instanceof org.emftext.language.java.classifiers.Class ) { return ( ( org.emftext.language.java.classifiers.Class ) thisClass ) .getSuperClass ( ) ; } if ( thisClass instanceof org.emftext.language.java.classifiers.AnonymousClass ) { return ( ( org.emftext.language.java.classifiers.AnonymousClass ) thisClass ) .getSuperClassifier ( ) ; } } return thisClass ; } else //referenced element points to an element with a type
    if ( this instanceof org.emftext.language.java.references.ReflectiveClassReference ) { return getClassClass ( ) ; } else //Strings may also appear as reference
    if ( this instanceof org.emftext.language.java.references.ElementReference ) { org.emftext.language.java.references.ReferenceableElement target = ( org.emftext.language.java.references.ReferenceableElement ) ( ( org.emftext.language.java.references.ElementReference ) this ) .getTarget ( ) ; if ( target .eIsProxy ( ) ) { type = null ; } //Navigate through AdditionalLocalVariable or Field
    if ( target instanceof org.emftext.language.java.variables.AdditionalLocalVariable ) { target = ( org.emftext.language.java.references.ReferenceableElement ) target .eContainer ( ) ; } if ( target instanceof org.emftext.language.java.members.AdditionalField ) { target = ( org.emftext.language.java.references.ReferenceableElement ) target .eContainer ( ) ; } if ( target instanceof org.emftext.language.java.types.TypedElement ) { org.emftext.language.java.types.TypeReference typeRef = ( ( org.emftext.language.java.types.TypedElement ) target ) .getTypeReference ( ) ; if ( typeRef != null ) { type = typeRef .getBoundTarget ( this ) ; } } else /*e.g. Annotation*/if ( target instanceof org.emftext.language.java.types.Type ) { return ( org.emftext.language.java.types.Type ) target ; } else if ( target instanceof org.emftext.language.java.members.EnumConstant ) { type = ( org.emftext.language.java.classifiers.Enumeration ) target .eContainer ( ) ; } } else if ( this instanceof org.emftext.language.java.references.StringReference ) { return getStringClass ( ) ; } else if ( this instanceof org.emftext.language.java.expressions.NestedExpression ) { type = ( ( org.emftext.language.java.expressions.NestedExpression ) this ) .getExpression ( ) .getType ( ) ; } else if ( this instanceof org.emftext.language.java.references.PrimitiveTypeReference ) { type = ( ( org.emftext.language.java.references.PrimitiveTypeReference ) this ) .getPrimitiveType ( ) ; } else { assert ( false ) ; } 
    return type ; 
    
  }

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Type getType() {
    return getOneType ( false ) ; 
    
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Type getAlternativeType() {
    return getOneType ( true ) ; 
    
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Type getOneType(boolean alternative) {
    org.emftext.language.java.classifiers.Class stringClass = getStringClass ( ) ; 
    org.emftext.language.java.types.Type type = null ; 
    if ( this instanceof org.emftext.language.java.references.Reference ) { org.emftext.language.java.references.Reference reference = ( org.emftext.language.java.references.Reference ) this ; //navigate down references
    while ( reference .getNext ( ) != null ) { reference = reference .getNext ( ) ; } type = reference .getReferencedType ( ) ; } else if ( this instanceof org.emftext.language.java.literals.Literal ) { type = ( ( org.emftext.language.java.literals.Literal ) this ) .getType ( ) ; } else if ( this instanceof org.emftext.language.java.expressions.CastExpression ) { type = ( ( org.emftext.language.java.expressions.CastExpression ) this ) .getTypeReference ( ) .getTarget ( ) ; } else if ( this instanceof org.emftext.language.java.expressions.AssignmentExpression ) { type = ( ( org.emftext.language.java.expressions.AssignmentExpression ) this ) .getChild ( ) .getOneType ( alternative ) ; } else if ( this instanceof org.emftext.language.java.expressions.ConditionalExpression && ( ( org.emftext.language.java.expressions.ConditionalExpression ) this ) .getExpressionIf ( ) != null ) { if ( alternative ) { type = ( ( org.emftext.language.java.expressions.ConditionalExpression ) this ) .getExpressionElse ( ) .getOneType ( alternative ) ; } else { type = ( ( org.emftext.language.java.expressions.ConditionalExpression ) this ) .getExpressionIf ( ) .getOneType ( alternative ) ; } } else if ( this instanceof org.emftext.language.java.expressions.EqualityExpression || this instanceof org.emftext.language.java.expressions.RelationExpression || this instanceof org.emftext.language.java.expressions.ConditionalOrExpression || this instanceof org.emftext.language.java.expressions.ConditionalAndExpression || this instanceof org.emftext.language.java.expressions.InstanceOfExpression ) { type = getLibClass ( "Boolean" ) ; } else if ( this instanceof org.emftext.language.java.expressions.AdditiveExpression || this instanceof org.emftext.language.java.expressions.MultiplicativeExpression || this instanceof org.emftext.language.java.expressions.InclusiveOrExpression || this instanceof org.emftext.language.java.expressions.ExclusiveOrExpression || this instanceof org.emftext.language.java.expressions.AndExpression || this instanceof org.emftext.language.java.expressions.ShiftExpression ) { if ( this instanceof org.emftext.language.java.expressions.AdditiveExpression ) { org.emftext.language.java.expressions.AdditiveExpression additiveExpression = ( org.emftext.language.java.expressions.AdditiveExpression ) this ; for ( org.emftext.language.java.expressions.Expression subExp : additiveExpression .getChildren ( ) ) { if ( stringClass .equals ( subExp .getOneType ( alternative ) ) ) { //special case: string concatenation
    return stringClass ; } } } @ SuppressWarnings ( "unchecked" ) org.emftext.language.java.expressions.Expression subExp = ( ( org.eclipse.emf.common.util.EList < org.emftext.language.java.expressions.Expression > ) this .eGet ( this .eClass ( ) .getEStructuralFeature ( "children" ) ) ) .get ( 0 ) ; return subExp .getOneType ( alternative ) ; } else if ( this instanceof org.emftext.language.java.expressions.UnaryExpression ) { org.emftext.language.java.expressions.Expression subExp = ( ( org.emftext.language.java.expressions.UnaryExpression ) this ) .getChild ( ) ; return subExp .getOneType ( alternative ) ; } else for ( org.eclipse.emf.common.util.TreeIterator < org.eclipse.emf.ecore.EObject > i = this .eAllContents ( ) ; i .hasNext ( ) ; ) { org.eclipse.emf.ecore.EObject next = i .next ( ) ; org.emftext.language.java.types.Type nextType = null ; if ( next instanceof org.emftext.language.java.expressions.PrimaryExpression ) { if ( next instanceof org.emftext.language.java.references.Reference ) { org.emftext.language.java.references.Reference ref = ( org.emftext.language.java.references.Reference ) next ; //navigate down references
    while ( ref .getNext ( ) != null ) { ref = ref .getNext ( ) ; } next = ref ; } if ( next instanceof org.emftext.language.java.literals.Literal ) { nextType = ( ( org.emftext.language.java.literals.Literal ) next ) .getType ( ) ; } else if ( next instanceof org.emftext.language.java.expressions.CastExpression ) { nextType = ( ( org.emftext.language.java.expressions.CastExpression ) next ) .getTypeReference ( ) .getTarget ( ) ; } else { nextType = ( ( org.emftext.language.java.references.Reference ) next ) .getReferencedType ( ) ; } i .prune ( ) ; } if ( nextType != null ) { type = nextType ; //in the special case that this is an expression with
    //some string included, everything is converted to string
    if ( stringClass .equals ( type ) ) { break ; } } } 
    assert ( type != null ) ; 
    return type ; 
    
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public long getArrayDimension() {
    long size = 0 ; 
    org.emftext.language.java.arrays.ArrayTypeable arrayType = null ; 
    if ( this instanceof org.emftext.language.java.expressions.NestedExpression && ( ( org.emftext.language.java.expressions.NestedExpression ) this ) .getNext ( ) == null ) { return ( ( org.emftext.language.java.expressions.NestedExpression ) this ) .getExpression ( ) .getArrayDimension ( ) - ( ( org.emftext.language.java.expressions.NestedExpression ) this ) .getArraySelectors ( ) .size ( ) ; } 
    if ( this instanceof org.emftext.language.java.expressions.ConditionalExpression && ( ( org.emftext.language.java.expressions.ConditionalExpression ) this ) .getExpressionIf ( ) != null ) { return ( ( org.emftext.language.java.expressions.ConditionalExpression ) this ) .getExpressionIf ( ) .getArrayDimension ( ) ; } 
    if ( this instanceof org.emftext.language.java.expressions.AssignmentExpression ) { return ( ( org.emftext.language.java.expressions.AssignmentExpression ) this ) .getValue ( ) .getArrayDimension ( ) ; } 
    if ( this instanceof org.emftext.language.java.expressions.InstanceOfExpression ) { return 0 ; } 
    if ( this instanceof org.emftext.language.java.references.Reference ) { org.emftext.language.java.references.Reference reference = ( org.emftext.language.java.references.Reference ) this ; while ( reference .getNext ( ) != null ) { reference = reference .getNext ( ) ; } //an array clone? -> dimension defined by cloned array
    if ( reference instanceof org.emftext.language.java.references.ElementReference && reference .getPrevious ( ) != null ) { org.emftext.language.java.references.ReferenceableElement target = ( ( org.emftext.language.java.references.ElementReference ) reference ) .getTarget ( ) ; if ( target instanceof org.emftext.language.java.members.Method ) { if ( "clone" .equals ( ( ( org.emftext.language.java.members.Method ) target ) .getName ( ) ) ) { reference = ( org.emftext.language.java.references.Reference ) reference .eContainer ( ) ; } } } if ( reference instanceof org.emftext.language.java.references.ElementReference ) { org.emftext.language.java.references.ElementReference elementReference = ( org.emftext.language.java.references.ElementReference ) reference ; if ( elementReference .getTarget ( ) instanceof org.emftext.language.java.arrays.ArrayTypeable ) { arrayType = ( org.emftext.language.java.arrays.ArrayTypeable ) elementReference .getTarget ( ) ; } if ( elementReference .getTarget ( ) instanceof org.emftext.language.java.variables.AdditionalLocalVariable ) { org.emftext.language.java.variables.AdditionalLocalVariable additionalLocalVariable = ( org.emftext.language.java.variables.AdditionalLocalVariable ) elementReference .getTarget ( ) ; arrayType = ( org.emftext.language.java.variables.LocalVariable ) additionalLocalVariable .eContainer ( ) ; size += additionalLocalVariable .getArrayDimensionsAfter ( ) .size ( ) ; size -= arrayType .getArrayDimensionsAfter ( ) .size ( ) ; } if ( elementReference .getTarget ( ) instanceof org.emftext.language.java.members.AdditionalField ) { org.emftext.language.java.members.AdditionalField additionalField = ( org.emftext.language.java.members.AdditionalField ) elementReference .getTarget ( ) ; arrayType = ( org.emftext.language.java.members.Field ) additionalField .eContainer ( ) ; size += additionalField .getArrayDimensionsAfter ( ) .size ( ) ; size -= arrayType .getArrayDimensionsAfter ( ) .size ( ) ; } } else if ( this instanceof org.emftext.language.java.arrays.ArrayTypeable ) { size += ( ( org.emftext.language.java.arrays.ArrayTypeable ) this ) .getArrayDimensionsBefore ( ) .size ( ) + ( ( org.emftext.language.java.arrays.ArrayTypeable ) this ) .getArrayDimensionsAfter ( ) .size ( ) ; if ( this instanceof org.emftext.language.java.parameters.VariableLengthParameter ) { size ++ ; } } size -= reference .getArraySelectors ( ) .size ( ) ; } else if ( this instanceof org.emftext.language.java.arrays.ArrayTypeable ) { size += ( ( org.emftext.language.java.arrays.ArrayTypeable ) this ) .getArrayDimensionsBefore ( ) .size ( ) + ( ( org.emftext.language.java.arrays.ArrayTypeable ) this ) .getArrayDimensionsAfter ( ) .size ( ) ; if ( this instanceof org.emftext.language.java.parameters.VariableLengthParameter ) { size ++ ; } } 
    if ( this instanceof org.emftext.language.java.arrays.ArrayInstantiationBySize ) { size += ( ( org.emftext.language.java.arrays.ArrayInstantiationBySize ) this ) .getSizes ( ) .size ( ) ; } 
    if ( arrayType != null ) { size += arrayType .getArrayDimension ( ) ; } 
    return size ; 
    
  }

	/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ClosuresPackage.CLOSURE__NEXT:
        if (next != null)
          msgs = ((InternalEObject)next).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClosuresPackage.CLOSURE__NEXT, null, msgs);
        return basicSetNext((Reference)otherEnd, msgs);
      case ClosuresPackage.CLOSURE__PREVIOUS:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetPrevious((Reference)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID)
    {
      case ClosuresPackage.CLOSURE__STATEMENTS:
        return ((InternalEList<?>)getStatements()).basicRemove(otherEnd, msgs);
      case ClosuresPackage.CLOSURE__TYPE_ARGUMENTS:
        return ((InternalEList<?>)getTypeArguments()).basicRemove(otherEnd, msgs);
      case ClosuresPackage.CLOSURE__NEXT:
        return basicSetNext(null, msgs);
      case ClosuresPackage.CLOSURE__ARRAY_SELECTORS:
        return ((InternalEList<?>)getArraySelectors()).basicRemove(otherEnd, msgs);
      case ClosuresPackage.CLOSURE__PREVIOUS:
        return basicSetPrevious(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

	/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID)
    {
      case ClosuresPackage.CLOSURE__PREVIOUS:
        return eInternalContainer().eInverseRemove(this, ReferencesPackage.REFERENCE__NEXT, Reference.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID)
    {
      case ClosuresPackage.CLOSURE__STATEMENTS:
        return getStatements();
      case ClosuresPackage.CLOSURE__TYPE_ARGUMENTS:
        return getTypeArguments();
      case ClosuresPackage.CLOSURE__NEXT:
        if (resolve) return getNext();
        return basicGetNext();
      case ClosuresPackage.CLOSURE__ARRAY_SELECTORS:
        return getArraySelectors();
      case ClosuresPackage.CLOSURE__PREVIOUS:
        if (resolve) return getPrevious();
        return basicGetPrevious();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case ClosuresPackage.CLOSURE__STATEMENTS:
        getStatements().clear();
        getStatements().addAll((Collection<? extends FeatureStatementListContainerStatements>)newValue);
        return;
      case ClosuresPackage.CLOSURE__TYPE_ARGUMENTS:
        getTypeArguments().clear();
        getTypeArguments().addAll((Collection<? extends TypeArgument>)newValue);
        return;
      case ClosuresPackage.CLOSURE__NEXT:
        setNext((Reference)newValue);
        return;
      case ClosuresPackage.CLOSURE__ARRAY_SELECTORS:
        getArraySelectors().clear();
        getArraySelectors().addAll((Collection<? extends ArraySelector>)newValue);
        return;
      case ClosuresPackage.CLOSURE__PREVIOUS:
        setPrevious((Reference)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eUnset(int featureID) {
    switch (featureID)
    {
      case ClosuresPackage.CLOSURE__STATEMENTS:
        getStatements().clear();
        return;
      case ClosuresPackage.CLOSURE__TYPE_ARGUMENTS:
        getTypeArguments().clear();
        return;
      case ClosuresPackage.CLOSURE__NEXT:
        setNext((Reference)null);
        return;
      case ClosuresPackage.CLOSURE__ARRAY_SELECTORS:
        getArraySelectors().clear();
        return;
      case ClosuresPackage.CLOSURE__PREVIOUS:
        setPrevious((Reference)null);
        return;
    }
    super.eUnset(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public boolean eIsSet(int featureID) {
    switch (featureID)
    {
      case ClosuresPackage.CLOSURE__STATEMENTS:
        return statements != null && !statements.isEmpty();
      case ClosuresPackage.CLOSURE__TYPE_ARGUMENTS:
        return typeArguments != null && !typeArguments.isEmpty();
      case ClosuresPackage.CLOSURE__NEXT:
        return next != null;
      case ClosuresPackage.CLOSURE__ARRAY_SELECTORS:
        return arraySelectors != null && !arraySelectors.isEmpty();
      case ClosuresPackage.CLOSURE__PREVIOUS:
        return basicGetPrevious() != null;
    }
    return super.eIsSet(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
    if (baseClass == StatementListContainer.class)
    {
      switch (derivedFeatureID)
      {
        case ClosuresPackage.CLOSURE__STATEMENTS: return StatementsPackage.STATEMENT_LIST_CONTAINER__STATEMENTS;
        default: return -1;
      }
    }
    if (baseClass == ArrayInitializationValue.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == AnnotationValue.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == Expression.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == AssignmentExpressionChild.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == ConditionalExpressionChild.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == ConditionalOrExpressionChild.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == ConditionalAndExpressionChild.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == InclusiveOrExpressionChild.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == ExclusiveOrExpressionChild.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == AndExpressionChild.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == EqualityExpressionChild.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == InstanceOfExpressionChild.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == RelationExpressionChild.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == ShiftExpressionChild.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == AdditiveExpressionChild.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == MultiplicativeExpressionChild.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == UnaryExpressionChild.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == UnaryModificationExpressionChild.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == PrimaryExpression.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == TypeArgumentable.class)
    {
      switch (derivedFeatureID)
      {
        case ClosuresPackage.CLOSURE__TYPE_ARGUMENTS: return GenericsPackage.TYPE_ARGUMENTABLE__TYPE_ARGUMENTS;
        default: return -1;
      }
    }
    if (baseClass == Reference.class)
    {
      switch (derivedFeatureID)
      {
        case ClosuresPackage.CLOSURE__NEXT: return ReferencesPackage.REFERENCE__NEXT;
        case ClosuresPackage.CLOSURE__ARRAY_SELECTORS: return ReferencesPackage.REFERENCE__ARRAY_SELECTORS;
        case ClosuresPackage.CLOSURE__PREVIOUS: return ReferencesPackage.REFERENCE__PREVIOUS;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
    if (baseClass == StatementListContainer.class)
    {
      switch (baseFeatureID)
      {
        case StatementsPackage.STATEMENT_LIST_CONTAINER__STATEMENTS: return ClosuresPackage.CLOSURE__STATEMENTS;
        default: return -1;
      }
    }
    if (baseClass == ArrayInitializationValue.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == AnnotationValue.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == Expression.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == AssignmentExpressionChild.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == ConditionalExpressionChild.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == ConditionalOrExpressionChild.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == ConditionalAndExpressionChild.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == InclusiveOrExpressionChild.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == ExclusiveOrExpressionChild.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == AndExpressionChild.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == EqualityExpressionChild.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == InstanceOfExpressionChild.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == RelationExpressionChild.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == ShiftExpressionChild.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == AdditiveExpressionChild.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == MultiplicativeExpressionChild.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == UnaryExpressionChild.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == UnaryModificationExpressionChild.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == PrimaryExpression.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == TypeArgumentable.class)
    {
      switch (baseFeatureID)
      {
        case GenericsPackage.TYPE_ARGUMENTABLE__TYPE_ARGUMENTS: return ClosuresPackage.CLOSURE__TYPE_ARGUMENTS;
        default: return -1;
      }
    }
    if (baseClass == Reference.class)
    {
      switch (baseFeatureID)
      {
        case ReferencesPackage.REFERENCE__NEXT: return ClosuresPackage.CLOSURE__NEXT;
        case ReferencesPackage.REFERENCE__ARRAY_SELECTORS: return ClosuresPackage.CLOSURE__ARRAY_SELECTORS;
        case ReferencesPackage.REFERENCE__PREVIOUS: return ClosuresPackage.CLOSURE__PREVIOUS;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

} //ClosureImpl
