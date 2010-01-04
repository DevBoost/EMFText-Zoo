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

SYNTAXDEF statemachine FOR <http://www.eclipse.org/uml2/3.0.0/UML> START StateMachine

OPTIONS {	
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	tokenspace = "1";
	resourcePluginID = "org.emftext.language.statemachine.resource.statemachine";
	basePackage = "org.emftext.language.statemachine.resource.statemachine";
}

TOKENS {
	DEFINE PSEUDOKIND $'initial'$ ;
}

RULES{	
  StateMachine  ::= "StateMachine" name[] "{" region "}" ;	
  Region        ::= subvertex* "transitions" "{" transition* "}";
  
  State         ::= "state" name[] "{" ("entry" ":" entry)? ("exit" ":" exit)? 
                    "do" ":" doActivity "}" ";";
  Pseudostate   ::=  kind[PSEUDOKIND] "state" name[] ";";
  FinalState    ::= "final" "state" name[] "{" ("entry" ":" entry)? ("exit" ":" exit)?
                    "do" ":" doActivity "}" ";"; 					
  
  Transition    ::= source[] "->" target[] "when" trigger 
                    ( "do" ":" effect )? ";";		
  Trigger       ::= name['"','"'];	
  Activity      ::= name['"','"'];										
}