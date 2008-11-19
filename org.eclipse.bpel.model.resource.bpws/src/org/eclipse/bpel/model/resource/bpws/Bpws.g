grammar Bpws;
options {superClass = EMFTextParserImpl; backtrack = true;}

@lexer::header{
package org.eclipse.bpel.model.resource.bpws;

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
package org.eclipse.bpel.model.resource.bpws;

//+++++++++++++++++++++++imports for org.eclipse.bpel.model begin++++++++++++++++++++++
import org.eclipse.bpel.model.Process;
//Implementation: org.eclipse.bpel.model.impl.ProcessImpl
import org.eclipse.bpel.model.PartnerLink;
//Implementation: org.eclipse.bpel.model.impl.PartnerLinkImpl
import org.eclipse.bpel.model.FaultHandler;
//Implementation: org.eclipse.bpel.model.impl.FaultHandlerImpl
import org.eclipse.bpel.model.Activity;
//Implementation: org.eclipse.bpel.model.impl.ActivityImpl
import org.eclipse.bpel.model.CorrelationSet;
//Implementation: org.eclipse.bpel.model.impl.CorrelationSetImpl
import org.eclipse.bpel.model.Invoke;
//Implementation: org.eclipse.bpel.model.impl.InvokeImpl
import org.eclipse.bpel.model.Link;
//Implementation: org.eclipse.bpel.model.impl.LinkImpl
import org.eclipse.bpel.model.Catch;
//Implementation: org.eclipse.bpel.model.impl.CatchImpl
import org.eclipse.bpel.model.Reply;
//Implementation: org.eclipse.bpel.model.impl.ReplyImpl
import org.eclipse.bpel.model.PartnerActivity;
//Implementation: org.eclipse.bpel.model.impl.PartnerActivityImpl
import org.eclipse.bpel.model.Receive;
//Implementation: org.eclipse.bpel.model.impl.ReceiveImpl
import org.eclipse.bpel.model.Exit;
//Implementation: org.eclipse.bpel.model.impl.ExitImpl
import org.eclipse.bpel.model.Throw;
//Implementation: org.eclipse.bpel.model.impl.ThrowImpl
import org.eclipse.bpel.model.Wait;
//Implementation: org.eclipse.bpel.model.impl.WaitImpl
import org.eclipse.bpel.model.Empty;
//Implementation: org.eclipse.bpel.model.impl.EmptyImpl
import org.eclipse.bpel.model.Sequence;
//Implementation: org.eclipse.bpel.model.impl.SequenceImpl
import org.eclipse.bpel.model.While;
//Implementation: org.eclipse.bpel.model.impl.WhileImpl
import org.eclipse.bpel.model.Pick;
//Implementation: org.eclipse.bpel.model.impl.PickImpl
import org.eclipse.bpel.model.Flow;
//Implementation: org.eclipse.bpel.model.impl.FlowImpl
import org.eclipse.bpel.model.OnAlarm;
//Implementation: org.eclipse.bpel.model.impl.OnAlarmImpl
import org.eclipse.bpel.model.Assign;
//Implementation: org.eclipse.bpel.model.impl.AssignImpl
import org.eclipse.bpel.model.Copy;
//Implementation: org.eclipse.bpel.model.impl.CopyImpl
import org.eclipse.bpel.model.Extension;
//Implementation: org.eclipse.bpel.model.impl.ExtensionImpl
import org.eclipse.bpel.model.Scope;
//Implementation: org.eclipse.bpel.model.impl.ScopeImpl
import org.eclipse.bpel.model.CompensateScope;
//Implementation: org.eclipse.bpel.model.impl.CompensateScopeImpl
import org.eclipse.bpel.model.CompensationHandler;
//Implementation: org.eclipse.bpel.model.impl.CompensationHandlerImpl
import org.eclipse.bpel.model.To;
//Implementation: org.eclipse.bpel.model.impl.ToImpl
import org.eclipse.bpel.model.From;
//Implementation: org.eclipse.bpel.model.impl.FromImpl
import org.eclipse.bpel.model.OnMessage;
//Implementation: org.eclipse.bpel.model.impl.OnMessageImpl
import org.eclipse.bpel.model.Expression;
//Implementation: org.eclipse.bpel.model.impl.ExpressionImpl
import org.eclipse.bpel.model.BooleanExpression;
//Implementation: org.eclipse.bpel.model.impl.BooleanExpressionImpl
import org.eclipse.bpel.model.Correlation;
//Implementation: org.eclipse.bpel.model.impl.CorrelationImpl
import org.eclipse.bpel.model.EventHandler;
//Implementation: org.eclipse.bpel.model.impl.EventHandlerImpl
import org.eclipse.bpel.model.Source;
//Implementation: org.eclipse.bpel.model.impl.SourceImpl
import org.eclipse.bpel.model.Target;
//Implementation: org.eclipse.bpel.model.impl.TargetImpl
import org.eclipse.bpel.model.PartnerLinks;
//Implementation: org.eclipse.bpel.model.impl.PartnerLinksImpl
import org.eclipse.bpel.model.Variables;
//Implementation: org.eclipse.bpel.model.impl.VariablesImpl
import org.eclipse.bpel.model.CorrelationSets;
//Implementation: org.eclipse.bpel.model.impl.CorrelationSetsImpl
import org.eclipse.bpel.model.Links;
//Implementation: org.eclipse.bpel.model.impl.LinksImpl
import org.eclipse.bpel.model.CatchAll;
//Implementation: org.eclipse.bpel.model.impl.CatchAllImpl
import org.eclipse.bpel.model.Correlations;
//Implementation: org.eclipse.bpel.model.impl.CorrelationsImpl
import org.eclipse.bpel.model.Variable;
//Implementation: org.eclipse.bpel.model.impl.VariableImpl
import org.eclipse.bpel.model.UnknownExtensibilityAttribute;
//Implementation: org.eclipse.bpel.model.impl.UnknownExtensibilityAttributeImpl
import org.eclipse.bpel.model.OnEvent;
//Implementation: org.eclipse.bpel.model.impl.OnEventImpl
import org.eclipse.bpel.model.Import;
//Implementation: org.eclipse.bpel.model.impl.ImportImpl
import org.eclipse.bpel.model.Rethrow;
//Implementation: org.eclipse.bpel.model.impl.RethrowImpl
import org.eclipse.bpel.model.Condition;
//Implementation: org.eclipse.bpel.model.impl.ConditionImpl
import org.eclipse.bpel.model.Targets;
//Implementation: org.eclipse.bpel.model.impl.TargetsImpl
import org.eclipse.bpel.model.Sources;
//Implementation: org.eclipse.bpel.model.impl.SourcesImpl
import org.eclipse.bpel.model.Query;
//Implementation: org.eclipse.bpel.model.impl.QueryImpl
import org.eclipse.bpel.model.ServiceRef;
//Implementation: org.eclipse.bpel.model.impl.ServiceRefImpl
import org.eclipse.bpel.model.Extensions;
//Implementation: org.eclipse.bpel.model.impl.ExtensionsImpl
import org.eclipse.bpel.model.ExtensionActivity;
//Implementation: org.eclipse.bpel.model.impl.ExtensionActivityImpl
import org.eclipse.bpel.model.FromPart;
//Implementation: org.eclipse.bpel.model.impl.FromPartImpl
import org.eclipse.bpel.model.ToPart;
//Implementation: org.eclipse.bpel.model.impl.ToPartImpl
import org.eclipse.bpel.model.OpaqueActivity;
//Implementation: org.eclipse.bpel.model.impl.OpaqueActivityImpl
import org.eclipse.bpel.model.ForEach;
//Implementation: org.eclipse.bpel.model.impl.ForEachImpl
import org.eclipse.bpel.model.RepeatUntil;
//Implementation: org.eclipse.bpel.model.impl.RepeatUntilImpl
import org.eclipse.bpel.model.TerminationHandler;
//Implementation: org.eclipse.bpel.model.impl.TerminationHandlerImpl
import org.eclipse.bpel.model.Validate;
//Implementation: org.eclipse.bpel.model.impl.ValidateImpl
import org.eclipse.bpel.model.If;
//Implementation: org.eclipse.bpel.model.impl.IfImpl
import org.eclipse.bpel.model.ElseIf;
//Implementation: org.eclipse.bpel.model.impl.ElseIfImpl
import org.eclipse.bpel.model.Else;
//Implementation: org.eclipse.bpel.model.impl.ElseImpl
import org.eclipse.bpel.model.CompletionCondition;
//Implementation: org.eclipse.bpel.model.impl.CompletionConditionImpl
import org.eclipse.bpel.model.Branches;
//Implementation: org.eclipse.bpel.model.impl.BranchesImpl
import org.eclipse.bpel.model.ExtensibleElement;
//Implementation: org.eclipse.bpel.model.impl.ExtensibleElementImpl
import org.eclipse.bpel.model.Documentation;
//Implementation: org.eclipse.bpel.model.impl.DocumentationImpl
import org.eclipse.bpel.model.MessageExchanges;
//Implementation: org.eclipse.bpel.model.impl.MessageExchangesImpl
import org.eclipse.bpel.model.MessageExchange;
//Implementation: org.eclipse.bpel.model.impl.MessageExchangeImpl
import org.eclipse.bpel.model.Compensate;
//Implementation: org.eclipse.bpel.model.impl.CompensateImpl
import org.eclipse.bpel.model.*;
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
//+++++++++++++++++++++++imports for org.eclipse.wst.wsdl begin++++++++++++++++++++++
import org.eclipse.wst.wsdl.WSDLElement;
//Implementation: org.eclipse.wst.wsdl.internal.impl.WSDLElementImpl
import org.eclipse.wst.wsdl.PortType;
//Implementation: org.eclipse.wst.wsdl.internal.impl.PortTypeImpl
import org.eclipse.wst.wsdl.Operation;
//Implementation: org.eclipse.wst.wsdl.internal.impl.OperationImpl
import org.eclipse.wst.wsdl.Message;
//Implementation: org.eclipse.wst.wsdl.internal.impl.MessageImpl
import org.eclipse.wst.wsdl.Part;
//Implementation: org.eclipse.wst.wsdl.internal.impl.PartImpl
import org.eclipse.wst.wsdl.Binding;
//Implementation: org.eclipse.wst.wsdl.internal.impl.BindingImpl
import org.eclipse.wst.wsdl.BindingOperation;
//Implementation: org.eclipse.wst.wsdl.internal.impl.BindingOperationImpl
import org.eclipse.wst.wsdl.Service;
//Implementation: org.eclipse.wst.wsdl.internal.impl.ServiceImpl
import org.eclipse.wst.wsdl.Port;
//Implementation: org.eclipse.wst.wsdl.internal.impl.PortImpl
import org.eclipse.wst.wsdl.ExtensibilityElement;
//Implementation: org.eclipse.wst.wsdl.internal.impl.ExtensibilityElementImpl
import org.eclipse.wst.wsdl.Definition;
//Implementation: org.eclipse.wst.wsdl.internal.impl.DefinitionImpl
import org.eclipse.wst.wsdl.Import;
//Implementation: org.eclipse.wst.wsdl.internal.impl.ImportImpl
import org.eclipse.wst.wsdl.ExtensibleElement;
//Implementation: org.eclipse.wst.wsdl.internal.impl.ExtensibleElementImpl
import org.eclipse.wst.wsdl.Input;
//Implementation: org.eclipse.wst.wsdl.internal.impl.InputImpl
import org.eclipse.wst.wsdl.Output;
//Implementation: org.eclipse.wst.wsdl.internal.impl.OutputImpl
import org.eclipse.wst.wsdl.Fault;
//Implementation: org.eclipse.wst.wsdl.internal.impl.FaultImpl
import org.eclipse.wst.wsdl.BindingInput;
//Implementation: org.eclipse.wst.wsdl.internal.impl.BindingInputImpl
import org.eclipse.wst.wsdl.BindingOutput;
//Implementation: org.eclipse.wst.wsdl.internal.impl.BindingOutputImpl
import org.eclipse.wst.wsdl.BindingFault;
//Implementation: org.eclipse.wst.wsdl.internal.impl.BindingFaultImpl
import org.eclipse.wst.wsdl.Namespace;
//Implementation: org.eclipse.wst.wsdl.internal.impl.NamespaceImpl
import javax.wsdl.PortType;
//Implementation: org.eclipse.wst.wsdl.internal.impl.IPortTypeImpl
import javax.wsdl.Operation;
//Implementation: org.eclipse.wst.wsdl.internal.impl.IOperationImpl
import javax.wsdl.Input;
//Implementation: org.eclipse.wst.wsdl.internal.impl.IInputImpl
import javax.wsdl.Output;
//Implementation: org.eclipse.wst.wsdl.internal.impl.IOutputImpl
import javax.wsdl.Fault;
//Implementation: org.eclipse.wst.wsdl.internal.impl.IFaultImpl
import javax.wsdl.Message;
//Implementation: org.eclipse.wst.wsdl.internal.impl.IMessageImpl
import javax.wsdl.Part;
//Implementation: org.eclipse.wst.wsdl.internal.impl.IPartImpl
import javax.wsdl.Service;
//Implementation: org.eclipse.wst.wsdl.internal.impl.IServiceImpl
import javax.wsdl.Port;
//Implementation: org.eclipse.wst.wsdl.internal.impl.IPortImpl
import javax.wsdl.Binding;
//Implementation: org.eclipse.wst.wsdl.internal.impl.IBindingImpl
import javax.wsdl.BindingOperation;
//Implementation: org.eclipse.wst.wsdl.internal.impl.IBindingOperationImpl
import javax.wsdl.BindingInput;
//Implementation: org.eclipse.wst.wsdl.internal.impl.IBindingInputImpl
import javax.wsdl.BindingOutput;
//Implementation: org.eclipse.wst.wsdl.internal.impl.IBindingOutputImpl
import javax.wsdl.BindingFault;
//Implementation: org.eclipse.wst.wsdl.internal.impl.IBindingFaultImpl
import javax.wsdl.extensions.ExtensibilityElement;
//Implementation: org.eclipse.wst.wsdl.internal.impl.IExtensibilityElementImpl
import javax.wsdl.Definition;
//Implementation: org.eclipse.wst.wsdl.internal.impl.IDefinitionImpl
import javax.wsdl.Import;
//Implementation: org.eclipse.wst.wsdl.internal.impl.IImportImpl
import java.util.List;
//Implementation: org.eclipse.wst.wsdl.internal.impl.IListImpl
import java.util.Map;
//Implementation: org.eclipse.wst.wsdl.internal.impl.IMapImpl
import java.net.URL;
//Implementation: org.eclipse.wst.wsdl.internal.impl.IURLImpl
import javax.wsdl.extensions.ExtensionRegistry;
//Implementation: org.eclipse.wst.wsdl.internal.impl.IExtensionRegistryImpl
import org.eclipse.wst.wsdl.Types;
//Implementation: org.eclipse.wst.wsdl.internal.impl.TypesImpl
import java.util.Iterator;
//Implementation: org.eclipse.wst.wsdl.internal.impl.IIteratorImpl
import javax.wsdl.Types;
//Implementation: org.eclipse.wst.wsdl.internal.impl.ITypesImpl
import org.eclipse.wst.wsdl.UnknownExtensibilityElement;
//Implementation: org.eclipse.wst.wsdl.internal.impl.UnknownExtensibilityElementImpl
import org.eclipse.wst.wsdl.XSDSchemaExtensibilityElement;
//Implementation: org.eclipse.wst.wsdl.internal.impl.XSDSchemaExtensibilityElementImpl
import org.eclipse.wst.wsdl.MessageReference;
//Implementation: org.eclipse.wst.wsdl.internal.impl.MessageReferenceImpl
import org.eclipse.wst.wsdl.*;
//+++++++++++++++++++++++imports for org.eclipse.xsd begin++++++++++++++++++++++
import org.eclipse.xsd.XSDAnnotation;
//Implementation: org.eclipse.xsd.impl.XSDAnnotationImpl
import org.eclipse.xsd.XSDAttributeDeclaration;
//Implementation: org.eclipse.xsd.impl.XSDAttributeDeclarationImpl
import org.eclipse.xsd.XSDAttributeGroupContent;
//Implementation: org.eclipse.xsd.impl.XSDAttributeGroupContentImpl
import org.eclipse.xsd.XSDAttributeGroupDefinition;
//Implementation: org.eclipse.xsd.impl.XSDAttributeGroupDefinitionImpl
import org.eclipse.xsd.XSDAttributeUse;
//Implementation: org.eclipse.xsd.impl.XSDAttributeUseImpl
import org.eclipse.xsd.XSDBoundedFacet;
//Implementation: org.eclipse.xsd.impl.XSDBoundedFacetImpl
import org.eclipse.xsd.XSDCardinalityFacet;
//Implementation: org.eclipse.xsd.impl.XSDCardinalityFacetImpl
import org.eclipse.xsd.XSDComplexTypeContent;
//Implementation: org.eclipse.xsd.impl.XSDComplexTypeContentImpl
import org.eclipse.xsd.XSDComplexTypeDefinition;
//Implementation: org.eclipse.xsd.impl.XSDComplexTypeDefinitionImpl
import org.eclipse.xsd.XSDComponent;
//Implementation: org.eclipse.xsd.impl.XSDComponentImpl
import org.eclipse.xsd.XSDConcreteComponent;
//Implementation: org.eclipse.xsd.impl.XSDConcreteComponentImpl
import org.eclipse.xsd.XSDConstrainingFacet;
//Implementation: org.eclipse.xsd.impl.XSDConstrainingFacetImpl
import org.eclipse.xsd.XSDDiagnostic;
//Implementation: org.eclipse.xsd.impl.XSDDiagnosticImpl
import org.eclipse.xsd.XSDElementDeclaration;
//Implementation: org.eclipse.xsd.impl.XSDElementDeclarationImpl
import org.eclipse.xsd.XSDEnumerationFacet;
//Implementation: org.eclipse.xsd.impl.XSDEnumerationFacetImpl
import org.eclipse.xsd.XSDFacet;
//Implementation: org.eclipse.xsd.impl.XSDFacetImpl
import org.eclipse.xsd.XSDFeature;
//Implementation: org.eclipse.xsd.impl.XSDFeatureImpl
import org.eclipse.xsd.XSDFixedFacet;
//Implementation: org.eclipse.xsd.impl.XSDFixedFacetImpl
import org.eclipse.xsd.XSDFractionDigitsFacet;
//Implementation: org.eclipse.xsd.impl.XSDFractionDigitsFacetImpl
import org.eclipse.xsd.XSDFundamentalFacet;
//Implementation: org.eclipse.xsd.impl.XSDFundamentalFacetImpl
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
//Implementation: org.eclipse.xsd.impl.XSDIdentityConstraintDefinitionImpl
import org.eclipse.xsd.XSDImport;
//Implementation: org.eclipse.xsd.impl.XSDImportImpl
import org.eclipse.xsd.XSDInclude;
//Implementation: org.eclipse.xsd.impl.XSDIncludeImpl
import org.eclipse.xsd.XSDLengthFacet;
//Implementation: org.eclipse.xsd.impl.XSDLengthFacetImpl
import org.eclipse.xsd.XSDMaxExclusiveFacet;
//Implementation: org.eclipse.xsd.impl.XSDMaxExclusiveFacetImpl
import org.eclipse.xsd.XSDMaxFacet;
//Implementation: org.eclipse.xsd.impl.XSDMaxFacetImpl
import org.eclipse.xsd.XSDMaxInclusiveFacet;
//Implementation: org.eclipse.xsd.impl.XSDMaxInclusiveFacetImpl
import org.eclipse.xsd.XSDMaxLengthFacet;
//Implementation: org.eclipse.xsd.impl.XSDMaxLengthFacetImpl
import org.eclipse.xsd.XSDMinExclusiveFacet;
//Implementation: org.eclipse.xsd.impl.XSDMinExclusiveFacetImpl
import org.eclipse.xsd.XSDMinFacet;
//Implementation: org.eclipse.xsd.impl.XSDMinFacetImpl
import org.eclipse.xsd.XSDMinInclusiveFacet;
//Implementation: org.eclipse.xsd.impl.XSDMinInclusiveFacetImpl
import org.eclipse.xsd.XSDMinLengthFacet;
//Implementation: org.eclipse.xsd.impl.XSDMinLengthFacetImpl
import org.eclipse.xsd.XSDModelGroup;
//Implementation: org.eclipse.xsd.impl.XSDModelGroupImpl
import org.eclipse.xsd.XSDModelGroupDefinition;
//Implementation: org.eclipse.xsd.impl.XSDModelGroupDefinitionImpl
import org.eclipse.xsd.XSDNamedComponent;
//Implementation: org.eclipse.xsd.impl.XSDNamedComponentImpl
import org.eclipse.xsd.XSDNotationDeclaration;
//Implementation: org.eclipse.xsd.impl.XSDNotationDeclarationImpl
import org.eclipse.xsd.XSDNumericFacet;
//Implementation: org.eclipse.xsd.impl.XSDNumericFacetImpl
import org.eclipse.xsd.XSDOrderedFacet;
//Implementation: org.eclipse.xsd.impl.XSDOrderedFacetImpl
import org.eclipse.xsd.XSDParticle;
//Implementation: org.eclipse.xsd.impl.XSDParticleImpl
import org.eclipse.xsd.XSDParticleContent;
//Implementation: org.eclipse.xsd.impl.XSDParticleContentImpl
import org.eclipse.xsd.XSDPatternFacet;
//Implementation: org.eclipse.xsd.impl.XSDPatternFacetImpl
import org.eclipse.xsd.XSDRedefinableComponent;
//Implementation: org.eclipse.xsd.impl.XSDRedefinableComponentImpl
import org.eclipse.xsd.XSDRedefineContent;
//Implementation: org.eclipse.xsd.impl.XSDRedefineContentImpl
import org.eclipse.xsd.XSDRedefine;
//Implementation: org.eclipse.xsd.impl.XSDRedefineImpl
import org.eclipse.xsd.XSDRepeatableFacet;
//Implementation: org.eclipse.xsd.impl.XSDRepeatableFacetImpl
import org.eclipse.xsd.XSDSchema;
//Implementation: org.eclipse.xsd.impl.XSDSchemaImpl
import org.eclipse.xsd.XSDSchemaCompositor;
//Implementation: org.eclipse.xsd.impl.XSDSchemaCompositorImpl
import org.eclipse.xsd.XSDSchemaContent;
//Implementation: org.eclipse.xsd.impl.XSDSchemaContentImpl
import org.eclipse.xsd.XSDSchemaDirective;
//Implementation: org.eclipse.xsd.impl.XSDSchemaDirectiveImpl
import org.eclipse.xsd.XSDScope;
//Implementation: org.eclipse.xsd.impl.XSDScopeImpl
import org.eclipse.xsd.XSDSimpleTypeDefinition;
//Implementation: org.eclipse.xsd.impl.XSDSimpleTypeDefinitionImpl
import org.eclipse.xsd.XSDTerm;
//Implementation: org.eclipse.xsd.impl.XSDTermImpl
import org.eclipse.xsd.XSDTotalDigitsFacet;
//Implementation: org.eclipse.xsd.impl.XSDTotalDigitsFacetImpl
import org.eclipse.xsd.XSDTypeDefinition;
//Implementation: org.eclipse.xsd.impl.XSDTypeDefinitionImpl
import org.eclipse.xsd.XSDWhiteSpaceFacet;
//Implementation: org.eclipse.xsd.impl.XSDWhiteSpaceFacetImpl
import org.eclipse.xsd.XSDWildcard;
//Implementation: org.eclipse.xsd.impl.XSDWildcardImpl
import org.eclipse.xsd.XSDXPathDefinition;
//Implementation: org.eclipse.xsd.impl.XSDXPathDefinitionImpl
import org.eclipse.xsd.*;
//+++++++++++++++++++++++imports for org.eclipse.bpel.model.partnerlinktype begin++++++++++++++++++++++
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
//Implementation: org.eclipse.bpel.model.partnerlinktype.impl.PartnerLinkTypeImpl
import org.eclipse.bpel.model.partnerlinktype.Role;
//Implementation: org.eclipse.bpel.model.partnerlinktype.impl.RoleImpl
import org.eclipse.bpel.model.partnerlinktype.*;
//+++++++++++++++++++++++imports for org.eclipse.bpel.model.messageproperties begin++++++++++++++++++++++
import org.eclipse.bpel.model.messageproperties.Property;
//Implementation: org.eclipse.bpel.model.messageproperties.impl.PropertyImpl
import org.eclipse.bpel.model.messageproperties.PropertyAlias;
//Implementation: org.eclipse.bpel.model.messageproperties.impl.PropertyAliasImpl
import org.eclipse.bpel.model.messageproperties.Query;
//Implementation: org.eclipse.bpel.model.messageproperties.impl.QueryImpl
import org.eclipse.bpel.model.messageproperties.*;
import org.reuseware.emftextedit.runtime.resource.*;
import org.reuseware.emftextedit.runtime.resource.impl.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.common.util.URI;
}

