package org.emftext.language.valueflow.diagram.part;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.emftext.language.valueflow.diagram.edit.commands.ValueflowCreateShortcutDecorationsCommand;
import org.emftext.language.valueflow.diagram.edit.parts.ModelEditPart;

/**
 * @generated
 */
public class ValueflowCreateShortcutAction implements IObjectActionDelegate {

	/**
	 * @generated
	 */
	private ModelEditPart mySelectedElement;

	/**
	 * @generated
	 */
	private Shell myShell;

	/**
	 * @generated
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		myShell = targetPart.getSite().getShell();
	}

	/**
	 * @generated
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		mySelectedElement = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size() == 1
					&& structuredSelection.getFirstElement() instanceof ModelEditPart) {
				mySelectedElement = (ModelEditPart) structuredSelection
						.getFirstElement();
			}
		}
		action.setEnabled(isEnabled());
	}

	/**
	 * @generated
	 */
	private boolean isEnabled() {
		return mySelectedElement != null;
	}

	/**
	 * @generated
	 */
	public void run(IAction action) {
		final View view = (View) mySelectedElement.getModel();
		ValueflowElementChooserDialog elementChooser = new ValueflowElementChooserDialog(
				myShell, view);
		int result = elementChooser.open();
		if (result != Window.OK) {
			return;
		}
		URI selectedModelElementURI = elementChooser
				.getSelectedModelElementURI();
		final EObject selectedElement;
		try {
			selectedElement = mySelectedElement.getEditingDomain()
					.getResourceSet().getEObject(selectedModelElementURI, true);
		} catch (WrappedException e) {
			ValueflowDiagramEditorPlugin
					.getInstance()
					.logError(
							"Exception while loading object: " + selectedModelElementURI.toString(), e); //$NON-NLS-1$
			return;
		}

		if (selectedElement == null) {
			return;
		}
		CreateViewRequest.ViewDescriptor viewDescriptor = new CreateViewRequest.ViewDescriptor(
				new EObjectAdapter(selectedElement), Node.class, null,
				ValueflowDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
		ICommand command = new CreateCommand(mySelectedElement
				.getEditingDomain(), viewDescriptor, view);
		command = command
				.compose(new ValueflowCreateShortcutDecorationsCommand(
						mySelectedElement.getEditingDomain(), view,
						viewDescriptor));
		try {
			OperationHistoryFactory.getOperationHistory().execute(command,
					new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			ValueflowDiagramEditorPlugin.getInstance().logError(
					"Unable to create shortcut", e); //$NON-NLS-1$
		}
	}

}
