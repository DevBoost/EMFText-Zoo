package org.emftext.language.template_concepts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;
import org.emftext.language.template_concepts.Placeholder;
import org.emftext.language.template_concepts.Template;
import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.IResourcePostProcessorProvider;
import org.emftext.runtime.resource.ITextResource;

/**
 * An ExpressionChecker can be used to check and evaluate OCL queries 
 * in templates. Examples for such queries are conditions (in IF elements),
 * collectionSelectors (in FOR loops) and the expressions in placeholders.
 * 
 * TODO when checking (and evaluating) OCL queries inside of (potentially
 * nested) loops, the context class is different. Instead of using the meta
 * class of the input model root element, we must use the type returned by
 * the collection that contains the expression.
 */
public class ExpressionChecker implements IOptionProvider, IResourcePostProcessor, IResourcePostProcessorProvider {

	public void process(ITextResource resource) {
		List<EObject> templates = getObjectsByType(resource, Template_conceptsPackage.eINSTANCE.getTemplate());
		if (templates.size() < 1) {
			return;
		}
		Template template = (Template) templates.get(0);
		EObject inputMetaClass = template.getInputMetaClass();
		EClass metaClass = (EClass) inputMetaClass;
		if (metaClass == null) {
			return;
		}
		
		List<EObject> placeholders = getObjectsByType(resource, Template_conceptsPackage.eINSTANCE.getPlaceholder());
		for (EObject next : placeholders) {
			Placeholder placeholder = (Placeholder) next;
			String expression = placeholder.getExpression();
			String error = parseExpression(metaClass, expression);
			if (error != null) {
				resource.addError("The expression \"" + expression + "\" is invalid (" + error + ").", placeholder);
			}
		}

		List<EObject> loops = getObjectsByType(resource, Template_conceptsPackage.eINSTANCE.getForLoop());
		for (EObject next : loops) {
			ForLoop loop = (ForLoop) next;
			String expression = loop.getCollection();
			String error = parseExpression(metaClass, expression);
			if (error != null) {
				resource.addError("The expression \"" + expression + "\" is invalid (" + error + ").", loop);
			}
		}

		List<EObject> conditions = getObjectsByType(resource, Template_conceptsPackage.eINSTANCE.getIfCondition());
		for (EObject next : conditions) {
			IfCondition condition = (IfCondition) next;
			String expression = condition.getCondition();
			String error = parseExpression(metaClass, expression);
			if (error != null) {
				resource.addError("The expression \"" + expression + "\" is invalid (" + error + ").", condition);
			}
		}
	}

	private List<EObject> getObjectsByType(ITextResource resource, EClass metaClass) {
		List<EObject> foundObjects = new ArrayList<EObject>();
		
		TreeIterator<EObject> contents = resource.getAllContents();
		while (contents.hasNext()) {
			EObject next = contents.next();
			if (metaClass.isInstance(next)) {
				foundObjects.add(next);
			}
		}
		return foundObjects;
	}

	// return the error if one was found
	private String parseExpression(EClass inputMetaClass, String expressionString) {
		Object query = createQuery(inputMetaClass, expressionString);
		if (query instanceof String) {
			return (String) query;
		} else {
			return null;
		}
	}

	public Object evaluateExpression(EClass inputMetaClass, String expressionString, EObject contextObject) {
		Object query = createQuery(inputMetaClass, expressionString);
		if (query instanceof Query) {
			return ((Query) query).evaluate(contextObject);
		} else {
			return null;
		}
	}

	private Object createQuery(EClass inputMetaClass, String expressionString) {
		OCL ocl = org.eclipse.ocl.ecore.OCL.newInstance();
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = ocl.createOCLHelper();
		
		helper.setContext(inputMetaClass);

		OCLExpression<EClassifier> expression;
		try {
			expression = helper.createQuery(expressionString);
			Query query = ocl.createQuery(expression);
			return query;
		} catch (ParserException e) {
			return e.getMessage();
		}
	}

	public IResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(IOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return options;
	}
}
