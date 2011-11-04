package org.emftext.language.hedl.validation;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;

public class UniqueComplexTypeNamesConstraint extends AbstractHedlConstraint {

	@Override
	public IStatus validate(IValidationContext context) {
		Set<EClass> types = new LinkedHashSet<EClass>();
		types.add(HEDL_PACKAGE.getEntity());
		types.add(HEDL_PACKAGE.getEnum());

		EObject target = context.getTarget();
		Set<EObject> entitiesAndEnumsWithDuplicateName = checkUniqueNames(target, HEDL_PACKAGE.getEntityModel(), types);
		
		if (entitiesAndEnumsWithDuplicateName.size() > 0) {
			return new ConstraintStatus(this, target, "Duplicate name for enum or entity.", entitiesAndEnumsWithDuplicateName);
		} else {
			return Status.OK_STATUS;
		}
	}
}
