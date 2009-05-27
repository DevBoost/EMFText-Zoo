/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
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
