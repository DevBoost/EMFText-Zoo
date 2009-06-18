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
	
}
