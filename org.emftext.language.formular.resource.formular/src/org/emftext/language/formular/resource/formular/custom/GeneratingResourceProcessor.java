package org.emftext.language.formular.resource.formular.custom;

import generator.fop.PSFormGenerator;
import generator.html.HTMLFormGenerator;
import generator.html.IPhoneFormGenerator;
import generator.html.IPhoneIndexGenerator;
import generator.xml.FOFormGenerator;
import generator.xml.XMLFormGenerator;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
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
				Formular formular = (Formular)eobject;
				createHTMLForm(formular);
				createIPhoneForm(formular);
				createXMLForm(formular);
				IFile result = createFoForm(formular);
				createPSForm(result,formular.getTitel());
			}
		}

	}

	private void createIPhoneForm(Formular formular) {
		final IPhoneFormGenerator iphoneFormGen = new IPhoneFormGenerator();
		generateForm(formular, "iphone",formular.getTitel()+".html", iphoneFormGen);
		final IPhoneIndexGenerator iphoneIndexGen = new IPhoneIndexGenerator();
		generateForm(formular, "iphone","index.html", iphoneIndexGen);
		
	}

	private void createHTMLForm(Formular formular) {
		final HTMLFormGenerator htmlFormGen = new HTMLFormGenerator();
		generateForm(formular, "html",formular.getTitel()+".html",htmlFormGen);
	}
	
	private void createXMLForm(Formular formular) {
		XMLFormGenerator xmlFormGenerator = new XMLFormGenerator();
		generateForm(formular, "xml",formular.getTitel()+".xml",xmlFormGenerator);
	}
	
	private IFile createFoForm(Formular formular) {
		FOFormGenerator foFormGenerator = new FOFormGenerator();
		return generateForm(formular,"xsl-fo",formular.getTitel()+".xml",foFormGenerator);
	}
	
	private IFile createPSForm(IFile foFile,String titel){
		PSFormGenerator psFormGenerator = new PSFormGenerator();
		return generateForm(foFile,foFile.getProject(),"ps",titel+".ps",psFormGenerator);

	}
	
	private IFile generateForm (Formular formular, String folderName, String filename,
			final IGenerator generator) {
		IFile resourceFile = WorkspaceSynchronizer.getFile(formular.eResource());
		return generateForm(formular,resourceFile.getProject(),folderName,filename,generator);
	}
	
	private IFile generateForm(Object argument,IProject targetProject, String folderName, String filename,
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
			PrintStream out = new PrintStream(outStream,false);
		
			out.print(generator.generate(argument));
			out.flush();
			out.close();
			
			if(!file.exists()){
				//file.setCharset("UTF-8",new NullProgressMonitor());
				file.create(new ByteArrayInputStream(outStream.toByteArray()),false,new NullProgressMonitor());
			}
			else{
				//file.setCharset("UTF-8",new NullProgressMonitor());
				file.setContents(new ByteArrayInputStream(outStream.toByteArray()),false,true,new NullProgressMonitor());
			}
			//		String uri = file.getLocation().toOSString();

		//	File f = new File(uri);
		//	output = new FileWriter(uri);
		//	writer = new BufferedWriter(output);
		//	writer.write(generator.generate(formular));
		//	writer.close();
			folder.refreshLocal(IFolder.DEPTH_INFINITE,new NullProgressMonitor());
			return file;
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return null;
	}

	public IResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

}
