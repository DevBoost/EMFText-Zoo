/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.hedl.resource.hedl.mopp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.emftext.language.hedl.Entity;
import org.emftext.language.hedl.EntityModel;
import org.emftext.language.hedl.codegen.DAOGenerator;
import org.emftext.language.hedl.resource.hedl.util.HedlStringUtil;


public class HedlBuilder implements org.emftext.language.hedl.resource.hedl.IHedlBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
		// TODO that this is not a 'bin' folder
		return true;
	}
	
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.hedl.resource.hedl.mopp.HedlResource resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		URI uri = resource.getURI();
		String packageName = getPackageName(uri);
		IFile modelFile = WorkspaceSynchronizer.getFile(resource);
		IContainer modelFolder = modelFile.getParent();
		File modelFolderFile = modelFolder.getRawLocation().toFile();
		
		DAOGenerator daoGenerator = new DAOGenerator();
		// set option overrideBuilder to 'false' and then perform build here
		TreeIterator<EObject> allContents = resource.getAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (next instanceof Entity) {
				Entity entity = (Entity) next;
				// generate entity base class
				StringConcatenation result = daoGenerator.generateEntityBaseClass(packageName, entity);
				saveGeneratedClass(modelFolderFile, result.toString(), entity.getName());
				// generate entity DAO class
				result = daoGenerator.generateEntityDAO(packageName, entity);
				saveGeneratedClass(modelFolderFile, result.toString(), entity.getName() + "DAO");
			} else if (next instanceof EntityModel) {
				EntityModel entityModel = (EntityModel) next;
				StringConcatenation result = daoGenerator.generateIDBOperations(packageName, entityModel);
				saveGeneratedClass(modelFolderFile, result.toString(), "IDBOperations");
				result = daoGenerator.generateICommand(packageName);
				saveGeneratedClass(modelFolderFile, result.toString(), "ICommand");
				result = daoGenerator.generateMainDAO(packageName, entityModel);
				saveGeneratedClass(modelFolderFile, result.toString(), "MainDAO");
				result = daoGenerator.generateOngoingShutdownException(packageName);
				saveGeneratedClass(modelFolderFile, result.toString(), "OngoingShutdownException");
			}
		}
		try {
			modelFolder.refreshLocal(1, new NullProgressMonitor());
		} catch (CoreException e) {
			// ignore
		}
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}

	private void saveGeneratedClass(File modelFolderFile, String content,
			String classname) {
		File entityClassFile = new File(modelFolderFile, classname + ".java");
		try {
			FileOutputStream fos = new FileOutputStream(entityClassFile);
			fos.write(content.getBytes());
			fos.close();
		} catch (IOException e) {
			HedlPlugin.logError("Excpetion while generating code.", e);
		}
	}

	private String getPackageName(URI uri) {
		String packageName = new String();
		String[] segments = uri.trimFileExtension().trimSegments(1).segments();
		List<String> packages = new ArrayList<String>();
		for (int i = segments.length - 1; i >= 0; i--) {
			String segment = segments[i];
			if (isSourceFolder(segment)) {
				break;
			}
			packages.add(0, segment);
		}
		packageName = HedlStringUtil.explode(packages, ".");
		return packageName;
	}

	private boolean isSourceFolder(String segment) {
		return segment.startsWith("src");
	}
}
