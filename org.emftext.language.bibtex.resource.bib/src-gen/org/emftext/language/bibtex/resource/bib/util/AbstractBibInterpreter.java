/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.language.bibtex.resource.bib.util;

/**
 * This class provides basic infrastructure to interpret models. To implement
 * concrete interpreters, subclass this abstract interpreter and override the
 * interprete_* methods. The interpretation can be customized by binding the two
 * type parameters (ResultType, ContextType). The former is returned by all
 * interprete_* methods, while the latter is passed from method to method while
 * traversing the model. The concrete traversal strategy can also be exchanged.
 * One can use a static traversal strategy by pushing all objects to interpret on
 * the interpretation stack (using addObjectToInterprete()) before calling
 * interprete(). Alternatively, the traversal strategy can be dynamic by pushing
 * objects on the interpretation stack during interpretation.
 */
public class AbstractBibInterpreter<ResultType, ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	private java.util.List<org.emftext.language.bibtex.resource.bib.IBibInterpreterListener> listeners = new java.util.ArrayList<org.emftext.language.bibtex.resource.bib.IBibInterpreterListener>();
	private org.eclipse.emf.ecore.EObject nextObjectToInterprete;
	private Object currentContext;
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		org.eclipse.emf.ecore.EObject next = null;
		currentContext = context;
		while (!interpretationStack.empty()) {
			try {
				next = interpretationStack.pop();
			} catch (java.util.EmptyStackException ese) {
				// this can happen when the interpreter was terminated between the call to empty()
				// and pop()
				break;
			}
			nextObjectToInterprete = next;
			notifyListeners(next);
			result = interprete(next, context);
			if (!continueInterpretation(context, result)) {
				break;
			}
		}
		currentContext = null;
		return result;
	}
	
	/**
	 * Override this method to stop the overall interpretation depending on the result
	 * of the interpretation of a single model elements.
	 */
	public boolean continueInterpretation(ContextType context, ResultType result) {
		return true;
	}
	
	public ResultType interprete(org.eclipse.emf.ecore.EObject object, ContextType context) {
		ResultType result = null;
		if (object instanceof org.emftext.language.bibtex.Bibliography) {
			result = interprete_org_emftext_language_bibtex_Bibliography((org.emftext.language.bibtex.Bibliography) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.ArticleEntry) {
			result = interprete_org_emftext_language_bibtex_ArticleEntry((org.emftext.language.bibtex.ArticleEntry) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.InProceedingsEntry) {
			result = interprete_org_emftext_language_bibtex_InProceedingsEntry((org.emftext.language.bibtex.InProceedingsEntry) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.Entry) {
			result = interprete_org_emftext_language_bibtex_Entry((org.emftext.language.bibtex.Entry) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.ReviewField) {
			result = interprete_org_emftext_language_bibtex_ReviewField((org.emftext.language.bibtex.ReviewField) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.AbstractField) {
			result = interprete_org_emftext_language_bibtex_AbstractField((org.emftext.language.bibtex.AbstractField) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.KeywordField) {
			result = interprete_org_emftext_language_bibtex_KeywordField((org.emftext.language.bibtex.KeywordField) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.Keyword) {
			result = interprete_org_emftext_language_bibtex_Keyword((org.emftext.language.bibtex.Keyword) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.UrlField) {
			result = interprete_org_emftext_language_bibtex_UrlField((org.emftext.language.bibtex.UrlField) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.EidField) {
			result = interprete_org_emftext_language_bibtex_EidField((org.emftext.language.bibtex.EidField) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.PartField) {
			result = interprete_org_emftext_language_bibtex_PartField((org.emftext.language.bibtex.PartField) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.PublisherField) {
			result = interprete_org_emftext_language_bibtex_PublisherField((org.emftext.language.bibtex.PublisherField) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.NoteField) {
			result = interprete_org_emftext_language_bibtex_NoteField((org.emftext.language.bibtex.NoteField) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.OrganizationField) {
			result = interprete_org_emftext_language_bibtex_OrganizationField((org.emftext.language.bibtex.OrganizationField) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.MonthField) {
			result = interprete_org_emftext_language_bibtex_MonthField((org.emftext.language.bibtex.MonthField) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.AddressField) {
			result = interprete_org_emftext_language_bibtex_AddressField((org.emftext.language.bibtex.AddressField) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.SeriesField) {
			result = interprete_org_emftext_language_bibtex_SeriesField((org.emftext.language.bibtex.SeriesField) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.PageField) {
			result = interprete_org_emftext_language_bibtex_PageField((org.emftext.language.bibtex.PageField) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.VolumeField) {
			result = interprete_org_emftext_language_bibtex_VolumeField((org.emftext.language.bibtex.VolumeField) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.JournalField) {
			result = interprete_org_emftext_language_bibtex_JournalField((org.emftext.language.bibtex.JournalField) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.BibtexKeyField) {
			result = interprete_org_emftext_language_bibtex_BibtexKeyField((org.emftext.language.bibtex.BibtexKeyField) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.YearField) {
			result = interprete_org_emftext_language_bibtex_YearField((org.emftext.language.bibtex.YearField) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.NumberField) {
			result = interprete_org_emftext_language_bibtex_NumberField((org.emftext.language.bibtex.NumberField) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.BookTitleField) {
			result = interprete_org_emftext_language_bibtex_BookTitleField((org.emftext.language.bibtex.BookTitleField) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.TitleField) {
			result = interprete_org_emftext_language_bibtex_TitleField((org.emftext.language.bibtex.TitleField) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.EditorField) {
			result = interprete_org_emftext_language_bibtex_EditorField((org.emftext.language.bibtex.EditorField) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.AuthorField) {
			result = interprete_org_emftext_language_bibtex_AuthorField((org.emftext.language.bibtex.AuthorField) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.Field) {
			result = interprete_org_emftext_language_bibtex_Field((org.emftext.language.bibtex.Field) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.Page) {
			result = interprete_org_emftext_language_bibtex_Page((org.emftext.language.bibtex.Page) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.IntValue) {
			result = interprete_org_emftext_language_bibtex_IntValue((org.emftext.language.bibtex.IntValue) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.YearValue) {
			result = interprete_org_emftext_language_bibtex_YearValue((org.emftext.language.bibtex.YearValue) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.StringValue) {
			result = interprete_org_emftext_language_bibtex_StringValue((org.emftext.language.bibtex.StringValue) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.Editor) {
			result = interprete_org_emftext_language_bibtex_Editor((org.emftext.language.bibtex.Editor) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.Author) {
			result = interprete_org_emftext_language_bibtex_Author((org.emftext.language.bibtex.Author) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.bibtex.Person) {
			result = interprete_org_emftext_language_bibtex_Person((org.emftext.language.bibtex.Person) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_Person(org.emftext.language.bibtex.Person object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_Author(org.emftext.language.bibtex.Author object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_Editor(org.emftext.language.bibtex.Editor object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_StringValue(org.emftext.language.bibtex.StringValue object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_YearValue(org.emftext.language.bibtex.YearValue object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_IntValue(org.emftext.language.bibtex.IntValue object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_Page(org.emftext.language.bibtex.Page object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_Field(org.emftext.language.bibtex.Field object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_AuthorField(org.emftext.language.bibtex.AuthorField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_EditorField(org.emftext.language.bibtex.EditorField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_TitleField(org.emftext.language.bibtex.TitleField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_BookTitleField(org.emftext.language.bibtex.BookTitleField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_NumberField(org.emftext.language.bibtex.NumberField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_YearField(org.emftext.language.bibtex.YearField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_BibtexKeyField(org.emftext.language.bibtex.BibtexKeyField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_JournalField(org.emftext.language.bibtex.JournalField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_VolumeField(org.emftext.language.bibtex.VolumeField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_PageField(org.emftext.language.bibtex.PageField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_SeriesField(org.emftext.language.bibtex.SeriesField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_AddressField(org.emftext.language.bibtex.AddressField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_MonthField(org.emftext.language.bibtex.MonthField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_OrganizationField(org.emftext.language.bibtex.OrganizationField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_NoteField(org.emftext.language.bibtex.NoteField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_PublisherField(org.emftext.language.bibtex.PublisherField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_PartField(org.emftext.language.bibtex.PartField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_EidField(org.emftext.language.bibtex.EidField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_UrlField(org.emftext.language.bibtex.UrlField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_Keyword(org.emftext.language.bibtex.Keyword object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_KeywordField(org.emftext.language.bibtex.KeywordField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_AbstractField(org.emftext.language.bibtex.AbstractField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_ReviewField(org.emftext.language.bibtex.ReviewField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_Entry(org.emftext.language.bibtex.Entry object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_InProceedingsEntry(org.emftext.language.bibtex.InProceedingsEntry object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_ArticleEntry(org.emftext.language.bibtex.ArticleEntry object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_Bibliography(org.emftext.language.bibtex.Bibliography object, ContextType context) {
		return null;
	}
	
	private void notifyListeners(org.eclipse.emf.ecore.EObject element) {
		for (org.emftext.language.bibtex.resource.bib.IBibInterpreterListener listener : listeners) {
			listener.handleInterpreteObject(element);
		}
	}
	
	/**
	 * Adds the given object to the interpretation stack. Attention: Objects that are
	 * added first, are interpret last.
	 */
	public void addObjectToInterprete(org.eclipse.emf.ecore.EObject object) {
		interpretationStack.push(object);
	}
	
	/**
	 * Adds the given collection of objects to the interpretation stack. Attention:
	 * Collections that are added first, are interpret last.
	 */
	public void addObjectsToInterprete(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		for (org.eclipse.emf.ecore.EObject object : objects) {
			addObjectToInterprete(object);
		}
	}
	
	/**
	 * Adds the given collection of objects in reverse order to the interpretation
	 * stack.
	 */
	public void addObjectsToInterpreteInReverseOrder(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		java.util.List<org.eclipse.emf.ecore.EObject> reverse = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>(objects.size());
		reverse.addAll(objects);
		java.util.Collections.reverse(reverse);
		addObjectsToInterprete(reverse);
	}
	
	/**
	 * Adds the given object and all its children to the interpretation stack such
	 * that they are interpret in top down order.
	 */
	public void addObjectTreeToInterpreteTopDown(org.eclipse.emf.ecore.EObject root) {
		java.util.List<org.eclipse.emf.ecore.EObject> objects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
		objects.add(root);
		java.util.Iterator<org.eclipse.emf.ecore.EObject> it = root.eAllContents();
		while (it.hasNext()) {
			org.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) it.next();
			objects.add(eObject);
		}
		addObjectsToInterpreteInReverseOrder(objects);
	}
	
	public void addListener(org.emftext.language.bibtex.resource.bib.IBibInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(org.emftext.language.bibtex.resource.bib.IBibInterpreterListener listener) {
		return listeners.remove(listener);
	}
	
	public org.eclipse.emf.ecore.EObject getNextObjectToInterprete() {
		return nextObjectToInterprete;
	}
	
	public java.util.Stack<org.eclipse.emf.ecore.EObject> getInterpretationStack() {
		return interpretationStack;
	}
	
	public void terminate() {
		interpretationStack.clear();
	}
	
	public Object getCurrentContext() {
		return currentContext;
	}
	
}
