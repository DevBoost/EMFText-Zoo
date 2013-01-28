SYNTAXDEF xwpf
FOR <http://www.itu.dk/sdg/language/xwpf>
START Content,Document

IMPORTS {
	org.devboost.stanford.language:<http://www.devboost.org/stanford/language>
}

OPTIONS {
	licenceHeader = "platform:/resource/dk.itu.sdg.language.xwpf/metamodel/licenseComment.txt";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE INTEGER $('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT $('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}


TOKENSTYLES {
	"Content" COLOR #7F0055, BOLD;
	"nlpContent" COLOR #7F0055, BOLD;
	"Document" COLOR #7F0055, BOLD;
	"bodyElements" COLOR #7F0055, BOLD;
	"comments" COLOR #7F0055, BOLD;
	"endnotes" COLOR #7F0055, BOLD;
	"footers" COLOR #7F0055, BOLD;
	"footnotes" COLOR #7F0055, BOLD;
	"headers" COLOR #7F0055, BOLD;
	"hyperlinks" COLOR #7F0055, BOLD;
	"numbering" COLOR #7F0055, BOLD;
	"packagePictures" COLOR #7F0055, BOLD;
	"paragraphs" COLOR #7F0055, BOLD;
	"pictures" COLOR #7F0055, BOLD;
	"tables" COLOR #7F0055, BOLD;
	"BodyElement" COLOR #7F0055, BOLD;
	"Comment" COLOR #7F0055, BOLD;
	"Footnote" COLOR #7F0055, BOLD;
	"Footer" COLOR #7F0055, BOLD;
	"Header" COLOR #7F0055, BOLD;
	"Hyperlink" COLOR #7F0055, BOLD;
	"Numbering" COLOR #7F0055, BOLD;
	"PictureData" COLOR #7F0055, BOLD;
	"Paragraph" COLOR #7F0055, BOLD;
	"runs" COLOR #7F0055, BOLD;
	"part" COLOR #7F0055, BOLD;
	"body" COLOR #7F0055, BOLD;
	"Table" COLOR #7F0055, BOLD;
	"Run" COLOR #7F0055, BOLD;
	"Part" COLOR #7F0055, BOLD;
	"Body" COLOR #7F0055, BOLD;
	"Sentence" COLOR #7F0055, BOLD;
	"words" COLOR #7F0055, BOLD;
	"dependencies" COLOR #7F0055, BOLD;
	"Word" COLOR #7F0055, BOLD;
	"governors" COLOR #7F0055, BOLD;
	"dependents" COLOR #7F0055, BOLD;
	"PlainText" COLOR #7F0055, BOLD;
	"Dependency" COLOR #7F0055, BOLD;
	"governor" COLOR #7F0055, BOLD;
	"dependent" COLOR #7F0055, BOLD;
	"Dabbrev" COLOR #7F0055, BOLD;
	"Dacomp" COLOR #7F0055, BOLD;
	"Dadvcl" COLOR #7F0055, BOLD;
	"Dadvmod" COLOR #7F0055, BOLD;
	"Dagent" COLOR #7F0055, BOLD;
	"Damod" COLOR #7F0055, BOLD;
	"Dappos" COLOR #7F0055, BOLD;
	"Dattr" COLOR #7F0055, BOLD;
	"Daux" COLOR #7F0055, BOLD;
	"Dauxpass" COLOR #7F0055, BOLD;
	"Dcc" COLOR #7F0055, BOLD;
	"Dccomp" COLOR #7F0055, BOLD;
	"Dcomplm" COLOR #7F0055, BOLD;
	"Dconj" COLOR #7F0055, BOLD;
	"collapsedWord" COLOR #7F0055, BOLD;
	"Dcop" COLOR #7F0055, BOLD;
	"Dcsubj" COLOR #7F0055, BOLD;
	"Dcsubjpass" COLOR #7F0055, BOLD;
	"Ddep" COLOR #7F0055, BOLD;
	"Ddet" COLOR #7F0055, BOLD;
	"Ddobj" COLOR #7F0055, BOLD;
	"Dexpl" COLOR #7F0055, BOLD;
	"Dinfmod" COLOR #7F0055, BOLD;
	"Diobj" COLOR #7F0055, BOLD;
	"Dmark" COLOR #7F0055, BOLD;
	"Dmwe" COLOR #7F0055, BOLD;
	"Dneg" COLOR #7F0055, BOLD;
	"Dnn" COLOR #7F0055, BOLD;
	"Dnpadvmod" COLOR #7F0055, BOLD;
	"Dnsubj" COLOR #7F0055, BOLD;
	"Dnsubjpass" COLOR #7F0055, BOLD;
	"Dnum" COLOR #7F0055, BOLD;
	"Dnumber" COLOR #7F0055, BOLD;
	"Dparataxis" COLOR #7F0055, BOLD;
	"Dpartmod" COLOR #7F0055, BOLD;
	"Dpcomp" COLOR #7F0055, BOLD;
	"Dpobj" COLOR #7F0055, BOLD;
	"Dposs" COLOR #7F0055, BOLD;
	"Dpossessive" COLOR #7F0055, BOLD;
	"Dpreconj" COLOR #7F0055, BOLD;
	"Dpredet" COLOR #7F0055, BOLD;
	"Dprep" COLOR #7F0055, BOLD;
	"Dprepc" COLOR #7F0055, BOLD;
	"Dprt" COLOR #7F0055, BOLD;
	"Dpunct" COLOR #7F0055, BOLD;
	"Dpurpcl" COLOR #7F0055, BOLD;
	"Dquantmod" COLOR #7F0055, BOLD;
	"Drcmod" COLOR #7F0055, BOLD;
	"Dref" COLOR #7F0055, BOLD;
	"Drel" COLOR #7F0055, BOLD;
	"Dtmod" COLOR #7F0055, BOLD;
	"Dxcomp" COLOR #7F0055, BOLD;
	"Dxsubj" COLOR #7F0055, BOLD;
	"Droot" COLOR #7F0055, BOLD;
	"Collapse" COLOR #7F0055, BOLD;
	"NLPParagraph" COLOR #7F0055, BOLD;
	"sentences" COLOR #7F0055, BOLD;
}


RULES {
	Content ::= "Content" "{" !1 (text['"','"'])* !0 "}";
	Document ::= "Document" "{" !1 ( !0 "bodyElements" ":" bodyElements | !0 "comments" ":" comments | !0 "endnotes" ":" endnotes | !0 "footers" ":" footers | !0 "footnotes" ":" footnotes | !0 "headers" ":" headers | !0 "hyperlinks" ":" hyperlinks | !0 "numbering" ":" numbering | !0 "packagePictures" ":" packagePictures | !0 "paragraphs" ":" paragraphs | !0 "pictures" ":" pictures | !0 styles[unrecognized:"unrecognized", heading1:"Heading1", heading2:"Heading2", listParagraph:"ListParagraph", normal:"null"] | !0 "tables" ":" tables)* !0 "}";
	BodyElement ::= "BodyElement" ";";
	Comment ::= !0 "Comment" "{" (text['"','"'] | author['"','"'] | identifier['"','"'])* "}";
	Footnote ::= !0 "Footnote" "{" (text['"','"'])* "}";
	Footer ::= !0 "Footer" "{" (text['"','"'])* "}";
	Header ::= !0 "Header" "{" (text['"','"'])* "}";
	Hyperlink ::= !0 "Hyperlink" (identifier['"','"'] | url['"','"'])* ";";
	Numbering ::= !0 "Numbering" ";";
	PictureData ::= !0 "PictureData" ";";
	Paragraph ::= !0 "Paragraph" "{" !1 (!0 text['"','"'] | !0 "runs" ":" runs | !0 "part" ":" part | !0 "body" ":" body | !0 alignment[] | !0 borderBottom[] | !0 borderTop[] | !0 borderBetween[] | !0 borderLeft[] | !0 borderRight[] | !0 verticalAlignment[] | !0 footnoteText['"','"'] | !0 indentFstLine[] | !0 indentHanging[] | !0 indentLeft[] | !0 indentRight[] | !0 spacingAfter[] | !0 spacingAfterLines[] | !0 spacingBefore[] | !0 spacingBeforeLines[] | !0 spacingLineRule[] | !0 style[unrecognized:"unrecognized", heading1:"Heading1", heading2:"Heading2", listParagraph:"ListParagraph", normal:"null"])* !0 "}";
	Table ::= !0 "Table" ";";
	Run ::= isBold["isBold" : ""] isItalic["isItalic" : ""] isStrike["isStrike" : ""] "Run" "{" (text['"','"'] | fontFamily['"','"'] | fontSize[] | color['"','"'] | textPosition[])* "}";
	Part ::= !0 "Part" ";";
	Body ::= !0 "Body" ";";
}