@members{
	private TokenResolverFactory tokenResolverFactory = new BpwsTokenResolverFactory();

	protected EObject doParse() throws RecognitionException {
		((BpwsLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((BpwsLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		return start();
	}
}

start
returns [ EObject element = null]
:  
c0 = process{ element = c0; }

;

process returns [Process element = null]
@init{
	element = BPELFactory.eINSTANCE.createProcess();
}
:
	'Process'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'targetNamespace'
			':'
			a5 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("targetNamespace"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("targetNamespace"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'queryLanguage'
			':'
			a6 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("queryLanguage"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a6,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("queryLanguage"), resolved); copyLocalizationInfos((CommonToken) a6, element); }

			|
			'expressionLanguage'
			':'
			a7 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a7.getText(),element.eClass().getEStructuralFeature("expressionLanguage"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a7,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("expressionLanguage"), resolved); copyLocalizationInfos((CommonToken) a7, element); }

			|
			'suppressJoinFailure'
			':'
			a8 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a8.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a8,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a8, element); }

			|
			'variableAccessSerializable'
			':'
			a9 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a9.getText(),element.eClass().getEStructuralFeature("variableAccessSerializable"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a9,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("variableAccessSerializable"), resolved); copyLocalizationInfos((CommonToken) a9, element); }

			|
			'partnerLinks'
			':'
			a10 = partnerlinks{element.eSet(element.eClass().getEStructuralFeature("partnerLinks"), a10); copyLocalizationInfos(a10, element); }

			|
			'variables'
			':'
			a11 = variables{element.eSet(element.eClass().getEStructuralFeature("variables"), a11); copyLocalizationInfos(a11, element); }

			|
			'activity'
			':'
			a12 = activity{element.eSet(element.eClass().getEStructuralFeature("activity"), a12); copyLocalizationInfos(a12, element); }

			|
			'faultHandlers'
			':'
			a13 = faulthandler{element.eSet(element.eClass().getEStructuralFeature("faultHandlers"), a13); copyLocalizationInfos(a13, element); }

			|
			'eventHandlers'
			':'
			a14 = eventhandler{element.eSet(element.eClass().getEStructuralFeature("eventHandlers"), a14); copyLocalizationInfos(a14, element); }

			|
			'correlationSets'
			':'
			a15 = correlationsets{element.eSet(element.eClass().getEStructuralFeature("correlationSets"), a15); copyLocalizationInfos(a15, element); }

			|
			'imports'
			':'
			a16 = keywordimport{((List) element.eGet(element.eClass().getEStructuralFeature("imports"))).add(a16); copyLocalizationInfos(a16, element); }

			|
			'extensions'
			':'
			a17 = extensions{element.eSet(element.eClass().getEStructuralFeature("extensions"), a17); copyLocalizationInfos(a17, element); }

			|
			'exitOnStandardFault'
			':'
			a18 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a18.getText(),element.eClass().getEStructuralFeature("exitOnStandardFault"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a18,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("exitOnStandardFault"), resolved); copyLocalizationInfos((CommonToken) a18, element); }

			|
			'messageExchanges'
			':'
			a19 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a19.getText(),element.eClass().getEStructuralFeature("messageExchanges"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a19,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;MessageExchanges proxy = BPELFactory.eINSTANCE.createMessageExchanges();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("messageExchanges"), proxy); copyLocalizationInfos((CommonToken) a19, element); copyLocalizationInfos((CommonToken) a19, proxy); }
		)
	)*
	'}'
