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

SYNTAXDEF ucinv
FOR <http://www.emftext.org/language/UseCaseInvariant>
START UseCaseModel

OPTIONS {	
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	reloadGeneratorModel = "true";
	tokenspace = "1";
}

TOKENSTYLES {
	"TEXT" COLOR #000000;
	
	"invariants" COLOR #7F0055, BOLD;
	"actor" COLOR #7F0055, BOLD;
	"counter" COLOR #7F0055, BOLD;
	"set" COLOR #7F0055, BOLD;
	"of" COLOR #7F0055, BOLD;
	"excluding" COLOR #7F0055, BOLD;
	"including" COLOR #7F0055, BOLD;
}

RULES {

UseCaseModel 
   ::=
        "invariants" "for" name[] ":" (!1 invariants)* !0 "."
	;

NormalActor
   ::=
        "actor" name[] ":" "[" (valuesBefore (#0 "," valuesBefore)*)? "]" "-->" "[" (valuesAfter (#0 "," valuesAfter)*)? "]" "."
	;

CounterActor
   ::=
        "counter" name[] ":" "[" (valuesBefore (#0 "," valuesBefore)*)? "]" "-->" "[" (valuesAfter (#0 "," valuesAfter)*)? "]" "."
	;

SingleValue 
   ::=
        type[] ("(" #0 ID[] #0 ")")?
	;

SetOfValues
   ::=
        "set" "of" type[] ("excluding" excluding)? ("including" including)?
	;
}