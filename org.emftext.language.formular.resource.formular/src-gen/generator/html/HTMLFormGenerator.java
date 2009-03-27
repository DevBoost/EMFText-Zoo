package generator.html;

import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.formular.*;;

public class HTMLFormGenerator
{
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
  protected final String TEXT_3 = " </title>" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "</head>" + NL + "" + NL + "<body>" + NL + "" + NL + "<h1> Formular: ";
  protected final String TEXT_4 = "</h1>" + NL;
  protected final String TEXT_5 = NL + NL + "<b> " + NL + "\t";
  protected final String TEXT_6 = NL + "\t" + NL + "</b>" + NL + "\t";
  protected final String TEXT_7 = " ";
  protected final String TEXT_8 = " ";
  protected final String TEXT_9 = NL + "<br>\t" + NL + "\t";
  protected final String TEXT_10 = NL + "\t\t(Nur bei: " + NL + "\t\t";
  protected final String TEXT_11 = NL + "\t\t\t";
  protected final String TEXT_12 = "  " + NL + "\t\t";
  protected final String TEXT_13 = NL + "\t\t)" + NL + "\t " + NL + "\t\t" + NL + "\t";
  protected final String TEXT_14 = NL + "\t<br>" + NL + "" + NL + "\t";
  protected final String TEXT_15 = " " + NL + "\t\t<input size=30></input>\t" + NL + "\t";
  protected final String TEXT_16 = NL + "\t";
  protected final String TEXT_17 = " " + NL + "\t\t<input size=\"2\" maxlength=\"2\" value=\"DD\"/>." + NL + "\t\t<input size=\"2\" maxlength=\"2\" value=\"MM\"/>." + NL + "\t\t<input size=\"4\" maxlength=\"4\" value=\"YYYY\"/>\t" + NL + "\t";
  protected final String TEXT_18 = NL + "\t";
  protected final String TEXT_19 = " " + NL + "\t\t<input size=10></input>\t" + NL + "\t";
  protected final String TEXT_20 = NL + "\t";
  protected final String TEXT_21 = " " + NL + "\t\t <input type=\"radio\" name=\"";
  protected final String TEXT_22 = "\" value=\"";
  protected final String TEXT_23 = "\"> ";
  protected final String TEXT_24 = NL + "\t\t ";
  protected final String TEXT_25 = " (beachte: ";
  protected final String TEXT_26 = ")";
  protected final String TEXT_27 = NL + "\t\t <br>" + NL + "\t";
  protected final String TEXT_28 = NL + "\t<br>" + NL + "" + NL + "\t" + NL + "\t" + NL + "\t" + NL;
  protected final String TEXT_29 = NL + NL + NL + NL + NL + NL + NL + NL + NL + NL + "</body>" + NL + "" + NL + "" + NL + "" + NL + "</html>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     Formular formular = (Formular) argument; 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(formular.getTitel());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(formular.getTitel() );
    stringBuffer.append(TEXT_4);
    EList<Frage> list = formular.getFragen();

    for (Iterator<Frage> iterator = list.iterator(); iterator.hasNext();) {

	Frage frage = iterator.next();


    stringBuffer.append(TEXT_5);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_6);
     if (frage.getErklaerung() != null) { 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(frage.getErklaerung());
    stringBuffer.append(TEXT_8);
     } 
    stringBuffer.append(TEXT_9);
     if (frage.getAbhaengigVon().size() > 0) { 
    stringBuffer.append(TEXT_10);
     for(Option option : frage.getAbhaengigVon()) { 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(option.getId() );
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
     } 
    stringBuffer.append(TEXT_14);
     if (frage.getAntwortTyp() instanceof Freitext) { 
    stringBuffer.append(TEXT_15);
     } 
    stringBuffer.append(TEXT_16);
     if (frage.getAntwortTyp() instanceof Datum) { 
    stringBuffer.append(TEXT_17);
     } 
    stringBuffer.append(TEXT_18);
     if (frage.getAntwortTyp() instanceof Zahl) { 
    stringBuffer.append(TEXT_19);
     } 
    stringBuffer.append(TEXT_20);
     if (frage.getAntwortTyp() instanceof Auswahl) { 
		Auswahl auswahl = (Auswahl) frage.getAntwortTyp();
		for(Option option : auswahl.getOptionen()) {
		
    stringBuffer.append(TEXT_21);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(option.getText());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(option.getText());
    stringBuffer.append(TEXT_24);
     if (option.getId() != null) {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(option.getId());
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
     	 }
	    } 
	
    stringBuffer.append(TEXT_28);
     
}
    stringBuffer.append(TEXT_29);
    return stringBuffer.toString();
  }
}
