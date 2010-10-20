package org.emftext.language.java.if2shortif;

import java.util.Arrays;
import java.util.List;

import org.emftext.language.java.java2dsl.AbstractQVTOBuilderAdapter;
import org.emftext.language.java.java2dsl.util.MetaModelName;


public class If2ShortIfBuildAdapter extends AbstractQVTOBuilderAdapter {

	@Override
	public int getTimeout() {
		return 30000;
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
		return "if2shortif";
	}

	@Override
	public String getScriptInOtherDirection() {
		return "shortif2if";
	}

	@Override
	public String getUtilClassName() {
		return "If2ShortIfQVTOStatisticUtil";
	}
	
	@Override
	public String getFileExtension() {
		return "java";
	}

	@Override
	public MetaModelName getMetaModelInLeftDirection() {
		return MetaModelName.JAVA;
	}

	@Override
	public MetaModelName getMetaModelInRightDirection() {
		return MetaModelName.JAVA;
	}

	@Override
	public List<String> getImportantMappingOperationNameInLeftDirection() {
		return Arrays.asList("expressions_ConditionalExpression");
	}

	@Override
	public List<String> getImportantMappingOperationNameInRightDirection() {
		return Arrays.asList("CondExpr2Cond");
	}

}
