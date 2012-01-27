/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.ui;

public abstract class AbstractPlOutlinePageAction extends org.eclipse.jface.action.Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private org.emftext.language.prolog.resource.pl.ui.PlOutlinePageTreeViewer treeViewer;
	
	public AbstractPlOutlinePageAction(org.emftext.language.prolog.resource.pl.ui.PlOutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		org.eclipse.jface.resource.ImageDescriptor descriptor = org.emftext.language.prolog.resource.pl.ui.PlImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = org.emftext.language.prolog.resource.pl.ui.PlUIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
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
			org.emftext.language.prolog.resource.pl.ui.PlUIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public org.emftext.language.prolog.resource.pl.ui.PlOutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public org.emftext.language.prolog.resource.pl.ui.PlOutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (org.emftext.language.prolog.resource.pl.ui.PlOutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}
