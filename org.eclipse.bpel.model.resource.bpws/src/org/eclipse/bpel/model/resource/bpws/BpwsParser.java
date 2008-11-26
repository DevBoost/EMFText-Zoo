// $ANTLR 3.0.1 C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g 2008-11-25 17:28:19

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BpwsParser extends EMFTextParserImpl {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "INTEGER", "FLOAT", "LB", "WS", "'Process'"
    };
    public static final int INTEGER=5;
    public static final int WS=8;
    public static final int LB=7;
    public static final int FLOAT=6;
    public static final int COMMENT=4;
    public static final int EOF=-1;

        public BpwsParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g"; }


    	private TokenResolverFactory tokenResolverFactory = new BpwsTokenResolverFactory();

    	protected EObject doParse() throws RecognitionException {
    		((BpwsLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((BpwsLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		return start();
    	}



    // $ANTLR start start
    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:449:1: start returns [ EObject element = null] : c0= process ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        Process c0 = null;


        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:451:1: (c0= process )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:452:1: c0= process
            {
            pushFollow(FOLLOW_process_in_start61);
            c0=process();
            _fsp--;

             element = c0; 

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


    // $ANTLR start process
    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:456:1: process returns [Process element = null] : 'Process' ;
    public final Process process() throws RecognitionException {
        Process element =  null;


        	element = BPELFactory.eINSTANCE.createProcess();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:460:1: ( 'Process' )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:461:2: 'Process'
            {
            match(input,9,FOLLOW_9_in_process81); 

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
    // $ANTLR end process


 

    public static final BitSet FOLLOW_process_in_start61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_process81 = new BitSet(new long[]{0x0000000000000002L});

}