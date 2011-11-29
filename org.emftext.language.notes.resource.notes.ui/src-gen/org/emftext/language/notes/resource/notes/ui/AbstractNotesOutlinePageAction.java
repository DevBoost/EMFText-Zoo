/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.ui;

public abstract class AbstractNotesOutlinePageAction extends org.eclipse.jface.action.Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private org.emftext.language.notes.resource.notes.ui.NotesOutlinePageTreeViewer treeViewer;
	
	public AbstractNotesOutlinePageAction(org.emftext.language.notes.resource.notes.ui.NotesOutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		org.eclipse.jface.resource.ImageDescriptor descriptor = org.emftext.language.notes.resource.notes.ui.NotesImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = org.emftext.language.notes.resource.notes.ui.NotesUIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
		valueChanged(checked, false);
	}
	
	@Override	
	public void run() {
		if (keepState()) {
			valueChanged(isChecked(), true);
		} else {
			runBusy(true);
		}
	}
	
	public void runBusy(final boolean on) {
		org.eclipse.swt.custom.BusyIndicator.showWhile(org.eclipse.swt.widgets.Display.getCurrent(), new Runnable() {
			public void run() {
				runInternal(on);
			}
		});
	}
	
	public abstract void runInternal(boolean on);
	
	private void valueChanged(boolean on, boolean store) {
		setChecked(on);
		runBusy(on);
		if (store) {
			org.emftext.language.notes.resource.notes.ui.NotesUIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public org.emftext.language.notes.resource.notes.ui.NotesOutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public org.emftext.language.notes.resource.notes.ui.NotesOutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (org.emftext.language.notes.resource.notes.ui.NotesOutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}
