package org.emftext.language.csv.resource.csv.mopp;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.csv.CSVDocument;
import org.emftext.language.csv.CsvFactory;
import org.emftext.language.csv.Row;
import org.emftext.language.csv.Value;
import org.emftext.language.csv.resource.csv.ICsvTextResource;

public class CustomCsvPrinter2 extends CsvPrinter2 {

	public CustomCsvPrinter2(OutputStream outputStream, ICsvTextResource resource) {
		super(outputStream, resource);
	}
	
	@Override
	public void print(EObject element) throws IOException {
		if (element instanceof CSVDocument) {
			normalize((CSVDocument) element);
		}
		super.print(element);
	}

	private void normalize(CSVDocument document) {
		for (Row row : document.getRows()) {
			List<Value> values = row.getValues();
			List<Value> newValues = new ArrayList<Value>();
			for (int i = 0; i < values.size(); i++) {
				Value value = values.get(i);
				boolean isLast = i == (values.size() - 1);
				if (isLast) {
					// convert
					Value newValue = CsvFactory.eINSTANCE.createValueWithoutComma();
					newValue.setText(value.getText());
					newValue.eAdapters().addAll(value.eAdapters());
					newValues.add(newValue);
				} else {
					// convert
					Value newValue = CsvFactory.eINSTANCE.createValueWithComma();
					newValue.setText(value.getText());
					newValue.eAdapters().addAll(value.eAdapters());
					newValues.add(newValue);
				}
			}
			row.getValues().clear();
			row.getValues().addAll(newValues);
		}
	}
}