;

partnerlink returns [PartnerLink element = null]
@init{
	element = BPELFactory.eINSTANCE.createPartnerLink();
}
:
	'PartnerLink'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'myRole'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("myRole"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Role proxy = PartnerlinktypeFactory.eINSTANCE.createRole();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("myRole"), proxy); copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); }

			|
			'partnerRole'
			':'
			a6 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("partnerRole"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a6,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Role proxy = PartnerlinktypeFactory.eINSTANCE.createRole();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("partnerRole"), proxy); copyLocalizationInfos((CommonToken) a6, element); copyLocalizationInfos((CommonToken) a6, proxy); }

			|
			'PartnerLinkType'
			':'
			a7 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a7.getText(),element.eClass().getEStructuralFeature("PartnerLinkType"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a7,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;PartnerLinkType proxy = PartnerlinktypeFactory.eINSTANCE.createPartnerLinkType();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("PartnerLinkType"), proxy); copyLocalizationInfos((CommonToken) a7, element); copyLocalizationInfos((CommonToken) a7, proxy); }

			|
			'initializePartnerRole'
			':'
			a8 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a8.getText(),element.eClass().getEStructuralFeature("initializePartnerRole"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a8,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("initializePartnerRole"), resolved); copyLocalizationInfos((CommonToken) a8, element); }
		)
	)*
	'}'
;

faulthandler returns [FaultHandler element = null]
@init{
	element = BPELFactory.eINSTANCE.createFaultHandler();
}
:
	'FaultHandler'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'catch'
			':'
			a4 = keywordcatch{((List) element.eGet(element.eClass().getEStructuralFeature("catch"))).add(a4); copyLocalizationInfos(a4, element); }

			|
			'catchAll'
			':'
			a5 = catchall{element.eSet(element.eClass().getEStructuralFeature("catchAll"), a5); copyLocalizationInfos(a5, element); }
		)
	)*
	'}'
;

activity returns [Activity element = null]
@init{
	element = BPELFactory.eINSTANCE.createActivity();
}
:
	'Activity'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }
		)
	)*
	'}'
	|//derived choice rules for sub-classes: 
	c0 = invoke{ element = c0; }	|
	c1 = reply{ element = c1; }	|
	c2 = partneractivity{ element = c2; }	|
	c3 = receive{ element = c3; }	|
	c4 = exit{ element = c4; }	|
	c5 = keywordthrow{ element = c5; }	|
	c6 = wait{ element = c6; }	|
	c7 = empty{ element = c7; }	|
	c8 = sequence{ element = c8; }	|
	c9 = keywordwhile{ element = c9; }	|
	c10 = pick{ element = c10; }	|
	c11 = flow{ element = c11; }	|
	c12 = assign{ element = c12; }	|
	c13 = scope{ element = c13; }	|
	c14 = compensatescope{ element = c14; }	|
	c15 = rethrow{ element = c15; }	|
	c16 = extensionactivity{ element = c16; }	|
	c17 = opaqueactivity{ element = c17; }	|
	c18 = foreach{ element = c18; }	|
	c19 = repeatuntil{ element = c19; }	|
	c20 = validate{ element = c20; }	|
	c21 = keywordif{ element = c21; }	|
	c22 = compensate{ element = c22; }
;

correlationset returns [CorrelationSet element = null]
@init{
	element = BPELFactory.eINSTANCE.createCorrelationSet();
}
:
	'CorrelationSet'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'properties'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("properties"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Property proxy = MessagepropertiesFactory.eINSTANCE.createProperty();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("properties"))).add(proxy); copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); }
		)
	)*
	'}'
;

