package org.emftext.language.rolecore.examples.riehle97;

import junit.framework.TestCase;

public class RiehleTest extends TestCase {

	public void testRoleHandling() {
		// create a clean core object
		Customer fred = Riehle97Factory.eINSTANCE.createCustomerCore();
		boolean isBorrower = fred.hasRole(Borrower.class);
		assertFalse(isBorrower);

		// add a role
		Borrower fredsBorrowerRole = Riehle97Factory.eINSTANCE.createBorrower();
		fred.addRole(fredsBorrowerRole);
		
		// check that the role is still there
		isBorrower = fred.hasRole(Borrower.class);
		assertTrue(isBorrower);
		
		// get the role object
		Borrower fredPlayingBorrower = fred.getRole(Borrower.class);
		assertNotNull(fredPlayingBorrower);
		// call a role specific method
		fredPlayingBorrower.getCredits();
	}
}
