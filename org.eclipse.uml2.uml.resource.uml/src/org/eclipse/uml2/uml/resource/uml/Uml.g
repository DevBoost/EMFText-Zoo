grammar Uml;
options {superClass = EMFTextParserImpl; backtrack = true;}

@lexer::header{
package org.eclipse.uml2.uml.resource.uml;

}

@lexer::members{
	public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition       = new java.util.ArrayList<Integer>();

	public void reportError(RecognitionException e) {
		lexerExceptions.add(e);

		lexerExceptionsPosition.add(((ANTLRStringStream)input).index());
	}
}
@header{
package org.eclipse.uml2.uml.resource.uml;

//+++++++++++++++++++++++imports for org.eclipse.uml2.uml begin++++++++++++++++++++++
import org.eclipse.uml2.uml.Comment;
//Implementation: org.eclipse.uml2.uml.internal.impl.CommentImpl
import org.eclipse.uml2.uml.Element;
//Implementation: org.eclipse.uml2.uml.internal.impl.ElementImpl
import org.eclipse.uml2.uml.Package;
//Implementation: org.eclipse.uml2.uml.internal.impl.PackageImpl
import org.eclipse.uml2.uml.PackageableElement;
//Implementation: org.eclipse.uml2.uml.internal.impl.PackageableElementImpl
import org.eclipse.uml2.uml.NamedElement;
//Implementation: org.eclipse.uml2.uml.internal.impl.NamedElementImpl
import org.eclipse.uml2.uml.Dependency;
//Implementation: org.eclipse.uml2.uml.internal.impl.DependencyImpl
import org.eclipse.uml2.uml.DirectedRelationship;
//Implementation: org.eclipse.uml2.uml.internal.impl.DirectedRelationshipImpl
import org.eclipse.uml2.uml.Relationship;
//Implementation: org.eclipse.uml2.uml.internal.impl.RelationshipImpl
import org.eclipse.uml2.uml.Namespace;
//Implementation: org.eclipse.uml2.uml.internal.impl.NamespaceImpl
import org.eclipse.uml2.uml.ElementImport;
//Implementation: org.eclipse.uml2.uml.internal.impl.ElementImportImpl
import org.eclipse.uml2.uml.PackageImport;
//Implementation: org.eclipse.uml2.uml.internal.impl.PackageImportImpl
import org.eclipse.uml2.uml.Constraint;
//Implementation: org.eclipse.uml2.uml.internal.impl.ConstraintImpl
import org.eclipse.uml2.uml.ValueSpecification;
//Implementation: org.eclipse.uml2.uml.internal.impl.ValueSpecificationImpl
import org.eclipse.uml2.uml.TypedElement;
//Implementation: org.eclipse.uml2.uml.internal.impl.TypedElementImpl
import org.eclipse.uml2.uml.Type;
//Implementation: org.eclipse.uml2.uml.internal.impl.TypeImpl
import org.eclipse.uml2.uml.Association;
//Implementation: org.eclipse.uml2.uml.internal.impl.AssociationImpl
import org.eclipse.uml2.uml.Classifier;
//Implementation: org.eclipse.uml2.uml.internal.impl.ClassifierImpl
import org.eclipse.uml2.uml.RedefinableElement;
//Implementation: org.eclipse.uml2.uml.internal.impl.RedefinableElementImpl
import org.eclipse.uml2.uml.TemplateableElement;
//Implementation: org.eclipse.uml2.uml.internal.impl.TemplateableElementImpl
import org.eclipse.uml2.uml.TemplateBinding;
//Implementation: org.eclipse.uml2.uml.internal.impl.TemplateBindingImpl
import org.eclipse.uml2.uml.TemplateSignature;
//Implementation: org.eclipse.uml2.uml.internal.impl.TemplateSignatureImpl
import org.eclipse.uml2.uml.TemplateParameter;
//Implementation: org.eclipse.uml2.uml.internal.impl.TemplateParameterImpl
import org.eclipse.uml2.uml.ParameterableElement;
//Implementation: org.eclipse.uml2.uml.internal.impl.ParameterableElementImpl
import org.eclipse.uml2.uml.TemplateParameterSubstitution;
//Implementation: org.eclipse.uml2.uml.internal.impl.TemplateParameterSubstitutionImpl
import org.eclipse.uml2.uml.Generalization;
//Implementation: org.eclipse.uml2.uml.internal.impl.GeneralizationImpl
import org.eclipse.uml2.uml.GeneralizationSet;
//Implementation: org.eclipse.uml2.uml.internal.impl.GeneralizationSetImpl
import org.eclipse.uml2.uml.Feature;
//Implementation: org.eclipse.uml2.uml.internal.impl.FeatureImpl
import org.eclipse.uml2.uml.Substitution;
//Implementation: org.eclipse.uml2.uml.internal.impl.SubstitutionImpl
import org.eclipse.uml2.uml.Realization;
//Implementation: org.eclipse.uml2.uml.internal.impl.RealizationImpl
import org.eclipse.uml2.uml.Abstraction;
//Implementation: org.eclipse.uml2.uml.internal.impl.AbstractionImpl
import org.eclipse.uml2.uml.OpaqueExpression;
//Implementation: org.eclipse.uml2.uml.internal.impl.OpaqueExpressionImpl
import org.eclipse.uml2.uml.Parameter;
//Implementation: org.eclipse.uml2.uml.internal.impl.ParameterImpl
import org.eclipse.uml2.uml.MultiplicityElement;
//Implementation: org.eclipse.uml2.uml.internal.impl.MultiplicityElementImpl
import org.eclipse.uml2.uml.ConnectableElement;
//Implementation: org.eclipse.uml2.uml.internal.impl.ConnectableElementImpl
import org.eclipse.uml2.uml.ConnectableElementTemplateParameter;
//Implementation: org.eclipse.uml2.uml.internal.impl.ConnectableElementTemplateParameterImpl
import org.eclipse.uml2.uml.ConnectorEnd;
//Implementation: org.eclipse.uml2.uml.internal.impl.ConnectorEndImpl
import org.eclipse.uml2.uml.Property;
//Implementation: org.eclipse.uml2.uml.internal.impl.PropertyImpl
import org.eclipse.uml2.uml.DeploymentTarget;
//Implementation: org.eclipse.uml2.uml.internal.impl.DeploymentTargetImpl
import org.eclipse.uml2.uml.Deployment;
//Implementation: org.eclipse.uml2.uml.internal.impl.DeploymentImpl
import org.eclipse.uml2.uml.DeployedArtifact;
//Implementation: org.eclipse.uml2.uml.internal.impl.DeployedArtifactImpl
import org.eclipse.uml2.uml.DeploymentSpecification;
//Implementation: org.eclipse.uml2.uml.internal.impl.DeploymentSpecificationImpl
import org.eclipse.uml2.uml.Artifact;
//Implementation: org.eclipse.uml2.uml.internal.impl.ArtifactImpl
import org.eclipse.uml2.uml.Manifestation;
//Implementation: org.eclipse.uml2.uml.internal.impl.ManifestationImpl
import org.eclipse.uml2.uml.Operation;
//Implementation: org.eclipse.uml2.uml.internal.impl.OperationImpl
import org.eclipse.uml2.uml.BehavioralFeature;
//Implementation: org.eclipse.uml2.uml.internal.impl.BehavioralFeatureImpl
import org.eclipse.uml2.uml.Behavior;
//Implementation: org.eclipse.uml2.uml.internal.impl.BehaviorImpl
import org.eclipse.uml2.uml.Class;
//Implementation: org.eclipse.uml2.uml.internal.impl.ClassImpl
import org.eclipse.uml2.uml.BehavioredClassifier;
//Implementation: org.eclipse.uml2.uml.internal.impl.BehavioredClassifierImpl
import org.eclipse.uml2.uml.InterfaceRealization;
//Implementation: org.eclipse.uml2.uml.internal.impl.InterfaceRealizationImpl
import org.eclipse.uml2.uml.Interface;
//Implementation: org.eclipse.uml2.uml.internal.impl.InterfaceImpl
import org.eclipse.uml2.uml.Reception;
//Implementation: org.eclipse.uml2.uml.internal.impl.ReceptionImpl
import org.eclipse.uml2.uml.Signal;
//Implementation: org.eclipse.uml2.uml.internal.impl.SignalImpl
import org.eclipse.uml2.uml.ProtocolStateMachine;
//Implementation: org.eclipse.uml2.uml.internal.impl.ProtocolStateMachineImpl
import org.eclipse.uml2.uml.StateMachine;
//Implementation: org.eclipse.uml2.uml.internal.impl.StateMachineImpl
import org.eclipse.uml2.uml.Region;
//Implementation: org.eclipse.uml2.uml.internal.impl.RegionImpl
import org.eclipse.uml2.uml.Vertex;
//Implementation: org.eclipse.uml2.uml.internal.impl.VertexImpl
import org.eclipse.uml2.uml.Transition;
//Implementation: org.eclipse.uml2.uml.internal.impl.TransitionImpl
import org.eclipse.uml2.uml.Trigger;
//Implementation: org.eclipse.uml2.uml.internal.impl.TriggerImpl
import org.eclipse.uml2.uml.Event;
//Implementation: org.eclipse.uml2.uml.internal.impl.EventImpl
import org.eclipse.uml2.uml.Port;
//Implementation: org.eclipse.uml2.uml.internal.impl.PortImpl
import org.eclipse.uml2.uml.State;
//Implementation: org.eclipse.uml2.uml.internal.impl.StateImpl
import org.eclipse.uml2.uml.ConnectionPointReference;
//Implementation: org.eclipse.uml2.uml.internal.impl.ConnectionPointReferenceImpl
import org.eclipse.uml2.uml.Pseudostate;
//Implementation: org.eclipse.uml2.uml.internal.impl.PseudostateImpl
import org.eclipse.uml2.uml.ProtocolConformance;
//Implementation: org.eclipse.uml2.uml.internal.impl.ProtocolConformanceImpl
import org.eclipse.uml2.uml.EncapsulatedClassifier;
//Implementation: org.eclipse.uml2.uml.internal.impl.EncapsulatedClassifierImpl
import org.eclipse.uml2.uml.StructuredClassifier;
//Implementation: org.eclipse.uml2.uml.internal.impl.StructuredClassifierImpl
import org.eclipse.uml2.uml.Connector;
//Implementation: org.eclipse.uml2.uml.internal.impl.ConnectorImpl
import org.eclipse.uml2.uml.Extension;
//Implementation: org.eclipse.uml2.uml.internal.impl.ExtensionImpl
import org.eclipse.uml2.uml.ExtensionEnd;
//Implementation: org.eclipse.uml2.uml.internal.impl.ExtensionEndImpl
import org.eclipse.uml2.uml.Stereotype;
//Implementation: org.eclipse.uml2.uml.internal.impl.StereotypeImpl
import org.eclipse.uml2.uml.Image;
//Implementation: org.eclipse.uml2.uml.internal.impl.ImageImpl
import org.eclipse.uml2.uml.Profile;
//Implementation: org.eclipse.uml2.uml.internal.impl.ProfileImpl
import org.eclipse.uml2.uml.Model;
//Implementation: org.eclipse.uml2.uml.internal.impl.ModelImpl
import org.eclipse.uml2.uml.ParameterSet;
//Implementation: org.eclipse.uml2.uml.internal.impl.ParameterSetImpl
import org.eclipse.uml2.uml.DataType;
//Implementation: org.eclipse.uml2.uml.internal.impl.DataTypeImpl
import org.eclipse.uml2.uml.OperationTemplateParameter;
//Implementation: org.eclipse.uml2.uml.internal.impl.OperationTemplateParameterImpl
import org.eclipse.uml2.uml.StructuralFeature;
//Implementation: org.eclipse.uml2.uml.internal.impl.StructuralFeatureImpl
import org.eclipse.uml2.uml.CollaborationUse;
//Implementation: org.eclipse.uml2.uml.internal.impl.CollaborationUseImpl
import org.eclipse.uml2.uml.Collaboration;
//Implementation: org.eclipse.uml2.uml.internal.impl.CollaborationImpl
import org.eclipse.uml2.uml.UseCase;
//Implementation: org.eclipse.uml2.uml.internal.impl.UseCaseImpl
import org.eclipse.uml2.uml.Include;
//Implementation: org.eclipse.uml2.uml.internal.impl.IncludeImpl
import org.eclipse.uml2.uml.Extend;
//Implementation: org.eclipse.uml2.uml.internal.impl.ExtendImpl
import org.eclipse.uml2.uml.ExtensionPoint;
//Implementation: org.eclipse.uml2.uml.internal.impl.ExtensionPointImpl
import org.eclipse.uml2.uml.RedefinableTemplateSignature;
//Implementation: org.eclipse.uml2.uml.internal.impl.RedefinableTemplateSignatureImpl
import org.eclipse.uml2.uml.ClassifierTemplateParameter;
//Implementation: org.eclipse.uml2.uml.internal.impl.ClassifierTemplateParameterImpl
import org.eclipse.uml2.uml.StringExpression;
//Implementation: org.eclipse.uml2.uml.internal.impl.StringExpressionImpl
import org.eclipse.uml2.uml.Expression;
//Implementation: org.eclipse.uml2.uml.internal.impl.ExpressionImpl
import org.eclipse.uml2.uml.Usage;
//Implementation: org.eclipse.uml2.uml.internal.impl.UsageImpl
import org.eclipse.uml2.uml.PackageMerge;
//Implementation: org.eclipse.uml2.uml.internal.impl.PackageMergeImpl
import org.eclipse.uml2.uml.ProfileApplication;
//Implementation: org.eclipse.uml2.uml.internal.impl.ProfileApplicationImpl
import org.eclipse.uml2.uml.Enumeration;
//Implementation: org.eclipse.uml2.uml.internal.impl.EnumerationImpl
import org.eclipse.uml2.uml.EnumerationLiteral;
//Implementation: org.eclipse.uml2.uml.internal.impl.EnumerationLiteralImpl
import org.eclipse.uml2.uml.InstanceSpecification;
//Implementation: org.eclipse.uml2.uml.internal.impl.InstanceSpecificationImpl
import org.eclipse.uml2.uml.Slot;
//Implementation: org.eclipse.uml2.uml.internal.impl.SlotImpl
import org.eclipse.uml2.uml.PrimitiveType;
//Implementation: org.eclipse.uml2.uml.internal.impl.PrimitiveTypeImpl
import org.eclipse.uml2.uml.LiteralSpecification;
//Implementation: org.eclipse.uml2.uml.internal.impl.LiteralSpecificationImpl
import org.eclipse.uml2.uml.LiteralInteger;
//Implementation: org.eclipse.uml2.uml.internal.impl.LiteralIntegerImpl
import org.eclipse.uml2.uml.LiteralString;
//Implementation: org.eclipse.uml2.uml.internal.impl.LiteralStringImpl
import org.eclipse.uml2.uml.LiteralBoolean;
//Implementation: org.eclipse.uml2.uml.internal.impl.LiteralBooleanImpl
import org.eclipse.uml2.uml.LiteralNull;
//Implementation: org.eclipse.uml2.uml.internal.impl.LiteralNullImpl
import org.eclipse.uml2.uml.InstanceValue;
//Implementation: org.eclipse.uml2.uml.internal.impl.InstanceValueImpl
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
//Implementation: org.eclipse.uml2.uml.internal.impl.LiteralUnlimitedNaturalImpl
import org.eclipse.uml2.uml.OpaqueBehavior;
//Implementation: org.eclipse.uml2.uml.internal.impl.OpaqueBehaviorImpl
import org.eclipse.uml2.uml.FunctionBehavior;
//Implementation: org.eclipse.uml2.uml.internal.impl.FunctionBehaviorImpl
import org.eclipse.uml2.uml.OpaqueAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.OpaqueActionImpl
import org.eclipse.uml2.uml.Action;
//Implementation: org.eclipse.uml2.uml.internal.impl.ActionImpl
import org.eclipse.uml2.uml.ExecutableNode;
//Implementation: org.eclipse.uml2.uml.internal.impl.ExecutableNodeImpl
import org.eclipse.uml2.uml.ActivityNode;
//Implementation: org.eclipse.uml2.uml.internal.impl.ActivityNodeImpl
import org.eclipse.uml2.uml.StructuredActivityNode;
//Implementation: org.eclipse.uml2.uml.internal.impl.StructuredActivityNodeImpl
import org.eclipse.uml2.uml.ActivityGroup;
//Implementation: org.eclipse.uml2.uml.internal.impl.ActivityGroupImpl
import org.eclipse.uml2.uml.Activity;
//Implementation: org.eclipse.uml2.uml.internal.impl.ActivityImpl
import org.eclipse.uml2.uml.Variable;
//Implementation: org.eclipse.uml2.uml.internal.impl.VariableImpl
import org.eclipse.uml2.uml.ActivityEdge;
//Implementation: org.eclipse.uml2.uml.internal.impl.ActivityEdgeImpl
import org.eclipse.uml2.uml.ActivityPartition;
//Implementation: org.eclipse.uml2.uml.internal.impl.ActivityPartitionImpl
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
//Implementation: org.eclipse.uml2.uml.internal.impl.InterruptibleActivityRegionImpl
import org.eclipse.uml2.uml.ExceptionHandler;
//Implementation: org.eclipse.uml2.uml.internal.impl.ExceptionHandlerImpl
import org.eclipse.uml2.uml.ObjectNode;
//Implementation: org.eclipse.uml2.uml.internal.impl.ObjectNodeImpl
import org.eclipse.uml2.uml.OutputPin;
//Implementation: org.eclipse.uml2.uml.internal.impl.OutputPinImpl
import org.eclipse.uml2.uml.Pin;
//Implementation: org.eclipse.uml2.uml.internal.impl.PinImpl
import org.eclipse.uml2.uml.InputPin;
//Implementation: org.eclipse.uml2.uml.internal.impl.InputPinImpl
import org.eclipse.uml2.uml.CallAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.CallActionImpl
import org.eclipse.uml2.uml.InvocationAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.InvocationActionImpl
import org.eclipse.uml2.uml.SendSignalAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.SendSignalActionImpl
import org.eclipse.uml2.uml.CallOperationAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.CallOperationActionImpl
import org.eclipse.uml2.uml.CallBehaviorAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.CallBehaviorActionImpl
import org.eclipse.uml2.uml.SequenceNode;
//Implementation: org.eclipse.uml2.uml.internal.impl.SequenceNodeImpl
import org.eclipse.uml2.uml.ControlNode;
//Implementation: org.eclipse.uml2.uml.internal.impl.ControlNodeImpl
import org.eclipse.uml2.uml.ControlFlow;
//Implementation: org.eclipse.uml2.uml.internal.impl.ControlFlowImpl
import org.eclipse.uml2.uml.InitialNode;
//Implementation: org.eclipse.uml2.uml.internal.impl.InitialNodeImpl
import org.eclipse.uml2.uml.ActivityParameterNode;
//Implementation: org.eclipse.uml2.uml.internal.impl.ActivityParameterNodeImpl
import org.eclipse.uml2.uml.ValuePin;
//Implementation: org.eclipse.uml2.uml.internal.impl.ValuePinImpl
import org.eclipse.uml2.uml.Message;
//Implementation: org.eclipse.uml2.uml.internal.impl.MessageImpl
import org.eclipse.uml2.uml.MessageEnd;
//Implementation: org.eclipse.uml2.uml.internal.impl.MessageEndImpl
import org.eclipse.uml2.uml.Interaction;
//Implementation: org.eclipse.uml2.uml.internal.impl.InteractionImpl
import org.eclipse.uml2.uml.InteractionFragment;
//Implementation: org.eclipse.uml2.uml.internal.impl.InteractionFragmentImpl
import org.eclipse.uml2.uml.Lifeline;
//Implementation: org.eclipse.uml2.uml.internal.impl.LifelineImpl
import org.eclipse.uml2.uml.PartDecomposition;
//Implementation: org.eclipse.uml2.uml.internal.impl.PartDecompositionImpl
import org.eclipse.uml2.uml.InteractionUse;
//Implementation: org.eclipse.uml2.uml.internal.impl.InteractionUseImpl
import org.eclipse.uml2.uml.Gate;
//Implementation: org.eclipse.uml2.uml.internal.impl.GateImpl
import org.eclipse.uml2.uml.GeneralOrdering;
//Implementation: org.eclipse.uml2.uml.internal.impl.GeneralOrderingImpl
import org.eclipse.uml2.uml.OccurrenceSpecification;
//Implementation: org.eclipse.uml2.uml.internal.impl.OccurrenceSpecificationImpl
import org.eclipse.uml2.uml.InteractionOperand;
//Implementation: org.eclipse.uml2.uml.internal.impl.InteractionOperandImpl
import org.eclipse.uml2.uml.InteractionConstraint;
//Implementation: org.eclipse.uml2.uml.internal.impl.InteractionConstraintImpl
import org.eclipse.uml2.uml.ExecutionSpecification;
//Implementation: org.eclipse.uml2.uml.internal.impl.ExecutionSpecificationImpl
import org.eclipse.uml2.uml.StateInvariant;
//Implementation: org.eclipse.uml2.uml.internal.impl.StateInvariantImpl
import org.eclipse.uml2.uml.ActionExecutionSpecification;
//Implementation: org.eclipse.uml2.uml.internal.impl.ActionExecutionSpecificationImpl
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
//Implementation: org.eclipse.uml2.uml.internal.impl.BehaviorExecutionSpecificationImpl
import org.eclipse.uml2.uml.ExecutionEvent;
//Implementation: org.eclipse.uml2.uml.internal.impl.ExecutionEventImpl
import org.eclipse.uml2.uml.CreationEvent;
//Implementation: org.eclipse.uml2.uml.internal.impl.CreationEventImpl
import org.eclipse.uml2.uml.DestructionEvent;
//Implementation: org.eclipse.uml2.uml.internal.impl.DestructionEventImpl
import org.eclipse.uml2.uml.SendOperationEvent;
//Implementation: org.eclipse.uml2.uml.internal.impl.SendOperationEventImpl
import org.eclipse.uml2.uml.MessageEvent;
//Implementation: org.eclipse.uml2.uml.internal.impl.MessageEventImpl
import org.eclipse.uml2.uml.SendSignalEvent;
//Implementation: org.eclipse.uml2.uml.internal.impl.SendSignalEventImpl
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
//Implementation: org.eclipse.uml2.uml.internal.impl.MessageOccurrenceSpecificationImpl
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
//Implementation: org.eclipse.uml2.uml.internal.impl.ExecutionOccurrenceSpecificationImpl
import org.eclipse.uml2.uml.ReceiveOperationEvent;
//Implementation: org.eclipse.uml2.uml.internal.impl.ReceiveOperationEventImpl
import org.eclipse.uml2.uml.ReceiveSignalEvent;
//Implementation: org.eclipse.uml2.uml.internal.impl.ReceiveSignalEventImpl
import org.eclipse.uml2.uml.Actor;
//Implementation: org.eclipse.uml2.uml.internal.impl.ActorImpl
import org.eclipse.uml2.uml.CallEvent;
//Implementation: org.eclipse.uml2.uml.internal.impl.CallEventImpl
import org.eclipse.uml2.uml.ChangeEvent;
//Implementation: org.eclipse.uml2.uml.internal.impl.ChangeEventImpl
import org.eclipse.uml2.uml.SignalEvent;
//Implementation: org.eclipse.uml2.uml.internal.impl.SignalEventImpl
import org.eclipse.uml2.uml.AnyReceiveEvent;
//Implementation: org.eclipse.uml2.uml.internal.impl.AnyReceiveEventImpl
import org.eclipse.uml2.uml.ForkNode;
//Implementation: org.eclipse.uml2.uml.internal.impl.ForkNodeImpl
import org.eclipse.uml2.uml.FlowFinalNode;
//Implementation: org.eclipse.uml2.uml.internal.impl.FlowFinalNodeImpl
import org.eclipse.uml2.uml.FinalNode;
//Implementation: org.eclipse.uml2.uml.internal.impl.FinalNodeImpl
import org.eclipse.uml2.uml.CentralBufferNode;
//Implementation: org.eclipse.uml2.uml.internal.impl.CentralBufferNodeImpl
import org.eclipse.uml2.uml.MergeNode;
//Implementation: org.eclipse.uml2.uml.internal.impl.MergeNodeImpl
import org.eclipse.uml2.uml.DecisionNode;
//Implementation: org.eclipse.uml2.uml.internal.impl.DecisionNodeImpl
import org.eclipse.uml2.uml.ActivityFinalNode;
//Implementation: org.eclipse.uml2.uml.internal.impl.ActivityFinalNodeImpl
import org.eclipse.uml2.uml.ComponentRealization;
//Implementation: org.eclipse.uml2.uml.internal.impl.ComponentRealizationImpl
import org.eclipse.uml2.uml.Component;
//Implementation: org.eclipse.uml2.uml.internal.impl.ComponentImpl
import org.eclipse.uml2.uml.Node;
//Implementation: org.eclipse.uml2.uml.internal.impl.NodeImpl
import org.eclipse.uml2.uml.CommunicationPath;
//Implementation: org.eclipse.uml2.uml.internal.impl.CommunicationPathImpl
import org.eclipse.uml2.uml.Device;
//Implementation: org.eclipse.uml2.uml.internal.impl.DeviceImpl
import org.eclipse.uml2.uml.ExecutionEnvironment;
//Implementation: org.eclipse.uml2.uml.internal.impl.ExecutionEnvironmentImpl
import org.eclipse.uml2.uml.CombinedFragment;
//Implementation: org.eclipse.uml2.uml.internal.impl.CombinedFragmentImpl
import org.eclipse.uml2.uml.Continuation;
//Implementation: org.eclipse.uml2.uml.internal.impl.ContinuationImpl
import org.eclipse.uml2.uml.ConsiderIgnoreFragment;
//Implementation: org.eclipse.uml2.uml.internal.impl.ConsiderIgnoreFragmentImpl
import org.eclipse.uml2.uml.CreateObjectAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.CreateObjectActionImpl
import org.eclipse.uml2.uml.DestroyObjectAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.DestroyObjectActionImpl
import org.eclipse.uml2.uml.TestIdentityAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.TestIdentityActionImpl
import org.eclipse.uml2.uml.ReadSelfAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.ReadSelfActionImpl
import org.eclipse.uml2.uml.StructuralFeatureAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.StructuralFeatureActionImpl
import org.eclipse.uml2.uml.ReadStructuralFeatureAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.ReadStructuralFeatureActionImpl
import org.eclipse.uml2.uml.WriteStructuralFeatureAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.WriteStructuralFeatureActionImpl
import org.eclipse.uml2.uml.ClearStructuralFeatureAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.ClearStructuralFeatureActionImpl
import org.eclipse.uml2.uml.RemoveStructuralFeatureValueAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.RemoveStructuralFeatureValueActionImpl
import org.eclipse.uml2.uml.AddStructuralFeatureValueAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.AddStructuralFeatureValueActionImpl
import org.eclipse.uml2.uml.LinkAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.LinkActionImpl
import org.eclipse.uml2.uml.LinkEndData;
//Implementation: org.eclipse.uml2.uml.internal.impl.LinkEndDataImpl
import org.eclipse.uml2.uml.QualifierValue;
//Implementation: org.eclipse.uml2.uml.internal.impl.QualifierValueImpl
import org.eclipse.uml2.uml.ReadLinkAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.ReadLinkActionImpl
import org.eclipse.uml2.uml.LinkEndCreationData;
//Implementation: org.eclipse.uml2.uml.internal.impl.LinkEndCreationDataImpl
import org.eclipse.uml2.uml.CreateLinkAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.CreateLinkActionImpl
import org.eclipse.uml2.uml.WriteLinkAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.WriteLinkActionImpl
import org.eclipse.uml2.uml.DestroyLinkAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.DestroyLinkActionImpl
import org.eclipse.uml2.uml.LinkEndDestructionData;
//Implementation: org.eclipse.uml2.uml.internal.impl.LinkEndDestructionDataImpl
import org.eclipse.uml2.uml.ClearAssociationAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.ClearAssociationActionImpl
import org.eclipse.uml2.uml.BroadcastSignalAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.BroadcastSignalActionImpl
import org.eclipse.uml2.uml.SendObjectAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.SendObjectActionImpl
import org.eclipse.uml2.uml.ValueSpecificationAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.ValueSpecificationActionImpl
import org.eclipse.uml2.uml.TimeExpression;
//Implementation: org.eclipse.uml2.uml.internal.impl.TimeExpressionImpl
import org.eclipse.uml2.uml.Observation;
//Implementation: org.eclipse.uml2.uml.internal.impl.ObservationImpl
import org.eclipse.uml2.uml.Duration;
//Implementation: org.eclipse.uml2.uml.internal.impl.DurationImpl
import org.eclipse.uml2.uml.DurationInterval;
//Implementation: org.eclipse.uml2.uml.internal.impl.DurationIntervalImpl
import org.eclipse.uml2.uml.Interval;
//Implementation: org.eclipse.uml2.uml.internal.impl.IntervalImpl
import org.eclipse.uml2.uml.TimeConstraint;
//Implementation: org.eclipse.uml2.uml.internal.impl.TimeConstraintImpl
import org.eclipse.uml2.uml.IntervalConstraint;
//Implementation: org.eclipse.uml2.uml.internal.impl.IntervalConstraintImpl
import org.eclipse.uml2.uml.TimeInterval;
//Implementation: org.eclipse.uml2.uml.internal.impl.TimeIntervalImpl
import org.eclipse.uml2.uml.DurationConstraint;
//Implementation: org.eclipse.uml2.uml.internal.impl.DurationConstraintImpl
import org.eclipse.uml2.uml.TimeObservation;
//Implementation: org.eclipse.uml2.uml.internal.impl.TimeObservationImpl
import org.eclipse.uml2.uml.DurationObservation;
//Implementation: org.eclipse.uml2.uml.internal.impl.DurationObservationImpl
import org.eclipse.uml2.uml.FinalState;
//Implementation: org.eclipse.uml2.uml.internal.impl.FinalStateImpl
import org.eclipse.uml2.uml.TimeEvent;
//Implementation: org.eclipse.uml2.uml.internal.impl.TimeEventImpl
import org.eclipse.uml2.uml.VariableAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.VariableActionImpl
import org.eclipse.uml2.uml.ReadVariableAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.ReadVariableActionImpl
import org.eclipse.uml2.uml.WriteVariableAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.WriteVariableActionImpl
import org.eclipse.uml2.uml.ClearVariableAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.ClearVariableActionImpl
import org.eclipse.uml2.uml.AddVariableValueAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.AddVariableValueActionImpl
import org.eclipse.uml2.uml.RemoveVariableValueAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.RemoveVariableValueActionImpl
import org.eclipse.uml2.uml.RaiseExceptionAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.RaiseExceptionActionImpl
import org.eclipse.uml2.uml.ActionInputPin;
//Implementation: org.eclipse.uml2.uml.internal.impl.ActionInputPinImpl
import org.eclipse.uml2.uml.InformationItem;
//Implementation: org.eclipse.uml2.uml.internal.impl.InformationItemImpl
import org.eclipse.uml2.uml.InformationFlow;
//Implementation: org.eclipse.uml2.uml.internal.impl.InformationFlowImpl
import org.eclipse.uml2.uml.ReadExtentAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.ReadExtentActionImpl
import org.eclipse.uml2.uml.ReclassifyObjectAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.ReclassifyObjectActionImpl
import org.eclipse.uml2.uml.ReadIsClassifiedObjectAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.ReadIsClassifiedObjectActionImpl
import org.eclipse.uml2.uml.StartClassifierBehaviorAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.StartClassifierBehaviorActionImpl
import org.eclipse.uml2.uml.ReadLinkObjectEndAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.ReadLinkObjectEndActionImpl
import org.eclipse.uml2.uml.ReadLinkObjectEndQualifierAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.ReadLinkObjectEndQualifierActionImpl
import org.eclipse.uml2.uml.CreateLinkObjectAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.CreateLinkObjectActionImpl
import org.eclipse.uml2.uml.AcceptEventAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.AcceptEventActionImpl
import org.eclipse.uml2.uml.AcceptCallAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.AcceptCallActionImpl
import org.eclipse.uml2.uml.ReplyAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.ReplyActionImpl
import org.eclipse.uml2.uml.UnmarshallAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.UnmarshallActionImpl
import org.eclipse.uml2.uml.ReduceAction;
//Implementation: org.eclipse.uml2.uml.internal.impl.ReduceActionImpl
import org.eclipse.uml2.uml.JoinNode;
//Implementation: org.eclipse.uml2.uml.internal.impl.JoinNodeImpl
import org.eclipse.uml2.uml.DataStoreNode;
//Implementation: org.eclipse.uml2.uml.internal.impl.DataStoreNodeImpl
import org.eclipse.uml2.uml.ObjectFlow;
//Implementation: org.eclipse.uml2.uml.internal.impl.ObjectFlowImpl
import org.eclipse.uml2.uml.ConditionalNode;
//Implementation: org.eclipse.uml2.uml.internal.impl.ConditionalNodeImpl
import org.eclipse.uml2.uml.Clause;
//Implementation: org.eclipse.uml2.uml.internal.impl.ClauseImpl
import org.eclipse.uml2.uml.LoopNode;
//Implementation: org.eclipse.uml2.uml.internal.impl.LoopNodeImpl
import org.eclipse.uml2.uml.ExpansionNode;
//Implementation: org.eclipse.uml2.uml.internal.impl.ExpansionNodeImpl
import org.eclipse.uml2.uml.ExpansionRegion;
//Implementation: org.eclipse.uml2.uml.internal.impl.ExpansionRegionImpl
import org.eclipse.uml2.uml.ProtocolTransition;
//Implementation: org.eclipse.uml2.uml.internal.impl.ProtocolTransitionImpl
import org.eclipse.uml2.uml.AssociationClass;
//Implementation: org.eclipse.uml2.uml.internal.impl.AssociationClassImpl
import org.eclipse.uml2.uml.*;
//+++++++++++++++++++++++imports for org.eclipse.emf.ecore begin++++++++++++++++++++++
import org.eclipse.emf.ecore.EAttribute;
//Implementation: org.eclipse.emf.ecore.impl.EAttributeImpl
import org.eclipse.emf.ecore.EAnnotation;
//Implementation: org.eclipse.emf.ecore.impl.EAnnotationImpl
import org.eclipse.emf.ecore.EClass;
//Implementation: org.eclipse.emf.ecore.impl.EClassImpl
import org.eclipse.emf.ecore.EClassifier;
//Implementation: org.eclipse.emf.ecore.impl.EClassifierImpl
import org.eclipse.emf.ecore.EDataType;
//Implementation: org.eclipse.emf.ecore.impl.EDataTypeImpl
import org.eclipse.emf.ecore.EEnum;
//Implementation: org.eclipse.emf.ecore.impl.EEnumImpl
import org.eclipse.emf.ecore.EEnumLiteral;
//Implementation: org.eclipse.emf.ecore.impl.EEnumLiteralImpl
import org.eclipse.emf.ecore.EFactory;
//Implementation: org.eclipse.emf.ecore.impl.EFactoryImpl
import org.eclipse.emf.ecore.EModelElement;
//Implementation: org.eclipse.emf.ecore.impl.EModelElementImpl
import org.eclipse.emf.ecore.ENamedElement;
//Implementation: org.eclipse.emf.ecore.impl.ENamedElementImpl
import org.eclipse.emf.ecore.EObject;
//Implementation: org.eclipse.emf.ecore.impl.EObjectImpl
import org.eclipse.emf.ecore.EOperation;
//Implementation: org.eclipse.emf.ecore.impl.EOperationImpl
import org.eclipse.emf.ecore.EPackage;
//Implementation: org.eclipse.emf.ecore.impl.EPackageImpl
import org.eclipse.emf.ecore.EParameter;
//Implementation: org.eclipse.emf.ecore.impl.EParameterImpl
import org.eclipse.emf.ecore.EReference;
//Implementation: org.eclipse.emf.ecore.impl.EReferenceImpl
import org.eclipse.emf.ecore.EStructuralFeature;
//Implementation: org.eclipse.emf.ecore.impl.EStructuralFeatureImpl
import org.eclipse.emf.ecore.ETypedElement;
//Implementation: org.eclipse.emf.ecore.impl.ETypedElementImpl
import java.util.Map.Entry;
//Implementation: org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl
import org.eclipse.emf.ecore.EGenericType;
//Implementation: org.eclipse.emf.ecore.impl.EGenericTypeImpl
import org.eclipse.emf.ecore.ETypeParameter;
//Implementation: org.eclipse.emf.ecore.impl.ETypeParameterImpl
import org.eclipse.emf.ecore.*;
import org.reuseware.emftextedit.runtime.resource.*;
import org.reuseware.emftextedit.runtime.resource.impl.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.common.util.URI;
}

