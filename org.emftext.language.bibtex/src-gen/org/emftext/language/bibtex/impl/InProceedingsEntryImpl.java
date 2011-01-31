/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.bibtex.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.bibtex.AddressField;
import org.emftext.language.bibtex.AuthorField;
import org.emftext.language.bibtex.BibtexPackage;
import org.emftext.language.bibtex.BookTitleField;
import org.emftext.language.bibtex.EditorField;
import org.emftext.language.bibtex.Field;
import org.emftext.language.bibtex.InProceedingsEntry;
import org.emftext.language.bibtex.MonthField;
import org.emftext.language.bibtex.NoteField;
import org.emftext.language.bibtex.NumberField;
import org.emftext.language.bibtex.OrganizationField;
import org.emftext.language.bibtex.PageField;
import org.emftext.language.bibtex.PublisherField;
import org.emftext.language.bibtex.SeriesField;
import org.emftext.language.bibtex.TitleField;
import org.emftext.language.bibtex.VolumeField;
import org.emftext.language.bibtex.YearField;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>In Proceedings Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.bibtex.impl.InProceedingsEntryImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.InProceedingsEntryImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.InProceedingsEntryImpl#getBookTitle <em>Book Title</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.InProceedingsEntryImpl#getYear <em>Year</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.InProceedingsEntryImpl#getEditor <em>Editor</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.InProceedingsEntryImpl#getPages <em>Pages</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.InProceedingsEntryImpl#getVolume <em>Volume</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.InProceedingsEntryImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.InProceedingsEntryImpl#getSeries <em>Series</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.InProceedingsEntryImpl#getAddress <em>Address</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.InProceedingsEntryImpl#getMonth <em>Month</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.InProceedingsEntryImpl#getOrganization <em>Organization</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.InProceedingsEntryImpl#getNote <em>Note</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.InProceedingsEntryImpl#getPublisher <em>Publisher</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InProceedingsEntryImpl extends EntryImpl implements InProceedingsEntry {
	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected AuthorField author;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected TitleField title;

	/**
	 * The cached value of the '{@link #getBookTitle() <em>Book Title</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBookTitle()
	 * @generated
	 * @ordered
	 */
	protected BookTitleField bookTitle;

	/**
	 * The cached value of the '{@link #getYear() <em>Year</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYear()
	 * @generated
	 * @ordered
	 */
	protected YearField year;

	/**
	 * The cached value of the '{@link #getEditor() <em>Editor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditor()
	 * @generated
	 * @ordered
	 */
	protected EditorField editor;

	/**
	 * The cached value of the '{@link #getPages() <em>Pages</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPages()
	 * @generated
	 * @ordered
	 */
	protected PageField pages;

	/**
	 * The cached value of the '{@link #getVolume() <em>Volume</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVolume()
	 * @generated
	 * @ordered
	 */
	protected VolumeField volume;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected NumberField number;

	/**
	 * The cached value of the '{@link #getSeries() <em>Series</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeries()
	 * @generated
	 * @ordered
	 */
	protected SeriesField series;

	/**
	 * The cached value of the '{@link #getAddress() <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected AddressField address;

	/**
	 * The cached value of the '{@link #getMonth() <em>Month</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonth()
	 * @generated
	 * @ordered
	 */
	protected MonthField month;

	/**
	 * The cached value of the '{@link #getOrganization() <em>Organization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrganization()
	 * @generated
	 * @ordered
	 */
	protected OrganizationField organization;

	/**
	 * The cached value of the '{@link #getNote() <em>Note</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNote()
	 * @generated
	 * @ordered
	 */
	protected NoteField note;

	/**
	 * The cached value of the '{@link #getPublisher() <em>Publisher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublisher()
	 * @generated
	 * @ordered
	 */
	protected PublisherField publisher;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InProceedingsEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BibtexPackage.Literals.IN_PROCEEDINGS_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuthorField getAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAuthor(AuthorField newAuthor, NotificationChain msgs) {
		AuthorField oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__AUTHOR, oldAuthor, newAuthor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthor(AuthorField newAuthor) {
		if (newAuthor != author) {
			NotificationChain msgs = null;
			if (author != null)
				msgs = ((InternalEObject)author).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__AUTHOR, null, msgs);
			if (newAuthor != null)
				msgs = ((InternalEObject)newAuthor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__AUTHOR, null, msgs);
			msgs = basicSetAuthor(newAuthor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__AUTHOR, newAuthor, newAuthor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TitleField getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTitle(TitleField newTitle, NotificationChain msgs) {
		TitleField oldTitle = title;
		title = newTitle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__TITLE, oldTitle, newTitle);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(TitleField newTitle) {
		if (newTitle != title) {
			NotificationChain msgs = null;
			if (title != null)
				msgs = ((InternalEObject)title).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__TITLE, null, msgs);
			if (newTitle != null)
				msgs = ((InternalEObject)newTitle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__TITLE, null, msgs);
			msgs = basicSetTitle(newTitle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__TITLE, newTitle, newTitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BookTitleField getBookTitle() {
		return bookTitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBookTitle(BookTitleField newBookTitle, NotificationChain msgs) {
		BookTitleField oldBookTitle = bookTitle;
		bookTitle = newBookTitle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__BOOK_TITLE, oldBookTitle, newBookTitle);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBookTitle(BookTitleField newBookTitle) {
		if (newBookTitle != bookTitle) {
			NotificationChain msgs = null;
			if (bookTitle != null)
				msgs = ((InternalEObject)bookTitle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__BOOK_TITLE, null, msgs);
			if (newBookTitle != null)
				msgs = ((InternalEObject)newBookTitle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__BOOK_TITLE, null, msgs);
			msgs = basicSetBookTitle(newBookTitle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__BOOK_TITLE, newBookTitle, newBookTitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public YearField getYear() {
		return year;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetYear(YearField newYear, NotificationChain msgs) {
		YearField oldYear = year;
		year = newYear;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__YEAR, oldYear, newYear);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYear(YearField newYear) {
		if (newYear != year) {
			NotificationChain msgs = null;
			if (year != null)
				msgs = ((InternalEObject)year).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__YEAR, null, msgs);
			if (newYear != null)
				msgs = ((InternalEObject)newYear).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__YEAR, null, msgs);
			msgs = basicSetYear(newYear, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__YEAR, newYear, newYear));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditorField getEditor() {
		return editor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEditor(EditorField newEditor, NotificationChain msgs) {
		EditorField oldEditor = editor;
		editor = newEditor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__EDITOR, oldEditor, newEditor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditor(EditorField newEditor) {
		if (newEditor != editor) {
			NotificationChain msgs = null;
			if (editor != null)
				msgs = ((InternalEObject)editor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__EDITOR, null, msgs);
			if (newEditor != null)
				msgs = ((InternalEObject)newEditor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__EDITOR, null, msgs);
			msgs = basicSetEditor(newEditor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__EDITOR, newEditor, newEditor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageField getPages() {
		return pages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPages(PageField newPages, NotificationChain msgs) {
		PageField oldPages = pages;
		pages = newPages;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__PAGES, oldPages, newPages);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPages(PageField newPages) {
		if (newPages != pages) {
			NotificationChain msgs = null;
			if (pages != null)
				msgs = ((InternalEObject)pages).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__PAGES, null, msgs);
			if (newPages != null)
				msgs = ((InternalEObject)newPages).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__PAGES, null, msgs);
			msgs = basicSetPages(newPages, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__PAGES, newPages, newPages));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VolumeField getVolume() {
		return volume;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVolume(VolumeField newVolume, NotificationChain msgs) {
		VolumeField oldVolume = volume;
		volume = newVolume;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__VOLUME, oldVolume, newVolume);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVolume(VolumeField newVolume) {
		if (newVolume != volume) {
			NotificationChain msgs = null;
			if (volume != null)
				msgs = ((InternalEObject)volume).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__VOLUME, null, msgs);
			if (newVolume != null)
				msgs = ((InternalEObject)newVolume).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__VOLUME, null, msgs);
			msgs = basicSetVolume(newVolume, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__VOLUME, newVolume, newVolume));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberField getNumber() {
		return number;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNumber(NumberField newNumber, NotificationChain msgs) {
		NumberField oldNumber = number;
		number = newNumber;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__NUMBER, oldNumber, newNumber);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumber(NumberField newNumber) {
		if (newNumber != number) {
			NotificationChain msgs = null;
			if (number != null)
				msgs = ((InternalEObject)number).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__NUMBER, null, msgs);
			if (newNumber != null)
				msgs = ((InternalEObject)newNumber).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__NUMBER, null, msgs);
			msgs = basicSetNumber(newNumber, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__NUMBER, newNumber, newNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeriesField getSeries() {
		return series;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSeries(SeriesField newSeries, NotificationChain msgs) {
		SeriesField oldSeries = series;
		series = newSeries;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__SERIES, oldSeries, newSeries);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeries(SeriesField newSeries) {
		if (newSeries != series) {
			NotificationChain msgs = null;
			if (series != null)
				msgs = ((InternalEObject)series).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__SERIES, null, msgs);
			if (newSeries != null)
				msgs = ((InternalEObject)newSeries).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__SERIES, null, msgs);
			msgs = basicSetSeries(newSeries, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__SERIES, newSeries, newSeries));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressField getAddress() {
		return address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAddress(AddressField newAddress, NotificationChain msgs) {
		AddressField oldAddress = address;
		address = newAddress;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__ADDRESS, oldAddress, newAddress);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddress(AddressField newAddress) {
		if (newAddress != address) {
			NotificationChain msgs = null;
			if (address != null)
				msgs = ((InternalEObject)address).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__ADDRESS, null, msgs);
			if (newAddress != null)
				msgs = ((InternalEObject)newAddress).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__ADDRESS, null, msgs);
			msgs = basicSetAddress(newAddress, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__ADDRESS, newAddress, newAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MonthField getMonth() {
		return month;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMonth(MonthField newMonth, NotificationChain msgs) {
		MonthField oldMonth = month;
		month = newMonth;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__MONTH, oldMonth, newMonth);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMonth(MonthField newMonth) {
		if (newMonth != month) {
			NotificationChain msgs = null;
			if (month != null)
				msgs = ((InternalEObject)month).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__MONTH, null, msgs);
			if (newMonth != null)
				msgs = ((InternalEObject)newMonth).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__MONTH, null, msgs);
			msgs = basicSetMonth(newMonth, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__MONTH, newMonth, newMonth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationField getOrganization() {
		return organization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOrganization(OrganizationField newOrganization, NotificationChain msgs) {
		OrganizationField oldOrganization = organization;
		organization = newOrganization;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__ORGANIZATION, oldOrganization, newOrganization);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrganization(OrganizationField newOrganization) {
		if (newOrganization != organization) {
			NotificationChain msgs = null;
			if (organization != null)
				msgs = ((InternalEObject)organization).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__ORGANIZATION, null, msgs);
			if (newOrganization != null)
				msgs = ((InternalEObject)newOrganization).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__ORGANIZATION, null, msgs);
			msgs = basicSetOrganization(newOrganization, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__ORGANIZATION, newOrganization, newOrganization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NoteField getNote() {
		return note;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNote(NoteField newNote, NotificationChain msgs) {
		NoteField oldNote = note;
		note = newNote;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__NOTE, oldNote, newNote);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNote(NoteField newNote) {
		if (newNote != note) {
			NotificationChain msgs = null;
			if (note != null)
				msgs = ((InternalEObject)note).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__NOTE, null, msgs);
			if (newNote != null)
				msgs = ((InternalEObject)newNote).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__NOTE, null, msgs);
			msgs = basicSetNote(newNote, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__NOTE, newNote, newNote));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublisherField getPublisher() {
		return publisher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPublisher(PublisherField newPublisher, NotificationChain msgs) {
		PublisherField oldPublisher = publisher;
		publisher = newPublisher;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__PUBLISHER, oldPublisher, newPublisher);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublisher(PublisherField newPublisher) {
		if (newPublisher != publisher) {
			NotificationChain msgs = null;
			if (publisher != null)
				msgs = ((InternalEObject)publisher).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__PUBLISHER, null, msgs);
			if (newPublisher != null)
				msgs = ((InternalEObject)newPublisher).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.IN_PROCEEDINGS_ENTRY__PUBLISHER, null, msgs);
			msgs = basicSetPublisher(newPublisher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_PROCEEDINGS_ENTRY__PUBLISHER, newPublisher, newPublisher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Field> getFields() {
		
				 org.eclipse.emf.common.util.EList< org.emftext.language.bibtex.Field> result = new  org.eclipse.emf.common.util.BasicEList< org.emftext.language.bibtex.Field>();
		
				
				 org.emftext.language.bibtex.TitleField titleField = getTitle();
		
				 org.emftext.language.bibtex.AuthorField authorField = getAuthor();
		
				 org.emftext.language.bibtex.YearField yearField = getYear();
		
				 org.emftext.language.bibtex.BookTitleField bookTitleField = getBookTitle();
		
				
				result.add(titleField);
		
				result.add(authorField);
		
				result.add(yearField);
		
				result.add(bookTitleField);
		
				
				return result;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__AUTHOR:
				return basicSetAuthor(null, msgs);
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__TITLE:
				return basicSetTitle(null, msgs);
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__BOOK_TITLE:
				return basicSetBookTitle(null, msgs);
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__YEAR:
				return basicSetYear(null, msgs);
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__EDITOR:
				return basicSetEditor(null, msgs);
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__PAGES:
				return basicSetPages(null, msgs);
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__VOLUME:
				return basicSetVolume(null, msgs);
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__NUMBER:
				return basicSetNumber(null, msgs);
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__SERIES:
				return basicSetSeries(null, msgs);
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__ADDRESS:
				return basicSetAddress(null, msgs);
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__MONTH:
				return basicSetMonth(null, msgs);
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__ORGANIZATION:
				return basicSetOrganization(null, msgs);
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__NOTE:
				return basicSetNote(null, msgs);
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__PUBLISHER:
				return basicSetPublisher(null, msgs);
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
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__AUTHOR:
				return getAuthor();
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__TITLE:
				return getTitle();
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__BOOK_TITLE:
				return getBookTitle();
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__YEAR:
				return getYear();
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__EDITOR:
				return getEditor();
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__PAGES:
				return getPages();
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__VOLUME:
				return getVolume();
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__NUMBER:
				return getNumber();
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__SERIES:
				return getSeries();
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__ADDRESS:
				return getAddress();
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__MONTH:
				return getMonth();
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__ORGANIZATION:
				return getOrganization();
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__NOTE:
				return getNote();
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__PUBLISHER:
				return getPublisher();
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
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__AUTHOR:
				setAuthor((AuthorField)newValue);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__TITLE:
				setTitle((TitleField)newValue);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__BOOK_TITLE:
				setBookTitle((BookTitleField)newValue);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__YEAR:
				setYear((YearField)newValue);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__EDITOR:
				setEditor((EditorField)newValue);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__PAGES:
				setPages((PageField)newValue);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__VOLUME:
				setVolume((VolumeField)newValue);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__NUMBER:
				setNumber((NumberField)newValue);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__SERIES:
				setSeries((SeriesField)newValue);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__ADDRESS:
				setAddress((AddressField)newValue);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__MONTH:
				setMonth((MonthField)newValue);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__ORGANIZATION:
				setOrganization((OrganizationField)newValue);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__NOTE:
				setNote((NoteField)newValue);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__PUBLISHER:
				setPublisher((PublisherField)newValue);
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
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__AUTHOR:
				setAuthor((AuthorField)null);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__TITLE:
				setTitle((TitleField)null);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__BOOK_TITLE:
				setBookTitle((BookTitleField)null);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__YEAR:
				setYear((YearField)null);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__EDITOR:
				setEditor((EditorField)null);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__PAGES:
				setPages((PageField)null);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__VOLUME:
				setVolume((VolumeField)null);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__NUMBER:
				setNumber((NumberField)null);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__SERIES:
				setSeries((SeriesField)null);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__ADDRESS:
				setAddress((AddressField)null);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__MONTH:
				setMonth((MonthField)null);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__ORGANIZATION:
				setOrganization((OrganizationField)null);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__NOTE:
				setNote((NoteField)null);
				return;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__PUBLISHER:
				setPublisher((PublisherField)null);
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
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__AUTHOR:
				return author != null;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__TITLE:
				return title != null;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__BOOK_TITLE:
				return bookTitle != null;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__YEAR:
				return year != null;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__EDITOR:
				return editor != null;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__PAGES:
				return pages != null;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__VOLUME:
				return volume != null;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__NUMBER:
				return number != null;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__SERIES:
				return series != null;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__ADDRESS:
				return address != null;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__MONTH:
				return month != null;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__ORGANIZATION:
				return organization != null;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__NOTE:
				return note != null;
			case BibtexPackage.IN_PROCEEDINGS_ENTRY__PUBLISHER:
				return publisher != null;
		}
		return super.eIsSet(featureID);
	}

} //InProceedingsEntryImpl
