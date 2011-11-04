package org.emftext.language.hedl.validation;

import java.util.Collections;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.IValidationContext;

/**
 * Checks that all properties have valid names (e.g., no java keywords). 
 */
public class ForbiddenPropertyNamesConstraint extends AbstractHedlConstraint {

	@Override
	public IStatus validate(IValidationContext context) {

		EObject target = context.getTarget();
		EClass type = HEDL_PACKAGE.getProperty();
		return checkForbiddenNames(target, type, Collections.singleton("id"));
	}
}
