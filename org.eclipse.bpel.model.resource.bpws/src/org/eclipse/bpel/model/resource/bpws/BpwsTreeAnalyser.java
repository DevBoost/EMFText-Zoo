package org.eclipse.bpel.model.resource.bpws; 

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.reuseware.emftextedit.runtime.resource.TextResource;
import org.reuseware.emftextedit.runtime.resource.impl.*;

import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.To;
import org.eclipse.bpel.model.ToPart;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.Source;
import org.eclipse.bpel.model.PartnerActivity;
import org.eclipse.bpel.model.Receive;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.Link;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Target;
import org.eclipse.bpel.model.Catch;
import org.eclipse.bpel.model.Reply;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.CompensateScope;
import org.eclipse.bpel.model.Correlation;
import org.eclipse.bpel.model.FromPart;
import org.eclipse.bpel.model.Throw;
import org.eclipse.bpel.model.MessageExchanges;
import org.eclipse.bpel.model.Validate;
import org.eclipse.bpel.model.resource.bpws.analysis.*;

public class BpwsTreeAnalyser extends EMFTextTreeAnalyserImpl {

	protected OnEventPartnerLinkProxyResolver onEventPartnerLinkProxyResolver = new OnEventPartnerLinkProxyResolver();

	protected FromVariableProxyResolver fromVariableProxyResolver = new FromVariableProxyResolver();

	protected ToPartProxyResolver toPartProxyResolver = new ToPartProxyResolver();

	protected ToPropertyProxyResolver toPropertyProxyResolver = new ToPropertyProxyResolver();

	protected OnEventPortTypeProxyResolver onEventPortTypeProxyResolver = new OnEventPortTypeProxyResolver();

	protected ToPartFromProxyResolver toPartFromProxyResolver = new ToPartFromProxyResolver();

	protected PartnerLinkPartnerRoleProxyResolver partnerLinkPartnerRoleProxyResolver = new PartnerLinkPartnerRoleProxyResolver();

	protected CorrelationSetPropertiesProxyResolver correlationSetPropertiesProxyResolver = new CorrelationSetPropertiesProxyResolver();

	protected SourceLinkProxyResolver sourceLinkProxyResolver = new SourceLinkProxyResolver();

	protected PartnerActivityPartnerLinkProxyResolver partnerActivityPartnerLinkProxyResolver = new PartnerActivityPartnerLinkProxyResolver();

	protected ReceiveFromPartProxyResolver receiveFromPartProxyResolver = new ReceiveFromPartProxyResolver();

	protected InvokeInputVariableProxyResolver invokeInputVariableProxyResolver = new InvokeInputVariableProxyResolver();

	protected PartnerLinkPartnerLinkTypeProxyResolver partnerLinkPartnerLinkTypeProxyResolver = new PartnerLinkPartnerLinkTypeProxyResolver();

	protected ScopeMessageExchangesProxyResolver scopeMessageExchangesProxyResolver = new ScopeMessageExchangesProxyResolver();

	protected OnMessageFromPartProxyResolver onMessageFromPartProxyResolver = new OnMessageFromPartProxyResolver();

	protected OnMessagePartnerLinkProxyResolver onMessagePartnerLinkProxyResolver = new OnMessagePartnerLinkProxyResolver();

	protected LinkTargetsProxyResolver linkTargetsProxyResolver = new LinkTargetsProxyResolver();

	protected VariableMessageTypeProxyResolver variableMessageTypeProxyResolver = new VariableMessageTypeProxyResolver();

	protected TargetLinkProxyResolver targetLinkProxyResolver = new TargetLinkProxyResolver();

	protected InvokeToPartProxyResolver invokeToPartProxyResolver = new InvokeToPartProxyResolver();

	protected CatchFaultElementProxyResolver catchFaultElementProxyResolver = new CatchFaultElementProxyResolver();

	protected ReplyVariableProxyResolver replyVariableProxyResolver = new ReplyVariableProxyResolver();

	protected OnEventFromPartProxyResolver onEventFromPartProxyResolver = new OnEventFromPartProxyResolver();

