package org.emftext.language.formular.resource.formular.custom;

import generator.html.HTMLFormGenerator;
import generator.html.IPhoneFormGenerator;
import generator.html.IPhoneIndexGenerator;
import generator.xml.FOFormGenerator;
import generator.xml.XMLFormGenerator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.emftext.language.formular.Formular;
import org.emftext.language.formular.resource.formular.IFormularResourcePostProcessor;
import org.emftext.language.formular.resource.formular.IFormularResourcePostProcessorProvider;
import org.emftext.language.formular.resource.formular.mopp.FormularResource;

public class GeneratingResourceProcessor implements IFormularResourcePostProcessor,
		IFormularResourcePostProcessorProvider {

	public void process(FormularResource resource) {
		EList<EObject> contents = resource.getContents();
		
		Set<EObject> distinctObjects = new HashSet<EObject>();
		distinctObjects.addAll(contents);
		for (EObject eobject : distinctObjects) {
			if (eobject instanceof Formular) {
				final Formular formular = (Formular)eobject;
				final IProject project = WorkspaceSynchronizer.getFile(formular.eResource()).getProject();
				Job creationJob = new Job("Generiere Formular") {
					@Override
					protected IStatus run(IProgressMonitor monitor) {
						createHTMLForm(project,formular);
						createIPhoneForm(project,formular);
						createXMLForm(project,formular);
						IFile result = createFoForm(project,formular);
						createPSForm(result,formular.getTitel());
						return Status.OK_STATUS;
					}
					
				};
				
				creationJob.schedule();
			}
		}

	}

	private void createIPhoneForm(IProject project, Formular formular) {
		final IPhoneFormGenerator iphoneFormGen = new IPhoneFormGenerator();
		generateForm(project,formular, "iphone",formular.getTitel()+".html", iphoneFormGen);
		final IPhoneIndexGenerator iphoneIndexGen = new IPhoneIndexGenerator();
		generateForm(project,formular, "iphone","index.html", iphoneIndexGen);
		
	}

	private void createHTMLForm(IProject project, Formular formular) {
		final HTMLFormGenerator htmlFormGen = new HTMLFormGenerator();
		generateForm(project,formular, "html",formular.getTitel()+".html",htmlFormGen);
	}
	
	private void createXMLForm(IProject project, Formular formular) {
		XMLFormGenerator xmlFormGenerator = new XMLFormGenerator();
		generateForm(project,formular, "xml",formular.getTitel()+".xml",xmlFormGenerator);
	}
	
	private IFile createFoForm(IProject project, Formular formular) {
		FOFormGenerator foFormGenerator = new FOFormGenerator();
		return generateForm(project,formular,"xsl-fo",formular.getTitel()+".xml",foFormGenerator);
	}
	
	private IFile createPSForm(IFile foFile,String titel){
		PDFFormGenerator psFormGenerator = new PDFFormGenerator();
		return generateForm(foFile.getProject(),foFile,"pdf",titel+".pdf",psFormGenerator);

	}
	
	private IFile generateForm(IProject targetProject, Object argument, String folderName, String filename,
			final IGenerator generator) {
		try {
			
			IFolder folder = targetProject.getFolder(folderName);
			if (!folder.exists()) {
				try {
					folder.create(true, true, new NullProgressMonitor());
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			IFile file = folder.getFile(filename);
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			outStream.write(generator.generate(argument));
			outStream.flush();
			
			if(!file.exists()){
				file.create(new ByteArrayInputStream(outStream.toByteArray()),false,new NullProgressMonitor());
			}
			else{
				file.setContents(new ByteArrayInputStream(outStream.toByteArray()),false,true,new NullProgressMonitor());
			}

			folder.refreshLocal(IFolder.DEPTH_INFINITE,new NullProgressMonitor());
			return file;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return null;
	}

	public IFormularResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

}
