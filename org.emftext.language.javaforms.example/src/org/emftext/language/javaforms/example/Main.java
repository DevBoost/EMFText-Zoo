package org.emftext.language.javaforms.example;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class Main extends ApplicationWindow {
		
	public Main() {
		super(null);
	}

	public void run() {
		// Don't return from open() until window closes
		setBlockOnOpen(true);
		// Open the main window
		open();
		// Dispose the display
		Display.getCurrent().dispose();
	}
	
	public Control createContents(Composite parent) {
		Test2Wizard wizard = new Test2Wizard();
		WizardDialog dialog = new WizardDialog(Display.getCurrent().getActiveShell(), wizard);
		dialog.create();
		dialog.open();
		return null;
	}
	
	public static void main(String[] args) {
		new Main().run();
	}
}
