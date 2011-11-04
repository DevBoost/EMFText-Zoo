package org.emftext.language.hedl.validation;

import java.util.Collections;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;

public class UniqueEnumLiteralNamesConstraint extends AbstractHedlConstraint {

	@Override
	public IStatus validate(IValidationContext context) {
		Set<EClass> types = Collections.singleton(HEDL_PACKAGE.getEnumLiteral());

		EObject target = context.getTarget();
		Set<EObject> propertiesWithDuplicateName = checkUniqueNames(target, HEDL_PACKAGE.getEnum(), types);
		
		if (propertiesWithDuplicateName.size() > 0) {
			return new ConstraintStatus(this, target, "Duplicate name for enumeration literal.", propertiesWithDuplicateName);
		} else {
			return Status.OK_STATUS;
		}
	}

}
