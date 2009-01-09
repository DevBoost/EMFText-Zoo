package org.emftext.language.java.resource.pkg;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.core.CompilationUnit;
import org.emftext.language.java.core.Package;
import org.emftext.language.java.resource.java.JavaTreeAnalyser;
import org.emftext.runtime.resource.IReferenceResolver;
import org.emftext.runtime.resource.ITextResource;

public class CustomPkgResourceImpl extends org.emftext.runtime.resource.impl.TextResourceImpl {
	private org.emftext.runtime.resource.IReferenceResolver analyser;


	public CustomPkgResourceImpl() {
		super();
	}

	public CustomPkgResourceImpl(org.eclipse.emf.common.util.URI uri) {
		super(uri);
	}

	protected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		java.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(options);
		java.io.InputStream actualInputStream = inputStream;
		
		IContainer container = WorkspaceSynchronizer.getFile(this).getParent();
		IResource[] members;
		List<CompilationUnit> units = new ArrayList<CompilationUnit>();
		
		
		
		
		Object inputStreamPreProcessorProvider = loadOptions.get(org.emftext.runtime.IOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER);
		if (inputStreamPreProcessorProvider != null) {
			if (inputStreamPreProcessorProvider instanceof org.emftext.runtime.IInputStreamProcessorProvider) {
				actualInputStream = ((org.emftext.runtime.IInputStreamProcessorProvider) inputStreamPreProcessorProvider).getInputStreamProcessor(inputStream);
			}
		}
		org.emftext.runtime.resource.ITextParser p = new PkgParser(new org.antlr.runtime.CommonTokenStream(new PkgLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream))));
		p.setResource(this);
		p.setOptions(loadOptions);
		org.eclipse.emf.ecore.EObject root = p.parse();
		while (root != null && root instanceof Package) {
			Package thisPackage = (Package) root;
			getContents().add(thisPackage);
			
			try {
				members = container.members();
				for (IResource resource : members) {
					if (resource instanceof IFile) {
						IFile file = (IFile) resource;
						if (file.getFileExtension().equals("java")) {
							//URI fileUri = URI.createFileURI( file.getFullPath().toString());
							URI resourceUri = URI.createURI("platform:/resource" + file.getFullPath().toString());
							
							ITextResource textResource = (ITextResource) getResourceSet().createResource(resourceUri);
							textResource.load(options);
						
							if (!textResource.getContents().isEmpty()) {
								CompilationUnit cUnit = (CompilationUnit) textResource.getContents().get(0);
								//only for not yet registered
//								if(!JavaClasspath.INSTANCE.URI_MAP.values().contains(resourceUri)) {
//									JavaClasspath.INSTANCE.registerClassifierSource(cUnit, resourceUri);
//								}
								units.add(cUnit);
								System.out.println("Loaded: " + file + ": " + cUnit);
							}
							
						}
					}
				}
			
			} catch (CoreException e) {
				e.printStackTrace();
				
			}
			
			thisPackage.getCompilationUnits().addAll(units);			
			root = null;
		}

		
		
		
		IReferenceResolver treeAnalyser = getTreeAnalyser();

		treeAnalyser.setOptions(loadOptions);
		
	}

	protected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {
		org.emftext.runtime.resource.ITextPrinter p = new PkgPrinter(outputStream, this);
		for(org.eclipse.emf.ecore.EObject root : getContents()) {
			p.print(root);
		}
	}

	public String[] getTokenNames() {
		return new PkgParser(null).getTokenNames();
	}

	public Object getScanner() {
		return new PkgLexer();
	}

	public org.emftext.runtime.resource.IReferenceResolver getTreeAnalyser() {
		if (analyser == null) {
			analyser = new JavaTreeAnalyser();
		}
		return analyser;
	}

	public void doUnload(){
		super.doUnload();
		analyser=null;
	}
}
