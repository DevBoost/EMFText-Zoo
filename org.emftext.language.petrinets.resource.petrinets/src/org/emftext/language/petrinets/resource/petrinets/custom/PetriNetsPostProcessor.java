/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.petrinets.resource.petrinets.custom;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.petrinets.BooleanExpression;
import org.emftext.language.petrinets.Cast;
import org.emftext.language.petrinets.Function;
import org.emftext.language.petrinets.FunctionCall;
import org.emftext.language.petrinets.FunctionType;
import org.emftext.language.petrinets.Setting;
import org.emftext.language.petrinets.SettingOperator;
import org.emftext.language.petrinets.UnaryMinus;
import org.emftext.language.petrinets.resource.petrinets.IPetrinetsOptionProvider;
import org.emftext.language.petrinets.resource.petrinets.IPetrinetsOptions;
import org.emftext.language.petrinets.resource.petrinets.IPetrinetsResourcePostProcessor;
import org.emftext.language.petrinets.resource.petrinets.IPetrinetsResourcePostProcessorProvider;
import org.emftext.language.petrinets.resource.petrinets.PetrinetsEProblemType;
import org.emftext.language.petrinets.resource.petrinets.analysis.FunctionCallAnalysisHelper;
import org.emftext.language.petrinets.resource.petrinets.mopp.PetrinetsResource;

public class PetriNetsPostProcessor implements IPetrinetsOptionProvider,
		IPetrinetsResourcePostProcessor,
		IPetrinetsResourcePostProcessorProvider {

	public IPetrinetsResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public void process(PetrinetsResource resource) {
		EcoreUtil.resolveAll(resource);
		TreeIterator<EObject> allContents = resource.getAllContents();
		while (allContents.hasNext()) {
			EObject eObject = (EObject) allContents.next();
			if (eObject instanceof FunctionCall) {
				FunctionCall fc = (FunctionCall) eObject;
				Function function = fc.getFunction();
				if (!function.eIsProxy()
						&& function.getFunctionType()
								.equals(FunctionType.WRITE)) {
					resource.addError(
							"The invocation of functions that write data is not allowed.",
							PetrinetsEProblemType.ANALYSIS_PROBLEM, fc);
				}
			} else if (eObject instanceof BooleanExpression) {
				BooleanExpression be = (BooleanExpression) eObject;
				EClassifier leftType = FunctionCallAnalysisHelper.getInstance()
						.getType(be.getLeft());
				if (leftType == null || leftType.getInstanceTypeName() == null
						|| !leftType.getInstanceClassName().equals("boolean")) {
					String type;
					if (leftType == null)
						type = "null";
					else
						type = leftType.getName();
					resource.addError(
							"Arguments to boolean expressions need to have a boolean return type. (found: "
									+ type + ")",
							PetrinetsEProblemType.ANALYSIS_PROBLEM,
							be.getLeft());
				}
				EClassifier rightType = FunctionCallAnalysisHelper
						.getInstance().getType(be.getRight());
				if (rightType == null
						|| rightType.getInstanceTypeName() == null
						|| !rightType.getInstanceTypeName().equals("boolean")) {
					String type;
					if (rightType == null)
						type = "null";
					else
						type = rightType.getName();
					resource.addError(
							"Arguments to boolean expressions need to have a boolean return type. (found: "
									+ type + ")",
							PetrinetsEProblemType.ANALYSIS_PROBLEM,
							be.getRight());
				}
			} else if (eObject instanceof Setting) {
				Setting setting = (Setting) eObject;
				EClassifier expectedType = setting.getFeature().getEType();
				EClassifier foundType = FunctionCallAnalysisHelper
						.getInstance().getType(setting.getValue());
				if (!FunctionCallAnalysisHelper.getInstance().isSubtype(
						foundType, expectedType)) {
					String found;
					if (foundType == null)
						found = "null";
					else
						found = foundType.getName();
					String expected;
					if (expectedType == null)
						expected = "null";
					else
						expected = expectedType.getName();

					resource.addError(
							"Type of assigned variable is not compatible with type expected for (found: "
									+ found + " " + ", expected: " + expected
									+ ")",
							PetrinetsEProblemType.ANALYSIS_PROBLEM, setting);
				}
				if (setting.getSettingOperator().equals(SettingOperator.ADD)) {
					if (setting.getFeature() != null
							&& !setting.getFeature().eIsProxy()
							&& !setting.getFeature().isMany()) {
						resource.addError(
								"You can only add to features of type List.",
								PetrinetsEProblemType.ANALYSIS_PROBLEM, setting);
					}
				} else if (setting.getSettingOperator().equals(
						SettingOperator.ASSIGN)) {
					if (setting.getFeature() != null
							&& !setting.getFeature().eIsProxy()
							&& setting.getFeature().isMany()) {
						resource.addError(
								"You can assign values to features of non-List type.",
								PetrinetsEProblemType.ANALYSIS_PROBLEM, setting);
					}
				}

			} else if (eObject instanceof UnaryMinus) {
				UnaryMinus um = (UnaryMinus) eObject;
				if (um.isMinus()) {
					EClassifier type = FunctionCallAnalysisHelper.getInstance()
							.getType(um.getExpression());

					if (!(EcorePackage.eINSTANCE.getEShort().equals(type)
							|| EcorePackage.eINSTANCE.getEInt().equals(type)
							|| EcorePackage.eINSTANCE.getEFloat().equals(type) || EcorePackage.eINSTANCE
							.getEDouble().equals(type))) {
						String typename;
						if (type == null)
							typename = "null";
						else
							typename = type.getName();

						resource.addError(
								"The minus operator is not defined for "
										+ typename,
								PetrinetsEProblemType.ANALYSIS_PROBLEM, um);
					}
				}
			} else if (eObject instanceof Cast) {
				Cast c = (Cast) eObject;
				EClassifier castTarget = c.getType();
				EClassifier foundType = FunctionCallAnalysisHelper
						.getInstance().getType(c.getExpression());
				boolean isSubtype = FunctionCallAnalysisHelper.getInstance()
						.isSubtype(castTarget, foundType);
				if (!isSubtype) {
					String target;
					if (castTarget == null)
						target = "null";
					else
						target = castTarget.getName();
					String found;
					if (foundType == null)
						found = "null";
					else
						found = foundType.getName();

					resource.addError(
							"Casting to a non-subtype is not allowed. (cast target: "
									+ target + ", found: " + found + ")",
							PetrinetsEProblemType.ANALYSIS_PROBLEM, c);
				}
			}

		}

	}

	public void terminate() {
		// TODO Auto-generated method stub

	}

	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IPetrinetsOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return map;
	}

}
