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

import org.emftext.language.bibtex.ArticleEntry;
import org.emftext.language.bibtex.AuthorField;
import org.emftext.language.bibtex.BibtexPackage;
import org.emftext.language.bibtex.EidField;
import org.emftext.language.bibtex.Field;
import org.emftext.language.bibtex.JournalField;
import org.emftext.language.bibtex.MonthField;
import org.emftext.language.bibtex.NoteField;
import org.emftext.language.bibtex.NumberField;
import org.emftext.language.bibtex.PageField;
import org.emftext.language.bibtex.PartField;
import org.emftext.language.bibtex.TitleField;
import org.emftext.language.bibtex.VolumeField;
import org.emftext.language.bibtex.YearField;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Article Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.bibtex.impl.ArticleEntryImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.ArticleEntryImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.ArticleEntryImpl#getYear <em>Year</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.ArticleEntryImpl#getJournal <em>Journal</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.ArticleEntryImpl#getPages <em>Pages</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.ArticleEntryImpl#getVolume <em>Volume</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.ArticleEntryImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.ArticleEntryImpl#getMonth <em>Month</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.ArticleEntryImpl#getNote <em>Note</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.ArticleEntryImpl#getPart <em>Part</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.impl.ArticleEntryImpl#getEid <em>Eid</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArticleEntryImpl extends EntryImpl implements ArticleEntry {
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
	 * The cached value of the '{@link #getYear() <em>Year</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYear()
	 * @generated
	 * @ordered
	 */
	protected YearField year;

	/**
	 * The cached value of the '{@link #getJournal() <em>Journal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJournal()
	 * @generated
	 * @ordered
	 */
	protected JournalField journal;

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
	 * The cached value of the '{@link #getMonth() <em>Month</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonth()
	 * @generated
	 * @ordered
	 */
	protected MonthField month;

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
	 * The cached value of the '{@link #getPart() <em>Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPart()
	 * @generated
	 * @ordered
	 */
	protected PartField part;

	/**
	 * The cached value of the '{@link #getEid() <em>Eid</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEid()
	 * @generated
	 * @ordered
	 */
	protected EidField eid;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArticleEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BibtexPackage.Literals.ARTICLE_ENTRY;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.ARTICLE_ENTRY__AUTHOR, oldAuthor, newAuthor);
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
				msgs = ((InternalEObject)author).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ARTICLE_ENTRY__AUTHOR, null, msgs);
			if (newAuthor != null)
				msgs = ((InternalEObject)newAuthor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ARTICLE_ENTRY__AUTHOR, null, msgs);
			msgs = basicSetAuthor(newAuthor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.ARTICLE_ENTRY__AUTHOR, newAuthor, newAuthor));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.ARTICLE_ENTRY__TITLE, oldTitle, newTitle);
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
				msgs = ((InternalEObject)title).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ARTICLE_ENTRY__TITLE, null, msgs);
			if (newTitle != null)
				msgs = ((InternalEObject)newTitle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ARTICLE_ENTRY__TITLE, null, msgs);
			msgs = basicSetTitle(newTitle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.ARTICLE_ENTRY__TITLE, newTitle, newTitle));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.ARTICLE_ENTRY__YEAR, oldYear, newYear);
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
				msgs = ((InternalEObject)year).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ARTICLE_ENTRY__YEAR, null, msgs);
			if (newYear != null)
				msgs = ((InternalEObject)newYear).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ARTICLE_ENTRY__YEAR, null, msgs);
			msgs = basicSetYear(newYear, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.ARTICLE_ENTRY__YEAR, newYear, newYear));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JournalField getJournal() {
		return journal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJournal(JournalField newJournal, NotificationChain msgs) {
		JournalField oldJournal = journal;
		journal = newJournal;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.ARTICLE_ENTRY__JOURNAL, oldJournal, newJournal);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJournal(JournalField newJournal) {
		if (newJournal != journal) {
			NotificationChain msgs = null;
			if (journal != null)
				msgs = ((InternalEObject)journal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ARTICLE_ENTRY__JOURNAL, null, msgs);
			if (newJournal != null)
				msgs = ((InternalEObject)newJournal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ARTICLE_ENTRY__JOURNAL, null, msgs);
			msgs = basicSetJournal(newJournal, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.ARTICLE_ENTRY__JOURNAL, newJournal, newJournal));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.ARTICLE_ENTRY__PAGES, oldPages, newPages);
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
				msgs = ((InternalEObject)pages).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ARTICLE_ENTRY__PAGES, null, msgs);
			if (newPages != null)
				msgs = ((InternalEObject)newPages).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ARTICLE_ENTRY__PAGES, null, msgs);
			msgs = basicSetPages(newPages, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.ARTICLE_ENTRY__PAGES, newPages, newPages));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.ARTICLE_ENTRY__VOLUME, oldVolume, newVolume);
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
				msgs = ((InternalEObject)volume).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ARTICLE_ENTRY__VOLUME, null, msgs);
			if (newVolume != null)
				msgs = ((InternalEObject)newVolume).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ARTICLE_ENTRY__VOLUME, null, msgs);
			msgs = basicSetVolume(newVolume, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.ARTICLE_ENTRY__VOLUME, newVolume, newVolume));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.ARTICLE_ENTRY__NUMBER, oldNumber, newNumber);
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
				msgs = ((InternalEObject)number).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ARTICLE_ENTRY__NUMBER, null, msgs);
			if (newNumber != null)
				msgs = ((InternalEObject)newNumber).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ARTICLE_ENTRY__NUMBER, null, msgs);
			msgs = basicSetNumber(newNumber, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.ARTICLE_ENTRY__NUMBER, newNumber, newNumber));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.ARTICLE_ENTRY__MONTH, oldMonth, newMonth);
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
				msgs = ((InternalEObject)month).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ARTICLE_ENTRY__MONTH, null, msgs);
			if (newMonth != null)
				msgs = ((InternalEObject)newMonth).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ARTICLE_ENTRY__MONTH, null, msgs);
			msgs = basicSetMonth(newMonth, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.ARTICLE_ENTRY__MONTH, newMonth, newMonth));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.ARTICLE_ENTRY__NOTE, oldNote, newNote);
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
				msgs = ((InternalEObject)note).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ARTICLE_ENTRY__NOTE, null, msgs);
			if (newNote != null)
				msgs = ((InternalEObject)newNote).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ARTICLE_ENTRY__NOTE, null, msgs);
			msgs = basicSetNote(newNote, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.ARTICLE_ENTRY__NOTE, newNote, newNote));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartField getPart() {
		return part;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPart(PartField newPart, NotificationChain msgs) {
		PartField oldPart = part;
		part = newPart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.ARTICLE_ENTRY__PART, oldPart, newPart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPart(PartField newPart) {
		if (newPart != part) {
			NotificationChain msgs = null;
			if (part != null)
				msgs = ((InternalEObject)part).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ARTICLE_ENTRY__PART, null, msgs);
			if (newPart != null)
				msgs = ((InternalEObject)newPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ARTICLE_ENTRY__PART, null, msgs);
			msgs = basicSetPart(newPart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.ARTICLE_ENTRY__PART, newPart, newPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EidField getEid() {
		return eid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEid(EidField newEid, NotificationChain msgs) {
		EidField oldEid = eid;
		eid = newEid;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.ARTICLE_ENTRY__EID, oldEid, newEid);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEid(EidField newEid) {
		if (newEid != eid) {
			NotificationChain msgs = null;
			if (eid != null)
				msgs = ((InternalEObject)eid).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ARTICLE_ENTRY__EID, null, msgs);
			if (newEid != null)
				msgs = ((InternalEObject)newEid).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ARTICLE_ENTRY__EID, null, msgs);
			msgs = basicSetEid(newEid, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.ARTICLE_ENTRY__EID, newEid, newEid));
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
		
				 org.emftext.language.bibtex.JournalField journalField = getJournal();
		
				 org.emftext.language.bibtex.VolumeField volumeField = getVolume();
		
				 org.emftext.language.bibtex.PageField pageField = getPages();
		
				
				result.add(titleField);
		
				result.add(authorField);
		
				result.add(yearField);
		
				result.add(journalField);
		
				result.add(volumeField);
		
				result.add(pageField);
		
				
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
			case BibtexPackage.ARTICLE_ENTRY__AUTHOR:
				return basicSetAuthor(null, msgs);
			case BibtexPackage.ARTICLE_ENTRY__TITLE:
				return basicSetTitle(null, msgs);
			case BibtexPackage.ARTICLE_ENTRY__YEAR:
				return basicSetYear(null, msgs);
			case BibtexPackage.ARTICLE_ENTRY__JOURNAL:
				return basicSetJournal(null, msgs);
			case BibtexPackage.ARTICLE_ENTRY__PAGES:
				return basicSetPages(null, msgs);
			case BibtexPackage.ARTICLE_ENTRY__VOLUME:
				return basicSetVolume(null, msgs);
			case BibtexPackage.ARTICLE_ENTRY__NUMBER:
				return basicSetNumber(null, msgs);
			case BibtexPackage.ARTICLE_ENTRY__MONTH:
				return basicSetMonth(null, msgs);
			case BibtexPackage.ARTICLE_ENTRY__NOTE:
				return basicSetNote(null, msgs);
			case BibtexPackage.ARTICLE_ENTRY__PART:
				return basicSetPart(null, msgs);
			case BibtexPackage.ARTICLE_ENTRY__EID:
				return basicSetEid(null, msgs);
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
			case BibtexPackage.ARTICLE_ENTRY__AUTHOR:
				return getAuthor();
			case BibtexPackage.ARTICLE_ENTRY__TITLE:
				return getTitle();
			case BibtexPackage.ARTICLE_ENTRY__YEAR:
				return getYear();
			case BibtexPackage.ARTICLE_ENTRY__JOURNAL:
				return getJournal();
			case BibtexPackage.ARTICLE_ENTRY__PAGES:
				return getPages();
			case BibtexPackage.ARTICLE_ENTRY__VOLUME:
				return getVolume();
			case BibtexPackage.ARTICLE_ENTRY__NUMBER:
				return getNumber();
			case BibtexPackage.ARTICLE_ENTRY__MONTH:
				return getMonth();
			case BibtexPackage.ARTICLE_ENTRY__NOTE:
				return getNote();
			case BibtexPackage.ARTICLE_ENTRY__PART:
				return getPart();
			case BibtexPackage.ARTICLE_ENTRY__EID:
				return getEid();
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
			case BibtexPackage.ARTICLE_ENTRY__AUTHOR:
				setAuthor((AuthorField)newValue);
				return;
			case BibtexPackage.ARTICLE_ENTRY__TITLE:
				setTitle((TitleField)newValue);
				return;
			case BibtexPackage.ARTICLE_ENTRY__YEAR:
				setYear((YearField)newValue);
				return;
			case BibtexPackage.ARTICLE_ENTRY__JOURNAL:
				setJournal((JournalField)newValue);
				return;
			case BibtexPackage.ARTICLE_ENTRY__PAGES:
				setPages((PageField)newValue);
				return;
			case BibtexPackage.ARTICLE_ENTRY__VOLUME:
				setVolume((VolumeField)newValue);
				return;
			case BibtexPackage.ARTICLE_ENTRY__NUMBER:
				setNumber((NumberField)newValue);
				return;
			case BibtexPackage.ARTICLE_ENTRY__MONTH:
				setMonth((MonthField)newValue);
				return;
			case BibtexPackage.ARTICLE_ENTRY__NOTE:
				setNote((NoteField)newValue);
				return;
			case BibtexPackage.ARTICLE_ENTRY__PART:
				setPart((PartField)newValue);
				return;
			case BibtexPackage.ARTICLE_ENTRY__EID:
				setEid((EidField)newValue);
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
			case BibtexPackage.ARTICLE_ENTRY__AUTHOR:
				setAuthor((AuthorField)null);
				return;
			case BibtexPackage.ARTICLE_ENTRY__TITLE:
				setTitle((TitleField)null);
				return;
			case BibtexPackage.ARTICLE_ENTRY__YEAR:
				setYear((YearField)null);
				return;
			case BibtexPackage.ARTICLE_ENTRY__JOURNAL:
				setJournal((JournalField)null);
				return;
			case BibtexPackage.ARTICLE_ENTRY__PAGES:
				setPages((PageField)null);
				return;
			case BibtexPackage.ARTICLE_ENTRY__VOLUME:
				setVolume((VolumeField)null);
				return;
			case BibtexPackage.ARTICLE_ENTRY__NUMBER:
				setNumber((NumberField)null);
				return;
			case BibtexPackage.ARTICLE_ENTRY__MONTH:
				setMonth((MonthField)null);
				return;
			case BibtexPackage.ARTICLE_ENTRY__NOTE:
				setNote((NoteField)null);
				return;
			case BibtexPackage.ARTICLE_ENTRY__PART:
				setPart((PartField)null);
				return;
			case BibtexPackage.ARTICLE_ENTRY__EID:
				setEid((EidField)null);
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
			case BibtexPackage.ARTICLE_ENTRY__AUTHOR:
				return author != null;
			case BibtexPackage.ARTICLE_ENTRY__TITLE:
				return title != null;
			case BibtexPackage.ARTICLE_ENTRY__YEAR:
				return year != null;
			case BibtexPackage.ARTICLE_ENTRY__JOURNAL:
				return journal != null;
			case BibtexPackage.ARTICLE_ENTRY__PAGES:
				return pages != null;
			case BibtexPackage.ARTICLE_ENTRY__VOLUME:
				return volume != null;
			case BibtexPackage.ARTICLE_ENTRY__NUMBER:
				return number != null;
			case BibtexPackage.ARTICLE_ENTRY__MONTH:
				return month != null;
			case BibtexPackage.ARTICLE_ENTRY__NOTE:
				return note != null;
			case BibtexPackage.ARTICLE_ENTRY__PART:
				return part != null;
			case BibtexPackage.ARTICLE_ENTRY__EID:
				return eid != null;
		}
		return super.eIsSet(featureID);
	}

} //ArticleEntryImpl
