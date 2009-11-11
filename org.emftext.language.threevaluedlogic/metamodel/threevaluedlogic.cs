//*******************************************************************************
// Copyright (c) 2006-2009 
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
START And, Or, Negation

OPTIONS {	
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	backtracking = "true";
	memoize = "true";
	reloadGeneratorModel = "true";
	tokenspace = "1";
}

RULES {
	And      ::= children:Or ("AND" children)*;
	Or       ::= (children:Negation,Nested, Constant) ("OR" children)*;
	Negation ::= "NOT" body:Nested, Constant;
	Nested   ::= "(" body:And ")";
	Constant ::= value[];
}