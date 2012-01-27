/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.mopp;

/**
 * The PlTaskItemBuilder is used to find task items in text documents. The current
 * implementation uses the generated lexer and the TaskItemDetector to detect task
 * items.
 */
public class PlTaskItemBuilder extends org.emftext.language.prolog.resource.pl.mopp.PlBuilderAdapter {
	
	/**
	 * The ID of the item task builder.
	 */
	public final static String BUILDER_ID = "org.emftext.language.prolog.resource.pl.taskItemBuilder";
	
	@Override	
	public void build(org.eclipse.core.resources.IFile resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		monitor.setTaskName("Searching for task items");
		new org.emftext.language.prolog.resource.pl.mopp.PlMarkerHelper().removeAllMarkers(resource, org.eclipse.core.resources.IMarker.TASK);
		if (isInBinFolder(resource)) {
			return;
		}
		java.util.List<org.emftext.language.prolog.resource.pl.mopp.PlTaskItem> taskItems = new java.util.ArrayList<org.emftext.language.prolog.resource.pl.mopp.PlTaskItem>();
		org.emftext.language.prolog.resource.pl.mopp.PlTaskItemDetector taskItemDetector = new org.emftext.language.prolog.resource.pl.mopp.PlTaskItemDetector();
		try {
			java.io.InputStream inputStream = resource.getContents();
			String content = org.emftext.language.prolog.resource.pl.util.PlStreamUtil.getContent(inputStream);
			org.emftext.language.prolog.resource.pl.IPlTextScanner lexer = new org.emftext.language.prolog.resource.pl.mopp.PlMetaInformation().createLexer();
			lexer.setText(content);
			
			org.emftext.language.prolog.resource.pl.IPlTextToken nextToken = lexer.getNextToken();
			while (nextToken != null) {
				String text = nextToken.getText();
				taskItems.addAll(taskItemDetector.findTaskItems(text, nextToken.getLine(), nextToken.getOffset()));
				nextToken = lexer.getNextToken();
			}
		} catch (java.io.IOException e) {
			org.emftext.language.prolog.resource.pl.mopp.PlPlugin.logError("Exception while searching for task items", e);
		} catch (org.eclipse.core.runtime.CoreException e) {
			org.emftext.language.prolog.resource.pl.mopp.PlPlugin.logError("Exception while searching for task items", e);
		}
		
		for (org.emftext.language.prolog.resource.pl.mopp.PlTaskItem taskItem : taskItems) {
			java.util.Map<String, Object> markerAttributes = new java.util.LinkedHashMap<String, Object>();
			markerAttributes.put(org.eclipse.core.resources.IMarker.USER_EDITABLE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.DONE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.LINE_NUMBER, taskItem.getLine());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_START, taskItem.getCharStart());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_END, taskItem.getCharEnd());
			markerAttributes.put(org.eclipse.core.resources.IMarker.MESSAGE, taskItem.getMessage());
			new org.emftext.language.prolog.resource.pl.mopp.PlMarkerHelper().createMarker(resource, org.eclipse.core.resources.IMarker.TASK, markerAttributes);
		}
	}
	
	public String getBuilderMarkerId() {
		return org.eclipse.core.resources.IMarker.TASK;
	}
	
	public boolean isInBinFolder(org.eclipse.core.resources.IFile resource) {
		org.eclipse.core.resources.IContainer parent = resource.getParent();
		while (parent != null) {
			if ("bin".equals(parent.getName())) {
				return true;
			}
			parent = parent.getParent();
		}
		return false;
	}
	
}
