/*******************************************************************************
 * Copyright (c) 2006-2011
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
package generator.html;

import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.forms.*;;

public class HTMLFormGenerator extends org.emftext.language.forms.resource.forms.custom.AbstractGenerator implements org.emftext.language.forms.resource.forms.custom.IGenerator {
  protected static String nl;
  public static synchronized HTMLFormGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    HTMLFormGenerator result = new HTMLFormGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">" + NL + "" + NL + "<html> " + NL + "" + NL + "<head> <title> ";
  protected final String TEXT_3 = " </title>" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "</head>" + NL + "" + NL + "<body>" + NL + "" + NL + "<h1> Form: ";
  protected final String TEXT_4 = "</h1>" + NL;
  protected final String TEXT_5 = " <fieldset>" + NL + "\t\t    <legend>";
  protected final String TEXT_6 = "</legend>";
  protected final String TEXT_7 = NL + "\t\t" + NL + "\t\t<b> " + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t" + NL + "\t\t</b>" + NL + "\t\t\t";
  protected final String TEXT_9 = " ";
  protected final String TEXT_10 = " ";
  protected final String TEXT_11 = NL + "\t\t<br>\t" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\t(Only if: &nbsp; " + NL + "\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\t";
  protected final String TEXT_14 = " was selected for Item ";
  protected final String TEXT_15 = NL + "\t\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\t)" + NL + "\t\t\t " + NL + "\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t<br>" + NL + "\t\t" + NL + "\t\t\t";
  protected final String TEXT_18 = " " + NL + "\t\t\t\t<input size=30></input>\t" + NL + "\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t";
  protected final String TEXT_20 = " " + NL + "\t\t\t\t<input size=\"2\" maxlength=\"2\" value=\"DD\"/>." + NL + "\t\t\t\t<input size=\"2\" maxlength=\"2\" value=\"MM\"/>." + NL + "\t\t\t\t<input size=\"4\" maxlength=\"4\" value=\"YYYY\"/>\t" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t";
  protected final String TEXT_22 = " " + NL + "\t\t\t\t<input size=10></input>\t" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t";
  protected final String TEXT_24 = " " + NL + "\t\t\t\t\t <input type=\"checkbox\" name=\"";
  protected final String TEXT_25 = "\" value=\"";
  protected final String TEXT_26 = "\"> ";
  protected final String TEXT_27 = NL + "\t\t\t\t\t ";
  protected final String TEXT_28 = " (mind: ";
  protected final String TEXT_29 = " )";
  protected final String TEXT_30 = NL + "\t\t\t\t\t ";
  protected final String TEXT_31 = NL + "\t\t\t\t\t <input type=\"radio\" name=\"";
  protected final String TEXT_32 = "\" value=\"";
  protected final String TEXT_33 = "\"> ";
  protected final String TEXT_34 = NL + "\t\t\t\t\t ";
  protected final String TEXT_35 = " (mind: ";
  protected final String TEXT_36 = " )";
  protected final String TEXT_37 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t ";
  protected final String TEXT_38 = NL + "\t\t\t\t\t <br>" + NL + "\t\t\t";
  protected final String TEXT_39 = "<input type=\"checkbox\" name=\"";
  protected final String TEXT_40 = "\" title=\"Yes|No\" checked=\"checked\" value=\"ok\" /> " + NL + "\t\t\t\t<label for=\"";
  protected final String TEXT_41 = "\">";
  protected final String TEXT_42 = "</label>" + NL + "\t\t\t\t";
  protected final String TEXT_43 = " (Yes: ";
  protected final String TEXT_44 = " )" + NL + "\t\t\t\t";
  protected final String TEXT_45 = " (No: ";
  protected final String TEXT_46 = " )" + NL + "\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t<br>" + NL + "\t\t" + NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_48 = NL + "\t\t   </fieldset>" + NL + "\t";
  protected final String TEXT_49 = NL + "\t\t" + NL + "\t" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "</body>" + NL + "" + NL + "" + NL + "" + NL + "</html>";

	/* (non-javadoc)
    * @see IGenerator#generate(Object)
    */
	public String generateString(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     Form form = (Form) argument; 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(form.getCaption());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(form.getCaption() );
    stringBuffer.append(TEXT_4);
    EList<Group> gruppen = form.getGroups();
	
	for (Group gruppe : gruppen) {
		 
    stringBuffer.append(TEXT_5);
    stringBuffer.append(gruppe.getName());
    stringBuffer.append(TEXT_6);
    

		EList<Item> list = gruppe.getItems();
		
		    for (Iterator<Item> iterator = list.iterator(); iterator.hasNext();) {
		
			Item frage = iterator.next();
		
		
    stringBuffer.append(TEXT_7);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_8);
     if (frage.getExplanation() != null) { 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(frage.getExplanation());
    stringBuffer.append(TEXT_10);
     } 
    stringBuffer.append(TEXT_11);
     if (frage.getDependentOf().size() > 0) { 
    stringBuffer.append(TEXT_12);
     for(Option option : frage.getDependentOf()) { 
    stringBuffer.append(TEXT_13);
    stringBuffer.append(option.getId() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(generateItemAddress(frage) );
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
     } 
    stringBuffer.append(TEXT_17);
     if (frage.getItemType() instanceof FreeText) { 
    stringBuffer.append(TEXT_18);
     } 
    stringBuffer.append(TEXT_19);
     if (frage.getItemType() instanceof Date) { 
    stringBuffer.append(TEXT_20);
     } 
    stringBuffer.append(TEXT_21);
     if (frage.getItemType() instanceof org.emftext.language.forms.Number) { 
    stringBuffer.append(TEXT_22);
     } 
    stringBuffer.append(TEXT_23);
     if (frage.getItemType() instanceof Choice) { 
				Choice auswahl = (Choice) frage.getItemType();
				for(Option option : auswahl.getOptions()) {
					if (auswahl.isMultiple()) {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(option.getText());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(option.getText());
    stringBuffer.append(TEXT_27);
     if (option.getId() != null) {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(option.getId());
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    } else { 
    stringBuffer.append(TEXT_31);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(option.getText());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(option.getText());
    stringBuffer.append(TEXT_34);
     if (option.getId() != null) {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(option.getId());
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
     	 }
			}
			if (frage.getItemType() instanceof Decision) { 
				Decision entscheidung = (Decision) frage.getItemType();
				
    stringBuffer.append(TEXT_39);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_42);
     
				if (entscheidung.getOptions().get(0).getId() != null) {
					
    stringBuffer.append(TEXT_43);
    stringBuffer.append(entscheidung.getOptions().get(0).getId());
    stringBuffer.append(TEXT_44);
    
				}
				if (entscheidung.getOptions().get(1).getId() != null) {
					
    stringBuffer.append(TEXT_45);
    stringBuffer.append(entscheidung.getOptions().get(1).getId());
    stringBuffer.append(TEXT_46);
    
				}
			}
			
			
    stringBuffer.append(TEXT_47);
    
		  }
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    return stringBuffer.toString();
  }
}