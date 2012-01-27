/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.util;

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
public class AbstractPlInterpreter<ResultType, ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	private java.util.List<org.emftext.language.prolog.resource.pl.IPlInterpreterListener> listeners = new java.util.ArrayList<org.emftext.language.prolog.resource.pl.IPlInterpreterListener>();
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
		if (object instanceof org.emftext.language.prolog.Conjunction) {
			result = interprete_org_emftext_language_prolog_Conjunction((org.emftext.language.prolog.Conjunction) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.prolog.Assignment) {
			result = interprete_org_emftext_language_prolog_Assignment((org.emftext.language.prolog.Assignment) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.prolog.Part) {
			result = interprete_org_emftext_language_prolog_Part((org.emftext.language.prolog.Part) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.prolog.Tail) {
			result = interprete_org_emftext_language_prolog_Tail((org.emftext.language.prolog.Tail) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.prolog.AnonymousVariable) {
			result = interprete_org_emftext_language_prolog_AnonymousVariable((org.emftext.language.prolog.AnonymousVariable) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.prolog.Expression) {
			result = interprete_org_emftext_language_prolog_Expression((org.emftext.language.prolog.Expression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.prolog.VariableReference) {
			result = interprete_org_emftext_language_prolog_VariableReference((org.emftext.language.prolog.VariableReference) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.prolog.Predicate) {
			result = interprete_org_emftext_language_prolog_Predicate((org.emftext.language.prolog.Predicate) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.prolog.List) {
			result = interprete_org_emftext_language_prolog_List((org.emftext.language.prolog.List) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.prolog.String) {
			result = interprete_org_emftext_language_prolog_String((org.emftext.language.prolog.String) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.prolog.SmallAtom) {
			result = interprete_org_emftext_language_prolog_SmallAtom((org.emftext.language.prolog.SmallAtom) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.prolog.Variable) {
			result = interprete_org_emftext_language_prolog_Variable((org.emftext.language.prolog.Variable) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.prolog.Numeral) {
			result = interprete_org_emftext_language_prolog_Numeral((org.emftext.language.prolog.Numeral) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.prolog.Atom) {
			result = interprete_org_emftext_language_prolog_Atom((org.emftext.language.prolog.Atom) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.prolog.Term) {
			result = interprete_org_emftext_language_prolog_Term((org.emftext.language.prolog.Term) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.prolog.Clause) {
			result = interprete_org_emftext_language_prolog_Clause((org.emftext.language.prolog.Clause) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.prolog.PrologProgram) {
			result = interprete_org_emftext_language_prolog_PrologProgram((org.emftext.language.prolog.PrologProgram) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_org_emftext_language_prolog_PrologProgram(org.emftext.language.prolog.PrologProgram prologProgram, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_prolog_Clause(org.emftext.language.prolog.Clause clause, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_prolog_Atom(org.emftext.language.prolog.Atom atom, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_prolog_Term(org.emftext.language.prolog.Term term, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_prolog_Numeral(org.emftext.language.prolog.Numeral numeral, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_prolog_Variable(org.emftext.language.prolog.Variable variable, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_prolog_SmallAtom(org.emftext.language.prolog.SmallAtom smallAtom, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_prolog_String(org.emftext.language.prolog.String string, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_prolog_List(org.emftext.language.prolog.List list, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_prolog_Predicate(org.emftext.language.prolog.Predicate predicate, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_prolog_VariableReference(org.emftext.language.prolog.VariableReference variableReference, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_prolog_Expression(org.emftext.language.prolog.Expression expression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_prolog_AnonymousVariable(org.emftext.language.prolog.AnonymousVariable anonymousVariable, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_prolog_Tail(org.emftext.language.prolog.Tail tail, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_prolog_Assignment(org.emftext.language.prolog.Assignment assignment, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_prolog_Conjunction(org.emftext.language.prolog.Conjunction conjunction, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_prolog_Part(org.emftext.language.prolog.Part part, ContextType context) {
		return null;
	}
	
	private void notifyListeners(org.eclipse.emf.ecore.EObject element) {
		for (org.emftext.language.prolog.resource.pl.IPlInterpreterListener listener : listeners) {
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
	
	public void addListener(org.emftext.language.prolog.resource.pl.IPlInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(org.emftext.language.prolog.resource.pl.IPlInterpreterListener listener) {
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
