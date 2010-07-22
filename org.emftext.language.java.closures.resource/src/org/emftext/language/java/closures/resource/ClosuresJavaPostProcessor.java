package org.emftext.language.java.closures.resource;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emftext.language.java.closures.resource.closure.mopp.ClosureResource;
import org.emftext.language.java.resource.java.IJavaOptionProvider;
import org.emftext.language.java.resource.java.IJavaOptions;
import org.emftext.language.java.resource.java.IJavaResourcePostProcessor;
import org.emftext.language.java.resource.java.IJavaResourcePostProcessorProvider;
import org.emftext.language.java.resource.java.mopp.JavaResource;
import org.emftext.language.mapping.qvto.test.QVTOStarter;

public class ClosuresJavaPostProcessor implements IJavaOptionProvider,
		IJavaResourcePostProcessor, IJavaResourcePostProcessorProvider {

	private static Stack<Thread> threads = new Stack<Thread>();
	private static int timeout = 300000; //TODO
	private static int maxActiveThreads = 1;
	
	@Override
	public IJavaResourcePostProcessor getResourcePostProcessor() { 
		return this;
	}

	@Override
	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IJavaOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return map;
	}
	
	@Override
	public void process(final JavaResource resource) {
		
		Thread root = new Thread(new Runnable(){

			@Override
			public void run() {
				callThreads(resource);
			}
			
		},"RootThread");
		root.start();
	}
	
	private void callThreads(final JavaResource resource){
		
		while(threads.size() >= maxActiveThreads) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			continue;
		}
		
		Runnable runnable = new Runnable(){ 
			@Override
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
	
	private void convert(JavaResource resource){
		
		init(resource.getResourceSet());
		
		URI xmiSourceURI = 
			resource.getURI().appendFileExtension("xmi");
		
		URI closureResourceURI =
			resource.getURI().trimFileExtension().trimSegments(1).appendSegment(
					resource.getURI().trimFileExtension().segment(
							resource.getURI().segmentCount()-1)
							.concat("_transformed")).appendFileExtension("closure");
		
		URI xmiTargetURI = 
			resource.getURI().trimFileExtension().trimSegments(1).appendSegment(
				resource.getURI().trimFileExtension().segment(
						resource.getURI().segmentCount()-1)
						.concat("_transformed")).appendFileExtension("java.xmi");
//			resource.getURI().trimFileExtension().trimSegments(
//					resource.getURI().segmentCount()-2);

		URI transformationFileURI = 
			resource.getURI().trimFileExtension()
				.trimSegments(resource.getURI().segmentCount()-2)
				.appendSegment("transformations")
				.appendSegment("java2closure")
				.appendFileExtension("qvto");
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IPath rootPath = root.getLocation();
		File file = rootPath.toFile();
		String transformationFileURIString = 
			file.toString().concat(transformationFileURI.toPlatformString(true));
//		transformationFileURIString =
//			transformationFileURIString.replaceAll("\\\\", "/").concat("file:/");
		
		if(new File(transformationFileURIString).exists()){
		
			XMIResource xmiResource = 
				(XMIResource)resource.getResourceSet().createResource(xmiSourceURI);
			
			xmiResource.getContents().addAll(EcoreUtil.copyAll(resource.getContents()));

			try {
				xmiResource.save(null);
			} catch (IOException e) {}

			QVTOStarter starter = new QVTOStarter(
					xmiSourceURI,
					xmiTargetURI,
					transformationFileURI,
					file.toString().concat(xmiSourceURI.toPlatformString(true)),
					true,
					"ClosureStatisticUtil",
					Arrays.asList("Closures_Closure"));
			
			if(starter.isHandledInterestingRules()){
			
				ClosureResource closureResource = 
					(ClosureResource)resource.getResourceSet().createResource(closureResourceURI);
			
				XMIResource xmiResourceTransformed = 
					(XMIResource)resource.getResourceSet().createResource(xmiSourceURI);
				
				try {
					xmiResourceTransformed.load(null);
				} catch (IOException e1) {}
				
				closureResource.getContents().addAll(xmiResourceTransformed.getContents());
								
				try {
					closureResource.save(null);
				} catch (IOException e) {}
			}
			
			//TODO
//			try {
//				xmiResource.delete(null);
//			} catch (IOException e) {}
		}
	}
	
	private void init(ResourceSet resourceSet){
		
		// initialize resource set of models
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
		    Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		
		
	}

	

}
