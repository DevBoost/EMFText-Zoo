package org.emftext.language.valueflow.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.valueflow.Agent;
import org.emftext.language.valueflow.GiveState;
import org.emftext.language.valueflow.Initial;
import org.emftext.language.valueflow.Model;
import org.emftext.language.valueflow.State;
import org.emftext.language.valueflow.TakeState;
import org.emftext.language.valueflow.ValueflowPackage;
import org.emftext.language.valueflow.diagram.edit.parts.AgentAgentStatesCompartmentEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.AgentEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.GiveStateEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.GiveStateGiveToEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.InitialEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.ModelEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.StateNextStateEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.TakeStateEditPart;
import org.emftext.language.valueflow.diagram.providers.ValueflowElementTypes;

/**
 * @generated
 */
public class ValueflowDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null
				|| view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (ValueflowVisualIDRegistry.getVisualID(view)) {
		case AgentAgentStatesCompartmentEditPart.VISUAL_ID:
			return getAgentAgentStatesCompartment_5001SemanticChildren(view);
		case ModelEditPart.VISUAL_ID:
			return getModel_79SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAgentAgentStatesCompartment_5001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Agent modelElement = (Agent) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getStates().iterator(); it.hasNext();) {
			State childElement = (State) it.next();
			int visualID = ValueflowVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == InitialEditPart.VISUAL_ID) {
				result.add(new ValueflowNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == GiveStateEditPart.VISUAL_ID) {
				result.add(new ValueflowNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TakeStateEditPart.VISUAL_ID) {
				result.add(new ValueflowNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_79SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Model modelElement = (Model) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getAgents().iterator(); it.hasNext();) {
			Agent childElement = (Agent) it.next();
			int visualID = ValueflowVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == AgentEditPart.VISUAL_ID) {
				result.add(new ValueflowNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (ValueflowVisualIDRegistry.getVisualID(view)) {
		case ModelEditPart.VISUAL_ID:
			return getModel_79ContainedLinks(view);
		case AgentEditPart.VISUAL_ID:
			return getAgent_1001ContainedLinks(view);
		case InitialEditPart.VISUAL_ID:
			return getInitial_2001ContainedLinks(view);
		case GiveStateEditPart.VISUAL_ID:
			return getGiveState_2002ContainedLinks(view);
		case TakeStateEditPart.VISUAL_ID:
			return getTakeState_2003ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (ValueflowVisualIDRegistry.getVisualID(view)) {
		case AgentEditPart.VISUAL_ID:
			return getAgent_1001IncomingLinks(view);
		case InitialEditPart.VISUAL_ID:
			return getInitial_2001IncomingLinks(view);
		case GiveStateEditPart.VISUAL_ID:
			return getGiveState_2002IncomingLinks(view);
		case TakeStateEditPart.VISUAL_ID:
			return getTakeState_2003IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (ValueflowVisualIDRegistry.getVisualID(view)) {
		case AgentEditPart.VISUAL_ID:
			return getAgent_1001OutgoingLinks(view);
		case InitialEditPart.VISUAL_ID:
			return getInitial_2001OutgoingLinks(view);
		case GiveStateEditPart.VISUAL_ID:
			return getGiveState_2002OutgoingLinks(view);
		case TakeStateEditPart.VISUAL_ID:
			return getTakeState_2003OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getModel_79ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAgent_1001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInitial_2001ContainedLinks(View view) {
		Initial modelElement = (Initial) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_State_NextState_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGiveState_2002ContainedLinks(View view) {
		GiveState modelElement = (GiveState) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_State_NextState_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_GiveState_GiveTo_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTakeState_2003ContainedLinks(View view) {
		TakeState modelElement = (TakeState) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_State_NextState_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAgent_1001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInitial_2001IncomingLinks(View view) {
		Initial modelElement = (Initial) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_State_NextState_3001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGiveState_2002IncomingLinks(View view) {
		GiveState modelElement = (GiveState) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_State_NextState_3001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTakeState_2003IncomingLinks(View view) {
		TakeState modelElement = (TakeState) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_State_NextState_3001(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_GiveState_GiveTo_3002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAgent_1001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInitial_2001OutgoingLinks(View view) {
		Initial modelElement = (Initial) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_State_NextState_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGiveState_2002OutgoingLinks(View view) {
		GiveState modelElement = (GiveState) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_State_NextState_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_GiveState_GiveTo_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTakeState_2003OutgoingLinks(View view) {
		TakeState modelElement = (TakeState) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_State_NextState_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_State_NextState_3001(
			State target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == ValueflowPackage.eINSTANCE
					.getState_NextState()) {
				result.add(new ValueflowLinkDescriptor(setting.getEObject(),
						target, ValueflowElementTypes.StateNextState_3001,
						StateNextStateEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_GiveState_GiveTo_3002(
			TakeState target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == ValueflowPackage.eINSTANCE
					.getGiveState_GiveTo()) {
				result.add(new ValueflowLinkDescriptor(setting.getEObject(),
						target, ValueflowElementTypes.GiveStateGiveTo_3002,
						GiveStateGiveToEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_State_NextState_3001(
			State source) {
		Collection result = new LinkedList();
		State destination = source.getNextState();
		if (destination == null) {
			return result;
		}
		result.add(new ValueflowLinkDescriptor(source, destination,
				ValueflowElementTypes.StateNextState_3001,
				StateNextStateEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_GiveState_GiveTo_3002(
			GiveState source) {
		Collection result = new LinkedList();
		TakeState destination = source.getGiveTo();
		if (destination == null) {
			return result;
		}
		result.add(new ValueflowLinkDescriptor(source, destination,
				ValueflowElementTypes.GiveStateGiveTo_3002,
				GiveStateGiveToEditPart.VISUAL_ID));
		return result;
	}

}
