package org.emftext.language.uml_class.resource.uml_class.ui;

public class Uml_classPropertySheetPage extends org.eclipse.ui.views.properties.PropertySheetPage implements org.eclipse.jface.viewers.ISelectionChangedListener {
	
	public void selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent event) {
		selectionChanged(null, event.getSelection());
	}
	
}
