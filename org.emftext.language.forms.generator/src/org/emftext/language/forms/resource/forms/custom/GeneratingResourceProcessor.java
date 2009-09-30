package org.emftext.language.forms.resource.forms.custom;

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
import org.emftext.language.forms.Form;
import org.emftext.language.forms.resource.forms.IFormsResourcePostProcessor;
import org.emftext.language.forms.resource.forms.IFormsResourcePostProcessorProvider;
import org.emftext.language.forms.resource.forms.mopp.FormsResource;

public class GeneratingResourceProcessor implements IFormsResourcePostProcessor,
		IFormsResourcePostProcessorProvider {

	public void process(FormsResource resource) {
		EList<EObject> contents = resource.getContents();
		
		Set<EObject> distinctObjects = new HashSet<EObject>();
		distinctObjects.addAll(contents);
		for (EObject eobject : distinctObjects) {
			if (eobject instanceof Form) {
				final Form form = (Form)eobject;
				final IProject project = WorkspaceSynchronizer.getFile(form.eResource()).getProject();
				Job creationJob = new Job("Generating Forms") {

					@Override
					protected IStatus run(IProgressMonitor monitor) {
						createHTMLForm(project,form);
						createIPhoneForm(project,form);
						createXMLForm(project,form);
						IFile result = createFoForm(project,form);
						createPSForm(result,form.getCaption());
						return Status.OK_STATUS;
					}
					
				};
				
				creationJob.schedule();
			}
		}

	}

	private void createIPhoneForm(IProject project, Form form) {
		final IPhoneFormGenerator iphoneFormGen = new IPhoneFormGenerator();
		generateForm(project,form, "iphone",form.getCaption()+".html", iphoneFormGen);
		final IPhoneIndexGenerator iphoneIndexGen = new IPhoneIndexGenerator();
		generateForm(project,form, "iphone","index.html", iphoneIndexGen);
		
	}

	private void createHTMLForm(IProject project, Form form) {
		final HTMLFormGenerator htmlFormGen = new HTMLFormGenerator();
		generateForm(project,form, "html",form.getCaption()+".html",htmlFormGen);
	}
	
	private void createXMLForm(IProject project, Form form) {
		XMLFormGenerator xmlFormGenerator = new XMLFormGenerator();
		generateForm(project,form, "xml",form.getCaption()+".xml",xmlFormGenerator);
	}
	
	private IFile createFoForm(IProject project, Form form) {
		FOFormGenerator foFormGenerator = new FOFormGenerator();
		return generateForm(project,form,"xsl-fo",form.getCaption()+".xml",foFormGenerator);
	}
	
	private IFile createPSForm(IFile foFile,String titel){
		PDFFormGenerator psFormGenerator = new PDFFormGenerator();
		return generateForm(foFile.getProject(),foFile,"pdf",titel+".pdf",psFormGenerator);
	}

	
	private IFile generateForm(IProject targetProject,Object argument, String folderName, String filename,
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

	public IFormsResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

}