invoke returns [Invoke element = null]
@init{
	element = BPELFactory.eINSTANCE.createInvoke();
}
:
	'Invoke'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }

			|
			'partnerLink'
			':'
			a8 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a8.getText(),element.eClass().getEStructuralFeature("partnerLink"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a8,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;PartnerLink proxy = BPELFactory.eINSTANCE.createPartnerLink();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("partnerLink"), proxy); copyLocalizationInfos((CommonToken) a8, element); copyLocalizationInfos((CommonToken) a8, proxy); }

			|
			'correlations'
			':'
			a9 = correlations{element.eSet(element.eClass().getEStructuralFeature("correlations"), a9); copyLocalizationInfos(a9, element); }

			|
			'portType'
			':'
			a10 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a10.getText(),element.eClass().getEStructuralFeature("portType"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a10,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;PortType proxy = WSDLFactory.eINSTANCE.createPortType();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("portType"), proxy); copyLocalizationInfos((CommonToken) a10, element); copyLocalizationInfos((CommonToken) a10, proxy); }

			|
			'operation'
			':'
			a11 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a11.getText(),element.eClass().getEStructuralFeature("operation"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a11,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Operation proxy = WSDLFactory.eINSTANCE.createOperation();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("operation"), proxy); copyLocalizationInfos((CommonToken) a11, element); copyLocalizationInfos((CommonToken) a11, proxy); }

			|
			'outputVariable'
			':'
			a12 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a12.getText(),element.eClass().getEStructuralFeature("outputVariable"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a12,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Variable proxy = BPELFactory.eINSTANCE.createVariable();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("outputVariable"), proxy); copyLocalizationInfos((CommonToken) a12, element); copyLocalizationInfos((CommonToken) a12, proxy); }

			|
			'inputVariable'
			':'
			a13 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a13.getText(),element.eClass().getEStructuralFeature("inputVariable"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a13,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Variable proxy = BPELFactory.eINSTANCE.createVariable();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("inputVariable"), proxy); copyLocalizationInfos((CommonToken) a13, element); copyLocalizationInfos((CommonToken) a13, proxy); }

			|
			'compensationHandler'
			':'
			a14 = compensationhandler{element.eSet(element.eClass().getEStructuralFeature("compensationHandler"), a14); copyLocalizationInfos(a14, element); }

			|
			'faultHandler'
			':'
			a15 = faulthandler{element.eSet(element.eClass().getEStructuralFeature("faultHandler"), a15); copyLocalizationInfos(a15, element); }

			|
			'toPart'
			':'
			a16 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a16.getText(),element.eClass().getEStructuralFeature("toPart"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a16,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;ToPart proxy = BPELFactory.eINSTANCE.createToPart();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("toPart"))).add(proxy); copyLocalizationInfos((CommonToken) a16, element); copyLocalizationInfos((CommonToken) a16, proxy); }

			|
			'fromPart'
			':'
			a17 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a17.getText(),element.eClass().getEStructuralFeature("fromPart"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a17,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;FromPart proxy = BPELFactory.eINSTANCE.createFromPart();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("fromPart"))).add(proxy); copyLocalizationInfos((CommonToken) a17, element); copyLocalizationInfos((CommonToken) a17, proxy); }
		)
	)*
	'}'
;

link returns [Link element = null]
@init{
	element = BPELFactory.eINSTANCE.createLink();
}
:
	'Link'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'sources'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("sources"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Source proxy = BPELFactory.eINSTANCE.createSource();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("sources"))).add(proxy); copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); }

			|
			'targets'
			':'
			a6 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("targets"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a6,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Target proxy = BPELFactory.eINSTANCE.createTarget();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("targets"))).add(proxy); copyLocalizationInfos((CommonToken) a6, element); copyLocalizationInfos((CommonToken) a6, proxy); }
		)
	)*
	'}'
;

keywordcatch returns [Catch element = null]
@init{
	element = BPELFactory.eINSTANCE.createCatch();
}
:
	'Catch'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'faultName'
			':'
			a4 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("faultName"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());javax.xml.namespace.QName resolved = (javax.xml.namespace.QName)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("faultName"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'faultVariable'
			':'
			a5 = variable{element.eSet(element.eClass().getEStructuralFeature("faultVariable"), a5); copyLocalizationInfos(a5, element); }

			|
			'activity'
			':'
			a6 = activity{element.eSet(element.eClass().getEStructuralFeature("activity"), a6); copyLocalizationInfos(a6, element); }

			|
			'faultMessageType'
			':'
			a7 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a7.getText(),element.eClass().getEStructuralFeature("faultMessageType"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a7,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Message proxy = WSDLFactory.eINSTANCE.createMessage();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("faultMessageType"), proxy); copyLocalizationInfos((CommonToken) a7, element); copyLocalizationInfos((CommonToken) a7, proxy); }

			|
			'faultElement'
			':'
			a8 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a8.getText(),element.eClass().getEStructuralFeature("faultElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a8,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;XSDElementDeclaration proxy = XSDFactory.eINSTANCE.createXSDElementDeclaration();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("faultElement"), proxy); copyLocalizationInfos((CommonToken) a8, element); copyLocalizationInfos((CommonToken) a8, proxy); }
		)
	)*
	'}'
;

reply returns [Reply element = null]
@init{
	element = BPELFactory.eINSTANCE.createReply();
}
:
	'Reply'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }

			|
			'partnerLink'
			':'
			a8 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a8.getText(),element.eClass().getEStructuralFeature("partnerLink"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a8,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;PartnerLink proxy = BPELFactory.eINSTANCE.createPartnerLink();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("partnerLink"), proxy); copyLocalizationInfos((CommonToken) a8, element); copyLocalizationInfos((CommonToken) a8, proxy); }

			|
			'correlations'
			':'
			a9 = correlations{element.eSet(element.eClass().getEStructuralFeature("correlations"), a9); copyLocalizationInfos(a9, element); }

			|
			'portType'
			':'
			a10 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a10.getText(),element.eClass().getEStructuralFeature("portType"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a10,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;PortType proxy = WSDLFactory.eINSTANCE.createPortType();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("portType"), proxy); copyLocalizationInfos((CommonToken) a10, element); copyLocalizationInfos((CommonToken) a10, proxy); }

			|
			'operation'
			':'
			a11 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a11.getText(),element.eClass().getEStructuralFeature("operation"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a11,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Operation proxy = WSDLFactory.eINSTANCE.createOperation();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("operation"), proxy); copyLocalizationInfos((CommonToken) a11, element); copyLocalizationInfos((CommonToken) a11, proxy); }

			|
			'faultName'
			':'
			a12 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a12.getText(),element.eClass().getEStructuralFeature("faultName"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a12,resolvedResolver.getErrorMessage());javax.xml.namespace.QName resolved = (javax.xml.namespace.QName)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("faultName"), resolved); copyLocalizationInfos((CommonToken) a12, element); }

			|
			'variable'
			':'
			a13 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a13.getText(),element.eClass().getEStructuralFeature("variable"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a13,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Variable proxy = BPELFactory.eINSTANCE.createVariable();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("variable"), proxy); copyLocalizationInfos((CommonToken) a13, element); copyLocalizationInfos((CommonToken) a13, proxy); }

			|
			'toPart'
			':'
			a14 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a14.getText(),element.eClass().getEStructuralFeature("toPart"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a14,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;ToPart proxy = BPELFactory.eINSTANCE.createToPart();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("toPart"))).add(proxy); copyLocalizationInfos((CommonToken) a14, element); copyLocalizationInfos((CommonToken) a14, proxy); }
		)
	)*
	'}'
;

partneractivity returns [PartnerActivity element = null]
@init{
	element = BPELFactory.eINSTANCE.createPartnerActivity();
}
:
	'PartnerActivity'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }

			|
			'partnerLink'
			':'
			a8 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a8.getText(),element.eClass().getEStructuralFeature("partnerLink"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a8,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;PartnerLink proxy = BPELFactory.eINSTANCE.createPartnerLink();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("partnerLink"), proxy); copyLocalizationInfos((CommonToken) a8, element); copyLocalizationInfos((CommonToken) a8, proxy); }

			|
			'correlations'
			':'
			a9 = correlations{element.eSet(element.eClass().getEStructuralFeature("correlations"), a9); copyLocalizationInfos(a9, element); }

			|
			'portType'
			':'
			a10 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a10.getText(),element.eClass().getEStructuralFeature("portType"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a10,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;PortType proxy = WSDLFactory.eINSTANCE.createPortType();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("portType"), proxy); copyLocalizationInfos((CommonToken) a10, element); copyLocalizationInfos((CommonToken) a10, proxy); }

			|
			'operation'
			':'
			a11 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a11.getText(),element.eClass().getEStructuralFeature("operation"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a11,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Operation proxy = WSDLFactory.eINSTANCE.createOperation();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("operation"), proxy); copyLocalizationInfos((CommonToken) a11, element); copyLocalizationInfos((CommonToken) a11, proxy); }
		)
	)*
	'}'
	|//derived choice rules for sub-classes: 
	c0 = invoke{ element = c0; }	|
	c1 = reply{ element = c1; }	|
	c2 = receive{ element = c2; }
;

receive returns [Receive element = null]
@init{
	element = BPELFactory.eINSTANCE.createReceive();
}
:
	'Receive'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }

			|
			'partnerLink'
			':'
			a8 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a8.getText(),element.eClass().getEStructuralFeature("partnerLink"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a8,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;PartnerLink proxy = BPELFactory.eINSTANCE.createPartnerLink();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("partnerLink"), proxy); copyLocalizationInfos((CommonToken) a8, element); copyLocalizationInfos((CommonToken) a8, proxy); }

			|
			'correlations'
			':'
			a9 = correlations{element.eSet(element.eClass().getEStructuralFeature("correlations"), a9); copyLocalizationInfos(a9, element); }

			|
			'portType'
			':'
			a10 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a10.getText(),element.eClass().getEStructuralFeature("portType"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a10,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;PortType proxy = WSDLFactory.eINSTANCE.createPortType();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("portType"), proxy); copyLocalizationInfos((CommonToken) a10, element); copyLocalizationInfos((CommonToken) a10, proxy); }

			|
			'operation'
			':'
			a11 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a11.getText(),element.eClass().getEStructuralFeature("operation"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a11,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Operation proxy = WSDLFactory.eINSTANCE.createOperation();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("operation"), proxy); copyLocalizationInfos((CommonToken) a11, element); copyLocalizationInfos((CommonToken) a11, proxy); }

			|
			'createInstance'
			':'
			a12 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a12.getText(),element.eClass().getEStructuralFeature("createInstance"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a12,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("createInstance"), resolved); copyLocalizationInfos((CommonToken) a12, element); }

			|
			'variable'
			':'
			a13 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a13.getText(),element.eClass().getEStructuralFeature("variable"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a13,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Variable proxy = BPELFactory.eINSTANCE.createVariable();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("variable"), proxy); copyLocalizationInfos((CommonToken) a13, element); copyLocalizationInfos((CommonToken) a13, proxy); }

			|
			'fromPart'
			':'
			a14 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a14.getText(),element.eClass().getEStructuralFeature("fromPart"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a14,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;FromPart proxy = BPELFactory.eINSTANCE.createFromPart();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("fromPart"))).add(proxy); copyLocalizationInfos((CommonToken) a14, element); copyLocalizationInfos((CommonToken) a14, proxy); }
		)
	)*
	'}'
;

exit returns [Exit element = null]
@init{
	element = BPELFactory.eINSTANCE.createExit();
}
:
	'Exit'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }
		)
	)*
	'}'
;

