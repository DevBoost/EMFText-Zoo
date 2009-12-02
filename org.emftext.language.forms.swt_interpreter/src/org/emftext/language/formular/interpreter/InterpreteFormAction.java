package org.emftext.language.formular.interpreter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class InterpreteFormAction implements IObjectActionDelegate {

	private static final String[] FORM = {"Formular", "Form"};
	private static final String[] FORM_GROUPS = {"gruppen", "groups"};
	private static final String[] FORM_TITLE = {"title", "titel"};
	private static final String[] GROUP_NAME = {"name"};
	private static final String[] GROUP_ITEMS = {"fragen", "items"};
	private static final String[] ITEM_TEXT = {"text"};
	private static final String[] ITEM_TYPES = {"antwortTyp", "itemType"};
	private static final String[] FREETEXT = {"FreeText", "FreiText"};
	private static final String[] CHOICE = {"Auswahl", "Choice"};
	private static final String[] DECISION = {"Decision", "Entscheidung"};
	private static final String[] NUMBER = {"Zahl", "Number"};
	private static final String[] DATE = {"Datum", "Date"};
	private static final String[] CHOICE_OPTIONS = {"options", "optionen"};
	private static final String[] CHOICE_NAME = {"text"};
	private static final String[] CHOICE_MULTIPLE = {"multiple", "mehrfach"};
	
	private ISelection selection;

	public void run(IAction action) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Object first = structuredSelection.getFirstElement();
			if (first instanceof IFile) {
				IFile file = (IFile) first;
				Resource resource = new ResourceSetImpl().createResource(URI.createFileURI(file.getLocation().toOSString()));
				if (resource != null) {
					try {
						resource.load(null);
						interprete(resource.getContents());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private void interprete(List<EObject> contents) {
		for (EObject eObject : contents) {
			interprete(eObject);
		}
	}

	private void interprete(EObject eObject) {
		if (isA(eObject, FORM)) {
			interpreteForm(eObject);
		}
	}

	private void interpreteForm(final EObject form) {
		Wizard wizard = new Wizard() {

			@Override
			public boolean performFinish() {
				return true;
			}
		};
		wizard.setWindowTitle(getString(form, FORM_TITLE));
		List<EObject> groups = getList(form, FORM_GROUPS);
		for (EObject group : groups) {
			List<EObject> items = getList(group, GROUP_ITEMS);
			for (final EObject item : items) {
				String groupTitle = getString(group, GROUP_NAME);
				if (groupTitle == null) {
					groupTitle = "";
				}
				wizard.addPage(new WizardPage(groupTitle, groupTitle, null) {
					
					public void createControl(Composite parent) {
						GridData gd = new GridData(SWT.FILL, SWT.BOTTOM, true, false, 1, 1);
						GridData gd2 = new GridData(SWT.FILL, SWT.BOTTOM, true, false, 2, 1);

						Composite composite = new Composite(parent, SWT.NONE);
						// create the desired layout for this wizard page
						GridLayout gl = new GridLayout();
						gl.numColumns = 2;
						composite.setLayout(gl);
						
						Label question = new Label(composite, NONE);
						question.setText(getString(item, ITEM_TEXT));
						
						EObject itemType = get(item, ITEM_TYPES);
						if (isA(itemType, FREETEXT)) {
							Text text = new Text(composite, SWT.SINGLE);
							text.setLayoutData(gd);
							question.setLayoutData(gd);
						}
						boolean itemIsChoice = isA(itemType, CHOICE);
						boolean itemIsDecision = isA(itemType, DECISION);
						if (itemIsChoice || itemIsDecision) {
							int type = SWT.RADIO;
							if (getBoolean(itemType, CHOICE_MULTIPLE)) {
								type = SWT.CHECK;
							}
							List<EObject> options = getList(itemType, CHOICE_OPTIONS);
							for (EObject option : options) {
								Button radioButton = new Button(composite, type);
								radioButton.setLayoutData(gd2);
								String optionName = getString(option, CHOICE_NAME);
								if (optionName == null) {
									optionName = "";
								}
								radioButton.setText(optionName);
							}
							question.setLayoutData(gd2);
						}
						if (isA(itemType, NUMBER)) {
							Spinner spinner = new Spinner(composite, SWT.NONE);
							spinner.setLayoutData(gd);
							question.setLayoutData(gd);
						}
						if (isA(itemType, DATE)) {
							DateTime dateTime = new DateTime(composite, SWT.NONE);
							dateTime.setLayoutData(gd);
							question.setLayoutData(gd2);
						}
						
						setControl(composite);
					}

				});
			}
		}
		WizardDialog dialog = new WizardDialog(Display.getCurrent().getActiveShell(), wizard);
		dialog.create();
		dialog.open();
	}

	private EObject get(EObject object, String[] featureNames) {
		Object value = getObject(object, featureNames);
		if (value instanceof EObject) {
			return (EObject) value;
		}
		return null;
	}
	
	private boolean getBoolean(EObject item,
			String[] optionMultiple) {
		Object value = getObject(item, optionMultiple);
		if (value != null && value instanceof Boolean) {
			return (Boolean) value;
		}
		return false;
	}

	private String getString(EObject eObject, String[] featureNames) {
		Object value = getObject(eObject, featureNames);
		if (value instanceof String) {
			return (String) value;
		}
		return null;
	}

	private Object getObject(EObject eObject, String[] featureNames) {
		for (String featureName : featureNames) {
			EStructuralFeature feature = eObject.eClass().getEStructuralFeature(featureName);
			if (feature == null) {
				continue;
			}
			Object value = eObject.eGet(feature);
			return value;
		}
		return null;
	}

	private List<EObject> getList(EObject eObject, String[] featureNames) {
		List<EObject> valueList = new ArrayList<EObject>();
		for (String featureName : featureNames) {
			EStructuralFeature feature = eObject.eClass().getEStructuralFeature(featureName);
			if (feature == null) {
				continue;
			}
			Object value = eObject.eGet(feature);
			if (value instanceof List<?>) {
				for (Iterator<?> iterator = ((List<?>) value).iterator(); iterator
						.hasNext();) {
					Object next = (Object) iterator.next();
					if (next instanceof EObject) {
						valueList.add((EObject) next);
					}
				}
			} else {
				if (value instanceof EObject) {
					valueList.add((EObject) value);
				}
			}
		}
		return valueList;
	}

	private boolean isA(EObject eObject, String[] formClassNames) {
		if (eObject == null) {
			return false;
		}
		for (String formClassName : formClassNames) {
			if (eObject.eClass().getName().equalsIgnoreCase(formClassName)) {
				return true;
			}
		}
		return false;
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}
}
