package org.emftext.language.java.properties.java2dsl.medini;

import java.util.Arrays;
import java.util.List;

import org.emftext.language.java.java2dsl.AbstractMediniBuilderAdapter;
import org.emftext.language.java.java2dsl.util.MetaModelName;

public class MediniJava2PropertyBuildAdapter extends AbstractMediniBuilderAdapter {

	@Override
	public int getTimeout() {
		return 3000000;
	}

	@Override
	public int getMaxActiveThreads() {
		return 1;
	}

	@Override
	public String getDirectoryWithScripts() {
		return "transformations";
	}

	@Override
	public String getScriptInOneDirection() {
		return "java2propjava";
	}

	@Override
	public String getScriptInOtherDirection() {
		return "java2propjava";
	}

	@Override
	public String getUtilClassName() {
		return "PropertyMediniStatisticUtil";
	}

	@Override
	public MetaModelName getMetaModelInLeftDirection() {
		return MetaModelName.PROPERTY;
	}

	@Override
	public MetaModelName getMetaModelInRightDirection() {
		return MetaModelName.PROPERTY;
	}

	@Override
	public List<String> getImportantMappingOperationNameInLeftDirection() {
		return Arrays.asList("Members_Property","Members_PropertyReadOnly");
	}

	@Override
	public List<String> getImportantMappingOperationNameInRightDirection() {
		return Arrays.asList("Members_Property","Members_PropertyReadOnly");
	}

	@Override
	public String getFileExtension() {
		return "propjava";
	}

	@Override
	public String getTransformationName() {
		return "copy";
	}

	@Override
	public String getDomainNameInLeftDirection() {
		return "PROPJAVA";
	}

	@Override
	public String getDomainNameInRightDirection() {
		return "JAVA";
	}
	
	
}
