package org.emftext.language.javaforms.example;	

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class Test2Wizard extends Wizard {

	@Override
	public boolean performFinish() {
		return true;
	}

	@Override
	public void addPages() {
		addPage(new WizardPage("Personal Details", "Personal Details", null) {

			public void createControl(Composite parent) {
				GridData gd = new GridData(SWT.FILL, SWT.BOTTOM, true, false, 1, 1);
				GridData gd2 = new GridData(SWT.FILL, SWT.BOTTOM, true, false, 2, 1);
	
				Composite composite = new Composite(parent, SWT.NONE);
				// create the desired layout for this wizard page
				GridLayout gl = new GridLayout();
				gl.numColumns = 2;
				composite.setLayout(gl);
	
				Label question = new Label(composite, NONE);
				question.setText("Age");

				// TODO handle conditional item
				if () {
				}
				
				setControl(composite);
			}
		});
		addPage(new WizardPage("Personal Details", "Personal Details", null) {

			public void createControl(Composite parent) {
				GridData gd = new GridData(SWT.FILL, SWT.BOTTOM, true, false, 1, 1);
				GridData gd2 = new GridData(SWT.FILL, SWT.BOTTOM, true, false, 2, 1);
	
				Composite composite = new Composite(parent, SWT.NONE);
				// create the desired layout for this wizard page
				GridLayout gl = new GridLayout();
				gl.numColumns = 2;
				composite.setLayout(gl);
	
				Label question = new Label(composite, NONE);
				question.setText("Legal Gurian");

				// TODO handle conditional item
				if (age < 18) {
				}
				
				setControl(composite);
			}
		});
	}
}