@members{
	private TokenResolverFactory tokenResolverFactory = new UmlTokenResolverFactory();

	protected EObject doParse() throws RecognitionException {
		((UmlLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((UmlLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		return start();
	}
}

start
returns [ EObject element = null]
:  
c0 = statemachine{ element = c0; }

;

statemachine returns [StateMachine element = null]
@init{
	element = UMLFactory.eINSTANCE.createStateMachine();
}
:
	'StateMachine'
	a0 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
	a1 = region{((List) element.eGet(element.eClass().getEStructuralFeature("region"))).add(a1); copyLocalizationInfos(a1, element); }
;

region returns [Region element = null]
@init{
	element = UMLFactory.eINSTANCE.createRegion();
}
:
	(
		(
			a0 = vertex{((List) element.eGet(element.eClass().getEStructuralFeature("subvertex"))).add(a0); copyLocalizationInfos(a0, element); }
			';'
		)
	)*
;

state returns [State element = null]
@init{
	element = UMLFactory.eINSTANCE.createState();
}
:
	'state'
	a0 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
	'{'
	(
		(
			'entry'
			':'
			a1 = behavior{element.eSet(element.eClass().getEStructuralFeature("entry"), a1); copyLocalizationInfos(a1, element); }
		)
	)?
	(
		(
			'exit'
			':'
			a2 = behavior{element.eSet(element.eClass().getEStructuralFeature("exit"), a2); copyLocalizationInfos(a2, element); }
		)
	)?
	'do'
	':'
	a3 = behavior{element.eSet(element.eClass().getEStructuralFeature("doActivity"), a3); copyLocalizationInfos(a3, element); }
	'}'
	|//derived choice rules for sub-classes: 
	c0 = finalstate{ element = c0; }
;

finalstate returns [FinalState element = null]
@init{
	element = UMLFactory.eINSTANCE.createFinalState();
}
:
	'final'
	'state'
	a0 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
	'{'
	(
		(
			'entry'
			':'
			a1 = behavior{element.eSet(element.eClass().getEStructuralFeature("entry"), a1); copyLocalizationInfos(a1, element); }
		)
	)?
	(
		(
			'exit'
			':'
			a2 = behavior{element.eSet(element.eClass().getEStructuralFeature("exit"), a2); copyLocalizationInfos(a2, element); }
		)
	)?
	'do'
	':'
	a3 = behavior{element.eSet(element.eClass().getEStructuralFeature("doActivity"), a3); copyLocalizationInfos(a3, element); }
	'}'
;

transition returns [Transition element = null]
@init{
	element = UMLFactory.eINSTANCE.createTransition();
}
:
	'transition'
	'from'
	a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("source"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;State proxy = UMLFactory.eINSTANCE.createState();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("source"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); }
	'to'
	a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("target"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;State proxy = UMLFactory.eINSTANCE.createState();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("target"), proxy); copyLocalizationInfos((CommonToken) a1, element); copyLocalizationInfos((CommonToken) a1, proxy); }
	'when'
	a2 = trigger{((List) element.eGet(element.eClass().getEStructuralFeature("trigger"))).add(a2); copyLocalizationInfos(a2, element); }
	'do'
	a3 = behavior{element.eSet(element.eClass().getEStructuralFeature("effect"), a3); copyLocalizationInfos(a3, element); }
;

trigger returns [Trigger element = null]
@init{
	element = UMLFactory.eINSTANCE.createTrigger();
}
:
	a0 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
;

activity returns [Activity element = null]
@init{
	element = UMLFactory.eINSTANCE.createActivity();
}
:
	a0 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
;

vertex
returns [Vertex element = null]
:
	c0 = state{ element = c0; }	|
	c1 = finalstate{ element = c1; }
;

behavior
returns [Behavior element = null]
:
	c0 = statemachine{ element = c0; }	|
	c1 = activity{ element = c1; }
;

COMMENT
:
	'//'(~('\n'|'\r'))*{ channel=99; }
;
INTEGER
:
	('-')?('1'..'9')('0'..'9')*|'0'{ channel=99; }
;
FLOAT
:
	('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ { channel=99; }
;
LB
:
	('\r\n' | '\r' | '\n'){ channel=99; }
;
WS
:
	(' ' | '\t' | '\f'){ channel=99; }
;
TEXT
:
	('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
QUOTED_34_34
:
	('"')(~('"')|('\\''"'))*('"')
;
