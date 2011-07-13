
package org.emftext.language.javaforms.resource.javaforms.mopp;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.resource.util.JDTConnector;
import org.emftext.language.javaforms.codegen.Generate;
import org.emftext.language.javaforms.resource.javaforms.IJavaformsBuilder;
import org.emftext.language.javaforms.resource.javaforms.IJavaformsTextPrinter;
import org.emftext.language.javaforms.resource.javaforms.IJavaformsTextResource;
import org.emftext.language.javaformscodegen.impl.JavaPrinterImpl;

public class JavaformsBuilder implements IJavaformsBuilder {
	
	public boolean isBuildingNeeded(URI uri) {
		return true;
	}

	public IStatus build(JavaformsResource resource, IProgressMonitor monitor) {
		if (resource.getErrors().size() > 0) {
			return org.eclipse.core.runtime.Status.CANCEL_STATUS;
		}
		JDTConnector.getInstance().initializeResourceSet(resource.getResourceSet(), resource.getURI());
		EcoreUtil.resolveAll(resource);
		
		URI model = resource.getURI();
		if (isBinResource(model)) {
			return org.eclipse.core.runtime.Status.CANCEL_STATUS;
		}
		try {
			List<Object> parameters = new ArrayList<Object>();
			parameters.add(model.trimFileExtension().lastSegment() + "Wizard");
			parameters.add(getPackageName(model.trimSegments(1)));
			parameters.add(new JavaPrinterImpl() {

				@Override
				public String print(EObject object) {
					if (object == null) {
						return "true";
					}
					OutputStream outputStream = new ByteArrayOutputStream();
					try {
						IJavaformsTextPrinter printer = new JavaformsMetaInformation().createPrinter(outputStream, (IJavaformsTextResource) object.eResource());
						printer.print(object);
					} catch (IOException e) {
						e.printStackTrace();
					}
					return outputStream.toString();
				}
			});
			
			IResource member = getMember(model);
			new Generate(model, getTargetFolder(member), parameters).doGenerate(null);
			member.refreshLocal(1, monitor);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}

	private boolean isBinResource(URI model) {
		for (String segment : model.segments()) {
			if ("bin".equals(segment)) {
				return true;
			}
		}
		return false;
	}

	private String getPackageName(URI model) {
		if (model == null) {
			return "";
		}
		if ("src".equals(model.lastSegment().toString())) {
			return null;
		} else {
			String parentPackage = getPackageName(model.trimSegments(1));
			if (parentPackage == null) {
				return model.lastSegment().toString();
			} else {
				return parentPackage + "." + model.lastSegment().toString();
			}
		}
	}

	private File getTargetFolder(IResource member) {
		File targetFolder =  new File(member.getRawLocation().toOSString());
		return targetFolder;
	}

	private IResource getMember(URI model) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IResource member = root.findMember(model.trimSegments(1).toPlatformString(true));
		return member;
	}
}
