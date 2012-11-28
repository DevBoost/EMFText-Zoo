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
package dk.itu.sdg.language.xwpf

import org.eclipse.core.resources.IFile
import org.eclipse.emf.ecore.EObject;

/**
 * @author jreimann
 *
 */
class ModelConvert extends AbstractConverter {

	@Override
	public void convert(DocX2Model converter, EObject modelDocument, IFile file) {
		converter.saveModel(modelDocument, file)
	}

}
