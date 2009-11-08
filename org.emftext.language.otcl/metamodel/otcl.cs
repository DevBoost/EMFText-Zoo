SYNTAXDEF tcl
FOR <http://www.emftext.org/language/otcl>
START OTclScript

OPTIONS {
	usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
}

TOKENS{
	DEFINE T_NONEWLINE $'-''nonewline'$;
	DEFINE COMMENT $'#'(~('\r\n'|'\r'|'\n'))*$;
	DEFINE WS      $(' '|'\t'|'\f')+$;
	DEFINE TEXT    $(~('\r\n'|'\r'|'\n'|' '|'\t'|'\f'|'\u0024'|'#'|'['|']'|'{'|'}'|'"'|';'))+$;
	//$ = \u0024
}

TOKENSTYLES {
	"COMMENT" COLOR #000080, ITALIC;

}

RULES{
	OTclScript::= (commands ("\\r\\n" | ";" |"\\n" | "\\r")+)*;
	
	//Words
	Compound::= "\"" ("\\r\\n" | ";" |"\\n" | "\\r")* commands? (("\\r\\n" | ";" |"\\n" | "\\r")+ commands)* ("\\r\\n" | ";" |"\\n" | "\\r")* "\"";
	
	Block::=    "{"  ("\\r\\n" | ";" |"\\n" | "\\r")* commands? (("\\r\\n" | ";" |"\\n" | "\\r")+ commands)* ("\\r\\n" | ";" |"\\n" | "\\r")* "}";
	
	Word::= value[];
	
	VariableSubstitution::= "$" setting[];
	
	CommandSubstitution::= "[" command "]";
	
	Self::= "$self";	
	
	//Commands
	Comment::= value[COMMENT];
	
	ProcedureCall::= procedure arguments*;

	Procedure::= "proc" name arguments body;
	
	Set::= "set" variable value?;
	
	Expr::= "expr"  arguments+;
	
	If::= "if" ifExpression (("then")? ifBody) ("elseif" elseIfExpressions elseIfBodies)* ("else" elseBody)?;
	
	For::= "for" start test next body;
	
	Puts::= "puts" (nonewline[T_NONEWLINE])? channelId? string;
	
	Class::= "class" name ("-superclass" superclass)?;
	
	InstanceProcedure::= class "instproc" name arguments body;
	
	New::= "new" class;
	

	
	//TODO complete list of build-in commands: http://www.tcl.tk/man/tcl8.4/TclCmd/contents.htm
	
}