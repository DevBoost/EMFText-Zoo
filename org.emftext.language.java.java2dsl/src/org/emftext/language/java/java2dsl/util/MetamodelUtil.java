package org.emftext.language.java.java2dsl.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.java.JavaPackage;
import org.emftext.language.java.closures.ClosuresPackage;
import org.emftext.language.java.properties.PropertiesPackage;

public class MetamodelUtil {

	private static final String extendString = "_transformed";
	
	/**
	 * Collect necessary meta model packages.
	 * 
	 * @return
	 */
	public static Collection<EPackage> collectMetaModels() {
		
		Collection<EPackage> metaPackages = new ArrayList<EPackage>();
		metaPackages.add(JavaPackage.eINSTANCE);
		metaPackages.add(PropertiesPackage.eINSTANCE);
		metaPackages.add(ClosuresPackage.eINSTANCE);
		
		System.out.println(metaPackages);
		
		return metaPackages;
		
	}
	
	/**
	 * Helper for XMI loading. Does lazy loading.
	 * Load a Resource with a name with the help of a ResourceSet.
	 * 
	 * @param xmlFileName
	 *            file name to load
	 * @return the EMF resource
	 */
	public static Resource getResource(String xmlFileName, ResourceSet rs) {
		URI uri = URI.createFileURI(xmlFileName);
		Resource resource = null;
		try {
			resource = rs.getResource(uri, true);
		} catch (Throwable fileNotFoundException) {
			resource = rs.createResource(uri);
		}
		return resource;
	}
	
	public static Resource getResource(URI fileURI, ResourceSet rs) {
		
		Resource resource = null;
		try {
			resource = rs.getResource(fileURI, true);
		} catch (Throwable fileNotFoundException) {
			resource = rs.createResource(fileURI);
		}
		return resource;
	}
	
	public static URI getTargetFileURI(
			URI sourcePathURI, 
			File sourceFile, 
			URI targetPathURI, 
			ResourceSet rs) throws Exception{
		
		URI srcURI = URI.createFileURI(sourceFile.getCanonicalPath());
		srcURI = rs.getURIConverter().normalize(srcURI);
		
		URI tempURI = sourcePathURI.appendSegment("");
		URI lastParts = srcURI.deresolve(tempURI);
		String[] segments = lastParts.segments();
		
		// kill '..' in segemnts
		ArrayList<String> tempSegemnts = new ArrayList<String>();
		for(int i=0; i<segments.length;i++){
			if(!segments[i].equals(".."))
				tempSegemnts.add(segments[i]);
		}
		String[] newSegments = new String[1];
		newSegments = tempSegemnts.toArray(newSegments);
		
		URI outFileURI = targetPathURI.appendSegments(newSegments);
		outFileURI = outFileURI.trimFileExtension().trimFileExtension();
		outFileURI = outFileURI.trimSegments(1).appendSegment(
				outFileURI.segment(outFileURI.segmentCount()-1).concat(extendString))
				.appendFileExtension("java.xmi");
		return outFileURI;
	}
}
