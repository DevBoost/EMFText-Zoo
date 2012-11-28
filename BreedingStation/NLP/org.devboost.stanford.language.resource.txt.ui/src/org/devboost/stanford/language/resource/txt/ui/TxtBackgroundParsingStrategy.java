/**
 * Copyright (C) 2012
 * Jan Reimann (TU Dresden, Software Technology Group)
 * Mirko Seifert (DevBoost GmbH)
 * Rolf-Helge Pfeiffer (IT University Copenhagen)
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/
package org.devboost.stanford.language.resource.txt.ui;

/**
 * A background parsing strategy that starts parsing after a amount of time after
 * the last key stroke. If keys are pressed within the delay interval, the delay
 * is reset. If keys are pressed during background parsing the parse thread is
 * stopped and a new parse task is scheduled.
 */
public class TxtBackgroundParsingStrategy {
	
	private static long DELAY = 500;
	
	/**
	 * this timer is used to schedule a parsing task and execute it after a given delay
	 */
	private Object lock = new Object();
	
	/**
	 * the background parsing task (may be null)
	 */
	private ParsingJob job = null;
	
	/**
	 * Schedules a task for background parsing that will be started after a delay.
	 */
	public void parse(org.eclipse.jface.text.DocumentEvent event, final org.devboost.stanford.language.resource.txt.ITxtTextResource resource, final org.devboost.stanford.language.resource.txt.ui.TxtEditor editor) {
		parse(event.getDocument(), resource, editor, DELAY);
	}
	
	/**
	 * Schedules a task for background parsing that will be started after a delay.
	 */
	public void parse(org.eclipse.jface.text.IDocument document, final org.devboost.stanford.language.resource.txt.ITxtTextResource resource, final org.devboost.stanford.language.resource.txt.ui.TxtEditor editor, long delay) {
		parse(document.get(), resource, editor, delay);
	}
	
	/**
	 * Schedules a task for background parsing that will be started after a delay.
	 */
	public void parse(final String contents, final org.devboost.stanford.language.resource.txt.ITxtTextResource resource, final org.devboost.stanford.language.resource.txt.ui.TxtEditor editor, long delay) {
//		if (resource == null) {
			return;
//		}
//		if (contents == null) {
//			return;
//		}
//		
//		// this synchronization is needed to avoid the creation of multiple tasks. without
//		// the synchronization this could easily happen, when this method is accessed by
//		// multiple threads. the creation of multiple tasks would imply that multiple
//		// background parsing threads for one editor are created, which is not desired.
//		synchronized (lock) {
//			if (job == null || job.getState() != org.eclipse.core.runtime.jobs.Job.RUNNING) {
//				// schedule new task
//				job = new ParsingJob();
//				job.resource = resource;
//				job.editor = editor;
//				job.newContents = contents;
//				job.schedule();
//			} else {
//				job.newContents = contents;
//			}
//		}
	}
	
	private class ParsingJob extends org.eclipse.core.runtime.jobs.Job {
		private org.devboost.stanford.language.resource.txt.ui.TxtEditor editor;
		private org.devboost.stanford.language.resource.txt.ITxtTextResource resource;
		
		public ParsingJob() {
			super("parsing document");
		}
		
		private String newContents = null;
		
		protected org.eclipse.core.runtime.IStatus run(org.eclipse.core.runtime.IProgressMonitor monitor) {
			while (newContents != null ) {
				while (newContents != null) {
					try {
						String currentContent = newContents;
						newContents = null;
						String encoding = null;
						if (resource instanceof org.devboost.stanford.language.resource.txt.mopp.TxtResource) {
							org.devboost.stanford.language.resource.txt.mopp.TxtResource concreteResource = (org.devboost.stanford.language.resource.txt.mopp.TxtResource) resource;
							encoding = concreteResource.getEncoding(null);
						}
						byte[] bytes = null;
						if (encoding != null) {
							bytes = currentContent.getBytes(encoding);
						} else {
							bytes = currentContent.getBytes();
						}
						resource.reload(new java.io.ByteArrayInputStream(bytes), null);
						if (newContents != null) {
							Thread.sleep(DELAY);
						}
					} catch (java.lang.Exception e) {
						e.printStackTrace();
					}
				}
				editor.notifyBackgroundParsingFinished();
			}
			return org.eclipse.core.runtime.Status.OK_STATUS;
		}
	};
	
}
