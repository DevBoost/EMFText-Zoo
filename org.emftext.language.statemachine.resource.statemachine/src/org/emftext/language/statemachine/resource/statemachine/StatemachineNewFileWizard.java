package org.emftext.language.statemachine.resource.statemachine;
public class StatemachineNewFileWizard extends org.emftext.runtime.ui.new_wizard.AbstractNewFileWizard {
	public String getFileExtension() {
		return "statemachine";
	}
	public String getExampleContent() {
		return "StateMachine value { transitions { } } ";
	}
}
