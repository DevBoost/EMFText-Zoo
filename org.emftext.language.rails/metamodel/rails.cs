//*******************************************************************************
// Copyright (c) 2006-2010 
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

SYNTAXDEF rails
FOR <http://www.emftext.org/language/rails>
START Project

OPTIONS {	
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
    generateCodeFromGeneratorModel = "true";
    reloadGeneratorModel = "true";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
}

TOKENSTYLES {
	"project" COLOR #000080, BOLD;
	"train" COLOR #000080, BOLD;
	"track" COLOR #000080, BOLD;
	"switch" COLOR #000080, BOLD;
	"connect" COLOR #000080, BOLD;
	"out:" COLOR #000080, BOLD;
	"in:" COLOR #000080, BOLD;
	"->" COLOR #000080, BOLD;
	"COMMENT" COLOR #008000;
}

RULES {
	
	Project ::= "project" (name[])? "{" 
			components* connections*
		"}";
	
	Train ::= "train" (name[])? ; 
	
	Track ::= "track" (name[])? 
		"{" 
			ports* 
			trains* 
		"}" ;
	
	Switch ::= "switch" (name[])?
		"{" 
			ports*
			trains* 
		"}" ;
	
	Connection ::= "connect" (name[])? source[] "->" target[] ;
	
	Out ::= "out:" (name[])? ;
	
	In  ::= "in:"  (name[])? ;
}