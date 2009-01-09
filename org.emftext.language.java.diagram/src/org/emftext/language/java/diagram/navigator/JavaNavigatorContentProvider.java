package org.emftext.language.java.diagram.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;
import org.emftext.language.java.diagram.edit.parts.Annotation2EditPart;
import org.emftext.language.java.diagram.edit.parts.AnnotationAnnotationMembersCompartment2EditPart;
import org.emftext.language.java.diagram.edit.parts.AnnotationAnnotationMembersCompartmentEditPart;
import org.emftext.language.java.diagram.edit.parts.AnnotationEditPart;
import org.emftext.language.java.diagram.edit.parts.AnnotationMethodEditPart;
import org.emftext.language.java.diagram.edit.parts.BlockEditPart;
import org.emftext.language.java.diagram.edit.parts.Class2EditPart;
import org.emftext.language.java.diagram.edit.parts.ClassClassMembersCompartment2EditPart;
import org.emftext.language.java.diagram.edit.parts.ClassClassMembersCompartmentEditPart;
import org.emftext.language.java.diagram.edit.parts.ClassEditPart;
import org.emftext.language.java.diagram.edit.parts.ClassifierImportClassifiersEditPart;
import org.emftext.language.java.diagram.edit.parts.ClassifierImportEditPart;
import org.emftext.language.java.diagram.edit.parts.CompilationUnitCompilationUnitClassifiersCompartmentEditPart;
import org.emftext.language.java.diagram.edit.parts.CompilationUnitCompilationUnitImportsCompartmentEditPart;
import org.emftext.language.java.diagram.edit.parts.CompilationUnitEditPart;
import org.emftext.language.java.diagram.edit.parts.ConstructorEditPart;
import org.emftext.language.java.diagram.edit.parts.Enumeration2EditPart;
import org.emftext.language.java.diagram.edit.parts.EnumerationEditPart;
import org.emftext.language.java.diagram.edit.parts.EnumerationEnumerationMembersCompartment2EditPart;
import org.emftext.language.java.diagram.edit.parts.EnumerationEnumerationMembersCompartmentEditPart;
import org.emftext.language.java.diagram.edit.parts.FieldEditPart;
import org.emftext.language.java.diagram.edit.parts.Interface2EditPart;
import org.emftext.language.java.diagram.edit.parts.InterfaceEditPart;
import org.emftext.language.java.diagram.edit.parts.InterfaceInterfaceMembersCompartment2EditPart;
import org.emftext.language.java.diagram.edit.parts.InterfaceInterfaceMembersCompartmentEditPart;
import org.emftext.language.java.diagram.edit.parts.MethodEditPart;
import org.emftext.language.java.diagram.edit.parts.PackageDescriptor2EditPart;
import org.emftext.language.java.diagram.edit.parts.PackageDescriptorEditPart;
import org.emftext.language.java.diagram.edit.parts.PackageEditPart;
import org.emftext.language.java.diagram.edit.parts.StaticImportEditPart;
import org.emftext.language.java.diagram.edit.parts.StaticImportStaticMembersEditPart;
import org.emftext.language.java.diagram.part.JavaVisualIDRegistry;
import org.emftext.language.java.diagram.part.Messages;

/**
 * @generated
 */
public class JavaNavigatorContentProvider implements ICommonContentProvider {

	/**
	 * @generated
	 */
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	 * @generated
	 */
	private Viewer myViewer;

	/**
	 * @generated
	 */
	private AdapterFactoryEditingDomain myEditingDomain;

	/**
	 * @generated
	 */
	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	/**
	 * @generated
	 */
	private Runnable myViewerRefreshRunnable;

