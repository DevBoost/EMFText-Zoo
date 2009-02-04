package org.emftext.language.java.test.bulk;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;

public class FailingClassesExtractor extends GiganticTest {

	private final static String[] failingURIs = new String[] {
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/core.kit/test/perf/src/org/openide/filesystems/ReadOnlyFSTest.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/core.kit/test/perf/src/org/openide/util/enum/SequenceEnumTest.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/core.kit/test/perf/src/org/openide/util/enum/Sequence2EnumTest.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/core.kit/test/perf/src/org/openide/util/enum/ArrayEnumTest.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/core.kit/test/perf/src/org/openide/util/enum/EnumBenchmark.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/debugger.jpda/test/unit/src/org/netbeans/api/debugger/jpda/testapps/EvaluatorApp.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/editor/test/qa-functional/data/cp-prj-1/src/org/netbeans/test/editor/completion/InnerOutter.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/editor/test/qa-functional/data/cp-prj-1/src/org/netbeans/test/editor/completion/ArgumentTest.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/editor/test/qa-functional/data/cp-prj-1/src/org/netbeans/test/editor/completion/TestFile.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/qa-functional/data/CC15Tests/src/accesscontroltest/points/Point.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/qa-functional/data/CC15Tests/src/localvarstest/Test.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/qa-functional/data/CC15Tests/src/test11/CCTest11i.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/qa-functional/data/cp-prj-1/src/org/netbeans/test/editor/completion/ArgumentTest.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/qa-functional/data/cp-prj-1/src/org/netbeans/test/editor/completion/InnerOutter.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/qa-functional/data/cp-prj-1/src/org/netbeans/test/editor/completion/TestFile.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/qa-functional/data/projects/java_editor_test/src/org/netbeans/test/java/editor/completiongui/GuiTest/ContextAware.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/qa-functional/data/projects/java_editor_test/src/org/netbeans/test/java/editor/smart_bracket/JavaSmartBracketTest/testComment.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/qa-functional/data/projects/java_editor_test/src/org/netbeans/test/java/editor/formatting/testReformatIncompleteStatement2.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/qa-functional/data/projects/java_editor_test/src/org/netbeans/test/java/editor/smart_bracket/JavaSmartBracketTest/testLBrace.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/qa-functional/data/projects/java_editor_test/src/org/netbeans/test/java/editor/smart_bracket/JavaSmartBracketTest/testSpace.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/qa-functional/data/projects/java_editor_test/src/org/netbeans/test/java/editor/formatting/testReformatIncompleteStatement.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/unit/data/org/netbeans/modules/editor/java/TestBrokenSource.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/unit/data/org/netbeans/modules/java/editor/imports/data/TestException.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/unit/data/org/netbeans/modules/java/editor/imports/data/TestEmptyCatch.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/unit/data/org/netbeans/modules/java/editor/imports/data/TestUnfinishedMethod2.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/unit/data/org/netbeans/modules/java/editor/semantic/data/ExitPointsStartedMethod.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/unit/data/org/netbeans/modules/editor/java/TestInterface2.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/unit/data/org/netbeans/modules/java/editor/completion/data/MethodStart.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/unit/data/org/netbeans/modules/java/editor/completion/data/GenericsMethodBodyStart.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/unit/data/org/netbeans/modules/java/editor/completion/data/InitializersStart.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/unit/data/org/netbeans/modules/java/editor/completion/data/SimpleMethodBodyStart.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/unit/data/org/netbeans/modules/java/editor/completion/data/GenericsStart.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.editor/test/unit/data/org/netbeans/modules/java/editor/semantic/data/UnusedParameters.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.hints/test/unit/data/org/netbeans/test/java/hints/AddSemicolon.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.hints/test/unit/data/org/netbeans/test/java/hints/CreateElementException.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.hints/test/unit/data/org/netbeans/test/java/hints/CreateElementTest/Bug105415.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.hints/test/unit/data/org/netbeans/test/java/hints/ImportClassEnablerTest/ImportHintDoNotPropose.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.hints/test/unit/data/org/netbeans/test/java/hints/ImplementAbstractMethods10.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.hints/test/unit/data/org/netbeans/test/java/hints/ImportClassEnablerTest/ImportTest6.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/java.hints/test/unit/data/org/netbeans/test/java/hints/ImplementAbstractMethods9.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/mobility.end2end/templates/InvocationAbstraction.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/mobility.end2end/templates/Structures.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/mobility.end2end/templates/InvocationAbstractionImpl.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/mobility.end2end/templates/Servlet.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/mobility.end2end/templates/ClientTest.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/mobility.end2end/templates/Utility.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/mobility.end2end/templates/Protocol.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/o.n.core/test/perf/src/org/netbeans/core/lookup/NbLookupBenchmark.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/openide.util.enumerations/src/org/openide/util/enum/QueueEnumeration.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/openide.util.enumerations/src/org/openide/util/enum/AlterEnumeration.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/openide.util.enumerations/src/org/openide/util/enum/EmptyEnumeration.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/openide.util.enumerations/src/org/openide/util/enum/FilterEnumeration.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/openide.util.enumerations/src/org/openide/util/enum/ArrayEnumeration.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/openide.util.enumerations/src/org/openide/util/enum/RemoveDuplicatesEnumeration.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/openide.util.enumerations/src/org/openide/util/enum/SequenceEnumeration.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/openide.util.enumerations/test/unit/src/org/openide/util/enum/OldEnumerationsTest.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/openide.util.enumerations/src/org/openide/util/enum/SingletonEnumeration.java",
			"/org.emftext.language.java.test.bulk/./input/netbeans-6.5-200811100001-ml-src.zip!/vmd.model/test/unit/src/org/netbeans/modules/vmd/api/model/GlobalDescriptorRegistryTest.java"
	};

	public static void main(String[] args) throws IOException, CoreException {
		new FailingClassesExtractor().doExtract();
	}

	private int count = 0;

	private void doExtract() throws IOException, CoreException {
		List<String> inputZips = getInputZips();
		for (String inputZip : inputZips) {
			Collection<URI> streams = getURIsForZipFileEntries(inputZip);
			for (URI next : streams) {
				extract(next);
			}
		}
	}

	private void extract(URI next) throws IOException {
		if (!contained(next)) {
			return;
		}
		InputStream is = new ExtensibleURIConverterImpl().createInputStream(next);
		count++;
		FileOutputStream fos = new FileOutputStream(new File(count + "_" + next.lastSegment()));
		
		int read = -1;
		while ((read = is.read()) > 0) {
			fos.write(read);
		}
		fos.close();
		is.close();
	}

	private boolean contained(URI next) {
		for (String failingURI : failingURIs) {
			if (next.toString().endsWith(failingURI)) {
				return true;
			}
		}
		return false;
	}

}
