package org.emftext.language.java.for2shortfor;

import java.util.Arrays;
import java.util.List;

import org.emftext.language.java.java2dsl.AbstractQVTOBuilderAdapter;
import org.emftext.language.java.java2dsl.util.MetaModelName;

public class For2ShortForBuildAdapter extends AbstractQVTOBuilderAdapter {

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
		return "for2shortfor";
	}

	@Override
	public String getScriptInOtherDirection() {
		return "shortfor2for";
	}

	@Override
	public String getFileExtension() {
		return "java";
	}
	
	@Override
	public String getUtilClassName() {
		return "For2ShortForQVTOStatisticUtil";
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
		return Arrays.asList("ForLoopToForEachLoop");
	}

	@Override
	public List<String> getImportantMappingOperationNameInRightDirection() {
		return Arrays.asList("ForEachLoopToForLoop");
	}

}
