// $ANTLR 3.0.1 C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g 2008-11-26 14:09:43

package org.eclipse.uml2.uml.resource.statemachine;

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class StatemachineParser extends EMFTextParserImpl {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "QUOTED_34_34", "TEXT", "COMMENT", "INTEGER", "FLOAT", "LB", "WS", "'StateMachine'", "'{'", "'}'", "';'", "'state'", "'entry'", "':'", "'exit'", "'do'", "'final'", "'transition'", "'from'", "'to'", "'when'"
    };
    public static final int INTEGER=7;
    public static final int WS=10;
    public static final int LB=9;
    public static final int FLOAT=8;
    public static final int TEXT=5;
    public static final int COMMENT=6;
    public static final int EOF=-1;
    public static final int QUOTED_34_34=4;

        public StatemachineParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[22+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g"; }


    	private TokenResolverFactory tokenResolverFactory = new StatemachineTokenResolverFactory();

    	protected EObject doParse() throws RecognitionException {
    		((StatemachineLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((StatemachineLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		return start();
    	}



    // $ANTLR start start
    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:575:1: start returns [ EObject element = null] : c0= statemachine ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        StateMachine c0 = null;


        try {
            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:577:1: (c0= statemachine )
            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:578:1: c0= statemachine
            {
            pushFollow(FOLLOW_statemachine_in_start61);
            c0=statemachine();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
               element = c0; 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end start


    // $ANTLR start statemachine
    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:582:1: statemachine returns [StateMachine element = null] : 'StateMachine' a0= QUOTED_34_34 '{' a1= region '}' ;
    public final StateMachine statemachine() throws RecognitionException {
        StateMachine element =  null;

        Token a0=null;
        Region a1 = null;



        	element = UMLFactory.eINSTANCE.createStateMachine();

        try {
            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:586:1: ( 'StateMachine' a0= QUOTED_34_34 '{' a1= region '}' )
            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:587:2: 'StateMachine' a0= QUOTED_34_34 '{' a1= region '}'
            {
            match(input,11,FOLLOW_11_in_statemachine81); if (failed) return element;
            a0=(Token)input.LT(1);
            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_statemachine88); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            }
            match(input,12,FOLLOW_12_in_statemachine92); if (failed) return element;
            pushFollow(FOLLOW_region_in_statemachine99);
            a1=region();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
              ((List) element.eGet(element.eClass().getEStructuralFeature("region"))).add(a1); copyLocalizationInfos(a1, element); 
            }
            match(input,13,FOLLOW_13_in_statemachine103); if (failed) return element;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end statemachine


    // $ANTLR start region
    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:594:1: region returns [Region element = null] : ( (a0= vertex ';' | a1= transition ';' ) )* ;
    public final Region region() throws RecognitionException {
        Region element =  null;

        Vertex a0 = null;

        Transition a1 = null;



        	element = UMLFactory.eINSTANCE.createRegion();

        try {
            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:598:1: ( ( (a0= vertex ';' | a1= transition ';' ) )* )
            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:599:2: ( (a0= vertex ';' | a1= transition ';' ) )*
            {
            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:599:2: ( (a0= vertex ';' | a1= transition ';' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==TEXT||LA2_0==15||(LA2_0>=20 && LA2_0<=21)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:600:3: (a0= vertex ';' | a1= transition ';' )
            	    {
            	    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:600:3: (a0= vertex ';' | a1= transition ';' )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==TEXT||LA1_0==15||LA1_0==20) ) {
            	        alt1=1;
            	    }
            	    else if ( (LA1_0==21) ) {
            	        alt1=2;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("600:3: (a0= vertex ';' | a1= transition ';' )", 1, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:601:4: a0= vertex ';'
            	            {
            	            pushFollow(FOLLOW_vertex_in_region134);
            	            a0=vertex();
            	            _fsp--;
            	            if (failed) return element;
            	            if ( backtracking==0 ) {
            	              ((List) element.eGet(element.eClass().getEStructuralFeature("subvertex"))).add(a0); copyLocalizationInfos(a0, element); 
            	            }
            	            match(input,14,FOLLOW_14_in_region140); if (failed) return element;

            	            }
            	            break;
            	        case 2 :
            	            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:605:4: a1= transition ';'
            	            {
            	            pushFollow(FOLLOW_transition_in_region155);
            	            a1=transition();
            	            _fsp--;
            	            if (failed) return element;
            	            if ( backtracking==0 ) {
            	              ((List) element.eGet(element.eClass().getEStructuralFeature("transition"))).add(a1); copyLocalizationInfos(a1, element); 
            	            }
            	            match(input,14,FOLLOW_14_in_region161); if (failed) return element;

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end region


    // $ANTLR start state
    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:611:1: state returns [State element = null] : ( 'state' a0= QUOTED_34_34 '{' ( ( 'entry' ':' a1= behavior ) )? ( ( 'exit' ':' a2= behavior ) )? 'do' ':' a3= behavior '}' | c0= finalstate );
    public final State state() throws RecognitionException {
        State element =  null;

        Token a0=null;
        Behavior a1 = null;

        Behavior a2 = null;

        Behavior a3 = null;

        FinalState c0 = null;



        	element = UMLFactory.eINSTANCE.createState();

        try {
            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:615:1: ( 'state' a0= QUOTED_34_34 '{' ( ( 'entry' ':' a1= behavior ) )? ( ( 'exit' ':' a2= behavior ) )? 'do' ':' a3= behavior '}' | c0= finalstate )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            else if ( (LA5_0==20) ) {
                alt5=2;
            }
            else {
                if (backtracking>0) {failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("611:1: state returns [State element = null] : ( 'state' a0= QUOTED_34_34 '{' ( ( 'entry' ':' a1= behavior ) )? ( ( 'exit' ':' a2= behavior ) )? 'do' ':' a3= behavior '}' | c0= finalstate );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:616:2: 'state' a0= QUOTED_34_34 '{' ( ( 'entry' ':' a1= behavior ) )? ( ( 'exit' ':' a2= behavior ) )? 'do' ':' a3= behavior '}'
                    {
                    match(input,15,FOLLOW_15_in_state187); if (failed) return element;
                    a0=(Token)input.LT(1);
                    match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_state194); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
                    }
                    match(input,12,FOLLOW_12_in_state198); if (failed) return element;
                    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:619:2: ( ( 'entry' ':' a1= behavior ) )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==16) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:620:3: ( 'entry' ':' a1= behavior )
                            {
                            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:620:3: ( 'entry' ':' a1= behavior )
                            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:621:4: 'entry' ':' a1= behavior
                            {
                            match(input,16,FOLLOW_16_in_state210); if (failed) return element;
                            match(input,17,FOLLOW_17_in_state215); if (failed) return element;
                            pushFollow(FOLLOW_behavior_in_state224);
                            a1=behavior();
                            _fsp--;
                            if (failed) return element;
                            if ( backtracking==0 ) {
                              element.eSet(element.eClass().getEStructuralFeature("entry"), a1); copyLocalizationInfos(a1, element); 
                            }

                            }


                            }
                            break;

                    }

                    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:626:2: ( ( 'exit' ':' a2= behavior ) )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==18) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:627:3: ( 'exit' ':' a2= behavior )
                            {
                            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:627:3: ( 'exit' ':' a2= behavior )
                            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:628:4: 'exit' ':' a2= behavior
                            {
                            match(input,18,FOLLOW_18_in_state245); if (failed) return element;
                            match(input,17,FOLLOW_17_in_state250); if (failed) return element;
                            pushFollow(FOLLOW_behavior_in_state259);
                            a2=behavior();
                            _fsp--;
                            if (failed) return element;
                            if ( backtracking==0 ) {
                              element.eSet(element.eClass().getEStructuralFeature("exit"), a2); copyLocalizationInfos(a2, element); 
                            }

                            }


                            }
                            break;

                    }

                    match(input,19,FOLLOW_19_in_state271); if (failed) return element;
                    match(input,17,FOLLOW_17_in_state274); if (failed) return element;
                    pushFollow(FOLLOW_behavior_in_state281);
                    a3=behavior();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                      element.eSet(element.eClass().getEStructuralFeature("doActivity"), a3); copyLocalizationInfos(a3, element); 
                    }
                    match(input,13,FOLLOW_13_in_state285); if (failed) return element;

                    }
                    break;
                case 2 :
                    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:638:2: c0= finalstate
                    {
                    pushFollow(FOLLOW_finalstate_in_state295);
                    c0=finalstate();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end state


    // $ANTLR start pseudostate
    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:641:1: pseudostate returns [Pseudostate element = null] : a0= TEXT 'state' a1= QUOTED_34_34 ;
    public final Pseudostate pseudostate() throws RecognitionException {
        Pseudostate element =  null;

        Token a0=null;
        Token a1=null;


        	element = UMLFactory.eINSTANCE.createPseudostate();

        try {
            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:645:1: (a0= TEXT 'state' a1= QUOTED_34_34 )
            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:646:2: a0= TEXT 'state' a1= QUOTED_34_34
            {
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_pseudostate318); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("kind"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());PseudostateKind resolved = (PseudostateKind)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("kind"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            }
            match(input,15,FOLLOW_15_in_pseudostate322); if (failed) return element;
            a1=(Token)input.LT(1);
            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_pseudostate329); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end pseudostate


    // $ANTLR start finalstate
    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:651:1: finalstate returns [FinalState element = null] : 'final' 'state' a0= QUOTED_34_34 '{' ( ( 'entry' ':' a1= behavior ) )? ( ( 'exit' ':' a2= behavior ) )? 'do' ':' a3= behavior '}' ;
    public final FinalState finalstate() throws RecognitionException {
        FinalState element =  null;

        Token a0=null;
        Behavior a1 = null;

        Behavior a2 = null;

        Behavior a3 = null;



        	element = UMLFactory.eINSTANCE.createFinalState();

        try {
            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:655:1: ( 'final' 'state' a0= QUOTED_34_34 '{' ( ( 'entry' ':' a1= behavior ) )? ( ( 'exit' ':' a2= behavior ) )? 'do' ':' a3= behavior '}' )
            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:656:2: 'final' 'state' a0= QUOTED_34_34 '{' ( ( 'entry' ':' a1= behavior ) )? ( ( 'exit' ':' a2= behavior ) )? 'do' ':' a3= behavior '}'
            {
            match(input,20,FOLLOW_20_in_finalstate348); if (failed) return element;
            match(input,15,FOLLOW_15_in_finalstate351); if (failed) return element;
            a0=(Token)input.LT(1);
            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_finalstate358); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            }
            match(input,12,FOLLOW_12_in_finalstate362); if (failed) return element;
            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:660:2: ( ( 'entry' ':' a1= behavior ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:661:3: ( 'entry' ':' a1= behavior )
                    {
                    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:661:3: ( 'entry' ':' a1= behavior )
                    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:662:4: 'entry' ':' a1= behavior
                    {
                    match(input,16,FOLLOW_16_in_finalstate374); if (failed) return element;
                    match(input,17,FOLLOW_17_in_finalstate379); if (failed) return element;
                    pushFollow(FOLLOW_behavior_in_finalstate388);
                    a1=behavior();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                      element.eSet(element.eClass().getEStructuralFeature("entry"), a1); copyLocalizationInfos(a1, element); 
                    }

                    }


                    }
                    break;

            }

            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:667:2: ( ( 'exit' ':' a2= behavior ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:668:3: ( 'exit' ':' a2= behavior )
                    {
                    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:668:3: ( 'exit' ':' a2= behavior )
                    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:669:4: 'exit' ':' a2= behavior
                    {
                    match(input,18,FOLLOW_18_in_finalstate409); if (failed) return element;
                    match(input,17,FOLLOW_17_in_finalstate414); if (failed) return element;
                    pushFollow(FOLLOW_behavior_in_finalstate423);
                    a2=behavior();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                      element.eSet(element.eClass().getEStructuralFeature("exit"), a2); copyLocalizationInfos(a2, element); 
                    }

                    }


                    }
                    break;

            }

            match(input,19,FOLLOW_19_in_finalstate435); if (failed) return element;
            match(input,17,FOLLOW_17_in_finalstate438); if (failed) return element;
            pushFollow(FOLLOW_behavior_in_finalstate445);
            a3=behavior();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
              element.eSet(element.eClass().getEStructuralFeature("doActivity"), a3); copyLocalizationInfos(a3, element); 
            }
            match(input,13,FOLLOW_13_in_finalstate449); if (failed) return element;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end finalstate


    // $ANTLR start transition
    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:680:1: transition returns [Transition element = null] : 'transition' 'from' a0= QUOTED_34_34 'to' a1= QUOTED_34_34 'when' a2= trigger ( ( 'do' ':' a3= behavior ) )? ;
    public final Transition transition() throws RecognitionException {
        Transition element =  null;

        Token a0=null;
        Token a1=null;
        Trigger a2 = null;

        Behavior a3 = null;



        	element = UMLFactory.eINSTANCE.createTransition();

        try {
            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:684:1: ( 'transition' 'from' a0= QUOTED_34_34 'to' a1= QUOTED_34_34 'when' a2= trigger ( ( 'do' ':' a3= behavior ) )? )
            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:685:2: 'transition' 'from' a0= QUOTED_34_34 'to' a1= QUOTED_34_34 'when' a2= trigger ( ( 'do' ':' a3= behavior ) )?
            {
            match(input,21,FOLLOW_21_in_transition467); if (failed) return element;
            match(input,22,FOLLOW_22_in_transition470); if (failed) return element;
            a0=(Token)input.LT(1);
            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_transition477); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("source"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;State proxy = UMLFactory.eINSTANCE.createState();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("source"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
            }
            match(input,23,FOLLOW_23_in_transition481); if (failed) return element;
            a1=(Token)input.LT(1);
            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_transition488); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("target"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;State proxy = UMLFactory.eINSTANCE.createState();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("target"), proxy); copyLocalizationInfos((CommonToken) a1, element); copyLocalizationInfos((CommonToken) a1, proxy); 
            }
            match(input,24,FOLLOW_24_in_transition492); if (failed) return element;
            pushFollow(FOLLOW_trigger_in_transition499);
            a2=trigger();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
              ((List) element.eGet(element.eClass().getEStructuralFeature("trigger"))).add(a2); copyLocalizationInfos(a2, element); 
            }
            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:692:2: ( ( 'do' ':' a3= behavior ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:693:3: ( 'do' ':' a3= behavior )
                    {
                    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:693:3: ( 'do' ':' a3= behavior )
                    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:694:4: 'do' ':' a3= behavior
                    {
                    match(input,19,FOLLOW_19_in_transition512); if (failed) return element;
                    match(input,17,FOLLOW_17_in_transition517); if (failed) return element;
                    pushFollow(FOLLOW_behavior_in_transition526);
                    a3=behavior();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                      element.eSet(element.eClass().getEStructuralFeature("effect"), a3); copyLocalizationInfos(a3, element); 
                    }

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end transition


    // $ANTLR start trigger
    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:701:1: trigger returns [Trigger element = null] : a0= QUOTED_34_34 ;
    public final Trigger trigger() throws RecognitionException {
        Trigger element =  null;

        Token a0=null;


        	element = UMLFactory.eINSTANCE.createTrigger();

        try {
            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:705:1: (a0= QUOTED_34_34 )
            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:706:2: a0= QUOTED_34_34
            {
            a0=(Token)input.LT(1);
            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_trigger557); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end trigger


    // $ANTLR start activity
    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:709:1: activity returns [Activity element = null] : a0= QUOTED_34_34 ;
    public final Activity activity() throws RecognitionException {
        Activity element =  null;

        Token a0=null;


        	element = UMLFactory.eINSTANCE.createActivity();

        try {
            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:713:1: (a0= QUOTED_34_34 )
            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:714:2: a0= QUOTED_34_34
            {
            a0=(Token)input.LT(1);
            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_activity580); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end activity


    // $ANTLR start vertex
    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );
    public final Vertex vertex() throws RecognitionException {
        Vertex element =  null;

        State c0 = null;

        Pseudostate c1 = null;

        FinalState c2 = null;


        try {
            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:719:1: (c0= state | c1= pseudostate | c2= finalstate )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt9=1;
                }
                break;
            case 20:
                {
                int LA9_2 = input.LA(2);

                if ( (LA9_2==15) ) {
                    int LA9_4 = input.LA(3);

                    if ( (LA9_4==QUOTED_34_34) ) {
                        int LA9_5 = input.LA(4);

                        if ( (LA9_5==12) ) {
                            switch ( input.LA(5) ) {
                            case 16:
                                {
                                int LA9_7 = input.LA(6);

                                if ( (LA9_7==17) ) {
                                    int LA9_10 = input.LA(7);

                                    if ( (LA9_10==11) ) {
                                        int LA9_13 = input.LA(8);

                                        if ( (LA9_13==QUOTED_34_34) ) {
                                            int LA9_19 = input.LA(9);

                                            if ( (LA9_19==12) ) {
                                                int LA9_23 = input.LA(10);

                                                if ( (synpred9()) ) {
                                                    alt9=1;
                                                }
                                                else if ( (true) ) {
                                                    alt9=3;
                                                }
                                                else {
                                                    if (backtracking>0) {failed=true; return element;}
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 23, input);

                                                    throw nvae;
                                                }
                                            }
                                            else {
                                                if (backtracking>0) {failed=true; return element;}
                                                NoViableAltException nvae =
                                                    new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 19, input);

                                                throw nvae;
                                            }
                                        }
                                        else {
                                            if (backtracking>0) {failed=true; return element;}
                                            NoViableAltException nvae =
                                                new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 13, input);

                                            throw nvae;
                                        }
                                    }
                                    else if ( (LA9_10==QUOTED_34_34) ) {
                                        int LA9_14 = input.LA(8);

                                        if ( (LA9_14==18) ) {
                                            int LA9_8 = input.LA(9);

                                            if ( (LA9_8==17) ) {
                                                int LA9_11 = input.LA(10);

                                                if ( (LA9_11==11) ) {
                                                    int LA9_15 = input.LA(11);

                                                    if ( (LA9_15==QUOTED_34_34) ) {
                                                        int LA9_20 = input.LA(12);

                                                        if ( (LA9_20==12) ) {
                                                            int LA9_24 = input.LA(13);

                                                            if ( (synpred9()) ) {
                                                                alt9=1;
                                                            }
                                                            else if ( (true) ) {
                                                                alt9=3;
                                                            }
                                                            else {
                                                                if (backtracking>0) {failed=true; return element;}
                                                                NoViableAltException nvae =
                                                                    new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 24, input);

                                                                throw nvae;
                                                            }
                                                        }
                                                        else {
                                                            if (backtracking>0) {failed=true; return element;}
                                                            NoViableAltException nvae =
                                                                new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 20, input);

                                                            throw nvae;
                                                        }
                                                    }
                                                    else {
                                                        if (backtracking>0) {failed=true; return element;}
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 15, input);

                                                        throw nvae;
                                                    }
                                                }
                                                else if ( (LA9_11==QUOTED_34_34) ) {
                                                    int LA9_16 = input.LA(11);

                                                    if ( (LA9_16==19) ) {
                                                        int LA9_9 = input.LA(12);

                                                        if ( (LA9_9==17) ) {
                                                            int LA9_12 = input.LA(13);

                                                            if ( (LA9_12==11) ) {
                                                                int LA9_17 = input.LA(14);

                                                                if ( (LA9_17==QUOTED_34_34) ) {
                                                                    int LA9_21 = input.LA(15);

                                                                    if ( (LA9_21==12) ) {
                                                                        int LA9_25 = input.LA(16);

                                                                        if ( (synpred9()) ) {
                                                                            alt9=1;
                                                                        }
                                                                        else if ( (true) ) {
                                                                            alt9=3;
                                                                        }
                                                                        else {
                                                                            if (backtracking>0) {failed=true; return element;}
                                                                            NoViableAltException nvae =
                                                                                new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 25, input);

                                                                            throw nvae;
                                                                        }
                                                                    }
                                                                    else {
                                                                        if (backtracking>0) {failed=true; return element;}
                                                                        NoViableAltException nvae =
                                                                            new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 21, input);

                                                                        throw nvae;
                                                                    }
                                                                }
                                                                else {
                                                                    if (backtracking>0) {failed=true; return element;}
                                                                    NoViableAltException nvae =
                                                                        new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 17, input);

                                                                    throw nvae;
                                                                }
                                                            }
                                                            else if ( (LA9_12==QUOTED_34_34) ) {
                                                                int LA9_18 = input.LA(14);

                                                                if ( (LA9_18==13) ) {
                                                                    int LA9_22 = input.LA(15);

                                                                    if ( (synpred9()) ) {
                                                                        alt9=1;
                                                                    }
                                                                    else if ( (true) ) {
                                                                        alt9=3;
                                                                    }
                                                                    else {
                                                                        if (backtracking>0) {failed=true; return element;}
                                                                        NoViableAltException nvae =
                                                                            new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 22, input);

                                                                        throw nvae;
                                                                    }
                                                                }
                                                                else {
                                                                    if (backtracking>0) {failed=true; return element;}
                                                                    NoViableAltException nvae =
                                                                        new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 18, input);

                                                                    throw nvae;
                                                                }
                                                            }
                                                            else {
                                                                if (backtracking>0) {failed=true; return element;}
                                                                NoViableAltException nvae =
                                                                    new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 12, input);

                                                                throw nvae;
                                                            }
                                                        }
                                                        else {
                                                            if (backtracking>0) {failed=true; return element;}
                                                            NoViableAltException nvae =
                                                                new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 9, input);

                                                            throw nvae;
                                                        }
                                                    }
                                                    else {
                                                        if (backtracking>0) {failed=true; return element;}
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 16, input);

                                                        throw nvae;
                                                    }
                                                }
                                                else {
                                                    if (backtracking>0) {failed=true; return element;}
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 11, input);

                                                    throw nvae;
                                                }
                                            }
                                            else {
                                                if (backtracking>0) {failed=true; return element;}
                                                NoViableAltException nvae =
                                                    new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 8, input);

                                                throw nvae;
                                            }
                                        }
                                        else if ( (LA9_14==19) ) {
                                            int LA9_9 = input.LA(9);

                                            if ( (LA9_9==17) ) {
                                                int LA9_12 = input.LA(10);

                                                if ( (LA9_12==11) ) {
                                                    int LA9_17 = input.LA(11);

                                                    if ( (LA9_17==QUOTED_34_34) ) {
                                                        int LA9_21 = input.LA(12);

                                                        if ( (LA9_21==12) ) {
                                                            int LA9_25 = input.LA(13);

                                                            if ( (synpred9()) ) {
                                                                alt9=1;
                                                            }
                                                            else if ( (true) ) {
                                                                alt9=3;
                                                            }
                                                            else {
                                                                if (backtracking>0) {failed=true; return element;}
                                                                NoViableAltException nvae =
                                                                    new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 25, input);

                                                                throw nvae;
                                                            }
                                                        }
                                                        else {
                                                            if (backtracking>0) {failed=true; return element;}
                                                            NoViableAltException nvae =
                                                                new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 21, input);

                                                            throw nvae;
                                                        }
                                                    }
                                                    else {
                                                        if (backtracking>0) {failed=true; return element;}
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 17, input);

                                                        throw nvae;
                                                    }
                                                }
                                                else if ( (LA9_12==QUOTED_34_34) ) {
                                                    int LA9_18 = input.LA(11);

                                                    if ( (LA9_18==13) ) {
                                                        int LA9_22 = input.LA(12);

                                                        if ( (synpred9()) ) {
                                                            alt9=1;
                                                        }
                                                        else if ( (true) ) {
                                                            alt9=3;
                                                        }
                                                        else {
                                                            if (backtracking>0) {failed=true; return element;}
                                                            NoViableAltException nvae =
                                                                new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 22, input);

                                                            throw nvae;
                                                        }
                                                    }
                                                    else {
                                                        if (backtracking>0) {failed=true; return element;}
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 18, input);

                                                        throw nvae;
                                                    }
                                                }
                                                else {
                                                    if (backtracking>0) {failed=true; return element;}
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 12, input);

                                                    throw nvae;
                                                }
                                            }
                                            else {
                                                if (backtracking>0) {failed=true; return element;}
                                                NoViableAltException nvae =
                                                    new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 9, input);

                                                throw nvae;
                                            }
                                        }
                                        else {
                                            if (backtracking>0) {failed=true; return element;}
                                            NoViableAltException nvae =
                                                new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 14, input);

                                            throw nvae;
                                        }
                                    }
                                    else {
                                        if (backtracking>0) {failed=true; return element;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 10, input);

                                        throw nvae;
                                    }
                                }
                                else {
                                    if (backtracking>0) {failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 7, input);

                                    throw nvae;
                                }
                                }
                                break;
                            case 18:
                                {
                                int LA9_8 = input.LA(6);

                                if ( (LA9_8==17) ) {
                                    int LA9_11 = input.LA(7);

                                    if ( (LA9_11==11) ) {
                                        int LA9_15 = input.LA(8);

                                        if ( (LA9_15==QUOTED_34_34) ) {
                                            int LA9_20 = input.LA(9);

                                            if ( (LA9_20==12) ) {
                                                int LA9_24 = input.LA(10);

                                                if ( (synpred9()) ) {
                                                    alt9=1;
                                                }
                                                else if ( (true) ) {
                                                    alt9=3;
                                                }
                                                else {
                                                    if (backtracking>0) {failed=true; return element;}
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 24, input);

                                                    throw nvae;
                                                }
                                            }
                                            else {
                                                if (backtracking>0) {failed=true; return element;}
                                                NoViableAltException nvae =
                                                    new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 20, input);

                                                throw nvae;
                                            }
                                        }
                                        else {
                                            if (backtracking>0) {failed=true; return element;}
                                            NoViableAltException nvae =
                                                new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 15, input);

                                            throw nvae;
                                        }
                                    }
                                    else if ( (LA9_11==QUOTED_34_34) ) {
                                        int LA9_16 = input.LA(8);

                                        if ( (LA9_16==19) ) {
                                            int LA9_9 = input.LA(9);

                                            if ( (LA9_9==17) ) {
                                                int LA9_12 = input.LA(10);

                                                if ( (LA9_12==11) ) {
                                                    int LA9_17 = input.LA(11);

                                                    if ( (LA9_17==QUOTED_34_34) ) {
                                                        int LA9_21 = input.LA(12);

                                                        if ( (LA9_21==12) ) {
                                                            int LA9_25 = input.LA(13);

                                                            if ( (synpred9()) ) {
                                                                alt9=1;
                                                            }
                                                            else if ( (true) ) {
                                                                alt9=3;
                                                            }
                                                            else {
                                                                if (backtracking>0) {failed=true; return element;}
                                                                NoViableAltException nvae =
                                                                    new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 25, input);

                                                                throw nvae;
                                                            }
                                                        }
                                                        else {
                                                            if (backtracking>0) {failed=true; return element;}
                                                            NoViableAltException nvae =
                                                                new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 21, input);

                                                            throw nvae;
                                                        }
                                                    }
                                                    else {
                                                        if (backtracking>0) {failed=true; return element;}
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 17, input);

                                                        throw nvae;
                                                    }
                                                }
                                                else if ( (LA9_12==QUOTED_34_34) ) {
                                                    int LA9_18 = input.LA(11);

                                                    if ( (LA9_18==13) ) {
                                                        int LA9_22 = input.LA(12);

                                                        if ( (synpred9()) ) {
                                                            alt9=1;
                                                        }
                                                        else if ( (true) ) {
                                                            alt9=3;
                                                        }
                                                        else {
                                                            if (backtracking>0) {failed=true; return element;}
                                                            NoViableAltException nvae =
                                                                new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 22, input);

                                                            throw nvae;
                                                        }
                                                    }
                                                    else {
                                                        if (backtracking>0) {failed=true; return element;}
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 18, input);

                                                        throw nvae;
                                                    }
                                                }
                                                else {
                                                    if (backtracking>0) {failed=true; return element;}
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 12, input);

                                                    throw nvae;
                                                }
                                            }
                                            else {
                                                if (backtracking>0) {failed=true; return element;}
                                                NoViableAltException nvae =
                                                    new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 9, input);

                                                throw nvae;
                                            }
                                        }
                                        else {
                                            if (backtracking>0) {failed=true; return element;}
                                            NoViableAltException nvae =
                                                new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 16, input);

                                            throw nvae;
                                        }
                                    }
                                    else {
                                        if (backtracking>0) {failed=true; return element;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 11, input);

                                        throw nvae;
                                    }
                                }
                                else {
                                    if (backtracking>0) {failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 8, input);

                                    throw nvae;
                                }
                                }
                                break;
                            case 19:
                                {
                                int LA9_9 = input.LA(6);

                                if ( (LA9_9==17) ) {
                                    int LA9_12 = input.LA(7);

                                    if ( (LA9_12==11) ) {
                                        int LA9_17 = input.LA(8);

                                        if ( (LA9_17==QUOTED_34_34) ) {
                                            int LA9_21 = input.LA(9);

                                            if ( (LA9_21==12) ) {
                                                int LA9_25 = input.LA(10);

                                                if ( (synpred9()) ) {
                                                    alt9=1;
                                                }
                                                else if ( (true) ) {
                                                    alt9=3;
                                                }
                                                else {
                                                    if (backtracking>0) {failed=true; return element;}
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 25, input);

                                                    throw nvae;
                                                }
                                            }
                                            else {
                                                if (backtracking>0) {failed=true; return element;}
                                                NoViableAltException nvae =
                                                    new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 21, input);

                                                throw nvae;
                                            }
                                        }
                                        else {
                                            if (backtracking>0) {failed=true; return element;}
                                            NoViableAltException nvae =
                                                new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 17, input);

                                            throw nvae;
                                        }
                                    }
                                    else if ( (LA9_12==QUOTED_34_34) ) {
                                        int LA9_18 = input.LA(8);

                                        if ( (LA9_18==13) ) {
                                            int LA9_22 = input.LA(9);

                                            if ( (synpred9()) ) {
                                                alt9=1;
                                            }
                                            else if ( (true) ) {
                                                alt9=3;
                                            }
                                            else {
                                                if (backtracking>0) {failed=true; return element;}
                                                NoViableAltException nvae =
                                                    new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 22, input);

                                                throw nvae;
                                            }
                                        }
                                        else {
                                            if (backtracking>0) {failed=true; return element;}
                                            NoViableAltException nvae =
                                                new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 18, input);

                                            throw nvae;
                                        }
                                    }
                                    else {
                                        if (backtracking>0) {failed=true; return element;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 12, input);

                                        throw nvae;
                                    }
                                }
                                else {
                                    if (backtracking>0) {failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 9, input);

                                    throw nvae;
                                }
                                }
                                break;
                            default:
                                if (backtracking>0) {failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 6, input);

                                throw nvae;
                            }

                        }
                        else {
                            if (backtracking>0) {failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 4, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 2, input);

                    throw nvae;
                }
                }
                break;
            case TEXT:
                {
                alt9=2;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("717:1: vertex returns [Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:720:2: c0= state
                    {
                    pushFollow(FOLLOW_state_in_vertex599);
                    c0=state();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:721:2: c1= pseudostate
                    {
                    pushFollow(FOLLOW_pseudostate_in_vertex609);
                    c1=pseudostate();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:722:2: c2= finalstate
                    {
                    pushFollow(FOLLOW_finalstate_in_vertex619);
                    c2=finalstate();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c2; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end vertex


    // $ANTLR start behavior
    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:725:1: behavior returns [Behavior element = null] : (c0= statemachine | c1= activity );
    public final Behavior behavior() throws RecognitionException {
        Behavior element =  null;

        StateMachine c0 = null;

        Activity c1 = null;


        try {
            // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:727:1: (c0= statemachine | c1= activity )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==11) ) {
                alt10=1;
            }
            else if ( (LA10_0==QUOTED_34_34) ) {
                alt10=2;
            }
            else {
                if (backtracking>0) {failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("725:1: behavior returns [Behavior element = null] : (c0= statemachine | c1= activity );", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:728:2: c0= statemachine
                    {
                    pushFollow(FOLLOW_statemachine_in_behavior638);
                    c0=statemachine();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:729:2: c1= activity
                    {
                    pushFollow(FOLLOW_activity_in_behavior648);
                    c1=activity();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end behavior

    // $ANTLR start synpred9
    public final void synpred9_fragment() throws RecognitionException {   
        // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:720:2: ( state )
        // C:\\userdata\\eclipse\\ldta-runtime\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:720:2: state
        {
        pushFollow(FOLLOW_state_in_synpred9599);
        state();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred9

    public final boolean synpred9() {
        backtracking++;
        int start = input.mark();
        try {
            synpred9_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_statemachine_in_start61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_statemachine81 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_statemachine88 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_statemachine92 = new BitSet(new long[]{0x000000000030A020L});
    public static final BitSet FOLLOW_region_in_statemachine99 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statemachine103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_vertex_in_region134 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_region140 = new BitSet(new long[]{0x0000000000308022L});
    public static final BitSet FOLLOW_transition_in_region155 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_region161 = new BitSet(new long[]{0x0000000000308022L});
    public static final BitSet FOLLOW_15_in_state187 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_state194 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_state198 = new BitSet(new long[]{0x00000000000D0000L});
    public static final BitSet FOLLOW_16_in_state210 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_state215 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_behavior_in_state224 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_state245 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_state250 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_behavior_in_state259 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_state271 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_state274 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_behavior_in_state281 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_state285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_finalstate_in_state295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_pseudostate318 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_pseudostate322 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_pseudostate329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_finalstate348 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_finalstate351 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_finalstate358 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_finalstate362 = new BitSet(new long[]{0x00000000000D0000L});
    public static final BitSet FOLLOW_16_in_finalstate374 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_finalstate379 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_behavior_in_finalstate388 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_finalstate409 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_finalstate414 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_behavior_in_finalstate423 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_finalstate435 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_finalstate438 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_behavior_in_finalstate445 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_finalstate449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_transition467 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_transition470 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_transition477 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_transition481 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_transition488 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_transition492 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_trigger_in_transition499 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_transition512 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_transition517 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_behavior_in_transition526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_trigger557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_activity580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_state_in_vertex599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pseudostate_in_vertex609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_finalstate_in_vertex619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statemachine_in_behavior638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_activity_in_behavior648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_state_in_synpred9599 = new BitSet(new long[]{0x0000000000000002L});

}