keywordthrow returns [Throw element = null]
@init{
	element = BPELFactory.eINSTANCE.createThrow();
}
:
	'Throw'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }

			|
			'faultName'
			':'
			a8 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a8.getText(),element.eClass().getEStructuralFeature("faultName"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a8,resolvedResolver.getErrorMessage());javax.xml.namespace.QName resolved = (javax.xml.namespace.QName)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("faultName"), resolved); copyLocalizationInfos((CommonToken) a8, element); }

			|
			'faultVariable'
			':'
			a9 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a9.getText(),element.eClass().getEStructuralFeature("faultVariable"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a9,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Variable proxy = BPELFactory.eINSTANCE.createVariable();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("faultVariable"), proxy); copyLocalizationInfos((CommonToken) a9, element); copyLocalizationInfos((CommonToken) a9, proxy); }
		)
	)*
	'}'
;

wait returns [Wait element = null]
@init{
	element = BPELFactory.eINSTANCE.createWait();
}
:
	'Wait'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }

			|
			'for'
			':'
			a8 = expression{element.eSet(element.eClass().getEStructuralFeature("for"), a8); copyLocalizationInfos(a8, element); }

			|
			'until'
			':'
			a9 = expression{element.eSet(element.eClass().getEStructuralFeature("until"), a9); copyLocalizationInfos(a9, element); }
		)
	)*
	'}'
;

empty returns [Empty element = null]
@init{
	element = BPELFactory.eINSTANCE.createEmpty();
}
:
	'Empty'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }
		)
	)*
	'}'
;

sequence returns [Sequence element = null]
@init{
	element = BPELFactory.eINSTANCE.createSequence();
}
:
	'Sequence'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }

			|
			'activities'
			':'
			a8 = activity{((List) element.eGet(element.eClass().getEStructuralFeature("activities"))).add(a8); copyLocalizationInfos(a8, element); }
		)
	)*
	'}'
;

keywordwhile returns [While element = null]
@init{
	element = BPELFactory.eINSTANCE.createWhile();
}
:
	'While'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }

			|
			'activity'
			':'
			a8 = activity{element.eSet(element.eClass().getEStructuralFeature("activity"), a8); copyLocalizationInfos(a8, element); }

			|
			'condition'
			':'
			a9 = condition{element.eSet(element.eClass().getEStructuralFeature("condition"), a9); copyLocalizationInfos(a9, element); }
		)
	)*
	'}'
;

pick returns [Pick element = null]
@init{
	element = BPELFactory.eINSTANCE.createPick();
}
:
	'Pick'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }

			|
			'createInstance'
			':'
			a8 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a8.getText(),element.eClass().getEStructuralFeature("createInstance"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a8,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("createInstance"), resolved); copyLocalizationInfos((CommonToken) a8, element); }

			|
			'messages'
			':'
			a9 = onmessage{((List) element.eGet(element.eClass().getEStructuralFeature("messages"))).add(a9); copyLocalizationInfos(a9, element); }

			|
			'alarm'
			':'
			a10 = onalarm{((List) element.eGet(element.eClass().getEStructuralFeature("alarm"))).add(a10); copyLocalizationInfos(a10, element); }
		)
	)*
	'}'
;

flow returns [Flow element = null]
@init{
	element = BPELFactory.eINSTANCE.createFlow();
}
:
	'Flow'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }

			|
			'activities'
			':'
			a8 = activity{((List) element.eGet(element.eClass().getEStructuralFeature("activities"))).add(a8); copyLocalizationInfos(a8, element); }

			|
			'links'
			':'
			a9 = links{element.eSet(element.eClass().getEStructuralFeature("links"), a9); copyLocalizationInfos(a9, element); }

			|
			'completionCondition'
			':'
			a10 = completioncondition{element.eSet(element.eClass().getEStructuralFeature("completionCondition"), a10); copyLocalizationInfos(a10, element); }
		)
	)*
	'}'
;

onalarm returns [OnAlarm element = null]
@init{
	element = BPELFactory.eINSTANCE.createOnAlarm();
}
:
	'OnAlarm'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'activity'
			':'
			a4 = activity{element.eSet(element.eClass().getEStructuralFeature("activity"), a4); copyLocalizationInfos(a4, element); }

			|
			'for'
			':'
			a5 = expression{element.eSet(element.eClass().getEStructuralFeature("for"), a5); copyLocalizationInfos(a5, element); }

			|
			'until'
			':'
			a6 = expression{element.eSet(element.eClass().getEStructuralFeature("until"), a6); copyLocalizationInfos(a6, element); }

			|
			'repeatEvery'
			':'
			a7 = expression{element.eSet(element.eClass().getEStructuralFeature("repeatEvery"), a7); copyLocalizationInfos(a7, element); }
		)
	)*
	'}'
;

assign returns [Assign element = null]
@init{
	element = BPELFactory.eINSTANCE.createAssign();
}
:
	'Assign'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }

			|
			'copy'
			':'
			a8 = copy{((List) element.eGet(element.eClass().getEStructuralFeature("copy"))).add(a8); copyLocalizationInfos(a8, element); }

			|
			'validate'
			':'
			a9 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a9.getText(),element.eClass().getEStructuralFeature("validate"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a9,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("validate"), resolved); copyLocalizationInfos((CommonToken) a9, element); }
		)
	)*
	'}'
;

copy returns [Copy element = null]
@init{
	element = BPELFactory.eINSTANCE.createCopy();
}
:
	'Copy'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'to'
			':'
			a4 = to{element.eSet(element.eClass().getEStructuralFeature("to"), a4); copyLocalizationInfos(a4, element); }

			|
			'from'
			':'
			a5 = from{element.eSet(element.eClass().getEStructuralFeature("from"), a5); copyLocalizationInfos(a5, element); }

			|
			'keepSrcElementName'
			':'
			a6 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("keepSrcElementName"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a6,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("keepSrcElementName"), resolved); copyLocalizationInfos((CommonToken) a6, element); }

			|
			'ignoreMissingFromData'
			':'
			a7 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a7.getText(),element.eClass().getEStructuralFeature("ignoreMissingFromData"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a7,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("ignoreMissingFromData"), resolved); copyLocalizationInfos((CommonToken) a7, element); }
		)
	)*
	'}'
;

extension returns [Extension element = null]
@init{
	element = BPELFactory.eINSTANCE.createExtension();
}
:
	'Extension'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'namespace'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("namespace"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("namespace"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'mustUnderstand'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("mustUnderstand"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("mustUnderstand"), resolved); copyLocalizationInfos((CommonToken) a5, element); }
		)
	)*
	'}'
;

scope returns [Scope element = null]
@init{
	element = BPELFactory.eINSTANCE.createScope();
}
:
	'Scope'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }

			|
			'isolated'
			':'
			a8 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a8.getText(),element.eClass().getEStructuralFeature("isolated"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a8,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("isolated"), resolved); copyLocalizationInfos((CommonToken) a8, element); }

			|
			'faultHandlers'
			':'
			a9 = faulthandler{element.eSet(element.eClass().getEStructuralFeature("faultHandlers"), a9); copyLocalizationInfos(a9, element); }

			|
			'compensationHandler'
			':'
			a10 = compensationhandler{element.eSet(element.eClass().getEStructuralFeature("compensationHandler"), a10); copyLocalizationInfos(a10, element); }

			|
			'activity'
			':'
			a11 = activity{element.eSet(element.eClass().getEStructuralFeature("activity"), a11); copyLocalizationInfos(a11, element); }

			|
			'variables'
			':'
			a12 = variables{element.eSet(element.eClass().getEStructuralFeature("variables"), a12); copyLocalizationInfos(a12, element); }

			|
			'correlationSets'
			':'
			a13 = correlationsets{element.eSet(element.eClass().getEStructuralFeature("correlationSets"), a13); copyLocalizationInfos(a13, element); }

			|
			'eventHandlers'
			':'
			a14 = eventhandler{element.eSet(element.eClass().getEStructuralFeature("eventHandlers"), a14); copyLocalizationInfos(a14, element); }

			|
			'partnerLinks'
			':'
			a15 = partnerlinks{element.eSet(element.eClass().getEStructuralFeature("partnerLinks"), a15); copyLocalizationInfos(a15, element); }

			|
			'terminationHandler'
			':'
			a16 = terminationhandler{element.eSet(element.eClass().getEStructuralFeature("terminationHandler"), a16); copyLocalizationInfos(a16, element); }

			|
			'messageExchanges'
			':'
			a17 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a17.getText(),element.eClass().getEStructuralFeature("messageExchanges"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a17,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;MessageExchanges proxy = BPELFactory.eINSTANCE.createMessageExchanges();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("messageExchanges"), proxy); copyLocalizationInfos((CommonToken) a17, element); copyLocalizationInfos((CommonToken) a17, proxy); }

			|
			'exitOnStandardFault'
			':'
			a18 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a18.getText(),element.eClass().getEStructuralFeature("exitOnStandardFault"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a18,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("exitOnStandardFault"), resolved); copyLocalizationInfos((CommonToken) a18, element); }
		)
	)*
	'}'
;

compensatescope returns [CompensateScope element = null]
@init{
	element = BPELFactory.eINSTANCE.createCompensateScope();
}
:
	'CompensateScope'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }

			|
			'target'
			':'
			a8 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a8.getText(),element.eClass().getEStructuralFeature("target"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a8,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Activity proxy = BPELFactory.eINSTANCE.createActivity();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("target"), proxy); copyLocalizationInfos((CommonToken) a8, element); copyLocalizationInfos((CommonToken) a8, proxy); }
		)
	)*
	'}'
;

compensationhandler returns [CompensationHandler element = null]
@init{
	element = BPELFactory.eINSTANCE.createCompensationHandler();
}
:
	'CompensationHandler'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'activity'
			':'
			a4 = activity{element.eSet(element.eClass().getEStructuralFeature("activity"), a4); copyLocalizationInfos(a4, element); }
		)
	)*
	'}'
;

to returns [To element = null]
@init{
	element = BPELFactory.eINSTANCE.createTo();
}
:
	'To'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'variable'
			':'
			a4 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("variable"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Variable proxy = BPELFactory.eINSTANCE.createVariable();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("variable"), proxy); copyLocalizationInfos((CommonToken) a4, element); copyLocalizationInfos((CommonToken) a4, proxy); }

			|
			'part'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("part"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Part proxy = WSDLFactory.eINSTANCE.createPart();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("part"), proxy); copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); }

			|
			'partnerLink'
			':'
			a6 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("partnerLink"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a6,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;PartnerLink proxy = BPELFactory.eINSTANCE.createPartnerLink();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("partnerLink"), proxy); copyLocalizationInfos((CommonToken) a6, element); copyLocalizationInfos((CommonToken) a6, proxy); }

			|
			'property'
			':'
			a7 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a7.getText(),element.eClass().getEStructuralFeature("property"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a7,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Property proxy = MessagepropertiesFactory.eINSTANCE.createProperty();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("property"), proxy); copyLocalizationInfos((CommonToken) a7, element); copyLocalizationInfos((CommonToken) a7, proxy); }

			|
			'query'
			':'
			a8 = query{element.eSet(element.eClass().getEStructuralFeature("query"), a8); copyLocalizationInfos(a8, element); }

			|
			'expression'
			':'
			a9 = expression{element.eSet(element.eClass().getEStructuralFeature("expression"), a9); copyLocalizationInfos(a9, element); }
		)
	)*
	'}'
