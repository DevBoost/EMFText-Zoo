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

SYNTAXDEF simplegui
FOR <http://www.emftext.org/language/simple_gui>
START Frame

OPTIONS {	
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	tokenspace = "1";
}

RULES {
	Frame ::= "F" "(" name[] ")" "contains" children* ";";
	
	Panel ::= "P" "(" name[] ")" "contains" children* ";";
	
	Button ::= "B" "(" name[] ")";

	Label ::= "L" "(" name[] ")";
	
	Image ::= "I" "(" key[] ")";
}