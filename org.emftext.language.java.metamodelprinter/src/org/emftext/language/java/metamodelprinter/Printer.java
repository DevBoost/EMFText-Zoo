package org.emftext.language.java.metamodelprinter;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.java.JavaPackage;

public class Printer {
	
	public static void main(String[] args) {
		int abstractClasses = 0;
		int concreteClasses = 0;
		
		JavaPackage jPackage = JavaPackage.eINSTANCE;
		EList<EPackage> packages = jPackage.getESubpackages();
		for (EPackage nextPackage : packages) {
			System.out.println(nextPackage.getName());
			EList<EClassifier> classifiers = nextPackage.getEClassifiers();
			for (EClassifier nextClassifier : classifiers) {
				if (nextClassifier instanceof EClass) {
					EClass nextEClass = (EClass) nextClassifier;
					if (nextEClass.isAbstract()) {
						System.out.println("A:: " + nextEClass.getName());
						abstractClasses++;
					} else {
						System.out.println(nextEClass.getName());
						concreteClasses++;
					}
				}
			}
			System.out.println();
		}
		System.out.println("Concrete classes: " + concreteClasses);
		System.out.println("Abstract classes: " + abstractClasses);
	}
}
