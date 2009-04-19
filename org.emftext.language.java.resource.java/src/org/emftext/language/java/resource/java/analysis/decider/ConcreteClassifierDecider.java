package org.emftext.language.java.resource.java.analysis.decider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.JavaUniquePathConstructor;
import org.emftext.language.java.classifiers.AnonymousClass;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.commons.NamespaceAwareElement;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.JavaRoot;
import org.emftext.language.java.containers.Package;
import org.emftext.language.java.imports.ClassifierImport;
import org.emftext.language.java.imports.Import;
import org.emftext.language.java.imports.PackageImport;
import org.emftext.language.java.imports.StaticClassifierImport;
import org.emftext.language.java.imports.StaticMemberImport;
import org.emftext.language.java.members.MembersPackage;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.resource.java.analysis.helper.ScopedTreeWalker;
import org.emftext.language.java.statements.StatementsPackage;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.util.classifiers.AnonymousClassUtil;
import org.emftext.language.java.util.classifiers.ClassifierUtil;
import org.emftext.language.java.util.classifiers.ConcreteClassifierUtil;
import org.emftext.language.java.util.containers.JavaRootUtil;
import org.emftext.language.java.util.imports.ImportUtil;

public class ConcreteClassifierDecider extends AbstractDecider {

	protected Resource resource;
	
	public boolean containsCandidates(EObject container, EReference containingReference) {
		if (MembersPackage.Literals.MEMBER_CONTAINER__MEMBERS.equals(containingReference)) {
			return true;
		}
		if (StatementsPackage.Literals.STATEMENT_CONTAINER__STATEMENT.equals(containingReference)) {
			return true;
		}
		if (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS.equals(containingReference)) {
			return true;
		}
		return false;
	}

	public EList<? extends EObject> getAdditionalCandidates(String identifier, EObject container) {
		EList<EObject> resultList = new BasicEList<EObject>();
		
		if (container instanceof Package) {
			Package p = (Package) container;
			String packageName = JavaUniquePathConstructor.packageName(p);
			if (packageName.equals("")) {
				packageName = p.getName();
			}
			else {
				packageName = packageName + JavaUniquePathConstructor.PACKAGE_SEPARATOR + p.getName();
			}
			
			resultList.addAll(JavaClasspath.get(resource).getClassifiers(
					packageName, "*"));
		}
		
		addInnerClasses(container, resultList);
		addImports(container, resultList);
		addDefaultImports(container, resultList);

		//TODO which inner classes are exactly imported and what is their priority?
		if(container instanceof CompilationUnit) {
			for(Import aImport : ((CompilationUnit)container).getImports()) {
				if(aImport instanceof ClassifierImport) {
					resultList.addAll(ConcreteClassifierUtil.getAllInnerClassifiers(
							((ClassifierImport)aImport).getClassifier()));
				}
			}
		}
		
		return resultList;
	}
	
	private void addInnerClasses(EObject container,
			EList<EObject> resultList) {
		if(container instanceof ConcreteClassifier) {
			//local inner classes
			resultList.addAll(ClassifierUtil.getAllMembers(
					(ConcreteClassifier) container));			
			//public inner classes (possibly external)
			resultList.addAll(ConcreteClassifierUtil.getAllInnerClassifiers(
					(ConcreteClassifier) container));
		}
		if(container instanceof AnonymousClass) {
			resultList.addAll(AnonymousClassUtil.getAllMembers(
					(AnonymousClass) container));	
			resultList.addAll(ConcreteClassifierUtil.getAllInnerClassifiers(
					AnonymousClassUtil.getSuperClassifier((AnonymousClass)container)));
		}
	}
	
	private void addImports(EObject container,
			EList<EObject> resultList) {
		if(container instanceof JavaRoot) {
			for(Import aImport : ((JavaRoot)container).getImports()) {
				if(aImport instanceof ClassifierImport) {
					resultList.add(((ClassifierImport)aImport).getClassifier());
				}
				else if (aImport instanceof StaticMemberImport) {
					resultList.addAll(((StaticMemberImport)aImport).getStaticMembers());
				}
				else if (aImport instanceof StaticClassifierImport) {
					resultList.addAll(((StaticClassifierImport)aImport).getStaticMembers());
				}
			}
			for(Import aImport : ((JavaRoot)container).getImports()) {
				if(aImport instanceof PackageImport) {
					resultList.addAll(ImportUtil.getClassifierList(
							aImport));
				}
			}
		}
	}
	
	private void addDefaultImports(EObject container,
			EList<EObject> resultList) {
		if(container instanceof JavaRoot) {
			resultList.addAll(JavaRootUtil.getDefaultImports(
					(JavaRoot) container));
		}
	}
	
	public boolean isPossibleTarget(String id, EObject element) {
		if (element instanceof ConcreteClassifier) {
			NamedElement ne = (NamedElement) element;
			return id.equals(ne.getName());
		}
		return false;
	}

	public boolean canFindTargetsFor(EObject referenceContainer,
			EReference crossReference) {
		
		resource = referenceContainer.eResource();
		
		return (referenceContainer instanceof Reference ||
				referenceContainer instanceof ClassifierReference);
	}
	
	/**
	 * This method assumes that the namespace of the given namespace aware element
	 * is relative to the scope given by the starting point element. That is,
	 * each element of the namespace points to a classifier, where the first element
	 * points to a classifier awailable in the scope given by the starting point
	 * (i.e., define locally or imported).
	 * 
	 * @param nsaElement
	 * @param idx
	 * @param startingPoint
	 * @param referenceContainer
	 * @param crossReference
	 * @return the classifier to which the last part of the namespace points, or null, if any
	 *         part of the namespace can not be resolved to a classifier in the given scope
	 */
	public static EObject resolveRelativeNamespace(NamespaceAwareElement nsaElement, int idx, 
			EObject startingPoint,
			EObject referenceContainer,
			EReference crossReference) {
		
		if (idx < nsaElement.getNamespaces().size()) {
			String identifier = nsaElement.getNamespaces().get(idx);
			
			List<IResolutionTargetDecider> deciderList = new ArrayList<IResolutionTargetDecider>();
			deciderList.add(new ConcreteClassifierDecider());
			ScopedTreeWalker treeWalker = new ScopedTreeWalker(deciderList);
			
			EObject target = treeWalker.walk(startingPoint, identifier, referenceContainer, crossReference);
			
			if (target != null) {
				return resolveRelativeNamespace(nsaElement, idx + 1, target, referenceContainer, crossReference); 
			}
			else {
				return null;
			}
		}
		
		if (startingPoint.eIsProxy()) {
			startingPoint = EcoreUtil.resolve(startingPoint, referenceContainer);
		}
		return startingPoint;
	}
	
}
