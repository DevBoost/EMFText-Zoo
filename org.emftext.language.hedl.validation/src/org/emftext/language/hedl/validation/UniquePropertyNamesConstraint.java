package org.emftext.language.hedl.validation;

import java.util.Collections;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;

/**
 * Checks that there are no two properties in the same entity that 
 * have the same name. 
 */
public class UniquePropertyNamesConstraint extends AbstractHedlConstraint {

	@Override
	public IStatus validate(IValidationContext context) {
		Set<EClass> types = Collections.singleton(HEDL_PACKAGE.getProperty());

		EObject target = context.getTarget();
		Set<EObject> propertiesWithDuplicateName = checkUniqueNames(target, HEDL_PACKAGE.getEntity(), types);
		
		if (propertiesWithDuplicateName.size() > 0) {
			return new ConstraintStatus(this, target, "Duplicate name for property.", propertiesWithDuplicateName);
		} else {
			return Status.OK_STATUS;
		}
	}
}
