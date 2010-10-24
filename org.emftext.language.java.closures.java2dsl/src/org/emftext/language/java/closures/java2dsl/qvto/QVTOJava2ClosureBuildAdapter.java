package org.emftext.language.java.closures.java2dsl.qvto;

import java.util.Arrays;
import java.util.List;

import org.emftext.language.java.java2dsl.AbstractQVTOBuilderAdapter;
import org.emftext.language.java.java2dsl.util.MetaModelName;


public class QVTOJava2ClosureBuildAdapter extends AbstractQVTOBuilderAdapter {

	@Override
	public int getTimeout() {
		return 300000;
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
		return "java2closure";
	}

	@Override
	public String getScriptInOtherDirection() {
		return "closure2java";
	}

	@Override
	public String getFileExtension() {
		return "closure";
	}
	
	@Override
	public String getUtilClassName() {
		return "ClosureQVTOStatisticUtil";
	}

	@Override
	public MetaModelName getMetaModelInLeftDirection() {
		return MetaModelName.CLOSURE;
	}

	@Override
	public MetaModelName getMetaModelInRightDirection() {
		return MetaModelName.CLOSURE;
	}

	@Override
	public List<String> getImportantMappingOperationNameInLeftDirection() {
		return Arrays.asList("Closures_Closure_NewConstructorCall",
				"Closures_Closure_MethodCall",
				"Closures_Closure_AssignmentExpression",
				"Closures_Closure_LocalVariable",
				"Closures_Closure_Return");
	}

	@Override
	public List<String> getImportantMappingOperationNameInRightDirection() {
		return Arrays.asList("Closure2Ncc");
	}

}
