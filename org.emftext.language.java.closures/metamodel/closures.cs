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

SYNTAXDEF closure
FOR <http://emftext.org/language/closures>
START java.Containers.CompilationUnit, java.Containers.EmptyModel
 
IMPORTS {
	java : <http://www.emftext.org/java> WITH SYNTAX java <../../org.emftext.language.java/metamodel/java.cs>
}

OPTIONS {	
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	defaultTokenName = "IDENTIFIER";
	usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel="true";

}

RULES {
	Closure ::= "{" (parameterTypes ("," parameterTypes)*)? "=>" valueType  "}" closureName[]? ( "=" "{" (parameters ("," parameters)*)? "=>" statements+  "}" ( "." methodName[] "(" (arguments ("," arguments)*)? ")" )? ";" )? ;

	ClosureCall ::= "{" closure[]? "}" "." methodName[] "(" (arguments ("," arguments)*)? ")" ";" ;

	ParameterClosureAssignment ::= "{" (parameters ("," parameters)*)? "=>" statements+  "}";

}


//{ => System.out.println("Hallo Welt"); }.invoke(); 
