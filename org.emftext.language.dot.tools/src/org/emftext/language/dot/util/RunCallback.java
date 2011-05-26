/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.dot.util;

import java.io.IOException;

/**
 * A simple interface providing three callback methods - used to
 * handle the execution result of an external process.
 */
public interface RunCallback {

    /**
     * Called upon normal exit of the process.
     *
     * @param exitCode the exit code of the process
     */
    public void exit(int exitCode);

    /**
     * Called whenever the process was interrupted.
     *
     * @param ie the exception thrown
     */
    public void interrupted(InterruptedException ie);

    /**
     * Called whenever an I/O error occurs.
     *
     * @param ioe the exception that was thrown
     */
    public void ioError(IOException ioe);

    public void result(Pair<String, String> pair);
}
