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
package de .tudresden .contact_management ;


class Contact {
	protected String name ;
	protected Address address ;
	protected java.util.LinkedList < Relationship > srcRelationships ;
	protected java.util.LinkedList < Relationship > targetRelationships ;
	protected Group group ;
}

