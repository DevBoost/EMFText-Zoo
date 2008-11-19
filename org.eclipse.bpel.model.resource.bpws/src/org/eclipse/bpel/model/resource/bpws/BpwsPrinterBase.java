package org.eclipse.bpel.model.resource.bpws;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.Link;
import org.eclipse.bpel.model.Catch;
import org.eclipse.bpel.model.Reply;
import org.eclipse.bpel.model.PartnerActivity;
import org.eclipse.bpel.model.Receive;
import org.eclipse.bpel.model.Exit;
import org.eclipse.bpel.model.Throw;
import org.eclipse.bpel.model.Wait;
import org.eclipse.bpel.model.Empty;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.model.While;
import org.eclipse.bpel.model.Pick;
import org.eclipse.bpel.model.Flow;
import org.eclipse.bpel.model.OnAlarm;
import org.eclipse.bpel.model.Assign;
import org.eclipse.bpel.model.Copy;
import org.eclipse.bpel.model.Extension;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.CompensateScope;
import org.eclipse.bpel.model.CompensationHandler;
import org.eclipse.bpel.model.To;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.BooleanExpression;
import org.eclipse.bpel.model.Correlation;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.Source;
import org.eclipse.bpel.model.Target;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.model.CorrelationSets;
import org.eclipse.bpel.model.Links;
import org.eclipse.bpel.model.CatchAll;
import org.eclipse.bpel.model.Correlations;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.UnknownExtensibilityAttribute;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Rethrow;
import org.eclipse.bpel.model.Condition;
import org.eclipse.bpel.model.Targets;
import org.eclipse.bpel.model.Sources;
import org.eclipse.bpel.model.Query;
import org.eclipse.bpel.model.ServiceRef;
import org.eclipse.bpel.model.Extensions;
import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.FromPart;
import org.eclipse.bpel.model.ToPart;
import org.eclipse.bpel.model.OpaqueActivity;
import org.eclipse.bpel.model.ForEach;
import org.eclipse.bpel.model.RepeatUntil;
import org.eclipse.bpel.model.TerminationHandler;
import org.eclipse.bpel.model.Validate;
import org.eclipse.bpel.model.If;
import org.eclipse.bpel.model.ElseIf;
import org.eclipse.bpel.model.Else;
import org.eclipse.bpel.model.CompletionCondition;
import org.eclipse.bpel.model.Branches;
import org.eclipse.bpel.model.ExtensibleElement;
import org.eclipse.bpel.model.Documentation;
import org.eclipse.bpel.model.MessageExchanges;
import org.eclipse.bpel.model.MessageExchange;
import org.eclipse.bpel.model.Compensate;
import java.util.List;
import java.util.Collection;
import java.util.ListIterator;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.reuseware.emftextedit.runtime.resource.*;
import org.reuseware.emftextedit.runtime.resource.impl.*;

public abstract class BpwsPrinterBase extends EMFTextPrinterImpl {

	protected TokenResolverFactory tokenResolverFactory = new BpwsTokenResolverFactory();
	protected EMFTextTreeAnalyser treeAnalyser = new BpwsTreeAnalyser();

	public BpwsPrinterBase(OutputStream o, TextResource resource) {

		super(o, resource);
	}

	protected static int matchCount(Map<java.lang.String, java.lang.Integer> featureCounter, Collection<java.lang.String> needed){
		int pos = 0;
		int neg = 0;

		for(String featureName:featureCounter.keySet()){
			if(needed.contains(featureName)){
				int value = featureCounter.get(featureName);
				if(value==0)
					neg+=1;
				else
					pos+=1;
			}
		}
		return neg>0?-neg:pos;
	}

	protected void doPrint(EObject element,PrintWriter out,String globaltab) {
		if (element == null||out == null) throw new NullPointerException("Nothing to write or to write on.");

		if(element instanceof Process){
			printProcess((Process) element,globaltab,out);
			return;
		}
		if(element instanceof PartnerLink){
			printPartnerLink((PartnerLink) element,globaltab,out);
			return;
		}
		if(element instanceof FaultHandler){
			printFaultHandler((FaultHandler) element,globaltab,out);
			return;
		}
		if(element instanceof CorrelationSet){
			printCorrelationSet((CorrelationSet) element,globaltab,out);
			return;
		}
		if(element instanceof Invoke){
			printInvoke((Invoke) element,globaltab,out);
			return;
		}
		if(element instanceof Link){
			printLink((Link) element,globaltab,out);
			return;
		}
		if(element instanceof Catch){
			printCatch((Catch) element,globaltab,out);
			return;
		}
		if(element instanceof Reply){
			printReply((Reply) element,globaltab,out);
			return;
		}
		if(element instanceof Receive){
			printReceive((Receive) element,globaltab,out);
			return;
		}
		if(element instanceof Exit){
			printExit((Exit) element,globaltab,out);
			return;
		}
		if(element instanceof Throw){
			printThrow((Throw) element,globaltab,out);
			return;
		}
		if(element instanceof Wait){
			printWait((Wait) element,globaltab,out);
			return;
		}
		if(element instanceof Empty){
			printEmpty((Empty) element,globaltab,out);
			return;
		}
		if(element instanceof Sequence){
			printSequence((Sequence) element,globaltab,out);
			return;
		}
		if(element instanceof While){
			printWhile((While) element,globaltab,out);
			return;
		}
		if(element instanceof Pick){
			printPick((Pick) element,globaltab,out);
			return;
		}
		if(element instanceof Flow){
			printFlow((Flow) element,globaltab,out);
			return;
		}
		if(element instanceof OnAlarm){
			printOnAlarm((OnAlarm) element,globaltab,out);
			return;
		}
		if(element instanceof Assign){
			printAssign((Assign) element,globaltab,out);
			return;
		}
		if(element instanceof Copy){
			printCopy((Copy) element,globaltab,out);
			return;
		}
		if(element instanceof Extension){
			printExtension((Extension) element,globaltab,out);
			return;
		}
		if(element instanceof Scope){
			printScope((Scope) element,globaltab,out);
			return;
		}
		if(element instanceof CompensateScope){
			printCompensateScope((CompensateScope) element,globaltab,out);
			return;
		}
		if(element instanceof CompensationHandler){
			printCompensationHandler((CompensationHandler) element,globaltab,out);
			return;
		}
		if(element instanceof To){
			printTo((To) element,globaltab,out);
			return;
		}
		if(element instanceof From){
			printFrom((From) element,globaltab,out);
			return;
		}
		if(element instanceof OnMessage){
			printOnMessage((OnMessage) element,globaltab,out);
			return;
		}
		if(element instanceof BooleanExpression){
			printBooleanExpression((BooleanExpression) element,globaltab,out);
			return;
		}
		if(element instanceof Correlation){
			printCorrelation((Correlation) element,globaltab,out);
			return;
		}
		if(element instanceof EventHandler){
			printEventHandler((EventHandler) element,globaltab,out);
			return;
		}
		if(element instanceof Source){
			printSource((Source) element,globaltab,out);
			return;
		}
		if(element instanceof Target){
			printTarget((Target) element,globaltab,out);
			return;
		}
		if(element instanceof PartnerLinks){
			printPartnerLinks((PartnerLinks) element,globaltab,out);
			return;
		}
		if(element instanceof Variables){
			printVariables((Variables) element,globaltab,out);
			return;
		}
		if(element instanceof CorrelationSets){
			printCorrelationSets((CorrelationSets) element,globaltab,out);
			return;
		}
		if(element instanceof Links){
			printLinks((Links) element,globaltab,out);
			return;
		}
		if(element instanceof CatchAll){
			printCatchAll((CatchAll) element,globaltab,out);
			return;
		}
		if(element instanceof Correlations){
			printCorrelations((Correlations) element,globaltab,out);
			return;
		}
		if(element instanceof Variable){
			printVariable((Variable) element,globaltab,out);
			return;
		}
		if(element instanceof UnknownExtensibilityAttribute){
			printUnknownExtensibilityAttribute((UnknownExtensibilityAttribute) element,globaltab,out);
			return;
		}
		if(element instanceof OnEvent){
			printOnEvent((OnEvent) element,globaltab,out);
			return;
		}
		if(element instanceof Import){
			printImport((Import) element,globaltab,out);
			return;
		}
		if(element instanceof Rethrow){
			printRethrow((Rethrow) element,globaltab,out);
			return;
		}
		if(element instanceof Condition){
			printCondition((Condition) element,globaltab,out);
			return;
		}
		if(element instanceof Targets){
			printTargets((Targets) element,globaltab,out);
			return;
		}
		if(element instanceof Sources){
			printSources((Sources) element,globaltab,out);
			return;
		}
		if(element instanceof Query){
			printQuery((Query) element,globaltab,out);
			return;
		}
		if(element instanceof ServiceRef){
			printServiceRef((ServiceRef) element,globaltab,out);
			return;
		}
		if(element instanceof Extensions){
			printExtensions((Extensions) element,globaltab,out);
			return;
		}
		if(element instanceof ExtensionActivity){
			printExtensionActivity((ExtensionActivity) element,globaltab,out);
			return;
		}
		if(element instanceof FromPart){
			printFromPart((FromPart) element,globaltab,out);
			return;
		}
		if(element instanceof ToPart){
			printToPart((ToPart) element,globaltab,out);
			return;
		}
		if(element instanceof OpaqueActivity){
			printOpaqueActivity((OpaqueActivity) element,globaltab,out);
			return;
		}
		if(element instanceof ForEach){
			printForEach((ForEach) element,globaltab,out);
			return;
		}
		if(element instanceof RepeatUntil){
			printRepeatUntil((RepeatUntil) element,globaltab,out);
			return;
		}
		if(element instanceof TerminationHandler){
			printTerminationHandler((TerminationHandler) element,globaltab,out);
			return;
		}
		if(element instanceof Validate){
			printValidate((Validate) element,globaltab,out);
			return;
		}
		if(element instanceof If){
			printIf((If) element,globaltab,out);
			return;
		}
		if(element instanceof ElseIf){
			printElseIf((ElseIf) element,globaltab,out);
			return;
		}
		if(element instanceof Else){
			printElse((Else) element,globaltab,out);
			return;
		}
		if(element instanceof CompletionCondition){
			printCompletionCondition((CompletionCondition) element,globaltab,out);
			return;
		}
		if(element instanceof Branches){
			printBranches((Branches) element,globaltab,out);
			return;
		}
		if(element instanceof Documentation){
			printDocumentation((Documentation) element,globaltab,out);
			return;
		}
		if(element instanceof MessageExchanges){
			printMessageExchanges((MessageExchanges) element,globaltab,out);
			return;
		}
		if(element instanceof MessageExchange){
			printMessageExchange((MessageExchange) element,globaltab,out);
			return;
		}
		if(element instanceof Compensate){
			printCompensate((Compensate) element,globaltab,out);
			return;
		}
		if(element instanceof PartnerActivity){
			printPartnerActivity((PartnerActivity) element,globaltab,out);
			return;
		}
		if(element instanceof Expression){
			printExpression((Expression) element,globaltab,out);
			return;
		}
		if(element instanceof Activity){
			printActivity((Activity) element,globaltab,out);
			return;
		}
		if(element instanceof ExtensibleElement){
			printExtensibleElement((ExtensibleElement) element,globaltab,out);
			return;
		}

		resource.addWarning("The cs printer can not handle " + element.eClass().getName() + " elements", element);
	}

