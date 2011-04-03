package org.emftext.language.webtest.runner;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.emftext.language.webtest.Command;
import org.emftext.language.webtest.TestScript;
import org.emftext.language.webtest.resource.webtest.util.WebtestResourceUtil;

public class WebtestRunner {
	
	public void runTest(String pathToScript) {
		URI uri = URI.createURI(pathToScript);
		TestScript script = WebtestResourceUtil.getResourceContent(uri);
		
		WebtestInterpreter interpreter = new WebtestInterpreter();
		List<Command> commands = script.getCommands();
		interpreter.addObjectsToInterpreteInReverseOrder(commands);
		interpreter.interprete(new WebtestContext());
	}
}
