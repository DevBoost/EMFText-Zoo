//*******************************************************************************
// Copyright (c) 2011 
// Software Technology Group, Dresden University of Technology
// 
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0 
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
// 
// Contributors:
//   Software Technology Group - TU Dresden, Germany 
//      - initial API and implementation
// ******************************************************************************/
SYNTAXDEF bib
FOR <http://www.emftext.org/language/bibtex>
START Bibliography

OPTIONS {
	usePredefinedTokens = "false";
	overridePluginXML = "false";
	reloadGeneratorModel = "true";
	additionalDependencies = "org.emftext.language.pacad.util";
	overrideDefaultResolverDelegate = "false";
	overrideTextResource = "false";
	//disableTokenSorting = "true";
}

TOKENS {
	DEFINE COMMENT $'%'(~('\n'|'\r'))*$;
	DEFINE YEAR $('1' |'2')('0'..'9')('0'..'9')('0'..'9')$;
	DEFINE INTEGER $('0'..'9')+$;
	DEFINE TEXT $('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'-'|'.')+$;
	//DEFINE WHITESPACETEXT $(('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'-')+((' ')('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'-'))*)+$;
	DEFINE WHITESPACE $(' ' | '\t' | '\f')+$;
	DEFINE LINEBREAK $('\r\n' | '\r' | '\n')$;
}

TOKENSTYLES {
	"COMMENT" COLOR #008000;
	"@INPROCEEDINGS" COLOR #000080;
	"@ARTICLE" COLOR #000080;
}


RULES {
	// syntax definition for class 'Bibliography'
	Bibliography ::= entries*;
	
	BibtexKeyField ::= value[TEXT];
	
	TitleField ::= "title" "=" #1  value['"','"'] ;
	BookTitleField ::= "booktitle" "=" #1 value['"','"'];
	YearField ::= "year" "=" #1 "{" value[YEAR] "}";
	
	AuthorField ::= "author" "=" #1 "{" authors ("and" authors)* "}" ;
	Author ::= firstName[TEXT] (secondName[TEXT] )? lastName[TEXT] ;

	EditorField ::= "editor" "=" #1 "{" editors ("and" editors)* "}" ;
	Editor ::= firstName[TEXT] (secondName[TEXT] )? lastName[TEXT] ;

	JournalField ::= "journal" "=" #1 "{" value[TEXT] "}";

	VolumeField ::= "volume" "=" #1 "{" (value[INTEGER])"}";

	PageField ::= "pages" "=" #1 "{" fromPage ("--" toPage)? "}";
	Page ::= value[INTEGER];

	NumberField ::= "number" "=" #1 "{" value[INTEGER] "}";
	SeriesField ::= "series" "=" #1  value['"','"'] ;

	AddressField ::= "address" "=" #1  value['"','"'] ;
	MonthField ::= "month" "=" #1  value['"','"'] ;
	OrganizationField ::= "organization" "=" #1  value['"','"'] ;
	PublisherField ::= "publisher" "=" #1  value['"','"'] ;
	NoteField ::= "note" "=" #1  value['"','"'] ;
	PartField ::= "part" "=" #1  "{" value[INTEGER] "}" ;
	EidField ::= "eid" "=" #1  value['"','"'] ;

	InProceedingsEntry ::= "@INPROCEEDINGS" "{" !1 
		bibtexKey #1
		// title, bookTitle, year, author are required 
		("," !1 ((title) | (bookTitle) | (year) | (author)))+ 
		// editor, volume, number, series, pages, address, month, organization, publisher, note are optional
		("," !1 ((editor) | (volume) | (number) | (series) | (pages) | (address) | (month) | (organization) | (publisher) | (note) ))*		
	!1 "}";

	ArticleEntry ::= "@ARTICLE" "{" !1 
		bibtexKey #1
		// title, journal, volume, year, author, pages are required 
		("," !1 ((title) | (journal) | (volume)| (year) | (author) | (pages)))+ 
		// number, month, part, eid, note
		("," !1 ((number) | (month) | (part)| (eid) | (note) ))* 
	!1 "}";

	

}