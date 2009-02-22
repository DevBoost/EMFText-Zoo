package org.emftext.language.java.resource.java.analysis.helper;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.annotations.AnnotationAttributeSetting;
import org.emftext.language.java.annotations.AnnotationInstance;
import org.emftext.language.java.expressions.AdditiveExpression;
import org.emftext.language.java.expressions.CastExpression;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.expressions.ExpressionsFactory;
import org.emftext.language.java.expressions.NestedExpression;
import org.emftext.language.java.expressions.PrimaryExpression;
import org.emftext.language.java.expressions.UnaryExpression;
import org.emftext.language.java.operators.Addition;
import org.emftext.language.java.operators.OperatorsFactory;
import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.references.ReferencesFactory;
import org.emftext.language.java.references.ReferencesPackage;
import org.emftext.language.java.resource.java.JavaReferenceResolverSwitch;
import org.emftext.language.java.types.NamespaceClassifierReference;
import org.emftext.language.java.types.PrimitiveType;
import org.emftext.language.java.types.TypesPackage;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.IResourcePostProcessorProvider;
import org.emftext.runtime.resource.IContextDependentURIFragment;
import org.emftext.runtime.resource.ITextResource;

public class ExpressionSimplifier implements IResourcePostProcessor, IResourcePostProcessorProvider {

	private static final ExpressionSimplifier theSimplifier = new ExpressionSimplifier();
	
	public IResourcePostProcessor getResourcePostProcessor() {
		return theSimplifier;
	}
	
	public void process(ITextResource resource) {
		repairWrongCasts(resource);
		simplifyDown(resource.getContents());
	}
	
	public void simplifyDown(EList<EObject> parentList) {
		for(EObject child : new BasicEList<EObject>(parentList)) {
			EObject singleContained = getSingleContained(child);
			EObject next = singleContained;
			while (next != null) {
				next = getSingleContained(singleContained);
				if (next != null) {
					singleContained = next;
				}
			}
			if (singleContained != null) {
				EcoreUtil.replace(child, singleContained);
				child = singleContained;
			}
			simplifyDown(child.eContents());
		}
	}

	
	public EObject getSingleContained(EObject parent) {
		if (parent.eContainer() instanceof AnnotationInstance ||
				parent.eContainer() instanceof AnnotationAttributeSetting) {
			//special case. Might be changed in the future.
			return null;
		}
		if (!(parent instanceof Expression)) {
			return null;
		}
		//never kill a primary
		if (parent instanceof PrimaryExpression) {
			return null;
		}
		
		EObject singleContained = null;
		for(EObject contained : parent.eContents()) {
			if (singleContained != null) {
				return null;
			}
			singleContained = contained;
		}
		if (!(singleContained instanceof Expression)) {
			return null;
		}

		return singleContained;
	}

	public void repairWrongCasts(Resource resource) {
		for(Iterator<EObject> i = resource.getAllContents(); i.hasNext(); ) {
			EObject next = i.next();
			if (next instanceof CastExpression) {
				CastExpression castExpression = (CastExpression) next;
				if(castExpression.getChild() instanceof UnaryExpression) {
					UnaryExpression unaryExpression = (UnaryExpression) castExpression.getChild();
					if (unaryExpression.getOperators().size() == 1 && 
							unaryExpression.getOperators().get(0) instanceof Addition) {
						//try to resolve the cast
						NamespaceClassifierReference nsClassifierReference = (NamespaceClassifierReference)castExpression.getType();
						EObject proxy = (EObject) nsClassifierReference
								.getClassifierReferences().get(0).eGet(TypesPackage.Literals.CLASSIFIER_REFERENCE__TARGET, false);
						EObject resolved = EcoreUtil.resolve(proxy, castExpression.eResource());

						if (!(resolved instanceof PrimitiveType)) {
							
							IdentifierReference mainIdReference = ReferencesFactory.eINSTANCE.createIdentifierReference();
							mainIdReference.eSet(
									ReferencesPackage.Literals.ELEMENT_REFERENCE__TARGET, proxy);
							String id = ((InternalEObject)proxy).eProxyURI().fragment();
							id = id.substring(IContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX.length());
							id = id.substring(id.indexOf("_") + 1);
							
							((ITextResource) resource).registerContextDependentProxy(
									new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<ElementReference, ReferenceableElement>(JavaReferenceResolverSwitch.getElementReferenceTargetReferenceResolver()),
									mainIdReference,
									ReferencesPackage.Literals.ELEMENT_REFERENCE__TARGET,
									id,
									proxy);
							
							IdentifierReference rootIdRef = mainIdReference;
							IdentifierReference prevIdRef = null;
							
							//namespace needs to be converted into reference chain
							for(String nsPart : nsClassifierReference.getNamespaces()) {
								IdentifierReference idRef = ReferencesFactory.eINSTANCE.createIdentifierReference();
								InternalEObject newProxy = (InternalEObject) EcoreUtil.copy(proxy);
								
								String newFragment = newProxy.eProxyURI().fragment();
								newFragment = newFragment.substring(0,newFragment.indexOf("_") + 1) + nsPart;
								
								URI newURI = newProxy.eProxyURI().trimFragment().appendFragment(newFragment);
								newProxy.eSetProxyURI(newURI);
								
								idRef.setTarget((ReferenceableElement) newProxy);
								
								((ITextResource) resource).registerContextDependentProxy(
										new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<ElementReference, ReferenceableElement>(JavaReferenceResolverSwitch.getElementReferenceTargetReferenceResolver()),
										idRef,
										ReferencesPackage.Literals.ELEMENT_REFERENCE__TARGET,
										nsPart,
										newProxy);
								
								String proxyURI = newProxy.eProxyURI().toString();
								proxyURI = proxyURI.substring(0,proxyURI.lastIndexOf("_"));
								
								if(prevIdRef != null) {
									prevIdRef.setNext(idRef);
								}
								else {
									rootIdRef = idRef;
								}
								prevIdRef = idRef;
							}
							
							if (prevIdRef != null) {
								prevIdRef.setNext(mainIdReference);
							}
							
							//find the containing additive expression to modify it 
							EObject aeChild = castExpression.eContainer();
							while(!(aeChild.eContainer() instanceof AdditiveExpression)) {
								aeChild = aeChild.eContainer();
							}
							AdditiveExpression additiveExpression = (AdditiveExpression) aeChild.eContainer();
							
							NestedExpression nestedExpression = ExpressionsFactory.eINSTANCE.createNestedExpression();

							nestedExpression.setExpression(rootIdRef);
							
							int idx = additiveExpression.getChildren().indexOf(aeChild);
							if (idx + 1 == additiveExpression.getChildren().size()) {
								additiveExpression.getChildren().add(idx + 1,unaryExpression.getChild());
							}
							else {
								additiveExpression.getChildren().add(unaryExpression.getChild());
							}
							if (idx == additiveExpression.getAdditiveOperators().size()) {
								additiveExpression.getAdditiveOperators().add(OperatorsFactory.eINSTANCE.createAddition());
							}
							else {
								additiveExpression.getAdditiveOperators().add(idx, OperatorsFactory.eINSTANCE.createAddition());
							}
							EcoreUtil.replace(castExpression, nestedExpression);
							//additiveExpression.getChildren().add(idx,nestedExpression);
							//additiveExpression.getChildren().remove(aeChild);
							
							//TODO set location map for nested expression and additive operator and identifier reference
						}
					}
				}
			}
		}
	}

}
