package org.reuseware.emftextedit.language.java.jdtconnector;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IElementChangedListener;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.reuseware.emftextedit.language.java.resource.classfile.JavaSourceOrClassFileResourceFactoryImpl;

public class JavaEMFModelUpdateListener implements IElementChangedListener {
	

	private JavaSourceOrClassFileResourceFactoryImpl resourceFactory;
		
	public JavaEMFModelUpdateListener(
			JavaSourceOrClassFileResourceFactoryImpl factory) {
		this.resourceFactory = factory;
	}

	public void elementChanged(ElementChangedEvent event) {
		for(IJavaElementDelta delta : event.getDelta().getAffectedChildren()) {
			IJavaProject project = (IJavaProject) delta.getElement();
			
			try {
				for(IPackageFragmentRoot pRoot : project.getPackageFragmentRoots()) {
					for(IJavaElement pFragment : pRoot.getChildren()) {
						if (pFragment instanceof IPackageFragment) {
							registerPackage((IPackageFragment) pFragment);
						}
					}
				}
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}

	}

	protected void registerPackage(IPackageFragment pFragment) throws JavaModelException {
		for(ICompilationUnit cu : pFragment.getCompilationUnits()) {
			if(pFragment.isReadOnly()) {
				//construct binary
				//FIXME resourceFactory.registerCompiledCompilationUnit(pFragment.getElementName(), cu);
			}
			else {
				//source can be parsed
				URI uri = URI.createPlatformResourceURI(cu.getPath().toString(), false);
				//FIXME resourceFactory.registerSourceCompilationUnit(pFragment.getElementName(), cu, uri);
			}
		}
	}

}