;

from returns [From element = null]
@init{
	element = BPELFactory.eINSTANCE.createFrom();
}
:
	'From'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'opaque'
			':'
			a4 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("opaque"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("opaque"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'endpointReference'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("endpointReference"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());EndpointReferenceRole resolved = (EndpointReferenceRole)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("endpointReference"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'literal'
			':'
			a6 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("literal"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a6,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("literal"), resolved); copyLocalizationInfos((CommonToken) a6, element); }

			|
			'unsafeLiteral'
			':'
			a7 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a7.getText(),element.eClass().getEStructuralFeature("unsafeLiteral"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a7,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("unsafeLiteral"), resolved); copyLocalizationInfos((CommonToken) a7, element); }

			|
			'expression'
			':'
			a8 = expression{element.eSet(element.eClass().getEStructuralFeature("expression"), a8); copyLocalizationInfos(a8, element); }

			|
			'serviceRef'
			':'
			a9 = serviceref{element.eSet(element.eClass().getEStructuralFeature("serviceRef"), a9); copyLocalizationInfos(a9, element); }

			|
			'type'
			':'
			a10 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a10.getText(),element.eClass().getEStructuralFeature("type"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a10,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;XSDComplexTypeDefinition proxy = XSDFactory.eINSTANCE.createXSDComplexTypeDefinition();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("type"), proxy); copyLocalizationInfos((CommonToken) a10, element); copyLocalizationInfos((CommonToken) a10, proxy); }

			|
			'variable'
			':'
			a11 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a11.getText(),element.eClass().getEStructuralFeature("variable"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a11,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Variable proxy = BPELFactory.eINSTANCE.createVariable();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("variable"), proxy); copyLocalizationInfos((CommonToken) a11, element); copyLocalizationInfos((CommonToken) a11, proxy); }

			|
			'part'
			':'
			a12 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a12.getText(),element.eClass().getEStructuralFeature("part"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a12,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Part proxy = WSDLFactory.eINSTANCE.createPart();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("part"), proxy); copyLocalizationInfos((CommonToken) a12, element); copyLocalizationInfos((CommonToken) a12, proxy); }

			|
			'partnerLink'
			':'
			a13 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a13.getText(),element.eClass().getEStructuralFeature("partnerLink"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a13,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;PartnerLink proxy = BPELFactory.eINSTANCE.createPartnerLink();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("partnerLink"), proxy); copyLocalizationInfos((CommonToken) a13, element); copyLocalizationInfos((CommonToken) a13, proxy); }

			|
			'property'
			':'
			a14 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a14.getText(),element.eClass().getEStructuralFeature("property"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a14,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Property proxy = MessagepropertiesFactory.eINSTANCE.createProperty();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("property"), proxy); copyLocalizationInfos((CommonToken) a14, element); copyLocalizationInfos((CommonToken) a14, proxy); }

			|
			'query'
			':'
			a15 = query{element.eSet(element.eClass().getEStructuralFeature("query"), a15); copyLocalizationInfos(a15, element); }
		)
	)*
	'}'
;

onmessage returns [OnMessage element = null]
@init{
	element = BPELFactory.eINSTANCE.createOnMessage();
}
:
	'OnMessage'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'variable'
			':'
			a4 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("variable"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Variable proxy = BPELFactory.eINSTANCE.createVariable();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("variable"), proxy); copyLocalizationInfos((CommonToken) a4, element); copyLocalizationInfos((CommonToken) a4, proxy); }

			|
			'activity'
			':'
			a5 = activity{element.eSet(element.eClass().getEStructuralFeature("activity"), a5); copyLocalizationInfos(a5, element); }

			|
			'portType'
			':'
			a6 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("portType"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a6,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;PortType proxy = WSDLFactory.eINSTANCE.createPortType();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("portType"), proxy); copyLocalizationInfos((CommonToken) a6, element); copyLocalizationInfos((CommonToken) a6, proxy); }

			|
			'partnerLink'
			':'
			a7 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a7.getText(),element.eClass().getEStructuralFeature("partnerLink"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a7,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;PartnerLink proxy = BPELFactory.eINSTANCE.createPartnerLink();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("partnerLink"), proxy); copyLocalizationInfos((CommonToken) a7, element); copyLocalizationInfos((CommonToken) a7, proxy); }

			|
			'correlations'
			':'
			a8 = correlations{element.eSet(element.eClass().getEStructuralFeature("correlations"), a8); copyLocalizationInfos(a8, element); }

			|
			'operation'
			':'
			a9 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a9.getText(),element.eClass().getEStructuralFeature("operation"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a9,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Operation proxy = WSDLFactory.eINSTANCE.createOperation();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("operation"), proxy); copyLocalizationInfos((CommonToken) a9, element); copyLocalizationInfos((CommonToken) a9, proxy); }

			|
			'fromPart'
			':'
			a10 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a10.getText(),element.eClass().getEStructuralFeature("fromPart"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a10,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;FromPart proxy = BPELFactory.eINSTANCE.createFromPart();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("fromPart"))).add(proxy); copyLocalizationInfos((CommonToken) a10, element); copyLocalizationInfos((CommonToken) a10, proxy); }
		)
	)*
	'}'
;

expression returns [Expression element = null]
@init{
	element = BPELFactory.eINSTANCE.createExpression();
}
:
	(
		a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("required"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("required"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
	)?
	'Expression'
	'{'
	(
		(
			'documentationElement'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'element'
			':'
			a2 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a2, element); }

			|
			'elementType'
			':'
			a3 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("elementType"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());javax.xml.namespace.QName resolved = (javax.xml.namespace.QName)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("elementType"), resolved); copyLocalizationInfos((CommonToken) a3, element); }

			|
			'body'
			':'
			a4 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("body"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.Object resolved = (java.lang.Object)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("body"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'expressionLanguage'
			':'
			a5 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("expressionLanguage"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("expressionLanguage"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'opaque'
			':'
			a6 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("opaque"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a6,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("opaque"), resolved); copyLocalizationInfos((CommonToken) a6, element); }
		)
	)*
	'}'
	|//derived choice rules for sub-classes: 
	c0 = booleanexpression{ element = c0; }	|
	c1 = condition{ element = c1; }	|
	c2 = branches{ element = c2; }
;

booleanexpression returns [BooleanExpression element = null]
@init{
	element = BPELFactory.eINSTANCE.createBooleanExpression();
}
:
	(
		a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("required"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("required"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
	)?
	'BooleanExpression'
	'{'
	(
		(
			'documentationElement'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'element'
			':'
			a2 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a2, element); }

			|
			'elementType'
			':'
			a3 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("elementType"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());javax.xml.namespace.QName resolved = (javax.xml.namespace.QName)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("elementType"), resolved); copyLocalizationInfos((CommonToken) a3, element); }

			|
			'body'
			':'
			a4 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("body"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.Object resolved = (java.lang.Object)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("body"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'expressionLanguage'
			':'
			a5 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("expressionLanguage"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("expressionLanguage"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'opaque'
			':'
			a6 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("opaque"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a6,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("opaque"), resolved); copyLocalizationInfos((CommonToken) a6, element); }
		)
	)*
	'}'
;

correlation returns [Correlation element = null]
@init{
	element = BPELFactory.eINSTANCE.createCorrelation();
}
:
	'Correlation'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'initiate'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("initiate"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("initiate"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'pattern'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("pattern"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());CorrelationPattern resolved = (CorrelationPattern)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("pattern"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'set'
			':'
			a6 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("set"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a6,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;CorrelationSet proxy = BPELFactory.eINSTANCE.createCorrelationSet();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("set"), proxy); copyLocalizationInfos((CommonToken) a6, element); copyLocalizationInfos((CommonToken) a6, proxy); }
		)
	)*
	'}'
;

eventhandler returns [EventHandler element = null]
@init{
	element = BPELFactory.eINSTANCE.createEventHandler();
}
:
	'EventHandler'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'alarm'
			':'
			a4 = onalarm{((List) element.eGet(element.eClass().getEStructuralFeature("alarm"))).add(a4); copyLocalizationInfos(a4, element); }

			|
			'events'
			':'
			a5 = onevent{((List) element.eGet(element.eClass().getEStructuralFeature("events"))).add(a5); copyLocalizationInfos(a5, element); }
		)
	)*
	'}'
;

source returns [Source element = null]
@init{
	element = BPELFactory.eINSTANCE.createSource();
}
:
	'Source'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'Link'
			':'
			a4 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("Link"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Link proxy = BPELFactory.eINSTANCE.createLink();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("Link"), proxy); copyLocalizationInfos((CommonToken) a4, element); copyLocalizationInfos((CommonToken) a4, proxy); }

			|
			'activity'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("activity"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Activity proxy = BPELFactory.eINSTANCE.createActivity();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("activity"), proxy); copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); }

			|
			'transitionCondition'
			':'
			a6 = condition{element.eSet(element.eClass().getEStructuralFeature("transitionCondition"), a6); copyLocalizationInfos(a6, element); }
		)
	)*
	'}'
;

target returns [Target element = null]
@init{
	element = BPELFactory.eINSTANCE.createTarget();
}
:
	'Target'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'Link'
			':'
			a4 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("Link"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Link proxy = BPELFactory.eINSTANCE.createLink();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("Link"), proxy); copyLocalizationInfos((CommonToken) a4, element); copyLocalizationInfos((CommonToken) a4, proxy); }

			|
			'activity'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("activity"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Activity proxy = BPELFactory.eINSTANCE.createActivity();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("activity"), proxy); copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); }
		)
	)*
	'}'
;

partnerlinks returns [PartnerLinks element = null]
@init{
	element = BPELFactory.eINSTANCE.createPartnerLinks();
}
:
	'PartnerLinks'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'children'
			':'
			a4 = partnerlink{((List) element.eGet(element.eClass().getEStructuralFeature("children"))).add(a4); copyLocalizationInfos(a4, element); }
		)
	)*
	'}'
;

variables returns [Variables element = null]
@init{
	element = BPELFactory.eINSTANCE.createVariables();
}
:
	'Variables'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'children'
			':'
			a4 = variable{((List) element.eGet(element.eClass().getEStructuralFeature("children"))).add(a4); copyLocalizationInfos(a4, element); }
		)
	)*
	'}'
;

correlationsets returns [CorrelationSets element = null]
@init{
	element = BPELFactory.eINSTANCE.createCorrelationSets();
}
:
	'CorrelationSets'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'children'
			':'
			a4 = correlationset{((List) element.eGet(element.eClass().getEStructuralFeature("children"))).add(a4); copyLocalizationInfos(a4, element); }
		)
	)*
	'}'
