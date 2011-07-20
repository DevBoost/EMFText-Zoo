package org.emftext.language.dbschema.test;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.dbschema.DbschemaPackage;

import junit.framework.TestCase;

public class FeatureIDTest extends TestCase {

	public void testFeatureID() {
		EClass attColumnClass = DbschemaPackage.eINSTANCE.getAttributeColumn();
		
		assertFeatureName(attColumnClass, "size", DbschemaPackage.ATTRIBUTE_COLUMN__SIZE);
		assertFeatureName(attColumnClass, "name", DbschemaPackage.ATTRIBUTE_COLUMN__NAME);
		assertFeatureName(attColumnClass, "primary", DbschemaPackage.ATTRIBUTE_COLUMN__PRIMARY);
		assertFeatureName(attColumnClass, "type", DbschemaPackage.ATTRIBUTE_COLUMN__TYPE);
	}

	private void assertFeatureName(EClass attColumnClass, String expectedName, int featureID) {
		EStructuralFeature feature = attColumnClass.getEStructuralFeature(featureID);
		assertEquals(expectedName, feature.getName());
	}
}
