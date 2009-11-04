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
package org.emftext.language.forms.resource.forms.custom;

import org.emftext.language.forms.Form;
import org.emftext.language.forms.Group;
import org.emftext.language.forms.Item;
import org.emftext.language.forms.Option;

public abstract class AbstractGenerator implements IGenerator {

	public byte[] generate(Object argument) {
		return generateString(argument).getBytes();
	}
	
	public abstract String generateString(Object argument);
	
	protected String generateItemAddress(Option option){
		Item item = (Item)option.eContainer().eContainer();
		return generateItemAddress(item);
	}
	
	protected String generateItemAddress(Item item){
		Group group = (Group)item.eContainer();
		String suffix = "."+(group.getItems().indexOf(item)+1);
		Form form = (Form)group.eContainer();
		return (form.getGroups().indexOf(group)+1)+suffix;
	}
	
	protected String generateItemText(Option option) {
		Item item = (Item) option.eContainer().eContainer();
		return item.getText();
	}
	
}
