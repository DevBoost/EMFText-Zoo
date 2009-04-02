package org.emftext.language.java.util.types;

import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.NamespaceClassifierReference;
import org.emftext.language.java.types.TypeReference;

public class ClassifierReferenceUtil {

	/**
	 * Extracts the (possibly nested) classifier reference (if any) 
	 * from the given type references.
	 * 
	 * @param typeReference
	 * @return
	 */
	public static ClassifierReference getPureClassifierReference(TypeReference typeReference) {
		ClassifierReference classifierReference = null;
		if (typeReference instanceof ClassifierReference) {
			classifierReference = (ClassifierReference) typeReference;
		}
		if (typeReference instanceof NamespaceClassifierReference) {
			NamespaceClassifierReference nsClassifierReference = (NamespaceClassifierReference) typeReference;
			if (!nsClassifierReference.getClassifierReferences().isEmpty()) {
				int lastIndex = nsClassifierReference.getClassifierReferences().size() - 1;
				classifierReference = nsClassifierReference.getClassifierReferences().get(lastIndex);
			}
		}
		return classifierReference;
	}

}
