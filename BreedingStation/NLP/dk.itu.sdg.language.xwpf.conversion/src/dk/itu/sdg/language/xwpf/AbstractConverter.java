/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package dk.itu.sdg.language.xwpf;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @author jreimann
 *
 */
public abstract class AbstractConverter extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);

		if (selection.size() == 1) {
			Object[]  selections = selection.toArray();
					Object fstSelection = selections[0];

							if (fstSelection instanceof IFile) {
								final IFile file = (IFile) fstSelection;

								Job convertToModelJob = new Job("Converting Word File...") {

									@Override
									protected IStatus run(IProgressMonitor monitor) {

										try {
											DocX2Model converter = new DocX2Model(file);
											EObject modelDocument = converter.transform();
											//							converter.saveModel(modelDocument)
											convert(converter, modelDocument, file);

											//							def Model2DocX backConverter = new Model2DocX(modelDocument)
											//							def docxDocument = backConverter.transform()
											//							backConverter.saveDocX(docxDocument)

											return Status.OK_STATUS;
										} catch (Exception e) {
											e.printStackTrace();
											return Status.CANCEL_STATUS;
										}
									}
								};

								convertToModelJob.schedule();
							}
		}

		return null;
	}

	public abstract void convert(DocX2Model converter, EObject modelDocument, IFile file);
}
