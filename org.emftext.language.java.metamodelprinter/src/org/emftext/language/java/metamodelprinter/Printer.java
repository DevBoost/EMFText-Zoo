package org.emftext.language.java.metamodelprinter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.java.JavaPackage;

public class Printer {
	
	public final static class NamedAndTypedFeature {
		
		private String name;
		private String typeName;
		
		public NamedAndTypedFeature(String name, String typeName) {
			super();
			this.name = name;
			this.typeName = typeName;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result
					+ ((typeName == null) ? 0 : typeName.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			NamedAndTypedFeature other = (NamedAndTypedFeature) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (typeName == null) {
				if (other.typeName != null)
					return false;
			} else if (!typeName.equals(other.typeName))
				return false;
			return true;
		}
	}
	
	public static void main(String[] args) {
		int abstractClasses = 0;
		int concreteClasses = 0;
		int packageCount = 0;
		Map<NamedAndTypedFeature, List<EClass>> featureNamesToClasses = new HashMap<NamedAndTypedFeature, List<EClass>>();
		
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
					EList<EStructuralFeature> features = nextEClass.getEStructuralFeatures();
					for (EStructuralFeature feature : features) {
						String featureTypeName = feature.getEType().getName();
						NamedAndTypedFeature featureName = new NamedAndTypedFeature(feature.getName(), featureTypeName);
						if (!featureNamesToClasses.containsKey(featureName)) {
							featureNamesToClasses.put(featureName, new ArrayList<EClass>());
						}
						featureNamesToClasses.get(featureName).add(nextEClass);
					}
				}
			}
			packageCount++;
			System.out.println();
		}
		
		for (NamedAndTypedFeature featureName : featureNamesToClasses.keySet()) {
			List<EClass> nextClassList = featureNamesToClasses.get(featureName);
			if (nextClassList.size() > 1) {
				System.out.println("Duplicate feature '" + featureName.name + ":" + featureName.typeName + "' in " + toString(nextClassList));
			}
		}
		System.out.println();

		System.out.println("Concrete classes: " + concreteClasses);
		System.out.println("Abstract classes: " + abstractClasses);
		System.out.println("Packages: " + packageCount);
	}

	private static String toString(List<EClass> nextClassList) {
		String result = "";
		for (EClass class1 : nextClassList) {
			result += class1.getName() + ", ";
		}
		return result;
	}
}
