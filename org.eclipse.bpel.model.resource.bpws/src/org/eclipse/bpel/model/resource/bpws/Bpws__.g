lexer grammar Bpws;
@members {
	public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition       = new java.util.ArrayList<Integer>();

	public void reportError(RecognitionException e) {
		lexerExceptions.add(e);

		lexerExceptionsPosition.add(((ANTLRStringStream)input).index());
	}
}
@header {
package org.eclipse.bpel.model.resource.bpws;

}

T11 : 'Process' ;
T12 : '{' ;
T13 : 'documentationElement' ;
T14 : ':' ;
T15 : 'element' ;
T16 : 'eExtensibilityElements' ;
T17 : 'documentation' ;
T18 : 'name' ;
T19 : 'targetNamespace' ;
T20 : 'queryLanguage' ;
T21 : 'expressionLanguage' ;
T22 : 'suppressJoinFailure' ;
T23 : 'variableAccessSerializable' ;
T24 : 'partnerLinks' ;
T25 : 'variables' ;
T26 : 'activity' ;
T27 : 'faultHandlers' ;
T28 : 'eventHandlers' ;
T29 : 'correlationSets' ;
T30 : 'imports' ;
T31 : 'extensions' ;
T32 : 'exitOnStandardFault' ;
T33 : 'messageExchanges' ;
T34 : '}' ;
T35 : 'PartnerLink' ;
T36 : 'myRole' ;
T37 : 'partnerRole' ;
T38 : 'PartnerLinkType' ;
T39 : 'initializePartnerRole' ;
T40 : 'FaultHandler' ;
T41 : 'catch' ;
T42 : 'catchAll' ;
T43 : 'Activity' ;
T44 : 'targets' ;
T45 : 'sources' ;
T46 : 'CorrelationSet' ;
T47 : 'properties' ;
T48 : 'Invoke' ;
T49 : 'partnerLink' ;
T50 : 'correlations' ;
T51 : 'portType' ;
T52 : 'operation' ;
T53 : 'outputVariable' ;
T54 : 'inputVariable' ;
T55 : 'compensationHandler' ;
T56 : 'faultHandler' ;
T57 : 'toPart' ;
T58 : 'fromPart' ;
T59 : 'Link' ;
T60 : 'Catch' ;
T61 : 'faultName' ;
T62 : 'faultVariable' ;
T63 : 'faultMessageType' ;
T64 : 'faultElement' ;
T65 : 'Reply' ;
T66 : 'variable' ;
T67 : 'PartnerActivity' ;
T68 : 'Receive' ;
T69 : 'createInstance' ;
T70 : 'Exit' ;
T71 : 'Throw' ;
T72 : 'Wait' ;
T73 : 'for' ;
T74 : 'until' ;
T75 : 'Empty' ;
T76 : 'Sequence' ;
T77 : 'activities' ;
T78 : 'While' ;
T79 : 'condition' ;
T80 : 'Pick' ;
T81 : 'messages' ;
T82 : 'alarm' ;
T83 : 'Flow' ;
T84 : 'links' ;
T85 : 'completionCondition' ;
T86 : 'OnAlarm' ;
T87 : 'repeatEvery' ;
T88 : 'Assign' ;
T89 : 'copy' ;
T90 : 'validate' ;
T91 : 'Copy' ;
T92 : 'to' ;
T93 : 'from' ;
T94 : 'keepSrcElementName' ;
T95 : 'ignoreMissingFromData' ;
T96 : 'CompensateScope' ;
T97 : 'target' ;
T98 : 'CompensationHandler' ;
T99 : 'To' ;
T100 : 'part' ;
T101 : 'property' ;
T102 : 'query' ;
T103 : 'expression' ;
T104 : 'From' ;
T105 : 'opaque' ;
T106 : 'endpointReference' ;
T107 : 'literal' ;
T108 : 'unsafeLiteral' ;
T109 : 'serviceRef' ;
T110 : 'type' ;
T111 : 'OnMessage' ;
T112 : 'Expression' ;
T113 : 'elementType' ;
T114 : 'body' ;
T115 : 'BooleanExpression' ;
T116 : 'Correlation' ;
T117 : 'initiate' ;
T118 : 'pattern' ;
T119 : 'set' ;
T120 : 'EventHandler' ;
T121 : 'events' ;
T122 : 'Source' ;
T123 : 'transitionCondition' ;
T124 : 'Target' ;
T125 : 'PartnerLinks' ;
T126 : 'children' ;
T127 : 'Variables' ;
T128 : 'CorrelationSets' ;
T129 : 'Links' ;
T130 : 'CatchAll' ;
T131 : 'Correlations' ;
T132 : 'Variable' ;
T133 : 'messageType' ;
T134 : 'XSDElement' ;
T135 : 'UnknownExtensibilityAttribute' ;
T136 : 'OnEvent' ;
T137 : 'Import' ;
T138 : 'namespace' ;
T139 : 'location' ;
T140 : 'importType' ;
T141 : 'Rethrow' ;
T142 : 'Condition' ;
T143 : 'Targets' ;
T144 : 'joinCondition' ;
T145 : 'Sources' ;
T146 : 'Query' ;
T147 : 'value' ;
T148 : 'ServiceRef' ;
T149 : 'referenceScheme' ;
T150 : 'Extensions' ;
T151 : 'ExtensionActivity' ;
T152 : 'FromPart' ;
T153 : 'ToPart' ;
T154 : 'OpaqueActivity' ;
T155 : 'ForEach' ;
T156 : 'startCounterValue' ;
T157 : 'finalCounterValue' ;
T158 : 'parallel' ;
T159 : 'counterName' ;
T160 : 'RepeatUntil' ;
T161 : 'TerminationHandler' ;
T162 : 'Validate' ;
T163 : 'If' ;
T164 : 'elseIf' ;
T165 : 'else' ;
T166 : 'ElseIf' ;
T167 : 'Else' ;
T168 : 'CompletionCondition' ;
T169 : 'branches' ;
T170 : 'Branches' ;
T171 : 'countCompletedBranchesOnly' ;
T172 : 'ExtensibleElement' ;
T173 : 'Documentation' ;
T174 : 'lang' ;
T175 : 'source' ;
T176 : 'MessageExchanges' ;
T177 : 'MessageExchange' ;
T178 : 'Compensate' ;
T179 : 'mustUnderstand' ;

// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.eclipse.bpel.model.resource.bpws\src\org\eclipse\bpel\model\resource\bpws\Bpws.g" 4271
COMMENT
:
	'//'(~('\n'|'\r'))*{ channel=99; }
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.eclipse.bpel.model.resource.bpws\src\org\eclipse\bpel\model\resource\bpws\Bpws.g" 4275
INTEGER
:
	('-')?('1'..'9')('0'..'9')*|'0'{ channel=99; }
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.eclipse.bpel.model.resource.bpws\src\org\eclipse\bpel\model\resource\bpws\Bpws.g" 4279
FLOAT
:
	('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ { channel=99; }
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.eclipse.bpel.model.resource.bpws\src\org\eclipse\bpel\model\resource\bpws\Bpws.g" 4283
LB
:
	('\r\n' | '\r' | '\n'){ channel=99; }
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.eclipse.bpel.model.resource.bpws\src\org\eclipse\bpel\model\resource\bpws\Bpws.g" 4287
WS
:
	(' ' | '\t' | '\f'){ channel=99; }
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.eclipse.bpel.model.resource.bpws\src\org\eclipse\bpel\model\resource\bpws\Bpws.g" 4291
TEXT
:
	('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.eclipse.bpel.model.resource.bpws\src\org\eclipse\bpel\model\resource\bpws\Bpws.g" 4295
QUOTED_34_34
:
	('"')(~('"')|('\\''"'))*('"')
;