;

links returns [Links element = null]
@init{
	element = BPELFactory.eINSTANCE.createLinks();
}
:
	'Links'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'children'
			':'
			a4 = link{((List) element.eGet(element.eClass().getEStructuralFeature("children"))).add(a4); copyLocalizationInfos(a4, element); }
		)
	)*
	'}'
;

catchall returns [CatchAll element = null]
@init{
	element = BPELFactory.eINSTANCE.createCatchAll();
}
:
	'CatchAll'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'activity'
			':'
			a4 = activity{element.eSet(element.eClass().getEStructuralFeature("activity"), a4); copyLocalizationInfos(a4, element); }
		)
	)*
	'}'
;

correlations returns [Correlations element = null]
@init{
	element = BPELFactory.eINSTANCE.createCorrelations();
}
:
	'Correlations'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'children'
			':'
			a4 = correlation{((List) element.eGet(element.eClass().getEStructuralFeature("children"))).add(a4); copyLocalizationInfos(a4, element); }
		)
	)*
	'}'
;

variable returns [Variable element = null]
@init{
	element = BPELFactory.eINSTANCE.createVariable();
}
:
	'Variable'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'messageType'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("messageType"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Message proxy = WSDLFactory.eINSTANCE.createMessage();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("messageType"), proxy); copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); }

			|
			'XSDElement'
			':'
			a6 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("XSDElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a6,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;XSDElementDeclaration proxy = XSDFactory.eINSTANCE.createXSDElementDeclaration();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("XSDElement"), proxy); copyLocalizationInfos((CommonToken) a6, element); copyLocalizationInfos((CommonToken) a6, proxy); }

			|
			'type'
			':'
			a7 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a7.getText(),element.eClass().getEStructuralFeature("type"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a7,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;XSDComplexTypeDefinition proxy = XSDFactory.eINSTANCE.createXSDComplexTypeDefinition();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("type"), proxy); copyLocalizationInfos((CommonToken) a7, element); copyLocalizationInfos((CommonToken) a7, proxy); }

			|
			'from'
			':'
			a8 = from{element.eSet(element.eClass().getEStructuralFeature("from"), a8); copyLocalizationInfos(a8, element); }
		)
	)*
	'}'
;

unknownextensibilityattribute returns [UnknownExtensibilityAttribute element = null]
@init{
	element = BPELFactory.eINSTANCE.createUnknownExtensibilityAttribute();
}
:
	(
		a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("required"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("required"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
	)?
	'UnknownExtensibilityAttribute'
	'{'
	(
		(
			'documentationElement'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'element'
			':'
			a2 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a2, element); }

			|
			'elementType'
			':'
			a3 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("elementType"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());javax.xml.namespace.QName resolved = (javax.xml.namespace.QName)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("elementType"), resolved); copyLocalizationInfos((CommonToken) a3, element); }

			|
			'children'
			':'
			a4 = unknownextensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("children"))).add(a4); copyLocalizationInfos(a4, element); }
		)
	)*
	'}'
;

onevent returns [OnEvent element = null]
@init{
	element = BPELFactory.eINSTANCE.createOnEvent();
}
:
	'OnEvent'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'activity'
			':'
			a4 = activity{element.eSet(element.eClass().getEStructuralFeature("activity"), a4); copyLocalizationInfos(a4, element); }

			|
			'variable'
			':'
			a5 = variable{element.eSet(element.eClass().getEStructuralFeature("variable"), a5); copyLocalizationInfos(a5, element); }

			|
			'partnerLink'
			':'
			a6 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("partnerLink"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a6,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;PartnerLink proxy = BPELFactory.eINSTANCE.createPartnerLink();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("partnerLink"), proxy); copyLocalizationInfos((CommonToken) a6, element); copyLocalizationInfos((CommonToken) a6, proxy); }

			|
			'correlations'
			':'
			a7 = correlations{element.eSet(element.eClass().getEStructuralFeature("correlations"), a7); copyLocalizationInfos(a7, element); }

			|
			'operation'
			':'
			a8 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a8.getText(),element.eClass().getEStructuralFeature("operation"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a8,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Operation proxy = WSDLFactory.eINSTANCE.createOperation();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("operation"), proxy); copyLocalizationInfos((CommonToken) a8, element); copyLocalizationInfos((CommonToken) a8, proxy); }

			|
			'portType'
			':'
			a9 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a9.getText(),element.eClass().getEStructuralFeature("portType"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a9,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;PortType proxy = WSDLFactory.eINSTANCE.createPortType();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("portType"), proxy); copyLocalizationInfos((CommonToken) a9, element); copyLocalizationInfos((CommonToken) a9, proxy); }

			|
			'messageType'
			':'
			a10 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a10.getText(),element.eClass().getEStructuralFeature("messageType"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a10,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Message proxy = WSDLFactory.eINSTANCE.createMessage();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("messageType"), proxy); copyLocalizationInfos((CommonToken) a10, element); copyLocalizationInfos((CommonToken) a10, proxy); }

			|
			'fromPart'
			':'
			a11 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a11.getText(),element.eClass().getEStructuralFeature("fromPart"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a11,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;FromPart proxy = BPELFactory.eINSTANCE.createFromPart();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("fromPart"))).add(proxy); copyLocalizationInfos((CommonToken) a11, element); copyLocalizationInfos((CommonToken) a11, proxy); }

			|
			'correlationSets'
			':'
			a12 = correlationsets{element.eSet(element.eClass().getEStructuralFeature("correlationSets"), a12); copyLocalizationInfos(a12, element); }
		)
	)*
	'}'
;

keywordimport returns [Import element = null]
@init{
	element = BPELFactory.eINSTANCE.createImport();
}
:
	'Import'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'namespace'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("namespace"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("namespace"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'location'
			':'
			a5 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("location"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("location"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'importType'
			':'
			a6 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("importType"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a6,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("importType"), resolved); copyLocalizationInfos((CommonToken) a6, element); }
		)
	)*
	'}'
;

rethrow returns [Rethrow element = null]
@init{
	element = BPELFactory.eINSTANCE.createRethrow();
}
:
	'Rethrow'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }
		)
	)*
	'}'
;

condition returns [Condition element = null]
@init{
	element = BPELFactory.eINSTANCE.createCondition();
}
:
	(
		a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("required"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("required"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
	)?
	'Condition'
	'{'
	(
		(
			'documentationElement'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'element'
			':'
			a2 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a2, element); }

			|
			'elementType'
			':'
			a3 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("elementType"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());javax.xml.namespace.QName resolved = (javax.xml.namespace.QName)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("elementType"), resolved); copyLocalizationInfos((CommonToken) a3, element); }

			|
			'body'
			':'
			a4 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("body"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.Object resolved = (java.lang.Object)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("body"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'expressionLanguage'
			':'
			a5 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("expressionLanguage"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("expressionLanguage"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'opaque'
			':'
			a6 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("opaque"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a6,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("opaque"), resolved); copyLocalizationInfos((CommonToken) a6, element); }
		)
	)*
	'}'
;

targets returns [Targets element = null]
@init{
	element = BPELFactory.eINSTANCE.createTargets();
}
:
	'Targets'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'children'
			':'
			a4 = target{((List) element.eGet(element.eClass().getEStructuralFeature("children"))).add(a4); copyLocalizationInfos(a4, element); }

			|
			'joinCondition'
			':'
			a5 = condition{element.eSet(element.eClass().getEStructuralFeature("joinCondition"), a5); copyLocalizationInfos(a5, element); }
		)
	)*
	'}'
;

sources returns [Sources element = null]
@init{
	element = BPELFactory.eINSTANCE.createSources();
}
:
	'Sources'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'children'
			':'
			a4 = source{((List) element.eGet(element.eClass().getEStructuralFeature("children"))).add(a4); copyLocalizationInfos(a4, element); }
		)
	)*
	'}'
;

query returns [Query element = null]
@init{
	element = BPELFactory.eINSTANCE.createQuery();
}
:
	'Query'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'value'
			':'
			a2 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a2, element); }

			|
			'queryLanguage'
			':'
			a3 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("queryLanguage"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("queryLanguage"), resolved); copyLocalizationInfos((CommonToken) a3, element); }
		)
	)*
	'}'
;

serviceref returns [ServiceRef element = null]
@init{
	element = BPELFactory.eINSTANCE.createServiceRef();
}
:
	'ServiceRef'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'referenceScheme'
			':'
			a3 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("referenceScheme"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("referenceScheme"), resolved); copyLocalizationInfos((CommonToken) a3, element); }

			|
			'value'
			':'
			a4 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.Object resolved = (java.lang.Object)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a4, element); }
		)
	)*
	'}'
;

extensions returns [Extensions element = null]
@init{
	element = BPELFactory.eINSTANCE.createExtensions();
}
:
	'Extensions'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'children'
			':'
			a4 = extension{((List) element.eGet(element.eClass().getEStructuralFeature("children"))).add(a4); copyLocalizationInfos(a4, element); }
		)
	)*
	'}'
;

extensionactivity returns [ExtensionActivity element = null]
@init{
	element = BPELFactory.eINSTANCE.createExtensionActivity();
}
:
	'ExtensionActivity'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }
		)
	)*
	'}'
;

frompart returns [FromPart element = null]
@init{
	element = BPELFactory.eINSTANCE.createFromPart();
}
:
	'FromPart'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'part'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("part"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("part"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'to'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("to"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;To proxy = BPELFactory.eINSTANCE.createTo();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("to"), proxy); copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); }
		)
	)*
	'}'
;

topart returns [ToPart element = null]
@init{
	element = BPELFactory.eINSTANCE.createToPart();
}
:
	'ToPart'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'part'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("part"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("part"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'from'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("from"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;From proxy = BPELFactory.eINSTANCE.createFrom();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("from"), proxy); copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); }
		)
	)*
	'}'
;

opaqueactivity returns [OpaqueActivity element = null]
@init{
	element = BPELFactory.eINSTANCE.createOpaqueActivity();
}
:
	'OpaqueActivity'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }
		)
	)*
	'}'
;

foreach returns [ForEach element = null]
@init{
	element = BPELFactory.eINSTANCE.createForEach();
}
:
	'ForEach'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }

			|
			'startCounterValue'
			':'
			a8 = expression{element.eSet(element.eClass().getEStructuralFeature("startCounterValue"), a8); copyLocalizationInfos(a8, element); }

			|
			'finalCounterValue'
			':'
			a9 = expression{element.eSet(element.eClass().getEStructuralFeature("finalCounterValue"), a9); copyLocalizationInfos(a9, element); }

			|
			'parallel'
			':'
			a10 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a10.getText(),element.eClass().getEStructuralFeature("parallel"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a10,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("parallel"), resolved); copyLocalizationInfos((CommonToken) a10, element); }

			|
			'counterName'
			':'
			a11 = variable{element.eSet(element.eClass().getEStructuralFeature("counterName"), a11); copyLocalizationInfos(a11, element); }

			|
			'completionCondition'
			':'
			a12 = completioncondition{element.eSet(element.eClass().getEStructuralFeature("completionCondition"), a12); copyLocalizationInfos(a12, element); }

			|
			'activity'
			':'
			a13 = activity{element.eSet(element.eClass().getEStructuralFeature("activity"), a13); copyLocalizationInfos(a13, element); }
		)
	)*
	'}'
