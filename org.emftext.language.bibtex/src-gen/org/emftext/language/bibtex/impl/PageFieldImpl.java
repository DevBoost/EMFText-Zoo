/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.bibtex.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.bibtex.BibtexPackage;
import org.emftext.language.bibtex.Page;
import org.emftext.language.bibtex.PageField;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.bibtex.impl.PageFieldImpl#getFromPage <em>From Page</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.PageFieldImpl#getToPage <em>To Page</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PageFieldImpl extends FieldImpl implements PageField {
	/**
	 * The cached value of the '{@link #getFromPage() <em>From Page</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromPage()
	 * @generated
	 * @ordered
	 */
	protected Page fromPage;

	/**
	 * The cached value of the '{@link #getToPage() <em>To Page</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToPage()
	 * @generated
	 * @ordered
	 */
	protected Page toPage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PageFieldImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BibtexPackage.Literals.PAGE_FIELD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Page getFromPage() {
		return fromPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFromPage(Page newFromPage, NotificationChain msgs) {
		Page oldFromPage = fromPage;
		fromPage = newFromPage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.PAGE_FIELD__FROM_PAGE, oldFromPage, newFromPage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromPage(Page newFromPage) {
		if (newFromPage != fromPage) {
			NotificationChain msgs = null;
			if (fromPage != null)
				msgs = ((InternalEObject)fromPage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.PAGE_FIELD__FROM_PAGE, null, msgs);
			if (newFromPage != null)
				msgs = ((InternalEObject)newFromPage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.PAGE_FIELD__FROM_PAGE, null, msgs);
			msgs = basicSetFromPage(newFromPage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.PAGE_FIELD__FROM_PAGE, newFromPage, newFromPage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Page getToPage() {
		return toPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetToPage(Page newToPage, NotificationChain msgs) {
		Page oldToPage = toPage;
		toPage = newToPage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.PAGE_FIELD__TO_PAGE, oldToPage, newToPage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToPage(Page newToPage) {
		if (newToPage != toPage) {
			NotificationChain msgs = null;
			if (toPage != null)
				msgs = ((InternalEObject)toPage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.PAGE_FIELD__TO_PAGE, null, msgs);
			if (newToPage != null)
				msgs = ((InternalEObject)newToPage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.PAGE_FIELD__TO_PAGE, null, msgs);
			msgs = basicSetToPage(newToPage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.PAGE_FIELD__TO_PAGE, newToPage, newToPage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BibtexPackage.PAGE_FIELD__FROM_PAGE:
				return basicSetFromPage(null, msgs);
			case BibtexPackage.PAGE_FIELD__TO_PAGE:
				return basicSetToPage(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BibtexPackage.PAGE_FIELD__FROM_PAGE:
				return getFromPage();
			case BibtexPackage.PAGE_FIELD__TO_PAGE:
				return getToPage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BibtexPackage.PAGE_FIELD__FROM_PAGE:
				setFromPage((Page)newValue);
				return;
			case BibtexPackage.PAGE_FIELD__TO_PAGE:
				setToPage((Page)newValue);
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
		switch (featureID) {
			case BibtexPackage.PAGE_FIELD__FROM_PAGE:
				setFromPage((Page)null);
				return;
			case BibtexPackage.PAGE_FIELD__TO_PAGE:
				setToPage((Page)null);
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
		switch (featureID) {
			case BibtexPackage.PAGE_FIELD__FROM_PAGE:
				return fromPage != null;
			case BibtexPackage.PAGE_FIELD__TO_PAGE:
				return toPage != null;
		}
		return super.eIsSet(featureID);
	}

} //PageFieldImpl
