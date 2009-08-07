SYNTAXDEF fs
FOR <http://www.emftext.org/language/filesystem>
START Folder

OPTIONS {
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
}

RULES {
	Folder    ::= "Folder" name['"','"'] "{" contents* "}" ;
	PlainFile ::= "File" name['"','"'] ;
}