package org.emftext.language.ecore.resource.mecore.mopp;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.emftext.language.mecore.MModelElement;
import org.emftext.language.mecore.MPackage;

/**
 * This subclass of the generated class MinEcoreResource created a wrapped
 * version of the contents of the MinEcoreResource. This wrapped version is
 * an Ecore model.
 */
public class CustomMinEcoreResource extends MinEcoreResource {

	private MinEcoreWrapper wrapper = new MinEcoreWrapper();

	private boolean isWrapping;

	public CustomMinEcoreResource(URI uri) {
		super(uri);
	}

	@Override
	public EList<EObject> getContents() {
		if (isWrapping) {
			return createEmptyList();
		}
		isWrapping = true;
		EList<EObject> mContents = getContentsInternal();
		if (mContents.size() != 1) {
			isWrapping = false;
			return createEmptyList();
		}
		EObject root = mContents.get(0);
		if (!(root instanceof MPackage)) {
			isWrapping = false;
			return createEmptyList();
		}
		MPackage mPackage = (MPackage) root;
		EPackage ePackage = wrapper.wrapMPackage(mPackage);
		
		EList<EObject> result = createEmptyList();
		result.add(ePackage);
		isWrapping = false;
		return result;
	}

	@Override
	public String getURIFragment(EObject eObject) {
		int index = 0;
		Map<MModelElement, EModelElement> mapping = wrapper.getMapping();
		for (MModelElement mElement : mapping.keySet()) {
			if (mapping.get(mElement) == eObject) {
				String result = "/" + index;
				return result;
			}
			index++;
		}
		return "/-";
	}

	private EList<EObject> createEmptyList() {
		EList<EObject> result = new BasicInternalEList<EObject>(EObject.class);
		return result;
	}
}