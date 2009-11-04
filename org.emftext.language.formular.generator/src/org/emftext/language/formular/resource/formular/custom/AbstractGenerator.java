/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.formular.resource.formular.custom;

import org.emftext.language.formular.*;

public abstract class AbstractGenerator implements IGenerator {

	public byte[] generate(Object argument) {
		return generateString(argument).getBytes();
	}
	
	public abstract String generateString(Object argument);
	
	protected String erzeugeFragenAdresse(Option option){
		Frage frage = (Frage)option.eContainer().eContainer();
		return erzeugeFragenAdresse(frage);
	}
	
	protected String erzeugeFragenAdresse(Frage frage){
		Gruppe gruppe = (Gruppe)frage.eContainer();
		String suffix = "."+(gruppe.getFragen().indexOf(frage)+1);
		Formular formular = (Formular)gruppe.eContainer();
		return (formular.getGruppen().indexOf(gruppe)+1)+suffix;
	}
	
}
