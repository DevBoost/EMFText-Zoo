package org.emftext.language.functions.validation;

import java.util.Collections;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.Category;
import org.eclipse.emf.validation.model.ConstraintSeverity;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.AbstractConstraintDescriptor;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.emftext.language.functions.Function;
import org.emftext.language.functions.FunctionSet;

public class FunctionsValidator extends AbstractModelConstraint implements IModelConstraint {
	
	public FunctionsValidator() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext context) {
		
		EObject target = context.getTarget();
		if (target instanceof Function) {
			Function function = (Function) target;
			FunctionSet functionSet = (FunctionSet) function.eContainer();
			boolean hasChildren = false;
			for (Function next : functionSet.getFunctions()) {
				if (next.getParent() == function) {
					hasChildren = true;
					break;
				}
			}
			if (hasChildren && function.getCosts() > 0) {
				return new ConstraintStatus(this, target, "Composite functions must not have explicit costs.", Collections.singleton(function));
			}
			if (!hasChildren && function.getCosts() == 0 && !function.isIgnored()) {
				return new ConstraintStatus(this, target, "Leaf functions must define explicit costs.", Collections.singleton(function));
			}
		}
		return Status.OK_STATUS;
	}

	public IConstraintDescriptor getDescriptor() {
		return new AbstractConstraintDescriptor() {
			
			public boolean targetsTypeOf(EObject eObject) {
				return true;
			}
			
			public boolean targetsEvent(Notification notification) {
				return false;
			}
			
			public void removeCategory(Category category) {
			}
			
			public boolean isLive() {
				return false;
			}
			
			public boolean isBatch() {
				return true;
			}
			
			public int getStatusCode() {
				return 0;
			}
			
			public ConstraintSeverity getSeverity() {
				return ConstraintSeverity.ERROR;
			}
			
			public String getPluginId() {
				return FunctionsValidator.class.getPackage().getName();
			}
			
			public String getName() {
				return "name";
			}
			
			public String getMessagePattern() {
				return "message";
			}
			
			public String getId() {
				return null;
			}
			
			public EvaluationMode<?> getEvaluationMode() {
				return EvaluationMode.BATCH;
			}
			
			public String getDescription() {
				return "description";
			}
			
			public Set<Category> getCategories() {
				return null;
			}
			
			public String getBody() {
				return null;
			}
			
			public void addCategory(Category category) {
			}
		};
	}
}