		public void printProcess(Process element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(20);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.getTargetNamespace();
			printCountingMap.put("targetNamespace", temp == null ? 0 : 1);
			temp = element.getQueryLanguage();
			printCountingMap.put("queryLanguage", temp == null ? 0 : 1);
			temp = element.getExpressionLanguage();
			printCountingMap.put("expressionLanguage", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.isVariableAccessSerializable();
			printCountingMap.put("variableAccessSerializable", temp == null ? 0 : 1);
			temp = element.getPartnerLinks();
			printCountingMap.put("partnerLinks", temp == null ? 0 : 1);
			temp = element.getVariables();
			printCountingMap.put("variables", temp == null ? 0 : 1);
			temp = element.getActivity();
			printCountingMap.put("activity", temp == null ? 0 : 1);
			temp = element.getFaultHandlers();
			printCountingMap.put("faultHandlers", temp == null ? 0 : 1);
			temp = element.getEventHandlers();
			printCountingMap.put("eventHandlers", temp == null ? 0 : 1);
			temp = element.getCorrelationSets();
			printCountingMap.put("correlationSets", temp == null ? 0 : 1);
			temp = element.getImports();
			printCountingMap.put("imports", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getExtensions();
			printCountingMap.put("extensions", temp == null ? 0 : 1);
			temp = element.isExitOnStandardFault();
			printCountingMap.put("exitOnStandardFault", temp == null ? 0 : 1);
			temp = element.getMessageExchanges();
			printCountingMap.put("messageExchanges", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Process");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printProcess_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printProcess_0(Process element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targetNamespace"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("queryLanguage"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("expressionLanguage"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("variableAccessSerializable"));
			if (tempMatchCount > matches) {
				alt = 9;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("partnerLinks"));
			if (tempMatchCount > matches) {
				alt = 10;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("variables"));
			if (tempMatchCount > matches) {
				alt = 11;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("activity"));
			if (tempMatchCount > matches) {
				alt = 12;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("faultHandlers"));
			if (tempMatchCount > matches) {
				alt = 13;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eventHandlers"));
			if (tempMatchCount > matches) {
				alt = 14;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("correlationSets"));
			if (tempMatchCount > matches) {
				alt = 15;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("imports"));
			if (tempMatchCount > matches) {
				alt = 16;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("extensions"));
			if (tempMatchCount > matches) {
				alt = 17;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("exitOnStandardFault"));
			if (tempMatchCount > matches) {
				alt = 18;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("messageExchanges"));
			if (tempMatchCount > matches) {
				alt = 19;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targetNamespace");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("targetNamespace");
						if(count>0){
							Object o =element.getTargetNamespace();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("targetNamespace"),element));
				
							printCountingMap.put("targetNamespace",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("queryLanguage");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("queryLanguage");
						if(count>0){
							Object o =element.getQueryLanguage();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("queryLanguage"),element));
				
							printCountingMap.put("queryLanguage",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("expressionLanguage");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("expressionLanguage");
						if(count>0){
							Object o =element.getExpressionLanguage();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("expressionLanguage"),element));
				
							printCountingMap.put("expressionLanguage",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 9:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("variableAccessSerializable");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("variableAccessSerializable");
						if(count>0){
							Object o =element.isVariableAccessSerializable();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("variableAccessSerializable"),element));
				
							printCountingMap.put("variableAccessSerializable",count-1);
						}
					}
				break;
				case 10:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("partnerLinks");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("partnerLinks");
						if(count>0){
							Object o =element.getPartnerLinks();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("partnerLinks",count-1);
						}
					}
				break;
				case 11:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("variables");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("variables");
						if(count>0){
							Object o =element.getVariables();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("variables",count-1);
						}
					}
				break;
				case 12:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("activity");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("activity");
						if(count>0){
							Object o =element.getActivity();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("activity",count-1);
						}
					}
				break;
				case 13:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("faultHandlers");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("faultHandlers");
						if(count>0){
							Object o =element.getFaultHandlers();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("faultHandlers",count-1);
						}
					}
				break;
				case 14:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eventHandlers");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eventHandlers");
						if(count>0){
							Object o =element.getEventHandlers();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eventHandlers",count-1);
						}
					}
				break;
				case 15:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("correlationSets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("correlationSets");
						if(count>0){
							Object o =element.getCorrelationSets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("correlationSets",count-1);
						}
					}
				break;
				case 16:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("imports");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("imports");
						if(count>0){
							Object o =element.getImports();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("imports",count-1);
						}
					}
				break;
				case 17:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("extensions");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("extensions");
						if(count>0){
							Object o =element.getExtensions();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("extensions",count-1);
						}
					}
				break;
				case 18:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("exitOnStandardFault");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("exitOnStandardFault");
						if(count>0){
							Object o =element.isExitOnStandardFault();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("exitOnStandardFault"),element));
				
							printCountingMap.put("exitOnStandardFault",count-1);
						}
					}
				break;
				case 19:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("messageExchanges");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("messageExchanges");
						if(count>0){
							Object o =element.getMessageExchanges();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("messageExchanges")),element.eClass().getEStructuralFeature("messageExchanges"),element));
							printCountingMap.put("messageExchanges",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printPartnerLink(PartnerLink element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(9);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.getMyRole();
			printCountingMap.put("myRole", temp == null ? 0 : 1);
			temp = element.getPartnerRole();
			printCountingMap.put("partnerRole", temp == null ? 0 : 1);
			temp = element.getPartnerLinkType();
			printCountingMap.put("PartnerLinkType", temp == null ? 0 : 1);
			temp = element.isInitializePartnerRole();
			printCountingMap.put("initializePartnerRole", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("PartnerLink");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printPartnerLink_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printPartnerLink_0(PartnerLink element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("myRole"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("partnerRole"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("PartnerLinkType"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("initializePartnerRole"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("myRole");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("myRole");
						if(count>0){
							Object o =element.getMyRole();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("myRole")),element.eClass().getEStructuralFeature("myRole"),element));
							printCountingMap.put("myRole",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("partnerRole");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("partnerRole");
						if(count>0){
							Object o =element.getPartnerRole();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("partnerRole")),element.eClass().getEStructuralFeature("partnerRole"),element));
							printCountingMap.put("partnerRole",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("PartnerLinkType");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("PartnerLinkType");
						if(count>0){
							Object o =element.getPartnerLinkType();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("PartnerLinkType")),element.eClass().getEStructuralFeature("PartnerLinkType"),element));
							printCountingMap.put("PartnerLinkType",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("initializePartnerRole");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("initializePartnerRole");
						if(count>0){
							Object o =element.isInitializePartnerRole();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("initializePartnerRole"),element));
				
							printCountingMap.put("initializePartnerRole",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printFaultHandler(FaultHandler element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(6);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getCatch();
			printCountingMap.put("catch", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getCatchAll();
			printCountingMap.put("catchAll", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("FaultHandler");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printFaultHandler_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printFaultHandler_0(FaultHandler element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("catch"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("catchAll"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("catch");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("catch");
						if(count>0){
							Object o =element.getCatch();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("catch",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("catchAll");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("catchAll");
						if(count>0){
							Object o =element.getCatchAll();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("catchAll",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printActivity(Activity element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(8);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Activity");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printActivity_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printActivity_0(Activity element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printCorrelationSet(CorrelationSet element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(6);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.getProperties();
			printCountingMap.put("properties", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("CorrelationSet");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printCorrelationSet_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printCorrelationSet_0(CorrelationSet element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("properties"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("properties");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("properties");
						if(count>0){
							Object o =element.getProperties();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("properties")),element.eClass().getEStructuralFeature("properties"),element));
							printCountingMap.put("properties",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printInvoke(Invoke element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(18);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			temp = element.getPartnerLink();
			printCountingMap.put("partnerLink", temp == null ? 0 : 1);
			temp = element.getCorrelations();
			printCountingMap.put("correlations", temp == null ? 0 : 1);
			temp = element.getPortType();
			printCountingMap.put("portType", temp == null ? 0 : 1);
			temp = element.getOperation();
			printCountingMap.put("operation", temp == null ? 0 : 1);
			temp = element.getOutputVariable();
			printCountingMap.put("outputVariable", temp == null ? 0 : 1);
			temp = element.getInputVariable();
			printCountingMap.put("inputVariable", temp == null ? 0 : 1);
			temp = element.getCompensationHandler();
			printCountingMap.put("compensationHandler", temp == null ? 0 : 1);
			temp = element.getFaultHandler();
			printCountingMap.put("faultHandler", temp == null ? 0 : 1);
			temp = element.getToPart();
			printCountingMap.put("toPart", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getFromPart();
			printCountingMap.put("fromPart", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Invoke");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printInvoke_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printInvoke_0(Invoke element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("partnerLink"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("correlations"));
			if (tempMatchCount > matches) {
				alt = 9;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("portType"));
			if (tempMatchCount > matches) {
				alt = 10;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("operation"));
			if (tempMatchCount > matches) {
				alt = 11;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("outputVariable"));
			if (tempMatchCount > matches) {
				alt = 12;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("inputVariable"));
			if (tempMatchCount > matches) {
				alt = 13;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("compensationHandler"));
			if (tempMatchCount > matches) {
				alt = 14;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("faultHandler"));
			if (tempMatchCount > matches) {
				alt = 15;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("toPart"));
			if (tempMatchCount > matches) {
				alt = 16;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("fromPart"));
			if (tempMatchCount > matches) {
				alt = 17;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("partnerLink");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("partnerLink");
						if(count>0){
							Object o =element.getPartnerLink();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("partnerLink")),element.eClass().getEStructuralFeature("partnerLink"),element));
							printCountingMap.put("partnerLink",count-1);
						}
					}
				break;
				case 9:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("correlations");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("correlations");
						if(count>0){
							Object o =element.getCorrelations();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("correlations",count-1);
						}
					}
				break;
				case 10:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("portType");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("portType");
						if(count>0){
							Object o =element.getPortType();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("portType")),element.eClass().getEStructuralFeature("portType"),element));
							printCountingMap.put("portType",count-1);
						}
					}
				break;
				case 11:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("operation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("operation");
						if(count>0){
							Object o =element.getOperation();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("operation")),element.eClass().getEStructuralFeature("operation"),element));
							printCountingMap.put("operation",count-1);
						}
					}
				break;
				case 12:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("outputVariable");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("outputVariable");
						if(count>0){
							Object o =element.getOutputVariable();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("outputVariable")),element.eClass().getEStructuralFeature("outputVariable"),element));
							printCountingMap.put("outputVariable",count-1);
						}
					}
				break;
				case 13:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("inputVariable");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("inputVariable");
						if(count>0){
							Object o =element.getInputVariable();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("inputVariable")),element.eClass().getEStructuralFeature("inputVariable"),element));
							printCountingMap.put("inputVariable",count-1);
						}
					}
				break;
				case 14:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("compensationHandler");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("compensationHandler");
						if(count>0){
							Object o =element.getCompensationHandler();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("compensationHandler",count-1);
						}
					}
				break;
				case 15:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("faultHandler");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("faultHandler");
						if(count>0){
							Object o =element.getFaultHandler();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("faultHandler",count-1);
						}
					}
				break;
				case 16:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("toPart");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("toPart");
						if(count>0){
							Object o =element.getToPart();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("toPart")),element.eClass().getEStructuralFeature("toPart"),element));
							printCountingMap.put("toPart",count-1);
						}
					}
				break;
				case 17:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("fromPart");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("fromPart");
						if(count>0){
							Object o =element.getFromPart();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("fromPart")),element.eClass().getEStructuralFeature("fromPart"),element));
							printCountingMap.put("fromPart",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printLink(Link element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(7);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Link");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printLink_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printLink_0(Link element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("sources")),element.eClass().getEStructuralFeature("sources"),element));
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("targets")),element.eClass().getEStructuralFeature("targets"),element));
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printCatch(Catch element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(9);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getFaultName();
			printCountingMap.put("faultName", temp == null ? 0 : 1);
			temp = element.getFaultVariable();
			printCountingMap.put("faultVariable", temp == null ? 0 : 1);
			temp = element.getActivity();
			printCountingMap.put("activity", temp == null ? 0 : 1);
			temp = element.getFaultMessageType();
			printCountingMap.put("faultMessageType", temp == null ? 0 : 1);
			temp = element.getFaultElement();
			printCountingMap.put("faultElement", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Catch");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printCatch_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printCatch_0(Catch element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("faultName"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("faultVariable"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("activity"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("faultMessageType"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("faultElement"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("faultName");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("faultName");
						if(count>0){
							Object o =element.getFaultName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("faultName"),element));
				
							printCountingMap.put("faultName",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("faultVariable");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("faultVariable");
						if(count>0){
							Object o =element.getFaultVariable();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("faultVariable",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("activity");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("activity");
						if(count>0){
							Object o =element.getActivity();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("activity",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("faultMessageType");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("faultMessageType");
						if(count>0){
							Object o =element.getFaultMessageType();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("faultMessageType")),element.eClass().getEStructuralFeature("faultMessageType"),element));
							printCountingMap.put("faultMessageType",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("faultElement");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("faultElement");
						if(count>0){
							Object o =element.getFaultElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("faultElement")),element.eClass().getEStructuralFeature("faultElement"),element));
							printCountingMap.put("faultElement",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printReply(Reply element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(15);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			temp = element.getPartnerLink();
			printCountingMap.put("partnerLink", temp == null ? 0 : 1);
			temp = element.getCorrelations();
			printCountingMap.put("correlations", temp == null ? 0 : 1);
			temp = element.getPortType();
			printCountingMap.put("portType", temp == null ? 0 : 1);
			temp = element.getOperation();
			printCountingMap.put("operation", temp == null ? 0 : 1);
			temp = element.getFaultName();
			printCountingMap.put("faultName", temp == null ? 0 : 1);
			temp = element.getVariable();
			printCountingMap.put("variable", temp == null ? 0 : 1);
			temp = element.getToPart();
			printCountingMap.put("toPart", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Reply");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printReply_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printReply_0(Reply element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("partnerLink"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("correlations"));
			if (tempMatchCount > matches) {
				alt = 9;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("portType"));
			if (tempMatchCount > matches) {
				alt = 10;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("operation"));
			if (tempMatchCount > matches) {
				alt = 11;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("faultName"));
			if (tempMatchCount > matches) {
				alt = 12;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("variable"));
			if (tempMatchCount > matches) {
				alt = 13;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("toPart"));
			if (tempMatchCount > matches) {
				alt = 14;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("partnerLink");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("partnerLink");
						if(count>0){
							Object o =element.getPartnerLink();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("partnerLink")),element.eClass().getEStructuralFeature("partnerLink"),element));
							printCountingMap.put("partnerLink",count-1);
						}
					}
				break;
				case 9:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("correlations");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("correlations");
						if(count>0){
							Object o =element.getCorrelations();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("correlations",count-1);
						}
					}
				break;
				case 10:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("portType");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("portType");
						if(count>0){
							Object o =element.getPortType();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("portType")),element.eClass().getEStructuralFeature("portType"),element));
							printCountingMap.put("portType",count-1);
						}
					}
				break;
				case 11:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("operation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("operation");
						if(count>0){
							Object o =element.getOperation();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("operation")),element.eClass().getEStructuralFeature("operation"),element));
							printCountingMap.put("operation",count-1);
						}
					}
				break;
				case 12:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("faultName");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("faultName");
						if(count>0){
							Object o =element.getFaultName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("faultName"),element));
				
							printCountingMap.put("faultName",count-1);
						}
					}
				break;
				case 13:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("variable");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("variable");
						if(count>0){
							Object o =element.getVariable();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("variable")),element.eClass().getEStructuralFeature("variable"),element));
							printCountingMap.put("variable",count-1);
						}
					}
				break;
				case 14:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("toPart");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("toPart");
						if(count>0){
							Object o =element.getToPart();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("toPart")),element.eClass().getEStructuralFeature("toPart"),element));
							printCountingMap.put("toPart",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printPartnerActivity(PartnerActivity element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(12);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			temp = element.getPartnerLink();
			printCountingMap.put("partnerLink", temp == null ? 0 : 1);
			temp = element.getCorrelations();
			printCountingMap.put("correlations", temp == null ? 0 : 1);
			temp = element.getPortType();
			printCountingMap.put("portType", temp == null ? 0 : 1);
			temp = element.getOperation();
			printCountingMap.put("operation", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("PartnerActivity");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printPartnerActivity_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printPartnerActivity_0(PartnerActivity element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("partnerLink"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("correlations"));
			if (tempMatchCount > matches) {
				alt = 9;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("portType"));
			if (tempMatchCount > matches) {
				alt = 10;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("operation"));
			if (tempMatchCount > matches) {
				alt = 11;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("partnerLink");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("partnerLink");
						if(count>0){
							Object o =element.getPartnerLink();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("partnerLink")),element.eClass().getEStructuralFeature("partnerLink"),element));
							printCountingMap.put("partnerLink",count-1);
						}
					}
				break;
				case 9:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("correlations");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("correlations");
						if(count>0){
							Object o =element.getCorrelations();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("correlations",count-1);
						}
					}
				break;
				case 10:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("portType");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("portType");
						if(count>0){
							Object o =element.getPortType();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("portType")),element.eClass().getEStructuralFeature("portType"),element));
							printCountingMap.put("portType",count-1);
						}
					}
				break;
				case 11:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("operation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("operation");
						if(count>0){
							Object o =element.getOperation();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("operation")),element.eClass().getEStructuralFeature("operation"),element));
							printCountingMap.put("operation",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printReceive(Receive element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(15);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			temp = element.getPartnerLink();
			printCountingMap.put("partnerLink", temp == null ? 0 : 1);
			temp = element.getCorrelations();
			printCountingMap.put("correlations", temp == null ? 0 : 1);
			temp = element.getPortType();
			printCountingMap.put("portType", temp == null ? 0 : 1);
			temp = element.getOperation();
			printCountingMap.put("operation", temp == null ? 0 : 1);
			temp = element.isCreateInstance();
			printCountingMap.put("createInstance", temp == null ? 0 : 1);
			temp = element.getVariable();
			printCountingMap.put("variable", temp == null ? 0 : 1);
			temp = element.getFromPart();
			printCountingMap.put("fromPart", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Receive");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printReceive_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printReceive_0(Receive element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("partnerLink"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("correlations"));
			if (tempMatchCount > matches) {
				alt = 9;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("portType"));
			if (tempMatchCount > matches) {
				alt = 10;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("operation"));
			if (tempMatchCount > matches) {
				alt = 11;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("createInstance"));
			if (tempMatchCount > matches) {
				alt = 12;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("variable"));
			if (tempMatchCount > matches) {
				alt = 13;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("fromPart"));
			if (tempMatchCount > matches) {
				alt = 14;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("partnerLink");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("partnerLink");
						if(count>0){
							Object o =element.getPartnerLink();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("partnerLink")),element.eClass().getEStructuralFeature("partnerLink"),element));
							printCountingMap.put("partnerLink",count-1);
						}
					}
				break;
				case 9:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("correlations");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("correlations");
						if(count>0){
							Object o =element.getCorrelations();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("correlations",count-1);
						}
					}
				break;
				case 10:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("portType");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("portType");
						if(count>0){
							Object o =element.getPortType();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("portType")),element.eClass().getEStructuralFeature("portType"),element));
							printCountingMap.put("portType",count-1);
						}
					}
				break;
				case 11:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("operation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("operation");
						if(count>0){
							Object o =element.getOperation();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("operation")),element.eClass().getEStructuralFeature("operation"),element));
							printCountingMap.put("operation",count-1);
						}
					}
				break;
				case 12:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("createInstance");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("createInstance");
						if(count>0){
							Object o =element.isCreateInstance();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("createInstance"),element));
				
							printCountingMap.put("createInstance",count-1);
						}
					}
				break;
				case 13:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("variable");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("variable");
						if(count>0){
							Object o =element.getVariable();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("variable")),element.eClass().getEStructuralFeature("variable"),element));
							printCountingMap.put("variable",count-1);
						}
					}
				break;
				case 14:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("fromPart");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("fromPart");
						if(count>0){
							Object o =element.getFromPart();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("fromPart")),element.eClass().getEStructuralFeature("fromPart"),element));
							printCountingMap.put("fromPart",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printExit(Exit element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(8);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Exit");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printExit_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printExit_0(Exit element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printThrow(Throw element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(10);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			temp = element.getFaultName();
			printCountingMap.put("faultName", temp == null ? 0 : 1);
			temp = element.getFaultVariable();
			printCountingMap.put("faultVariable", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Throw");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printThrow_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printThrow_0(Throw element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("faultName"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("faultVariable"));
			if (tempMatchCount > matches) {
				alt = 9;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("faultName");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("faultName");
						if(count>0){
							Object o =element.getFaultName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("faultName"),element));
				
							printCountingMap.put("faultName",count-1);
						}
					}
				break;
				case 9:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("faultVariable");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("faultVariable");
						if(count>0){
							Object o =element.getFaultVariable();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("faultVariable")),element.eClass().getEStructuralFeature("faultVariable"),element));
							printCountingMap.put("faultVariable",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printWait(Wait element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(10);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			temp = element.getFor();
			printCountingMap.put("for", temp == null ? 0 : 1);
			temp = element.getUntil();
			printCountingMap.put("until", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Wait");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printWait_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printWait_0(Wait element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("for"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("until"));
			if (tempMatchCount > matches) {
				alt = 9;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("for");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("for");
						if(count>0){
							Object o =element.getFor();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("for",count-1);
						}
					}
				break;
				case 9:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("until");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("until");
						if(count>0){
							Object o =element.getUntil();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("until",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printEmpty(Empty element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(8);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Empty");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printEmpty_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printEmpty_0(Empty element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printSequence(Sequence element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(9);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			temp = element.getActivities();
			printCountingMap.put("activities", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Sequence");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printSequence_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printSequence_0(Sequence element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("activities"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("activities");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("activities");
						if(count>0){
							Object o =element.getActivities();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("activities",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printWhile(While element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(10);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			temp = element.getActivity();
			printCountingMap.put("activity", temp == null ? 0 : 1);
			temp = element.getCondition();
			printCountingMap.put("condition", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("While");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printWhile_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printWhile_0(While element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("activity"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("condition"));
			if (tempMatchCount > matches) {
				alt = 9;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("activity");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("activity");
						if(count>0){
							Object o =element.getActivity();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("activity",count-1);
						}
					}
				break;
				case 9:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("condition");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("condition");
						if(count>0){
							Object o =element.getCondition();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("condition",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printPick(Pick element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(11);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			temp = element.isCreateInstance();
			printCountingMap.put("createInstance", temp == null ? 0 : 1);
			temp = element.getMessages();
			printCountingMap.put("messages", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getAlarm();
			printCountingMap.put("alarm", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Pick");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printPick_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printPick_0(Pick element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("createInstance"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("messages"));
			if (tempMatchCount > matches) {
				alt = 9;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("alarm"));
			if (tempMatchCount > matches) {
				alt = 10;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("createInstance");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("createInstance");
						if(count>0){
							Object o =element.isCreateInstance();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("createInstance"),element));
				
							printCountingMap.put("createInstance",count-1);
						}
					}
				break;
				case 9:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("messages");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("messages");
						if(count>0){
							Object o =element.getMessages();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("messages",count-1);
						}
					}
				break;
				case 10:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("alarm");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("alarm");
						if(count>0){
							Object o =element.getAlarm();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("alarm",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printFlow(Flow element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(11);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			temp = element.getActivities();
			printCountingMap.put("activities", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getLinks();
			printCountingMap.put("links", temp == null ? 0 : 1);
			temp = element.getCompletionCondition();
			printCountingMap.put("completionCondition", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Flow");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printFlow_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printFlow_0(Flow element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("activities"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("links"));
			if (tempMatchCount > matches) {
				alt = 9;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("completionCondition"));
			if (tempMatchCount > matches) {
				alt = 10;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("activities");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("activities");
						if(count>0){
							Object o =element.getActivities();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("activities",count-1);
						}
					}
				break;
				case 9:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("links");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("links");
						if(count>0){
							Object o =element.getLinks();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("links",count-1);
						}
					}
				break;
				case 10:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("completionCondition");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("completionCondition");
						if(count>0){
							Object o =element.getCompletionCondition();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("completionCondition",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printOnAlarm(OnAlarm element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(8);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getActivity();
			printCountingMap.put("activity", temp == null ? 0 : 1);
			temp = element.getFor();
			printCountingMap.put("for", temp == null ? 0 : 1);
			temp = element.getUntil();
			printCountingMap.put("until", temp == null ? 0 : 1);
			temp = element.getRepeatEvery();
			printCountingMap.put("repeatEvery", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("OnAlarm");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printOnAlarm_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printOnAlarm_0(OnAlarm element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("activity"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("for"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("until"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("repeatEvery"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("activity");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("activity");
						if(count>0){
							Object o =element.getActivity();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("activity",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("for");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("for");
						if(count>0){
							Object o =element.getFor();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("for",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("until");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("until");
						if(count>0){
							Object o =element.getUntil();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("until",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("repeatEvery");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("repeatEvery");
						if(count>0){
							Object o =element.getRepeatEvery();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("repeatEvery",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printAssign(Assign element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(10);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			temp = element.getCopy();
			printCountingMap.put("copy", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.isValidate();
			printCountingMap.put("validate", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Assign");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printAssign_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printAssign_0(Assign element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("copy"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("validate"));
			if (tempMatchCount > matches) {
				alt = 9;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("copy");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("copy");
						if(count>0){
							Object o =element.getCopy();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("copy",count-1);
						}
					}
				break;
				case 9:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("validate");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("validate");
						if(count>0){
							Object o =element.isValidate();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("validate"),element));
				
							printCountingMap.put("validate",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printCopy(Copy element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(8);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getTo();
			printCountingMap.put("to", temp == null ? 0 : 1);
			temp = element.getFrom();
			printCountingMap.put("from", temp == null ? 0 : 1);
			temp = element.isKeepSrcElementName();
			printCountingMap.put("keepSrcElementName", temp == null ? 0 : 1);
			temp = element.isIgnoreMissingFromData();
			printCountingMap.put("ignoreMissingFromData", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Copy");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printCopy_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printCopy_0(Copy element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("to"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("from"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("keepSrcElementName"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("ignoreMissingFromData"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("to");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("to");
						if(count>0){
							Object o =element.getTo();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("to",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("from");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("from");
						if(count>0){
							Object o =element.getFrom();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("from",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("keepSrcElementName");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("keepSrcElementName");
						if(count>0){
							Object o =element.isKeepSrcElementName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("keepSrcElementName"),element));
				
							printCountingMap.put("keepSrcElementName",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("ignoreMissingFromData");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("ignoreMissingFromData");
						if(count>0){
							Object o =element.isIgnoreMissingFromData();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("ignoreMissingFromData"),element));
				
							printCountingMap.put("ignoreMissingFromData",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printExtension(Extension element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(6);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getNamespace();
			printCountingMap.put("namespace", temp == null ? 0 : 1);
			temp = element.isMustUnderstand();
			printCountingMap.put("mustUnderstand", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Extension");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printExtension_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printExtension_0(Extension element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("namespace"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("mustUnderstand"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("namespace");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("namespace");
						if(count>0){
							Object o =element.getNamespace();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("namespace"),element));
				
							printCountingMap.put("namespace",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("mustUnderstand");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("mustUnderstand");
						if(count>0){
							Object o =element.isMustUnderstand();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("mustUnderstand"),element));
				
							printCountingMap.put("mustUnderstand",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printScope(Scope element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(19);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			temp = element.isIsolated();
			printCountingMap.put("isolated", temp == null ? 0 : 1);
			temp = element.getFaultHandlers();
			printCountingMap.put("faultHandlers", temp == null ? 0 : 1);
			temp = element.getCompensationHandler();
			printCountingMap.put("compensationHandler", temp == null ? 0 : 1);
			temp = element.getActivity();
			printCountingMap.put("activity", temp == null ? 0 : 1);
			temp = element.getVariables();
			printCountingMap.put("variables", temp == null ? 0 : 1);
			temp = element.getCorrelationSets();
			printCountingMap.put("correlationSets", temp == null ? 0 : 1);
			temp = element.getEventHandlers();
			printCountingMap.put("eventHandlers", temp == null ? 0 : 1);
			temp = element.getPartnerLinks();
			printCountingMap.put("partnerLinks", temp == null ? 0 : 1);
			temp = element.getTerminationHandler();
			printCountingMap.put("terminationHandler", temp == null ? 0 : 1);
			temp = element.getMessageExchanges();
			printCountingMap.put("messageExchanges", temp == null ? 0 : 1);
			temp = element.isExitOnStandardFault();
			printCountingMap.put("exitOnStandardFault", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Scope");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printScope_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printScope_0(Scope element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("isolated"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("faultHandlers"));
			if (tempMatchCount > matches) {
				alt = 9;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("compensationHandler"));
			if (tempMatchCount > matches) {
				alt = 10;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("activity"));
			if (tempMatchCount > matches) {
				alt = 11;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("variables"));
			if (tempMatchCount > matches) {
				alt = 12;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("correlationSets"));
			if (tempMatchCount > matches) {
				alt = 13;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eventHandlers"));
			if (tempMatchCount > matches) {
				alt = 14;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("partnerLinks"));
			if (tempMatchCount > matches) {
				alt = 15;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("terminationHandler"));
			if (tempMatchCount > matches) {
				alt = 16;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("messageExchanges"));
			if (tempMatchCount > matches) {
				alt = 17;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("exitOnStandardFault"));
			if (tempMatchCount > matches) {
				alt = 18;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("isolated");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("isolated");
						if(count>0){
							Object o =element.isIsolated();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("isolated"),element));
				
							printCountingMap.put("isolated",count-1);
						}
					}
				break;
				case 9:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("faultHandlers");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("faultHandlers");
						if(count>0){
							Object o =element.getFaultHandlers();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("faultHandlers",count-1);
						}
					}
				break;
				case 10:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("compensationHandler");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("compensationHandler");
						if(count>0){
							Object o =element.getCompensationHandler();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("compensationHandler",count-1);
						}
					}
				break;
				case 11:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("activity");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("activity");
						if(count>0){
							Object o =element.getActivity();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("activity",count-1);
						}
					}
				break;
				case 12:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("variables");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("variables");
						if(count>0){
							Object o =element.getVariables();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("variables",count-1);
						}
					}
				break;
				case 13:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("correlationSets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("correlationSets");
						if(count>0){
							Object o =element.getCorrelationSets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("correlationSets",count-1);
						}
					}
				break;
				case 14:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eventHandlers");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eventHandlers");
						if(count>0){
							Object o =element.getEventHandlers();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eventHandlers",count-1);
						}
					}
				break;
				case 15:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("partnerLinks");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("partnerLinks");
						if(count>0){
							Object o =element.getPartnerLinks();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("partnerLinks",count-1);
						}
					}
				break;
				case 16:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("terminationHandler");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("terminationHandler");
						if(count>0){
							Object o =element.getTerminationHandler();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("terminationHandler",count-1);
						}
					}
				break;
				case 17:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("messageExchanges");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("messageExchanges");
						if(count>0){
							Object o =element.getMessageExchanges();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("messageExchanges")),element.eClass().getEStructuralFeature("messageExchanges"),element));
							printCountingMap.put("messageExchanges",count-1);
						}
					}
				break;
				case 18:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("exitOnStandardFault");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("exitOnStandardFault");
						if(count>0){
							Object o =element.isExitOnStandardFault();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("exitOnStandardFault"),element));
				
							printCountingMap.put("exitOnStandardFault",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printCompensateScope(CompensateScope element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(9);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			temp = element.getTarget();
			printCountingMap.put("target", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("CompensateScope");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printCompensateScope_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printCompensateScope_0(CompensateScope element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("target"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("target");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("target");
						if(count>0){
							Object o =element.getTarget();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("target")),element.eClass().getEStructuralFeature("target"),element));
							printCountingMap.put("target",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printCompensationHandler(CompensationHandler element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getActivity();
			printCountingMap.put("activity", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("CompensationHandler");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printCompensationHandler_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printCompensationHandler_0(CompensationHandler element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("activity"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("activity");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("activity");
						if(count>0){
							Object o =element.getActivity();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("activity",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printTo(To element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(10);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getVariable();
			printCountingMap.put("variable", temp == null ? 0 : 1);
			temp = element.getPart();
			printCountingMap.put("part", temp == null ? 0 : 1);
			temp = element.getPartnerLink();
			printCountingMap.put("partnerLink", temp == null ? 0 : 1);
			temp = element.getProperty();
			printCountingMap.put("property", temp == null ? 0 : 1);
			temp = element.getQuery();
			printCountingMap.put("query", temp == null ? 0 : 1);
			temp = element.getExpression();
			printCountingMap.put("expression", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("To");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printTo_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printTo_0(To element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("variable"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("part"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("partnerLink"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("property"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("query"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("expression"));
			if (tempMatchCount > matches) {
				alt = 9;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("variable");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("variable");
						if(count>0){
							Object o =element.getVariable();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("variable")),element.eClass().getEStructuralFeature("variable"),element));
							printCountingMap.put("variable",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("part");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("part");
						if(count>0){
							Object o =element.getPart();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("part")),element.eClass().getEStructuralFeature("part"),element));
							printCountingMap.put("part",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("partnerLink");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("partnerLink");
						if(count>0){
							Object o =element.getPartnerLink();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("partnerLink")),element.eClass().getEStructuralFeature("partnerLink"),element));
							printCountingMap.put("partnerLink",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("property");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("property");
						if(count>0){
							Object o =element.getProperty();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("property")),element.eClass().getEStructuralFeature("property"),element));
							printCountingMap.put("property",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("query");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("query");
						if(count>0){
							Object o =element.getQuery();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("query",count-1);
						}
					}
				break;
				case 9:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("expression");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("expression");
						if(count>0){
							Object o =element.getExpression();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("expression",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printFrom(From element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(16);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.isOpaque();
			printCountingMap.put("opaque", temp == null ? 0 : 1);
			temp = element.getEndpointReference();
			printCountingMap.put("endpointReference", temp == null ? 0 : 1);
			temp = element.getLiteral();
			printCountingMap.put("literal", temp == null ? 0 : 1);
			temp = element.isUnsafeLiteral();
			printCountingMap.put("unsafeLiteral", temp == null ? 0 : 1);
			temp = element.getExpression();
			printCountingMap.put("expression", temp == null ? 0 : 1);
			temp = element.getServiceRef();
			printCountingMap.put("serviceRef", temp == null ? 0 : 1);
			temp = element.getType();
			printCountingMap.put("type", temp == null ? 0 : 1);
			temp = element.getVariable();
			printCountingMap.put("variable", temp == null ? 0 : 1);
			temp = element.getPart();
			printCountingMap.put("part", temp == null ? 0 : 1);
			temp = element.getPartnerLink();
			printCountingMap.put("partnerLink", temp == null ? 0 : 1);
			temp = element.getProperty();
			printCountingMap.put("property", temp == null ? 0 : 1);
			temp = element.getQuery();
			printCountingMap.put("query", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("From");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printFrom_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printFrom_0(From element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("opaque"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("endpointReference"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("literal"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("unsafeLiteral"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("expression"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("serviceRef"));
			if (tempMatchCount > matches) {
				alt = 9;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("type"));
			if (tempMatchCount > matches) {
				alt = 10;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("variable"));
			if (tempMatchCount > matches) {
				alt = 11;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("part"));
			if (tempMatchCount > matches) {
				alt = 12;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("partnerLink"));
			if (tempMatchCount > matches) {
				alt = 13;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("property"));
			if (tempMatchCount > matches) {
				alt = 14;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("query"));
			if (tempMatchCount > matches) {
				alt = 15;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("opaque");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("opaque");
						if(count>0){
							Object o =element.isOpaque();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("opaque"),element));
				
							printCountingMap.put("opaque",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("endpointReference");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("endpointReference");
						if(count>0){
							Object o =element.getEndpointReference();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("endpointReference"),element));
				
							printCountingMap.put("endpointReference",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("literal");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("literal");
						if(count>0){
							Object o =element.getLiteral();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("literal"),element));
				
							printCountingMap.put("literal",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("unsafeLiteral");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("unsafeLiteral");
						if(count>0){
							Object o =element.isUnsafeLiteral();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("unsafeLiteral"),element));
				
							printCountingMap.put("unsafeLiteral",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("expression");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("expression");
						if(count>0){
							Object o =element.getExpression();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("expression",count-1);
						}
					}
				break;
				case 9:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("serviceRef");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("serviceRef");
						if(count>0){
							Object o =element.getServiceRef();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("serviceRef",count-1);
						}
					}
				break;
				case 10:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("type");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("type");
						if(count>0){
							Object o =element.getType();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("type")),element.eClass().getEStructuralFeature("type"),element));
							printCountingMap.put("type",count-1);
						}
					}
				break;
				case 11:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("variable");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("variable");
						if(count>0){
							Object o =element.getVariable();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("variable")),element.eClass().getEStructuralFeature("variable"),element));
							printCountingMap.put("variable",count-1);
						}
					}
				break;
				case 12:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("part");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("part");
						if(count>0){
							Object o =element.getPart();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("part")),element.eClass().getEStructuralFeature("part"),element));
							printCountingMap.put("part",count-1);
						}
					}
				break;
				case 13:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("partnerLink");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("partnerLink");
						if(count>0){
							Object o =element.getPartnerLink();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("partnerLink")),element.eClass().getEStructuralFeature("partnerLink"),element));
							printCountingMap.put("partnerLink",count-1);
						}
					}
				break;
				case 14:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("property");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("property");
						if(count>0){
							Object o =element.getProperty();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("property")),element.eClass().getEStructuralFeature("property"),element));
							printCountingMap.put("property",count-1);
						}
					}
				break;
				case 15:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("query");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("query");
						if(count>0){
							Object o =element.getQuery();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("query",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printOnMessage(OnMessage element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(11);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getVariable();
			printCountingMap.put("variable", temp == null ? 0 : 1);
			temp = element.getActivity();
			printCountingMap.put("activity", temp == null ? 0 : 1);
			temp = element.getPortType();
			printCountingMap.put("portType", temp == null ? 0 : 1);
			temp = element.getPartnerLink();
			printCountingMap.put("partnerLink", temp == null ? 0 : 1);
			temp = element.getCorrelations();
			printCountingMap.put("correlations", temp == null ? 0 : 1);
			temp = element.getOperation();
			printCountingMap.put("operation", temp == null ? 0 : 1);
			temp = element.getFromPart();
			printCountingMap.put("fromPart", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("OnMessage");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printOnMessage_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printOnMessage_0(OnMessage element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("variable"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("activity"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("portType"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("partnerLink"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("correlations"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("operation"));
			if (tempMatchCount > matches) {
				alt = 9;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("fromPart"));
			if (tempMatchCount > matches) {
				alt = 10;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("variable");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("variable");
						if(count>0){
							Object o =element.getVariable();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("variable")),element.eClass().getEStructuralFeature("variable"),element));
							printCountingMap.put("variable",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("activity");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("activity");
						if(count>0){
							Object o =element.getActivity();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("activity",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("portType");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("portType");
						if(count>0){
							Object o =element.getPortType();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("portType")),element.eClass().getEStructuralFeature("portType"),element));
							printCountingMap.put("portType",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("partnerLink");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("partnerLink");
						if(count>0){
							Object o =element.getPartnerLink();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("partnerLink")),element.eClass().getEStructuralFeature("partnerLink"),element));
							printCountingMap.put("partnerLink",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("correlations");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("correlations");
						if(count>0){
							Object o =element.getCorrelations();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("correlations",count-1);
						}
					}
				break;
				case 9:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("operation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("operation");
						if(count>0){
							Object o =element.getOperation();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("operation")),element.eClass().getEStructuralFeature("operation"),element));
							printCountingMap.put("operation",count-1);
						}
					}
				break;
				case 10:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("fromPart");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("fromPart");
						if(count>0){
							Object o =element.getFromPart();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("fromPart")),element.eClass().getEStructuralFeature("fromPart"),element));
							printCountingMap.put("fromPart",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printExpression(Expression element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(7);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.isRequired();
			printCountingMap.put("required", temp == null ? 0 : 1);
			temp = element.getElementType();
			printCountingMap.put("elementType", temp == null ? 0 : 1);
			temp = element.getBody();
			printCountingMap.put("body", temp == null ? 0 : 1);
			temp = element.getExpressionLanguage();
			printCountingMap.put("expressionLanguage", temp == null ? 0 : 1);
			temp = element.isOpaque();
			printCountingMap.put("opaque", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("required");
			if(count>0){
				Object o =element.isRequired();
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("required"),element));
				
				printCountingMap.put("required",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Expression");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printExpression_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printExpression_0(Expression element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("elementType"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("body"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("expressionLanguage"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("opaque"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("elementType");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("elementType");
						if(count>0){
							Object o =element.getElementType();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("elementType"),element));
				
							printCountingMap.put("elementType",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("body");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("body");
						if(count>0){
							Object o =element.getBody();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("body"),element));
				
							printCountingMap.put("body",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("expressionLanguage");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("expressionLanguage");
						if(count>0){
							Object o =element.getExpressionLanguage();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("expressionLanguage"),element));
				
							printCountingMap.put("expressionLanguage",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("opaque");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("opaque");
						if(count>0){
							Object o =element.isOpaque();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("opaque"),element));
				
							printCountingMap.put("opaque",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printBooleanExpression(BooleanExpression element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(7);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.isRequired();
			printCountingMap.put("required", temp == null ? 0 : 1);
			temp = element.getElementType();
			printCountingMap.put("elementType", temp == null ? 0 : 1);
			temp = element.getBody();
			printCountingMap.put("body", temp == null ? 0 : 1);
			temp = element.getExpressionLanguage();
			printCountingMap.put("expressionLanguage", temp == null ? 0 : 1);
			temp = element.isOpaque();
			printCountingMap.put("opaque", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("required");
			if(count>0){
				Object o =element.isRequired();
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("required"),element));
				
				printCountingMap.put("required",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("BooleanExpression");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printBooleanExpression_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printBooleanExpression_0(BooleanExpression element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("elementType"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("body"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("expressionLanguage"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("opaque"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("elementType");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("elementType");
						if(count>0){
							Object o =element.getElementType();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("elementType"),element));
				
							printCountingMap.put("elementType",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("body");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("body");
						if(count>0){
							Object o =element.getBody();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("body"),element));
				
							printCountingMap.put("body",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("expressionLanguage");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("expressionLanguage");
						if(count>0){
							Object o =element.getExpressionLanguage();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("expressionLanguage"),element));
				
							printCountingMap.put("expressionLanguage",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("opaque");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("opaque");
						if(count>0){
							Object o =element.isOpaque();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("opaque"),element));
				
							printCountingMap.put("opaque",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printCorrelation(Correlation element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(7);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getInitiate();
			printCountingMap.put("initiate", temp == null ? 0 : 1);
			temp = element.getPattern();
			printCountingMap.put("pattern", temp == null ? 0 : 1);
			temp = element.getSet();
			printCountingMap.put("set", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Correlation");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printCorrelation_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printCorrelation_0(Correlation element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("initiate"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("pattern"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("set"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("initiate");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("initiate");
						if(count>0){
							Object o =element.getInitiate();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("initiate"),element));
				
							printCountingMap.put("initiate",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("pattern");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("pattern");
						if(count>0){
							Object o =element.getPattern();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("pattern"),element));
				
							printCountingMap.put("pattern",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("set");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("set");
						if(count>0){
							Object o =element.getSet();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("set")),element.eClass().getEStructuralFeature("set"),element));
							printCountingMap.put("set",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printEventHandler(EventHandler element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(6);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getAlarm();
			printCountingMap.put("alarm", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getEvents();
			printCountingMap.put("events", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("EventHandler");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printEventHandler_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printEventHandler_0(EventHandler element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("alarm"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("events"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("alarm");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("alarm");
						if(count>0){
							Object o =element.getAlarm();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("alarm",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("events");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("events");
						if(count>0){
							Object o =element.getEvents();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("events",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printSource(Source element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(7);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getLink();
			printCountingMap.put("Link", temp == null ? 0 : 1);
			temp = element.getActivity();
			printCountingMap.put("activity", temp == null ? 0 : 1);
			temp = element.getTransitionCondition();
			printCountingMap.put("transitionCondition", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Source");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printSource_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printSource_0(Source element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("Link"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("activity"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("transitionCondition"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("Link");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("Link");
						if(count>0){
							Object o =element.getLink();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("Link")),element.eClass().getEStructuralFeature("Link"),element));
							printCountingMap.put("Link",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("activity");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("activity");
						if(count>0){
							Object o =element.getActivity();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("activity")),element.eClass().getEStructuralFeature("activity"),element));
							printCountingMap.put("activity",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("transitionCondition");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("transitionCondition");
						if(count>0){
							Object o =element.getTransitionCondition();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("transitionCondition",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printTarget(Target element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(6);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getLink();
			printCountingMap.put("Link", temp == null ? 0 : 1);
			temp = element.getActivity();
			printCountingMap.put("activity", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Target");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printTarget_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printTarget_0(Target element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("Link"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("activity"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("Link");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("Link");
						if(count>0){
							Object o =element.getLink();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("Link")),element.eClass().getEStructuralFeature("Link"),element));
							printCountingMap.put("Link",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("activity");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("activity");
						if(count>0){
							Object o =element.getActivity();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("activity")),element.eClass().getEStructuralFeature("activity"),element));
							printCountingMap.put("activity",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printPartnerLinks(PartnerLinks element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getChildren();
			printCountingMap.put("children", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("PartnerLinks");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printPartnerLinks_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printPartnerLinks_0(PartnerLinks element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("children"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("children");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("children");
						if(count>0){
							Object o =element.getChildren();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("children",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printVariables(Variables element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getChildren();
			printCountingMap.put("children", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Variables");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printVariables_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printVariables_0(Variables element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("children"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("children");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("children");
						if(count>0){
							Object o =element.getChildren();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("children",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printCorrelationSets(CorrelationSets element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getChildren();
			printCountingMap.put("children", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("CorrelationSets");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printCorrelationSets_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printCorrelationSets_0(CorrelationSets element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("children"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("children");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("children");
						if(count>0){
							Object o =element.getChildren();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("children",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printLinks(Links element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getChildren();
			printCountingMap.put("children", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Links");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printLinks_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printLinks_0(Links element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("children"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("children");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("children");
						if(count>0){
							Object o =element.getChildren();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("children",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printCatchAll(CatchAll element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getActivity();
			printCountingMap.put("activity", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("CatchAll");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printCatchAll_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printCatchAll_0(CatchAll element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("activity"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("activity");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("activity");
						if(count>0){
							Object o =element.getActivity();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("activity",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printCorrelations(Correlations element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getChildren();
			printCountingMap.put("children", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Correlations");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printCorrelations_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printCorrelations_0(Correlations element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("children"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("children");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("children");
						if(count>0){
							Object o =element.getChildren();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("children",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printVariable(Variable element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(9);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.getMessageType();
			printCountingMap.put("messageType", temp == null ? 0 : 1);
			temp = element.getXSDElement();
			printCountingMap.put("XSDElement", temp == null ? 0 : 1);
			temp = element.getType();
			printCountingMap.put("type", temp == null ? 0 : 1);
			temp = element.getFrom();
			printCountingMap.put("from", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Variable");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printVariable_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printVariable_0(Variable element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("messageType"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("XSDElement"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("type"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("from"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("messageType");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("messageType");
						if(count>0){
							Object o =element.getMessageType();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("messageType")),element.eClass().getEStructuralFeature("messageType"),element));
							printCountingMap.put("messageType",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("XSDElement");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("XSDElement");
						if(count>0){
							Object o =element.getXSDElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("XSDElement")),element.eClass().getEStructuralFeature("XSDElement"),element));
							printCountingMap.put("XSDElement",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("type");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("type");
						if(count>0){
							Object o =element.getType();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("type")),element.eClass().getEStructuralFeature("type"),element));
							printCountingMap.put("type",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("from");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("from");
						if(count>0){
							Object o =element.getFrom();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("from",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printUnknownExtensibilityAttribute(UnknownExtensibilityAttribute element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.isRequired();
			printCountingMap.put("required", temp == null ? 0 : 1);
			temp = element.getElementType();
			printCountingMap.put("elementType", temp == null ? 0 : 1);
			temp = element.getChildren();
			printCountingMap.put("children", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("required");
			if(count>0){
				Object o =element.isRequired();
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("required"),element));
				
				printCountingMap.put("required",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("UnknownExtensibilityAttribute");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printUnknownExtensibilityAttribute_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printUnknownExtensibilityAttribute_0(UnknownExtensibilityAttribute element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("elementType"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("children"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("elementType");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("elementType");
						if(count>0){
							Object o =element.getElementType();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("elementType"),element));
				
							printCountingMap.put("elementType",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("children");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("children");
						if(count>0){
							Object o =element.getChildren();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("children",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printOnEvent(OnEvent element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(13);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getActivity();
			printCountingMap.put("activity", temp == null ? 0 : 1);
			temp = element.getVariable();
			printCountingMap.put("variable", temp == null ? 0 : 1);
			temp = element.getPartnerLink();
			printCountingMap.put("partnerLink", temp == null ? 0 : 1);
			temp = element.getCorrelations();
			printCountingMap.put("correlations", temp == null ? 0 : 1);
			temp = element.getOperation();
			printCountingMap.put("operation", temp == null ? 0 : 1);
			temp = element.getPortType();
			printCountingMap.put("portType", temp == null ? 0 : 1);
			temp = element.getMessageType();
			printCountingMap.put("messageType", temp == null ? 0 : 1);
			temp = element.getFromPart();
			printCountingMap.put("fromPart", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getCorrelationSets();
			printCountingMap.put("correlationSets", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("OnEvent");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printOnEvent_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printOnEvent_0(OnEvent element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("activity"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("variable"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("partnerLink"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("correlations"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("operation"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("portType"));
			if (tempMatchCount > matches) {
				alt = 9;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("messageType"));
			if (tempMatchCount > matches) {
				alt = 10;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("fromPart"));
			if (tempMatchCount > matches) {
				alt = 11;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("correlationSets"));
			if (tempMatchCount > matches) {
				alt = 12;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("activity");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("activity");
						if(count>0){
							Object o =element.getActivity();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("activity",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("variable");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("variable");
						if(count>0){
							Object o =element.getVariable();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("variable",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("partnerLink");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("partnerLink");
						if(count>0){
							Object o =element.getPartnerLink();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("partnerLink")),element.eClass().getEStructuralFeature("partnerLink"),element));
							printCountingMap.put("partnerLink",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("correlations");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("correlations");
						if(count>0){
							Object o =element.getCorrelations();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("correlations",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("operation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("operation");
						if(count>0){
							Object o =element.getOperation();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("operation")),element.eClass().getEStructuralFeature("operation"),element));
							printCountingMap.put("operation",count-1);
						}
					}
				break;
				case 9:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("portType");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("portType");
						if(count>0){
							Object o =element.getPortType();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("portType")),element.eClass().getEStructuralFeature("portType"),element));
							printCountingMap.put("portType",count-1);
						}
					}
				break;
				case 10:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("messageType");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("messageType");
						if(count>0){
							Object o =element.getMessageType();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("messageType")),element.eClass().getEStructuralFeature("messageType"),element));
							printCountingMap.put("messageType",count-1);
						}
					}
				break;
				case 11:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("fromPart");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("fromPart");
						if(count>0){
							Object o =element.getFromPart();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("fromPart")),element.eClass().getEStructuralFeature("fromPart"),element));
							printCountingMap.put("fromPart",count-1);
						}
					}
				break;
				case 12:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("correlationSets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("correlationSets");
						if(count>0){
							Object o =element.getCorrelationSets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("correlationSets",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printImport(Import element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(7);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getNamespace();
			printCountingMap.put("namespace", temp == null ? 0 : 1);
			temp = element.getLocation();
			printCountingMap.put("location", temp == null ? 0 : 1);
			temp = element.getImportType();
			printCountingMap.put("importType", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Import");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printImport_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printImport_0(Import element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("namespace"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("location"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("importType"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("namespace");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("namespace");
						if(count>0){
							Object o =element.getNamespace();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("namespace"),element));
				
							printCountingMap.put("namespace",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("location");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("location");
						if(count>0){
							Object o =element.getLocation();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("location"),element));
				
							printCountingMap.put("location",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("importType");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("importType");
						if(count>0){
							Object o =element.getImportType();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("importType"),element));
				
							printCountingMap.put("importType",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printRethrow(Rethrow element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(8);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Rethrow");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printRethrow_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printRethrow_0(Rethrow element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printCondition(Condition element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(7);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.isRequired();
			printCountingMap.put("required", temp == null ? 0 : 1);
			temp = element.getElementType();
			printCountingMap.put("elementType", temp == null ? 0 : 1);
			temp = element.getBody();
			printCountingMap.put("body", temp == null ? 0 : 1);
			temp = element.getExpressionLanguage();
			printCountingMap.put("expressionLanguage", temp == null ? 0 : 1);
			temp = element.isOpaque();
			printCountingMap.put("opaque", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("required");
			if(count>0){
				Object o =element.isRequired();
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("required"),element));
				
				printCountingMap.put("required",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Condition");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printCondition_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printCondition_0(Condition element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("elementType"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("body"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("expressionLanguage"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("opaque"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("elementType");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("elementType");
						if(count>0){
							Object o =element.getElementType();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("elementType"),element));
				
							printCountingMap.put("elementType",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("body");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("body");
						if(count>0){
							Object o =element.getBody();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("body"),element));
				
							printCountingMap.put("body",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("expressionLanguage");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("expressionLanguage");
						if(count>0){
							Object o =element.getExpressionLanguage();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("expressionLanguage"),element));
				
							printCountingMap.put("expressionLanguage",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("opaque");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("opaque");
						if(count>0){
							Object o =element.isOpaque();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("opaque"),element));
				
							printCountingMap.put("opaque",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printTargets(Targets element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(6);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getChildren();
			printCountingMap.put("children", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getJoinCondition();
			printCountingMap.put("joinCondition", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Targets");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printTargets_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printTargets_0(Targets element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("children"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("joinCondition"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("children");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("children");
						if(count>0){
							Object o =element.getChildren();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("children",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("joinCondition");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("joinCondition");
						if(count>0){
							Object o =element.getJoinCondition();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("joinCondition",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printSources(Sources element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getChildren();
			printCountingMap.put("children", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Sources");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printSources_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printSources_0(Sources element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("children"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("children");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("children");
						if(count>0){
							Object o =element.getChildren();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("children",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printQuery(Query element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getValue();
			printCountingMap.put("value", temp == null ? 0 : 1);
			temp = element.getQueryLanguage();
			printCountingMap.put("queryLanguage", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Query");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printQuery_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printQuery_0(Query element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("value"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("queryLanguage"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("value");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("value");
						if(count>0){
							Object o =element.getValue();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("value"),element));
				
							printCountingMap.put("value",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("queryLanguage");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("queryLanguage");
						if(count>0){
							Object o =element.getQueryLanguage();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("queryLanguage"),element));
				
							printCountingMap.put("queryLanguage",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printServiceRef(ServiceRef element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getReferenceScheme();
			printCountingMap.put("referenceScheme", temp == null ? 0 : 1);
			temp = element.getValue();
			printCountingMap.put("value", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("ServiceRef");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printServiceRef_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printServiceRef_0(ServiceRef element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("referenceScheme"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("value"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("referenceScheme");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("referenceScheme");
						if(count>0){
							Object o =element.getReferenceScheme();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("referenceScheme"),element));
				
							printCountingMap.put("referenceScheme",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("value");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("value");
						if(count>0){
							Object o =element.getValue();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("value"),element));
				
							printCountingMap.put("value",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printExtensions(Extensions element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getChildren();
			printCountingMap.put("children", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Extensions");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printExtensions_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printExtensions_0(Extensions element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("children"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("children");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("children");
						if(count>0){
							Object o =element.getChildren();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("children",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printExtensionActivity(ExtensionActivity element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(8);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("ExtensionActivity");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printExtensionActivity_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printExtensionActivity_0(ExtensionActivity element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printFromPart(FromPart element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(6);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getPart();
			printCountingMap.put("part", temp == null ? 0 : 1);
			temp = element.getTo();
			printCountingMap.put("to", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("FromPart");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printFromPart_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printFromPart_0(FromPart element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("part"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("to"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("part");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("part");
						if(count>0){
							Object o =element.getPart();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("part"),element));
				
							printCountingMap.put("part",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("to");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("to");
						if(count>0){
							Object o =element.getTo();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("to")),element.eClass().getEStructuralFeature("to"),element));
							printCountingMap.put("to",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printToPart(ToPart element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(6);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getPart();
			printCountingMap.put("part", temp == null ? 0 : 1);
			temp = element.getFrom();
			printCountingMap.put("from", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("ToPart");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printToPart_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printToPart_0(ToPart element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("part"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("from"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("part");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("part");
						if(count>0){
							Object o =element.getPart();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("part"),element));
				
							printCountingMap.put("part",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("from");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("from");
						if(count>0){
							Object o =element.getFrom();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("from")),element.eClass().getEStructuralFeature("from"),element));
							printCountingMap.put("from",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printOpaqueActivity(OpaqueActivity element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(8);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("OpaqueActivity");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printOpaqueActivity_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printOpaqueActivity_0(OpaqueActivity element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printForEach(ForEach element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(14);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			temp = element.getStartCounterValue();
			printCountingMap.put("startCounterValue", temp == null ? 0 : 1);
			temp = element.getFinalCounterValue();
			printCountingMap.put("finalCounterValue", temp == null ? 0 : 1);
			temp = element.isParallel();
			printCountingMap.put("parallel", temp == null ? 0 : 1);
			temp = element.getCounterName();
			printCountingMap.put("counterName", temp == null ? 0 : 1);
			temp = element.getCompletionCondition();
			printCountingMap.put("completionCondition", temp == null ? 0 : 1);
			temp = element.getActivity();
			printCountingMap.put("activity", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("ForEach");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printForEach_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printForEach_0(ForEach element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("startCounterValue"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("finalCounterValue"));
			if (tempMatchCount > matches) {
				alt = 9;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("parallel"));
			if (tempMatchCount > matches) {
				alt = 10;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("counterName"));
			if (tempMatchCount > matches) {
				alt = 11;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("completionCondition"));
			if (tempMatchCount > matches) {
				alt = 12;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("activity"));
			if (tempMatchCount > matches) {
				alt = 13;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("startCounterValue");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("startCounterValue");
						if(count>0){
							Object o =element.getStartCounterValue();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("startCounterValue",count-1);
						}
					}
				break;
				case 9:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("finalCounterValue");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("finalCounterValue");
						if(count>0){
							Object o =element.getFinalCounterValue();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("finalCounterValue",count-1);
						}
					}
				break;
				case 10:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("parallel");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("parallel");
						if(count>0){
							Object o =element.isParallel();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("parallel"),element));
				
							printCountingMap.put("parallel",count-1);
						}
					}
				break;
				case 11:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("counterName");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("counterName");
						if(count>0){
							Object o =element.getCounterName();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("counterName",count-1);
						}
					}
				break;
				case 12:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("completionCondition");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("completionCondition");
						if(count>0){
							Object o =element.getCompletionCondition();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("completionCondition",count-1);
						}
					}
				break;
				case 13:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("activity");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("activity");
						if(count>0){
							Object o =element.getActivity();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("activity",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printRepeatUntil(RepeatUntil element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(10);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			temp = element.getActivity();
			printCountingMap.put("activity", temp == null ? 0 : 1);
			temp = element.getCondition();
			printCountingMap.put("condition", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("RepeatUntil");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printRepeatUntil_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printRepeatUntil_0(RepeatUntil element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("activity"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("condition"));
			if (tempMatchCount > matches) {
				alt = 9;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("activity");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("activity");
						if(count>0){
							Object o =element.getActivity();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("activity",count-1);
						}
					}
				break;
				case 9:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("condition");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("condition");
						if(count>0){
							Object o =element.getCondition();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("condition",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printTerminationHandler(TerminationHandler element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getActivity();
			printCountingMap.put("activity", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("TerminationHandler");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printTerminationHandler_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printTerminationHandler_0(TerminationHandler element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("activity"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("activity");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("activity");
						if(count>0){
							Object o =element.getActivity();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("activity",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printValidate(Validate element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(9);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			temp = element.getVariables();
			printCountingMap.put("variables", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Validate");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printValidate_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printValidate_0(Validate element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("variables"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("variables");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("variables");
						if(count>0){
							Object o =element.getVariables();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("variables")),element.eClass().getEStructuralFeature("variables"),element));
							printCountingMap.put("variables",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printIf(If element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(12);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			temp = element.getCondition();
			printCountingMap.put("condition", temp == null ? 0 : 1);
			temp = element.getElseIf();
			printCountingMap.put("elseIf", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getElse();
			printCountingMap.put("else", temp == null ? 0 : 1);
			temp = element.getActivity();
			printCountingMap.put("activity", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("If");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printIf_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printIf_0(If element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("condition"));
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("elseIf"));
			if (tempMatchCount > matches) {
				alt = 9;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("else"));
			if (tempMatchCount > matches) {
				alt = 10;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("activity"));
			if (tempMatchCount > matches) {
				alt = 11;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("condition");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("condition");
						if(count>0){
							Object o =element.getCondition();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("condition",count-1);
						}
					}
				break;
				case 9:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("elseIf");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("elseIf");
						if(count>0){
							Object o =element.getElseIf();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("elseIf",count-1);
						}
					}
				break;
				case 10:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("else");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("else");
						if(count>0){
							Object o =element.getElse();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("else",count-1);
						}
					}
				break;
				case 11:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("activity");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("activity");
						if(count>0){
							Object o =element.getActivity();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("activity",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printElseIf(ElseIf element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(6);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getCondition();
			printCountingMap.put("condition", temp == null ? 0 : 1);
			temp = element.getActivity();
			printCountingMap.put("activity", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("ElseIf");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printElseIf_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printElseIf_0(ElseIf element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("condition"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("activity"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("condition");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("condition");
						if(count>0){
							Object o =element.getCondition();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("condition",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("activity");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("activity");
						if(count>0){
							Object o =element.getActivity();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("activity",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printElse(Else element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getActivity();
			printCountingMap.put("activity", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Else");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printElse_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printElse_0(Else element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("activity"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("activity");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("activity");
						if(count>0){
							Object o =element.getActivity();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("activity",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printCompletionCondition(CompletionCondition element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getBranches();
			printCountingMap.put("branches", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("CompletionCondition");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printCompletionCondition_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printCompletionCondition_0(CompletionCondition element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("branches"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("branches");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("branches");
						if(count>0){
							Object o =element.getBranches();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("branches",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printBranches(Branches element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(8);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.isRequired();
			printCountingMap.put("required", temp == null ? 0 : 1);
			temp = element.getElementType();
			printCountingMap.put("elementType", temp == null ? 0 : 1);
			temp = element.getBody();
			printCountingMap.put("body", temp == null ? 0 : 1);
			temp = element.getExpressionLanguage();
			printCountingMap.put("expressionLanguage", temp == null ? 0 : 1);
			temp = element.isOpaque();
			printCountingMap.put("opaque", temp == null ? 0 : 1);
			temp = element.isCountCompletedBranchesOnly();
			printCountingMap.put("countCompletedBranchesOnly", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("required");
			if(count>0){
				Object o =element.isRequired();
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("required"),element));
				
				printCountingMap.put("required",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Branches");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printBranches_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printBranches_0(Branches element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("elementType"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("body"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("expressionLanguage"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("opaque"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("countCompletedBranchesOnly"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("elementType");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("elementType");
						if(count>0){
							Object o =element.getElementType();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("elementType"),element));
				
							printCountingMap.put("elementType",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("body");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("body");
						if(count>0){
							Object o =element.getBody();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("body"),element));
				
							printCountingMap.put("body",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("expressionLanguage");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("expressionLanguage");
						if(count>0){
							Object o =element.getExpressionLanguage();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("expressionLanguage"),element));
				
							printCountingMap.put("expressionLanguage",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("opaque");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("opaque");
						if(count>0){
							Object o =element.isOpaque();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("opaque"),element));
				
							printCountingMap.put("opaque",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("countCompletedBranchesOnly");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("countCompletedBranchesOnly");
						if(count>0){
							Object o =element.isCountCompletedBranchesOnly();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("countCompletedBranchesOnly"),element));
				
							printCountingMap.put("countCompletedBranchesOnly",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printExtensibleElement(ExtensibleElement element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("ExtensibleElement");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printExtensibleElement_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printExtensibleElement_0(ExtensibleElement element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printDocumentation(Documentation element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.getLang();
			printCountingMap.put("lang", temp == null ? 0 : 1);
			temp = element.getSource();
			printCountingMap.put("source", temp == null ? 0 : 1);
			temp = element.getValue();
			printCountingMap.put("value", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Documentation");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printDocumentation_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printDocumentation_0(Documentation element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("lang"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("source"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("value"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("source");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("source");
						if(count>0){
							Object o =element.getSource();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("source"),element));
				
							printCountingMap.put("source",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("value");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("value");
						if(count>0){
							Object o =element.getValue();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("value"),element));
				
							printCountingMap.put("value",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("lang");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("lang");
					if(count>0){
						Object o =element.getLang();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("lang"),element));
				
						printCountingMap.put("lang",count-1);
					}
			}
		}
		public void printMessageExchanges(MessageExchanges element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getChildren();
			printCountingMap.put("children", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("MessageExchanges");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printMessageExchanges_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printMessageExchanges_0(MessageExchanges element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("children"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("children");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("children");
						if(count>0){
							Object o =element.getChildren();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("children")),element.eClass().getEStructuralFeature("children"),element));
							printCountingMap.put("children",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printMessageExchange(MessageExchange element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("MessageExchange");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printMessageExchange_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printMessageExchange_0(MessageExchange element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		public void printCompensate(Compensate element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(8);
			Object temp;
			temp = element.getDocumentationElement();
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.getElement();
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.getEExtensibilityElements();
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getDocumentation();
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.isSuppressJoinFailure();
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.getTargets();
			printCountingMap.put("targets", temp == null ? 0 : 1);
			temp = element.getSources();
			printCountingMap.put("sources", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Compensate");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printCompensate_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printCompensate_0(Compensate element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("documentationElement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("element"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("eExtensibilityElements"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("documentation"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("suppressJoinFailure"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("targets"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("sources"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("element");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("element");
						if(count>0){
							Object o =element.getElement();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("element"),element));
				
							printCountingMap.put("element",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("eExtensibilityElements");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("eExtensibilityElements");
						if(count>0){
							Object o =element.getEExtensibilityElements();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("eExtensibilityElements",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("documentation");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("documentation");
						if(count>0){
							Object o =element.getDocumentation();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("documentation",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("suppressJoinFailure");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("suppressJoinFailure");
						if(count>0){
							Object o =element.isSuppressJoinFailure();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suppressJoinFailure"),element));
				
							printCountingMap.put("suppressJoinFailure",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("targets");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("targets");
						if(count>0){
							Object o =element.getTargets();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("targets",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("sources");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("sources");
						if(count>0){
							Object o =element.getSources();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("sources",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("documentationElement");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("documentationElement");
					if(count>0){
						Object o =element.getDocumentationElement();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("documentationElement"),element));
				
						printCountingMap.put("documentationElement",count-1);
					}
			}
		}
		}
