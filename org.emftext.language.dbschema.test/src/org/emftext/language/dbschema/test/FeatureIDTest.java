package org.emftext.language.dbschema.test;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.dbschema.DbschemaPackage;

import junit.framework.TestCase;

public class FeatureIDTest extends TestCase {

	public void testFeatureID() {
		EClass attColumnClass = DbschemaPackage.eINSTANCE.getAttributeColumn();
		int featureID = DbschemaPackage.ATTRIBUTE_COLUMN__SIZE;
		//assertEquals(3, featureID);
		EStructuralFeature feature = attColumnClass.getEStructuralFeature(featureID);
		assertEquals("size", feature.getName());
	}
}
