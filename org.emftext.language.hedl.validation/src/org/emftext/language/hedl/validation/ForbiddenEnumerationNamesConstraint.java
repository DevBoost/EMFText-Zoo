package org.emftext.language.hedl.validation;

import java.util.Collections;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.IValidationContext;

/**
 * Checks that all enumerations have valid names (e.g., no java keywords). 
 */
public class ForbiddenEnumerationNamesConstraint extends AbstractHedlConstraint {

	@Override
	public IStatus validate(IValidationContext context) {

		EObject target = context.getTarget();
		EClass type = HEDL_PACKAGE.getEnum();
		return checkForbiddenNames(target, type, Collections.<String>emptySet());
	}
}
