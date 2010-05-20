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

SYNTAXDEF tvl
FOR <http://www.emftext.org/language/threevaluedlogic>
START Formula

OPTIONS {	
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	backtracking = "true";
	memoize = "true";
	reloadGeneratorModel = "true";
	tokenspace = "1";
}

TOKENSTYLES {
	"OR" COLOR #00a5f2, BOLD;
	"AND" COLOR #00a5f2, BOLD;
	"NOT" COLOR #00a5f2, BOLD;
	"(" COLOR #00a5f2, BOLD;
	")" COLOR #00a5f2, BOLD;
}

RULES {
	@operator(type="binary_left_associative",weight="1", identifier="Formula")
	Or       ::= children "OR" children;
	
	@operator(type="binary_left_associative",weight="2", identifier="Formula")
	And      ::= children "AND" children;
	
	@operator(type="unary_prefix", weight="3", identifier="Formula")
	Negation ::= "NOT" body;
	
	@operator(type="primitive", weight="4", identifier="Formula")
	Nested   ::= "(" body ")";

	@operator(type="primitive", weight="4", identifier="Formula")
	Constant ::= value[];
}