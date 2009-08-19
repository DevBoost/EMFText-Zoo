package org.emftext.language.owl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.emftext.language.owl.reasoning.EMFTextOWLReasoner;
import org.emftext.language.owl.reasoning.PelletReasoner;
import org.emftext.language.owl.reasoning.ReasoningException;
import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.IResourcePostProcessorProvider;
import org.emftext.runtime.resource.EProblemType;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.impl.AbstractProblem;
import org.semanticweb.owl.model.OWLClass;

public class ConsistencyChecker implements IResourcePostProcessor,
		IResourcePostProcessorProvider, IOptionProvider {

	private EMFTextOWLReasoner reasoner;

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(IOptions.RESOURCE_POSTPROCESSOR_PROVIDER,
				new ConsistencyChecker());
		return options;
	}

	public ConsistencyChecker() {
		this.reasoner = new PelletReasoner();

	}

	public void process(ITextResource resource) {
		IFile file = WorkspaceSynchronizer.getFile(resource);
		try {
			InputStream stream = file.getContents();
			BufferedReader br = new BufferedReader(
					new InputStreamReader(stream));
			StringBuilder sb = new StringBuilder();
			String line = null;

			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
			String content = sb.toString();
			Set<OWLClass> inconsistentClasses;
			System.out.println(content);
			try {
				inconsistentClasses = reasoner.getInconsistentClasses(content);
			} catch (final ReasoningException e) {
				resource.addProblem(new AbstractProblem() {

					public EProblemType getType() {
						return EProblemType.ERROR;
					}

					public String getMessage() {
						return e.getMessage();
					}
				}, resource.getContents().get(0));
				
				return;
			}
			Set<String> invalidIris = new HashSet<String>();
			for (OWLClass class1 : inconsistentClasses) {
				invalidIris.add(class1.getURI().getFragment());
			}
			TreeIterator<EObject> allContents = resource.getAllContents();
			while (allContents.hasNext()) {
				EObject next = allContents.next();
				if (next instanceof Class) {
					final Class c = ((Class) next);
					if (invalidIris.contains(c.getIri())) {
						resource.addProblem(new AbstractProblem() {

							public EProblemType getType() {
								return EProblemType.ERROR;
							}

							public String getMessage() {
								return "The class '" + c.getIri()
										+ "' is inconsistent.";
							}
						}, next);
					}
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public IResourcePostProcessor getResourcePostProcessor() {
		return new ConsistencyChecker();
	}

}
