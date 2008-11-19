SYNTAXDEF bpws
FOR <http://docs.oasis-open.org/wsbpel/2.0/process/executable>
START Process

TOKENS{
		DEFINE COMMENT$'//'(~('\n'|'\r'))*$;
		DEFINE INTEGER$('-')?('1'..'9')('0'..'9')*|'0'$;
		DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}

RULES{
		
		Process::= "Process"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "targetNamespace"  ":" targetNamespace['"','"'] | "queryLanguage"  ":" queryLanguage['"','"'] | "expressionLanguage"  ":" expressionLanguage['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "variableAccessSerializable"  ":" variableAccessSerializable[]| "partnerLinks"  ":" partnerLinks | "variables"  ":" variables | "activity"  ":" activity | "faultHandlers"  ":" faultHandlers | "eventHandlers"  ":" eventHandlers | "correlationSets"  ":" correlationSets | "imports"  ":" imports | "extensions"  ":" extensions | "exitOnStandardFault"  ":" exitOnStandardFault[]| "messageExchanges"  ":" messageExchanges[] )* "}"  ;
		
		PartnerLink::= "PartnerLink"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "myRole"  ":" myRole[]| "partnerRole"  ":" partnerRole[]| "PartnerLinkType"  ":" PartnerLinkType[]| "initializePartnerRole"  ":" initializePartnerRole[] )* "}"  ;
		
		FaultHandler::= "FaultHandler"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "catch"  ":" catch | "catchAll"  ":" catchAll  )* "}"  ;
		
		Activity::= "Activity"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources  )* "}"  ;
		
		CorrelationSet::= "CorrelationSet"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "properties"  ":" properties[] )* "}"  ;
		
		Invoke::= "Invoke"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources | "partnerLink"  ":" partnerLink[]| "correlations"  ":" correlations | "portType"  ":" portType[]| "operation"  ":" operation[]| "outputVariable"  ":" outputVariable[]| "inputVariable"  ":" inputVariable[]| "compensationHandler"  ":" compensationHandler | "faultHandler"  ":" faultHandler | "toPart"  ":" toPart[]| "fromPart"  ":" fromPart[] )* "}"  ;
		
		Link::= "Link"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "sources"  ":" sources[]| "targets"  ":" targets[] )* "}"  ;
		
		Catch::= "Catch"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "faultName"  ":" faultName[]| "faultVariable"  ":" faultVariable | "activity"  ":" activity | "faultMessageType"  ":" faultMessageType[]| "faultElement"  ":" faultElement[] )* "}"  ;
		
		Reply::= "Reply"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources | "partnerLink"  ":" partnerLink[]| "correlations"  ":" correlations | "portType"  ":" portType[]| "operation"  ":" operation[]| "faultName"  ":" faultName[]| "variable"  ":" variable[]| "toPart"  ":" toPart[] )* "}"  ;
		
		PartnerActivity::= "PartnerActivity"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources | "partnerLink"  ":" partnerLink[]| "correlations"  ":" correlations | "portType"  ":" portType[]| "operation"  ":" operation[] )* "}"  ;
		
		Receive::= "Receive"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources | "partnerLink"  ":" partnerLink[]| "correlations"  ":" correlations | "portType"  ":" portType[]| "operation"  ":" operation[]| "createInstance"  ":" createInstance[]| "variable"  ":" variable[]| "fromPart"  ":" fromPart[] )* "}"  ;
		
		Exit::= "Exit"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources  )* "}"  ;
		
		Throw::= "Throw"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources | "faultName"  ":" faultName[]| "faultVariable"  ":" faultVariable[] )* "}"  ;
		
		Wait::= "Wait"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources | "for"  ":" for | "until"  ":" until  )* "}"  ;
		
		Empty::= "Empty"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources  )* "}"  ;
		
		Sequence::= "Sequence"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources | "activities"  ":" activities  )* "}"  ;
		
		While::= "While"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources | "activity"  ":" activity | "condition"  ":" condition  )* "}"  ;
		
		Pick::= "Pick"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources | "createInstance"  ":" createInstance[]| "messages"  ":" messages | "alarm"  ":" alarm  )* "}"  ;
		
		Flow::= "Flow"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources | "activities"  ":" activities | "links"  ":" links | "completionCondition"  ":" completionCondition  )* "}"  ;
		
		OnAlarm::= "OnAlarm"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "activity"  ":" activity | "for"  ":" for | "until"  ":" until | "repeatEvery"  ":" repeatEvery  )* "}"  ;
		
		Assign::= "Assign"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources | "copy"  ":" copy | "validate"  ":" validate[] )* "}"  ;
		
		Copy::= "Copy"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "to"  ":" to | "from"  ":" from | "keepSrcElementName"  ":" keepSrcElementName[]| "ignoreMissingFromData"  ":" ignoreMissingFromData[] )* "}"  ;
		
		Extension::= "Extension"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "namespace"  ":" namespace['"','"'] | "mustUnderstand"  ":" mustUnderstand[] )* "}"  ;
		
		Scope::= "Scope"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources | "isolated"  ":" isolated[]| "faultHandlers"  ":" faultHandlers | "compensationHandler"  ":" compensationHandler | "activity"  ":" activity | "variables"  ":" variables | "correlationSets"  ":" correlationSets | "eventHandlers"  ":" eventHandlers | "partnerLinks"  ":" partnerLinks | "terminationHandler"  ":" terminationHandler | "messageExchanges"  ":" messageExchanges[]| "exitOnStandardFault"  ":" exitOnStandardFault[] )* "}"  ;
		
		CompensateScope::= "CompensateScope"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources | "target"  ":" target[] )* "}"  ;
		
		CompensationHandler::= "CompensationHandler"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "activity"  ":" activity  )* "}"  ;
		
		To::= "To"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "variable"  ":" variable[]| "part"  ":" part[]| "partnerLink"  ":" partnerLink[]| "property"  ":" property[]| "query"  ":" query | "expression"  ":" expression  )* "}"  ;
		
		From::= "From"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "opaque"  ":" opaque[]| "endpointReference"  ":" endpointReference[]| "literal"  ":" literal['"','"'] | "unsafeLiteral"  ":" unsafeLiteral[]| "expression"  ":" expression | "serviceRef"  ":" serviceRef | "type"  ":" type[]| "variable"  ":" variable[]| "part"  ":" part[]| "partnerLink"  ":" partnerLink[]| "property"  ":" property[]| "query"  ":" query  )* "}"  ;
		
		OnMessage::= "OnMessage"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "variable"  ":" variable[]| "activity"  ":" activity | "portType"  ":" portType[]| "partnerLink"  ":" partnerLink[]| "correlations"  ":" correlations | "operation"  ":" operation[]| "fromPart"  ":" fromPart[] )* "}"  ;
		
		Expression::=required[]? "Expression"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "elementType"  ":" elementType[]| "body"  ":" body[]| "expressionLanguage"  ":" expressionLanguage['"','"'] | "opaque"  ":" opaque[] )* "}"  ;
		
		BooleanExpression::=required[]? "BooleanExpression"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "elementType"  ":" elementType[]| "body"  ":" body[]| "expressionLanguage"  ":" expressionLanguage['"','"'] | "opaque"  ":" opaque[] )* "}"  ;
		
		Correlation::= "Correlation"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "initiate"  ":" initiate['"','"'] | "pattern"  ":" pattern[]| "set"  ":" set[] )* "}"  ;
		
		EventHandler::= "EventHandler"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "alarm"  ":" alarm | "events"  ":" events  )* "}"  ;
		
		Source::= "Source"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "Link"  ":" Link[]| "activity"  ":" activity[]| "transitionCondition"  ":" transitionCondition  )* "}"  ;
		
		Target::= "Target"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "Link"  ":" Link[]| "activity"  ":" activity[] )* "}"  ;
		
		PartnerLinks::= "PartnerLinks"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "children"  ":" children  )* "}"  ;
		
		Variables::= "Variables"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "children"  ":" children  )* "}"  ;
		
		CorrelationSets::= "CorrelationSets"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "children"  ":" children  )* "}"  ;
		
		Links::= "Links"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "children"  ":" children  )* "}"  ;
		
		CatchAll::= "CatchAll"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "activity"  ":" activity  )* "}"  ;
		
		Correlations::= "Correlations"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "children"  ":" children  )* "}"  ;
		
		Variable::= "Variable"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "messageType"  ":" messageType[]| "XSDElement"  ":" XSDElement[]| "type"  ":" type[]| "from"  ":" from  )* "}"  ;
		
		UnknownExtensibilityAttribute::=required[]? "UnknownExtensibilityAttribute"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "elementType"  ":" elementType[]| "children"  ":" children  )* "}"  ;
		
		OnEvent::= "OnEvent"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "activity"  ":" activity | "variable"  ":" variable | "partnerLink"  ":" partnerLink[]| "correlations"  ":" correlations | "operation"  ":" operation[]| "portType"  ":" portType[]| "messageType"  ":" messageType[]| "fromPart"  ":" fromPart[]| "correlationSets"  ":" correlationSets  )* "}"  ;
		
		Import::= "Import"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "namespace"  ":" namespace['"','"'] | "location"  ":" location['"','"'] | "importType"  ":" importType['"','"']  )* "}"  ;
		
		Rethrow::= "Rethrow"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources  )* "}"  ;
		
		Condition::=required[]? "Condition"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "elementType"  ":" elementType[]| "body"  ":" body[]| "expressionLanguage"  ":" expressionLanguage['"','"'] | "opaque"  ":" opaque[] )* "}"  ;
		
		Targets::= "Targets"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "children"  ":" children | "joinCondition"  ":" joinCondition  )* "}"  ;
		
		Sources::= "Sources"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "children"  ":" children  )* "}"  ;
		
		Query::= "Query"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "value"  ":" value['"','"'] | "queryLanguage"  ":" queryLanguage['"','"']  )* "}"  ;
		
		ServiceRef::= "ServiceRef"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "referenceScheme"  ":" referenceScheme['"','"'] | "value"  ":" value[] )* "}"  ;
		
		Extensions::= "Extensions"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "children"  ":" children  )* "}"  ;
		
		ExtensionActivity::= "ExtensionActivity"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources  )* "}"  ;
		
		FromPart::= "FromPart"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "part"  ":" part['"','"'] | "to"  ":" to[] )* "}"  ;
		
		ToPart::= "ToPart"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "part"  ":" part['"','"'] | "from"  ":" from[] )* "}"  ;
		
		OpaqueActivity::= "OpaqueActivity"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources  )* "}"  ;
		
		ForEach::= "ForEach"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources | "startCounterValue"  ":" startCounterValue | "finalCounterValue"  ":" finalCounterValue | "parallel"  ":" parallel[]| "counterName"  ":" counterName | "completionCondition"  ":" completionCondition | "activity"  ":" activity  )* "}"  ;
		
		RepeatUntil::= "RepeatUntil"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources | "activity"  ":" activity | "condition"  ":" condition  )* "}"  ;
		
		TerminationHandler::= "TerminationHandler"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "activity"  ":" activity  )* "}"  ;
		
		Validate::= "Validate"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources | "variables"  ":" variables[] )* "}"  ;
		
		If::= "If"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources | "condition"  ":" condition | "elseIf"  ":" elseIf | "else"  ":" else | "activity"  ":" activity  )* "}"  ;
		
		ElseIf::= "ElseIf"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "condition"  ":" condition | "activity"  ":" activity  )* "}"  ;
		
		Else::= "Else"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "activity"  ":" activity  )* "}"  ;
		
		CompletionCondition::= "CompletionCondition"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "branches"  ":" branches  )* "}"  ;
		
		Branches::=required[]? "Branches"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "elementType"  ":" elementType[]| "body"  ":" body[]| "expressionLanguage"  ":" expressionLanguage['"','"'] | "opaque"  ":" opaque[]| "countCompletedBranchesOnly"  ":" countCompletedBranchesOnly[] )* "}"  ;
		
		ExtensibleElement::= "ExtensibleElement"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation  )* "}"  ;
		
		Documentation::= "Documentation"  "{" ( "lang"  ":" lang['"','"'] | "source"  ":" source['"','"'] | "value"  ":" value['"','"']  )* "}"  ;
		
		MessageExchanges::= "MessageExchanges"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "children"  ":" children[] )* "}"  ;
		
		MessageExchange::= "MessageExchange"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"']  )* "}"  ;
		
		Compensate::= "Compensate"  "{" ( "documentationElement"  ":" documentationElement[]| "element"  ":" element[]| "eExtensibilityElements"  ":" eExtensibilityElements | "documentation"  ":" documentation | "name"  ":" name['"','"'] | "suppressJoinFailure"  ":" suppressJoinFailure[]| "targets"  ":" targets | "sources"  ":" sources  )* "}"  ;
		
}