package org.emftext.language.java.resource.java.analysis.decider;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.annotations.AnnotationInstance;
import org.emftext.language.java.classifiers.Annotation;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.imports.ClassifierImport;
import org.emftext.language.java.imports.Import;
import org.emftext.language.java.imports.PackageImport;
import org.emftext.language.java.imports.StaticClassifierImport;
import org.emftext.language.java.imports.StaticMemberImport;
import org.emftext.language.java.members.MembersPackage;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.statements.StatementsPackage;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.NamespaceClassifierReference;
import org.emftext.language.java.util.classifiers.ConcreteClassifierUtil;
import org.emftext.language.java.util.containers.CompilationUnitUtil;
import org.emftext.language.java.util.imports.PackageImportUtil;

public class ConcreteClassifierDecider extends AbstractDecider {

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
		
		handleQualifiedTypeReferences(identifier, container, resultList);
		handleQualifiedAnnotationReferences(identifier, container, resultList);
		
		addInnerClasses(container, resultList);
		
		addImports(container, resultList);
		
		addDefaultImports(container, resultList);
		
		return resultList;
	}

	private void handleQualifiedTypeReferences(String identifier,
			EObject container, EList<EObject> resultList) {
		
		if (container.eContainer() instanceof NamespaceClassifierReference) {
			NamespaceClassifierReference ncr = (NamespaceClassifierReference) container.eContainer();
			int idx = ncr.getClassifierReferences().indexOf(container);
			if(ncr.getNamespaces().size() > 0 && idx == 0) {
				Classifier target = null;
				//if the reference is qualified, the target can be directly found
				String containerName = JavaClasspath.INSTANCE.getContainerNameFromNamespace(ncr, "");
				target = (Classifier) EcoreUtil.resolve(
						JavaClasspath.INSTANCE.getClassifier(containerName + identifier), container.eResource());
				resultList.add(target);
			}
		}
	}
	
	private void handleQualifiedAnnotationReferences(String identifier,
			EObject container, EList<EObject> resultList) {
		if (container instanceof AnnotationInstance) {
			AnnotationInstance annotationInstance = (AnnotationInstance) container;
			if (annotationInstance.getNamespaces().size() > 0) {
				String containerName = JavaClasspath.INSTANCE.getContainerNameFromNamespace(annotationInstance, "");
				ConcreteClassifier target = (ConcreteClassifier) EcoreUtil.resolve(
						JavaClasspath.INSTANCE.getClassifier(containerName + identifier), container.eResource());
			
				if (target instanceof Annotation) {
					resultList.add(target);
				}
			}
		}
	}
	
	private void addInnerClasses(EObject container,
			EList<EObject> resultList) {
		if(container instanceof ConcreteClassifier) {
			resultList.addAll(ConcreteClassifierUtil.getAllInnerClassifiers(
					(ConcreteClassifier) container));
		}
	}
	
	private void addImports(EObject container,
			EList<EObject> resultList) {
		if(container instanceof CompilationUnit) {
			for(Import aImport : ((CompilationUnit)container).getImports()) {
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
			for(Import aImport : ((CompilationUnit)container).getImports()) {
				if(aImport instanceof PackageImport) {
					resultList.addAll(PackageImportUtil.getImportedClassifiers(
							(PackageImport) aImport));
				}
			}
		}
	}
	
	private void addDefaultImports(EObject container,
			EList<EObject> resultList) {
		if(container instanceof CompilationUnit) {
			resultList.addAll(CompilationUnitUtil.getDefaultImports(
					(CompilationUnit) container));
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
		return (referenceContainer instanceof Reference ||
				referenceContainer instanceof ClassifierReference);
	}
	
}
