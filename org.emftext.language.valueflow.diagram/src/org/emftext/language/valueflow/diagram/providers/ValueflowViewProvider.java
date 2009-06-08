package org.emftext.language.valueflow.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.valueflow.diagram.edit.parts.AgentAgentStatesCompartmentEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.AgentEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.AgentNameEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.GiveStateEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.GiveStateGiveToEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.GiveStateValueEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.InitialEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.InitialNameEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.ModelEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.StateNextStateEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.TakeStateEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.TakeStateNameEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.WrappingLabel2EditPart;
import org.emftext.language.valueflow.diagram.edit.parts.WrappingLabelEditPart;
import org.emftext.language.valueflow.diagram.part.ValueflowVisualIDRegistry;
import org.emftext.language.valueflow.diagram.view.factories.AgentAgentStatesCompartmentViewFactory;
import org.emftext.language.valueflow.diagram.view.factories.AgentNameViewFactory;
import org.emftext.language.valueflow.diagram.view.factories.AgentViewFactory;
import org.emftext.language.valueflow.diagram.view.factories.GiveStateGiveToViewFactory;
import org.emftext.language.valueflow.diagram.view.factories.GiveStateValueViewFactory;
import org.emftext.language.valueflow.diagram.view.factories.GiveStateViewFactory;
import org.emftext.language.valueflow.diagram.view.factories.InitialNameViewFactory;
import org.emftext.language.valueflow.diagram.view.factories.InitialViewFactory;
import org.emftext.language.valueflow.diagram.view.factories.ModelViewFactory;
import org.emftext.language.valueflow.diagram.view.factories.StateNextStateViewFactory;
import org.emftext.language.valueflow.diagram.view.factories.TakeStateNameViewFactory;
import org.emftext.language.valueflow.diagram.view.factories.TakeStateViewFactory;
import org.emftext.language.valueflow.diagram.view.factories.WrappingLabel2ViewFactory;
import org.emftext.language.valueflow.diagram.view.factories.WrappingLabelViewFactory;

/**
 * @generated
 */
public class ValueflowViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter,
			String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (ModelEditPart.MODEL_ID.equals(diagramKind)
				&& ValueflowVisualIDRegistry
						.getDiagramVisualID(semanticElement) != -1) {
			return ModelViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		if (containerView == null) {
			return null;
		}
		IElementType elementType = getSemanticElementType(semanticAdapter);
		EObject domainElement = getSemanticElement(semanticAdapter);
		int visualID;
		if (semanticHint == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if (elementType != null || domainElement == null) {
				return null;
			}
			visualID = ValueflowVisualIDRegistry.getNodeVisualID(containerView,
					domainElement);
		} else {
			visualID = ValueflowVisualIDRegistry.getVisualID(semanticHint);
			if (elementType != null) {
				// Semantic hint is specified together with element type.
				// Both parameters should describe exactly the same diagram element.
				// In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID() for
				// domainElement (if specified) is the same as in element type.
				if (!ValueflowElementTypes.isKnownElementType(elementType)
						|| (!(elementType instanceof IHintedType))) {
					return null; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType)
						.getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null
						&& visualID != ValueflowVisualIDRegistry
								.getNodeVisualID(containerView, domainElement)) {
					return null; // visual id for node EClass should match visual id from element type
				}
			} else {
				// Element type is not specified. Domain element should be present (except pure design elements).
				// This method is called with EObjectAdapter as parameter from:
				//   - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint preferencesHint) 
				//   - generated ViewFactory.decorateView() for parent element
				if (!ModelEditPart.MODEL_ID.equals(ValueflowVisualIDRegistry
						.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case AgentEditPart.VISUAL_ID:
				case InitialEditPart.VISUAL_ID:
				case GiveStateEditPart.VISUAL_ID:
				case TakeStateEditPart.VISUAL_ID:
					if (domainElement == null
							|| visualID != ValueflowVisualIDRegistry
									.getNodeVisualID(containerView,
											domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case AgentNameEditPart.VISUAL_ID:
				case AgentAgentStatesCompartmentEditPart.VISUAL_ID:
					if (AgentEditPart.VISUAL_ID != ValueflowVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case InitialNameEditPart.VISUAL_ID:
					if (InitialEditPart.VISUAL_ID != ValueflowVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case GiveStateValueEditPart.VISUAL_ID:
					if (GiveStateEditPart.VISUAL_ID != ValueflowVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case TakeStateNameEditPart.VISUAL_ID:
					if (TakeStateEditPart.VISUAL_ID != ValueflowVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case WrappingLabelEditPart.VISUAL_ID:
					if (StateNextStateEditPart.VISUAL_ID != ValueflowVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case WrappingLabel2EditPart.VISUAL_ID:
					if (GiveStateGiveToEditPart.VISUAL_ID != ValueflowVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				default:
					return null;
				}
			}
		}
		return getNodeViewClass(containerView, visualID);
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(View containerView, int visualID) {
		if (containerView == null
				|| !ValueflowVisualIDRegistry.canCreateNode(containerView,
						visualID)) {
			return null;
		}
		switch (visualID) {
		case AgentEditPart.VISUAL_ID:
			return AgentViewFactory.class;
		case AgentNameEditPart.VISUAL_ID:
			return AgentNameViewFactory.class;
		case InitialEditPart.VISUAL_ID:
			return InitialViewFactory.class;
		case InitialNameEditPart.VISUAL_ID:
			return InitialNameViewFactory.class;
		case GiveStateEditPart.VISUAL_ID:
			return GiveStateViewFactory.class;
		case GiveStateValueEditPart.VISUAL_ID:
			return GiveStateValueViewFactory.class;
		case TakeStateEditPart.VISUAL_ID:
			return TakeStateViewFactory.class;
		case TakeStateNameEditPart.VISUAL_ID:
			return TakeStateNameViewFactory.class;
		case AgentAgentStatesCompartmentEditPart.VISUAL_ID:
			return AgentAgentStatesCompartmentViewFactory.class;
		case WrappingLabelEditPart.VISUAL_ID:
			return WrappingLabelViewFactory.class;
		case WrappingLabel2EditPart.VISUAL_ID:
			return WrappingLabel2ViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (!ValueflowElementTypes.isKnownElementType(elementType)
				|| (!(elementType instanceof IHintedType))) {
			return null; // foreign element type
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null) {
			return null; // our hint is visual id and must be specified
		}
		if (semanticHint != null && !semanticHint.equals(elementTypeHint)) {
			return null; // if semantic hint is specified it should be the same as in element type
		}
		int visualID = ValueflowVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null
				&& visualID != ValueflowVisualIDRegistry
						.getLinkWithClassVisualID(domainElement)) {
			return null; // visual id for link EClass should match visual id from element type
		}
		return getEdgeViewClass(visualID);
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(int visualID) {
		switch (visualID) {
		case StateNextStateEditPart.VISUAL_ID:
			return StateNextStateViewFactory.class;
		case GiveStateGiveToEditPart.VISUAL_ID:
			return GiveStateGiveToViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}
}
