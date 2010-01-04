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

SYNTAXDEF conference
FOR <http://www.emftext.org/language/conference>

START Conference

OPTIONS {
 	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	tokenspace = "1";
}

TOKENSTYLES {
	"QUOTED_34_34" COLOR #404040;
}

RULES {
	Conference ::= 
		"CONFERENCE" name['"','"'] 
		"(" organizers['"','"'] ("," organizers['"','"'])* ")" 
	    ( elements )* 
	    "REGISTERED" "SPEAKERS" ":" speakers ("," speakers)*;
		
	Participant ::= name['"','"'] "FROM" country [];
		
	Talk ::= "TALK" name['"','"'] "PRESENTED" "BY" presenter['"','"'];
		
	Track ::= "TRACK" name['"','"'] ":" slots*;
		
	Slot ::= "AT" hour[] ":" minute[] ":" talk;
	
	Lunch ::= "AT" hour[] ":" minute[] "LUNCH";
}