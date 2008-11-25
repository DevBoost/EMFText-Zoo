SYNTAXDEF bpws
FOR <http://docs.oasis-open.org/wsbpel/2.0/process/executable>
START Process

TOKENS{
		DEFINE COMMENT$'//'(~('\n'|'\r'))*$;
		DEFINE INTEGER$('-')?('1'..'9')('0'..'9')*|'0'$;
		DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}

RULES{
		
		Process::= "Process"  ;
}