	/**
	 * @generated
	 */
	public JavaNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
				.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new HashMap() {
			public Object get(Object key) {
				if (!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {
			public void run() {
				if (myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain,
				new WorkspaceSynchronizer.Delegate() {
					public void dispose() {
					}

					public boolean handleResourceChanged(final Resource resource) {
						for (Iterator it = myEditingDomain.getResourceSet()
								.getResources().iterator(); it.hasNext();) {
							Resource nextResource = (Resource) it.next();
							nextResource.unload();
						}
						if (myViewer != null) {
							myViewer.getControl().getDisplay().asyncExec(
									myViewerRefreshRunnable);
						}
						return true;
					}

					public boolean handleResourceDeleted(Resource resource) {
						for (Iterator it = myEditingDomain.getResourceSet()
								.getResources().iterator(); it.hasNext();) {
							Resource nextResource = (Resource) it.next();
							nextResource.unload();
						}
						if (myViewer != null) {
							myViewer.getControl().getDisplay().asyncExec(
									myViewerRefreshRunnable);
						}
						return true;
					}

					public boolean handleResourceMoved(Resource resource,
							final URI newURI) {
						for (Iterator it = myEditingDomain.getResourceSet()
								.getResources().iterator(); it.hasNext();) {
							Resource nextResource = (Resource) it.next();
							nextResource.unload();
						}
						if (myViewer != null) {
							myViewer.getControl().getDisplay().asyncExec(
									myViewerRefreshRunnable);
						}
						return true;
					}
				});
	}

	/**
	 * @generated
	 */
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		for (Iterator it = myEditingDomain.getResourceSet().getResources()
				.iterator(); it.hasNext();) {
			Resource resource = (Resource) it.next();
			resource.unload();
		}
		((TransactionalEditingDomain) myEditingDomain).dispose();
		myEditingDomain = null;
	}

	/**
	 * @generated
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
	}

	/**
	 * @generated
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath()
					.toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(
					fileURI, true);
			Collection result = new ArrayList();
			result.addAll(createNavigatorItems(selectViewsByType(resource
					.getContents(), PackageEditPart.MODEL_ID), file, false));
			return result.toArray();
		}

		if (parentElement instanceof JavaNavigatorGroup) {
			JavaNavigatorGroup group = (JavaNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof JavaNavigatorItem) {
			JavaNavigatorItem navigatorItem = (JavaNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		/*
		 * Due to plugin.xml restrictions this code will be called only for views representing
		 * shortcuts to this diagram elements created on other diagrams. 
		 */
		if (parentElement instanceof IAdaptable) {
			View view = (View) ((IAdaptable) parentElement)
					.getAdapter(View.class);
			if (view != null) {
				return getViewChildren(view, parentElement);
			}
		}

		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Object[] getViewChildren(View view, Object parentElement) {
		switch (JavaVisualIDRegistry.getVisualID(view)) {

		case PackageEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			result.addAll(getForeignShortcuts((Diagram) view, parentElement));
			JavaNavigatorGroup links = new JavaNavigatorGroup(
					Messages.NavigatorGroupName_Package_1000_links,
					"icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view), CompilationUnitEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view),
					ClassifierImportClassifiersEditPart.VISUAL_ID);
			links
					.addChildren(createNavigatorItems(connectedViews, links,
							false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view),
					StaticImportStaticMembersEditPart.VISUAL_ID);
			links
					.addChildren(createNavigatorItems(connectedViews, links,
							false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case CompilationUnitEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			Collection connectedViews = getChildrenByType(
					Collections.singleton(view),
					CompilationUnitCompilationUnitClassifiersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ClassEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					CompilationUnitCompilationUnitClassifiersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Enumeration2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					CompilationUnitCompilationUnitClassifiersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Interface2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					CompilationUnitCompilationUnitClassifiersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Annotation2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					CompilationUnitCompilationUnitClassifiersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					PackageDescriptor2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					CompilationUnitCompilationUnitImportsCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ClassifierImportEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					CompilationUnitCompilationUnitImportsCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					StaticImportEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case ClassEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			JavaNavigatorGroup incominglinks = new JavaNavigatorGroup(
					Messages.NavigatorGroupName_Class_3030_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					ClassClassMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					AnnotationMethodEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ClassClassMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Class2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ClassClassMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					EnumerationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ClassClassMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					InterfaceEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ClassClassMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					FieldEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ClassClassMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					MethodEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ClassClassMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					AnnotationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ClassClassMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					PackageDescriptorEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ClassClassMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ConstructorEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ClassClassMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BlockEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					ClassifierImportClassifiersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					StaticImportStaticMembersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case AnnotationMethodEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			JavaNavigatorGroup incominglinks = new JavaNavigatorGroup(
					Messages.NavigatorGroupName_AnnotationMethod_3031_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view),
					StaticImportStaticMembersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case Class2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			JavaNavigatorGroup incominglinks = new JavaNavigatorGroup(
					Messages.NavigatorGroupName_Class_3032_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					ClassClassMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					AnnotationMethodEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ClassClassMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Class2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ClassClassMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					EnumerationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ClassClassMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					InterfaceEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ClassClassMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					FieldEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ClassClassMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					MethodEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ClassClassMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					AnnotationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ClassClassMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					PackageDescriptorEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ClassClassMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ConstructorEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ClassClassMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BlockEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					ClassifierImportClassifiersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					StaticImportStaticMembersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case EnumerationEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			JavaNavigatorGroup incominglinks = new JavaNavigatorGroup(
					Messages.NavigatorGroupName_Enumeration_3033_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					EnumerationEnumerationMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					AnnotationMethodEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					EnumerationEnumerationMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Class2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					EnumerationEnumerationMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					EnumerationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					EnumerationEnumerationMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					InterfaceEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					EnumerationEnumerationMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					FieldEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					EnumerationEnumerationMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					MethodEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					EnumerationEnumerationMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					AnnotationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					EnumerationEnumerationMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					PackageDescriptorEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					EnumerationEnumerationMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ConstructorEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					EnumerationEnumerationMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BlockEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					ClassifierImportClassifiersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					StaticImportStaticMembersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case InterfaceEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			JavaNavigatorGroup incominglinks = new JavaNavigatorGroup(
					Messages.NavigatorGroupName_Interface_3034_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					InterfaceInterfaceMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					AnnotationMethodEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					InterfaceInterfaceMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Class2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					InterfaceInterfaceMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					EnumerationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					InterfaceInterfaceMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					InterfaceEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					InterfaceInterfaceMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					FieldEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					InterfaceInterfaceMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					MethodEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					InterfaceInterfaceMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					AnnotationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					InterfaceInterfaceMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					PackageDescriptorEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					InterfaceInterfaceMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ConstructorEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					InterfaceInterfaceMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BlockEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					ClassifierImportClassifiersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					StaticImportStaticMembersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case FieldEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			JavaNavigatorGroup incominglinks = new JavaNavigatorGroup(
					Messages.NavigatorGroupName_Field_3035_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view),
					StaticImportStaticMembersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case MethodEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			JavaNavigatorGroup incominglinks = new JavaNavigatorGroup(
					Messages.NavigatorGroupName_Method_3036_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view),
					StaticImportStaticMembersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case AnnotationEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			JavaNavigatorGroup incominglinks = new JavaNavigatorGroup(
					Messages.NavigatorGroupName_Annotation_3037_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					AnnotationAnnotationMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					AnnotationMethodEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					AnnotationAnnotationMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Class2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					AnnotationAnnotationMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					EnumerationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					AnnotationAnnotationMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					InterfaceEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					AnnotationAnnotationMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					FieldEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					AnnotationAnnotationMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					MethodEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					AnnotationAnnotationMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					AnnotationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					AnnotationAnnotationMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					PackageDescriptorEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					AnnotationAnnotationMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ConstructorEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					AnnotationAnnotationMembersCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BlockEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					ClassifierImportClassifiersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					StaticImportStaticMembersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case PackageDescriptorEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			JavaNavigatorGroup incominglinks = new JavaNavigatorGroup(
					Messages.NavigatorGroupName_PackageDescriptor_3038_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view),
					ClassifierImportClassifiersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					StaticImportStaticMembersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ConstructorEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			JavaNavigatorGroup incominglinks = new JavaNavigatorGroup(
					Messages.NavigatorGroupName_Constructor_3039_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view),
					StaticImportStaticMembersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case BlockEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			JavaNavigatorGroup incominglinks = new JavaNavigatorGroup(
					Messages.NavigatorGroupName_Block_3040_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view),
					StaticImportStaticMembersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case Enumeration2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			JavaNavigatorGroup incominglinks = new JavaNavigatorGroup(
					Messages.NavigatorGroupName_Enumeration_3041_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					EnumerationEnumerationMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					AnnotationMethodEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					EnumerationEnumerationMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Class2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					EnumerationEnumerationMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					EnumerationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					EnumerationEnumerationMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					InterfaceEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					EnumerationEnumerationMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					FieldEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					EnumerationEnumerationMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					MethodEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					EnumerationEnumerationMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					AnnotationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					EnumerationEnumerationMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					PackageDescriptorEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					EnumerationEnumerationMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ConstructorEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					EnumerationEnumerationMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BlockEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					ClassifierImportClassifiersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					StaticImportStaticMembersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case Interface2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			JavaNavigatorGroup incominglinks = new JavaNavigatorGroup(
					Messages.NavigatorGroupName_Interface_3042_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					InterfaceInterfaceMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					AnnotationMethodEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					InterfaceInterfaceMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Class2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					InterfaceInterfaceMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					EnumerationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					InterfaceInterfaceMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					InterfaceEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					InterfaceInterfaceMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					FieldEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					InterfaceInterfaceMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					MethodEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					InterfaceInterfaceMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					AnnotationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					InterfaceInterfaceMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					PackageDescriptorEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					InterfaceInterfaceMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ConstructorEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					InterfaceInterfaceMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BlockEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					ClassifierImportClassifiersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					StaticImportStaticMembersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case Annotation2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			JavaNavigatorGroup incominglinks = new JavaNavigatorGroup(
					Messages.NavigatorGroupName_Annotation_3043_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					AnnotationAnnotationMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					AnnotationMethodEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					AnnotationAnnotationMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Class2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					AnnotationAnnotationMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					EnumerationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					AnnotationAnnotationMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					InterfaceEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					AnnotationAnnotationMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					FieldEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					AnnotationAnnotationMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					MethodEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					AnnotationAnnotationMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					AnnotationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					AnnotationAnnotationMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					PackageDescriptorEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					AnnotationAnnotationMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ConstructorEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					AnnotationAnnotationMembersCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BlockEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					ClassifierImportClassifiersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					StaticImportStaticMembersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case PackageDescriptor2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			JavaNavigatorGroup incominglinks = new JavaNavigatorGroup(
					Messages.NavigatorGroupName_PackageDescriptor_3044_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view),
					ClassifierImportClassifiersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					StaticImportStaticMembersEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ClassifierImportEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			JavaNavigatorGroup outgoinglinks = new JavaNavigatorGroup(
					Messages.NavigatorGroupName_ClassifierImport_3045_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getOutgoingLinksByType(Collections
					.singleton(view),
					ClassifierImportClassifiersEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case StaticImportEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			JavaNavigatorGroup outgoinglinks = new JavaNavigatorGroup(
					Messages.NavigatorGroupName_StaticImport_3046_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getOutgoingLinksByType(Collections
					.singleton(view),
					StaticImportStaticMembersEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ClassifierImportClassifiersEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			JavaNavigatorGroup target = new JavaNavigatorGroup(
					Messages.NavigatorGroupName_ClassifierImportClassifiers_4003_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			JavaNavigatorGroup source = new JavaNavigatorGroup(
					Messages.NavigatorGroupName_ClassifierImportClassifiers_4003_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections
					.singleton(view), ClassEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Class2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					EnumerationEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					InterfaceEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					AnnotationEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					PackageDescriptorEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Enumeration2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Interface2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Annotation2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					PackageDescriptor2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					ClassifierImportEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case StaticImportStaticMembersEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			JavaNavigatorGroup target = new JavaNavigatorGroup(
					Messages.NavigatorGroupName_StaticImportStaticMembers_4004_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			JavaNavigatorGroup source = new JavaNavigatorGroup(
					Messages.NavigatorGroupName_StaticImportStaticMembers_4004_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections
					.singleton(view), ClassEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					AnnotationMethodEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Class2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					EnumerationEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					InterfaceEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					FieldEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					MethodEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					AnnotationEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					PackageDescriptorEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					ConstructorEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					BlockEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Enumeration2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Interface2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Annotation2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					PackageDescriptor2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					StaticImportEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Collection getLinksSourceByType(Collection edges, int visualID) {
		Collection result = new ArrayList();
		String type = JavaVisualIDRegistry.getType(visualID);
		for (Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType())
					&& isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getLinksTargetByType(Collection edges, int visualID) {
		Collection result = new ArrayList();
		String type = JavaVisualIDRegistry.getType(visualID);
		for (Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType())
					&& isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getOutgoingLinksByType(Collection nodes, int visualID) {
		Collection result = new ArrayList();
		String type = JavaVisualIDRegistry.getType(visualID);
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getIncomingLinksByType(Collection nodes, int visualID) {
		Collection result = new ArrayList();
		String type = JavaVisualIDRegistry.getType(visualID);
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getChildrenByType(Collection nodes, int visualID) {
		Collection result = new ArrayList();
		String type = JavaVisualIDRegistry.getType(visualID);
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getDiagramLinksByType(Collection diagrams, int visualID) {
		Collection result = new ArrayList();
		String type = JavaVisualIDRegistry.getType(visualID);
		for (Iterator it = diagrams.iterator(); it.hasNext();) {
			Diagram nextDiagram = (Diagram) it.next();
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection selectViewsByType(Collection views, String type) {
		Collection result = new ArrayList();
		for (Iterator it = views.iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return PackageEditPart.MODEL_ID.equals(JavaVisualIDRegistry
				.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection createNavigatorItems(Collection views, Object parent,
			boolean isLeafs) {
		Collection result = new ArrayList();
		for (Iterator it = views.iterator(); it.hasNext();) {
			result
					.add(new JavaNavigatorItem((View) it.next(), parent,
							isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getForeignShortcuts(Diagram diagram, Object parent) {
		Collection result = new ArrayList();
		for (Iterator it = diagram.getChildren().iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (!isOwnView(nextView)
					&& nextView.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				result.add(nextView);
			}
		}
		return createNavigatorItems(result, parent, false);
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof JavaAbstractNavigatorItem) {
			JavaAbstractNavigatorItem abstractNavigatorItem = (JavaAbstractNavigatorItem) element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean hasChildren(Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
	}

}
