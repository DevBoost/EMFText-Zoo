/**
 * <copyright>
 * </copyright>
 *
 * 
 */
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
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		while (!interpretationStack.empty()) {
			org.eclipse.emf.ecore.EObject next = interpretationStack.pop();
			result = interprete(next, context);
			if (!continueInterpretation(result)) {
				break;
			}
		}
		return result;
	}
	
	/**
	 * Override this method to stop the overall interpretation depending on the result
	 * of the interpretation of a single model elements.
	 */
	public boolean continueInterpretation(ResultType result) {
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
	
	public ResultType interprete_org_emftext_language_bibtex_TitleField(org.emftext.language.bibtex.TitleField object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_bibtex_BookTitleField(org.emftext.language.bibtex.BookTitleField object, ContextType context) {
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
	
	public void addObjectToInterprete(org.eclipse.emf.ecore.EObject object) {
		interpretationStack.push(object);
	}
	
}
