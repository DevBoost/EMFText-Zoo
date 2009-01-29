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
				EList<ConcreteClassifier> candidates = new BasicEList<ConcreteClassifier>();
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
					//relative
					if (myPos > 0) {
						//given by a previous class
						candidates.add((ConcreteClassifier) nsClassifierReference.getClassifierReferences().get(myPos - 1).getTarget());
					}
					else if (!nsClassifierReference.getNamespace().isEmpty()) {
						//scope defined by package namespace
						//consider imports and default imports
						CompilationUnit cu = findContainingCompilationUnit(container);
						candidates.addAll(
								JavaClasspath.INSTANCE.getInternalClassifiers(findContainingClassifier(container)));
						
						for(Import explicitImport : cu.getImports()) {
							if (explicitImport instanceof ClassifierImport) {
								ConcreteClassifier classifierImport = 
									((ClassifierImport)explicitImport).getClassifier();
								candidates.add(classifierImport);
							}
							else if (explicitImport instanceof PackageImport) {
								EList<ConcreteClassifier> importedClassifiers =  
									JavaClasspath.INSTANCE.getClassifiers(explicitImport);
								candidates.addAll(importedClassifiers);
							
							}
							/*TODO take classifiers out of static imports
							 * 
							else if (explicitImport instanceof StaticMemberImport) {
								Member staticMember = 
									((StaticMemberImport)explicitImport).getStaticMember();
								scopeCandidates.add(staticMember);
							}
							else if (explicitImport instanceof StaticClassifierImport) {
								EList<Member> staticMembers = 
									((StaticClassifierImport)explicitImport).getStaticMembers();
								contentsList.addAll(staticMembers);
							}*/

						}
						String packageName = JavaUniquePathConstructor.packageName(cu);
						EList<ConcreteClassifier> defaultImports = JavaClasspath.INSTANCE.getDefaultImports(packageName);
						candidates.addAll(defaultImports);
					}
					
					for(ConcreteClassifier cand : candidates) {
						if(identifier.equals(cand.getName())) {
							cand = (ConcreteClassifier) EcoreUtil.resolve(cand, container.eResource());
							if (!cand.eIsProxy()) {
								target = (Classifier) cand;
								break;								
							}
						}
						for(Member m : getAllMemebers(cand)) {
							if (m instanceof ConcreteClassifier) {
								if(m.getName().equals(identifier)) {
									m = (ConcreteClassifier) EcoreUtil.resolve(m, container.eResource());
									if (!m.eIsProxy()) {
										if (nsClassifierReference.getNamespace().isEmpty()) {
											target = (Classifier) cand;
											break;
										}
										if (cand.eResource().equals(container.eResource())) {
											target = (Classifier) cand;
											break;
										}
										else {
											URI candUri = m.eResource().getURI();
											String fullName = candUri.trimFileExtension().toString().substring(JavaUniquePathConstructor.JAVA_CLASSIFIER_PATHMAP.length()) + "$";
											String myNs = JavaClasspath.INSTANCE.getContainerNameFromNamespace(nsClassifierReference, "");
											if (fullName.endsWith(myNs)) {
												target = (Classifier) m;
												break;
											}
										}
									}
								}
							}
						}
						if (target != null) {
							break;
						}
					}
				}

				if (target != null) {
					result.addMapping(identifier, target);
				}
			}			
		}
		
	}
}
