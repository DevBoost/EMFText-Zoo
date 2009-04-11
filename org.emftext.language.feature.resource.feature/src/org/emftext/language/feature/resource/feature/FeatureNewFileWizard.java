package org.emftext.language.feature.resource.feature;
public class FeatureNewFileWizard extends org.emftext.runtime.ui.new_wizard.AbstractNewFileWizard {
	public String getFileExtension() {
		return "feature";
	}
	public String getExampleContent() {
		return "FeatureModel \" someFeatureModelName \" Feature \" someFeatureName \" ";
	}
}
