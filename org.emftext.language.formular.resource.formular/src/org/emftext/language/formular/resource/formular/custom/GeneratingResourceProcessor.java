package org.emftext.language.formular.resource.formular.custom;

import generator.html.HTMLFormGenerator;
import generator.html.IPhoneFormGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.emftext.language.formular.Formular;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.IResourcePostProcessorProvider;
import org.emftext.runtime.resource.ITextResource;

public class GeneratingResourceProcessor implements IResourcePostProcessor,
		IResourcePostProcessorProvider {

	private static String TARGETDIR = "./output/";

	public void process(ITextResource resource) {
		EList<EObject> contents = resource.getContents();

		Set<EObject> distinctObjects = new HashSet<EObject>();
		distinctObjects.addAll(contents);
		for (EObject eobject : distinctObjects) {
			if (eobject instanceof Formular) {
				createHTMLForm((Formular) eobject);
				createIPhoneForm((Formular) eobject);
				
			}
		}

	}

	private void createIPhoneForm(Formular formular) {
		final IPhoneFormGenerator iphoneFormGen = new IPhoneFormGenerator();
		generateForm(formular, "iphone", iphoneFormGen);
		
	}

	private void createHTMLForm(Formular formular) {
		final HTMLFormGenerator htmlFormGen = new HTMLFormGenerator();
		generateForm(formular, "html", htmlFormGen);
	}

	private void generateForm(Formular formular, String location,
			final IGenerator generator) {
		FileWriter output;
		BufferedWriter writer;
		try {
			IFile resourcefile = WorkspaceSynchronizer.getFile(formular
					.eResource());
			
			IFolder folder = resourcefile.getProject().getFolder(location);
			if (!folder.exists()) {
				try {
					folder.create(true, true, new NullProgressMonitor());
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			IFile file = folder.getFile("formular.html");

			String uri = file.getLocation().toOSString();

			File f = new File(uri);
			output = new FileWriter(uri);
			writer = new BufferedWriter(output);
			writer.write(generator.generate(formular));
			writer.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public IResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

}
