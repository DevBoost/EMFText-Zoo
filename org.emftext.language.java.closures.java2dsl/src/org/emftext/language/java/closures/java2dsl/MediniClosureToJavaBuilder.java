package org.emftext.language.java.closures.java2dsl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
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
import org.emftext.language.java.java2dsl.mediniqvt.MediniQVTDirectionEnum;
import org.emftext.language.java.java2dsl.mediniqvt.MediniQVTStarter;
import org.emftext.language.java.resource.java.mopp.JavaResource;
import org.emftext.sdk.util.StreamUtil;

public class MediniClosureToJavaBuilder extends ClosureBuilderAdapter implements IClosureBuilder {

	private static Stack<Thread> threads = new Stack<Thread>();
	private static int timeout = 30000000; //TODO
	private static int maxActiveThreads = 1;
	private static Map<URI,Thread> semaphoreMap = new HashMap<URI,Thread>();
	
	public boolean isBuildingNeeded(URI uri) {
		
		for(String segment : uri.segmentsList()){
			if(segment.toLowerCase().equals("bin"))
				return false;
		}
		
		if(uri.segment(uri.segmentCount()-1).contains("_transformed"))
			return false;
		
		if(semaphoreMap.containsKey(uri))
			return false;

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
		
		semaphoreMap.put(resource.getURI(), root);
		root.start();
		semaphoreMap.remove(resource.getURI());
		
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
			resource.getURI().trimFileExtension().appendFileExtension("java");
		
		URI xmiTargetURI = 
			resource.getURI().trimFileExtension().appendFileExtension("java.xmi");
	
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
					Arrays.asList("Closures_Closure"),
					MediniQVTDirectionEnum.DSL2JAVA);
			
			if(starter.isHandledInterestingRules()){
			
				JavaResource javaResource = 
					(JavaResource)resource.getResourceSet().createResource(javaResourceURI);
			
				XMIResource xmiResourceTransformed = 
					(XMIResource)resource.getResourceSet().createResource(xmiTargetURI);
				
				try {
					xmiResourceTransformed.load(null);
				} catch (IOException e) {
					System.out.println(e);
				}
				
				javaResource.getContents().addAll(
						EcoreUtil.copyAll(
								xmiResourceTransformed.getContents()));
								
				// TODO neu
				
				URI javaTempResourceURI =
					resource.getURI().trimFileExtension().trimSegments(1).appendSegment(
							resource.getURI().trimFileExtension().segment(
									resource.getURI().segmentCount()-1)
									.concat("_transformed")).appendFileExtension("java");
				JavaResource javaResourceTemp = 
					(JavaResource)resource.getResourceSet().createResource(javaTempResourceURI);
			
				javaResourceTemp.getContents().addAll(
						EcoreUtil.copyAll(xmiResourceTransformed.getContents()));
				try {
					javaResourceTemp.save(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				File javaResourceTempFile = new File(
					rootPathFile.toString().concat(javaTempResourceURI.toPlatformString(true)));
				File javaResourceFile = new File(
						rootPathFile.toString().concat(javaResourceURI.toPlatformString(true)));
					
				boolean hasContentChanged = false;
				
				try {
					ByteArrayInputStream closureResourceTempFileBytes =
						 new ByteArrayInputStream(StreamUtil.getContent(javaResourceTempFile));
						
					hasContentChanged = 
						StreamUtil.storeContentIfChanged(
								javaResourceFile, closureResourceTempFileBytes);
					if(hasContentChanged)
						System.out.println(javaResourceURI + " content was changed!");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				try {
					javaResourceTemp.delete(null);
				} catch (IOException e) {
					e.printStackTrace();
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