	protected PartnerActivityPortTypeProxyResolver partnerActivityPortTypeProxyResolver = new PartnerActivityPortTypeProxyResolver();

	protected ProcessMessageExchangesProxyResolver processMessageExchangesProxyResolver = new ProcessMessageExchangesProxyResolver();

	protected InvokeOutputVariableProxyResolver invokeOutputVariableProxyResolver = new InvokeOutputVariableProxyResolver();

	protected CompensateScopeTargetProxyResolver compensateScopeTargetProxyResolver = new CompensateScopeTargetProxyResolver();

	protected OnMessagePortTypeProxyResolver onMessagePortTypeProxyResolver = new OnMessagePortTypeProxyResolver();

	protected CorrelationSetProxyResolver correlationSetProxyResolver = new CorrelationSetProxyResolver();

	protected SourceActivityProxyResolver sourceActivityProxyResolver = new SourceActivityProxyResolver();

	protected FromPartToProxyResolver fromPartToProxyResolver = new FromPartToProxyResolver();

	protected ThrowFaultVariableProxyResolver throwFaultVariableProxyResolver = new ThrowFaultVariableProxyResolver();

	protected FromPartProxyResolver fromPartProxyResolver = new FromPartProxyResolver();

	protected FromPartnerLinkProxyResolver fromPartnerLinkProxyResolver = new FromPartnerLinkProxyResolver();

	protected OnMessageVariableProxyResolver onMessageVariableProxyResolver = new OnMessageVariableProxyResolver();

	protected MessageExchangesChildrenProxyResolver messageExchangesChildrenProxyResolver = new MessageExchangesChildrenProxyResolver();

	protected TargetActivityProxyResolver targetActivityProxyResolver = new TargetActivityProxyResolver();

	protected OnEventOperationProxyResolver onEventOperationProxyResolver = new OnEventOperationProxyResolver();

	protected ValidateVariablesProxyResolver validateVariablesProxyResolver = new ValidateVariablesProxyResolver();

	protected OnMessageOperationProxyResolver onMessageOperationProxyResolver = new OnMessageOperationProxyResolver();

	protected ToPartnerLinkProxyResolver toPartnerLinkProxyResolver = new ToPartnerLinkProxyResolver();

	protected PartnerActivityOperationProxyResolver partnerActivityOperationProxyResolver = new PartnerActivityOperationProxyResolver();

	protected LinkSourcesProxyResolver linkSourcesProxyResolver = new LinkSourcesProxyResolver();

	protected FromPropertyProxyResolver fromPropertyProxyResolver = new FromPropertyProxyResolver();

	protected OnEventMessageTypeProxyResolver onEventMessageTypeProxyResolver = new OnEventMessageTypeProxyResolver();

	protected VariableXSDElementProxyResolver variableXSDElementProxyResolver = new VariableXSDElementProxyResolver();

	protected FromTypeProxyResolver fromTypeProxyResolver = new FromTypeProxyResolver();

	protected ToVariableProxyResolver toVariableProxyResolver = new ToVariableProxyResolver();

	protected PartnerLinkMyRoleProxyResolver partnerLinkMyRoleProxyResolver = new PartnerLinkMyRoleProxyResolver();

	protected VariableTypeProxyResolver variableTypeProxyResolver = new VariableTypeProxyResolver();

	protected ReceiveVariableProxyResolver receiveVariableProxyResolver = new ReceiveVariableProxyResolver();

	protected ReplyToPartProxyResolver replyToPartProxyResolver = new ReplyToPartProxyResolver();

	protected InvokeFromPartProxyResolver invokeFromPartProxyResolver = new InvokeFromPartProxyResolver();

	protected CatchFaultMessageTypeProxyResolver catchFaultMessageTypeProxyResolver = new CatchFaultMessageTypeProxyResolver();

