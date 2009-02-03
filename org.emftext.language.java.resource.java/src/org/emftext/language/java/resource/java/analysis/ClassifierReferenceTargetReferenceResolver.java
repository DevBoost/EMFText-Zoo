package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.JavaUniquePathConstructor;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.imports.ClassifierImport;
import org.emftext.language.java.imports.Import;
import org.emftext.language.java.imports.PackageImport;
import org.emftext.language.java.imports.StaticClassifierImport;
import org.emftext.language.java.imports.StaticMemberImport;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.resource.java.analysis.helper.JavaReferenceResolver;
import org.emftext.language.java.types.NamespaceClassifierReference;

public class ClassifierReferenceTargetReferenceResolver extends JavaReferenceResolver<org.emftext.language.java.types.ClassifierReference> {

	@Override
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EObject element, org.emftext.language.java.types.ClassifierReference container, org.eclipse.emf.ecore.EReference reference) {
		Classifier classifier = (Classifier) element;
		String fullID = classifier.getName();
		
		if (!(container.eContainer() instanceof NamespaceClassifierReference)) {
			//the element might be missing his namespace
			URI resourceURI = element.eResource().getURI();
			if (resourceURI.toString().startsWith(JavaUniquePathConstructor.JAVA_CLASSIFIER_PATHMAP)) {
				String qualifiedName = resourceURI.trimFileExtension().toString().substring(
						JavaUniquePathConstructor.JAVA_CLASSIFIER_PATHMAP.length());
				//inner classes directly contained in outer
				EObject inner = element;
				String innerName = "";
				while(inner.eContainer() instanceof Classifier) {
					innerName =  "$" + ((Classifier)inner).getName() + innerName;
					inner = inner.eContainer();
				}
				qualifiedName = qualifiedName + innerName;
				if (qualifiedName.startsWith("java.lang.")) {
					//default import
				}
				else {
					fullID = qualifiedName;
					CompilationUnit cu = findContainingCompilationUnit(container);
					String packageName = "";
					if (fullID.contains(".")) {
						packageName = fullID.substring(0,fullID.lastIndexOf("."));
					}
					//fullID = fullID.replaceAll("\\$", ".");
					if (fullID.contains("$")) {
						//TODO full ref for inner classes, code below
						fullID = ((NamedElement) element).getName();
					}
					else if (JavaUniquePathConstructor.packageName(cu).equals(packageName)) {
						//same package
						fullID = ((NamedElement) element).getName();
					}
					else {
						//a inner class?
						/*Class containersClass = findContainingClass(container);
						if (containersClass != null) {
							EList<Classifier> innerClasses = JavaClasspath.INSTANCE.getInternalClassifiers(containersClass);
							for (Classifier superClass : getAllSuperTypes(containersClass)) {
								innerClasses.addAll(
										JavaClasspath.INSTANCE.getInternalClassifiers(superClass));
							}
							for(Classifier innerCand : innerClasses) {
								if (element.equals(EcoreUtil.resolve(innerCand, myResource))) {
									fullID = ((NamedElement) element).getName();
								}
							}
						}*/
						for(Import imp : cu.getImports()) {
							if(imp instanceof ClassifierImport) {
								ClassifierImport classifierImport = (ClassifierImport) imp;
								if (element.equals(classifierImport.getClassifier())) {
									//the element is imported -> simple name
									fullID = ((NamedElement) element).getName();
								}
							}
							if(imp instanceof PackageImport) {
								String name = ((NamedElement) element).getName();
								EList<ConcreteClassifier> importedClassifiers =  
									JavaClasspath.INSTANCE.getClassifiers(imp);
								for(ConcreteClassifier classifierProxy : importedClassifiers) {
									if (name.equals(classifierProxy.getName())) {
										fullID = name;
										break;
									}
								}
								
							}
							else if (imp instanceof StaticMemberImport) {
								StaticMemberImport staticImport = (StaticMemberImport) imp;
								if (element.equals(staticImport.getStaticMember())) {
									//the element is imported -> simple name
									fullID = ((NamedElement) element).getName();
								}
							}
							else if (imp instanceof StaticClassifierImport) {
								StaticClassifierImport staticImport = (StaticClassifierImport) imp;
								if (staticImport.getStaticMembers().contains(element)) {
									//the element is imported -> simple name
									fullID = ((NamedElement) element).getName();
								}
							}	
						}
					}
				}
			}
		}
		
		return fullID;

	}


	@Override
	protected void doResolve(java.lang.String identifier, org.emftext.language.java.types.ClassifierReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IResolveResult result) {
		if (container.eContainer() instanceof NamespaceClassifierReference) {
			NamespaceClassifierReference nsClassifierReference = (NamespaceClassifierReference) container.eContainer();

			//first try to resolve in local scope
			super.doResolve(identifier, container, reference, position, resolveFuzzy, result);

			if  (!result.wasResolved()){
				//not in local scope; try to resolve
				Classifier target = null;
				int myPos = nsClassifierReference.getClassifierReferences().indexOf(container);
				
				//global
				String containerName = JavaClasspath.INSTANCE.getContainerNameFromNamespace(nsClassifierReference, "");
				if (containerName == null) {
					return;
				}
				//append possible type-argumented container classes
				for(int i = 0; i < myPos; i++) {
					Classifier prevClassifier = nsClassifierReference.getClassifierReferences().get(i).getTarget();
					if (prevClassifier.eIsProxy()) {
						return;
					}
					containerName = containerName + prevClassifier.getName() + JavaUniquePathConstructor.CLASSIFIER_SEPARATOR ;
				}
				target = (Classifier) EcoreUtil.resolve(
						JavaClasspath.INSTANCE.getClassifier(containerName + identifier), container.eResource());
				
				if(target.eIsProxy()) {
					target = null;
				}
				
				if (target == null) {
					ConcreteClassifier directContainer = findContainingClassifier(container);

					//relative
					if (myPos > 0) {
						//given by a previous class
						directContainer = (ConcreteClassifier) nsClassifierReference.getClassifierReferences().get(myPos - 1).getTarget();
					}
					else if (!nsClassifierReference.getNamespace().isEmpty()) {
						//scope defined by container namespace: 
						//this has to be a class because packages are always absolute (global), and would have been found before 
						CompilationUnit cu = findContainingCompilationUnit(container);
						EList<ConcreteClassifier> rootContainerCandidates = new BasicEList<ConcreteClassifier>();
						
						collectClassifiersInScope(
								findContainingClassifier(container), cu, rootContainerCandidates);
						
						for(String nextInNS : nsClassifierReference.getNamespace()) {
							ConcreteClassifier nextContainer = null;
							for(ConcreteClassifier cand: rootContainerCandidates) {
								if (nextInNS.equals(cand.getName())) {
									nextContainer = cand;
									break;
								}
							}
							if (nextContainer == null) {
								directContainer = null;
								break;
							}
							else {
								rootContainerCandidates = new BasicEList<ConcreteClassifier>();
								
								for(Member m : nextContainer.getMembers()) {
									if(m instanceof ConcreteClassifier) {
										rootContainerCandidates.add((ConcreteClassifier) m);
									}
								}
								
								rootContainerCandidates.addAll(
										JavaClasspath.INSTANCE.getInternalClassifiers(nextContainer));
								//add super internals
								for(ConcreteClassifier superClass : getAllSuperTypes(nextContainer)) {
									for(Member m : superClass.getMembers()) {
										if(m instanceof ConcreteClassifier) {
											rootContainerCandidates.add((ConcreteClassifier) m);
										}
									}
									rootContainerCandidates.addAll(
											JavaClasspath.INSTANCE.getInternalClassifiers(superClass));
								}
								directContainer = nextContainer;
							}
						}
					}
					
					if (directContainer != null) {
						EList<ConcreteClassifier> allInternal = new BasicEList<ConcreteClassifier>();

						for(Member m : directContainer.getMembers()) {
							if(m instanceof ConcreteClassifier) {
								allInternal.add((ConcreteClassifier) m);
							}
						}
						
						allInternal.addAll(JavaClasspath.INSTANCE.getInternalClassifiers(directContainer));
						//add super internals
						for(ConcreteClassifier superClass : getAllSuperTypes(directContainer)) {
							for(Member m : superClass.getMembers()) {
								if(m instanceof ConcreteClassifier) {
									allInternal.add((ConcreteClassifier) m);
								}
							}
							allInternal.addAll(
									JavaClasspath.INSTANCE.getInternalClassifiers(superClass));
						}
						for(ConcreteClassifier cand : allInternal) {
							if(cand.getName().equals(identifier)) {
								cand = (ConcreteClassifier) EcoreUtil.resolve(cand, container.eResource());
								if (!cand.eIsProxy()) {
									target = cand;
									break;
								}
							}
							else {
								//try the super types
								for(ConcreteClassifier superCand : getAllSuperTypes(cand)) {
									superCand = (ConcreteClassifier) EcoreUtil.resolve(superCand, container.eResource());
									if (!superCand.eIsProxy()) {
										target = superCand;
										break;
									}
								}
							}
						}
					}
				}

				if (target != null) {
					result.addMapping(identifier, target);
				}
			}			
		}
		
	}


	protected void collectClassifiersInScope(
			ConcreteClassifier containingClassifier,
			CompilationUnit cu,
			EList<ConcreteClassifier> rootContainerCandidates) {
		
		
		ConcreteClassifier outerContainer = containingClassifier;
		while(outerContainer != null) {
			for(Member m : outerContainer.getMembers()) {
				if(m instanceof ConcreteClassifier) {
					rootContainerCandidates.add((ConcreteClassifier) m);
				}
			}
			if(outerContainer.eContainer() instanceof ConcreteClassifier) {
				outerContainer = (ConcreteClassifier) outerContainer.eContainer();
			}
			else {
				rootContainerCandidates.add(outerContainer);
				outerContainer = null;
			}
		}
		
		rootContainerCandidates.addAll(cu.getClassifiers());

		
		rootContainerCandidates.addAll(
				JavaClasspath.INSTANCE.getInternalClassifiers(containingClassifier));		
		for(Import explicitImport : cu.getImports()) {
			if (explicitImport instanceof ClassifierImport) {
				ConcreteClassifier classifierImport = 
					((ClassifierImport)explicitImport).getClassifier();
				rootContainerCandidates.add(classifierImport);
			}
			else if (explicitImport instanceof PackageImport) {
				EList<ConcreteClassifier> importedClassifiers =  
					JavaClasspath.INSTANCE.getClassifiers(explicitImport);
				rootContainerCandidates.addAll(importedClassifiers);
			
			}
			else if (explicitImport instanceof StaticMemberImport) {
				Member staticMember = 
					((StaticMemberImport)explicitImport).getStaticMember();
				if (staticMember instanceof ConcreteClassifier) {
					rootContainerCandidates.add((ConcreteClassifier) staticMember);
				}
			}
			else if (explicitImport instanceof StaticClassifierImport) {
				EList<Member> staticMembers = 
					((StaticClassifierImport)explicitImport).getStaticMembers();
				for(Member staticMember : staticMembers) {
					if (staticMember instanceof ConcreteClassifier) {
						rootContainerCandidates.add((ConcreteClassifier) staticMember);
					}
				}
			}

		}
		String packageName = JavaUniquePathConstructor.packageName(cu);
		EList<ConcreteClassifier> defaultImports = JavaClasspath.INSTANCE.getDefaultImports(packageName);
		rootContainerCandidates.addAll(defaultImports);
	}
}