;

repeatuntil returns [RepeatUntil element = null]
@init{
	element = BPELFactory.eINSTANCE.createRepeatUntil();
}
:
	'RepeatUntil'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }

			|
			'activity'
			':'
			a8 = activity{element.eSet(element.eClass().getEStructuralFeature("activity"), a8); copyLocalizationInfos(a8, element); }

			|
			'condition'
			':'
			a9 = condition{element.eSet(element.eClass().getEStructuralFeature("condition"), a9); copyLocalizationInfos(a9, element); }
		)
	)*
	'}'
;

terminationhandler returns [TerminationHandler element = null]
@init{
	element = BPELFactory.eINSTANCE.createTerminationHandler();
}
:
	'TerminationHandler'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'activity'
			':'
			a4 = activity{element.eSet(element.eClass().getEStructuralFeature("activity"), a4); copyLocalizationInfos(a4, element); }
		)
	)*
	'}'
;

validate returns [Validate element = null]
@init{
	element = BPELFactory.eINSTANCE.createValidate();
}
:
	'Validate'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }

			|
			'variables'
			':'
			a8 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a8.getText(),element.eClass().getEStructuralFeature("variables"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a8,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Variable proxy = BPELFactory.eINSTANCE.createVariable();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("variables"))).add(proxy); copyLocalizationInfos((CommonToken) a8, element); copyLocalizationInfos((CommonToken) a8, proxy); }
		)
	)*
	'}'
;

keywordif returns [If element = null]
@init{
	element = BPELFactory.eINSTANCE.createIf();
}
:
	'If'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }

			|
			'condition'
			':'
			a8 = condition{element.eSet(element.eClass().getEStructuralFeature("condition"), a8); copyLocalizationInfos(a8, element); }

			|
			'elseIf'
			':'
			a9 = elseif{((List) element.eGet(element.eClass().getEStructuralFeature("elseIf"))).add(a9); copyLocalizationInfos(a9, element); }

			|
			'else'
			':'
			a10 = keywordelse{element.eSet(element.eClass().getEStructuralFeature("else"), a10); copyLocalizationInfos(a10, element); }

			|
			'activity'
			':'
			a11 = activity{element.eSet(element.eClass().getEStructuralFeature("activity"), a11); copyLocalizationInfos(a11, element); }
		)
	)*
	'}'
;

elseif returns [ElseIf element = null]
@init{
	element = BPELFactory.eINSTANCE.createElseIf();
}
:
	'ElseIf'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'condition'
			':'
			a4 = condition{element.eSet(element.eClass().getEStructuralFeature("condition"), a4); copyLocalizationInfos(a4, element); }

			|
			'activity'
			':'
			a5 = activity{element.eSet(element.eClass().getEStructuralFeature("activity"), a5); copyLocalizationInfos(a5, element); }
		)
	)*
	'}'
;

keywordelse returns [Else element = null]
@init{
	element = BPELFactory.eINSTANCE.createElse();
}
:
	'Else'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'activity'
			':'
			a4 = activity{element.eSet(element.eClass().getEStructuralFeature("activity"), a4); copyLocalizationInfos(a4, element); }
		)
	)*
	'}'
;

completioncondition returns [CompletionCondition element = null]
@init{
	element = BPELFactory.eINSTANCE.createCompletionCondition();
}
:
	'CompletionCondition'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'branches'
			':'
			a4 = branches{element.eSet(element.eClass().getEStructuralFeature("branches"), a4); copyLocalizationInfos(a4, element); }
		)
	)*
	'}'
;

branches returns [Branches element = null]
@init{
	element = BPELFactory.eINSTANCE.createBranches();
}
:
	(
		a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("required"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("required"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
	)?
	'Branches'
	'{'
	(
		(
			'documentationElement'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'element'
			':'
			a2 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a2, element); }

			|
			'elementType'
			':'
			a3 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("elementType"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());javax.xml.namespace.QName resolved = (javax.xml.namespace.QName)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("elementType"), resolved); copyLocalizationInfos((CommonToken) a3, element); }

			|
			'body'
			':'
			a4 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("body"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.Object resolved = (java.lang.Object)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("body"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'expressionLanguage'
			':'
			a5 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("expressionLanguage"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("expressionLanguage"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'opaque'
			':'
			a6 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("opaque"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a6,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("opaque"), resolved); copyLocalizationInfos((CommonToken) a6, element); }

			|
			'countCompletedBranchesOnly'
			':'
			a7 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a7.getText(),element.eClass().getEStructuralFeature("countCompletedBranchesOnly"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a7,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("countCompletedBranchesOnly"), resolved); copyLocalizationInfos((CommonToken) a7, element); }
		)
	)*
	'}'
;

extensibleelement returns [ExtensibleElement element = null]
@init{
	element = BPELFactory.eINSTANCE.createExtensibleElement();
}
:
	'ExtensibleElement'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }
		)
	)*
	'}'
	|//derived choice rules for sub-classes: 
	c0 = process{ element = c0; }	|
	c1 = partnerlink{ element = c1; }	|
	c2 = faulthandler{ element = c2; }	|
	c3 = activity{ element = c3; }	|
	c4 = correlationset{ element = c4; }	|
	c5 = invoke{ element = c5; }	|
	c6 = link{ element = c6; }	|
	c7 = keywordcatch{ element = c7; }	|
	c8 = reply{ element = c8; }	|
	c9 = partneractivity{ element = c9; }	|
	c10 = receive{ element = c10; }	|
	c11 = exit{ element = c11; }	|
	c12 = keywordthrow{ element = c12; }	|
	c13 = wait{ element = c13; }	|
	c14 = empty{ element = c14; }	|
	c15 = sequence{ element = c15; }	|
	c16 = keywordwhile{ element = c16; }	|
	c17 = pick{ element = c17; }	|
	c18 = flow{ element = c18; }	|
	c19 = onalarm{ element = c19; }	|
	c20 = assign{ element = c20; }	|
	c21 = copy{ element = c21; }	|
	c22 = extension{ element = c22; }	|
	c23 = scope{ element = c23; }	|
	c24 = compensatescope{ element = c24; }	|
	c25 = compensationhandler{ element = c25; }	|
	c26 = to{ element = c26; }	|
	c27 = from{ element = c27; }	|
	c28 = onmessage{ element = c28; }	|
	c29 = correlation{ element = c29; }	|
	c30 = eventhandler{ element = c30; }	|
	c31 = source{ element = c31; }	|
	c32 = target{ element = c32; }	|
	c33 = partnerlinks{ element = c33; }	|
	c34 = variables{ element = c34; }	|
	c35 = correlationsets{ element = c35; }	|
	c36 = links{ element = c36; }	|
	c37 = catchall{ element = c37; }	|
	c38 = correlations{ element = c38; }	|
	c39 = variable{ element = c39; }	|
	c40 = onevent{ element = c40; }	|
	c41 = keywordimport{ element = c41; }	|
	c42 = rethrow{ element = c42; }	|
	c43 = targets{ element = c43; }	|
	c44 = sources{ element = c44; }	|
	c45 = extensions{ element = c45; }	|
	c46 = extensionactivity{ element = c46; }	|
	c47 = frompart{ element = c47; }	|
	c48 = topart{ element = c48; }	|
	c49 = opaqueactivity{ element = c49; }	|
	c50 = foreach{ element = c50; }	|
	c51 = repeatuntil{ element = c51; }	|
	c52 = terminationhandler{ element = c52; }	|
	c53 = validate{ element = c53; }	|
	c54 = keywordif{ element = c54; }	|
	c55 = elseif{ element = c55; }	|
	c56 = keywordelse{ element = c56; }	|
	c57 = completioncondition{ element = c57; }	|
	c58 = messageexchanges{ element = c58; }	|
	c59 = messageexchange{ element = c59; }	|
	c60 = compensate{ element = c60; }
;

documentation returns [Documentation element = null]
@init{
	element = BPELFactory.eINSTANCE.createDocumentation();
}
:
	'Documentation'
	'{'
	(
		(
			'lang'
			':'
			a0 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("lang"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("lang"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'source'
			':'
			a1 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("source"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("source"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'value'
			':'
			a2 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a2, element); }
		)
	)*
	'}'
;

messageexchanges returns [MessageExchanges element = null]
@init{
	element = BPELFactory.eINSTANCE.createMessageExchanges();
}
:
	'MessageExchanges'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'children'
			':'
			a4 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("children"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;MessageExchange proxy = BPELFactory.eINSTANCE.createMessageExchange();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("children"))).add(proxy); copyLocalizationInfos((CommonToken) a4, element); copyLocalizationInfos((CommonToken) a4, proxy); }
		)
	)*
	'}'
;

messageexchange returns [MessageExchange element = null]
@init{
	element = BPELFactory.eINSTANCE.createMessageExchange();
}
:
	'MessageExchange'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }
		)
	)*
	'}'
;

compensate returns [Compensate element = null]
@init{
	element = BPELFactory.eINSTANCE.createCompensate();
}
:
	'Compensate'
	'{'
	(
		(
			'documentationElement'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("documentationElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("documentationElement"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'element'
			':'
			a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("element"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());org.w3c.dom.Element resolved = (org.w3c.dom.Element)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("element"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'eExtensibilityElements'
			':'
			a2 = extensibilityelement{((List) element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"))).add(a2); copyLocalizationInfos(a2, element); }

			|
			'documentation'
			':'
			a3 = documentation{element.eSet(element.eClass().getEStructuralFeature("documentation"), a3); copyLocalizationInfos(a3, element); }

			|
			'name'
			':'
			a4 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a4, element); }

			|
			'suppressJoinFailure'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("suppressJoinFailure"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suppressJoinFailure"), resolved); copyLocalizationInfos((CommonToken) a5, element); }

			|
			'targets'
			':'
			a6 = targets{element.eSet(element.eClass().getEStructuralFeature("targets"), a6); copyLocalizationInfos(a6, element); }

			|
			'sources'
			':'
			a7 = sources{element.eSet(element.eClass().getEStructuralFeature("sources"), a7); copyLocalizationInfos(a7, element); }
		)
	)*
	'}'
;

extensibilityelement
returns [ExtensibilityElement element = null]
:
	c0 = expression{ element = c0; }	|
	c1 = booleanexpression{ element = c1; }	|
	c2 = unknownextensibilityattribute{ element = c2; }	|
	c3 = condition{ element = c3; }	|
	c4 = branches{ element = c4; }
;

unknownextensibilityelement
returns [UnknownExtensibilityElement element = null]
:
	c0 = unknownextensibilityattribute{ element = c0; }
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
