package org.emftext.language.csv.resource.csv.postprocessing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.csv.CSVDocument;
import org.emftext.language.csv.CsvFactory;
import org.emftext.language.csv.Row;
import org.emftext.language.csv.Value;
import org.emftext.language.csv.ValueWithComma;
import org.emftext.language.csv.ValueWithoutComma;
import org.emftext.language.csv.resource.csv.ICsvOptionProvider;
import org.emftext.language.csv.resource.csv.ICsvOptions;
import org.emftext.language.csv.resource.csv.ICsvResourcePostProcessor;
import org.emftext.language.csv.resource.csv.ICsvResourcePostProcessorProvider;
import org.emftext.language.csv.resource.csv.mopp.CsvResource;

/**
 * This post processor replaces all instance of the {@link ValueWithComma} and
 * {@link ValueWithoutComma} classes with instances of their superclass {@link Value}.
 * 
 * The two subclasses are required for parsing CSV files, but actually represent
 * the same kind of information.
 */
public class CsvPostProcessor implements ICsvOptionProvider, ICsvResourcePostProcessorProvider, ICsvResourcePostProcessor {

	public void process(CsvResource resource) {
		if (!resource.getErrors().isEmpty()) {
			return;
		}
		EList<EObject> contents = resource.getContents();
		EObject rootObject = contents.get(0);
		CSVDocument document = (CSVDocument) rootObject;
		EList<Row> rows = document.getRows();
		for (Row row : rows) {
			EList<Value> values = row.getValues();
			List<Value> replacedValues = new ArrayList<Value>();
			for (Value value : values) {
				Value newValue = CsvFactory.eINSTANCE.createValue();
				newValue.setText(value.getText());
				replacedValues.add(newValue);
			}
			values.clear();
			values.addAll(replacedValues);
		}
	}

	public Map<?, ?> getOptions() {
		return Collections.singletonMap(ICsvOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
	}

	public ICsvResourcePostProcessor getResourcePostProcessor() {
		return this;
	}
}
