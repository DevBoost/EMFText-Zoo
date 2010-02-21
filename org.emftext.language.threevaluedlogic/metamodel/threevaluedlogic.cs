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

RULES {
	@Leftassoc(weight="1", identifier="Formula")
	Or       ::= children "OR" children;
	
	@Leftassoc(weight="2", identifier="Formula")
	And      ::= children "AND" children;
	
	@Unary(weight="3", identifier="Formula")
	Negation ::= "NOT" body;
	
	@Primitive(weight="4", identifier="Formula")
	Nested   ::= "(" body ")";

	@Primitive(weight="4", identifier="Formula")
	Constant ::= value[];
}