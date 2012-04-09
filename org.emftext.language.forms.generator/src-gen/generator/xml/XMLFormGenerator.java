package generator.xml;

import java.util.List;
import org.emftext.language.forms.*;;

public class XMLFormGenerator extends org.emftext.language.forms.resource.forms.custom.AbstractGenerator implements org.emftext.language.forms.resource.forms.custom.IGenerator {
  protected static String nl;
  public static synchronized XMLFormGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    XMLFormGenerator result = new XMLFormGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"no\"?>" + NL + "" + NL + "<form titel=\"";
  protected final String TEXT_2 = "\"" + NL + "\txmlns=\"http://org.emftext.language.forms/metamodel/FormMM.xsd\" " + NL + "\txmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " + NL + "\txsi:schemaLocation=\"http://org.emftext.language.forms/metamodel/FormMM.xsd schema/FormMM.xsd\">";
  protected final String TEXT_3 = NL + "\t   <gruppe name=\"";
  protected final String TEXT_4 = "\">";
  protected final String TEXT_5 = NL + "\t\t<";
  protected final String TEXT_6 = ">";
  protected final String TEXT_7 = NL + "\t\t\t<text>" + NL + "\t\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t</text>";
  protected final String TEXT_9 = NL + "\t\t\t<erklaerung>" + NL + "\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t</erklaerung>";
  protected final String TEXT_11 = NL + "\t\t\t<vorbedingungen>";
  protected final String TEXT_12 = NL + "\t\t\t\t<option id=\"";
  protected final String TEXT_13 = "\"/>";
  protected final String TEXT_14 = NL + "\t\t\t</vorbedingungen>";
  protected final String TEXT_15 = NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t<optionen mehrfach=\"";
  protected final String TEXT_17 = "\">";
  protected final String TEXT_18 = NL + "\t\t\t\t<option id=\"";
  protected final String TEXT_19 = "\">" + NL + "\t\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\t</option>";
  protected final String TEXT_21 = NL + "\t\t\t</optionen>";
  protected final String TEXT_22 = NL + "\t\t\t\t<option id=\"";
  protected final String TEXT_23 = "\">" + NL + "\t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\t</option>";
  protected final String TEXT_25 = "\t\t\t" + NL + "\t\t\t</";
  protected final String TEXT_26 = ">";
  protected final String TEXT_27 = NL + "\t</gruppe>" + NL + "\t";
  protected final String TEXT_28 = NL + "</form>";

	/* (non-javadoc)
    * @see IGenerator#generate(Object)
    */
	public String generateString(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Form form = (Form) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append((form.getCaption()==null?"My Form":form.getCaption()) );
    stringBuffer.append(TEXT_2);
     
   List<Group> gruppen=form.getGroups();
   for(Group gruppe:gruppen){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(gruppe.getName() );
    stringBuffer.append(TEXT_4);
      
	   List<Item> fragen=gruppe.getItems();
	   for(Item frage:fragen){
			ItemType typ = frage.getItemType();
			String typName = typ.eClass().getName().toLowerCase();
			String erklaerung = frage.getExplanation();
			String text = frage.getText();
			List<Option> vorbedingungen = frage.getDependentOf();
    stringBuffer.append(TEXT_5);
    stringBuffer.append(typName);
    stringBuffer.append(TEXT_6);
     if(text!=null){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(text);
    stringBuffer.append(TEXT_8);
     }
     if(erklaerung!=null){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(erklaerung);
    stringBuffer.append(TEXT_10);
     }
     if(!vorbedingungen.isEmpty()){
    stringBuffer.append(TEXT_11);
     for(Option option:vorbedingungen){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(option.getId());
    stringBuffer.append(TEXT_13);
     }
    stringBuffer.append(TEXT_14);
     }
    stringBuffer.append(TEXT_15);
     if(typ instanceof Choice){ Choice auswahl=(Choice)typ;
    stringBuffer.append(TEXT_16);
    stringBuffer.append(auswahl.isMultiple());
    stringBuffer.append(TEXT_17);
     for(Option option:auswahl.getOptions()) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(option.getId()==null?"":option.getId() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(option.getText() );
    stringBuffer.append(TEXT_20);
     }
    stringBuffer.append(TEXT_21);
     }else if(typ instanceof Decision){ Decision entscheidung=(Decision)typ;for(Option option:entscheidung.getOptions()){
    stringBuffer.append(TEXT_22);
    stringBuffer.append(option.getId()==null?"":option.getId() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(option.getText() );
    stringBuffer.append(TEXT_24);
     } }
    stringBuffer.append(TEXT_25);
    stringBuffer.append(typName);
    stringBuffer.append(TEXT_26);
     }
    stringBuffer.append(TEXT_27);
     }
    stringBuffer.append(TEXT_28);
    return stringBuffer.toString();
  }
}