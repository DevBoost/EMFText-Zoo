package org.emftext.language.java.resource.java.analysis.decider;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.imports.Import;
import org.emftext.language.java.imports.PackageImport;
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
	
	public boolean walkInto(EObject container, EReference containingReference) {
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
		
		addInnerClasses(container, resultList);
		
		addPackageImports(container, resultList);
		
		addDefaultImports(container, resultList);
		
		return resultList;
	}

	private void handleQualifiedTypeReferences(String identifier,
			EObject container, EList<EObject> resultList) {
		
		if (container.eContainer() instanceof NamespaceClassifierReference) {
			NamespaceClassifierReference ncr = (NamespaceClassifierReference) container.eContainer();
			int idx = ncr.getClassifierReferences().indexOf(container);
			if(ncr.getNamespaces().size() > 0 || idx > 0) {
				Classifier target = null;
				//if the reference is qualified, the target can be directly found
				if (idx > 0) {
					target = ncr.getClassifierReferences().get(idx - 1).getTarget();
				}
				else {
					String containerName = JavaClasspath.INSTANCE.getContainerNameFromNamespace(ncr, "");
					target = (Classifier) EcoreUtil.resolve(
							JavaClasspath.INSTANCE.getClassifier(containerName + identifier), container.eResource());
				}
				resultList.add(target);
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
	
	private void addPackageImports(EObject container,
			EList<EObject> resultList) {
		if(container instanceof CompilationUnit) {
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
