
package org.emftext.language.eag.resource.eag.analysis;

import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.eag.Import;
import org.emftext.language.eag.resource.eag.IEagReferenceResolveResult;
import org.emftext.language.eag.resource.eag.IEagReferenceResolver;

public class ImportImportedPackageReferenceResolver implements IEagReferenceResolver<Import, EPackage> {
	
	public void resolve(String identifier, Import container, EReference reference, int position, boolean resolveFuzzy, final IEagReferenceResolveResult<EPackage> result) {
		Registry registry = EPackage.Registry.INSTANCE;
		Set<String> namespaceURIs = registry.keySet();
		for (String namespaceURI : namespaceURIs) {
			EPackage ePackage = registry.getEPackage(namespaceURI);
			if (ePackage == null) {
				continue;
			}
			if (resolveFuzzy || identifier.equals(namespaceURI)) {
				result.addMapping(namespaceURI, ePackage);
				if (!resolveFuzzy) {
					return;
				}
			}
		}
	}
	
	public String deResolve(EPackage element, Import container, EReference reference) {
		return element.getNsURI();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
	}
}
