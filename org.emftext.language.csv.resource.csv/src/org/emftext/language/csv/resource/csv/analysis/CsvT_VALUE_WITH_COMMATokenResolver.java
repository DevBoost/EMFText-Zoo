
package org.emftext.language.csv.resource.csv.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.csv.Row;
import org.emftext.language.csv.Value;
import org.emftext.language.csv.resource.csv.analysis.helper.VALUETokenResolver;

public class CsvT_VALUE_WITH_COMMATokenResolver extends VALUETokenResolver {
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = super.deResolve(value, feature, container);
		assert container instanceof Value;
		EObject rowObject = container.eContainer();
		assert rowObject instanceof Row;
		Row row = (Row) rowObject;
		EList<Value> values = row.getValues();
		int index = values.indexOf(container);
		boolean isLast = index == values.size() - 1;
		String delimiter;
		if (isLast) {
			delimiter = System.getProperty("line.separator");
		} else {
			delimiter = ",";
		}
		return result + delimiter;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.csv.resource.csv.ICsvTokenResolveResult result) {
		if (lexem.endsWith(",")) {
			lexem = lexem.substring(0, lexem.length() - 1);
		}
		super.resolve(lexem, feature, result);
	}
}