	public EObject resolve(InternalEObject proxy, EObject container, EReference reference, TextResource resource, boolean reportErrors) {
		if (container instanceof OnEvent && reference.getFeatureID() == 6) {
			return onEventPartnerLinkProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof From && reference.getFeatureID() == 11) {
			return fromVariableProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof To && reference.getFeatureID() == 5) {
			return toPartProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof To && reference.getFeatureID() == 7) {
			return toPropertyProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof OnEvent && reference.getFeatureID() == 9) {
			return onEventPortTypeProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof ToPart && reference.getFeatureID() == 5) {
			return toPartFromProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof PartnerLink && reference.getFeatureID() == 6) {
			return partnerLinkPartnerRoleProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof CorrelationSet && reference.getFeatureID() == 5) {
			return correlationSetPropertiesProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Source && reference.getFeatureID() == 4) {
			return sourceLinkProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof PartnerActivity && reference.getFeatureID() == 8) {
			return partnerActivityPartnerLinkProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Receive && reference.getFeatureID() == 14) {
			return receiveFromPartProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Invoke && reference.getFeatureID() == 13) {
			return invokeInputVariableProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof PartnerLink && reference.getFeatureID() == 7) {
			return partnerLinkPartnerLinkTypeProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Scope && reference.getFeatureID() == 17) {
			return scopeMessageExchangesProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof OnMessage && reference.getFeatureID() == 10) {
			return onMessageFromPartProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof OnMessage && reference.getFeatureID() == 7) {
			return onMessagePartnerLinkProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Link && reference.getFeatureID() == 6) {
			return linkTargetsProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Variable && reference.getFeatureID() == 5) {
			return variableMessageTypeProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Target && reference.getFeatureID() == 4) {
			return targetLinkProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Invoke && reference.getFeatureID() == 16) {
			return invokeToPartProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Catch && reference.getFeatureID() == 8) {
			return catchFaultElementProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Reply && reference.getFeatureID() == 13) {
			return replyVariableProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof OnEvent && reference.getFeatureID() == 11) {
			return onEventFromPartProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof PartnerActivity && reference.getFeatureID() == 10) {
			return partnerActivityPortTypeProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Process && reference.getFeatureID() == 19) {
			return processMessageExchangesProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Invoke && reference.getFeatureID() == 12) {
			return invokeOutputVariableProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof CompensateScope && reference.getFeatureID() == 8) {
			return compensateScopeTargetProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof OnMessage && reference.getFeatureID() == 6) {
			return onMessagePortTypeProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Correlation && reference.getFeatureID() == 6) {
			return correlationSetProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Source && reference.getFeatureID() == 5) {
			return sourceActivityProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof FromPart && reference.getFeatureID() == 5) {
			return fromPartToProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Throw && reference.getFeatureID() == 9) {
			return throwFaultVariableProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof From && reference.getFeatureID() == 12) {
			return fromPartProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof From && reference.getFeatureID() == 13) {
			return fromPartnerLinkProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof OnMessage && reference.getFeatureID() == 4) {
			return onMessageVariableProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof MessageExchanges && reference.getFeatureID() == 4) {
			return messageExchangesChildrenProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Target && reference.getFeatureID() == 5) {
			return targetActivityProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof OnEvent && reference.getFeatureID() == 8) {
			return onEventOperationProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Validate && reference.getFeatureID() == 8) {
			return validateVariablesProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof OnMessage && reference.getFeatureID() == 9) {
			return onMessageOperationProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof To && reference.getFeatureID() == 6) {
			return toPartnerLinkProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof PartnerActivity && reference.getFeatureID() == 11) {
			return partnerActivityOperationProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Link && reference.getFeatureID() == 5) {
			return linkSourcesProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof From && reference.getFeatureID() == 14) {
			return fromPropertyProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof OnEvent && reference.getFeatureID() == 10) {
			return onEventMessageTypeProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Variable && reference.getFeatureID() == 6) {
			return variableXSDElementProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof From && reference.getFeatureID() == 10) {
			return fromTypeProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof To && reference.getFeatureID() == 4) {
			return toVariableProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof PartnerLink && reference.getFeatureID() == 5) {
			return partnerLinkMyRoleProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Variable && reference.getFeatureID() == 7) {
			return variableTypeProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Receive && reference.getFeatureID() == 13) {
			return receiveVariableProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Reply && reference.getFeatureID() == 14) {
			return replyToPartProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Invoke && reference.getFeatureID() == 17) {
			return invokeFromPartProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Catch && reference.getFeatureID() == 7) {
			return catchFaultMessageTypeProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		return null;
	}

	public String deResolve(EObject refObject, EObject container, EReference reference) {
		if (container instanceof OnEvent && reference.getFeatureID() == 6) {
			return onEventPartnerLinkProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof From && reference.getFeatureID() == 11) {
			return fromVariableProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof To && reference.getFeatureID() == 5) {
			return toPartProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof To && reference.getFeatureID() == 7) {
			return toPropertyProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof OnEvent && reference.getFeatureID() == 9) {
			return onEventPortTypeProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof ToPart && reference.getFeatureID() == 5) {
			return toPartFromProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof PartnerLink && reference.getFeatureID() == 6) {
			return partnerLinkPartnerRoleProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof CorrelationSet && reference.getFeatureID() == 5) {
			return correlationSetPropertiesProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Source && reference.getFeatureID() == 4) {
			return sourceLinkProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof PartnerActivity && reference.getFeatureID() == 8) {
			return partnerActivityPartnerLinkProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Receive && reference.getFeatureID() == 14) {
			return receiveFromPartProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Invoke && reference.getFeatureID() == 13) {
			return invokeInputVariableProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof PartnerLink && reference.getFeatureID() == 7) {
			return partnerLinkPartnerLinkTypeProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Scope && reference.getFeatureID() == 17) {
			return scopeMessageExchangesProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof OnMessage && reference.getFeatureID() == 10) {
			return onMessageFromPartProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof OnMessage && reference.getFeatureID() == 7) {
			return onMessagePartnerLinkProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Link && reference.getFeatureID() == 6) {
			return linkTargetsProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Variable && reference.getFeatureID() == 5) {
			return variableMessageTypeProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Target && reference.getFeatureID() == 4) {
			return targetLinkProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Invoke && reference.getFeatureID() == 16) {
			return invokeToPartProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Catch && reference.getFeatureID() == 8) {
			return catchFaultElementProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Reply && reference.getFeatureID() == 13) {
			return replyVariableProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof OnEvent && reference.getFeatureID() == 11) {
			return onEventFromPartProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof PartnerActivity && reference.getFeatureID() == 10) {
			return partnerActivityPortTypeProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Process && reference.getFeatureID() == 19) {
			return processMessageExchangesProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Invoke && reference.getFeatureID() == 12) {
			return invokeOutputVariableProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof CompensateScope && reference.getFeatureID() == 8) {
			return compensateScopeTargetProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof OnMessage && reference.getFeatureID() == 6) {
			return onMessagePortTypeProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Correlation && reference.getFeatureID() == 6) {
			return correlationSetProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Source && reference.getFeatureID() == 5) {
			return sourceActivityProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof FromPart && reference.getFeatureID() == 5) {
			return fromPartToProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Throw && reference.getFeatureID() == 9) {
			return throwFaultVariableProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof From && reference.getFeatureID() == 12) {
			return fromPartProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof From && reference.getFeatureID() == 13) {
			return fromPartnerLinkProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof OnMessage && reference.getFeatureID() == 4) {
			return onMessageVariableProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof MessageExchanges && reference.getFeatureID() == 4) {
			return messageExchangesChildrenProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Target && reference.getFeatureID() == 5) {
			return targetActivityProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof OnEvent && reference.getFeatureID() == 8) {
			return onEventOperationProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Validate && reference.getFeatureID() == 8) {
			return validateVariablesProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof OnMessage && reference.getFeatureID() == 9) {
			return onMessageOperationProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof To && reference.getFeatureID() == 6) {
			return toPartnerLinkProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof PartnerActivity && reference.getFeatureID() == 11) {
			return partnerActivityOperationProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Link && reference.getFeatureID() == 5) {
			return linkSourcesProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof From && reference.getFeatureID() == 14) {
			return fromPropertyProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof OnEvent && reference.getFeatureID() == 10) {
			return onEventMessageTypeProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Variable && reference.getFeatureID() == 6) {
			return variableXSDElementProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof From && reference.getFeatureID() == 10) {
			return fromTypeProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof To && reference.getFeatureID() == 4) {
			return toVariableProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof PartnerLink && reference.getFeatureID() == 5) {
			return partnerLinkMyRoleProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Variable && reference.getFeatureID() == 7) {
			return variableTypeProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Receive && reference.getFeatureID() == 13) {
			return receiveVariableProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Reply && reference.getFeatureID() == 14) {
			return replyToPartProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Invoke && reference.getFeatureID() == 17) {
			return invokeFromPartProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Catch && reference.getFeatureID() == 7) {
			return catchFaultMessageTypeProxyResolver.deResolve(refObject,container,reference);
		}
		return null;
	}

	public void setOptions(java.util.Map<?, ?> options) {
		onEventPartnerLinkProxyResolver.setOptions(options);
		fromVariableProxyResolver.setOptions(options);
		toPartProxyResolver.setOptions(options);
		toPropertyProxyResolver.setOptions(options);
		onEventPortTypeProxyResolver.setOptions(options);
		toPartFromProxyResolver.setOptions(options);
		partnerLinkPartnerRoleProxyResolver.setOptions(options);
		correlationSetPropertiesProxyResolver.setOptions(options);
		sourceLinkProxyResolver.setOptions(options);
		partnerActivityPartnerLinkProxyResolver.setOptions(options);
		receiveFromPartProxyResolver.setOptions(options);
		invokeInputVariableProxyResolver.setOptions(options);
		partnerLinkPartnerLinkTypeProxyResolver.setOptions(options);
		scopeMessageExchangesProxyResolver.setOptions(options);
		onMessageFromPartProxyResolver.setOptions(options);
		onMessagePartnerLinkProxyResolver.setOptions(options);
		linkTargetsProxyResolver.setOptions(options);
		variableMessageTypeProxyResolver.setOptions(options);
		targetLinkProxyResolver.setOptions(options);
		invokeToPartProxyResolver.setOptions(options);
		catchFaultElementProxyResolver.setOptions(options);
		replyVariableProxyResolver.setOptions(options);
		onEventFromPartProxyResolver.setOptions(options);
		partnerActivityPortTypeProxyResolver.setOptions(options);
		processMessageExchangesProxyResolver.setOptions(options);
		invokeOutputVariableProxyResolver.setOptions(options);
		compensateScopeTargetProxyResolver.setOptions(options);
		onMessagePortTypeProxyResolver.setOptions(options);
		correlationSetProxyResolver.setOptions(options);
		sourceActivityProxyResolver.setOptions(options);
		fromPartToProxyResolver.setOptions(options);
		throwFaultVariableProxyResolver.setOptions(options);
		fromPartProxyResolver.setOptions(options);
		fromPartnerLinkProxyResolver.setOptions(options);
		onMessageVariableProxyResolver.setOptions(options);
		messageExchangesChildrenProxyResolver.setOptions(options);
		targetActivityProxyResolver.setOptions(options);
		onEventOperationProxyResolver.setOptions(options);
		validateVariablesProxyResolver.setOptions(options);
		onMessageOperationProxyResolver.setOptions(options);
		toPartnerLinkProxyResolver.setOptions(options);
		partnerActivityOperationProxyResolver.setOptions(options);
		linkSourcesProxyResolver.setOptions(options);
		fromPropertyProxyResolver.setOptions(options);
		onEventMessageTypeProxyResolver.setOptions(options);
		variableXSDElementProxyResolver.setOptions(options);
		fromTypeProxyResolver.setOptions(options);
		toVariableProxyResolver.setOptions(options);
		partnerLinkMyRoleProxyResolver.setOptions(options);
		variableTypeProxyResolver.setOptions(options);
		receiveVariableProxyResolver.setOptions(options);
		replyToPartProxyResolver.setOptions(options);
		invokeFromPartProxyResolver.setOptions(options);
		catchFaultMessageTypeProxyResolver.setOptions(options);
	}
}
