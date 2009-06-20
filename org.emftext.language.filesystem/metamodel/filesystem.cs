SYNTAXDEF fs
FOR <http://www.emftext.org/language/filesystem>
START Folder

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
}

RULES {
	Folder::= "Folder" "{" contents* "}" ;
	PlainFile::= "PlainFile"  "{"  "}" ;
}