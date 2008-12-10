package org.emftext.language.java.resource.classfile;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.Class;
import org.emftext.language.java.Classifier;
import org.emftext.language.java.Interface;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.JavaUniquePathConstructor;
import org.emftext.language.java.QualifiedTypeArgument;
import org.emftext.language.java.TypeReferenceSequence;
import org.emftext.language.java.resource.java.JavaResourceImpl;

public class JavaSourcFileResourceImpl extends JavaResourceImpl {

	public JavaSourcFileResourceImpl(URI uri) {
		super(uri);
	}

	@Override
	public EObject getEObject(String id) {
		EObject result = super.getEObject(id);
		if (result != null) {
			return result;
		} else {
			System.out.println("");
		}
		return result;
	}

	@Override
	protected EObject getEObject(List<String> uriFragmentPath) {
		int size = uriFragmentPath.size();
		EObject eObject = getEObjectForURIFragmentRootSegment(size == 0 ? ""
				: uriFragmentPath.get(0));
		for (int i = 1; i < size && eObject != null; ++i) {
			// default
			EObject nextEObject = ((InternalEObject) eObject)
					.eObjectForURIFragmentSegment(uriFragmentPath.get(i));
			if (nextEObject != null) {
				eObject = nextEObject;
			} else {
				if (eObject instanceof Classifier) {
					eObject = handleClassifiers((Classifier) eObject,
							uriFragmentPath.get(i));
				}
			}
		}

		return eObject;
	}

	protected EObject handleClassifiers(Classifier javaClassifier, String id) {
		List<Classifier> superClassifierList = null;

		if (javaClassifier instanceof Class) {
			superClassifierList = getAllSuperType((Class) javaClassifier);
		} else {
			// TODO
			System.out.println("");
		}

		for (Classifier superClassifier : superClassifierList) {
			EObject member = resolveMember(superClassifier, id);
			if (member != null) {
				return member;
			}
		}

		return null;
	}

	protected EList<Classifier> getAllSuperType(Class javaClass) {
		EList<Classifier> superClassifierList = new BasicEList<Classifier>();
		EList<Interface> ifList = new BasicEList<Interface>();
		Class superClass = javaClass;
		while (!superClass.getName().equals("Object")) {
			if (superClass.getExtends() != null) {
				TypeReferenceSequence typeRef = (TypeReferenceSequence) superClass.getExtends().getType();
				superClass = (Class) typeRef.getParts().get(typeRef.getParts().size() - 1).getTarget();
			} else {
				superClass = (Class) JavaClasspath.INSTANCE.getClassifiers(
						"java.lang", "Object").get(0);
				superClass = (Class) EcoreUtil.resolve(superClass, this);
			}
			superClassifierList.add(superClass);

		}
		return superClassifierList;

	}

	protected void collectAllImplementedInterfaces(
			EList<Interface> interfaceList) {
		for (Interface javaIf : new BasicEList<Interface>(interfaceList)) {
			for (QualifiedTypeArgument typeArg : javaIf.getExtends()) {
				typeArg.getType();
			}
		}
	}

	protected EObject resolveMember(EObject eObject, String id) {
		// TODO implement analyses of argument types
		return ((InternalEObject) eObject).eObjectForURIFragmentSegment(id);
	}

}
