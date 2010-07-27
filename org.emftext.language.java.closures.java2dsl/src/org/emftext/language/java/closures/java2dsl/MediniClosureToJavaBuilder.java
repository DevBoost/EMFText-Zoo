package org.emftext.language.java.closures.java2dsl;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emftext.language.java.closures.resource.closure.IClosureBuilder;
import org.emftext.language.java.closures.resource.closure.mopp.ClosureBuilderAdapter;
import org.emftext.language.java.closures.resource.closure.mopp.ClosureResource;
import org.emftext.language.java.java2dsl.mediniqvt.MediniQVTStarter;
import org.emftext.language.java.resource.java.mopp.JavaResource;

public class MediniClosureToJavaBuilder extends ClosureBuilderAdapter implements IClosureBuilder {

	private static Stack<Thread> threads = new Stack<Thread>();
	private static int timeout = 3000000; //TODO
	private static int maxActiveThreads = 1;
	
	public boolean isBuildingNeeded(URI uri) {
		
		for(String segment : uri.segmentsList()){
			if(segment.toLowerCase().equals("bin"))
				return false;
		}

		return true;
	}
	
	public IProject[] build(int kind, @SuppressWarnings("rawtypes") Map args, IProgressMonitor monitor)
			throws CoreException {
		
		return build(kind, args, monitor, this, getProject()); 
	}
	
	public IStatus build(final ClosureResource resource, IProgressMonitor monitor) {
		
		Thread root = new Thread(new Runnable(){

			public void run() {
				callThreads(resource);
			}
			
		},"RootThread");
		root.start();
		
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}

	private void callThreads(final ClosureResource resource){
	
		while(threads.size() >= maxActiveThreads) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			continue;
		}
		
		Runnable runnable = new Runnable(){ 
			
			public void run() {
				convert(resource);
				
				threads.remove(Thread.currentThread());
			}
		};
		
		final Thread workerThread = new Thread(runnable,"PostProcessor");
		threads.add(workerThread);
		
		final Thread timeoutThread = new Thread(new Runnable() {
	
			@SuppressWarnings("deprecation")
			public void run() {
				try {
					workerThread.join(timeout);
					boolean wasStillAlive = workerThread.isAlive();
					if(wasStillAlive)
						System.out.println("interrupt: " + workerThread);
					workerThread.stop();
					while (workerThread.isAlive()) {
						System.out.println(workerThread.toString() + "is still there!");
						Thread.sleep(100);
					}
					if (wasStillAlive) {
						System.out.println("Run was interrupted by timeout.");
					}
				}
				catch (Exception e1) {
					System.out.println(e1);
				}
				threads.remove(workerThread);
			}
		}, "Timeout Thread");
		
		workerThread.start();
		timeoutThread.start();
	}
	
	private void convert(ClosureResource resource){
		
		init(resource.getResourceSet());
		
		URI xmiSourceURI = 
			resource.getURI().appendFileExtension("xmi");
		
		URI javaResourceURI =
			resource.getURI().trimFileExtension().trimSegments(1).appendSegment(
					resource.getURI().trimFileExtension().segment(
							resource.getURI().segmentCount()-1)
							.concat("_transformed")).appendFileExtension("java");
		
		URI xmiTargetURI = 
			resource.getURI().trimFileExtension().trimSegments(1).appendSegment(
				resource.getURI().trimFileExtension().segment(
						resource.getURI().segmentCount()-1)
						.concat("_transformed")).appendFileExtension("closure.xmi");
	//		resource.getURI().trimFileExtension().trimSegments(
	//				resource.getURI().segmentCount()-2);
	
		URI transformationFileURI = 
			resource.getURI().trimFileExtension()
				.trimSegments(resource.getURI().segmentCount()-2)
				.appendSegment("transformations")
				.appendSegment("java2closure")
				.appendFileExtension("qvt");
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IPath rootPath = root.getLocation();
		File rootPathFile = rootPath.toFile();
		String transformationFileURIString = 
			rootPathFile.toString().concat(transformationFileURI.toPlatformString(true));
	//	transformationFileURIString =
	//		transformationFileURIString.replaceAll("\\\\", "/").concat("file:/");
		
		if(new File(transformationFileURIString).exists()){
		
			XMIResource xmiResource = 
				(XMIResource)resource.getResourceSet().createResource(xmiSourceURI);
			
			xmiResource.getContents().addAll(EcoreUtil.copyAll(resource.getContents()));
	
			try {
				xmiResource.save(null);
			} catch (IOException e) {
				System.out.println(e);
			}
	
			MediniQVTStarter starter = new MediniQVTStarter(
					xmiSourceURI, 
					xmiTargetURI,
					rootPathFile.toString(),
					transformationFileURIString, 
					rootPathFile.toString().concat(xmiSourceURI.toPlatformString(true)), 
					"copy", 
					"JAVA", 
					"ClosureMediniStatisticUtil", 
					Arrays.asList("Closures_Closure"));
			
			if(starter.isHandledInterestingRules()){
			
				ClosureResource closureResource = 
					(ClosureResource)resource.getResourceSet().createResource(javaResourceURI);
			
				XMIResource xmiResourceTransformed = 
					(XMIResource)resource.getResourceSet().createResource(xmiTargetURI);
				
				try {
					xmiResourceTransformed.load(null);
				} catch (IOException e) {
					System.out.println(e);
				}
				
				closureResource.getContents().addAll(xmiResourceTransformed.getContents());
								
				try {
					closureResource.save(null);
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			
			//TODO
	//		try {
	//			xmiResource.delete(null);
	//		} catch (IOException e) {}
		}
	}
	
	private void init(ResourceSet resourceSet){
		
		// initialize resource set of models
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
		    Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		
		
	}
}